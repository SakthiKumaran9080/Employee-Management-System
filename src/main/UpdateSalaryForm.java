package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UpdateSalaryForm {

	JFrame frmUpdateSalary;
	private JTextField txtEmployeeId;
	private JTextField txtBasicSalary;
	private JButton btnOk;
	private JButton btnCancel;
	MainMenu m=new MainMenu();
	
	String qry="";
	Connection con=null;
	PreparedStatement st=null;
	ResultSet rs=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateSalaryForm window = new UpdateSalaryForm();
					window.frmUpdateSalary.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UpdateSalaryForm() {
		initialize();
		con=MyConnection.getConnection();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUpdateSalary = new JFrame();
		frmUpdateSalary.setTitle("Update Salary");
		frmUpdateSalary.setBounds(100, 100, 450, 300);
		frmUpdateSalary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUpdateSalary.getContentPane().setLayout(null);
		Dimension tk=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(int)((tk.getWidth()-frmUpdateSalary.getWidth())/2);
		int y=(int)((tk.getHeight()-frmUpdateSalary.getHeight())/2);
		frmUpdateSalary.setLocation(x,y);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(0, 0, 436, 263);
		frmUpdateSalary.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEmployeeId = new JLabel("Employee Id");
		lblEmployeeId.setBackground(Color.DARK_GRAY);
		lblEmployeeId.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEmployeeId.setBounds(38, 61, 119, 30);
		panel.add(lblEmployeeId);
		
		JLabel lblBasicSalary = new JLabel("Basic Salary");
		lblBasicSalary.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblBasicSalary.setBackground(Color.DARK_GRAY);
		lblBasicSalary.setBounds(38, 129, 119, 30);
		panel.add(lblBasicSalary);
		
		txtEmployeeId = new JTextField();
		txtEmployeeId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int eid=Integer.parseInt(txtEmployeeId.getText());
				qry = "select * from employee where Employee_Id=?";
		        try {
					st = con.prepareStatement(qry);
			        st.setInt(1,eid);
			        rs=st.executeQuery();
			        if(rs.next()) {
			        	txtBasicSalary.setText(rs.getString("BasicSalary"));
			        }
		        } catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		txtEmployeeId.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtEmployeeId.setBounds(148, 61, 225, 30);
		panel.add(txtEmployeeId);
		txtEmployeeId.setColumns(10);
		
		txtBasicSalary = new JTextField();
		txtBasicSalary.setColumns(10);
		txtBasicSalary.setBounds(148, 129, 225, 30);
		panel.add(txtBasicSalary);
		
		btnOk = new JButton("Update");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int eid=Integer.parseInt(txtEmployeeId.getText());
				String bsalary=txtBasicSalary.getText();
				if(eid!=0 && !txtEmployeeId.getText().isEmpty()) {
					qry="update employee set BasicSalary=? where Employee_Id="+eid;
					try {
						st=con.prepareStatement(qry);
						st.setString(1, bsalary);
						st.executeUpdate();
						JOptionPane.showMessageDialog(null, "Employee Salary Details Updated");
				        m.frmMainMenu.setVisible(true);
				        frmUpdateSalary.dispose();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnOk.setForeground(new Color(255, 255, 255));
		btnOk.setBackground(new Color(210, 105, 30));
		btnOk.setBorder(null);
		btnOk.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnOk.setBounds(148, 187, 85, 32);
		panel.add(btnOk);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        m.frmMainMenu.setVisible(true);
		        frmUpdateSalary.dispose();
			}
		});
		btnCancel.setBackground(new Color(210, 105, 30));
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCancel.setBorder(null);
		btnCancel.setBounds(288, 188, 85, 30);
		panel.add(btnCancel);
	}
}
