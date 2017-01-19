package employee;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UserDataReadWriteFromFile 
{
	public static ArrayList<EmployeeRegistrationInfo> readDataFromFile()
	{
		ArrayList<EmployeeRegistrationInfo> list4;
		try
		{
		   FileInputStream fin=new FileInputStream("ed.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   list4=(ArrayList<EmployeeRegistrationInfo>)oin.readObject();
		   
		   oin.close();
		   fin.close();
		}catch(Exception e)
		 {
			 list4=new ArrayList<EmployeeRegistrationInfo>();
		 }
		 
		return list4;
	}
	
	public static void writeDatatoFile(ArrayList<EmployeeRegistrationInfo> wlist)
	{
		try	
		 {
		       FileOutputStream fout=new FileOutputStream("ed.dat");
		       ObjectOutputStream oout=new ObjectOutputStream(fout);
		       oout.writeObject(wlist);
		       
		       oout.close();
		}catch(Exception e){System.out.println(e);}
	}
}