package employee;

import java.awt.BorderLayout;
import java.awt.EventQueue;





import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;





import java.awt.Toolkit;





import javax.swing.JLabel;
import javax.swing.JButton;





import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.util.ArrayList;





import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

import java.time.LocalDate;
import java.time.LocalDateTime;

import manager.LeaveReadWrite;

import javax.swing.ImageIcon;

public class Leave extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFielddateoftakingleave;
	private JTextField textFieldDuration;
	ArrayList<EmployeeRegistrationInfo> list=UserDataReadWriteFromFile.readDataFromFile();
	ArrayList<EmployeeLeaveInfo> listleave=LeaveReadWrite.readAppFromFile();
	private JTextArea textAreaReason;
	private JRadioButton rdbtnSl ;
	private JRadioButton rdbtnPl;
	private JRadioButton rdbtnCl;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args,int index) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Leave frame = new Leave(index);
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
	public Leave(int index) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Employee Appraisal System Images Path\\Coder4S.png"));
		setTitle("Leave Form");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 366);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		LocalDate today=LocalDate.now();
		int day=today.getDayOfMonth();
		int month=today.getMonthValue();
		int year=today.getYear();
		
		JLabel lblDdmmyyyy_1 = new JLabel("dd/mm/yyyy");
		lblDdmmyyyy_1.setForeground(Color.WHITE);
		lblDdmmyyyy_1.setBounds(275, 85, 86, 23);
		contentPane.add(lblDdmmyyyy_1);
		
		JLabel lblDateOfLeave = new JLabel("Date of  taking leave:");
		lblDateOfLeave.setForeground(Color.BLACK);
		lblDateOfLeave.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateOfLeave.setBounds(10, 84, 159, 23);
		contentPane.add(lblDateOfLeave);
		
		
		JLabel lblDurationOfLeave = new JLabel("Duration of Leave:");
		lblDurationOfLeave.setForeground(Color.BLACK);
		lblDurationOfLeave.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDurationOfLeave.setBounds(10, 53, 159, 23);
		contentPane.add(lblDurationOfLeave);
		
		JLabel lblTypeOfLeave = new JLabel("Type of Leave:");
		lblTypeOfLeave.setForeground(Color.BLACK);
		lblTypeOfLeave.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTypeOfLeave.setBounds(10, 118, 159, 23);
		contentPane.add(lblTypeOfLeave);
		
		JLabel lblReasonForTaking = new JLabel("Reason for taking leave:");
		lblReasonForTaking.setForeground(Color.BLACK);
		lblReasonForTaking.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblReasonForTaking.setBounds(10, 141, 159, 23);
		contentPane.add(lblReasonForTaking);
		
		textAreaReason = new JTextArea();
		textAreaReason.setText(" ");
		textAreaReason.setBounds(10, 169, 378, 151);
		contentPane.add(textAreaReason);
		
		rdbtnCl = new JRadioButton("CL");
		buttonGroup.add(rdbtnCl);
		rdbtnCl.setBackground(SystemColor.inactiveCaption);
		rdbtnCl.setBounds(175, 119, 55, 23);
		contentPane.add(rdbtnCl);
		
		rdbtnPl = new JRadioButton("PL");
		buttonGroup.add(rdbtnPl);
		rdbtnPl.setBackground(SystemColor.inactiveCaption);
		rdbtnPl.setBounds(232, 118, 51, 23);
		contentPane.add(rdbtnPl);
		
		rdbtnSl = new JRadioButton("SL");
		buttonGroup.add(rdbtnSl);
		rdbtnSl.setBackground(SystemColor.inactiveCaption);
		rdbtnSl.setBounds(285, 118, 52, 23);
		contentPane.add(rdbtnSl);
		rdbtnCl.setSelected(true);
		
		textFielddateoftakingleave = new JTextField();
		textFielddateoftakingleave.setText(" ");
		textFielddateoftakingleave.setBounds(179, 86, 86, 20);
		contentPane.add(textFielddateoftakingleave);
		textFielddateoftakingleave.setColumns(10);
		
		textFieldDuration = new JTextField();
		textFieldDuration.setText(" ");
		textFieldDuration.setColumns(10);
		textFieldDuration.setBounds(179, 55, 86, 20);
		contentPane.add(textFieldDuration);
		
		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setForeground(Color.BLACK);
		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmployeeId.setBounds(10, 11, 159, 23);
		contentPane.add(lblEmployeeId);
		
		JLabel lblEmployeeiddynamic = new JLabel(list.get(index).getEmployeeid());
		lblEmployeeiddynamic.setForeground(Color.BLACK);
		lblEmployeeiddynamic.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmployeeiddynamic.setBounds(178, 11, 159, 23);
		contentPane.add(lblEmployeeiddynamic);
		
		JLabel label = new JLabel("\u00A9Coder 4S");
		label.setForeground(new Color(0, 128, 0));
		label.setBounds(408, 306, 83, 14);
		contentPane.add(label);
		
		
		
		
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setMnemonic('S');
		btnSubmit.setForeground(Color.BLUE);
		btnSubmit.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnSubmit.setBounds(398, 273, 89, 23);
		contentPane.add(btnSubmit);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Employee Appraisal System Images Path\\background.jpg"));
		label_1.setBounds(0, 0, 491, 320);
		contentPane.add(label_1);
		
		JLabel lblDdmmyyyy = new JLabel("dd/mm/yyyy");
		lblDdmmyyyy.setBounds(285, 65, 200, 50);
		contentPane.add(lblDdmmyyyy);
		btnSubmit.addActionListener((e) ->
										{
											
											String id=list.get(index).getEmployeeid();
											int indexinleave=searchIdinLeave(id);
											listleave=LeaveReadWrite.readAppFromFile();
											String n=listleave.get(indexinleave).getNumberofleaves();
											int no=Integer.parseInt(n);
											if(textFieldDuration.getText().equals(" ") || textAreaReason.getText().equals(" ") || textFielddateoftakingleave.getText().equals(" ")){
												JOptionPane.showMessageDialog(null, "All feilds are mandatory");
												
											}
										
											
											else{
												String s1=textFielddateoftakingleave.getText().trim();
												int x1=s1.indexOf("/");
												String d1=s1.substring(0,x1);
												d1=d1.trim();
												int x2=s1.indexOf("/", (x1+1));
												String d2=s1.substring((x1+1), x2);
												d2=d2.trim();
												String d3=s1.substring(x2+1);
												d3=d3.trim();
												
								/*1*/			if(Integer.parseInt(d3)>year){
													System.out.println("in 1");
													addLeave(index);
													listleave.get(indexinleave).setStatus("Pending");
													LeaveReadWrite.writeApptoFile(listleave);
													JOptionPane.showMessageDialog(this,"Leave request sent");
													dispose();
													
													
												}
							/*2*/				else if(Integer.parseInt(d3)==year){
													
													if(Integer.parseInt(d2)>month){
														addLeave(index);
														listleave.get(indexinleave).setStatus("Pending");
														LeaveReadWrite.writeApptoFile(listleave);
														JOptionPane.showMessageDialog(this,"Leave request sent");
														dispose();
													}
													else if(Integer.parseInt(d2)<month){
														JOptionPane.showMessageDialog(null, "Invalid Date Entry");
														
													}
													
													else {
														if(Integer.parseInt(d1)>day){
															addLeave(index);
															listleave.get(indexinleave).setStatus("Pending");
															LeaveReadWrite.writeApptoFile(listleave);
															JOptionPane.showMessageDialog(this,"Leave request sent");
															dispose();
															
														}
														else{
															JOptionPane.showMessageDialog(null, "Invalid Date Entry");
															
														}
													
													
													}
												
												}
												else{
													JOptionPane.showMessageDialog(null, "Invalid Date Entry");
													
												}
												
												
											}
											
											
											
											
										});
		
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


public void addLeave(int index){
	
	String i=list.get(index).getEmployeeid();
	int indexinleave=searchIdinLeave(i);

	listleave.get(indexinleave).setDurationofleave(textFieldDuration.getText());
	listleave.get(indexinleave).setDays(textFielddateoftakingleave.getText());
	listleave.get(indexinleave).setReason(textAreaReason.getText());
	if(rdbtnCl.isSelected()){
		listleave.get(indexinleave).setTypeofleave("CL");
	}
	else if(rdbtnPl.isSelected()){
		listleave.get(indexinleave).setTypeofleave("PL");
	}
	else if(rdbtnSl.isSelected()){
		listleave.get(indexinleave).setTypeofleave("SL");
	}
	
	LeaveReadWrite.writeApptoFile(listleave);
	
}
}
