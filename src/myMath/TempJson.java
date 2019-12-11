package myMath;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;

public class TempJson {
	public static ArrayList<function> tempInitFromFile(String file) throws IOException {
		// TODO Auto-generated method stub
		Gson gson = new Gson();

		try 
		{
			FileReader reader = new FileReader(file);
			Functions_GUI fg= gson.fromJson(reader,Functions_GUI.class);
			System.out.println(fg);
			return fg.getCl();
			//			System.out.println(cl.get(1).toString());
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static void saveToFile(String file,ArrayList<function> arr) throws IOException {
		// TODO Auto-generated method stub
		Functions_GUI func=new Functions_GUI(arr);
		Gson gson = new Gson();
		String json = gson.toJson(func);
		System.out.println(json);
		try 
		{
			
			PrintWriter pw = new PrintWriter(new File(file));
			pw.write(json);
			pw.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return;
		}


	}
}
