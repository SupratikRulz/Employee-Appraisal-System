package manager;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import employee.AppDataReadWrite;
import employee.EmployeeAppraisal_Info;
import employee.EmployeeRegistrationInfo;
import employee.UserDataReadWriteFromFile;

public class BestEmployee extends JFrame {
	
	
	BestEmployee(){
		
		super("List of Best Employees");
		
		ArrayList<EmployeeAppraisal_Info> listappraisal=AppDataReadWrite.readAppFromFile();
		ArrayList<EmployeeAppraisal_Info> list=new ArrayList<EmployeeAppraisal_Info>();
		ArrayList<EmployeeRegistrationInfo> list2=UserDataReadWriteFromFile.readDataFromFile();
		
		String heading[]={"Employee ID","Employee Name","Employee Grade","Email ID","Phone Number"};
		String data[][]=new String[listappraisal.size()][5];
		int r=0;
		
		for(int i=0;i<listappraisal.size();i++){
				listappraisal.get(i).setAverage((Double.parseDouble(listappraisal.get(i).getMancustomersatisfaction())+Double.parseDouble(listappraisal.get(i).getMandiscipline())+Double.parseDouble(listappraisal.get(i).getManleadearship())+Double.parseDouble(listappraisal.get(i).getManpunctuality())+Double.parseDouble(listappraisal.get(i).getManteamwork()))/5);
				if(listappraisal.get(i).getAverage()>=4.25){
					list.add(listappraisal.get(i));
					String id=listappraisal.get(i).getEmployeeid();
					int indexofreginfo=Search.searchId(id);
				
					data[r][0]=list.get(r).getEmployeeid();
					data[r][1]=list2.get(indexofreginfo).getEmployeeid();
					data[r][2]=(String.valueOf(list.get(r).getAverage()));
					data[r][3]=list2.get(indexofreginfo).getEmailid();
					data[r][4]=list2.get(indexofreginfo).getPhno();
					r++;
					
				}
		
		}
		Container con=getContentPane();
		con.setLayout(new BorderLayout());
		
		
		JTable datatable=new JTable(data, heading);
		JScrollPane jsp=new JScrollPane(datatable);
		datatable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		/*for 
		 * making
		 *  table 
		 *  larger 
		 *   */
		
		
		for(int i=0;i<=4;i++){
			datatable.getColumnModel().getColumn(i).setPreferredWidth(200);
		}
		
		con.add(new JLabel("Best Employees"),BorderLayout.NORTH);
		con.add(jsp,BorderLayout.CENTER);
		
		setSize(1366, 600);
		
		setLocation(0, 0);
		setVisible(true);
		
	}
	
	

}
