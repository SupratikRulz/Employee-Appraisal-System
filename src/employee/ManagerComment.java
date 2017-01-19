package employee;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.Color;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Font;

public class ManagerComment extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,int index) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerComment frame = new ManagerComment(index);
					frame.setVisible(true);
				} catch (Exception e) {
					
					JOptionPane.showMessageDialog(null, "Sorry no comments available");
					
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManagerComment(int index) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Employee Appraisal System Images Path\\Coder4S.png"));
		setResizable(false);
		ArrayList<EmployeeRegistrationInfo> manager=UserDataReadWriteFromFile.readDataFromFile();
		setTitle("Manager Comment Window");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 421);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblManager = new JLabel("Manager Comment");
		lblManager.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblManager.setForeground(Color.RED);
		lblManager.setBounds(10, 11, 145, 27);
		contentPane.add(lblManager);
		
		String id=manager.get(index).getEmployeeid();
		
		int indexofappdata=searchIdAppData(id);
		ArrayList<EmployeeAppraisal_Info> comment=AppDataReadWrite.readAppFromFile();
		
		JLabel lblmanagercomment = new JLabel(comment.get(indexofappdata).getMancomment());
		lblmanagercomment.setForeground(SystemColor.desktop);
		lblmanagercomment.setVerticalAlignment(SwingConstants.TOP);
		lblmanagercomment.setBounds(10, 49, 472, 141);
		contentPane.add(lblmanagercomment);
		
		JTextArea textAreaemployeecomment = new JTextArea();
		textAreaemployeecomment.setBounds(10, 201, 362, 162);
		contentPane.add(textAreaemployeecomment);
		
		JButton btnReply = new JButton("Reply");
		btnReply.setToolTipText("Reply to comment of Manager");
		btnReply.setMnemonic('R');
		btnReply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				comment.get(indexofappdata).setEmpcomment(textAreaemployeecomment.getText());
				AppDataReadWrite.writeApptoFile(comment);
				JOptionPane.showMessageDialog(null, "Replied Successfuly");
				dispose();
				
			}
		});
		btnReply.setForeground(Color.BLUE);
		btnReply.setBounds(393, 340, 89, 23);
		contentPane.add(btnReply);
		
		JLabel label = new JLabel("\u00A9Coder 4S");
		label.setForeground(new Color(0, 128, 0));
		label.setBounds(403, 374, 83, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Employee Appraisal System Images Path\\background.jpg"));
		label_1.setBounds(0, 0, 502, 392);
		contentPane.add(label_1);
	}
	
	
	public int searchIdAppData(String s){
		

		ArrayList<EmployeeAppraisal_Info> list2;
		int f = -1;
		try
		{
			list2=AppDataReadWrite.readAppFromFile();
			
			for(int p=0; p<list2.size(); p++)
			{
				if(s.equals(list2.get(p).getEmployeeid()))
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
