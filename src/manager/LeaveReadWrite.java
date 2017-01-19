package manager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import employee.EmployeeLeaveInfo;




public class LeaveReadWrite {
	
	
	public static ArrayList<EmployeeLeaveInfo> readAppFromFile()
	{
		ArrayList<EmployeeLeaveInfo> list9;
		try
		{
		   FileInputStream fin1=new FileInputStream("Leave.dat");
		   ObjectInputStream oin1=new ObjectInputStream(fin1);
		   list9=(ArrayList<EmployeeLeaveInfo>)oin1.readObject();
		   
		   oin1.close();
		   fin1.close();
		}catch(Exception e)
		 {
			 list9=new ArrayList<EmployeeLeaveInfo>();
		 }
		 
		return list9;
	}
	
	public static void writeApptoFile(ArrayList<EmployeeLeaveInfo> wlist)
	{
		try	
		 {
				
		       FileOutputStream fout1=new FileOutputStream("Leave.dat");
		       ObjectOutputStream oout1=new ObjectOutputStream(fout1);
		       oout1.writeObject(wlist);
		       
		       oout1.close();
		}catch(Exception e){System.out.println(e);}
	}
	
	

}
