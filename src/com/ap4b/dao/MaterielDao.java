package com.ap4b.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ap4b.model.Materiel;
import com.ap4b.util.StringUtil;

public class MaterielDao {

	/*
	 * afficher tous les matériels disponibles ou pas disponibles
	 */
	public static ResultSet list(Connection con, Materiel materiel) throws Exception{
		
		String strSql = "select * from t_materiel where disponible = ? order by id";
		PreparedStatement pstmt = con.prepareStatement(strSql);
		pstmt.setString(1, materiel.getDisponible());
		
		return pstmt.executeQuery();
	}
	
	/*
	 * afficher tous les matériels
	 */
	public static ResultSet listAll(Connection con) throws Exception{
		
		String strSql = "select * from t_materiel order by id";
		PreparedStatement pstmt = con.prepareStatement(strSql);
		
		return pstmt.executeQuery();
	}
	/*
	 * modifier les états ou les caractéristiques de matériels
	 */
	public static int update(Connection con, Materiel materiel) throws Exception{
		String strSql = "update t_materiel set etat=?,duree=?, disponible=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(strSql);
		
		pstmt.setString(1, materiel.getEtat());
		pstmt.setString(2, materiel.getDuree());
		pstmt.setString(3, materiel.getDisponible());
		pstmt.setInt(4, materiel.getId());
		
		return pstmt.executeUpdate();
	}
	
	/*
	 * supprimer les matériels sélectionnés
	 */
	public static int delete(Connection con, Materiel materiel) throws Exception{
		String strSql = "delete from t_materiel where id=?";
		PreparedStatement pstmt = con.prepareStatement(strSql);
		
		pstmt.setInt(1, materiel.getId());
		return pstmt.executeUpdate();
	}
	
	/*
	 * ajouter les matériels sélectionnés
	 */
	public static int add(Connection con, Materiel materiel) throws Exception{
		String strSql = "insert into t_materiel values(?,?,?,?,?)";
		
		PreparedStatement pstmt = con.prepareStatement(strSql);
		pstmt.setInt(1, materiel.getId());
		pstmt.setString(2, materiel.getSorte());
		pstmt.setString(3, materiel.getEtat());
		pstmt.setString(4, materiel.getDuree());
		pstmt.setString(5, materiel.getDisponible());
		
		return pstmt.executeUpdate();
	}
}
