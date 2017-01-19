package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class LoginSelection extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSelection frame = new LoginSelection();
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
	public LoginSelection() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Employee Appraisal System Images Path\\Coder4S.png"));
		setResizable(false);
		setTitle("Login Selection");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 205);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeSelect = new JLabel("Welcome : Select Yourself");
		lblWelcomeSelect.setBackground(SystemColor.inactiveCaption);
		lblWelcomeSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeSelect.setFont(new Font("Monotype Corsiva", Font.BOLD, 32));
		lblWelcomeSelect.setForeground(new Color(255, 255, 0));
		lblWelcomeSelect.setBounds(0, 11, 444, 70);
		contentPane.add(lblWelcomeSelect);
		
		JRadioButton rdbtnEmployee = new JRadioButton("Employee");
		rdbtnEmployee.setMnemonic('E');
		rdbtnEmployee.setToolTipText("Goes to Employee Login");
		rdbtnEmployee.setBackground(SystemColor.inactiveCaption);
		rdbtnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.main(null);
				dispose();
			}
		});
		rdbtnEmployee.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnEmployee.setForeground(Color.BLUE);
		buttonGroup.add(rdbtnEmployee);
		rdbtnEmployee.setBounds(123, 100, 109, 23);
		contentPane.add(rdbtnEmployee);
		
		JRadioButton rdbtnManager = new JRadioButton("Manager");
		rdbtnManager.setMnemonic('M');
		rdbtnManager.setToolTipText("Goes to Manager Login");
		rdbtnManager.setBackground(SystemColor.inactiveCaption);
		rdbtnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginManager.main(null);
				dispose();
			}
		});
		rdbtnManager.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnManager.setForeground(Color.BLUE);
		buttonGroup.add(rdbtnManager);
		rdbtnManager.setBounds(241, 100, 109, 23);
		contentPane.add(rdbtnManager);
		
		JLabel lblNewLabel = new JLabel("\u00A9Coder 4S");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setBounds(351, 162, 83, 14);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Employee Appraisal System Images Path\\logoutgis.png"));
		label.setBounds(0, 0, 444, 176);
		contentPane.add(label);
	}
}
