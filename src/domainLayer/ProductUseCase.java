package domainLayer;

import java.util.ArrayList;

import dataLayer.Response;

public interface ProductUseCase {
	Response<ArrayList<Product>> fetchProducts();
}
