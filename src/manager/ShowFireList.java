package manager;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import manager.EmployeeFireInfo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.awt.Toolkit;

public class ShowFireList extends JFrame{
	
	
	

		private static final long serialVersionUID = 1L;

		public ShowFireList()
		{
			super("Fired List Of Employees");
			setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Supratik Rulz\\Desktop\\Java Programs\\EmpDemo\\Coder4S.png"));
			String heading[]={"Employee ID","Name","Sex","Email Id","Address","Marital Status","Phone Number","DOB","Dept","Password"};
			String data[][];
			ArrayList<EmployeeFireInfo> list;
			try
			{
				list = FireDataReadWrite.readDataFromFile();
				
				data = new String[list.size()][10];
				
				
				int r=0;
				if(list.isEmpty()){
					JOptionPane.showMessageDialog(null,"No Fired Employee");
				}
				for(int i=0;i<list.size();i++)
				{
					
					data[r][0]=list.get(i).getEmployeeid();
					data[r][1]=list.get(i).getName();
					data[r][2]=list.get(i).getSex();
					data[r][3]=list.get(i).getEmailid();
					data[r][4]=list.get(i).getAddress();
					data[r][5]=list.get(i).getMarstatus();
					data[r][6]=list.get(i).getPhno();
					data[r][7]=list.get(i).getDob();
					data[r][8]=list.get(i).getDept();
					data[r][9]=list.get(i).getPassword();
				
					r++;
					
				}
				
				
				Container con=getContentPane();
				con.setLayout(new BorderLayout());
				
				JTable datatable=new JTable(data, heading);
				JScrollPane jsp=new JScrollPane(datatable);
				datatable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				for(int i=0;i<10;i++){
					datatable.getColumnModel().getColumn(i).setPreferredWidth(200);
				}
				
				con.add(new JLabel("All Employee Fired Details"),BorderLayout.NORTH);
				con.add(jsp,BorderLayout.CENTER);
				
				setSize(1366,600);
				
				setLocation(0,0);
				setVisible(true);
			}catch(Exception e)
			{
				
				e.printStackTrace();
			}
			
		}
	}


