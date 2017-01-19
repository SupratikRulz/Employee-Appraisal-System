package manager;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FireDataReadWrite{
	
	
		public static ArrayList<EmployeeFireInfo> readDataFromFile()
		{
			ArrayList<EmployeeFireInfo> list4;
			try
			{
			   FileInputStream fin=new FileInputStream("fire records.dat");
			   ObjectInputStream oin=new ObjectInputStream(fin);
			   list4=(ArrayList<EmployeeFireInfo>)oin.readObject();
			   
			   oin.close();
			   fin.close();
			}catch(Exception e)
			 {
				 list4=new ArrayList<EmployeeFireInfo>();
			 }
			 
			return list4;
		}
		
		public static void writeDatatoFile(ArrayList<EmployeeFireInfo> wlist)
		{
			try	
			 {
			       FileOutputStream fout=new FileOutputStream("fire records.dat");
			       ObjectOutputStream oout=new ObjectOutputStream(fout);
			       oout.writeObject(wlist);
			       
			       oout.close();
			}catch(Exception e){System.out.println(e);}
		}
	}
	
	

