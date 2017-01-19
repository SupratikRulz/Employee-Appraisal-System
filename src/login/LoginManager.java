package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import manager.ManagerHome;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class LoginManager extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldusername;
	private JPasswordField passwordFielduserpass;
	private JLabel lblUserId;
	private JLabel lblPassword;
	private JLabel label;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginManager frame = new LoginManager();
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
	public LoginManager() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Employee Appraisal System Images Path\\Coder4S.png"));
		setTitle("Login Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 248);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldusername = new JTextField();
		textFieldusername.setBounds(10, 55, 200, 29);
		contentPane.add(textFieldusername);
		textFieldusername.setColumns(10);
		
		passwordFielduserpass = new JPasswordField();
		passwordFielduserpass.setBounds(282, 55, 200, 29);
		contentPane.add(passwordFielduserpass);
		
		lblUserId = new JLabel("User ID:");
		lblUserId.setForeground(new Color(0, 0, 0));
		lblUserId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUserId.setBounds(10, 11, 112, 29);
		contentPane.add(lblUserId);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(282, 11, 112, 29);
		contentPane.add(lblPassword);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setToolTipText("Login to your account");
		btnSignIn.setMnemonic('S');
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(textFieldusername.getText().equals("Manager") && passwordFielduserpass.getText().equals("123")){
					dispose();
					ManagerHome.main(null);
				
				}
				else{
					
					JOptionPane.showMessageDialog(null, "Incorrect Login");
					
				}
			}
		});
		btnSignIn.setForeground(Color.BLUE);
		btnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSignIn.setBounds(393, 122, 89, 23);
		contentPane.add(btnSignIn);
		
		label = new JLabel("\u00A9Coder 4S");
		label.setForeground(new Color(0, 128, 0));
		label.setBounds(426, 184, 83, 14);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Employee Appraisal System Images Path\\background.jpg"));
		label_1.setBounds(0, -1, 519, 210);
		contentPane.add(label_1);
	}
}
