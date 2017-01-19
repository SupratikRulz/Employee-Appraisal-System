package employee;


import java.awt.BorderLayout;
import java.awt.EventQueue;





import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;





import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;





import javax.swing.JLabel;





import java.awt.Font;





import javax.swing.JSeparator;





import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;





import javax.swing.JTextPane;





import java.awt.SystemColor;





import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;





import login.LoginSelection;
import manager.Calculator;
import manager.LeaveReadWrite;
import manager.ManSetDay_Info;
import manager.Search;
import manager.SetDayReadWriteFile;
import manager.Calender;
import manager.TargetInfo;
import manager.TargetReadWrite;


import java.awt.Toolkit;


import javax.swing.ImageIcon;

public class EmployeeHome extends JFrame {

	private JPanel contentPane;
	private LocalDate today; 
	ArrayList<TargetInfo> targetlist;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,int index) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeHome frame = new EmployeeHome(index);
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
	public EmployeeHome(int index) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Employee Appraisal System Images Path\\Coder4S.png"));
		ArrayList<EmployeeRegistrationInfo> list=UserDataReadWriteFromFile.readDataFromFile();
		setTitle("Employee Home");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 403);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome ~");
		lblWelcome.setForeground(Color.RED);
		lblWelcome.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		lblWelcome.setBounds(34, 49, 188, 44);
		contentPane.add(lblWelcome);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setMnemonic('U');
		btnUpdate.setForeground(Color.BLUE);
		btnUpdate.setToolTipText("Helps to update information like Phone No. ,Email ID,Address");
		btnUpdate.setBounds(29, 104, 89, 23);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener((e) ->
		{
			EmployeeUpdate.main(null,index);
			//dispose();
			//EmployeeHome.main(null, index);
		}
		);

		
		JButton btnAppraise = new JButton("Appraise");
		btnAppraise.setMnemonic('A');
		btnAppraise.setForeground(Color.BLUE);
		btnAppraise.setToolTipText("Appraise Yourself");
		btnAppraise.setBounds(128, 104, 89, 23);
		contentPane.add(btnAppraise);
		
		
		ArrayList<ManSetDay_Info> list0=SetDayReadWriteFile.readDateFromFile();
		ArrayList<EmployeeRegistrationInfo> listsearch=UserDataReadWriteFromFile.readDataFromFile();
		String id=listsearch.get(index).getEmployeeid();
		
		
		today = LocalDate.now();
		int day = today.getDayOfMonth();
  		int month = today.getMonthValue();
  		int year = today.getYear();
  		String date=day+"/"+month+"/"+year;
		
		if((searchIdAppraise(id)>=0) && (list0.get((list0.size()-1)).getDate()<day)){
			btnAppraise.setEnabled(false);;
		}
		btnAppraise.addActionListener((e) ->
										{
											EmployeeAppraisal.main(null,index);
											
										}
										);
		
	
  		
  		LocalTime time = LocalTime.now();
		int hr = time.getHour();
 		int min = time.getMinute();
 		int sec = time.getSecond();
		
 		String times = hr+":"+min+":"+sec;
		
		JLabel lblTime = new JLabel(times);
		lblTime.setForeground(new Color(255, 255, 0));
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTime.setBounds(656, 38, 76, 23);
		contentPane.add(lblTime);
		
		JLabel lblDate = new JLabel(date);
		lblDate.setForeground(new Color(255, 255, 0));
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(656, 67, 76, 26);
		contentPane.add(lblDate);
		
		JLabel lblTime_1 = new JLabel("Time:");
		lblTime_1.setForeground(Color.RED);
		lblTime_1.setBackground(Color.RED);
		lblTime_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTime_1.setBounds(586, 39, 76, 23);
		contentPane.add(lblTime_1);
		
		JLabel lblDate_1 = new JLabel("Date:");
		lblDate_1.setForeground(Color.RED);
		lblDate_1.setBackground(Color.RED);
		lblDate_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate_1.setBounds(586, 70, 76, 23);
		contentPane.add(lblDate_1);
		
		JLabel lblid = new JLabel("ID Number:");
		lblid.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblid.setForeground(new Color(255, 0, 0));
		lblid.setBounds(34, 185, 76, 25);
		contentPane.add(lblid);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setForeground(new Color(255, 0, 0));
		lblName.setBounds(34, 214, 59, 25);
		contentPane.add(lblName);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSex.setForeground(new Color(255, 0, 0));
		lblSex.setBounds(34, 250, 59, 25);
		contentPane.add(lblSex);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setForeground(new Color(255, 0, 0));
		lblEmail.setBounds(34, 276, 59, 25);
		contentPane.add(lblEmail);
		
		JLabel lblMaritalStatus = new JLabel("Marital Status:");
		lblMaritalStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMaritalStatus.setForeground(new Color(255, 0, 0));
		lblMaritalStatus.setBounds(34, 298, 89, 25);
		contentPane.add(lblMaritalStatus);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPhoneNumber.setForeground(new Color(255, 0, 0));
		lblPhoneNumber.setBounds(34, 323, 89, 25);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDepartment.setForeground(new Color(255, 0, 0));
		lblDepartment.setBounds(342, 185, 76, 25);
		contentPane.add(lblDepartment);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddress.setForeground(new Color(255, 0, 0));
		lblAddress.setBounds(342, 216, 59, 25);
		contentPane.add(lblAddress);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDateOfBirth.setForeground(new Color(255, 0, 0));
		lblDateOfBirth.setBounds(34, 344, 89, 25);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblempid = new JLabel(list.get(index).getEmployeeid());
		lblempid.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblempid.setForeground(Color.BLACK);
		lblempid.setBounds(137, 190, 188, 14);
		contentPane.add(lblempid);
		
		JLabel lblempname = new JLabel(list.get(index).getName());
		lblempname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblempname.setForeground(Color.BLACK);
		lblempname.setBounds(137, 219, 188, 14);
		contentPane.add(lblempname);
		
		JLabel lblempsex = new JLabel(list.get(index).getSex());
		lblempsex.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblempsex.setForeground(Color.BLACK);
		lblempsex.setBounds(137, 255, 188, 14);
		contentPane.add(lblempsex);
		
		JLabel lblempemail = new JLabel(list.get(index).getEmailid());
		lblempemail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblempemail.setForeground(Color.BLACK);
		lblempemail.setBounds(137, 281, 188, 14);
		contentPane.add(lblempemail);
		
		JLabel lblempmarstatus = new JLabel(list.get(index).getMarstatus());
		lblempmarstatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblempmarstatus.setForeground(Color.BLACK);
		lblempmarstatus.setBounds(133, 303, 188, 14);
		contentPane.add(lblempmarstatus);
		
		JLabel lblempphno = new JLabel(list.get(index).getPhno());
		lblempphno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblempphno.setForeground(Color.BLACK);
		lblempphno.setBounds(133, 328, 188, 14);
		contentPane.add(lblempphno);
		
		JLabel lblempdob = new JLabel(list.get(index).getDob());
		lblempdob.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblempdob.setForeground(Color.BLACK);
		lblempdob.setBounds(133, 349, 188, 14);
		contentPane.add(lblempdob);
		
		JLabel lblempdept = new JLabel(list.get(index).getDept());
		lblempdept.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblempdept.setForeground(Color.BLACK);
		lblempdept.setBounds(428, 190, 188, 14);
		contentPane.add(lblempdept);
		
		JLabel lblempaddress = new JLabel(list.get(index).getAddress());
		lblempaddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblempaddress.setVerticalAlignment(SwingConstants.TOP);
		lblempaddress.setForeground(Color.BLACK);
		lblempaddress.setBounds(428, 221, 272, 128);
		contentPane.add(lblempaddress);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 96, 715, 14);
		contentPane.add(separator);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setForeground(new Color(255, 0, 0));
		lblPassword.setBounds(342, 344, 89, 25);
		contentPane.add(lblPassword);
		
		JLabel lblemppassword = new JLabel(list.get(index).getPassword());
		lblemppassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblemppassword.setForeground(Color.BLACK);
		lblemppassword.setBounds(428, 349, 188, 14);
		contentPane.add(lblemppassword);
		
		JButton btnLeaveRequest = new JButton("Leave Request");
		btnLeaveRequest.addActionListener(new ActionListener() {
			
			
			
		public void actionPerformed(ActionEvent arg0) {
				
												Leave.main(null, index);
												
												
				
			}
		});
		btnLeaveRequest.setToolTipText("Request a leave to manager");
		btnLeaveRequest.setMnemonic('L');
		btnLeaveRequest.setForeground(Color.BLUE);
		btnLeaveRequest.setBounds(429, 104, 159, 23);
		contentPane.add(btnLeaveRequest);
		
		JButton btnManagerComment = new JButton("Manager Comment");
		btnManagerComment.setToolTipText("Dispaly manager's comment and also has reply option");
		btnManagerComment.setMnemonic('M');
		btnManagerComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ManagerComment.main(null,index);
				/*dispose();
				EmployeeHome.main(null, index);*/
			}
		});
		btnManagerComment.setForeground(Color.BLUE);
		btnManagerComment.setBounds(227, 104, 192, 23);
		contentPane.add(btnManagerComment);
		
		int storeindex=0;
		ArrayList<EmployeeLeaveInfo> liststatus=LeaveReadWrite.readAppFromFile();
		for(int i=0;i<=liststatus.size();i++){
			
			if(list.get(index).getEmployeeid().equals(liststatus.get(i).getEmployeeid())){
				storeindex=i;
				break;
			}
			
		}
		
		JLabel lblLeaverestatusdynamic = new JLabel(liststatus.get(storeindex).getStatus());
		lblLeaverestatusdynamic.setForeground(Color.BLUE);
		lblLeaverestatusdynamic.setBounds(648, 138, 140, 14);
		contentPane.add(lblLeaverestatusdynamic);
		
		JButton btnViewBucket = new JButton("View Bucket");
		btnViewBucket.setToolTipText("shows in which bucket you belong");
		btnViewBucket.setMnemonic('B');
		btnViewBucket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
			ArrayList<EmployeeAppraisal_Info> appraisallist=AppDataReadWrite.readAppFromFile();
			int appindex=0;
			for(int i=0;i<appraisallist.size();i++){
				if(list.get(index).getEmployeeid().equals(appraisallist.get(i).getEmployeeid())){
					appindex=i;
					break;
				}
			}
			double buk=appraisallist.get(appindex).getAverage();
			String bucket="";
			if(buk>=4)
				bucket="A";
			else if(buk>=3)
				bucket="B";
			else if(buk>=2)
				bucket="C";
			else if(buk>=1)
				bucket="D";
			else
				bucket="E";
			JOptionPane.showMessageDialog(null,"You belong to bucket:"+bucket);
				}catch(Exception f){
					JOptionPane.showMessageDialog(null, "No Bucket Assigned");
				}
			}
		});
		btnViewBucket.setForeground(Color.BLUE);
		btnViewBucket.setBounds(597, 104, 128, 23);
		contentPane.add(btnViewBucket);
		
		JLabel lblLeaveStatus = new JLabel("Leave Status:");
		lblLeaveStatus.setForeground(Color.YELLOW);
		lblLeaveStatus.setBounds(566, 134, 126, 23);
		contentPane.add(lblLeaveStatus);
		
		JLabel label = new JLabel("\u00A9Coder 4S");
		label.setForeground(new Color(0, 128, 0));
		label.setBounds(649, 349, 83, 14);
		contentPane.add(label);
		
		JButton btnCalander = new JButton("Calander");
		btnCalander.setToolTipText("displays calender");
		btnCalander.setMnemonic('D');
		btnCalander.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Calender.main(null);
			
					

			}
		});
		btnCalander.setForeground(Color.BLUE);
		btnCalander.setBounds(29, 134, 89, 23);
		contentPane.add(btnCalander);
		
		JButton btnShowTarget = new JButton("Show Target");
		btnShowTarget.setToolTipText("Shows the target of month set by manager");
		btnShowTarget.setMnemonic('T');
		btnShowTarget.setForeground(Color.BLUE);
		btnShowTarget.setBounds(227, 134, 106, 23);
		contentPane.add(btnShowTarget);
		btnShowTarget.addActionListener((e)->
											{
												try{
												targetlist=TargetReadWrite.readTargetFromFile();
												JOptionPane.showMessageDialog(null, targetlist.get((targetlist.size()-1)).getTarget());
												dispose();
												EmployeeHome.main(null, index);
												}catch(Exception g){
													JOptionPane.showMessageDialog(null, "Manager has not set target yet");
												}
											}
		);
		JButton btnShowMessageBy = new JButton("Show Message by Manager");
		btnShowMessageBy.setToolTipText("shows personal message sent by manager if any");
		btnShowMessageBy.setMnemonic('S');
		btnShowMessageBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ShowMessageByManager.main(null,list.get(index).getEmployeeid(),index);

			
				
				
				
				
				
			}
		});
		btnShowMessageBy.setForeground(Color.BLUE);
		btnShowMessageBy.setBounds(342, 134, 203, 23);
		contentPane.add(btnShowMessageBy);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setToolTipText("sign out from account");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Logout.main(null);
				
			}
		});
		btnLogOut.setForeground(Color.RED);
		btnLogOut.setFont(new Font("Sitka Text", Font.BOLD, 11));
		btnLogOut.setMnemonic('L');
		btnLogOut.setBounds(587, 11, 89, 23);
		contentPane.add(btnLogOut);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setToolTipText("refreshes the page");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EmployeeHome.main(null, index);
				
			}
		});
		btnRefresh.setMnemonic('L');
		btnRefresh.setForeground(Color.RED);
		btnRefresh.setFont(new Font("Sitka Text", Font.BOLD, 11));
		btnRefresh.setBounds(488, 10, 89, 23);
		contentPane.add(btnRefresh);
		
		JButton btnCalculator = new JButton("Calculator");
		btnCalculator.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCalculator.setToolTipText("calculator for preforming quick calculations");
		btnCalculator.setMnemonic('C');
		btnCalculator.setForeground(Color.BLUE);
		btnCalculator.setBounds(128, 134, 89, 23);
		contentPane.add(btnCalculator);
		btnCalculator.addActionListener((e) ->
											{
												Calculator.main(null);
											}
											);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Employee Appraisal System Images Path\\bak.jpg"));
		label_1.setBounds(0, 0, 745, 374);
		contentPane.add(label_1);
		
		
	}
	

	
	public int searchIdinLeave(String id){
		
		ArrayList<EmployeeLeaveInfo> list2;
		int f = -1;
		try
		{
			list2=LeaveReadWrite.readAppFromFile();
			
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
