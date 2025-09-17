package co.jdc.shp.model;

import lombok.Data;

@Data
public class Product {

	private int id;
	private String name;
	private String category;
	private int price;
	
	public Product(String [] array) {
		id = Integer.parseInt(array[0]);
		name = array[1];
		category = array[2];
		price = Integer.parseInt(array[3]);
	}
}
