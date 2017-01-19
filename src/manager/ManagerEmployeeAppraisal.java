package manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;

import employee.AppDataReadWrite;
import employee.EmployeeAppraisal_Info;
import employee.EmployeeLeaveInfo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;

import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class ManagerEmployeeAppraisal extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldleadership;
	private JTextField textFieldteamwork;
	private JTextField textFieldcustomersatisfaction;
	private JTextField textFielddiscipline;
	private JTextField textFieldpunctuality;
	ArrayList<EmployeeAppraisal_Info> listofappraisal=AppDataReadWrite.readAppFromFile();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,int i) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerEmployeeAppraisal frame = new ManagerEmployeeAppraisal(i);
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
	public ManagerEmployeeAppraisal(int i) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Employee Appraisal System Images Path\\Coder4S.png"));
		setTitle("Appraise Employee");
		setResizable(false);
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 440);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblleadership = new JLabel("1. Leadership");
		lblleadership.setForeground(Color.BLACK);
		lblleadership.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblleadership.setBounds(11, 115, 94, 20);
		contentPane.add(lblleadership);
		
		JLabel lblteamwork = new JLabel("2. Teamwork");
		lblteamwork.setForeground(Color.BLACK);
		lblteamwork.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblteamwork.setBounds(11, 146, 94, 27);
		contentPane.add(lblteamwork);
		
		JLabel lblcustomersatisfaction = new JLabel("3. Customer Satisfaction");
		lblcustomersatisfaction.setForeground(Color.BLACK);
		lblcustomersatisfaction.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblcustomersatisfaction.setBounds(11, 184, 177, 20);
		contentPane.add(lblcustomersatisfaction);
		
		JLabel lbldiscipline = new JLabel("4. Discipline");
		lbldiscipline.setForeground(Color.BLACK);
		lbldiscipline.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbldiscipline.setBounds(11, 215, 124, 20);
		contentPane.add(lbldiscipline);
		
		JLabel lblpunctuality = new JLabel("5. Punctuality");
		lblpunctuality.setForeground(Color.BLACK);
		lblpunctuality.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblpunctuality.setBounds(10, 257, 124, 20);
		contentPane.add(lblpunctuality);
		
		JLabel lblnextyeargoals = new JLabel("6. Next year Goals");
		lblnextyeargoals.setForeground(Color.BLACK);
		lblnextyeargoals.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblnextyeargoals.setBounds(11, 300, 150, 27);
		contentPane.add(lblnextyeargoals);
		
		JLabel label_6 = new JLabel("                       Instructions:- Outstanding-Grade '5'   ; Excellent -Grade'4'  ;");
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_6.setBounds(30, -13, 667, 60);
		contentPane.add(label_6);
		
		JLabel lblGoodgradeSatisfactorygradeNot = new JLabel("                     Good-Grade'3' Satisfactory-Grade'2'; Not satisfactory-Grade-'1'");
		lblGoodgradeSatisfactorygradeNot.setForeground(Color.RED);
		lblGoodgradeSatisfactorygradeNot.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGoodgradeSatisfactorygradeNot.setBounds(40, 11, 667, 60);
		contentPane.add(lblGoodgradeSatisfactorygradeNot);
		
		JLabel empleadership = new JLabel(listofappraisal.get(i).getLeadearship());
		empleadership.setForeground(Color.RED);
		empleadership.setFont(new Font("Tahoma", Font.PLAIN, 15));
		empleadership.setBounds(211, 115, 94, 20);
		contentPane.add(empleadership);
		
		JLabel lblempteamwork = new JLabel(listofappraisal.get(i).getTeamwork());
		lblempteamwork.setForeground(Color.RED);
		lblempteamwork.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblempteamwork.setBounds(211, 154, 94, 20);
		contentPane.add(lblempteamwork);
		
		JLabel lblemplcustomersatisfaction = new JLabel(listofappraisal.get(i).getCustomersatisfaction());
		lblemplcustomersatisfaction.setForeground(Color.RED);
		lblemplcustomersatisfaction.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblemplcustomersatisfaction.setBounds(211, 189, 94, 20);
		contentPane.add(lblemplcustomersatisfaction);
		
		JLabel lblempdiscipline = new JLabel(listofappraisal.get(i).getDiscipline());
		lblempdiscipline.setForeground(Color.RED);
		lblempdiscipline.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblempdiscipline.setBounds(211, 220, 94, 20);
		contentPane.add(lblempdiscipline);
		
		JLabel lblemppunctuality = new JLabel(listofappraisal.get(i).getPunctuality());
		lblemppunctuality.setForeground(Color.RED);
		lblemppunctuality.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblemppunctuality.setBounds(211, 257, 94, 20);
		contentPane.add(lblemppunctuality);
		
		JLabel lblempnextyeargoals = new JLabel(listofappraisal.get(i).getNextyeargoals());
		lblempnextyeargoals.setVerticalAlignment(SwingConstants.TOP);
		lblempnextyeargoals.setForeground(Color.RED);
		lblempnextyeargoals.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblempnextyeargoals.setBounds(211, 300, 244, 90);
		contentPane.add(lblempnextyeargoals);
		
		textFieldleadership = new JTextField();
		textFieldleadership.setColumns(10);
		textFieldleadership.setBounds(461, 117, 86, 20);
		contentPane.add(textFieldleadership);
		
		textFieldteamwork = new JTextField();
		textFieldteamwork.setColumns(10);
		textFieldteamwork.setBounds(461, 153, 86, 20);
		contentPane.add(textFieldteamwork);
		
		textFieldcustomersatisfaction = new JTextField();
		textFieldcustomersatisfaction.setColumns(10);
		textFieldcustomersatisfaction.setBounds(461, 191, 86, 20);
		contentPane.add(textFieldcustomersatisfaction);
		
		textFielddiscipline = new JTextField();
		textFielddiscipline.setColumns(10);
		textFielddiscipline.setBounds(461, 222, 86, 20);
		contentPane.add(textFielddiscipline);
		
		textFieldpunctuality = new JTextField();
		textFieldpunctuality.setColumns(10);
		textFieldpunctuality.setBounds(461, 257, 86, 20);
		contentPane.add(textFieldpunctuality);
		

		JTextArea textAreacommentmanager = new JTextArea();
		textAreacommentmanager.setBounds(557, 115, 159, 167);
		contentPane.add(textAreacommentmanager);
		
		JLabel lblComment = new JLabel("Comment");
		lblComment.setForeground(Color.BLACK);
		lblComment.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblComment.setBounds(582, 82, 94, 20);
		contentPane.add(lblComment);
		
		JButton btnAppraise = new JButton("Appraise");
		btnAppraise.setToolTipText("Appraise the employee");
		btnAppraise.setMnemonic('A');
		btnAppraise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listofappraisal.get(i).setMancomment(textAreacommentmanager.getText());
				listofappraisal.get(i).setMandiscipline(textFielddiscipline.getText());
				listofappraisal.get(i).setManleadearship(textFieldleadership.getText());
				listofappraisal.get(i).setMancustomersatisfaction(textFieldcustomersatisfaction.getText());
				listofappraisal.get(i).setManpunctuality(textFieldpunctuality.getText());
				listofappraisal.get(i).setManteamwork(textFieldteamwork.getText());
				listofappraisal.get(i).setApproveflag("Manager Approved");
				listofappraisal.get(i).setAverage((Double.parseDouble(listofappraisal.get(i).getMandiscipline())+Double.parseDouble(listofappraisal.get(i).getManpunctuality())+Double.parseDouble(listofappraisal.get(i).getMancustomersatisfaction())+Double.parseDouble(listofappraisal.get(i).getManleadearship())+Double.parseDouble(listofappraisal.get(i).getManteamwork()))/5);
				
				
				AppDataReadWrite.writeApptoFile(listofappraisal);
				JOptionPane.showMessageDialog(null, "Successfully Appraised!!");
				dispose();
				
				
			}
		});
		btnAppraise.setForeground(Color.BLUE);
		btnAppraise.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		btnAppraise.setBounds(608, 330, 108, 33);
		contentPane.add(btnAppraise);
		
		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setForeground(Color.BLACK);
		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeId.setBounds(11, 82, 94, 20);
		contentPane.add(lblEmployeeId);
		
		ArrayList<EmployeeAppraisal_Info> listk=AppDataReadWrite.readAppFromFile();
		
		JLabel lblempiddynamic = new JLabel(listk.get(i).getEmployeeid());
		lblempiddynamic.setForeground(Color.RED);
		lblempiddynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblempiddynamic.setBounds(211, 82, 94, 20);
		contentPane.add(lblempiddynamic);
		
		JLabel lblLeavesTaken = new JLabel("Leaves Taken:");
		lblLeavesTaken.setForeground(Color.BLACK);
		lblLeavesTaken.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLeavesTaken.setBounds(345, 82, 145, 20);
		contentPane.add(lblLeavesTaken);
		
		String leavesdyna = "";
		ArrayList<EmployeeLeaveInfo> listleavestaken=LeaveReadWrite.readAppFromFile();
		for(int j=0;j<listleavestaken.size();j++){
			if(listleavestaken.get(j).getEmployeeid().equals(listk.get(i).getEmployeeid())){
				leavesdyna=listleavestaken.get(j).getNumberofleaves();
				break;
			}
		}
		JLabel lblLeavesdynamic = new JLabel(leavesdyna);
		lblLeavesdynamic.setForeground(Color.RED);
		lblLeavesdynamic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLeavesdynamic.setBounds(453, 82, 94, 20);
		contentPane.add(lblLeavesdynamic);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Employee Appraisal System Images Path\\background.jpg"));
		label.setBounds(0, 0, 736, 411);
		contentPane.add(label);
		
	}
}
