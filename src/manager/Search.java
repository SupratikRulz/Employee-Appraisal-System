package manager;


import employee.*;

import java.util.ArrayList;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.Serializable;
import java.util.ArrayList;


public class Search extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	
	public static int searchId(String id)
	{
		
		ArrayList<EmployeeRegistrationInfo> list2;
		int f = -1;
		try
		{
			list2=UserDataReadWriteFromFile.readDataFromFile();
			
			for(int p=0; p<list2.size(); p++)
			{
				if(id.equals(list2.get(p).getEmployeeid()))
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
	
	
	public static int searchEmail(String e){
		
		
		ArrayList<EmployeeRegistrationInfo> list2;
		int f = -1;
		try
		{
			list2=UserDataReadWriteFromFile.readDataFromFile();
			
			for(int p=0; p<list2.size(); p++)
			{
				if(e.equals(list2.get(p).getEmailid()))
				{
				   f = p;
				   break;
				}	
			}
			 
			return(f);
		}catch(Exception arg)
		{
			System.out.println(arg);
			return(-2);
		}
		
	
		}
	
	Search(){
		super("List of Approval Request");
		String heading[]={"Name","Sex","Email Id","Address","Marital Status","Phone Number","DOB","Dept","Password"};
		ArrayList<EmployeeRegistrationInfo> list4=new ArrayList<EmployeeRegistrationInfo>();
		
		
		ArrayList<EmployeeRegistrationInfo> list3;
		
		
		list3=UserDataReadWriteFromFile.readDataFromFile();
		String data[][]=new String[list3.size()][9];
			
		
			
			
		for(int i=0;i<list3.size();i++){
				if("0".equals(list3.get(i).getApprovalstatus())){
					
					list4.add(list3.get(i));
					
				}
		
		}
			
		int r=0;
		for(EmployeeRegistrationInfo re : list4)
		{
			data[r][0]=re.getName();
			data[r][1]=re.getSex();
			data[r][2]=re.getEmailid();
			data[r][3]=re.getAddress();
			data[r][4]=re.getMarstatus();
			data[r][5]=re.getPhno();
			data[r][6]=re.getDob();
			data[r][7]=re.getDept();
			data[r][8]=re.getPassword();
			r++;
			
			
			
		}
		Container con=getContentPane();
		con.setLayout(new BorderLayout());
		
		
		JTable datatable=new JTable(data, heading);
		JScrollPane jsp=new JScrollPane(datatable);
		datatable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for(int i=0;i<=8;i++){
			datatable.getColumnModel().getColumn(i).setPreferredWidth(200);
		}
		
		con.add(new JLabel("All Approval Requests"),BorderLayout.NORTH);
		con.add(jsp,BorderLayout.CENTER);
		
		setSize(1366, 768);
		
		setLocation(0, 0);
		setVisible(true);
	}
 	
	

}
