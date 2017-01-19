package employee;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import manager.LeaveReadWrite;
import manager.MessageInfo;
import manager.MessageReadWrite;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Toolkit;

public class ShowMessageByManager extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String id,int i) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowMessageByManager frame = new ShowMessageByManager(id,i);
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "No Message Available");
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShowMessageByManager(String id,int i) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Employee Appraisal System Images Path\\Coder4S.png"));
		setTitle("Manager Message");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMessageDate = new JLabel("Message");
		lblMessageDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMessageDate.setForeground(Color.RED);
		lblMessageDate.setBounds(25, 11, 136, 29);
		contentPane.add(lblMessageDate);
		
		int indexofmsg=searchIdinMessage(id);
		list4=MessageReadWrite.readDataFromFile();
		
		
		
		
		JLabel lblDynamicMessage = new JLabel(list4.get(indexofmsg).getMessage());
		lblDynamicMessage.setForeground(Color.BLACK);
		lblDynamicMessage.setVerticalAlignment(SwingConstants.TOP);
		lblDynamicMessage.setBounds(10, 57, 414, 177);
		contentPane.add(lblDynamicMessage);
		
		JLabel label = new JLabel("\u00A9Coder 4S");
		label.setForeground(new Color(0, 128, 0));
		label.setBounds(341, 236, 83, 14);
		contentPane.add(label);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});
		btnOk.setForeground(Color.BLUE);
		btnOk.setBounds(335, 7, 89, 23);
		contentPane.add(btnOk);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Employee Appraisal System Images Path\\background.jpg"));
		label_1.setBounds(0, 0, 434, 261);
		contentPane.add(label_1);
	}
	ArrayList<MessageInfo> list4;
public int searchIdinMessage(String id){
		
		ArrayList<MessageInfo> list2;
		int f = -1;
		try
		{
			list2=MessageReadWrite.readDataFromFile();
			
			for(int p=0; p<list2.size(); p++)
			{
				if(id.equals(list2.get(p).getId()))
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
