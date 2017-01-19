package manager;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import employee.CopyRegToLeave;
import employee.EmployeeHome;
import employee.EmployeeRegistrationInfo;
import employee.Logout;
import employee.UserDataReadWriteFromFile;

import java.awt.SystemColor;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

import login.LoginSelection;
import javax.swing.ImageIcon;

public class ManagerHome extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSearch;
	private String sysdate,systime;
	private JTextField textFieldApproveEmail;
	private EmployeeRegistrationInfo rei;
	private ArrayList<EmployeeRegistrationInfo> employeelist2;
	private JTextField textFieldEmpappid;
	public static int managerdate=0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerHome frame = new ManagerHome();
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
	public ManagerHome() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Employee Appraisal System Images Path\\Coder4S.png"));
		setTitle("Manager Home");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 385);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 778, 21);
		contentPane.add(menuBar);
		
		JMenu mnView = new JMenu("View");
		mnView.setMnemonic('V');
		menuBar.add(mnView);
		
		JMenuItem mntmApprovalRequests = new JMenuItem("Approval Requests");
		mntmApprovalRequests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ApprovalRequestList();
			}
		});
		
		JMenu mnAppraise = new JMenu("Appraise");
		mnView.add(mnAppraise);
		
		JMenuItem mntmAppraiseList = new JMenuItem("Appraise List");
		mntmAppraiseList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new ShowAppraisalList();
			}
		});
		mnAppraise.add(mntmAppraiseList);
		
		JMenuItem mntmAppraiseEmployee = new JMenuItem("Appraise Employee");
		mntmAppraiseEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AppraiseEmployeeID.main(null);
			}
		});
		mnAppraise.add(mntmAppraiseEmployee);
		mnView.add(mntmApprovalRequests);
		
		JMenuItem mntmAllEmployees = new JMenuItem("All Employees");
		mntmAllEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new DisplayAllData();
				
			}
		});
		
		JMenu mnLeave = new JMenu("Leave");
		mnView.add(mnLeave);
		
		JMenuItem mntmLeaveRequest = new JMenuItem("Leave Request");
		mntmLeaveRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new showLeaves();
				
			}
		});
		mnLeave.add(mntmLeaveRequest);
		
		JMenuItem mntmGrantLeave = new JMenuItem("Grant Leave");
		mntmGrantLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				grantRequest.main(null);
				
			}
		});
		mnLeave.add(mntmGrantLeave);
		mnView.add(mntmAllEmployees);
		
		JMenuItem mntmFireEmployeeList = new JMenuItem("Fire Employee List");
		mntmFireEmployeeList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			new	ShowFireList();
				
			}
		});
		mnView.add(mntmFireEmployeeList);
		
		JMenu mnSet = new JMenu("Set");
		mnSet.setMnemonic('T');
		menuBar.add(mnSet);
		
		JMenuItem mntmAppraiseDeadlineDay = new JMenuItem("Appraise Deadline Day");
		mntmAppraiseDeadlineDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerSetDay.main(null);
			}
		});
		mnSet.add(mntmAppraiseDeadlineDay);
		
		JMenuItem mntmTarget = new JMenuItem("Target of Month");
		mntmTarget.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Target.main(null);
				
				
			
			}
		});
		mnSet.add(mntmTarget);
		
		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setMnemonic('E');
		menuBar.add(mnEdit);
		
		JMenuItem mntmFireEmployee = new JMenuItem("Fire Employee");
		mntmFireEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FireEmployee.main(null);
				/*dispose();
				ManagerHome.main(null);
				*/
			}
		});
		mnEdit.add(mntmFireEmployee);
		
		JMenuItem mntmSendMessage = new JMenuItem("Send Message");
		mntmSendMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SendMessageToEmployee.main(null);
				
				
			}
		});
		mnEdit.add(mntmSendMessage);
		
		JMenu mnTools = new JMenu("Tools");
		mnTools.setMnemonic('T');
		menuBar.add(mnTools);
		
		JMenuItem mntmCalender = new JMenuItem("Calender");
		mnTools.add(mntmCalender);
		
		JMenuItem mntmCalculator = new JMenuItem("Calculator");
		mntmCalculator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Calculator.main(null);
			}
		});
		mnTools.add(mntmCalculator);
		mntmCalender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Calender.main(null);
				
			}
		});
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setForeground(new Color(255, 0, 0));
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDate.setBounds(528, 55, 65, 33);
		contentPane.add(lblDate);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setForeground(new Color(255, 0, 0));
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTime.setBounds(528, 89, 65, 33);
		contentPane.add(lblTime);
		
		JLabel lblWelcome = new JLabel("Welcome~");
		lblWelcome.setForeground(Color.RED);
		lblWelcome.setFont(new Font("Monotype Corsiva", Font.BOLD, 32));
		lblWelcome.setBounds(10, 43, 282, 79);
		contentPane.add(lblWelcome);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		separator.setBounds(10, 120, 723, 2);
		contentPane.add(separator);
		
		JButton btnListBestEmployees = new JButton("List Best Employees");
		btnListBestEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new BestEmployee();
			}
		});
		btnListBestEmployees.setToolTipText("Gives the list of Best Employees");
		btnListBestEmployees.setMnemonic('B');
		btnListBestEmployees.setForeground(Color.BLUE);
		btnListBestEmployees.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnListBestEmployees.setBounds(20, 133, 198, 52);
		contentPane.add(btnListBestEmployees);
		
		JButton btnListWorstEmployees = new JButton("List Worst Employees");
		btnListWorstEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new WorstEmployee();
				
			}
		});
		btnListWorstEmployees.setToolTipText("Gives the list of all worst employees");
		btnListWorstEmployees.setMnemonic('W');
		btnListWorstEmployees.setForeground(Color.BLUE);
		btnListWorstEmployees.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnListWorstEmployees.setBounds(20, 193, 198, 52);
		contentPane.add(btnListWorstEmployees);
		
		LocalDate today = LocalDate.now();
		int day = today.getDayOfMonth();
  		int month = today.getMonthValue();
  		int year = today.getYear();
			
		sysdate = day+"/"+month+"/"+year;		
		
		LocalTime time = LocalTime.now();
		int hr = time.getHour();
 		int min = time.getMinute();
 		int sec = time.getSecond();
		
 		systime = hr+":"+min+":"+sec;
		
		JLabel lblDateShow = new JLabel(sysdate);
		lblDateShow.setForeground(Color.BLUE);
		lblDateShow.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDateShow.setBounds(614, 55, 106, 33);
		contentPane.add(lblDateShow);
		
		JLabel lblTimeShow = new JLabel(systime);
		lblTimeShow.setForeground(Color.BLUE);
		lblTimeShow.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTimeShow.setBounds(614, 89, 106, 33);
		contentPane.add(lblTimeShow);
		
		JLabel lblSearchEmployees = new JLabel("Search Employees:");
		lblSearchEmployees.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSearchEmployees.setForeground(new Color(255, 0, 0));
		lblSearchEmployees.setBounds(10, 281, 160, 40);
		contentPane.add(lblSearchEmployees);
		
		JRadioButton rdbtnId = new JRadioButton("ID");
		rdbtnId.setMnemonic('I');
		rdbtnId.setForeground(Color.BLUE);
		rdbtnId.setBounds(187, 275, 136, 21);
		contentPane.add(rdbtnId);
		
		ButtonGroup search=new ButtonGroup();
		search.add(rdbtnId);
		
		
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(333, 281, 288, 33);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JRadioButton rdbtnEmailSearch = new JRadioButton("Email Search");
		rdbtnEmailSearch.setMnemonic('L');
		search.add(rdbtnEmailSearch);
		rdbtnEmailSearch.setForeground(Color.BLUE);
		rdbtnEmailSearch.setBounds(187, 300, 136, 21);
		contentPane.add(rdbtnEmailSearch);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(rdbtnEmailSearch.isSelected()){
					
					int searchemail=Search.searchEmail(textFieldSearch.getText().trim());
					if(searchemail>=0){
						new SearchDisplay(searchemail);
					}
					else{
						JOptionPane.showMessageDialog(null, "NOT FOUND");
					}
					
				}
				else if(rdbtnId.isSelected()){
				
					 int idfoundpos = Search.searchId(textFieldSearch.getText().trim());
                     
                     if(idfoundpos >= 0)
                     {
                          new SearchDisplay(idfoundpos);
                     }
                     else
                     {
                         JOptionPane.showMessageDialog(null, "ID NOT FOUND");
                     }
				}
			
				
			}
		});
		btnSearch.setToolTipText("Searches by the category selected");
		btnSearch.setMnemonic('S');
		btnSearch.setForeground(Color.BLUE);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearch.setBounds(631, 281, 89, 34);
		contentPane.add(btnSearch);
		
		textFieldApproveEmail = new JTextField();
		textFieldApproveEmail.setBounds(414, 133, 288, 33);
		contentPane.add(textFieldApproveEmail);
		textFieldApproveEmail.setColumns(10);
		
		textFieldEmpappid = new JTextField();
		textFieldEmpappid.setColumns(10);
		textFieldEmpappid.setBounds(414, 177, 288, 33);
		contentPane.add(textFieldEmpappid);
		
		
		JLabel lblEnterEmailTo = new JLabel("Enter Email to Approve:");
		lblEnterEmailTo.setForeground(Color.RED);
		lblEnterEmailTo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterEmailTo.setBounds(220, 133, 196, 31);
		contentPane.add(lblEnterEmailTo);
		
		JButton btnApprove = new JButton("Approve");
		btnApprove.setMnemonic('A');
		btnApprove.setToolTipText("Approve the registered employee");
		btnApprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int searchemail=Search.searchEmail(textFieldApproveEmail.getText().trim());
				int searchidreg= Search.searchId(textFieldEmpappid.getText().trim());
				if(searchemail >= 0 && searchidreg<0){
					
					createObjRegInfo();
	            	
	            	
	                JOptionPane.showMessageDialog(null,"Approved");
	                new CopyRegToLeave(textFieldEmpappid.getText().trim());
	                dispose();
	                ManagerHome.main(null);
	                
				}
				else{
					JOptionPane.showMessageDialog(null, "Not Found or Employee ID exists already");
				}
				
				
				
			}
		});
		btnApprove.setForeground(Color.BLUE);
		btnApprove.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnApprove.setBounds(594, 221, 106, 33);
		contentPane.add(btnApprove);
		
		JLabel lblGiveEmployeeId = new JLabel("Give Employee ID:");
		lblGiveEmployeeId.setForeground(new Color(255, 0, 0));
		lblGiveEmployeeId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGiveEmployeeId.setBounds(266, 176, 196, 31);
		contentPane.add(lblGiveEmployeeId);
		
		JLabel label = new JLabel("\u00A9Coder 4S");
		label.setForeground(new Color(0, 128, 0));
		label.setBounds(641, 331, 83, 14);
		contentPane.add(label);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Logout.main(null);
				
			}
		});
		btnLogOut.setForeground(Color.RED);
		btnLogOut.setFont(new Font("Sitka Text", Font.BOLD, 12));
		btnLogOut.setMnemonic('O');
		btnLogOut.setBounds(631, 32, 89, 23);
		contentPane.add(btnLogOut);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setToolTipText("Refresh this page");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				ManagerHome.main(null);
			}
		});
		btnRefresh.setMnemonic('R');
		btnRefresh.setForeground(Color.RED);
		btnRefresh.setFont(new Font("Sitka Text", Font.BOLD, 12));
		btnRefresh.setBounds(528, 32, 89, 23);
		contentPane.add(btnRefresh);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Employee Appraisal System Images Path\\bak.jpg"));
		label_1.setBounds(0, 23, 743, 333);
		contentPane.add(label_1);
		
		
		
		
	}
	
	
	public void ApprovalRequestList(){
		
		new Search();
		
		
		
	}
	
public void createObjRegInfo() {
		
	int searchemail=Search.searchEmail(textFieldApproveEmail.getText().trim());
	employeelist2=UserDataReadWriteFromFile.readDataFromFile();
	employeelist2.get(searchemail).setApprovalstatus("1");
	employeelist2.get(searchemail).setEmployeeid(textFieldEmpappid.getText());
	UserDataReadWriteFromFile.writeDatatoFile(employeelist2);
	
		
}
}
