package com.ap4b.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.ap4b.dao.MaterielDao;
import com.ap4b.model.Materiel;
import com.ap4b.util.DbUtil;
import com.ap4b.util.StringUtil;

public class MaterielManagerInterFrm extends JInternalFrame {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField idTxt;
	private JTextField sorteTxt;
	private JTextField dureeTxt;
	private JTable materielTable;
	private JTextField etatTxt;
	
	private JRadioButton disponibleJrb;
	private JRadioButton pasdisponibleJrb;
	private JRadioButton disponibleChangeJrb;
	private JRadioButton indisponibleChangeJrb;

	private DbUtil dbUtil = new DbUtil();//pour la connexion de base de données
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaterielManagerInterFrm frame = new MaterielManagerInterFrm();
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
	public MaterielManagerInterFrm() {
		setTitle("consulter et modifier");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 592, 377);
		
		disponibleJrb = new JRadioButton("disponible");
		disponibleJrb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listDisponibleActionPerformed(e);
			}
		});
		buttonGroup.add(disponibleJrb);
		disponibleJrb.setSelected(true);
		
		pasdisponibleJrb = new JRadioButton("pas disponible");
		pasdisponibleJrb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listIndisponibleActionPerformed(e);
			}
		});
		buttonGroup.add(pasdisponibleJrb);
		
		JLabel lblNewLabel = new JLabel("id");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("sorte");
		
		sorteTxt = new JTextField();
		sorteTxt.setEditable(false);
		sorteTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("dur\u00E9e");
		
		dureeTxt = new JTextField();
		dureeTxt.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton supprimerBtn = new JButton("supprimer");
		supprimerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supprimerActionPerformed(e);
			}
		});
		supprimerBtn.setIcon(new ImageIcon(MaterielManagerInterFrm.class.getResource("/images/delete.png")));
		
		JLabel lblNewLabel_3 = new JLabel("\u00E9tat");
		
		etatTxt = new JTextField();
		etatTxt.setColumns(10);
		
		JButton changerBtn = new JButton("changer");
		changerBtn.addActionListener((k)->{
				changerActionPerformed(k);
		});
		changerBtn.setIcon(new ImageIcon(MaterielManagerInterFrm.class.getResource("/images/change.png")));
		
		disponibleChangeJrb = new JRadioButton("disponible");
		buttonGroup_1.add(disponibleChangeJrb);
		
		indisponibleChangeJrb = new JRadioButton("indisponible");
		buttonGroup_1.add(indisponibleChangeJrb);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(sorteTxt, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_3))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(48)
									.addComponent(supprimerBtn)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(etatTxt, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(dureeTxt, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
								.addComponent(changerBtn))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(indisponibleChangeJrb, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
								.addComponent(disponibleChangeJrb, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(disponibleJrb, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(pasdisponibleJrb, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 563, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(disponibleJrb)
						.addComponent(pasdisponibleJrb))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(sorteTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(etatTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(dureeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(disponibleChangeJrb))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(supprimerBtn)
							.addComponent(changerBtn))
						.addComponent(indisponibleChangeJrb))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		materielTable = new JTable();
		materielTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				materielTableMousePressed(e);
			}
		});
		scrollPane.setViewportView(materielTable);
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
		getContentPane().setLayout(groupLayout);
		
		fillTable(new Materiel());//afficher les matériels dans la table

	}

	private synchronized void supprimerActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id = idTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "Selectionnez votre donnée à supprimer");
			return;
		}
		Integer id_int = Integer.parseInt(id);
		
		int n = JOptionPane.showConfirmDialog(null, "Vous êtes sûr que vous voulez le supprimer?");
		
		Materiel materiel = new Materiel(id_int);
		if(n==0) {
			/*
			 * effectuer la liaision à la base de données
			 */
			Connection con = null;
			try {
				con = dbUtil.getCon();

				int deleteNum = MaterielDao.delete(con, materiel);
				if(deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "Suppression avec succès");
					this.resetValue();
					this.fillTable(new Materiel());
				}else {
					JOptionPane.showMessageDialog(null, "Suppression échoue");
				}
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Suppression échoue");
			}finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * Cette partie est pour mettre les données dans la zone ci-dessous
	 */
	private void materielTableMousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = this.materielTable.getSelectedRow();
		this.idTxt.setText(materielTable.getValueAt(row, 0).toString());
		this.sorteTxt.setText(materielTable.getValueAt(row, 1).toString());
		this.etatTxt.setText(materielTable.getValueAt(row, 2).toString());
		this.dureeTxt.setText(materielTable.getValueAt(row, 3).toString());
		
		if("disponible".equals(materielTable.getValueAt(row, 4))) { //faire attention à EQUALS() ici
			this.disponibleChangeJrb.setSelected(true);
		}else {
			this.indisponibleChangeJrb.setSelected(true);
		}
	}

	/*
	 * Cette partie est pour modifier les caractéristiques d'un matériel 
	 */
	private synchronized void changerActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id2 = this.idTxt.getText();
		if(StringUtil.isEmpty(id2)) {
			JOptionPane.showMessageDialog(null, "Selectionnez votre donnée pour modifier");
			return;
		}
		
		Integer id_int = Integer.parseInt(id2);
		
		String etat = this.etatTxt.getText();
		if(StringUtil.isEmpty(etat)) {
			JOptionPane.showMessageDialog(null, "Etat ne peut pas être null");
			return;
		}
		String duree = this.dureeTxt.getText();

		String disponible = "";
		if(disponibleChangeJrb.isSelected()) {
			disponible = "disponible";
		}else if(indisponibleChangeJrb.isSelected()){
			disponible = "indisponible";
		}
		Materiel materiel = new Materiel(id_int, etat, duree, disponible);
		
		/**
		 * Effectuer la liaison avec la base de données
		 */
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addNum = MaterielDao.update(con, materiel);
			if(addNum == 1) {
				JOptionPane.showMessageDialog(null, "Materiel modification avec succès");
				resetValue();
				this.fillTable(new Materiel());
			}else {
				JOptionPane.showMessageDialog(null, "Materiel modification échoue");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Materiel modification échoue");
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
	 * Cette partie est pour afficher tous les matériels disponibles 
	 * quand l'interface <<consulter et modifier>> s'affiche  
	 */
	private void fillTable(Materiel materiel) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) materielTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			if(disponibleJrb.isSelected()) {
				materiel.setDisponible("disponible");
			}else {
				materiel.setDisponible("indisponible");
			}			
			ResultSet rs = MaterielDao.list(con, materiel);
			
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

	/*
	 * Cette partie est pour afficher les matériels disponibles ou indisponibles 
	 * après choisir un de deux JRadioBouton dans l'interface
	 */
	//quand on choisit le JRadioBouton: Disponbile
	private void listDisponibleActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		Materiel materiel = new Materiel();
		
		DefaultTableModel dtm = (DefaultTableModel) materielTable.getModel();
		dtm.setRowCount(0);

		Connection con = null;
		try {
			con = dbUtil.getCon();
			
			materiel.setDisponible("disponible");
		
			ResultSet rs = MaterielDao.list(con, materiel);
			
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
	//quand on choisit le JRadioBouton: Indisponbile
	private void listIndisponibleActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		Materiel materiel = new Materiel();
		
		DefaultTableModel dtm = (DefaultTableModel) materielTable.getModel();
		dtm.setRowCount(0);

		Connection con = null;
		try {
			con = dbUtil.getCon();
			
			materiel.setDisponible("indisponible");
		
			ResultSet rs = MaterielDao.list(con, materiel);
			
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
	
	/*
	 * Cette partie est pour effacer tous les champs ci-dessous
	 */
	private void resetValue() {
		this.idTxt.setText("");
		this.sorteTxt.setText("");
		this.etatTxt.setText("");
		this.dureeTxt.setText("");
		this.disponibleChangeJrb.setSelected(true);
	}
}
