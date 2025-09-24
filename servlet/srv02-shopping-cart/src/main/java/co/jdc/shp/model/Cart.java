package co.jdc.shp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart implements Serializable{

	private static final long serialVersionUID = 1L;

	public static final String KEY = "cart";
	
	private Map<Integer, CartItem> items = new LinkedHashMap<>();

	public void addToCart(Product prod) {
		var item = items.get(prod.getId());
		
		if(null == item) {
			item = new CartItem(prod);
			items.put(prod.getId(), item);
		}
		
		item.setQuantity(item.getQuantity() + 1);
	}
	
	public void removeOne(int productId) {
		var item = items.get(productId);
		
		if(null != item) {
			item.setQuantity(item.getQuantity() - 1);
			
			if(item.getQuantity() == 0) {
				items.remove(productId);
			}
		}
	}
	
	public List<CartItem> getItems() {
		return new ArrayList<>(items.values());
	}
	
	public void clear() {
		items.clear();
	}
	
	public int getTotalItems() {
		return items.values().stream()
				.mapToInt(a -> a.getQuantity()).sum();
	}
	
	public int getTotalAmount() {
		return items.values().stream()
				.mapToInt(a -> a.getTotal()).sum();
	}
}
