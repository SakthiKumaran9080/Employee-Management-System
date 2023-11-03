package main;

import java.awt.EventQueue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SalarySlip {
	JFrame frmSalarySlip;
	String qry="";
	Connection con=null;
	PreparedStatement st=null;
	ResultSet rs=null;
	JLabel lblEmpId1;
	JLabel lblEmpName;
	JLabel lblEmpDesignation;
	JLabel lblDate1;
	JLabel lblTime1;
	JLabel lblSalary;
	JLabel lblSalary1;
	JLabel llblNetPay1;
	JLabel lblTotalDeductions1;
	JLabel lblProvidentFund1;
	JLabel lblInsurence1;
	JLabel lblProfessionalTax1;
	JLabel lblGrossSalary1;
	JLabel lblRentAllowences1;
	JLabel lblMedicalAllowences1;
	MainMenu m=new MainMenu();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalarySlip window = new SalarySlip();
					window.frmSalarySlip.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public SalarySlip() {
		initialize();
		con=MyConnection.getConnection();
	}

	private void initialize() {
		frmSalarySlip = new JFrame();
		frmSalarySlip.setTitle("Salary Slip");
		frmSalarySlip.setBounds(100, 100, 829, 568);
		frmSalarySlip.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSalarySlip.getContentPane().setLayout(null);
		Dimension tk=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(int)((tk.getWidth()-frmSalarySlip.getWidth())/2);
		int y=(int)((tk.getHeight()-frmSalarySlip.getHeight())/2);
		frmSalarySlip.setLocation(x,y);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(0, 0, 813, 531);
		frmSalarySlip.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Salary Slip");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTitle.setBounds(345, 22, 102, 27);
		panel.add(lblTitle);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setForeground(Color.DARK_GRAY);
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblDate.setBounds(540, 75, 41, 21);
		panel.add(lblDate);
		
		JLabel lblTime = new JLabel("Time : ");
		lblTime.setForeground(Color.DARK_GRAY);
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTime.setBounds(540, 107, 46, 21);
		panel.add(lblTime);
		
		lblSalary = new JLabel("Salary : ");
		lblSalary.setForeground(Color.DARK_GRAY);
		lblSalary.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSalary.setBounds(57, 281, 55, 21);
		panel.add(lblSalary);
		
		JLabel lblMedicalAllowences = new JLabel("Medical Allowences : ");
		lblMedicalAllowences.setForeground(Color.DARK_GRAY);
		lblMedicalAllowences.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMedicalAllowences.setBounds(57, 329, 146, 20);
		panel.add(lblMedicalAllowences);
		
		JLabel lblDeductions = new JLabel("Total Deductions : ");
		lblDeductions.setForeground(Color.DARK_GRAY);
		lblDeductions.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDeductions.setBounds(459, 416, 128, 20);
		panel.add(lblDeductions);
		
		JLabel lblRentAllowences = new JLabel("Rent Allowences :");
		lblRentAllowences.setForeground(Color.DARK_GRAY);
		lblRentAllowences.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblRentAllowences.setBounds(57, 370, 121, 20);
		panel.add(lblRentAllowences);
		
		JLabel lblProfessionalTax = new JLabel("Professional Tax : ");
		lblProfessionalTax.setForeground(Color.DARK_GRAY);
		lblProfessionalTax.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblProfessionalTax.setBounds(459, 281, 124, 20);
		panel.add(lblProfessionalTax);
		
		JLabel lblInsurence = new JLabel("Insurence : ");
		lblInsurence.setForeground(Color.DARK_GRAY);
		lblInsurence.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblInsurence.setBounds(459, 328, 78, 20);
		panel.add(lblInsurence);
		
		JLabel lblProvidentFund = new JLabel("Provident Fund : ");
		lblProvidentFund.setForeground(Color.DARK_GRAY);
		lblProvidentFund.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblProvidentFund.setBounds(459, 370, 116, 20);
		panel.add(lblProvidentFund);
		
		JLabel lblGrossSalary = new JLabel("Gross salary : ");
		lblGrossSalary.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblGrossSalary.setBounds(56, 416, 94, 20);
		panel.add(lblGrossSalary);
		
		JLabel lblEmpId = new JLabel("Employee Id :");
		lblEmpId.setForeground(Color.DARK_GRAY);
		lblEmpId.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblEmpId.setBounds(33, 75, 95, 21);
		panel.add(lblEmpId);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setForeground(Color.DARK_GRAY);
		lblName.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblName.setBounds(33, 113, 78, 21);
		panel.add(lblName);
		
		JLabel lblDesignation = new JLabel("Designation : ");
		lblDesignation.setForeground(Color.DARK_GRAY);
		lblDesignation.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblDesignation.setBounds(33, 153, 98, 21);
		panel.add(lblDesignation);
		
		JLabel lblTopic1 = new JLabel("Allowences");
		lblTopic1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTopic1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblTopic1.setBounds(133, 210, 96, 25);
		panel.add(lblTopic1);
		
		JLabel lbltopic = new JLabel("Deduction");
		lbltopic.setHorizontalAlignment(SwingConstants.CENTER);
		lbltopic.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lbltopic.setBounds(540, 210, 96, 25);
		panel.add(lbltopic);
		
		JLabel lblNetPay = new JLabel("Net Pay : ");
		lblNetPay.setForeground(Color.DARK_GRAY);
		lblNetPay.setHorizontalAlignment(SwingConstants.CENTER);
		lblNetPay.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNetPay.setBounds(540, 468, 66, 20);
		panel.add(lblNetPay);
		
		JLabel lblNewLabel = new JLabel("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		lblNewLabel.setBounds(33, 243, 745, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		lblNewLabel_1.setBounds(33, 498, 745, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		lblNewLabel_1_1.setBounds(33, 446, 745, 14);
		panel.add(lblNewLabel_1_1);
		
		lblEmpId1 = new JLabel("");
		lblEmpId1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblEmpId1.setBounds(133, 72, 156, 28);
		panel.add(lblEmpId1);
		
		lblEmpName = new JLabel("");
		lblEmpName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblEmpName.setBounds(90, 110, 226, 28);
		panel.add(lblEmpName);
		
		lblEmpDesignation = new JLabel("");
		lblEmpDesignation.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblEmpDesignation.setBounds(133, 150, 252, 28);
		panel.add(lblEmpDesignation);
		
		lblDate1 = new JLabel("");
		lblDate1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblDate1.setBounds(591, 76, 116, 20);
		panel.add(lblDate1);
		
		lblTime1 = new JLabel("");
		lblTime1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTime1.setBounds(591, 108, 126, 20);
		panel.add(lblTime1);
		
		lblSalary1 = new JLabel("");
		lblSalary1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSalary1.setBounds(110, 281, 172, 21);
		panel.add(lblSalary1);
		
		lblMedicalAllowences1 = new JLabel("");
		lblMedicalAllowences1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMedicalAllowences1.setBounds(202, 329, 172, 21);
		panel.add(lblMedicalAllowences1);
		
		lblRentAllowences1 = new JLabel("");
		lblRentAllowences1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblRentAllowences1.setBounds(179, 370, 172, 21);
		panel.add(lblRentAllowences1);
		
		lblGrossSalary1 = new JLabel("");
		lblGrossSalary1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGrossSalary1.setBounds(149, 416, 156, 21);
		panel.add(lblGrossSalary1);
		
		lblProfessionalTax1 = new JLabel("");
		lblProfessionalTax1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblProfessionalTax1.setBounds(583, 281, 156, 21);
		panel.add(lblProfessionalTax1);
		
		lblInsurence1 = new JLabel("");
		lblInsurence1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblInsurence1.setBounds(540, 329, 172, 21);
		panel.add(lblInsurence1);
		
		lblProvidentFund1 = new JLabel("");
		lblProvidentFund1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblProvidentFund1.setBounds(583, 370, 172, 21);
		panel.add(lblProvidentFund1);
		
		lblTotalDeductions1 = new JLabel("");
		lblTotalDeductions1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTotalDeductions1.setBounds(583, 416, 172, 21);
		panel.add(lblTotalDeductions1);
		
		llblNetPay1 = new JLabel("");
		llblNetPay1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		llblNetPay1.setBounds(605, 468, 143, 21);
		panel.add(llblNetPay1);
		
		JLabel lblNewLabel_2 = new JLabel("Back");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				m.frmMainMenu.setVisible(true);
				frmSalarySlip.dispose();
			}
		});
		lblNewLabel_2.setForeground(new Color(210, 105, 30));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_2.setBounds(758, 10, 45, 13);
		panel.add(lblNewLabel_2);
	}
}
