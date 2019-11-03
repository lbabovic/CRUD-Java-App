package domainLayer;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;

import dataLayer.Response;

public class ProductInteractor implements ProductUseCase, SearchUseCase, EditUseCase, FileWriterUseCase {
	ProductProviderInterface provider;
	FileCreatorProviderInterface fileProvider;
	
	public ProductInteractor(ProductProviderInterface provider, FileCreatorProviderInterface fileProvider) {
		this.provider = provider;
		this.fileProvider = fileProvider;
	}
	
	public Response<ArrayList<Product>> searchProducts(String input, String inputCategory, double minPrice, double maxPrice,
			String isDeleted, int minAmount, int maxAmount) {
		return provider.searchProducts(input, inputCategory, minPrice, maxPrice, isDeleted, minAmount, maxAmount);
	}

	public Response<ArrayList<Product>> fetchProducts() {
		// TODO Auto-generated method stub
		return provider.fetchProducts();
	}
	
	public Response<ArrayList<Product>> editProduct(String name) {
		// TODO Auto-generated method stub
		return provider.editProduct(name);
	}

	@Override
	public Response<Boolean> deleteProduct(String productName) {
		// TODO Auto-generated method stub
		return provider.deleteProduct(productName);
	}

	@Override
	public String createXML(JButton open) {
		// TODO Auto-generated method stub
		return fileProvider.createXML(provider.getCachedProducts(), open);
	}

	@Override
	public String validate(String xml) {
		// TODO Auto-generated method stub
		return fileProvider.validate(xml);
	}

	@Override
	public boolean createJSON(JButton open) {
		// TODO Auto-generated method stub
		return fileProvider.createJSON(provider.getCachedProducts(), open);
	}

	@Override
	public boolean createPDF(JButton open) {
		// TODO Auto-generated method stub
		return fileProvider.createPDF(provider.getCachedProducts(), open);
	}

	@Override
	public Response<Boolean> updateProduct(String name, String desc, double price, int amount, int isDeleted,
			String category, String ogName) {
		// TODO Auto-generated method stub
		return provider.updateProduct(name, desc, price, amount, isDeleted, category, ogName);
	}

	@Override
	public Response<Boolean> addProduct(String name, String desc, double price, int amount,int isDeleted,String category) {
		// TODO Auto-generated method stub
		return provider.addProduct(name, desc, price, amount, isDeleted, category);
	}
}
