package employee;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

import java.awt.Choice;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JRadioButton;

import manager.DisplayAllData;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class Employee extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldname;
	private JTextField textFieldemail;
	private JTextField textFieldphone;
	private JPasswordField passwordFieldpass;
	private JPasswordField passwordFieldrepass;
	private JComboBox day,month,year;
	private JComboBox marstats;
	private JComboBox sex;
	private JTextArea textAreaaddress;
	private JComboBox comboBoxdept;
	
	
	EmployeeRegistrationInfo r;
	ArrayList<EmployeeRegistrationInfo> employeelist;
	private Scanner sc2;
	private Scanner sc1;
	private Scanner sc3;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee frame = new Employee();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Employee() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Employee Appraisal System Images Path\\Coder4S.png"));
		setResizable(false);
		setTitle("Employee Register");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 647);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setBounds(10, 62, 113, 29);
		lblName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		contentPane.add(lblName);
		
		textFieldname = new JTextField();
		textFieldname.setForeground(Color.BLUE);
		textFieldname.setBounds(155, 61, 299, 27);
		contentPane.add(textFieldname);
		textFieldname.setColumns(10);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setForeground(new Color(0, 0, 0));
		lblSex.setBounds(10, 93, 113, 29);
		lblSex.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		contentPane.add(lblSex);
		
		JLabel lblEmailId = new JLabel("Email ID:");
		lblEmailId.setForeground(new Color(0, 0, 0));
		lblEmailId.setBounds(10, 133, 113, 29);
		lblEmailId.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		contentPane.add(lblEmailId);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setForeground(new Color(0, 0, 0));
		lblAddress.setBounds(10, 166, 113, 29);
		lblAddress.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		contentPane.add(lblAddress);
		
		textFieldemail = new JTextField();
		textFieldemail.setForeground(Color.BLUE);
		textFieldemail.setBounds(155, 136, 299, 27);
		textFieldemail.setColumns(10);
		contentPane.add(textFieldemail);
		
		
		
		JLabel lblPhoneNo = new JLabel("Phone No.:");
		lblPhoneNo.setForeground(new Color(0, 0, 0));
		lblPhoneNo.setBounds(10, 297, 113, 29);
		lblPhoneNo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		contentPane.add(lblPhoneNo);
		
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setForeground(new Color(0, 0, 0));
		lblDateOfBirth.setBounds(10, 353, 113, 29);
		lblDateOfBirth.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		contentPane.add(lblDateOfBirth);
		
		JLabel lblMaritalStatus = new JLabel("Marital Status:");
		lblMaritalStatus.setForeground(new Color(0, 0, 0));
		lblMaritalStatus.setBounds(10, 257, 113, 29);
		lblMaritalStatus.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		contentPane.add(lblMaritalStatus);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setToolTipText("Password must be minimum 5 characters");
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setBounds(10, 457, 113, 29);
		lblPassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		contentPane.add(lblPassword);
		
		JLabel lblReenterPassword = new JLabel("Re-enter Password:");
		lblReenterPassword.setForeground(new Color(0, 0, 0));
		lblReenterPassword.setBounds(10, 497, 141, 29);
		lblReenterPassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		contentPane.add(lblReenterPassword);
		
		textFieldphone = new JTextField();
		textFieldphone.setForeground(Color.BLUE);
		textFieldphone.setBounds(155, 297, 299, 27);
		textFieldphone.setColumns(10);
		contentPane.add(textFieldphone);
		
		passwordFieldpass = new JPasswordField();
		passwordFieldpass.setForeground(Color.BLUE);
		passwordFieldpass.setBounds(155, 463, 299, 20);
		contentPane.add(passwordFieldpass);
	
		
		passwordFieldrepass = new JPasswordField();
		passwordFieldrepass.setForeground(Color.BLUE);
		passwordFieldrepass.setBounds(155, 503, 299, 20);
		contentPane.add(passwordFieldrepass);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setForeground(Color.BLUE);
		btnRegister.setToolTipText("Helps to Register and send approval request to manager");
		btnRegister.setMnemonic('R');
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addRegInfo();
				
			}
		});
		
		
		btnRegister.setFont(new Font("Sitka Display", Font.PLAIN, 13));
		btnRegister.setBounds(320, 539, 134, 31);
		contentPane.add(btnRegister);
		
		 String dvalue[]=new String[31];
		   for(int i=0;i<=30;i++)
		   {
				dvalue[i]=String.valueOf(i+1);
		   }
				
		   String mvalue[]=new String[12];
		   for(int i=0;i<=11;i++)
		   {
				mvalue[i]=String.valueOf(i+1);
		   }
				
		   String yvalue[]=new String[66];
		   int cnt=0;
		   for(int i=1950;i<=2015;i++)
		   {
				yvalue[cnt]=String.valueOf(i);
				cnt++;	
		   }
			month=new JComboBox(mvalue);
			month.setForeground(Color.BLUE);
			month.setBounds(246, 359, 68, 20);
			contentPane.add(month);
			day=new JComboBox(dvalue);
			day.setForeground(Color.BLUE);
			day.setBounds(156, 360, 68, 18);
			contentPane.add(day);
			year=new JComboBox(yvalue);
			year.setForeground(Color.BLUE);
			year.setBounds(340, 359, 68, 20);
			contentPane.add(year);
			
			JLabel lblDay = new JLabel("Day");
			lblDay.setForeground(new Color(0, 0, 0));
			lblDay.setBounds(155, 335, 46, 14);
			contentPane.add(lblDay);
			
			JLabel lblMonth = new JLabel("Month");
			lblMonth.setForeground(new Color(0, 0, 0));
			lblMonth.setBounds(246, 333, 46, 15);
			contentPane.add(lblMonth);
			
			JLabel lblYear = new JLabel("Year");
			lblYear.setForeground(new Color(0, 0, 0));
			lblYear.setBounds(340, 334, 46, 14);
			contentPane.add(lblYear);
			
			String mstatus[]={"Married","Seperated","Widowed","Divorced","Single"};
			marstats=new JComboBox(mstatus);
			marstats.setForeground(Color.BLUE);
			marstats.setBounds(155,263,150,20);
			contentPane.add(marstats);
			
			
			textAreaaddress = new JTextArea();
			textAreaaddress.setForeground(Color.BLUE);
			textAreaaddress.setBounds(155, 170, 299, 82);
			textAreaaddress.setText(" ");
			contentPane.add(textAreaaddress);
			

			String s[]={"Male","Female"};
			sex = new JComboBox(s);
			sex.setForeground(Color.BLUE);
			sex.setBounds(155, 99, 83, 20);
			contentPane.add(sex);
			
			JLabel lblDepartment = new JLabel("Department:");
			lblDepartment.setForeground(new Color(0, 0, 0));
			lblDepartment.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
			lblDepartment.setBounds(10, 393, 113, 29);
			contentPane.add(lblDepartment);
			
			String d[]={"Developement","Human Resource"};
			comboBoxdept = new JComboBox(d);
			comboBoxdept.setForeground(Color.BLUE);
			comboBoxdept.setBounds(155, 399, 127, 20);
			contentPane.add(comboBoxdept);
			
			
			
			JLabel lblRegistrationForm = new JLabel("                      Registration Form");
			lblRegistrationForm.setForeground(new Color(255, 255, 0));
			lblRegistrationForm.setFont(new Font("Sylfaen", Font.PLAIN, 24));
			lblRegistrationForm.setBounds(10, 0, 444, 47);
			contentPane.add(lblRegistrationForm);
			
			JLabel label = new JLabel("\u00A9Coder 4S");
			label.setForeground(new Color(0, 128, 0));
			label.setBounds(371, 593, 83, 14);
			contentPane.add(label);
			
			JLabel label_1 = new JLabel("");
			label_1.setIcon(new ImageIcon("C:\\Employee Appraisal System Images Path\\background.jpg"));
			label_1.setBounds(0, 0, 469, 618);
			contentPane.add(label_1);
	}
	
	
		
	
	private void addRegInfo() {
		
		if(createObjRegInfo()==0){
		
		int con=JOptionPane.showConfirmDialog(this, "Are You Sure to Register?");
		
     	 if(con==JOptionPane.YES_OPTION)
		 {
		   employeelist = UserDataReadWriteFromFile.readDataFromFile();
		
		   employeelist.add(r);
		   
		   
			
		   UserDataReadWriteFromFile.writeDatatoFile(employeelist);
		   
			
		   JOptionPane.showMessageDialog(this, "You Are Registered,Please contact to manager for approval and id");
		  dispose();
		}
		}
     	
	}
				    
		
		
	

	public int createObjRegInfo() {
		
		
		String name,gender,emailid,address,mstatus,phno,dob,dept,branch,password,repassword;
		name=textFieldname.getText().trim();
		gender=(String)sex.getSelectedItem();
		emailid=textFieldemail.getText();
		address=textAreaaddress.getText();
		mstatus=(String)marstats.getSelectedItem();
		phno=textFieldphone.getText();
		int d=Integer.parseInt((String)day.getSelectedItem());
		int m=Integer.parseInt((String)month.getSelectedItem());
		int y=Integer.parseInt((String)year.getSelectedItem());
		dob=d+"/"+m+"/"+y;
		dept=(String)comboBoxdept.getSelectedItem();
		
		
		String namepattern = "^[a-zA-Z  ]{3,20}$";
    	String name2 = textFieldname.getText();
    	sc1 = new Scanner(name2);

    	String match = sc1.findInLine(namepattern);

    	if (match == null){
    		
    		JOptionPane.showMessageDialog(null, "Enter valid name");
    			textFieldname.setBackground(Color.RED);
    			textFieldname.setForeground(Color.WHITE);
    		return 1;
    		
    	}
		

		String emailpattern = "^(\\w)+@(\\w+\\.)(\\w+\\.)?[A-Za-z]+$";
    	String email = textFieldemail.getText();
    	sc2 = new Scanner(email);
    	String match1 = sc2.findInLine(emailpattern);
    	if (match1 == null){
    		JOptionPane.showMessageDialog(null,"Enter Valid Email");
    	/**/	
    		textFieldemail.setBackground(Color.RED);
    		textFieldemail.setForeground(Color.WHITE);
    		return 1;
    	}
    	
    	if(address.equals(" ")){
    		JOptionPane.showMessageDialog(null,"Address cannot be empty");
    		textAreaaddress.setBackground(Color.RED);
    		textAreaaddress.setForeground(Color.WHITE);
    		return 1;
    	}
    	
    	
    	
    	
    	String phnopattern = "^[0-9]{10}$";
    	String phno2= textFieldphone.getText();

    	sc3 = new Scanner(phno2);

    	String match2 = sc3.findInLine(phnopattern);

    	if (match2 == null){
    		
    		JOptionPane.showMessageDialog(null, "Enter Valid Phone Number");
    		textFieldphone.setBackground(Color.RED);
    		textFieldphone.setForeground(Color.WHITE);
    		return 1;
    	}
    
    	
		
		password=passwordFieldpass.getText();
		repassword=passwordFieldrepass.getText();
		//r=new EmployeeRegistrationInfo(name, gender, emailid, address, mstatus, phno, dob, dept, password,"0","0");
		if(password.equals(repassword) && !password.equals("") && password.length()>=5){
			r=new EmployeeRegistrationInfo(name, gender, emailid, address, mstatus, phno, dob, dept, password,"0","0");
			
			return 0;
		}
		else{
			JOptionPane.showMessageDialog(this,"Password Mismatch or Blank or less than 5 characters ");
			passwordFieldpass.setBackground(Color.RED);
			passwordFieldrepass.setBackground(Color.RED);
			   return 1;
		}
	}
}
