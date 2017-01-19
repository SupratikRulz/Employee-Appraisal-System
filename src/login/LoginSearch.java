package login;

import employee.EmployeeRegistrationInfo;
import employee.UserDataReadWriteFromFile;

import java.util.ArrayList;


public class LoginSearch 
{

	public static int searh(String id,String pass)
	{
		ArrayList<EmployeeRegistrationInfo> list6;
		int f=-1;
		try
		{
			list6=UserDataReadWriteFromFile.readDataFromFile();
			
			for(int p=0; p<list6.size(); p++)
			{
				if((id.equals(list6.get(p).getEmployeeid())) && (pass.equals(list6.get(p).getPassword())))
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
}
