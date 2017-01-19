package manager;

import java.util.ArrayList;

import employee.EmployeeAppraisal_Info;
import employee.EmployeeRegistrationInfo;
import employee.UserDataReadWriteFromFile;

public class DeleteInfo 
{
	public static void deleteInfoData(int index)
	{
		ArrayList<EmployeeRegistrationInfo> list1;
		
		list1=UserDataReadWriteFromFile.readDataFromFile();
		
		list1.remove(index);
		 
		UserDataReadWriteFromFile.writeDatatoFile(list1);
		
	}
}