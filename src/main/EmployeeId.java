package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class EmployeeId {
	
	JFrame frmEmployeeId;
	private final JPanel panel = new JPanel();
	JTextField txtEmployeeId_ID;
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
					EmployeeId window = new EmployeeId();
					window.frmEmployeeId.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmployeeId() {
		initialize();
		con=MyConnection.getConnection();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmployeeId = new JFrame();
		frmEmployeeId.setTitle("Employee Id");
		frmEmployeeId.setBounds(100, 100, 450, 300);
		frmEmployeeId.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmployeeId.getContentPane().setLayout(null);
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(0, 0, 436, 263);
		frmEmployeeId.getContentPane().add(panel);
		panel.setLayout(null);
		Dimension tk=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(int)((tk.getWidth()-frmEmployeeId.getWidth())/2);
		int y=(int)((tk.getHeight()-frmEmployeeId.getHeight())/2);
		frmEmployeeId.setLocation(x,y);
		
		JLabel lblEmployeeId = new JLabel("Employee Id");
		lblEmployeeId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeId.setForeground(Color.DARK_GRAY);
		lblEmployeeId.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblEmployeeId.setBounds(96, 51, 223, 39);
		panel.add(lblEmployeeId);
		
		txtEmployeeId_ID = new JTextField();
		txtEmployeeId_ID.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmployeeId_ID.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtEmployeeId_ID.setBounds(96, 114, 229, 32);
		panel.add(txtEmployeeId_ID);
		txtEmployeeId_ID.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int eid=Integer.parseInt(txtEmployeeId_ID.getText());
				qry = "select * from employee where Employee_Id=?";
		        try {
					st = con.prepareStatement(qry);
			        st.setInt(1,eid);
			        rs=st.executeQuery();
			        if(rs.next()) {
			        	m.lblEmpId_Main.setText(String.valueOf(eid));
			        	m.lblDesignation_Main.setText(rs.getString("Designation"));
						m.frmMainMenu.setVisible(true);
						frmEmployeeId.dispose();
			        }
		        } catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnOk.setBackground(new Color(210, 105, 30));
		btnOk.setBorder(null);
		btnOk.setForeground(new Color(255, 255, 255));
		btnOk.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnOk.setBounds(93, 177, 85, 32);
		panel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEmployeeId_ID.setText("");
			}
		});
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setBackground(new Color(210, 105, 30));
		btnCancel.setBorder(null);
		btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCancel.setBounds(240, 177, 85, 32);
		panel.add(btnCancel);
	}
}
