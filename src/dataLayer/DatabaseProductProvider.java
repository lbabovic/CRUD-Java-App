package dataLayer;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import domainLayer.Product;
import domainLayer.ProductProviderInterface;

public class DatabaseProductProvider implements ProductProviderInterface {
	DatabaseService databaseService;
	
	public DatabaseProductProvider(DatabaseService databaseService) {
		this.databaseService = databaseService;
	}

	@Override
	public Response<ArrayList<Product>> fetchProducts() {
		// TODO Auto-generated method stub
		return databaseService.getAllProducts();
	}

	@Override
	public Response<ArrayList<Product>> searchProducts(String input, String inputCategory, double minPrice,
			double maxPrice, String isDeleted, int minAmount, int maxAmount) {
		// TODO Auto-generated method stub
		return databaseService.searchProducts(input, inputCategory, minPrice, maxPrice, isDeleted, minAmount, maxAmount);
	}

	@Override
	public Response<ArrayList<Product>> editProduct(String name) {
		// TODO Auto-generated method stub
		return databaseService.getDetailsForEdit(name);
	}

	@Override
	public Response<Boolean> deleteProduct(String productName) {
		// TODO Auto-generated method stub
		return databaseService.deleteProduct(productName);
	}

	@Override
	public ArrayList<Product> getCachedProducts() {
		// TODO Auto-generated method stub
		return databaseService.getCachedProducts();
	}

	@Override
	public Response<Boolean> updateProduct(String name, String desc, double price, int amount, int isDeleted,
			String category, String ogName) {
		// TODO Auto-generated method stub
		return databaseService.updateProduct(name, desc, price, amount, isDeleted, category, ogName);
	}

	@Override
	public Response<Boolean> addProduct(String name, String desc, double price, int amount,int isDeleted,String category) {
		// TODO Auto-generated method stub
		return databaseService.addProduct(name, desc, price, amount, isDeleted, category);
	}
}
