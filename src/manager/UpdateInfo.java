package manager;
import java.util.ArrayList;

import employee.*;

public class UpdateInfo {
	

	public static void UpdateInfodata(EmployeeRegistrationInfo rg,int index)
	{
		ArrayList<EmployeeRegistrationInfo> list1;
		
		list1=UserDataReadWriteFromFile.readDataFromFile();
		
		list1.set(index, rg);
		 
		UserDataReadWriteFromFile.writeDatatoFile(list1);
	}

}
