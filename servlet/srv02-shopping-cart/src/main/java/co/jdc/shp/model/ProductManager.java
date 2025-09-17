package co.jdc.shp.model;

import java.util.List;
import java.util.Map;

public class ProductManager {
	
	public static final String KEY = "ProductManager";
	
	private Map<Integer, Product> products;

	public ProductManager(Map<Integer, Product> products) {
		this.products = products;
	}

	public List<Product> search(String keyword) {
		return products.values().stream()
				.filter(product -> null == keyword || 
							product.getName().toLowerCase().startsWith(keyword.toLowerCase()) ||
							product.getCategory().toLowerCase().startsWith(keyword.toLowerCase()))
				.toList();
	}
	
	public Product findById(int id) {
		return products.get(id);
	}
}
