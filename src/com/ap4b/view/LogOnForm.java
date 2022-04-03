package com.ap4b.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.ap4b.dao.UserDao;
import com.ap4b.model.User;
import com.ap4b.util.DbUtil;
import com.ap4b.util.StringUtil;

public class LogOnForm extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTxt;
	private JPasswordField passwordTxt;
	private JComboBox modeJcb;
	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnForm frame = new LogOnForm();
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
	public LogOnForm() {
		setTitle("Login page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Gestion de parc informatique");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setIcon(new ImageIcon(LogOnForm.class.getResource("/images/universite.png")));
		
		JLabel lblNewLabel_1 = new JLabel("username");
		lblNewLabel_1.setIcon(new ImageIcon(LogOnForm.class.getResource("/images/username.png")));
		
		usernameTxt = new JTextField();
		usernameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("password");
		lblNewLabel_2.setIcon(new ImageIcon(LogOnForm.class.getResource("/images/code.png")));
		
		passwordTxt = new JPasswordField();
		
		modeJcb = new JComboBox();
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(LogOnForm.class.getResource("/images/login.png")));
		
		JButton btnNewButton_1 = new JButton("reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(LogOnForm.class.getResource("/images/reset.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE)
					.addGap(49))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(126)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(modeJcb, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1)
								.addComponent(btnNewButton))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(passwordTxt)
									.addComponent(usernameTxt))
								.addComponent(btnNewButton_1))))
					.addContainerGap(196, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(modeJcb, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		 fillMode();
	}
	
	/*
	 * après avoir cliqué sur le bouton login
	 */
	private void loginActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String username = this.usernameTxt.getText();
		String password = new String(this.passwordTxt.getPassword());
		
		/*
		 * cette partie est pour véifier s'il y a un champ null et alerte l'utilisateur
		 * utiliser StringUtil.isEmpty() crée par nous-mêmes pour que "" et "  " soient tous considérés null
		 */
		if(StringUtil.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, "nom ne peut pas être null");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "code ne peut pas être null");
			return;
		}
		
		User user_jcb = (User) this.modeJcb.getSelectedItem();
		if(user_jcb.equals(modeJcb.getItemAt(0))) {
			JOptionPane.showMessageDialog(null, "Choisissez votre mode");
			return;
		}
		
		/*
		 * connecter à la base de données pour vérifier le nom,code,mode sont légaux ou pas
		 */
		User user = new User(username,password,user_jcb.getMode());
		Connection con = null;
		try {
			con = dbUtil.getCon();
			User currentUser = userDao.login(con, user);
			if(currentUser!=null) {
				if(user.getMode()=="administrateur") {
				    dispose();
				    new MainFrm().setVisible(true);
				}else {
						dispose();
						new MainFrm2().setVisible(true);
				}
			}else {
				JOptionPane.showMessageDialog(null, "login échoue, nom/code/mode invalide");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/*
	 * refaire les données pour la fonction login
	 */
	private void resetActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.modeJcb.setSelectedIndex(0);
		this.usernameTxt.setText("");
		this.passwordTxt.setText("");
	}

	private void fillMode() { //ajouter les éléments pour modeJcb
		User user = null;
		
		user = new User();
		user.setMode("Vous êtes...");
		this.modeJcb.addItem(user);	
		
		user = new User();
		user.setMode("administrateur");
		this.modeJcb.addItem(user);		
		
		user = new User();
		user.setMode("enseignant");
		this.modeJcb.addItem(user);
	}
}
