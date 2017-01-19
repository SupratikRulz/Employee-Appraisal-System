package manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.SystemColor;

import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import employee.EmployeeRegistrationInfo;
import employee.UserDataReadWriteFromFile;

public class SendMessageToEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEmployeeid;
	private ArrayList<MessageInfo> msglist;
	private JTextArea textAreaMessage;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SendMessageToEmployee frame = new SendMessageToEmployee();
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
	public SendMessageToEmployee() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Employee Appraisal System Images Path\\Coder4S.png"));
		setTitle("Send Message To Employee");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 306);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textAreaMessage = new JTextArea();
		textAreaMessage.setBounds(10, 29, 414, 151);
		contentPane.add(textAreaMessage);
		
		JLabel lblWriteMessageHere = new JLabel("Write Message Here:");
		lblWriteMessageHere.setForeground(Color.BLACK);
		lblWriteMessageHere.setBounds(10, 11, 189, 14);
		contentPane.add(lblWriteMessageHere);
		
		JLabel lblEmployeeIdTo = new JLabel("Employee ID to send:");
		lblEmployeeIdTo.setForeground(Color.BLACK);
		lblEmployeeIdTo.setBounds(10, 188, 272, 14);
		contentPane.add(lblEmployeeIdTo);
		
		textFieldEmployeeid = new JTextField();
		textFieldEmployeeid.setBounds(10, 213, 312, 20);
		contentPane.add(textFieldEmployeeid);
		textFieldEmployeeid.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				msglist=MessageReadWrite.readDataFromFile();
				if(createMsgObj()==1){
				msglist.add(r);
				MessageReadWrite.writeDatatoFile(msglist);
				
				JOptionPane.showMessageDialog(null, "Message Sent Successfully!!");
				dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "Incorrect ID");
				}
				
				
			}
		});
		btnSend.setForeground(Color.BLUE);
		btnSend.setMnemonic('S');
		btnSend.setBounds(335, 212, 89, 23);
		contentPane.add(btnSend);
		
		JLabel label = new JLabel("\u00A9Coder 4S");
		label.setForeground(new Color(0, 128, 0));
		label.setBounds(341, 247, 83, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Employee Appraisal System Images Path\\background.jpg"));
		label_1.setBounds(0, 0, 434, 267);
		contentPane.add(label_1);
	}
	MessageInfo r;
	public int createMsgObj()
	{
		String no=textFieldEmployeeid.getText().trim();
		String msg=textAreaMessage.getText();
		int flag=0;
		ArrayList<EmployeeRegistrationInfo> chk=UserDataReadWriteFromFile.readDataFromFile();
		for(int k=0;k<chk.size();k++){
			if(chk.get(k).getEmployeeid().equals(no)){
				flag=1;
				break;
			}
		}
		if(flag==1){
		r=new MessageInfo(no, msg);
		}
		return flag;
	}
	

}
