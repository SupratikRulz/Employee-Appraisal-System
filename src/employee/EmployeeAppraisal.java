package employee;

import java.awt.BorderLayout;
import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;



import java.awt.Font;



import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JButton;



import java.awt.SystemColor;
import java.time.LocalDate;



import javax.swing.JTextArea;
import javax.swing.JTextPane;



import manager.ManagerHome;
import manager.Search;
import manager.SetDayReadWriteFile;
import manager.ManSetDay_Info;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;


public class EmployeeAppraisal extends JFrame {

	private JPanel contentPane;
	private LocalDate today;
	private JTextField textFieldleadership;
	private JTextField textFieldcustomersatisfaxtion;
	private JTextField textFieldteamwork;
	private JTextField textFieldpunctuality;
	private JButton btnAppraise;
	private JLabel lblNextYearGoals;
	private JLabel lblNewLabel;
	private JTextField textFielddiscipline;
	private JTextArea textAreanextyeargoals;
	ArrayList<EmployeeAppraisal_Info> Applist;
	private String date;
	public int day;
	  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args,int index) {
		 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					EmployeeAppraisal frame = new EmployeeAppraisal(index);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	EmployeeAppraisal(int index) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Supratik Rulz\\Desktop\\Java Programs\\EmpDemo\\Coder4S.png"));
		
		setTitle("Employee Appraisal Form");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 478);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInstructions = new JLabel("                       Instructions:- Outstanding-Grade '5'   ; Excellent -Grade'4'  ;");
		lblInstructions.setForeground(Color.RED);
		lblInstructions.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblInstructions.setBounds(10, 0, 667, 60);
		contentPane.add(lblInstructions);
		
		JLabel lblLeadership = new JLabel("1. Leadership");
		lblLeadership.setForeground(new Color(0, 0, 0));
		lblLeadership.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLeadership.setBounds(41, 168, 94, 20);
		contentPane.add(lblLeadership);
		
		textFieldleadership = new JTextField();
		textFieldleadership.setText(" ");
		textFieldleadership.setForeground(new Color(0, 0, 0));
		textFieldleadership.setBounds(249, 170, 86, 20);
		contentPane.add(textFieldleadership);
		textFieldleadership.setColumns(10);
		
		JLabel lblTeamwork = new JLabel("2. Teamwork");
		lblTeamwork.setForeground(new Color(0, 0, 0));
		lblTeamwork.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTeamwork.setBounds(41, 199, 94, 27);
		contentPane.add(lblTeamwork);
		
		textFieldcustomersatisfaxtion = new JTextField();
		textFieldcustomersatisfaxtion.setText(" ");
		textFieldcustomersatisfaxtion.setBounds(249, 239, 86, 20);
		contentPane.add(textFieldcustomersatisfaxtion);
		textFieldcustomersatisfaxtion.setColumns(10);
		
		JLabel lblCustomerSatisfaction = new JLabel("3. Customer Satisfaction");
		lblCustomerSatisfaction.setForeground(new Color(0, 0, 0));
		lblCustomerSatisfaction.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerSatisfaction.setBounds(41, 237, 177, 20);
		contentPane.add(lblCustomerSatisfaction);
		
		
		textFieldteamwork = new JTextField();
		textFieldteamwork.setText(" ");
		textFieldteamwork.setColumns(10);
		textFieldteamwork.setBounds(249, 204, 86, 20);
		contentPane.add(textFieldteamwork);
		
		JLabel lbldiscipline = new JLabel("4. Discipline");
		lbldiscipline.setForeground(new Color(0, 0, 0));
		lbldiscipline.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbldiscipline.setBounds(41, 268, 124, 20);
		contentPane.add(lbldiscipline);
		
		textFieldpunctuality = new JTextField();
		textFieldpunctuality.setText(" ");
		textFieldpunctuality.setBounds(249, 312, 86, 20);
		contentPane.add(textFieldpunctuality);
		textFieldpunctuality.setColumns(10);
		
		today=LocalDate.now();
		int day=today.getDayOfMonth();
		int month=today.getMonthValue();
		int year=today.getYear();
		date=day+"/"+month+"/"+year;
		
		JLabel lblDate=new JLabel(date);
		lblDate.setForeground(Color.YELLOW);
		lblDate.setFont(new Font("Tahoma",Font.PLAIN,15));
		lblDate.setBounds(575,113,76,26);
		contentPane.add(lblDate);
		
		lblNextYearGoals = new JLabel("6. Next year Goals");
		lblNextYearGoals.setForeground(new Color(0, 0, 0));
		lblNextYearGoals.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNextYearGoals.setBounds(41, 353, 150, 27);
		contentPane.add(lblNextYearGoals);
		
		 textAreanextyeargoals = new JTextArea();
		textAreanextyeargoals.setBounds(249, 356, 263, 72);
		contentPane.add(textAreanextyeargoals);
		
		lblNewLabel = new JLabel("                     Good-Grade'3' Satisfactory-Grade'2'; Not satisfactory-Grade-'1'");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 51, 667, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblPunctuality = new JLabel("5. Punctuality");
		lblPunctuality.setForeground(new Color(0, 0, 0));
		lblPunctuality.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPunctuality.setBounds(40, 310, 124, 20);
		contentPane.add(lblPunctuality);
		
		textFielddiscipline = new JTextField();
		textFielddiscipline.setText(" ");
		textFielddiscipline.setColumns(10);
		textFielddiscipline.setBounds(249, 270, 86, 20);
		contentPane.add(textFielddiscipline);
		
		JLabel lblDate_1 = new JLabel("Date:");
		lblDate_1.setForeground(new Color(0, 0, 0));
		lblDate_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDate_1.setBounds(519, 113, 62, 26);
		contentPane.add(lblDate_1);
		
		lblYourId = new JLabel("Your ID:");
		lblYourId.setForeground(new Color(0, 0, 0));
		lblYourId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYourId.setBounds(41, 113, 94, 20);
		contentPane.add(lblYourId);
		
		ArrayList<EmployeeRegistrationInfo> list2=UserDataReadWriteFromFile.readDataFromFile();
		
		lblEmpid = new JLabel(list2.get(index).getEmployeeid());
		lblEmpid.setForeground(Color.YELLOW);
		lblEmpid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmpid.setBounds(241, 113, 268, 20);
		contentPane.add(lblEmpid);
		
		label = new JLabel("\u00A9Coder 4S");
		label.setForeground(new Color(0, 128, 0));
		label.setBounds(594, 424, 83, 14);
		contentPane.add(label);
		
		
		btnAppraise = new JButton("Appraise");
		btnAppraise.setForeground(Color.BLUE);
		btnAppraise.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 15));
		btnAppraise.setBounds(562, 341, 115, 23);
		contentPane.add(btnAppraise);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Employee Appraisal System Images Path\\background.jpg"));
		label_1.setBounds(0, 0, 697, 449);
		contentPane.add(label_1);
		btnAppraise.addActionListener((e) ->
										{
											try{
											ArrayList<ManSetDay_Info> list0=SetDayReadWriteFile.readDateFromFile();
											ArrayList<EmployeeRegistrationInfo> listsearch=UserDataReadWriteFromFile.readDataFromFile();
											String id=listsearch.get(index).getEmployeeid();
											
											if((searchIdAppraise(id)<0) && (list0.get((list0.size()-1)).getDate()>=day)){
												if(!textAreanextyeargoals.getText().equals(" ") 
													&& !textFieldcustomersatisfaxtion.getText().equals(" ")
													&& !textFielddiscipline.getText().equals(" ") 
													&& !textFieldleadership.getText().equals(" ")
													&& !textFieldpunctuality.getText().equals(" ")
													&& !textFieldteamwork.getText().equals(" ")){
											addAppInfo(index);
											
												}
												else{
													
													JOptionPane.showMessageDialog(null, "Fields Cannot be empty");
													
												}
										}
										else{
											JOptionPane.showMessageDialog(this, "You Can't Appraise Now ");
										}
											
										
										}catch(Exception f){
											JOptionPane.showMessageDialog(this, "You Can't Appraise Now ");	
										}
											
										}
										);
		
		
		
		
		
	}

	EmployeeAppraisal_Info re;
	private JLabel lblYourId;
	private JLabel lblEmpid;
	private JLabel label;
	public void createObjAppInfo(int i) {
		ArrayList<EmployeeRegistrationInfo> list=UserDataReadWriteFromFile.readDataFromFile();
		
		String leadership,teamwork,customersatisfaction,discipline,punctuality,nextyeargoals,date1;
		leadership=textFieldleadership.getText().trim();
		teamwork=textFieldteamwork.getText().trim();
		customersatisfaction=textFieldcustomersatisfaxtion.getText().trim();
		discipline=textFielddiscipline.getText().trim();
		punctuality=textFieldpunctuality.getText().trim();
		nextyeargoals=textAreanextyeargoals.getText().trim();
		date1=date.substring(0, date.indexOf("/"));
		
			re=new EmployeeAppraisal_Info(list.get(i).getEmployeeid(),leadership,teamwork,customersatisfaction,discipline,punctuality,nextyeargoals,date1,"0","0","0","0","0","0","1");
	}
	
	private void addAppInfo(int i) {
		
		createObjAppInfo(i);
		
		
		int con1=JOptionPane.showConfirmDialog(this, "Are You Sure to Appraise?");
		
     	 if(con1==JOptionPane.YES_OPTION)
		 {
		   Applist = AppDataReadWrite.readAppFromFile();
		  
			
		   Applist.add(re);
			
		   AppDataReadWrite.writeApptoFile(Applist);
		   
			
		   JOptionPane.showMessageDialog(this, "Successfully Appraised");
		   dispose();
			EmployeeHome.main(null, i);
		 }
	} 
	public int searchIdAppraise(String id){
		ArrayList<EmployeeAppraisal_Info> list2;
		int f = -1;
		try
		{
			list2=AppDataReadWrite.readAppFromFile();
			
			for(int p=0; p<list2.size(); p++)
			{
				if(id.equals(list2.get(p).getEmployeeid()))
				{
				   f = p;
				   break;
				}	
			}
			 
			return(f);
		}catch(Exception e)
		{
			System.out.println(e);
			return(-2);
		}
	}
}

