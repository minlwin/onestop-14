package co.jdc.shp.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import lombok.Data;

@Data
public class Invoice implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final DateTimeFormatter DF = DateTimeFormatter
			.ofPattern("yyyy-MM-dd HH:mm");

	private int id;
	private LocalDateTime invoiceAt;
	private Account account;
	private List<CartItem> items;
	
	public String getInvoiceDateTime() {
		return DF.format(invoiceAt);
	}
	
	public String getInvoiceId() {
		return "INV-%06d".formatted(id);
	}
	
	public int getTotalAmount() {
		return items.stream().mapToInt(a -> a.getTotal()).sum();
	}
	
	public int getTotalCount() {
		return items.stream().mapToInt(a -> a.getQuantity()).sum();
	}
}
