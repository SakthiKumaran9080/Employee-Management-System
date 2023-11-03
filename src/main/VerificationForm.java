package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Toolkit;


public class VerificationForm {

	String qry="";
	Connection con=null;
	PreparedStatement st=null;
	ResultSet rs=null;
	JFrame frmVerification;
	JTextField txtMail_Verify;
	RecoveryForm r=new RecoveryForm();
	LoginForm l=new LoginForm();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerificationForm window = new VerificationForm();
					window.frmVerification.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public VerificationForm() {
		initialize();
		con=MyConnection.getConnection();
	}
	private void initialize() {
		frmVerification = new JFrame();
		frmVerification.setIconImage(Toolkit.getDefaultToolkit().getImage(VerificationForm.class.getResource("/form_icon/VerificationForm.png")));
		frmVerification.setTitle("Verification");
		frmVerification.getContentPane().setBackground(new Color(255, 255, 255));
		frmVerification.setBounds(100, 100, 450, 300);
		frmVerification.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVerification.getContentPane().setLayout(null);
		Dimension tk=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(int)((tk.getWidth()-frmVerification.getWidth())/2);
		int y=(int)((tk.getHeight()-frmVerification.getHeight())/2);
		frmVerification.setLocation(x,y);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBorder(null);
		btnOk.setForeground(new Color(255, 255, 255));
		btnOk.setBackground(new Color(210, 105, 30));
		btnOk.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mail=txtMail_Verify.getText();
				if(mail==null || mail.isEmpty() || mail.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Email");
				}
				else {
					qry="select * from user";
					try {
						st=con.prepareStatement(qry);
						rs=st.executeQuery();
						if(rs.next()) {
							if(!mail.equals(rs.getString("Email"))) {
								JOptionPane.showMessageDialog(null, "Please Check your Email");
							}
							else {
								r.frmRecovery.setVisible(true);
								frmVerification.dispose();
							}
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnOk.setBounds(121, 155, 89, 32);
		frmVerification.getContentPane().add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBorder(null);
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setBackground(new Color(210, 105, 30));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "Are you sure?","Cancel",JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_OPTION) {
					l.frmLoginForm.setVisible(true);
					frmVerification.dispose();
				}
			}
		});
		btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCancel.setBounds(220, 155, 89, 32);
		frmVerification.getContentPane().add(btnCancel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(0, 0, 436, 263);
		frmVerification.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtMail_Verify = new JTextField();
		txtMail_Verify.setHorizontalAlignment(SwingConstants.CENTER);
		txtMail_Verify.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMail_Verify.setBounds(93, 103, 251, 30);
		panel.add(txtMail_Verify);
		txtMail_Verify.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Recovery Email");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBounds(135, 51, 159, 30);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel.setBackground(new Color(255, 255, 255));
	}
}
