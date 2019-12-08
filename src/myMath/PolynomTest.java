package myMath;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.Test;
class PolynomTest {

	@Test
	void testPolynom() {
		Polynom x=new Polynom();
		Iterator<Monom> m=x.iteretor();
		while (m.hasNext()) {
			Monom t=m.next();	
			assertEquals(0, t.get_coefficient());
			assertEquals(0, t.get_power());
		}
	}

	@Test
	void testPolynomString() {
		double a=3;
		Polynom x=new Polynom("3x^3+2x^2+x");
		Iterator<Monom> m=x.iteretor();
		while (m.hasNext()) {
			Monom t=m.next();
			assertEquals(a, t.get_coefficient());
			assertEquals(a, t.get_power());
			a--;
		}
	}

	@Test
	void testF() {
		Polynom x=new Polynom("3x^3+2x^2+x");
		double sum=x.f(1);
		assertEquals(6,sum );
		double sum2=x.f(2.1);
		assertEquals(38.703, sum2);
		double sum3=x.f(-2.5);
		assertEquals(-36.875, sum3);
	}

	@Test
	void testAddPolynom_able() {
		Polynom x=new Polynom("2x^2+3x+2");
		Polynom_able y=new Polynom("2x^2+1");
		Polynom z=new Polynom("4x^2+3x+3");
		x.add(y);
		Iterator<Monom> m=x.iteretor();
		Iterator<Monom> m2=z.iteretor();
		while (m.hasNext()&&m2.hasNext()) {
			Monom t=m.next();
			Monom t2=m2.next();
			assertEquals(t2.get_coefficient(), t.get_coefficient());
			assertEquals(t2.get_power(), t.get_power());

		}
	}

	@Test
	void testAddMonom() {
		Polynom x=new Polynom("2x^2+x"); 
		Monom y=new Monom(1,1);
		Polynom z=new Polynom("2x^2+2x");
		x.add(y);
		assertEquals(true,x.equals(z));
	}

	@Test
	void testSubstract() {
		Polynom x=new Polynom("6x^2+3x+5");
		Polynom y=new Polynom("2x^2+3x^6+5x^4+2");
		Polynom z=new Polynom("4X^2-3x^6-5x^4+3x+3");
		x.substract(y);
		assertEquals(true,x.equals(z));
		x.substract(x);
		assertEquals(true, x.isZero());
	}

	@Test
	void testMultiplyPolynom_able() {	
		Polynom x=new Polynom("6x^2+3x+5");
		Polynom_able y=new Polynom("2x^2-6");
		Polynom z=new Polynom("12x^4+6x^3-26x^2-18x-30");
		x.multiply(y);
		assertEquals(true,x.equals(z));
	}

	@Test
	void testEqualsPolynom_able() {
		Polynom x=new Polynom("2.99999999x^2+2+4x");
		Polynom_able y=new Polynom("3x^2+4x+2");
		//System.out.println(x);
		//System.out.println(x.equals(y));
		assertEquals(true, x.equals(y));
		assertEquals(x, new Polynom(x.toString()));
	}


	@Test
	void testIsZero() {
		Polynom x=new Polynom();
		assertEquals(true, x.isZero());
	}

	@Test
	void testRoot() {
		Polynom x=new Polynom("x^2-2x+1");
		assertEquals(1, x.root(0, 3, 0.00001));
		Polynom y=new Polynom("x^2-12x+35");
		assertEquals(5, y.root(4,6,0.00001));
		//System.out.println(y.root(4,6,0.00001));
		assertEquals(7,y.root(6,8,0.00001));
		//System.out.println(y.root(6,8,0.00001));


	}

	@Test
	void testCopy() {
		Polynom x=new Polynom("3x^2-6x+3");
		Polynom_able y=x.copy();
		y.add(new Monom(-3,2));
		assertEquals(false, x.equals(y));
		assertEquals(y, new Polynom("-6x+3"));
	}

	@Test
	void testDerivative() {
		Polynom x=new Polynom("3x^2-6x+3");
		Polynom y=new Polynom("6x-6");
		assertEquals(true, y.equals(x.derivative()));
	}

	@Test
	void testArea() {
		Polynom x=new Polynom("6x+2.3");
		double a= x.area(0, 2, 0.000001);
		assertEquals(true, a-16.6<0.001);
		//System.out.println(x.area(0, 1, 0.000001));
		Polynom p=new Polynom("x^3+4x^2-5");
		//check the approximated area above X-axis
		assertEquals(p.area(0, 1, 0.0001), 0);
		assertEquals(p.area(-3.618, 0, 0.0001),(p.area(-3.618, 1, 0.0001)));
	}

	@Test
	void testMultiplyMonom() {
		Polynom x=new Polynom("6x+2");
		Monom y=new Monom("2x^4");
		Polynom_able z=new Polynom("12x^5+4x^4");
		x.multiply(y);
		assertEquals(true,z.equals(x));
	}

	@Test
	void testToString() {
		Polynom_able p1 = new Polynom();
		String[] monoms1 = {"7", "-x^7","5.0000001x^2","4x^2","-1.5x^3"};
		for(int i=0;i<monoms1.length;i++) {
			Monom m = new Monom(monoms1[i]);
			p1.add(m);
		}
		assertEquals(p1, new Polynom(p1.toString()));
		assertEquals(p1, new Polynom("7+9x^2-1.5x^3-x^7"));
	}


}
