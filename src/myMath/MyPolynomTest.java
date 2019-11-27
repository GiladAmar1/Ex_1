package myMath;

public class MyPolynomTest {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}
	public static void test1() {
		System.out.println("*****  Test1  *****");
		Polynom p1 = new Polynom();
		String[] monoms = {"1","x","x^2", "0.5x^2"};
		for(int i=0;i<monoms.length;i++) {
			Monom m = new Monom(monoms[i]);
			p1.add(m);
			System.out.println(i+")"+"  add a monom="+p1+"    \tCalculate polynomial x="+ i+"  is-"+p1.f(i));
		}

	}
	public static void test2() {
		System.out.println("*****  Test2  *****");
		Polynom p1 = new Polynom("5x^2-3x+2");
		Polynom p2 =  new Polynom("-3x+2+5x^2");
		System.out.println("p1="+p1+"   p2="+p2+"   If polynomial p1 and p2 are logically equal- "+p1.equals(p2));
		Polynom_able p3=p1.copy();
		System.out.println("p1="+p1+" p3="+p3 );
		p1.add(p3);
		System.out.println("p1="+p1+"   p2="+p2+"   If polynomial p1 and p2 are logically equal- "+p1.equals(p2));
		p1.add(new Monom(2, 0));
		System.out.println(p1);
		p1.substract(p3);
		System.out.println("p1 minus p3-"+p1);

	}
	public static void test3() {
		System.out.println("*****  Test3  *****");
		double x0=-1;
		double x1=2;
		double eps=0.000001;
		Polynom p=new Polynom("x^2+2x");
		Polynom_able p1= p.copy();
		System.out.println(p.area(x0, x1, eps));
		System.out.println(p1.root(x0, x1, eps));
	}
}