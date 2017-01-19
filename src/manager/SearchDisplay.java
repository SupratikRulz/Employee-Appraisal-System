package manager;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import employee.EmployeeRegistrationInfo;
import employee.UserDataReadWriteFromFile;

public class SearchDisplay extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	public SearchDisplay(int index)
	{
		super("Email Search Window");
		String heading[]={"Name","Sex","Email Id","Address","Marital Status","Phone Number","DOB","Dept","Password"};
		String data[][] = new String[1][9];
		ArrayList<EmployeeRegistrationInfo> list6;
		try
		{
			list6 = UserDataReadWriteFromFile.readDataFromFile();
					
			EmployeeRegistrationInfo re = list6.get(index);
			
			int r = 0;
			data[r][0]=list6.get(index).getName();
			data[r][1]=list6.get(index).getSex();
			data[r][2]=list6.get(index).getEmailid();
			data[r][3]=list6.get(index).getAddress();
			data[r][4]=list6.get(index).getMarstatus();
			data[r][5]=list6.get(index).getPhno();
			data[r][6]=list6.get(index).getDob();
			data[r][7]=list6.get(index).getDept();
			data[r][8]=list6.get(index).getPassword();
			r++;
					
			Container con=getContentPane();
			con.setLayout(new BorderLayout());
			
			JTable datatable=new JTable(data, heading);
			JScrollPane jsp=new JScrollPane(datatable);
			datatable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			for(int i=0;i<=8;i++){
				datatable.getColumnModel().getColumn(i).setPreferredWidth(200);
			}
			
			con.add(new JLabel("Information Details"),BorderLayout.NORTH);
			con.add(jsp,BorderLayout.CENTER);
			
			setSize(1366,600);
			
			setLocation(0, 0);
			setVisible(true);
				
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}

