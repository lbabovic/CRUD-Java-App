package dataLayer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.rmi.CORBA.StubDelegate;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import domainLayer.Product;

public class DatabaseService {
	private String path;
	private String user;
	private String password;
	private Connection conn;
	private ArrayList<Product> cachedProducts = new ArrayList<Product>();
	
	public DatabaseService(String path, String user, String password) {
		super();
		this.path = path;
		this.user = user;
		this.password = password;
	}
	
	private boolean openConnection(){
		try {
			conn = DriverManager.getConnection(path,user,password);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			return false;
		}
	}
	
	private void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	public ArrayList<Product> getCachedProducts() {
		return cachedProducts;
	}
	
	private void refreshCachedProducts() {
		String qry = "SELECT * FROM product";
		executeCustomQuery(qry);
	}
	
	private Response<ArrayList<Product>> executeCustomQuery(String qry) {
		if(openConnection()){
			ArrayList<Product> products = new ArrayList<>();
			try {
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(qry);
				while(rs.next()){
					String name = rs.getString("name");
					String description = rs.getString("description");
					boolean deleted = rs.getBoolean("isDeleted");
					double price = rs.getDouble("price");
					int amount = rs.getInt("amount");
					String category = rs.getString("category");
					
					Product p = new Product(name, description, deleted, price, amount, category);
					
					products.add(p);
				}
				cachedProducts = products;
				closeConnection();
				return new Response<ArrayList<Product>>(true, products, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				closeConnection();
				return new Response<ArrayList<Product>>(false, null, "Error in executing query!");
			}
		}
		return new Response<ArrayList<Product>>(false, null, "Error when opening connection!");	
	}
	
	private Response<Boolean> executeSimpleQuery(String qry) {
		if(openConnection()){
			try {
				Statement s = conn.createStatement();
				s.executeUpdate(qry);
				refreshCachedProducts();
				return new Response<Boolean>(true, true, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
				return new Response<Boolean>(false, null, "Error in executing query!");
			}
		}
		return new Response<Boolean>(false, null, "Error when opening connection!");
	}
	
	public Response<ArrayList<Product>> getAllProducts(){
		String qry = "SELECT * FROM product";
		return executeCustomQuery(qry);
	}
	
	public Response<ArrayList<Product>> searchProducts(String input, String inputCategory,double minPrice, double maxPrice, String isDeleted, int minAmount, int maxAmount){
		String qry = "SELECT * FROM product WHERE name LIKE '" + input + "%'";
		qry += !inputCategory.equalsIgnoreCase("") ? " AND category = '" + inputCategory + "'" : " AND category != '' "; 
		if(minPrice != 0 && maxPrice == 0){ qry += " AND price >= " + minPrice;}
		if(minPrice == 0 && maxPrice != 0){	qry += " AND price <= " + maxPrice;}
		if(minPrice != 0 && maxPrice != 0){ qry += " AND price >= " + minPrice + " AND price <= " + maxPrice;}
		if(!isDeleted.equalsIgnoreCase("Select")){ qry += isDeleted.equalsIgnoreCase("Available") ? " AND isDeleted = 0" : " AND isDeleted = 1";}
		if(minAmount != 0 && maxAmount == 0){qry += " AND amount >= " + minAmount;}
		if(minAmount == 0 && maxAmount != 0){qry += " AND amount <= " + maxAmount;}
		if(minAmount != 0 && maxAmount != 0){qry += " AND amount >= " + minAmount + " AND amount <= " + maxAmount;}
		return executeCustomQuery(qry);
	}
	
	public Response<ArrayList<Product>> getDetailsForEdit(String productName){
		String qry = "SELECT * FROM product WHERE name = '" + productName + "'";
		return executeCustomQuery(qry);
	}
	
	public Response<Boolean> deleteProduct(String productName){
		String qry = "DELETE FROM product WHERE name = '" + productName + "'";
		return executeSimpleQuery(qry);
	}
	
	public Response<Boolean> updateProduct(String name, String desc, double price, int amount,int isDeleted,String category, String ogName){
		String qry = "UPDATE product SET name = '" + name + "', description = '" + desc + "', price = " 
						+ price + ", amount = " + amount + ", isDeleted = " + isDeleted + ", category = '" + category + "' WHERE name = '" + ogName + "'";
		return executeSimpleQuery(qry);
	}
	
	public Response<Boolean> addProduct(String name, String desc, double price, int amount,int isDeleted,String category){
		if (cachedProducts.size() == 0) { getAllProducts(); }
		System.out.println(cachedProducts.size());
		if (cachedProducts.stream().filter(product -> product.getName().equalsIgnoreCase(name)).count()>0) {
			return new Response<Boolean>(false, null, "Product already exists!");
		};
		String qry = "INSERT INTO product (name,description,isDeleted,amount,price,category) "
						+ "VALUES ('" + name + "','" + desc + "', " + isDeleted + "," + amount + ", " + price + ", '" + category + "')";
		return executeSimpleQuery(qry);
	}
	
	public Response<Boolean> logIn(String username, String password) {
		String qry = "SELECT * FROM `user` WHERE username = '" + username + "' AND password = '" + password + "'";
		if(openConnection()){
			ArrayList<Product> products = new ArrayList<>();
			try {
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(qry);
				Response<Boolean> response = rs.next() ? new Response<Boolean>(true, true, null) : new Response<Boolean>(false, null, "Wrong username or password!");
				closeConnection();
				return response;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				closeConnection();
				return new Response<Boolean>(false, null, "Error in executing query!");
			}
		}
		return new Response<Boolean>(false, null, "Error when opening connection!");
	}
}