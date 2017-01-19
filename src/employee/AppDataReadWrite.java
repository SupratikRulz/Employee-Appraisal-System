package employee;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AppDataReadWrite 
{
	public static ArrayList<EmployeeAppraisal_Info> readAppFromFile()
	{
		ArrayList<EmployeeAppraisal_Info> list9;
		try
		{
		   FileInputStream fin1=new FileInputStream("EmployeeApp.dat");
		   ObjectInputStream oin1=new ObjectInputStream(fin1);
		   list9=(ArrayList<EmployeeAppraisal_Info>)oin1.readObject();
		   
		   oin1.close();
		   fin1.close();
		}catch(Exception e)
		 {
			 list9=new ArrayList<EmployeeAppraisal_Info>();
		 }
		 
		return list9;
	}
	
	public static void writeApptoFile(ArrayList<EmployeeAppraisal_Info> wlist)
	{
		try	
		 {
				
		       FileOutputStream fout1=new FileOutputStream("EmployeeApp.dat");
		       ObjectOutputStream oout1=new ObjectOutputStream(fout1);
		       oout1.writeObject(wlist);
		       
		       oout1.close();
		}catch(Exception e){System.out.println(e);}
	}
}