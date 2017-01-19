package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.Font;

import javax.swing.JRadioButton;

import employee.Employee;
import employee.EmployeeHome;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Employee Appraisal System Images Path\\Coder4S.png"));
		setResizable(false);
		setForeground(SystemColor.inactiveCaption);
		setTitle("Login Employee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 214);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setForeground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(30, 47, 183, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Sign In");
		btnLogin.setMnemonic('I');
		btnLogin.setToolTipText("Helps to sign into the account");
		btnLogin.setForeground(Color.BLUE);
		btnLogin.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		btnLogin.setBounds(348, 89, 89, 23);
		contentPane.add(btnLogin);
		btnLogin.addActionListener((e) ->
		                            {
		                            	searchd();
		                            	
		                            }
									);
		
		JLabel lbluserid = new JLabel("User ID");
		lbluserid.setForeground(new Color(0, 0, 0));
		lbluserid.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		lbluserid.setBounds(30, 22, 124, 14);
		contentPane.add(lbluserid);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		lblPassword.setBounds(254, 22, 102, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(254, 47, 183, 20);
		contentPane.add(passwordField);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setToolTipText("Helps to register a new account");
		btnSignUp.setMnemonic('U');
		btnSignUp.setForeground(Color.BLUE);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Employee.main(null);
			}
		});
		btnSignUp.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		btnSignUp.setBounds(348, 125, 89, 23);
		contentPane.add(btnSignUp);
		
		JLabel label = new JLabel("\u00A9Coder 4S");
		label.setForeground(new Color(0, 128, 0));
		label.setBounds(392, 160, 83, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Employee Appraisal System Images Path\\background.jpg"));
		label_1.setBounds(0, 0, 485, 185);
		contentPane.add(label_1);
		
		ButtonGroup login=new ButtonGroup();
	}
	void searchd()
	{
		int index=LoginSearch.searh( textField.getText().trim(), passwordField.getText());
		if(index>=0)
		{	
			dispose();
			EmployeeHome.main(null,index);
		}
		else
		{
			JOptionPane.showMessageDialog(this, "ID or PASSWORD MISMATCH");
        }
		
	}
}
