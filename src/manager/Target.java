package manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Toolkit;
import java.awt.SystemColor;



import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;



import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;



import employee.EmployeeHome;
import employee.EmployeeUpdate;
import javax.swing.ImageIcon;

public class Target extends JFrame {

	private JPanel contentPane;
	private JTextArea textAreaTarget;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Target frame = new Target();
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
	public Target() {
		ArrayList<TargetInfo> list=TargetReadWrite.readTargetFromFile();
		setResizable(false);
		setTitle("Set Target of Month");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Supratik Rulz\\Desktop\\Java Programs\\EmpDemo\\Coder4S.png"));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textAreaTarget = new JTextArea();
		textAreaTarget.setText(" ");
		textAreaTarget.setBounds(20, 33, 389, 166);
		contentPane.add(textAreaTarget);
		
		JButton btnSetTarget = new JButton("Set Target");
		btnSetTarget.setForeground(Color.BLUE);
		btnSetTarget.setBounds(270, 210, 139, 23);
		contentPane.add(btnSetTarget);
		btnSetTarget.addActionListener((e) ->
		{if(textAreaTarget.getText().equals(" ")){
			JOptionPane.showMessageDialog(null, "Cannot set Target");
		}
		else{
			createTargetInfo();
			list.add(r);
			TargetReadWrite.writeTargettoFile(list);
			JOptionPane.showMessageDialog(null,"Target Set");
			dispose();
			
			
		}
		}
		);
		
		JLabel label = new JLabel("\u00A9Coder 4S");
		label.setForeground(new Color(0, 128, 0));
		label.setBounds(326, 246, 83, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Employee Appraisal System Images Path\\background.jpg"));
		label_1.setBounds(0, 0, 444, 271);
		contentPane.add(label_1);
	}
	
	TargetInfo r; 
	public void createTargetInfo()
	{
		String s=textAreaTarget.getText();
		r=new TargetInfo(s);
	}
}
