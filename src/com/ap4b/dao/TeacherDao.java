package com.ap4b.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ap4b.model.Teacher;
import com.ap4b.util.StringUtil;

public class TeacherDao {
	public int add(Connection con, Teacher teacher)throws Exception{
		String sql="insert into t_user values(?,?,?,?)";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setInt(1, teacher.getId());
		pstmt.setString(2, teacher.getUsername());
		pstmt.setString(3, teacher.getPassword());
		pstmt.setString(4, teacher.getMode());
		return pstmt.executeUpdate();
	}
	public int delete(Connection con, int id)throws Exception{
		String sql="delete from t_user where id=?";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setInt(1, id);
		return pstmt.executeUpdate();
		
	}
	public ResultSet list(Connection con,Teacher teacher)throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_user where mode = 'enseignant'");
		if(StringUtil.isNotEmpty(teacher.getUsername())){
			sb.append(" and username like '%"+teacher.getUsername()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}

}
