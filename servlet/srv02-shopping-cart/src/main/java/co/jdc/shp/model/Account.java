package co.jdc.shp.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;

	public static final String KEY = "loginUser";
	
	private String name;
	private String email;
	private String password;

}
