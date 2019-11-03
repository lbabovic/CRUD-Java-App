package domainLayer;

import java.util.ArrayList;

import dataLayer.Response;

public interface SearchUseCase {
	Response<ArrayList<Product>> searchProducts(String input, String inputCategory,double minPrice, double maxPrice, String isDeleted, int minAmount, int maxAmount);
}
