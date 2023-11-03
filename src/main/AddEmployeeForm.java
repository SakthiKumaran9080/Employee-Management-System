package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class AddEmployeeForm {

	JFrame frmAddEmployee;
	private JTextField txtEmpName_Add;
	private JTextField txtEmail_Add;
	private JTextField txtPhone_Add;
	private JTextField txtSalary_Add;
	private JTextField txtLocation_Add;
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
					AddEmployeeForm window = new AddEmployeeForm();
					window.frmAddEmployee.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddEmployeeForm() {
		initialize();
		con=MyConnection.getConnection();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frmAddEmployee = new JFrame();
		frmAddEmployee.setIconImage(Toolkit.getDefaultToolkit().getImage(AddEmployeeForm.class.getResource("/form_icon/AddEmployeeForm.png")));
		frmAddEmployee.setTitle("Add Employee");
		frmAddEmployee.setBounds(100, 100, 597, 696);
		frmAddEmployee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddEmployee.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(0, 0, 583, 659);
		frmAddEmployee.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEmpName = new JLabel("Employee Name");
		lblEmpName.setForeground(Color.DARK_GRAY);
		lblEmpName.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEmpName.setBounds(35, 47, 110, 20);
		panel.add(lblEmpName);
		
		txtEmpName_Add = new JTextField();
		txtEmpName_Add.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtEmpName_Add.setBounds(207, 47, 304, 20);
		panel.add(txtEmpName_Add);
		txtEmpName_Add.setColumns(10);
		
		txtEmail_Add = new JTextField();
		txtEmail_Add.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtEmail_Add.setColumns(10);
		txtEmail_Add.setBounds(207, 88, 304, 20);
		panel.add(txtEmail_Add);
		
		JLabel lblEmail = new JLabel("Email Id");
		lblEmail.setForeground(Color.DARK_GRAY);
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEmail.setBounds(35, 88, 110, 20);
		panel.add(lblEmail);
		
		txtPhone_Add = new JTextField();
		txtPhone_Add.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtPhone_Add.setColumns(10);
		txtPhone_Add.setBounds(207, 129, 304, 20);
		panel.add(txtPhone_Add);
		
		JLabel lblPhone = new JLabel("Phone Number");
		lblPhone.setForeground(Color.DARK_GRAY);
		lblPhone.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPhone.setBounds(35, 129, 110, 20);
		panel.add(lblPhone);
		
		txtSalary_Add = new JTextField();
		txtSalary_Add.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSalary_Add.setColumns(10);
		txtSalary_Add.setBounds(207, 548, 304, 20);
		panel.add(txtSalary_Add);
		
		JLabel lblSalary = new JLabel("Basic Salary P/A");
		lblSalary.setForeground(Color.DARK_GRAY);
		lblSalary.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSalary.setBounds(35, 548, 110, 20);
		panel.add(lblSalary);
		
		JLabel lblAddress = new JLabel("Permenant Address");
		lblAddress.setForeground(Color.DARK_GRAY);
		lblAddress.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblAddress.setBounds(35, 263, 133, 20);
		panel.add(lblAddress);
		
		JTextArea txtAddress_Add = new JTextArea();
		txtAddress_Add.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtAddress_Add.setLineWrap(true);
		txtAddress_Add.setRows(3);
		txtAddress_Add.setBounds(207, 263, 293, 78);
		panel.add(txtAddress_Add);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.DARK_GRAY);
		lblGender.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblGender.setBounds(35, 174, 110, 20);
		panel.add(lblGender);
		
		JRadioButton radioMale_Add = new JRadioButton("Male");
		radioMale_Add.setSelected(true);
		radioMale_Add.setBackground(new Color(176, 224, 230));
		radioMale_Add.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		radioMale_Add.setBounds(207, 170, 55, 29);
		panel.add(radioMale_Add);
		
		JRadioButton radioFemale_Add = new JRadioButton("Female");
		radioFemale_Add.setBackground(new Color(176, 224, 230));
		radioFemale_Add.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		radioFemale_Add.setBounds(278, 170, 71, 29);
		panel.add(radioFemale_Add);
		
		JDateChooser dcBirth_Add = new JDateChooser();
		dcBirth_Add.setDateFormatString("dd-MM-yyyy");
		dcBirth_Add.setBounds(207, 219, 141, 20);
		panel.add(dcBirth_Add);
		
		JLabel lblDateBirth = new JLabel("Date of Birth");
		lblDateBirth.setForeground(Color.DARK_GRAY);
		lblDateBirth.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDateBirth.setBounds(35, 219, 110, 20);
		panel.add(lblDateBirth);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setForeground(Color.DARK_GRAY);
		lblDesignation.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDesignation.setBounds(35, 375, 133, 20);
		panel.add(lblDesignation);
		
		JComboBox comboDesignation_Add = new JComboBox();
		comboDesignation_Add.setBackground(new Color(255, 255, 255));
		comboDesignation_Add.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboDesignation_Add.setModel(new DefaultComboBoxModel(new String[] {"<No Selection>", "Associate Software Engineer", "UI/UX Designer", "FrontEnd Developer", "Java Developer", "Web Developer", "Data Analyst", "Tester", "Admin"}));
		comboDesignation_Add.setBounds(207, 372, 210, 26);
		panel.add(comboDesignation_Add);
		
		JLabel lblType = new JLabel("Employee Type");
		lblType.setForeground(Color.DARK_GRAY);
		lblType.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblType.setBounds(35, 420, 110, 20);
		panel.add(lblType);
		
		JRadioButton radioFull_Add = new JRadioButton("Full Time");
		radioFull_Add.setSelected(true);
		radioFull_Add.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		radioFull_Add.setBackground(new Color(176, 224, 230));
		radioFull_Add.setBounds(207, 416, 81, 29);
		panel.add(radioFull_Add);
		
		JRadioButton radioPart_Add = new JRadioButton("Part Time");
		radioPart_Add.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		radioPart_Add.setBackground(new Color(176, 224, 230));
		radioPart_Add.setBounds(300, 416, 85, 29);
		panel.add(radioPart_Add);
		
		JLabel lblDateJoin = new JLabel("Date of Joining");
		lblDateJoin.setForeground(Color.DARK_GRAY);
		lblDateJoin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDateJoin.setBounds(36, 463, 110, 20);
		panel.add(lblDateJoin);
		
		JDateChooser dcJoin_Add = new JDateChooser();
		dcJoin_Add.setDateFormatString("dd-MM-yyyy");
		dcJoin_Add.setBounds(208, 463, 141, 20);
		panel.add(dcJoin_Add);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setForeground(Color.DARK_GRAY);
		lblLocation.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblLocation.setBounds(35, 504, 110, 20);
		panel.add(lblLocation);
		
		txtLocation_Add = new JTextField();
		txtLocation_Add.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtLocation_Add.setColumns(10);
		txtLocation_Add.setBounds(207, 504, 304, 20);
		panel.add(txtLocation_Add);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=txtEmpName_Add.getText();
				String mail=txtEmail_Add.getText();
				String phone=txtPhone_Add.getText();
				String address=txtAddress_Add.getText();
				String desig=(String)comboDesignation_Add.getSelectedItem();
				String location=txtLocation_Add.getText();
				String salary=txtSalary_Add.getText();
				String gender="";
				String type="";
				SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
				String dob=sdf.format(dcBirth_Add.getDate());
				String doj=sdf.format(dcJoin_Add.getDate());
				double bsalary=Double.parseDouble(txtSalary_Add.getText());
				if(name==null || name.isEmpty() || name.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Employee Name");
					txtEmpName_Add.requestFocus();
					return;
				}
				if(mail==null || mail.isEmpty() || mail.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Email");
					txtEmail_Add.requestFocus();
					return;
				}
				if(phone==null || phone.isEmpty() || phone.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Phone Number");
					txtPhone_Add.requestFocus();
					return;
				}
				if(dob==null || dob.isEmpty() || dob.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Select Date of Birth");
				}
				if(address==null || address.isEmpty() || address.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Permenant Address");
					txtAddress_Add.requestFocus();
					return;
				}
				if(desig.equalsIgnoreCase("<No Selection>")) {
					JOptionPane.showMessageDialog(null, "Please Select Designation");
					comboDesignation_Add.requestFocus();
					return;
				}
				if(doj==null || doj.isEmpty() || doj.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Select Date of Joining");
				}
				if(location==null || location.isEmpty() || location.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Location");
					txtLocation_Add.requestFocus();
					return;
				}
				if(salary==null || salary.isEmpty() || salary.trim().isEmpty() || bsalary==0) {
					JOptionPane.showMessageDialog(null, "Please Enter Basic Salary Per Annum");
					txtSalary_Add.requestFocus();
					return;
				}
				else {
					qry = "insert into employee(Employee_Name,E_Mail,Phone_Number,Gender,Date_of_Birth,Address,Designation,Employee_Type,Date_of_Joining,Location,BasicSalary) values(?,?,?,?,?,?,?,?,?,?,?)";
			        try {
						st = con.prepareStatement(qry);
				        st.setString(1,name);
				        st.setString(2,mail);
				        st.setString(3,phone);
				        if(radioMale_Add.isSelected()) {
							gender="Male";
						}
						if(radioFemale_Add.isSelected()) {
							gender="Female";
						}
				        st.setString(4,gender);
				        st.setString(5,dob);
				        st.setString(6,address);
				        st.setString(7,desig);
				        if(radioFull_Add.isSelected()) {
							type="Full Time";
						}
						if(radioPart_Add.isSelected()) {
							type="Part Time";
						}
				        st.setString(8,type);
				        st.setString(9,doj);
				        st.setString(10,location);
				        st.setDouble(11,bsalary);
				        st.executeUpdate();
				        JOptionPane.showMessageDialog(null, "Employee Details Added");
				        m.frmMainMenu.setVisible(true);
				        frmAddEmployee.dispose();
			        } catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnSave.setForeground(new Color(255, 255, 255));
		btnSave.setBackground(new Color(210, 105, 30));
		btnSave.setBorder(null);
		btnSave.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnSave.setBounds(207, 595, 101, 29);
		panel.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "Are you sure?","Cancel",JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_OPTION) {
			        m.frmMainMenu.setVisible(true);
			        frmAddEmployee.dispose();
				}
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCancel.setBorder(null);
		btnCancel.setBackground(new Color(210, 105, 30));
		btnCancel.setBounds(410, 595, 101, 29);
		panel.add(btnCancel);
		
		ButtonGroup radioGender=new ButtonGroup();
		radioGender.add(radioMale_Add);
		radioGender.add(radioFemale_Add);
		
		ButtonGroup radioType=new ButtonGroup();
		radioType.add(radioFull_Add);
		radioType.add(radioPart_Add);
	}
}
