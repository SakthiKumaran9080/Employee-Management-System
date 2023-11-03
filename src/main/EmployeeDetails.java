package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmployeeDetails {

	String qry="";
	Connection con=null;
	PreparedStatement st=null;
	ResultSet rs=null;
	
	JFrame frmEmployeeDetails;
	private JTextField txtEmployeeId_Details;
	private JTextArea txtAddress_Details;
	JLabel lblEmployeeName_1_Details;
	JLabel lblEmailId_1_Details;
	JLabel lblPhoneNumber_1_Details;
	JLabel lblGender_1_Details;
	JLabel lblDateofBirth_1_Details;
	JLabel lblDesignation_1_Details;
	JLabel lblEmployeeType_1_Details;
	JLabel lblDateOfJoining_1_Details;
	JLabel lblLocation_1_Details;
	JLabel lblBasicSalary_1_Details;
	private JLabel lblNewLabel;
	MainMenu m=new MainMenu();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeDetails window = new EmployeeDetails();
					window.frmEmployeeDetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmployeeDetails() {
		initialize();
		con=MyConnection.getConnection();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmployeeDetails = new JFrame();
		frmEmployeeDetails.setTitle("Employee Details");
		frmEmployeeDetails.setBounds(100, 100, 548, 700);
		frmEmployeeDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmployeeDetails.getContentPane().setLayout(null);
		Dimension tk=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(int)((tk.getWidth()-frmEmployeeDetails.getWidth())/2);
		int y=(int)((tk.getHeight()-frmEmployeeDetails.getHeight())/2);
		frmEmployeeDetails.setLocation(x,y);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(0, 0, 534, 663);
		frmEmployeeDetails.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEmployeeId = new JLabel("Employee Id");
		lblEmployeeId.setForeground(Color.DARK_GRAY);
		lblEmployeeId.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEmployeeId.setBounds(69, 30, 101, 26);
		panel.add(lblEmployeeId);
		
		JLabel lblEmployeeName = new JLabel("Employee Name");
		lblEmployeeName.setForeground(Color.DARK_GRAY);
		lblEmployeeName.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEmployeeName.setBounds(69, 78, 110, 26);
		panel.add(lblEmployeeName);
		
		JLabel lblEmailId = new JLabel("Email Id");
		lblEmailId.setForeground(Color.DARK_GRAY);
		lblEmailId.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEmailId.setBounds(69, 130, 101, 26);
		panel.add(lblEmailId);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setForeground(Color.DARK_GRAY);
		lblPhoneNumber.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPhoneNumber.setBounds(69, 183, 102, 26);
		panel.add(lblPhoneNumber);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.DARK_GRAY);
		lblGender.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblGender.setBounds(69, 236, 101, 26);
		panel.add(lblGender);
		
		JLabel lblDateofBirth = new JLabel("Date of Birth");
		lblDateofBirth.setForeground(Color.DARK_GRAY);
		lblDateofBirth.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDateofBirth.setBounds(69, 289, 101, 26);
		panel.add(lblDateofBirth);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.DARK_GRAY);
		lblAddress.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblAddress.setBounds(69, 342, 101, 26);
		panel.add(lblAddress);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setForeground(Color.DARK_GRAY);
		lblDesignation.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDesignation.setBounds(69, 423, 101, 26);
		panel.add(lblDesignation);
		
		JLabel lblEmployeeType = new JLabel("Employee Type");
		lblEmployeeType.setForeground(Color.DARK_GRAY);
		lblEmployeeType.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEmployeeType.setBounds(69, 470, 104, 26);
		panel.add(lblEmployeeType);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setForeground(Color.DARK_GRAY);
		lblLocation.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblLocation.setBounds(69, 568, 101, 26);
		panel.add(lblLocation);
		
		JLabel lblBasicSalary = new JLabel("Basic Salary");
		lblBasicSalary.setForeground(Color.DARK_GRAY);
		lblBasicSalary.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblBasicSalary.setBounds(69, 615, 101, 26);
		panel.add(lblBasicSalary);
		
		txtEmployeeId_Details = new JTextField();
		txtEmployeeId_Details.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int eid=Integer.parseInt(txtEmployeeId_Details.getText());
				qry = "select * from employee where Employee_Id=?";
		        try {
					st = con.prepareStatement(qry);
			        st.setInt(1,eid);
			        rs=st.executeQuery();
			        if(rs.next()) {
			        	lblEmployeeName_1_Details.setText(rs.getString("Employee_Name"));
			        	lblEmailId_1_Details.setText(rs.getString("E_Mail"));
			        	lblPhoneNumber_1_Details.setText(rs.getString("Phone_Number"));
			        	lblGender_1_Details.setText(rs.getString("Gender"));
			        	lblDateofBirth_1_Details.setText(rs.getString("Date_of_Birth"));
			        	txtAddress_Details.setText(rs.getString("Address"));
			        	lblDesignation_1_Details.setText(rs.getString("Designation"));
			        	lblEmployeeType_1_Details.setText(rs.getString("Employee_Type"));
			        	lblDateOfJoining_1_Details.setText(rs.getString("Date_of_Joining"));
			        	lblLocation_1_Details.setText(rs.getString("Location"));
			        	lblBasicSalary_1_Details.setText(rs.getString("BasicSalary"));
			        }
		        } catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		txtEmployeeId_Details.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtEmployeeId_Details.setBounds(236, 30, 234, 26);
		panel.add(txtEmployeeId_Details);
		txtEmployeeId_Details.setColumns(10);
		
		txtAddress_Details = new JTextArea();
		txtAddress_Details.setBackground(new Color(176, 224, 230));
		txtAddress_Details.setLineWrap(true);
		txtAddress_Details.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtAddress_Details.setRows(3);
		txtAddress_Details.setEditable(false);
		txtAddress_Details.setBounds(235, 343, 234, 63);
		panel.add(txtAddress_Details);
		
		JLabel lblDateOfJoining = new JLabel("Date of Joining");
		lblDateOfJoining.setForeground(Color.DARK_GRAY);
		lblDateOfJoining.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDateOfJoining.setBounds(69, 518, 104, 26);
		panel.add(lblDateOfJoining);
		
		lblEmployeeName_1_Details = new JLabel("Employee Name");
		lblEmployeeName_1_Details.setForeground(new Color(0, 0, 0));
		lblEmployeeName_1_Details.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblEmployeeName_1_Details.setBounds(236, 80, 231, 26);
		panel.add(lblEmployeeName_1_Details);
		
		lblEmailId_1_Details = new JLabel("Email Id");
		lblEmailId_1_Details.setForeground(new Color(0, 0, 0));
		lblEmailId_1_Details.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblEmailId_1_Details.setBounds(236, 131, 231, 26);
		panel.add(lblEmailId_1_Details);
		
		lblPhoneNumber_1_Details = new JLabel("Phone Number");
		lblPhoneNumber_1_Details.setForeground(new Color(0, 0, 0));
		lblPhoneNumber_1_Details.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblPhoneNumber_1_Details.setBounds(235, 179, 227, 26);
		panel.add(lblPhoneNumber_1_Details);
		
		lblGender_1_Details = new JLabel("Gender");
		lblGender_1_Details.setForeground(new Color(0, 0, 0));
		lblGender_1_Details.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGender_1_Details.setBounds(235, 234, 229, 26);
		panel.add(lblGender_1_Details);
		
		lblDateofBirth_1_Details = new JLabel("Date of Birth");
		lblDateofBirth_1_Details.setForeground(new Color(0, 0, 0));
		lblDateofBirth_1_Details.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblDateofBirth_1_Details.setBounds(234, 291, 235, 26);
		panel.add(lblDateofBirth_1_Details);
		
		lblDesignation_1_Details = new JLabel("Designation");
		lblDesignation_1_Details.setForeground(new Color(0, 0, 0));
		lblDesignation_1_Details.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblDesignation_1_Details.setBounds(238, 424, 228, 26);
		panel.add(lblDesignation_1_Details);
		
		lblEmployeeType_1_Details = new JLabel("Employee Type");
		lblEmployeeType_1_Details.setForeground(new Color(0, 0, 0));
		lblEmployeeType_1_Details.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblEmployeeType_1_Details.setBounds(236, 470, 233, 26);
		panel.add(lblEmployeeType_1_Details);
		
		lblDateOfJoining_1_Details = new JLabel("Date of Joining");
		lblDateOfJoining_1_Details.setForeground(new Color(0, 0, 0));
		lblDateOfJoining_1_Details.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblDateOfJoining_1_Details.setBounds(236, 516, 232, 26);
		panel.add(lblDateOfJoining_1_Details);
		
		lblLocation_1_Details = new JLabel("Location");
		lblLocation_1_Details.setForeground(new Color(0, 0, 0));
		lblLocation_1_Details.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLocation_1_Details.setBounds(235, 566, 228, 26);
		panel.add(lblLocation_1_Details);
		
		lblBasicSalary_1_Details = new JLabel("Basic Salary");
		lblBasicSalary_1_Details.setForeground(new Color(0, 0, 0));
		lblBasicSalary_1_Details.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblBasicSalary_1_Details.setBounds(234, 616, 221, 26);
		panel.add(lblBasicSalary_1_Details);
		
		lblNewLabel = new JLabel("Back");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				m.frmMainMenu.setVisible(true);
				frmEmployeeDetails.dispose();
			}
		});
		lblNewLabel.setForeground(new Color(184, 134, 11));
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel.setBounds(499, 10, 25, 16);
		panel.add(lblNewLabel);
	}
}
