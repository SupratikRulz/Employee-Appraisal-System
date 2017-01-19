package manager;


import java.util.ArrayList;

import employee.EmployeeLeaveInfo;
import manager.LeaveReadWrite;



public class DeleteLeaveInfo {
	
	

	public static void deleteInfoData(int index)
	{
		ArrayList<EmployeeLeaveInfo> list1;
		
		list1=LeaveReadWrite.readAppFromFile();
		
		list1.remove(index);
		 
		LeaveReadWrite.writeApptoFile(list1);
		
		}
	
	

}
