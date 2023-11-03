package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JCheckBox;

public class RecoveryForm {

	JFrame frmRecovery;
	private JPasswordField txtPass_Recovery;
	private JPasswordField txtConfirm_Recovery;
	String mail;
	LoginForm l=new LoginForm();
	
	String qry="";
	Connection con=null;
	PreparedStatement st=null;
	ResultSet rs=null;
	JFrame frmVerification;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecoveryForm window = new RecoveryForm();
					window.frmRecovery.setVisible(true);
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
	public RecoveryForm() {
		initialize();
		con=MyConnection.getConnection();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRecovery = new JFrame();
		frmRecovery.setIconImage(Toolkit.getDefaultToolkit().getImage(RecoveryForm.class.getResource("/form_icon/RecoveryForm.png")));
		frmRecovery.setTitle("Change Password");
		frmRecovery.setBounds(100, 100, 552, 362);
		frmRecovery.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRecovery.getContentPane().setLayout(null);
		Dimension tk=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(int)((tk.getWidth()-frmRecovery.getWidth())/2);
		int y=(int)((tk.getHeight()-frmRecovery.getHeight())/2);
		frmRecovery.setLocation(x,y);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(0, 0, 537, 325);
		frmRecovery.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPass = new JLabel("Password");
		lblPass.setForeground(Color.DARK_GRAY);
		lblPass.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblPass.setBounds(126, 78, 88, 27);
		panel.add(lblPass);
		
		JLabel lblConfirm = new JLabel("Confirm Password");
		lblConfirm.setForeground(Color.DARK_GRAY);
		lblConfirm.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblConfirm.setBounds(44, 152, 170, 27);
		panel.add(lblConfirm);
		
		txtPass_Recovery = new JPasswordField();
		txtPass_Recovery.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtPass_Recovery.setBounds(237, 78, 212, 27);
		panel.add(txtPass_Recovery);
		
		txtConfirm_Recovery = new JPasswordField();
		txtConfirm_Recovery.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtConfirm_Recovery.setBounds(237, 152, 212, 27);
		panel.add(txtConfirm_Recovery);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBorder(null);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass=String.valueOf(txtPass_Recovery.getPassword());
				String confirm=String.valueOf(txtConfirm_Recovery.getPassword());
				if(pass==null || pass.isEmpty() || pass.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter Password");
				}
				if(!pass.equals(confirm)) {
					JOptionPane.showMessageDialog(null, "Password and Confirm Password must be same");
					txtPass_Recovery.setText("");
					txtConfirm_Recovery.setText("");
				}
				else {
					qry="update user set Password=? where Email=?";
					try {
						st=con.prepareStatement(qry);
						st.setString(1,pass);
						st.setString(2, mail);
						st.executeUpdate();
						JOptionPane.showMessageDialog(null, "Password has been changed!");
						l.frmLoginForm.setVisible(true);
						frmRecovery.dispose();
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
						txtPass_Recovery.setText("");
						txtConfirm_Recovery.setText("");
					}
				}
			}
		});
		btnOk.setBackground(new Color(210, 105, 30));
		btnOk.setForeground(new Color(255, 255, 255));
		btnOk.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnOk.setBounds(172, 239, 110, 32);
		panel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBorder(null);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "Are you sure?","Cancel",JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_OPTION) {
					l.frmLoginForm.setVisible(true);
					frmRecovery.dispose();
				}
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCancel.setBackground(new Color(210, 105, 30));
		btnCancel.setBounds(339, 239, 110, 32);
		panel.add(btnCancel);
		
		JCheckBox chkPass_Recovery = new JCheckBox("Show Password");
		chkPass_Recovery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkPass_Recovery.isSelected()) {
					txtPass_Recovery.setEchoChar((char)0);
					txtConfirm_Recovery.setEchoChar((char)0);
				}
				else {
					txtPass_Recovery.setEchoChar('*');
					txtConfirm_Recovery.setEchoChar('*');
				}
			}
		});
		chkPass_Recovery.setBackground(new Color(176, 224, 230));
		chkPass_Recovery.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		chkPass_Recovery.setBounds(237, 185, 110, 21);
		panel.add(chkPass_Recovery);
	}
}
