package MyMath;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.google.gson.Gson;

public class Functions_GUI implements functions {

	private ArrayList<function> a=new ArrayList<function>();
	
	public  Functions_GUI() {
		// TODO Auto-generated constructor stub
		this.a=null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return a.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return a.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return a.contains(o);
	}

	@Override
	public Iterator<function> iterator() {
		// TODO Auto-generated method stub
		return a.iterator();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return a.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(function e) {
		// TODO Auto-generated method stub
		return a.add(e);
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return a.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return a.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends function> c) {
		// TODO Auto-generated method stub
		return a.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return a.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return a.retainAll(c);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		a.clear();
	}

	@Override
	public void initFromFile(String file) throws IOException {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		try 
		{
			FileReader reader = new FileReader(file);
			Functions_GUI f= gson.fromJson(reader,Functions_GUI.class);
			this.a=f.a;
//			System.out.println(f);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveToFile(String file) throws IOException {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		String json = gson.toJson(a);
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

	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		// TODO Auto-generated method stub
		
		StdDraw.setCanvasSize(width,height);
		
		
	}

	@Override
	public void drawFunctions(String json_file) {
		// TODO Auto-generated method stub
		
	}

	

}
