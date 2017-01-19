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

public class ShowAppraisalList extends JFrame {
	
	public ShowAppraisalList() {
		
		super("List of Appraisal");
		String heading[]={"Employee ID","Employee leadearship","Employee teamwork",
				"Employee customer satisfaction","Employee discipline","Employee punctuality",
				"Employee nextyeargoals","Date Appraised","Manager leadearship",
				"Manager teamwork", "Manager customer satisfaction",
				"Manager discipline","Manager punctuality","approveflag","Employee Comment","Grade"};
			
		
		
	ArrayList<EmployeeAppraisal_Info> list3=AppDataReadWrite.readAppFromFile();
		String data[][]=new String[list3.size()][16];
	
			
		int r=0;
		for(EmployeeAppraisal_Info re : list3)
		{
			data[r][0]=re.getEmployeeid();
			data[r][1]=re.getLeadearship();
			data[r][2]=re.getTeamwork();
			data[r][3]=re.getCustomersatisfaction();
			data[r][4]=re.getDiscipline();
			data[r][5]=re.getPunctuality();
			data[r][6]=re.getNextyeargoals();
			data[r][7]=re.getDate1();
			data[r][8]=re.getManleadearship();
			data[r][9]=re.getManteamwork();
			data[r][10]=re.getMancustomersatisfaction();
			data[r][11]=re.getMandiscipline();
			data[r][12]=re.getManpunctuality();
			data[r][13]=re.getApproveflag();
			data[r][14]=re.getEmpcomment();
			data[r][15]=String.valueOf(re.getAverage());
			r++;
			
			
			
		}
		Container con=getContentPane();
		con.setLayout(new BorderLayout());
		
		
		JTable datatable=new JTable(data, heading);
		JScrollPane jsp=new JScrollPane(datatable);
		datatable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		for(int i=0;i<=15;i++){
			datatable.getColumnModel().getColumn(i).setPreferredWidth(200);
		}
		
		con.add(new JLabel("All Registration Details"),BorderLayout.NORTH);
		con.add(jsp,BorderLayout.CENTER);
		
		setSize(1366,600);
		
		setLocation(0, 0);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
