package employee;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import login.LoginSelection;
import java.awt.SystemColor;

public class Logout extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logout frame = new Logout();
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
	public Logout() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Employee Appraisal System Images Path\\logoutgis.png"));
		setTitle("Logout Window");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Employee Appraisal System Images Path\\logoutgis.png"));
		btnNewButton.setToolTipText("Select any one of the option");
		btnNewButton.setBounds(0, 0, 1013, 514);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Old English Text MT", Font.PLAIN, 30));
		btnNewButton_1.setBounds(0, 513, 506, 54);
		contentPane.add(btnNewButton_1);
		
		JButton btnLogInAgain = new JButton("LOG IN AGAIN");
		btnLogInAgain.setBackground(SystemColor.activeCaption);
		btnLogInAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginSelection.main(null);
			}
		});
		btnLogInAgain.setForeground(Color.GREEN);
		btnLogInAgain.setFont(new Font("Old English Text MT", Font.PLAIN, 30));
		btnLogInAgain.setBounds(507, 513, 506, 54);
		contentPane.add(btnLogInAgain);
	}
}
