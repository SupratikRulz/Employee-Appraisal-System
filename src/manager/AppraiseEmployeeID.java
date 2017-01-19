package manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import employee.AppDataReadWrite;
import employee.EmployeeAppraisal_Info;
import employee.EmployeeRegistrationInfo;
import employee.UserDataReadWriteFromFile;

public class AppraiseEmployeeID extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldsearchempid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppraiseEmployeeID frame = new AppraiseEmployeeID();
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
	public AppraiseEmployeeID() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Employee Appraisal System Images Path\\Coder4S.png"));
		setResizable(false);
		setTitle("Appraise Employee");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 173);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterEmployeeId = new JLabel("Enter Employee ID to Appraise");
		lblEnterEmployeeId.setForeground(Color.RED);
		lblEnterEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterEmployeeId.setBounds(10, 23, 215, 28);
		contentPane.add(lblEnterEmployeeId);
		
		textFieldsearchempid = new JTextField();
		textFieldsearchempid.setBounds(10, 62, 215, 20);
		contentPane.add(textFieldsearchempid);
		textFieldsearchempid.setColumns(10);
		
		JButton btnNewButton = new JButton("Get Appraise Form");
		btnNewButton.setToolTipText("get the appraisal form for entered employee id");
		btnNewButton.setMnemonic('G');
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=searchIdinappraise(textFieldsearchempid.getText());
				if(id>=0){
					ManagerEmployeeAppraisal.main(null,id);
					dispose();
					ManagerHome.main(null);
				}
				else{
					JOptionPane.showMessageDialog(null, "Please Enter Valid ID");
				}
				
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(248, 61, 145, 23);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("\u00A9Coder 4S");
		label.setForeground(new Color(0, 128, 0));
		label.setBounds(351, 119, 83, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Employee Appraisal System Images Path\\background.jpg"));
		label_1.setBounds(0, 0, 444, 144);
		contentPane.add(label_1);
	}
	
	public int searchIdinappraise(String id){
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
