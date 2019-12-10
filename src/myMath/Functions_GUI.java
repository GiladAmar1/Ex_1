package myMath;

import java.awt.Color;
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

	private ArrayList<function> a;

	public  Functions_GUI() {
		// TODO Auto-generated constructor stub
		this.a=new ArrayList<function>();;
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
			a= gson.fromJson(reader,ArrayList.class);
			System.out.println(a);

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
		//		System.out.println(json);
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
		StdDraw.setXscale(rx.get_min(), rx.get_max());
		StdDraw.setYscale(ry.get_min(), ry.get_max());
		StdDraw.setPenRadius(0.009);
		double rx_steps =(rx.get_max()-rx.get_min())/resolution;
		for (int i = 0; i < this.size(); i++) {
			StdDraw.setPenColor(Colors[i%7]);
			for (double j = rx.get_min(); j <rx.get_max(); j+=rx_steps) {
				double y=a.get(i).f(j);
				if(y<ry.get_max()&&y>ry.get_min()) {
					StdDraw.point(j, y);
				}
			}

		}	
	}

	public static Color[] Colors = {Color.blue, Color.cyan, Color.MAGENTA, Color.ORANGE, Color.red, Color.GREEN, Color.PINK};
	@Override
	public void drawFunctions(String json_file) {
		// TODO Auto-generated method stub

		try {
			initFromFile(json_file);
			StdDraw.setCanvasSize();
			StdDraw.setYscale();
			StdDraw.setXscale();
			drawFunctions(512, 512,new Range(-10, 10),new Range(-5,15) , 500);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}


	}



}
