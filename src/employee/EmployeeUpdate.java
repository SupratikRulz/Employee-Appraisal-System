package employee;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.awt.SystemColor;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Scanner;

import employee.EmployeeRegistrationInfo;

import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class EmployeeUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldphno;
	private JTextField textFielemail;
	private JPasswordField passwordFieldpass;
	private ArrayList<EmployeeRegistrationInfo> list8=UserDataReadWriteFromFile.readDataFromFile();
	private JTextArea  textAreaAddress;
	private Scanner sc2;
	private Scanner sc1;
	private Scanner sc3;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args,int i) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeUpdate frame = new EmployeeUpdate(i);
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
	public EmployeeUpdate(int i) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Employee Appraisal System Images Path\\Coder4S.png"));
		setTitle("Update Informations");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 426);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setForeground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNumber.setForeground(Color.RED);
		lblPhoneNumber.setBounds(10, 28, 117, 24);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblEmailId = new JLabel("Email ID:");
		lblEmailId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmailId.setForeground(Color.RED);
		lblEmailId.setBounds(10, 84, 117, 24);
		contentPane.add(lblEmailId);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setForeground(Color.RED);
		lblAddress.setBounds(10, 148, 117, 24);
		contentPane.add(lblAddress);
		
		textFieldphno = new JTextField();
		textFieldphno.setText(list8.get(i).getPhno());
		
		textFieldphno.setBackground(Color.WHITE);
		textFieldphno.setForeground(Color.BLACK);
		textFieldphno.setBounds(141, 28, 347, 24);
		contentPane.add(textFieldphno);
		textFieldphno.setColumns(10);
		
		textFielemail = new JTextField();
		textFielemail.setText(list8.get(i).getEmailid());
		textFielemail.setBackground(Color.WHITE);
		textFielemail.setForeground(Color.BLACK);
		textFielemail.setColumns(10);
		textFielemail.setBounds(141, 84, 347, 24);
		contentPane.add(textFielemail);
		
		textAreaAddress = new JTextArea();
		textAreaAddress.setText(list8.get(i).getAddress());
		textAreaAddress.setBackground(Color.WHITE);
		textAreaAddress.setForeground(Color.BLACK);
		textAreaAddress.setBounds(141, 148, 347, 102);
		contentPane.add(textAreaAddress);
		

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setForeground(Color.RED);
		lblPassword.setBounds(10, 275, 117, 24);
		contentPane.add(lblPassword);
		
		/*JLabel lblReenterPassword = new JLabel("Re-enter Password:");
		lblReenterPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReenterPassword.setForeground(Color.RED);
		lblReenterPassword.setBounds(10, 318, 165, 24);
		contentPane.add(lblReenterPassword);*/
		
		passwordFieldpass = new JPasswordField();
		passwordFieldpass.setText(list8.get(i).getPassword());
		passwordFieldpass.setBackground(Color.WHITE);
		passwordFieldpass.setBounds(141, 277, 347, 20);
		contentPane.add(passwordFieldpass);
		
		JLabel label = new JLabel("\u00A9Coder 4S");
		label.setForeground(new Color(0, 128, 0));
		label.setBounds(477, 382, 83, 14);
		contentPane.add(label);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setToolTipText("By clicking this you update your provided informations in text feils");
		btnUpdate.setForeground(Color.BLUE);
		btnUpdate.setMnemonic('U');
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(467, 348, 89, 23);
		contentPane.add(btnUpdate);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Employee Appraisal System Images Path\\background.jpg"));
		label_1.setBounds(0, 0, 566, 397);
		contentPane.add(label_1);
		btnUpdate.addActionListener((e) ->
										{
											
											
											int k= empUpdateddata(i);
											if(k==0){
												UserDataReadWriteFromFile.writeDatatoFile(list8);
												
												 JOptionPane.showMessageDialog(this, "Your personal information is Updated");
												 dispose();
												
												 
												
											}
											
											
										}
										);
		
		
		/*passwordField_1 = new JPasswordField();
		passwordField_1.setBackground(Color.WHITE);
		passwordField_1.setBounds(141, 317, 347, 20);
		contentPane.add(passwordField_1);*/
	}
	
	public int empUpdateddata(int i)
	{
		
		String emailpattern = "^(\\w)+@(\\w+\\.)(\\w+\\.)?[A-Za-z]+$";
		String phnopattern = "^[0-9]{10}$";
		String phno2= textFieldphno.getText();
		sc3 = new Scanner(phno2);
		String email =textFielemail.getText();
    	sc2 = new Scanner(email);
    	String match2 = sc3.findInLine(phnopattern);
    	String match1 = sc2.findInLine(emailpattern);
    	if (match1 == null){
    		JOptionPane.showMessageDialog(null,"Enter Valid Email");
    	/**/textFielemail.setBackground(Color.RED);
    		textFielemail.setForeground(Color.WHITE);
    		return 1;
    	}
    	else if(textAreaAddress.getText().equals("")){
    		JOptionPane.showMessageDialog(null,"Address cannot be empty");
    		textAreaAddress.setBackground(Color.RED);
    		textAreaAddress.setForeground(Color.WHITE);
    		return 1;
    	}
    	else if (match2 == null){
    		
    		JOptionPane.showMessageDialog(null, "Enter Valid Phone Number");
    		
    		
    		textFieldphno.setBackground(Color.RED);
    		textFieldphno.setForeground(Color.WHITE);
    		return 1;
    	}
    	
    	else if(passwordFieldpass.getText().length()<5){
    		JOptionPane.showMessageDialog(null,"Ivalid Password");
    		passwordFieldpass.setBackground(Color.RED);
    		passwordFieldpass.setForeground(Color.WHITE);
    		return 1;
    	}
		
    	else{
		
		
		list8.get(i).setPhno(textFieldphno.getText());
		list8.get(i).setEmailid(textFielemail.getText());
		list8.get(i).setAddress(textAreaAddress.getText());
		list8.get(i).setPassword(passwordFieldpass.getText());
		
		
	
		 return 0;
		 
    	}
	}
}
