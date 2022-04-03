package com.ap4b.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ap4b.dao.MaterielDao;
import com.ap4b.model.Materiel;
import com.ap4b.util.DbUtil;
import com.ap4b.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MaterielManagerInterFrm2 extends JInternalFrame {
	private JTable materielTable;
	private DbUtil dbUtil = new DbUtil();//pour la connexion de base de données
	private JTextField idTxt;
	private JTextField sorteTxt;
	private JTextField etatTxt;
	private JTextField dureeTxt;
	private JRadioButton disponibleJrb;
	private JRadioButton indisponibleJrb;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnNewButton_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaterielManagerInterFrm2 frame = new MaterielManagerInterFrm2();
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
	public MaterielManagerInterFrm2() {
		setTitle("ajouter un nouveau");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 557, 394);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("id");
		
		idTxt = new JTextField();
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("sorte");
		
		sorteTxt = new JTextField();
		sorteTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("etat");
		
		etatTxt = new JTextField();
		etatTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("dur\u00E9e");
		
		dureeTxt = new JTextField();
		dureeTxt.setColumns(10);
		
		disponibleJrb = new JRadioButton("disponible");
		buttonGroup.add(disponibleJrb);
		disponibleJrb.setSelected(true);
		
		indisponibleJrb = new JRadioButton("indisponible");
		buttonGroup.add(indisponibleJrb);
		
		JButton btnNewButton = new JButton("ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouterActionPerformed(e);//ajouter un nouveau matériel
			}
		});
		btnNewButton.setIcon(new ImageIcon(MaterielManagerInterFrm2.class.getResource("/images/add.png")));
		
		btnNewButton_1 = new JButton("R\u00E9initialiser");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed(e);//vider tous les champs
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(MaterielManagerInterFrm2.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 534, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGap(54)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addGap(43)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(sorteTxt, 0, 0, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGap(35)
									.addComponent(lblNewLabel_3)
									.addGap(18)
									.addComponent(dureeTxt, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
									.addGap(45)
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(etatTxt, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(indisponibleJrb, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
								.addComponent(disponibleJrb, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(95)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(39)
							.addComponent(btnNewButton_1)))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(sorteTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(disponibleJrb))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(dureeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2)
								.addComponent(etatTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(indisponibleJrb)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(101, Short.MAX_VALUE))
		);
		
		materielTable = new JTable();
		materielTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "sorte", "etat", "dur\u00E9e", "disponible"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(materielTable);
		getContentPane().setLayout(groupLayout);
		
		fillAllTable();////afficher les matériels dans la table

	}
	
	private void resetActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		resetValue();
	}

	/*
	 * ajouter un nouveau matériel après cliquer sur le bouton 
	 */
	private synchronized void ajouterActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id = this.idTxt.getText();
		
		String sorte = this.sorteTxt.getText();
		String etat = this.etatTxt.getText();
		String duree = this.dureeTxt.getText();
		String disponible = "";
		if(this.disponibleJrb.isSelected()) {
			disponible = "disponible";
		}else {
			disponible = "indisponible";
		}
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "id ne peut pas être null");	
			return;
		}
		if(StringUtil.isEmpty(sorte)) {
			JOptionPane.showMessageDialog(null, "sorte ne peut pas être null");	
			return;
		}
		if(StringUtil.isEmpty(etat)) {
			JOptionPane.showMessageDialog(null, "etat ne peut pas être null");	
			return;
		}
		
		Integer id_int = Integer.parseInt(id);
		Materiel materiel = new Materiel(id_int, sorte, etat, duree, disponible);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addNum = MaterielDao.add(con, materiel);
			if(addNum == 1) {
				JOptionPane.showMessageDialog(null, "Ajout avec succès");
				resetValue();
				fillAllTable();
			}else {
				JOptionPane.showMessageDialog(null, "Ajout échoue");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ajout échoue");
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
	 * Cette partie est pour afficher tous les matériels  
	 * quand l'interface <<ajouter un nouveau>> s'affiche  
	 */
	private void fillAllTable() {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) materielTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			
			ResultSet rs = MaterielDao.listAll(con);
			
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("id"));
				v.add(rs.getString("sorte"));
				v.add(rs.getString("etat"));
				v.add(rs.getString("duree"));
				v.add(rs.getString("disponible"));
				
				dtm.addRow(v);
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
	
	private void resetValue() {
		this.idTxt.setText("");
		this.sorteTxt.setText("");
		this.etatTxt.setText("");
		this.dureeTxt.setText("");
		this.disponibleJrb.setSelected(true);
	}

}
