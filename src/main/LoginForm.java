package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Toolkit;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm {

	JFrame frmLoginForm;
	private JTextField txtUname_Log;
	private JPasswordField txtPass_Log;
	private JLabel lblNewLabel_3;
	VerificationForm v=new VerificationForm();
	MainMenu m=new MainMenu();
	RegisterForm r=new RegisterForm();
	
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
					LoginForm window = new LoginForm();
					window.frmLoginForm.setVisible(true);
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
	public LoginForm() {
		initialize();
		con=MyConnection.getConnection();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginForm = new JFrame();
		frmLoginForm.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginForm.class.getResource("/form_icon/LoginForm.png")));
		frmLoginForm.setLocation(new Point(1000, 1000));
		frmLoginForm.setTitle("Login Form");
		frmLoginForm.setBounds(100, 100, 444, 516);
		frmLoginForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginForm.getContentPane().setLayout(null);
		Dimension tk=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(int)((tk.getWidth()-frmLoginForm.getWidth())/2);
		int y=(int)((tk.getHeight()-frmLoginForm.getHeight())/2);
		frmLoginForm.setLocation(x,y);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 0, 430, 479);
		frmLoginForm.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(100, 149, 237));
		headerPanel.setBounds(0, 0, 430, 89);
		mainPanel.add(headerPanel);
		headerPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login here!");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(148, 33, 140, 36);
		headerPanel.add(lblNewLabel);
		
		JLabel lblUname = new JLabel("Username (or) Email");
		lblUname.setForeground(Color.DARK_GRAY);
		lblUname.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblUname.setBounds(80, 134, 174, 25);
		mainPanel.add(lblUname);
		
		JLabel lblPass = new JLabel("Password");
		lblPass.setForeground(Color.DARK_GRAY);
		lblPass.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblPass.setBounds(80, 197, 81, 25);
		mainPanel.add(lblPass);
		
		txtUname_Log = new JTextField();
		txtUname_Log.setForeground(Color.BLACK);
		txtUname_Log.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtUname_Log.setBounds(80, 162, 268, 25);
		mainPanel.add(txtUname_Log);
		txtUname_Log.setColumns(10);
		
		txtPass_Log = new JPasswordField();
		txtPass_Log.setForeground(Color.BLACK);
		txtPass_Log.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtPass_Log.setBounds(80, 227, 268, 25);
		mainPanel.add(txtPass_Log);
		
		JLabel lblNewLabel_1 = new JLabel("Forgot");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setBounds(226, 289, 45, 20);
		mainPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password?");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.frmVerification.setVisible(true);
				frmLoginForm.dispose();
			}
		});
		lblNewLabel_1_1.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(278, 289, 70, 20);
		mainPanel.add(lblNewLabel_1_1);
		
		JButton btnLogin_Log = new JButton("Log In");
		btnLogin_Log.setBorder(null);
		btnLogin_Log.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String uname=txtUname_Log.getText();
				String pass=String.valueOf(txtPass_Log.getPassword());
				if(uname.equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Please Enter Username");
					txtUname_Log.requestFocus();
					return;
				}
				if(pass.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter Password");
					txtPass_Log.requestFocus();
					return;
				}
				else {
					qry="select * from user where (Username=? or Email=?) and Password=?";
					try {
						st=con.prepareStatement(qry);
						st.setString(1, uname);
						st.setString(2, uname);
						st.setString(3, pass);
						rs=st.executeQuery();
						if(rs.next()) {
							JOptionPane.showMessageDialog(null, "Login Success");
							m.lblEmpName_Main.setText(rs.getString(2));
							m.lblDesignation_Main.setText(rs.getString("Designation"));
							m.frmMainMenu.setVisible(true);
							frmLoginForm.dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Login Failed");
							txtUname_Log.setText("");
							txtPass_Log.setText("");
						}
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				}
			}
		});
		btnLogin_Log.setBackground(new Color(100, 149, 237));
		btnLogin_Log.setForeground(new Color(255, 255, 255));
		btnLogin_Log.setFont(new Font("Segoe UI", Font.BOLD, 19));
		btnLogin_Log.setBounds(80, 327, 268, 44);
		mainPanel.add(btnLogin_Log);
		
		JLabel lblNewLabel_2 = new JLabel("Don't have an account?");
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_2.setBounds(141, 397, 160, 20);
		mainPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Register here!");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				r.frmRegister.setVisible(true);
				frmLoginForm.dispose();
			}
		});
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_3.setForeground(new Color(100, 149, 237));
		lblNewLabel_3.setBounds(169, 427, 95, 20);
		mainPanel.add(lblNewLabel_3);
		
		JCheckBox chkPass_Log = new JCheckBox("Show Password");
		chkPass_Log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkPass_Log.isSelected()) {
					txtPass_Log.setEchoChar((char)0);
				}
				else {
					txtPass_Log.setEchoChar('*');
				}
			}
		});
		chkPass_Log.setBackground(Color.WHITE);
		chkPass_Log.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		chkPass_Log.setBounds(80, 258, 99, 21);
		mainPanel.add(chkPass_Log);
	}
}
