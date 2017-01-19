package manager;

import employee.EmployeeLeaveInfo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import employee.EmployeeLeaveInfo;

public class showLeaves extends JFrame{
	
	
	public showLeaves() {
		
		super("List of Leaves");
		String heading[]={"Employee ID","Status","Date of Leave","Duration of leave","Type of leave","Reason","Total number of Leaves"};
			
		
		
	ArrayList<EmployeeLeaveInfo> list3=LeaveReadWrite.readAppFromFile();
		String data[][]=new String[list3.size()][7];
	
			
		int r=0;
		for(EmployeeLeaveInfo re : list3)
		{
			data[r][0]=re.getEmployeeid();
			data[r][1]=re.getStatus();
			data[r][2]=re.getDays();
			data[r][3]=re.getDurationofleave();
			data[r][4]=re.getTypeofleave();
			data[r][5]=re.getReason();
			data[r][6]=re.getNumberofleaves();
			r++;
			
			
			
		}
		Container con=getContentPane();
		con.setLayout(new BorderLayout());
		
		
		JTable datatable=new JTable(data, heading);
		JScrollPane jsp=new JScrollPane(datatable);
		datatable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for(int i=0;i<=6;i++){
			datatable.getColumnModel().getColumn(i).setPreferredWidth(200);
		}
		
		con.add(new JLabel("All Leave Details"),BorderLayout.NORTH);
		con.add(jsp,BorderLayout.CENTER);
		
		setSize(1366, 600);
		
		setLocation(0, 0);
		setVisible(true);
	}

}
