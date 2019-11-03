package domainLayer;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dataLayer.Response;

public interface ProductProviderInterface {
	Response<ArrayList<Product>> fetchProducts();
	Response<ArrayList<Product>> searchProducts(String input, String inputCategory,double minPrice, double maxPrice, String isDeleted, int minAmount, int maxAmount);
	Response<ArrayList<Product>> editProduct(String name);
	Response<Boolean> updateProduct(String name, String desc, double price, int amount,int isDeleted,String category, String ogName);
	Response<Boolean> deleteProduct(String productName);
	Response<Boolean> addProduct(String name, String desc, double price, int amount,int isDeleted,String category);
	ArrayList<Product> getCachedProducts();
}
