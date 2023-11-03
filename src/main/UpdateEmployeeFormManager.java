package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class UpdateEmployeeFormManager {

	JFrame frmUpdateEmployeeManager;
	String qry="";
	Connection con=null;
	PreparedStatement st=null;
	ResultSet rs=null;
	private JTextField txtEmpName;
	private JTextField txtEmail;
	private JTextField txtPhoneNumber;
	private JTextField txtLocation;
	private JTextField txtEmployeeId;
	@SuppressWarnings("rawtypes")
	JComboBox txtDesignation;
	MainMenu m=new MainMenu();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateEmployeeFormManager window = new UpdateEmployeeFormManager();
					window.frmUpdateEmployeeManager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UpdateEmployeeFormManager() {
		initialize();
		con=MyConnection.getConnection();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	@SuppressWarnings("rawtypes")
	private void initialize() {
		frmUpdateEmployeeManager = new JFrame();
		frmUpdateEmployeeManager.setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateEmployeeFormManager.class.getResource("/form_icon/UpdateEmployeeForm.png")));
		frmUpdateEmployeeManager.setTitle("Update Employee");
		frmUpdateEmployeeManager.setBounds(100, 100, 558, 699);
		frmUpdateEmployeeManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUpdateEmployeeManager.getContentPane().setLayout(null);
		Dimension tk=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(int)((tk.getWidth()-frmUpdateEmployeeManager.getWidth())/2);
		int y=(int)((tk.getHeight()-frmUpdateEmployeeManager.getHeight())/2);
		frmUpdateEmployeeManager.setLocation(x,y);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(0, 0, 544, 662);
		frmUpdateEmployeeManager.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEmpName = new JLabel("Employee Name");
		lblEmpName.setForeground(Color.DARK_GRAY);
		lblEmpName.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEmpName.setBounds(56, 98, 120, 32);
		panel.add(lblEmpName);
		
		txtEmpName = new JTextField();
		txtEmpName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtEmpName.setBounds(212, 98, 267, 32);
		panel.add(txtEmpName);
		txtEmpName.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.DARK_GRAY);
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEmail.setBounds(56, 160, 120, 32);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(212, 160, 267, 32);
		panel.add(txtEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setForeground(Color.DARK_GRAY);
		lblPhoneNumber.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPhoneNumber.setBounds(56, 217, 120, 32);
		panel.add(lblPhoneNumber);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(212, 217, 267, 32);
		panel.add(txtPhoneNumber);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setForeground(Color.DARK_GRAY);
		lblLocation.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblLocation.setBounds(56, 543, 120, 32);
		panel.add(lblLocation);
		
		txtLocation = new JTextField();
		txtLocation.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtLocation.setColumns(10);
		txtLocation.setBounds(212, 543, 267, 32);
		panel.add(txtLocation);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.DARK_GRAY);
		lblGender.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblGender.setBounds(56, 270, 120, 32);
		panel.add(lblGender);
		
		JLabel lblAddress = new JLabel("Permenant Address");
		lblAddress.setForeground(Color.DARK_GRAY);
		lblAddress.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblAddress.setBounds(56, 371, 133, 32);
		panel.add(lblAddress);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setForeground(Color.DARK_GRAY);
		lblDateOfBirth.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDateOfBirth.setBounds(56, 323, 88, 20);
		panel.add(lblDateOfBirth);
		
		JLabel lblEmployeeType = new JLabel("Employee Type");
		lblEmployeeType.setForeground(Color.DARK_GRAY);
		lblEmployeeType.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEmployeeType.setBounds(56, 490, 120, 32);
		panel.add(lblEmployeeType);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(new Color(176, 224, 230));
		rdbtnMale.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		rdbtnMale.setBounds(212, 270, 55, 29);
		panel.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(176, 224, 230));
		rdbtnFemale.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		rdbtnFemale.setBounds(336, 270, 71, 29);
		panel.add(rdbtnFemale);
		
		JRadioButton rdbtnFullTime = new JRadioButton("Full Time");
		rdbtnFullTime.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		rdbtnFullTime.setBackground(new Color(176, 224, 230));
		rdbtnFullTime.setBounds(212, 493, 81, 29);
		panel.add(rdbtnFullTime);
		
		JRadioButton rdbtnPartTime = new JRadioButton("Part Time");
		rdbtnPartTime.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		rdbtnPartTime.setBackground(new Color(176, 224, 230));
		rdbtnPartTime.setBounds(336, 493, 85, 29);
		panel.add(rdbtnPartTime);
		
		JDateChooser dcBirth = new JDateChooser();
		dcBirth.setDateFormatString("dd-MM-yyyy");
		dcBirth.setBounds(212, 323, 151, 20);
		panel.add(dcBirth);
		
		JTextArea txtAddress = new JTextArea();
		txtAddress.setRows(3);
		txtAddress.setBounds(212, 371, 267, 59);
		panel.add(txtAddress);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int eid=Integer.parseInt(txtEmployeeId.getText());
				String name=txtEmpName.getText();
				String mail=txtEmail.getText();
				String phone=txtPhoneNumber.getText();
				String address=txtAddress.getText();
				String location=txtLocation.getText();
				String gender="";
				String type="";
				String des=(String)txtDesignation.getSelectedItem();
				SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
				String dob=sdf.format(dcBirth.getDate());
				if(eid!=0 && !txtEmployeeId.getText().isEmpty()) {
					qry="update employee set Employee_Name=?, E_Mail=?, Phone_Number=?, Gender=?, Date_of_Birth=?, Address=?, Designation=?, Employee_Type=?, Location=? where Employee_Id="+eid;
					try {
						st=con.prepareStatement(qry);
						st.setString(1, name);
						st.setString(2, mail);
						st.setString(3, phone);
						if(rdbtnMale.isSelected()) {
							gender="Male";
						}
						if(rdbtnFemale.isSelected()) {
							gender="Female";
						}
						st.setString(4, gender);
						st.setString(5, dob);
						st.setString(6, address);
						st.setString(7, des);
						if(rdbtnFullTime.isSelected()) {
							type="Full Time";
						}
						if(rdbtnPartTime.isSelected()) {
							type="Part Time";
						}
						st.setString(8, type);
						st.setString(9, location);
						st.executeUpdate();
						JOptionPane.showMessageDialog(null, "Employee Details Updated");
				        m.frmMainMenu.setVisible(true);
				        frmUpdateEmployeeManager.dispose();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBackground(new Color(210, 105, 30));
		btnUpdate.setBorder(null);
		btnUpdate.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnUpdate.setBounds(212, 607, 88, 32);
		panel.add(btnUpdate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "Are you sure?","Cancel",JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_OPTION) {
					m.frmMainMenu.setVisible(true);
					frmUpdateEmployeeManager.dispose();
				}
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCancel.setBorder(null);
		btnCancel.setBackground(new Color(210, 105, 30));
		btnCancel.setBounds(391, 607, 88, 32);
		panel.add(btnCancel);
		
		ButtonGroup radioGender=new ButtonGroup();
		radioGender.add(rdbtnMale);
		radioGender.add(rdbtnFemale);
		
		ButtonGroup radioType=new ButtonGroup();
		radioType.add(rdbtnFullTime);
		radioType.add(rdbtnPartTime);
		
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
			        	txtEmpName.setText(rs.getString("Employee_Name"));
			        	txtEmail.setText(rs.getString("E_Mail"));
			        	txtPhoneNumber.setText(rs.getString("Phone_Number"));
			        	String gen=rs.getString("Gender");
			        	if(gen.equalsIgnoreCase("Male")) {
			        		rdbtnMale.setSelected(true);
			        	}
			        	if(gen.equalsIgnoreCase("Female")) {
			        		rdbtnFemale.setSelected(true);
			        	}
			        	String dob=rs.getString("Date_of_Birth");
						try {
							Date sdf = new SimpleDateFormat("dd-MM-yyyy").parse(dob);
							dcBirth.setDate(sdf);
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
			        	txtAddress.setText(rs.getString("Address"));
			        	txtDesignation.setSelectedItem(rs.getString("Designation"));
			        	String type=rs.getString("Employee_Type");
			        	if(type.equalsIgnoreCase("Full Time")) {
			        		rdbtnFullTime.setSelected(true);
			        	}
			        	if(type.equalsIgnoreCase("Part Time")) {
			        		rdbtnPartTime.setSelected(true);
			        	}
			        	txtLocation.setText(rs.getString("Location"));
			        }
		        } catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		txtEmployeeId.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtEmployeeId.setColumns(10);
		txtEmployeeId.setBounds(212, 35, 267, 32);
		panel.add(txtEmployeeId);
		
		JLabel lblEmployeeId = new JLabel("Employee Id");
		lblEmployeeId.setForeground(Color.DARK_GRAY);
		lblEmployeeId.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEmployeeId.setBounds(56, 35, 120, 32);
		panel.add(lblEmployeeId);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setForeground(Color.DARK_GRAY);
		lblDesignation.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDesignation.setBounds(56, 448, 120, 32);
		panel.add(lblDesignation);
		
		txtDesignation = new JComboBox();
		txtDesignation.setEditable(true);
		txtDesignation.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtDesignation.setBounds(212, 455, 268, 32);
		panel.add(txtDesignation);
	}
}
