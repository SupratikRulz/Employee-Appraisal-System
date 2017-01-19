package manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import java.util.ArrayList;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class ManagerSetDay extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerSetDay frame = new ManagerSetDay();
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
	public ManagerSetDay() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Employee Appraisal System Images Path\\Coder4S.png"));
		setTitle("Manager Set Last Date of Appraisal");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 175);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSetLastOf = new JLabel("Set Last Day of Appraisal for Employees");
		lblSetLastOf.setForeground(Color.RED);
		lblSetLastOf.setFont(new Font("SketchFlow Print", Font.BOLD, 17));
		lblSetLastOf.setBounds(10, 11, 444, 40);
		contentPane.add(lblSetLastOf);
		
		textField = new JTextField();
		textField.setBounds(110, 76, 78, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		ArrayList<ManSetDay_Info> list1;
		JButton btnSet = new JButton("Set");
		btnSet.setToolTipText("sets the last day of appraisal for employees");
		btnSet.setMnemonic('S');
		btnSet.setForeground(Color.BLUE);
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
														
														addDateInfo();
				
			}
		});
		btnSet.setBounds(222, 76, 78, 30);
		contentPane.add(btnSet);
		
		JLabel label = new JLabel("\u00A9Coder 4S");
		label.setForeground(new Color(0, 128, 0));
		label.setBounds(351, 121, 83, 14);
		contentPane.add(label);
		
		JLabel lblNeLabel = new JLabel("Ne label");
		lblNeLabel.setIcon(new ImageIcon("C:\\Employee Appraisal System Images Path\\background.jpg"));
		lblNeLabel.setBounds(0, 0, 444, 146);
		contentPane.add(lblNeLabel);
	}
	ArrayList< ManSetDay_Info> list;
	ManSetDay_Info re;
	public void createObjDateInfo() {
		
		int day;
		day=Integer.parseInt(textField.getText());
		re=new ManSetDay_Info(day);
}
	private void addDateInfo() {
		
		createObjDateInfo();
		
			int con1=JOptionPane.showConfirmDialog(this, "Are You Sure to set date?");
		
     	 if(con1==JOptionPane.YES_OPTION)
		 {
		  list = SetDayReadWriteFile.readDateFromFile();
		  
			
		   list.add(re);
			
		   SetDayReadWriteFile.writeDatatoFile(list);
		   
			
		   JOptionPane.showMessageDialog(this, "Successfully set");
		   dispose();
		 }
	}
}