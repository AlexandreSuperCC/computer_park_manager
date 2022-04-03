package com.ap4b.model;
/**
 * objet de metériel
 * @author 18019
 *
 */
public class Materiel {


	private int id;
	private String sorte;
	private String etat;
	private String duree;
	private String disponible;
	
	public Materiel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Materiel(int id, String etat, String duree, String disponible) {
		super();
		this.id = id;
		this.etat = etat;
		this.duree = duree;
		this.disponible = disponible;
	}
	
	public Materiel(int id, String sorte, String etat, String duree, String disponible) {
		super();
		this.id = id;
		this.sorte = sorte;
		this.etat = etat;
		this.duree = duree;
		this.disponible = disponible;
	}

	public Materiel(String disponible) {
		super();
		this.disponible = disponible;
	}

	public Materiel(int id, String etat, String duree) {
		super();
		this.id = id;
		this.etat = etat;
		this.duree = duree;
	}

	public Materiel(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSorte() {
		return sorte;
	}

	public void setSorte(String sorte) {
		this.sorte = sorte;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public String getDisponible() {
		return disponible;
	}

	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}
	
	
	
}
