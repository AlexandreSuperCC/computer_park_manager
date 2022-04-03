package com.ap4b.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.ap4b.dao.TeacherDao;
import com.ap4b.model.Teacher;
import com.ap4b.util.DbUtil;
import com.ap4b.util.StringUtil;



public class TeacherAddInterFrm extends JInternalFrame {
	private JTextField IdTxt;
	private JTextField nameTxt;
	private JTextField passwordTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private TeacherDao teacherDao=new TeacherDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherAddInterFrm frame = new TeacherAddInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TeacherAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("add teacher");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("teacher ID");
		lblNewLabel.setBounds(41, 51, 113, 18);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("teacher name");
		lblNewLabel_1.setBounds(41, 102, 113, 18);
		getContentPane().add(lblNewLabel_1);
		
		IdTxt = new JTextField();
		IdTxt.setBounds(231, 48, 86, 24);
		getContentPane().add(IdTxt);
		IdTxt.setColumns(10);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(231, 99, 86, 24);
		getContentPane().add(nameTxt);
		nameTxt.setColumns(10);
		
		JButton Add = new JButton("Add");
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacherNameAddActionPerformed(e);
			}
		});
		Add.setBounds(72, 197, 113, 27);
		getContentPane().add(Add);
		
		JButton Reset = new JButton("Reset");
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		Reset.setBounds(255, 197, 113, 27);
		getContentPane().add(Reset);
		
		JLabel lblNewLabel_2 = new JLabel("teacher password");
		lblNewLabel_2.setBounds(41, 152, 154, 18);
		getContentPane().add(lblNewLabel_2);
		
		passwordTxt = new JTextField();
		passwordTxt.setBounds(231, 149, 86, 24);
		getContentPane().add(passwordTxt);
		passwordTxt.setColumns(10);

	}
	private synchronized void teacherNameAddActionPerformed(ActionEvent evt) {
		int teacherId=Integer.parseInt(this.IdTxt.getText());
		String teacherName=this.nameTxt.getText();
		String teacherPassword=this.passwordTxt.getText();
		if(StringUtil.isEmpty(String.valueOf(teacherId))){
			JOptionPane.showMessageDialog(null, "teacher ID can't be empty");
			return;
		}
		if(StringUtil.isEmpty(teacherName)){
			JOptionPane.showMessageDialog(null, "teacher name can't be empty");
			return;
		}
		if(StringUtil.isEmpty(teacherPassword)){
			JOptionPane.showMessageDialog(null, "password can't be empty");
			return;
		}
		Teacher teacher=new Teacher(teacherId,teacherName,teacherPassword,"enseignant");
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int n=teacherDao.add(con, teacher);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "Add teacher successfully");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "Add teacher failed");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Add teacher failed");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

	private void resetValueActionPerformed(ActionEvent e) {
		this.resetValue();	
	}

	private void resetValue() {
		this.IdTxt.setText("");
		this.nameTxt.setText("");
		this.passwordTxt.setText("");
	}
}
