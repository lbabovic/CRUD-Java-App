package guiLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dataLayer.Response;
import domainLayer.Product;

public class MainFrameDataSource {
	private GUIDependencies dependencies;
	
	public MainFrameDataSource(GUIDependencies dependencies) {
		super();
		this.dependencies = dependencies;
	}
	
	public GUIDependencies getDependencies() {
		return dependencies;
	}
	
	public Response<Boolean> deleteProduct(String name) {
		return dependencies.editUseCase.deleteProduct(name);
	}
	
	public Response<Product> getProductForEdit(String name) {
		Response<ArrayList<Product>> resultProducts = dependencies.editUseCase.editProduct(name);
		switch (resultProducts.getResponseType()) {
		case success:
			return new Response<Product>(true,resultProducts.getResponse().get(0),null);
		case error:
			return new Response<Product>(false,null,resultProducts.getErrorDescription());
		}
		return new Response<Product>(false,null,resultProducts.getErrorDescription());
	}
	
	public Response<Object[][]> getAllProducts(){
		Response<ArrayList<Product>> productsResponse = dependencies.productUseCase.fetchProducts();
		switch (productsResponse.getResponseType()) {
		case success:
			Object[][] objects = new Object[productsResponse.getResponse().size()][6];
			int i = 0;
			for (Product p: productsResponse.getResponse()) {
				Object[] o = {p.getName(), p.getDescription(),p.getPrice(),p.getAmount(),p.getCategory(),p.isDeleted()};
				objects[i] = o;
				i++;
			}
			return new Response<Object[][]>(true, objects, null);
		case error:
			return new Response<Object[][]>(false, null, productsResponse.getErrorDescription());
		}
		return new Response<Object[][]>(false, null, productsResponse.getErrorDescription());
	}
	
	public Response<Object[][]> filteredProductsForTable(String input,String inputCategory,double minPrice, double maxPrice, String isDeleted, int minAmount, int maxAmount){
		Response<ArrayList<Product>> productsResponse = dependencies.searchUseCase.searchProducts(input, inputCategory, minPrice, maxPrice, isDeleted, minAmount, maxAmount);
		switch (productsResponse.getResponseType()) {
		case success:
			Object[][] objects = new Object[productsResponse.getResponse().size()][6];
			int i = 0;
			for (Product p: productsResponse.getResponse()) {
				Object[] o = {p.getName(), p.getDescription(),p.getPrice(),p.getAmount(),p.getCategory(),p.isDeleted()};
				objects[i] = o;
				i++;
			}
			return new Response<Object[][]>(true, objects, null);
		case error:
			return new Response<Object[][]>(false, null, productsResponse.getErrorDescription());
		}
		return new Response<Object[][]>(false, null, productsResponse.getErrorDescription());
	}
}
