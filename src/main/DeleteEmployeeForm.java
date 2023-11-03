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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class DeleteEmployeeForm {

	String qry="";
	Connection con=null;
	PreparedStatement st=null;
	ResultSet rs=null;
	
	JFrame frmDeleteEmployee;
	JTextArea txtAddress_Del;
	private JTextField txtEmployeeId_Del;
	JLabel lblEmployeeName_1_Del;
	JLabel lblEmailId_1_Del;
	JLabel lblPhoneNumber_1_Del;
	JLabel lblGender_1_Del;
	JLabel lblDateofBirth_1_Del;
	JLabel lblDesignation_1_Del;
	JLabel lblEmployeeType_1_Del;
	JLabel lblDateOfJoining_1_Del;
	JLabel lblLocation_1_Del;
	JLabel lblBasicSalary_1_Del;
	MainMenu m=new MainMenu();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteEmployeeForm window = new DeleteEmployeeForm();
					window.frmDeleteEmployee.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public DeleteEmployeeForm() {
		initialize();
		con=MyConnection.getConnection();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDeleteEmployee = new JFrame();
		frmDeleteEmployee.setTitle("Delete Employee");
		frmDeleteEmployee.setBounds(100, 100, 548, 720);
		frmDeleteEmployee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDeleteEmployee.getContentPane().setLayout(null);
		Dimension tk=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(int)((tk.getWidth()-frmDeleteEmployee.getWidth())/2);
		int y=(int)((tk.getHeight()-frmDeleteEmployee.getHeight())/2);
		frmDeleteEmployee.setLocation(x,y);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(0, 0, 534, 683);
		frmDeleteEmployee.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEmployeeName = new JLabel("Employee Name");
		lblEmployeeName.setForeground(Color.DARK_GRAY);
		lblEmployeeName.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEmployeeName.setBounds(70, 58, 110, 26);
		panel.add(lblEmployeeName);
		
		JLabel lblEmailId = new JLabel("Email Id");
		lblEmailId.setForeground(Color.DARK_GRAY);
		lblEmailId.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEmailId.setBounds(70, 110, 101, 26);
		panel.add(lblEmailId);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setForeground(Color.DARK_GRAY);
		lblPhoneNumber.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPhoneNumber.setBounds(70, 163, 102, 26);
		panel.add(lblPhoneNumber);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.DARK_GRAY);
		lblGender.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblGender.setBounds(70, 216, 101, 26);
		panel.add(lblGender);
		
		JLabel lblDateofBirth = new JLabel("Date of Birth");
		lblDateofBirth.setForeground(Color.DARK_GRAY);
		lblDateofBirth.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDateofBirth.setBounds(70, 269, 101, 26);
		panel.add(lblDateofBirth);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.DARK_GRAY);
		lblAddress.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblAddress.setBounds(70, 322, 101, 26);
		panel.add(lblAddress);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setForeground(Color.DARK_GRAY);
		lblDesignation.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDesignation.setBounds(70, 403, 101, 26);
		panel.add(lblDesignation);
		
		JLabel lblEmployeeType = new JLabel("Employee Type");
		lblEmployeeType.setForeground(Color.DARK_GRAY);
		lblEmployeeType.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEmployeeType.setBounds(70, 450, 104, 26);
		panel.add(lblEmployeeType);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setForeground(Color.DARK_GRAY);
		lblLocation.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblLocation.setBounds(70, 548, 101, 26);
		panel.add(lblLocation);
		
		JLabel lblBasicSalary = new JLabel("Basic Salary");
		lblBasicSalary.setForeground(Color.DARK_GRAY);
		lblBasicSalary.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblBasicSalary.setBounds(70, 595, 101, 26);
		panel.add(lblBasicSalary);
		
		txtAddress_Del = new JTextArea();
		txtAddress_Del.setEditable(false);
		txtAddress_Del.setBackground(new Color(176, 224, 230));
		txtAddress_Del.setLineWrap(true);
		txtAddress_Del.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtAddress_Del.setRows(3);
		txtAddress_Del.setBounds(237, 323, 234, 63);
		panel.add(txtAddress_Del);
		
		JLabel lblDateOfJoining = new JLabel("Date of Joining");
		lblDateOfJoining.setForeground(Color.DARK_GRAY);
		lblDateOfJoining.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDateOfJoining.setBounds(70, 498, 104, 26);
		panel.add(lblDateOfJoining);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int eid=Integer.parseInt(txtEmployeeId_Del.getText());
				System.out.println(eid);
				int result=JOptionPane.showConfirmDialog(null, "Are you sure?","Cancel",JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_OPTION) {
					qry = "delete from employee where Employee_Id="+eid;
			        try {
						st = con.prepareStatement(qry);
				        st.executeUpdate();
				        JOptionPane.showMessageDialog(null, "Employee Details Deleted");
				        m.frmMainMenu.setVisible(true);
				        frmDeleteEmployee.dispose();
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
		btnOk.setBounds(237, 641, 85, 32);
		panel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.frmMainMenu.setVisible(true);
				frmDeleteEmployee.dispose();
			}
		});
		btnCancel.setBackground(new Color(210, 105, 30));
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setBorder(null);
		btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCancel.setBounds(386, 641, 85, 32);
		panel.add(btnCancel);
		
		JLabel lblEmployeeId = new JLabel("Employee Id");
		lblEmployeeId.setForeground(Color.DARK_GRAY);
		lblEmployeeId.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEmployeeId.setBounds(70, 10, 110, 26);
		panel.add(lblEmployeeId);
		
		txtEmployeeId_Del = new JTextField();
		txtEmployeeId_Del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int eid=Integer.parseInt(txtEmployeeId_Del.getText());
				qry = "select * from employee where Employee_Id=?";
		        try {
					st = con.prepareStatement(qry);
			        st.setInt(1,eid);
			        rs=st.executeQuery();
			        if(rs.next()) {
			        	lblEmployeeName_1_Del.setText(rs.getString("Employee_Name"));
			        	lblEmailId_1_Del.setText(rs.getString("E_Mail"));
			        	lblPhoneNumber_1_Del.setText(rs.getString("Phone_Number"));
			        	lblGender_1_Del.setText(rs.getString("Gender"));
			        	lblDateofBirth_1_Del.setText(rs.getString("Date_of_Birth"));
			        	txtAddress_Del.setText(rs.getString("Address"));
			        	lblDesignation_1_Del.setText(rs.getString("Designation"));
			        	lblEmployeeType_1_Del.setText(rs.getString("Employee_Type"));
			        	lblDateOfJoining_1_Del.setText(rs.getString("Date_of_Joining"));
			        	lblLocation_1_Del.setText(rs.getString("Location"));
			        	lblBasicSalary_1_Del.setText(rs.getString("BasicSalary"));
			        }
		        } catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		txtEmployeeId_Del.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtEmployeeId_Del.setColumns(10);
		txtEmployeeId_Del.setBounds(237, 10, 234, 26);
		panel.add(txtEmployeeId_Del);
		
		lblEmployeeName_1_Del = new JLabel("Employee Name");
		lblEmployeeName_1_Del.setForeground(new Color(0, 0, 0));
		lblEmployeeName_1_Del.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblEmployeeName_1_Del.setBounds(237, 58, 234, 26);
		panel.add(lblEmployeeName_1_Del);
		
		lblEmailId_1_Del = new JLabel("Email Id");
		lblEmailId_1_Del.setForeground(new Color(0, 0, 0));
		lblEmailId_1_Del.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblEmailId_1_Del.setBounds(237, 110, 234, 26);
		panel.add(lblEmailId_1_Del);
		
		lblPhoneNumber_1_Del = new JLabel("Phone Number");
		lblPhoneNumber_1_Del.setForeground(new Color(0, 0, 0));
		lblPhoneNumber_1_Del.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblPhoneNumber_1_Del.setBounds(237, 163, 234, 26);
		panel.add(lblPhoneNumber_1_Del);
		
		lblGender_1_Del = new JLabel("Gender");
		lblGender_1_Del.setForeground(new Color(0, 0, 0));
		lblGender_1_Del.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGender_1_Del.setBounds(239, 216, 232, 26);
		panel.add(lblGender_1_Del);
		
		lblDateofBirth_1_Del = new JLabel("Date of Birth");
		lblDateofBirth_1_Del.setForeground(new Color(0, 0, 0));
		lblDateofBirth_1_Del.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblDateofBirth_1_Del.setBounds(237, 269, 234, 26);
		panel.add(lblDateofBirth_1_Del);
		
		lblDesignation_1_Del = new JLabel("Designation");
		lblDesignation_1_Del.setForeground(new Color(0, 0, 0));
		lblDesignation_1_Del.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblDesignation_1_Del.setBounds(237, 403, 234, 26);
		panel.add(lblDesignation_1_Del);
		
		lblEmployeeType_1_Del = new JLabel("Employee Type");
		lblEmployeeType_1_Del.setForeground(new Color(0, 0, 0));
		lblEmployeeType_1_Del.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblEmployeeType_1_Del.setBounds(237, 450, 234, 26);
		panel.add(lblEmployeeType_1_Del);
		
		lblDateOfJoining_1_Del = new JLabel("Date of Joining");
		lblDateOfJoining_1_Del.setForeground(new Color(0, 0, 0));
		lblDateOfJoining_1_Del.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblDateOfJoining_1_Del.setBounds(237, 498, 234, 26);
		panel.add(lblDateOfJoining_1_Del);
		
		lblLocation_1_Del = new JLabel("Location");
		lblLocation_1_Del.setForeground(new Color(0, 0, 0));
		lblLocation_1_Del.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLocation_1_Del.setBounds(237, 548, 234, 26);
		panel.add(lblLocation_1_Del);
		
		lblBasicSalary_1_Del = new JLabel("Basic Salary");
		lblBasicSalary_1_Del.setForeground(new Color(0, 0, 0));
		lblBasicSalary_1_Del.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblBasicSalary_1_Del.setBounds(237, 595, 234, 26);
		panel.add(lblBasicSalary_1_Del);
	}
}
