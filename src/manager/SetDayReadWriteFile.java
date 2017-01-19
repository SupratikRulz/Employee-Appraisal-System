package manager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SetDayReadWriteFile {
		public static ArrayList<ManSetDay_Info> readDateFromFile()
		{
			ArrayList<ManSetDay_Info> list5;
			try
			{
			   FileInputStream fin2=new FileInputStream("date.dat");
			   ObjectInputStream oin2=new ObjectInputStream(fin2);
			   list5=(ArrayList<ManSetDay_Info>)oin2.readObject();
			   
			   oin2.close();
			   fin2.close();
			}catch(Exception e)
			 {
				 list5=new ArrayList<ManSetDay_Info>();
			 }
			 
			return list5;
		}
		
		public static void writeDatatoFile(ArrayList<ManSetDay_Info> wlist)
		{
			try	
			 {
			       FileOutputStream fout2=new FileOutputStream("date.dat");
			       ObjectOutputStream oout2=new ObjectOutputStream(fout2);
			       oout2.writeObject(wlist);
			       
			       oout2.close();
			}catch(Exception e){System.out.println(e);}
		}
	}


