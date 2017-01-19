package manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JLabel;

import employee.EmployeeLeaveInfo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;



public class grantRequest extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldemployeeid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					grantRequest frame = new grantRequest();
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
	public grantRequest() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Employee Appraisal System Images Path\\Coder4S.png"));
		setTitle("Grant Request Window");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 161);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setForeground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldemployeeid = new JTextField();
		textFieldemployeeid.setBounds(10, 61, 259, 20);
		contentPane.add(textFieldemployeeid);
		textFieldemployeeid.setColumns(10);
		
		JButton btnGrantLeave = new JButton("Grant Leave");
		btnGrantLeave.setToolTipText("grants leave to the employee id entered");
		btnGrantLeave.setMnemonic('G');
		btnGrantLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ArrayList<EmployeeLeaveInfo> leavelist=LeaveReadWrite.readAppFromFile();
				int flag=0;
				for(int i=0;i<leavelist.size();i++){
					if((leavelist.get(i).getEmployeeid()).equals(textFieldemployeeid.getText().trim()) && (leavelist.get(i).getStatus().equals("Pending"))){
						leavelist.get(i).setStatus("Granted");
						int no=Integer.parseInt(leavelist.get(i).getNumberofleaves().trim());
						int n=Integer.parseInt(leavelist.get(i).getDurationofleave().trim());
						no=no+n;
						leavelist.get(i).setNumberofleaves(String.valueOf(no));
						LeaveReadWrite.writeApptoFile(leavelist);
						JOptionPane.showMessageDialog(null, "Leave Granted Successfully");
						dispose();
						flag=1;
						break;
					}
					else{
						//JOptionPane.showMessageDialog(null, "Enter valid ID or already granted");
					}
					
				}
				if(flag==0){
					JOptionPane.showMessageDialog(null, "Enter valid ID or already granted");	
				}
				
			}
		});
		btnGrantLeave.setForeground(Color.BLUE);
		btnGrantLeave.setBounds(279, 60, 116, 23);
		contentPane.add(btnGrantLeave);
		
		JLabel lblEnterEmployeeId = new JLabel("Enter Employee ID to Grant Leave:");
		lblEnterEmployeeId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnterEmployeeId.setForeground(SystemColor.desktop);
		lblEnterEmployeeId.setBounds(10, 21, 385, 31);
		contentPane.add(lblEnterEmployeeId);
		
		JLabel label = new JLabel("\u00A9Coder 4S");
		label.setForeground(new Color(0, 128, 0));
		label.setBounds(341, 97, 83, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Employee Appraisal System Images Path\\background.jpg"));
		label_1.setBounds(0, 0, 434, 122);
		contentPane.add(label_1);
	}
}
