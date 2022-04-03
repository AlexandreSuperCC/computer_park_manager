package com.ap4b.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.ap4b.dao.TeacherDao;
import com.ap4b.model.Teacher;
import com.ap4b.util.DbUtil;
import com.ap4b.util.StringUtil;

public class TeacherDeleteInterFrm extends JInternalFrame {
	private JTable table;
	private DbUtil dbUtil=new DbUtil();
	private TeacherDao teacherDao=new TeacherDao();
	private JTextField teachernameText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherDeleteInterFrm frame = new TeacherDeleteInterFrm();
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
	public TeacherDeleteInterFrm() {
		setTitle("Delete teacher");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 450, 447);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setBounds(47, 349, 81, 27);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				teacherDeleteActionEvent(evt);
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();

		
		scrollPane.setBounds(34, 34, 386, 258);
		getContentPane().add(scrollPane);
		
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
		
			public void mousePressed(MouseEvent e) {
				tableMousepressed(e);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Teacher Name", "Teacher Password"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(140);
		table.getColumnModel().getColumn(2).setPreferredWidth(153);
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("");
		
		JLabel lblNewLabel = new JLabel("Teacher ID");
		
		teachernameText = new JTextField();
		teachernameText.setColumns(10);
		
		JButton btnRefresh = new JButton("Refresh");//!
		btnNewButton.setBounds(47, 349, 81, 27);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTable(new Teacher());
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRefresh)
						.addComponent(teachernameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(117))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(299, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel)
							.addComponent(teachernameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(label))
					.addGap(28)
					.addComponent(btnRefresh)
					.addGap(33))
		);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new Teacher());

	}

	private void tableMousepressed(MouseEvent e) {
		int row=table.getSelectedRow();
		teachernameText.setText((String)table.getValueAt(row, 0));
		
	}

	private synchronized void teacherDeleteActionEvent(ActionEvent evt) {
		String teachername = teachernameText.getText();
		
		if(StringUtil.isEmpty(teachername)){
			JOptionPane.showMessageDialog(null, "choice");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "Are you sure?");
		if(n==0){
			Connection con=null;
			try{
				con=dbUtil.getCon();
				int deleteNum=teacherDao.delete(con, Integer.parseInt(teachername));
				if(deleteNum==1){
					this.teachernameText.setText("");
					JOptionPane.showMessageDialog(null, "Delete successfully");
					
					this.fillTable(new Teacher());
				}else{
					JOptionPane.showMessageDialog(null, "F");
				}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "F");
			}finally{
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		
		
	}

	private void fillTable(Teacher teacher){
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		dtm.setRowCount(0); 
		Connection con=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=teacherDao.list(con, teacher);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("nom"));
				v.add(rs.getString("code"));

				dtm.addRow(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}
}
