package myMath;

import java.util.ArrayList;

public class MyMonomTest {

	public static void main(String[] args) {
		//test1success();
		test2error();

	}
	private static void test1success() {
		System.out.println("*****  Test1success:  *****");
		String  [] Monoms= {"2","-x","-2x","-4x^3","x^2","0x","0"};
		Monom s=new Monom(1,2);
		for(int i=0;i<Monoms.length;i++) {
			Monom a=new Monom(Monoms[i]);
			s.multipy(a);
			System.out.println(i+") "+a +"    \tisZero: "+a.isZero()+"\t f("+i+") = "+a.f(i)+" \t multipy this with monom s = "+s);	
		}


	}
	private static void test2error() {
		System.out.println("*****  Testerror:  *****");
		String  [] Monoms= {"2","-x^z","-ex","-4x^3r3","r","0x^r"};
		int counter=0;
		Monom s=new Monom("2");
		for(int i=0;i<Monoms.length;i++) {
			try {
				Monom a=new Monom(Monoms[i]);
				a.add(s);
				System.out.println(i+") "+Monoms[i]+"    \tlegal monum"+"    Connection Monom:  "+s+"  with monom: "+Monoms[i]+" = "+a);
			}
			catch(Exception e){
				System.out.println(i+") "+Monoms[i]+" plus "+s+"       \tCan't connect monoms");
				counter++;
			}
		}
		if (counter==Monoms.length) {
			System.out.println("There is no valid monom in the array");
		}
		else {
			System.out.println("Exists  "+(Monoms.length-counter)+"  Monoms legal in the array");
			System.out.println("Exists  "+(counter)+"  Monoms illegal in the array");

		}

	}
}
