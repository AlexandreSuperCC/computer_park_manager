package com.ap4b.model;

/**
 * objet de user
 * @author 18019
 *
 */

public class User {

	private int id;
	private String nom;
	private String code;
	private String mode;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String nom, String code, String mode) {
		super();
		this.nom = nom;
		this.code = code;
		this.mode = mode;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMode() {
		return mode;
	}
	
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/*
	 * pour afficher directement le mode dans la fonction login
	 */
	@Override
	public String toString() {
		return mode;
	}

}
