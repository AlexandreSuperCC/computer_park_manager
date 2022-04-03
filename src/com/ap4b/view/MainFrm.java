package com.ap4b.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;





public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 507);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Administrateur manager");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("materiel manager");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("consulter et modifier");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaterielManagerInterFrmActionPerformed(e);//afficher l'interface MaterielManagerInterFrm qui est JInternalFrame
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("ajouter un nouveau");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaterielManagerInterFrm2ActionPerformed(e);//afficher l'interface MaterielManagerInterFrm2 qui est JInternalFrame
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("teacher manager");
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("ajouter les enseignants");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacherAddActionPerformed(e);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("supprimer les enseignants");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteTeacherActionPerformed(e);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("sortir en toute s\u00E9curit\u00E9");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortirActionPerformed(e);//sortir de ce système
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_3 = new JMenu("About us");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Notre groupe");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutUsActionPerformed(e);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		table = new JDesktopPane();
		table.setBackground(Color.CYAN);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 779, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 446, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void deleteTeacherActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		TeacherDeleteInterFrm teacherDeleteInterFrm = new TeacherDeleteInterFrm();
		teacherDeleteInterFrm.setVisible(true);
		table.add(teacherDeleteInterFrm);
	}

	private void teacherAddActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		TeacherAddInterFrm teacherAddInterFrm=new TeacherAddInterFrm();
		teacherAddInterFrm.setVisible(true);
		table.add(teacherAddInterFrm);
	}

	private void sortirActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int result = JOptionPane.showConfirmDialog(null, "Vous voulez sortir de ce système?");
		if(result==0) {
			dispose();
		}
	}

	private void MaterielManagerInterFrm2ActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MaterielManagerInterFrm2 materielManagerInterFrm2 = new MaterielManagerInterFrm2();
		materielManagerInterFrm2.setVisible(true);
		table.add(materielManagerInterFrm2);
	}

	private void MaterielManagerInterFrmActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MaterielManagerInterFrm materielManagerInterFrm = new MaterielManagerInterFrm();
		materielManagerInterFrm.setVisible(true);
		table.add(materielManagerInterFrm);
	}

	private void aboutUsActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		AboutusInterFrm aboutUsFrm = new AboutusInterFrm();
		aboutUsFrm.setVisible(true);
		table.add(aboutUsFrm);
	}
}
