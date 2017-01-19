package manager;


import java.util.ArrayList;

import employee.EmployeeAppraisal_Info;
import employee.AppDataReadWrite;


public class DeleteAppraisalInfo {
	

	public static void deleteInfoData(int index)
	{
		ArrayList<EmployeeAppraisal_Info> list1;
		
		list1=AppDataReadWrite.readAppFromFile();
		
		list1.remove(index);
		 
		AppDataReadWrite.writeApptoFile(list1);
		
		}
}
