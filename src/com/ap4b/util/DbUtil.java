package com.ap4b.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * c'est l'outil pour connecter la base de donnée
 * @author 18019
 *
 */

public class DbUtil {

	private String dbUrl = "jdbc:mysql://localhost:3306/materiel_ecole";//addresse pour mysql connection
	private String dbUsername="root";
	private String dbPassword="0423";
	private String jdbcName="com.mysql.cj.jdbc.Driver";//driver
	
	/*
	 * mettre en oeuvre database connexion
	 */
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
		return con;
	}
	
	/*
	 * fermer database connection
	 */
	public void closeCon(Connection con)throws Exception{
		if(con!=null) {
			con.close();
		}
	}
	
	/*
	 * c'est seulement pour tester la connexion marche ou pas
	 */
	public static void main(String[] args){//ctrl + 1
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("Connexion de database avec succï¿½s");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connection de database ï¿½choue");
		}
	}
	
}
