package manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JTextField;

import employee.AppDataReadWrite;
import employee.EmployeeAppraisal_Info;
import employee.EmployeeLeaveInfo;
import employee.EmployeeRegistrationInfo;
import employee.UserDataReadWriteFromFile;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import java.awt.Font;

public class FireEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldFire;
	ArrayList<EmployeeRegistrationInfo> firelistreg=UserDataReadWriteFromFile.readDataFromFile();
	ArrayList<EmployeeFireInfo> firelist=FireDataReadWrite.readDataFromFile();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FireEmployee frame = new FireEmployee();
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
	public FireEmployee() {
		setTitle("Fire Employee");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Employee Appraisal System Images Path\\Coder4S.png"));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 188);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u00A9Coder 4S");
		label.setForeground(new Color(0, 128, 0));
		label.setBounds(309, 137, 83, 14);
		contentPane.add(label);
		
		JLabel lblEnterEmployeeId = new JLabel("Enter Employee ID to Fire:");
		lblEnterEmployeeId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterEmployeeId.setForeground(SystemColor.desktop);
		lblEnterEmployeeId.setBounds(10, 11, 254, 31);
		contentPane.add(lblEnterEmployeeId);
		
		textFieldFire = new JTextField();
		textFieldFire.setBounds(10, 51, 368, 20);
		contentPane.add(textFieldFire);
		textFieldFire.setColumns(10);
		
		JButton btnFire = new JButton("Fire");
		btnFire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				
				
				int indexofreginfo=Search.searchId(textFieldFire.getText().trim());
				String idoffire=firelistreg.get(indexofreginfo).getEmployeeid();
				int indexofleaveifo=searchIdLeave(idoffire);
				int indexofappraisalinfo=searchIdAppraisal(idoffire);
				if(indexofreginfo>=0){
					addFire(indexofreginfo);
					JOptionPane.showMessageDialog(null, "Fired Successfully!!");
					DeleteInfo.deleteInfoData(indexofreginfo);
					DeleteLeaveInfo.deleteInfoData(indexofleaveifo);
					if(indexofappraisalinfo>=0){
						DeleteAppraisalInfo.deleteInfoData(indexofappraisalinfo);
					}
					dispose();
					
				}
				else{
					JOptionPane.showMessageDialog(null, "Enter Valid ID");
					dispose();
					FireEmployee.main(null);
				}
				}catch(Exception h){
					JOptionPane.showMessageDialog(null, "Enter Valid ID");
					
				}
			}
		});
		btnFire.setForeground(Color.RED);
		btnFire.setBounds(299, 94, 89, 23);
		contentPane.add(btnFire);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Employee Appraisal System Images Path\\background.jpg"));
		label_1.setBounds(0, 0, 444, 159);
		contentPane.add(label_1);
		
		
	}
	
	public int searchIdLeave(String id){
		ArrayList<EmployeeLeaveInfo> leavelist=LeaveReadWrite.readAppFromFile();
		
		for(int i=0;i<leavelist.size();i++){
			if((leavelist.get(i).getEmployeeid()).equals(id.trim())){
				return i;
			}
		
	}
		return -2;
	}
	
	public int searchIdAppraisal(String id){
		ArrayList<EmployeeAppraisal_Info> leavelist=AppDataReadWrite.readAppFromFile();
		
		for(int i=0;i<leavelist.size();i++){
			if((leavelist.get(i).getEmployeeid()).equals(id.trim())){
				return i;
			}
		
	}
		return -2;
	}
	EmployeeFireInfo r;
	public void objFire(int i)
	{

		String name,gender,emailid,address,mstatus,phno,dob,dept,password,repassword,empid;
		name=firelistreg.get(i).getName();
		gender=firelistreg.get(i).getSex();
		emailid=firelistreg.get(i).getEmailid();
		address=firelistreg.get(i).getAddress();
		mstatus=firelistreg.get(i).getMarstatus();
		phno=firelistreg.get(i).getPhno();
		dob=firelistreg.get(i).getDob();
		dept=firelistreg.get(i).getDept();
		password=firelistreg.get(i).getPassword();
		empid=firelistreg.get(i).getEmployeeid();
		r=new EmployeeFireInfo(name, gender, emailid, address, mstatus, phno, dob, dept, password,empid);
		
	}
	
	public void addFire(int i)
	{
		objFire(i);
		
		firelist.add(r);
		
		FireDataReadWrite.writeDatatoFile(firelist);
	}
}
