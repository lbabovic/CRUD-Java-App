package domainLayer;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dataLayer.Response;

public interface EditUseCase {
	Response<ArrayList<Product>> editProduct(String name);
	Response<Boolean> deleteProduct(String productName);
	Response<Boolean> updateProduct(String name, String desc, double price, int amount,int isDeleted,String category, String ogName);
	public Response<Boolean> addProduct(String name, String desc, double price, int amount,int isDeleted,String category);
	}
