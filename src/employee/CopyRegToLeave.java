package employee;
import java.util.ArrayList;

import manager.LeaveReadWrite;

public class CopyRegToLeave {
	
	

	EmployeeLeaveInfo r;
	public CopyRegToLeave(String s){
		ArrayList<EmployeeLeaveInfo> leave=LeaveReadWrite.readAppFromFile();
			
			r=new EmployeeLeaveInfo(s,"");
			
			leave.add(r);
			LeaveReadWrite.writeApptoFile(leave);
		
		
		
	}

}
