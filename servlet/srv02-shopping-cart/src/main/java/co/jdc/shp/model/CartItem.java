package co.jdc.shp.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class CartItem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int productId;
	private String name;
	private int price;
	private int quantity;
	
	public CartItem(Product p) {
		this.productId = p.getId();
		this.name = p.getName();
		this.price = p.getPrice();
	}
	
	public int getTotal() {
		return price * quantity;
	}
}
