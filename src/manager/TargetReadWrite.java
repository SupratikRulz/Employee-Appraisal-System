package manager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class TargetReadWrite {
	
	public static ArrayList<TargetInfo> readTargetFromFile()
	{
		ArrayList<TargetInfo> list4;
		try
		{
		   FileInputStream fin3=new FileInputStream("target.dat");
		   ObjectInputStream oin3=new ObjectInputStream(fin3);
		   list4=(ArrayList<TargetInfo>)oin3.readObject();
		   
		   oin3.close();
		   fin3.close();
		}catch(Exception e)
		 {
			 list4=new ArrayList<TargetInfo>();
		 }
		 
		return list4;
	}
	
	public static void writeTargettoFile(ArrayList<TargetInfo> wlist)
	{
		try	
		 {
		       FileOutputStream fout3=new FileOutputStream("target.dat");
		       ObjectOutputStream oout3=new ObjectOutputStream(fout3);
		       oout3.writeObject(wlist);
		       
		       oout3.close();
		}catch(Exception e){System.out.println(e);}
	}

}
