package com.ap4b.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ap4b.model.User;



/**
 * c'est pour la fonction login
 * @author 18019
 *
 */
public class UserDao {
	/*
	 * verifier le login est légal ou pas
	 */	

	public User login(Connection con, User user) throws Exception{
		User resultUser = null;
		String strSql = "select * from t_user where nom=? and code=? and mode=?";//pour plus de sécurité
		PreparedStatement pstmt = con.prepareStatement(strSql);
		pstmt.setString(1, user.getNom());
		pstmt.setString(2, user.getCode());
		pstmt.setString(3, user.getMode());
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			resultUser = new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setNom(rs.getString("nom"));
			resultUser.setCode(rs.getString("code"));
			resultUser.setMode(rs.getString("mode"));
		}
	
		return resultUser;
	}
		
		

}
