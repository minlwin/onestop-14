package co.jdc.shp.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceManager implements Serializable{

	private static final long serialVersionUID = 1L;
	public static final String KEY = "InvoiceManager";
	
	private int id;
	private Map<Integer, Invoice> idMap = Collections.synchronizedMap(new HashMap<>());
	private Map<String, List<Invoice>> accountMap = Collections.synchronizedMap(new HashMap<>());

	public Invoice create(Account account, List<CartItem> items) {
		
		var invoice = new Invoice();
		invoice.setId(++ id);
		invoice.setInvoiceAt(LocalDateTime.now());
		invoice.setAccount(account);
		invoice.setItems(items);
		
		idMap.put(invoice.getId(), invoice);
		
		var list = accountMap.get(account.getEmail());
		
		if(null == list) {
			list = new ArrayList<>();
			accountMap.put(account.getEmail(), list);
		}
		
		list.add(invoice);
		
		return invoice;
	}
	
	public Invoice findById(int id) {
		return idMap.get(id);
	}
	
	public List<Invoice> findByAccount(String email) {
		return accountMap.get(email);
	}
}
