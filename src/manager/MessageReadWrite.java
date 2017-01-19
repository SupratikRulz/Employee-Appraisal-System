package manager;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class MessageReadWrite {

	
		public static ArrayList<MessageInfo> readDataFromFile()
		{
			ArrayList<MessageInfo> list4;
			try
			{
			   FileInputStream fin=new FileInputStream("message.dat");
			   ObjectInputStream oin=new ObjectInputStream(fin);
			   list4=(ArrayList<MessageInfo>)oin.readObject();
			   
			   oin.close();
			   fin.close();
			}catch(Exception e)
			 {
				 list4=new ArrayList<MessageInfo>();
			 }
			 
			return list4;
		}
		
		public static void writeDatatoFile(ArrayList<MessageInfo> wlist)
		{
			try	
			 {
			       FileOutputStream fout=new FileOutputStream("message.dat");
			       ObjectOutputStream oout=new ObjectOutputStream(fout);
			       oout.writeObject(wlist);
			       
			       oout.close();
			}catch(Exception e){System.out.println(e);}
		}
	}
	
	

