package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.awt.Toolkit;

public class MainMenu {

	JFrame frmMainMenu;
	JLabel lblDetails_Main;
	JLabel lblDetails_1_Main;
	JLabel lblUpdate_Main;
	JLabel lblUpdate_1_Main;
	JLabel lblEmpName_Main;
	JLabel lblDesignation_Main;
	JLabel lblEmpId_Main;
	LoginForm l=new LoginForm();
	AddEmployeeForm a=new AddEmployeeForm();
	DeleteEmployeeForm d=new DeleteEmployeeForm();
	EmployeeDetails ed=new EmployeeDetails();
	EmployeeId eid=new EmployeeId();
	SalarySlip s=new SalarySlip();
	UpdateEmployeeFormHr uh=new UpdateEmployeeFormHr();
	UpdateEmployeeFormManager um=new UpdateEmployeeFormManager();
	UpdateSalaryForm us=new UpdateSalaryForm();
	
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
					MainMenu window = new MainMenu();
					window.frmMainMenu.setVisible(true);
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
	public MainMenu() {
		initialize();
		con=MyConnection.getConnection();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainMenu = new JFrame();
		frmMainMenu.setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu.class.getResource("/form_icon/MainMenu.png")));
		frmMainMenu.setTitle("Main Menu");
		frmMainMenu.setBounds(100, 100, 1031, 662);
		frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainMenu.getContentPane().setLayout(null);
		Dimension tk=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(int)((tk.getWidth()-frmMainMenu.getWidth())/2);
		int y=(int)((tk.getHeight()-frmMainMenu.getHeight())/2);
		frmMainMenu.setLocation(x,y);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 1017, 625);
		frmMainMenu.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel sidePanel = new JPanel();
		sidePanel.setBackground(new Color(102, 205, 170));
		sidePanel.setBounds(0, 0, 160, 625);
		mainPanel.add(sidePanel);
		sidePanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainMenu.class.getResource("/icon/User_Add.png")));
		lblNewLabel.setBorder(null);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 136, 128);
		sidePanel.add(lblNewLabel);
		
		lblEmpName_Main = new JLabel("");
		lblEmpName_Main.setForeground(Color.DARK_GRAY);
		lblEmpName_Main.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEmpName_Main.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpName_Main.setBounds(10, 148, 136, 20);
		sidePanel.add(lblEmpName_Main);
		
		lblDesignation_Main = new JLabel("");
		lblDesignation_Main.setForeground(Color.DARK_GRAY);
		lblDesignation_Main.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesignation_Main.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDesignation_Main.setBounds(10, 178, 136, 20);
		sidePanel.add(lblDesignation_Main);
		
		JLabel lblLogout_Main = new JLabel("Log Out");
		lblLogout_Main.setForeground(Color.DARK_GRAY);
		lblLogout_Main.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				l.frmLoginForm.setVisible(true);
				frmMainMenu.dispose();
			}
		});
		lblLogout_Main.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout_Main.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblLogout_Main.setBounds(48, 568, 54, 20);
		sidePanel.add(lblLogout_Main);
		
		lblEmpId_Main = new JLabel("");
		lblEmpId_Main.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpId_Main.setForeground(Color.DARK_GRAY);
		lblEmpId_Main.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEmpId_Main.setBounds(40, 148, 84, 20);
		sidePanel.add(lblEmpId_Main);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(null);
		panel.setBounds(159, 77, 858, 548);
		mainPanel.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(58, 86, 154, 141);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAdd_Main = new JLabel("");
		lblAdd_Main.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a.frmAddEmployee.setVisible(true);
				frmMainMenu.dispose();
			}
		});
		lblAdd_Main.setBounds(31, 10, 101, 91);
		panel_1.add(lblAdd_Main);
		lblAdd_Main.setIcon(new ImageIcon(MainMenu.class.getResource("/icon/Add_Icon.png")));
		lblAdd_Main.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblAdd_1_Main = new JLabel("Add Employee");
		lblAdd_1_Main.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a.frmAddEmployee.setVisible(true);
				frmMainMenu.dispose();
			}
		});
		lblAdd_1_Main.setForeground(new Color(184, 134, 11));
		lblAdd_1_Main.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblAdd_1_Main.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd_1_Main.setBounds(31, 111, 98, 20);
		panel_1.add(lblAdd_1_Main);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1_1.setBounds(266, 86, 154, 141);
		panel.add(panel_1_1);
		
		lblUpdate_Main = new JLabel("");
		lblUpdate_Main.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String des=lblDesignation_Main.getText();
				if(des.equals("HR")) {
					uh.frmUpdateEmployeeHr.setVisible(true);
					frmMainMenu.dispose();
				}
				else if(des.equals("Manager")){
					um.frmUpdateEmployeeManager.setVisible(true);
					frmMainMenu.dispose();
				}
			}
		});
		lblUpdate_Main.setIcon(new ImageIcon(MainMenu.class.getResource("/icon/Update_Icon.png")));
		lblUpdate_Main.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate_Main.setBounds(31, 10, 101, 91);
		panel_1_1.add(lblUpdate_Main);
		
		lblUpdate_1_Main = new JLabel("Update Employee");
		lblUpdate_1_Main.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String des=lblDesignation_Main.getText();
				if(des.equals("HR")) {
					uh.frmUpdateEmployeeHr.setVisible(true);
					frmMainMenu.dispose();
				}
				else if(des.equals("Manager")){
					um.frmUpdateEmployeeManager.setVisible(true);
					frmMainMenu.dispose();
				}
			}
		});
		lblUpdate_1_Main.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate_1_Main.setForeground(new Color(184, 134, 11));
		lblUpdate_1_Main.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblUpdate_1_Main.setBounds(10, 111, 134, 20);
		panel_1_1.add(lblUpdate_1_Main);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(Color.LIGHT_GRAY);
		panel_1_2.setBounds(471, 86, 154, 141);
		panel.add(panel_1_2);
		
		JLabel lblDelete_Main = new JLabel("");
		lblDelete_Main.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String des=lblDesignation_Main.getText();
				if(des.equals("HR")) {
					d.frmDeleteEmployee.setVisible(true);
					frmMainMenu.dispose();
				}
			}
		});
		lblDelete_Main.setIcon(new ImageIcon(MainMenu.class.getResource("/icon/Delete_Icon.png")));
		lblDelete_Main.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete_Main.setBounds(31, 10, 101, 91);
		panel_1_2.add(lblDelete_Main);
		
		JLabel lblDelete_1_Main = new JLabel("Delete Employee");
		lblDelete_1_Main.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String des=lblDesignation_Main.getText();
				if(des.equals("HR")) {
					d.frmDeleteEmployee.setVisible(true);
					frmMainMenu.dispose();
				}
			}
		});
		lblDelete_1_Main.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete_1_Main.setForeground(new Color(184, 134, 11));
		lblDelete_1_Main.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDelete_1_Main.setBounds(10, 111, 135, 20);
		panel_1_2.add(lblDelete_1_Main);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBackground(Color.LIGHT_GRAY);
		panel_1_3.setBounds(676, 86, 154, 141);
		panel.add(panel_1_3);
		
		lblDetails_Main = new JLabel("");
		lblDetails_Main.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ed.frmEmployeeDetails.setVisible(true);
				frmMainMenu.dispose();
			}
		});
		lblDetails_Main.setIcon(new ImageIcon(MainMenu.class.getResource("/icon/Report_Icon.png")));
		lblDetails_Main.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetails_Main.setBounds(31, 10, 101, 91);
		panel_1_3.add(lblDetails_Main);
		
		lblDetails_1_Main = new JLabel("Employee Details");
		lblDetails_1_Main.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ed.frmEmployeeDetails.setVisible(true);
				frmMainMenu.dispose();
			}
		});
		lblDetails_1_Main.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetails_1_Main.setForeground(new Color(184, 134, 11));
		lblDetails_1_Main.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDetails_1_Main.setBounds(10, 111, 138, 20);
		panel_1_3.add(lblDetails_1_Main);
		
		JLabel lblNewLabel_4 = new JLabel("Employee Section");
		lblNewLabel_4.setForeground(new Color(30, 144, 255));
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_4.setBounds(48, 52, 121, 20);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(MainMenu.class.getResource("/icon/Identicator_Icon.png")));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(173, 52, 20, 20);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon(MainMenu.class.getResource("/icon/Identicator_Icon.png")));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setBounds(149, 296, 20, 20);
		panel.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Salary Section");
		lblNewLabel_4_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_4_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(48, 296, 96, 20);
		panel.add(lblNewLabel_4_1);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setLayout(null);
		panel_1_4.setBackground(Color.LIGHT_GRAY);
		panel_1_4.setBounds(159, 337, 154, 141);
		panel.add(panel_1_4);
		
		JLabel lblUpdateSalary_Main = new JLabel("");
		lblUpdateSalary_Main.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String des=lblDesignation_Main.getText();
				if(des.equals("Accountant")) {
					us.frmUpdateSalary.setVisible(true);
					frmMainMenu.dispose();
				}
			}
		});
		lblUpdateSalary_Main.setIcon(new ImageIcon(MainMenu.class.getResource("/icon/Update_Salary_Icon.png")));
		lblUpdateSalary_Main.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateSalary_Main.setBounds(31, 10, 101, 91);
		panel_1_4.add(lblUpdateSalary_Main);
		
		JLabel lblUpdateSalary_1_Main = new JLabel("Update Salary");
		lblUpdateSalary_1_Main.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String des=lblDesignation_Main.getText();
				if(des.equals("Accountant")) {
					us.frmUpdateSalary.setVisible(true);
					frmMainMenu.dispose();
				}
			}
		});
		lblUpdateSalary_1_Main.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateSalary_1_Main.setForeground(new Color(184, 134, 11));
		lblUpdateSalary_1_Main.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblUpdateSalary_1_Main.setBounds(31, 111, 98, 20);
		panel_1_4.add(lblUpdateSalary_1_Main);
		
		JPanel panel_1_5 = new JPanel();
		panel_1_5.setLayout(null);
		panel_1_5.setBackground(Color.LIGHT_GRAY);
		panel_1_5.setBounds(516, 337, 154, 141);
		panel.add(panel_1_5);
		
		JLabel lblPayslip_Main = new JLabel("");
		lblPayslip_Main.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String des=lblDesignation_Main.getText();
				int eid=Integer.parseInt(lblEmpId_Main.getText());
				DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        		LocalDate now = LocalDate.now();  
        		String Date=now.format(df);  
        		DateTimeFormatter tf = DateTimeFormatter.ofPattern("hh:mm:ss");
        		LocalTime now1 = LocalTime.now();  
        		String Time=now1.format(tf); 
				qry = "select * from employee where Employee_Id=?";
		        try {
					st = con.prepareStatement(qry);
			        st.setInt(1,eid);
			        rs=st.executeQuery();
			        if(rs.next()) {
			        	double b_salary=rs.getDouble("BasicSalary");
			        	String name=rs.getString("Employee_Name");
			        	if(eid==rs.getInt("Employee_Id")) {
			        		double salary=(int)b_salary/12;
			        		double rent=(int)salary*10/100;
			        		double medical=(int)salary*5/100;
			        		double gross=(int)salary+rent+medical;
			        		double tax=(int)salary*5/100;
			        		double ins=(int)salary*10/100;
			        		double pf=(int)salary*10/100;
			        		double ded=(int)(tax+ins+pf);
			        		double np=(int)(gross-ded);
			        		s.llblNetPay1.setText(String.valueOf(np));
			        		s.lblTotalDeductions1.setText(String.valueOf(ded));
			        		s.lblProvidentFund1.setText(String.valueOf(pf));
			        		s.lblInsurence1.setText(String.valueOf(ins));
			        		s.lblProfessionalTax1.setText(String.valueOf(tax));
			        		s.lblGrossSalary1.setText(String.valueOf(gross));
			        		s.lblMedicalAllowences1.setText(String.valueOf(medical));
			        		s.lblRentAllowences1.setText(String.valueOf(rent));
			        		s.lblSalary1.setText(String.valueOf(salary));
			        		s.lblEmpId1.setText(String.valueOf(eid));
			        		s.lblEmpName.setText(name);
			        		s.lblEmpDesignation.setText(des);
			        		s.lblDate1.setText(Date);
			         		s.lblTime1.setText(Time);
			        		s.frmSalarySlip.setVisible(true);
			        		frmMainMenu.dispose();
			        	}
			        }
		        } catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		lblPayslip_Main.setIcon(new ImageIcon(MainMenu.class.getResource("/icon/Salary_Receipt_Icon.png")));
		lblPayslip_Main.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayslip_Main.setBounds(31, 10, 101, 91);
		panel_1_5.add(lblPayslip_Main);
		
		JLabel lblPayslip_1_Main = new JLabel("Generate Payslip");
		lblPayslip_1_Main.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String des=lblDesignation_Main.getText();
				int eid=Integer.parseInt(lblEmpId_Main.getText());
				DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        		LocalDate now = LocalDate.now();  
        		String Date=now.format(df);  
        		DateTimeFormatter tf = DateTimeFormatter.ofPattern("hh:mm:ss");
        		LocalTime now1 = LocalTime.now();  
        		String Time=now1.format(tf); 
				qry = "select * from employee where Employee_Id=?";
		        try {
					st = con.prepareStatement(qry);
			        st.setInt(1,eid);
			        rs=st.executeQuery();
			        if(rs.next()) {
			        	double b_salary=rs.getDouble("BasicSalary");
			        	String name=rs.getString("Employee_Name");
			        	if(eid==rs.getInt("Employee_Id")) {
			        		double salary=b_salary/12;
			        		double rent=salary*10/100;
			        		double medical=salary*5/100;
			        		double gross=salary+rent+medical;
			        		double tax=salary*5/100;
			        		double ins=salary*10/100;
			        		double pf=salary*10/100;
			        		double ded=tax+ins+pf;
			        		double np=gross-ded;
			        		s.llblNetPay1.setText(String.valueOf(np));
			        		s.lblTotalDeductions1.setText(String.valueOf(ded));
			        		s.lblProvidentFund1.setText(String.valueOf(pf));
			        		s.lblInsurence1.setText(String.valueOf(ins));
			        		s.lblProfessionalTax1.setText(String.valueOf(tax));
			        		s.lblGrossSalary1.setText(String.valueOf(gross));
			        		s.lblMedicalAllowences1.setText(String.valueOf(medical));
			        		s.lblRentAllowences1.setText(String.valueOf(rent));
			        		s.lblSalary1.setText(String.valueOf(salary));
			        		s.lblEmpId1.setText(String.valueOf(eid));
			        		s.lblEmpName.setText(name);
			        		s.lblEmpDesignation.setText(des);
			        		s.lblDate1.setText(Date);
			         		s.lblTime1.setText(Time);
			        		s.frmSalarySlip.setVisible(true);
			        		frmMainMenu.dispose();
			        	}
			        }
		        } catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		lblPayslip_1_Main.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayslip_1_Main.setForeground(new Color(184, 134, 11));
		lblPayslip_1_Main.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPayslip_1_Main.setBounds(10, 111, 135, 20);
		panel_1_5.add(lblPayslip_1_Main);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(Color.LIGHT_GRAY);
		headerPanel.setBorder(null);
		headerPanel.setBounds(159, 0, 858, 77);
		mainPanel.add(headerPanel);
		headerPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome to Employee Management System");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setBorder(null);
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 19, 838, 47);
		headerPanel.add(lblNewLabel_1);
	}
}
