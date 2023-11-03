package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;

public class RegisterForm {

	JFrame frmRegister;
	private JTextField txtFname_Reg;
	private JTextField txtLname_Reg;
	private JTextField txtUsername_Reg;
	@SuppressWarnings("rawtypes")
	private JComboBox txtDesignation_Reg;
	private JPasswordField txtPass_Reg;
	LoginForm l=new LoginForm();
	
	String qry="";
	Connection con=null;
	PreparedStatement st=null;
	ResultSet rs=null;
	private JTextField txtEmail_Reg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterForm window = new RegisterForm();
					window.frmRegister.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterForm() {
		initialize();
		con=MyConnection.getConnection();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frmRegister = new JFrame();
		frmRegister.setIconImage(Toolkit.getDefaultToolkit().getImage(RegisterForm.class.getResource("/form_icon/RegisterForm.png")));
		frmRegister.setTitle("Register Form");
		frmRegister.setBounds(100, 100, 487, 582);
		frmRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegister.getContentPane().setLayout(null);
		Dimension tk=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(int)((tk.getWidth()-frmRegister.getWidth())/2);
		int y=(int)((tk.getHeight()-frmRegister.getHeight())/2);
		frmRegister.setLocation(x,y);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 473, 545);
		frmRegister.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(0, 0, 473, 97);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 23));
		lblNewLabel.setBounds(198, 40, 90, 31);
		panel_1.add(lblNewLabel);
		
		JLabel lblFname = new JLabel("First Name");
		lblFname.setForeground(Color.DARK_GRAY);
		lblFname.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblFname.setBounds(35, 114, 93, 25);
		panel.add(lblFname);
		
		JLabel lblLname = new JLabel("Last Name");
		lblLname.setForeground(Color.DARK_GRAY);
		lblLname.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblLname.setBounds(35, 170, 90, 25);
		panel.add(lblLname);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.DARK_GRAY);
		lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblUsername.setBounds(35, 330, 86, 25);
		panel.add(lblUsername);
		
		txtFname_Reg = new JTextField();
		txtFname_Reg.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtFname_Reg.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtFname_Reg.setBounds(164, 114, 264, 25);
		panel.add(txtFname_Reg);
		txtFname_Reg.setColumns(10);
		
		txtLname_Reg = new JTextField();
		txtLname_Reg.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtLname_Reg.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtLname_Reg.setColumns(10);
		txtLname_Reg.setBounds(164, 170, 264, 25);
		panel.add(txtLname_Reg);
		
		txtUsername_Reg = new JTextField();
		txtUsername_Reg.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtUsername_Reg.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtUsername_Reg.setColumns(10);
		txtUsername_Reg.setBounds(164, 330, 264, 25);
		panel.add(txtUsername_Reg);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setForeground(Color.DARK_GRAY);
		lblDesignation.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblDesignation.setBounds(35, 223, 104, 25);
		panel.add(lblDesignation);
		
		txtDesignation_Reg = new JComboBox();
		txtDesignation_Reg.setBackground(new Color(255, 255, 255));
		txtDesignation_Reg.setBorder(null);
		txtDesignation_Reg.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtDesignation_Reg.setModel(new DefaultComboBoxModel(new String[] {"<No Selection>", "Manager", "HR", "Accountant"}));
		txtDesignation_Reg.setBounds(164, 223, 264, 30);
		panel.add(txtDesignation_Reg);
		
		JLabel lblPass = new JLabel("Password");
		lblPass.setForeground(Color.DARK_GRAY);
		lblPass.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblPass.setBounds(35, 377, 81, 25);
		panel.add(lblPass);
		
		txtPass_Reg = new JPasswordField();
		txtPass_Reg.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtPass_Reg.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtPass_Reg.setBounds(164, 377, 264, 25);
		panel.add(txtPass_Reg);
		
		JButton btnRegister_Reg = new JButton("Register");
		btnRegister_Reg.setBorder(null);
		btnRegister_Reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname=txtUsername_Reg.getText();
				String pass=String.valueOf(txtPass_Reg.getPassword());
				String fname=txtFname_Reg.getText();
				String lname=txtLname_Reg.getText();
				String desig=(String)txtDesignation_Reg.getSelectedItem();
				String email=txtEmail_Reg.getText();
				if(fname==null || fname.isEmpty() || fname.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter First Name");
					txtFname_Reg.requestFocus();
					return;
				}
				if(lname==null || lname.isEmpty() || lname.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Last Name");
					txtLname_Reg.requestFocus();
					return;
				}
				if(desig.equalsIgnoreCase("<No Selection>")) {
					JOptionPane.showMessageDialog(null, "Please Select Designation");
					txtDesignation_Reg.requestFocus();
					return;
				}
				if(email==null || email.isEmpty() || email.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Email Id");
					txtEmail_Reg.requestFocus();
					return;
				}
				if(uname==null || uname.isEmpty() || uname.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Username");
					txtUsername_Reg.requestFocus();
					return;
				}
				if(pass==null || pass.isEmpty() || pass.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Password");
					txtPass_Reg.requestFocus();
					return;
				}
				else {
					qry="insert into user (Fname,Lname,Designation,Email,Username,Password) values (?,?,?,?,?,?);";
					try {
						st=con.prepareStatement(qry);
						st.setString(1, txtFname_Reg.getText());
						st.setString(2, txtLname_Reg.getText());
						st.setString(3, (String)txtDesignation_Reg.getSelectedItem());
						st.setString(4,txtEmail_Reg.getText());
						st.setString(5, txtUsername_Reg.getText());
						st.setString(6, String.valueOf(txtPass_Reg.getPassword()));
						st.executeUpdate();
						JOptionPane.showMessageDialog(null, "Register Success");
						l.frmLoginForm.setVisible(true);
						frmRegister.dispose();
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				}
			}
		});
		btnRegister_Reg.setBackground(new Color(100, 149, 237));
		btnRegister_Reg.setForeground(Color.WHITE);
		btnRegister_Reg.setFont(new Font("Segoe UI", Font.BOLD, 19));
		btnRegister_Reg.setBounds(39, 435, 389, 32);
		panel.add(btnRegister_Reg);
		
		JLabel lblNewLabel_1 = new JLabel("Already have an account?");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_1.setBounds(164, 479, 142, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Log In Now");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				l.frmLoginForm.setVisible(true);
				frmRegister.dispose();
			}
		});
		lblNewLabel_1_1.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(190, 512, 78, 20);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblEmail = new JLabel("Email Id");
		lblEmail.setForeground(Color.DARK_GRAY);
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblEmail.setBounds(35, 276, 69, 25);
		panel.add(lblEmail);
		
		txtEmail_Reg = new JTextField();
		txtEmail_Reg.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtEmail_Reg.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtEmail_Reg.setColumns(10);
		txtEmail_Reg.setBounds(164, 276, 264, 25);
		panel.add(txtEmail_Reg);
		
		JCheckBox chkPass_Reg = new JCheckBox("Show Password");
		chkPass_Reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkPass_Reg.isSelected()) {
					txtPass_Reg.setEchoChar((char)0);
				}
				else {
					txtPass_Reg.setEchoChar('*');
				}
			}
		});
		chkPass_Reg.setBackground(new Color(255, 255, 255));
		chkPass_Reg.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		chkPass_Reg.setBounds(164, 408, 110, 21);
		panel.add(chkPass_Reg);
	}
}
