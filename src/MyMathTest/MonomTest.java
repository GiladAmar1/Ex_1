package MyMathTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import MyMath.Monom;

class MonomTest {



	@Test
	void testMonomDoubleInt() {
		Monom x=new Monom(2,2);
		assertEquals(2,x.get_coefficient());
		assertEquals(2,x.get_power());
	}

	@Test
	void testMonomMonom() {
		Monom x=new Monom("9x^4");
		Monom y=new Monom(x);
		assertEquals(true,x.get_coefficient()==(y.get_coefficient()));
		assertEquals(true,x.get_power()==(y.get_power()));
	}

	@Test
	void testDerivative() {
		Monom x=new Monom("2x^2");
		//System.out.println(x.derivative());
		assertEquals(4, x.derivative().get_coefficient());
		assertEquals(1, x.derivative().get_power());
	}

	@Test
	void testF() {
		Monom y=new Monom("6x^2");
		double x=3.5;
		assertEquals(73.5, y.f(x));
	}

	@Test
	void testIsZero() {
		Monom a=new Monom(0, 0);
		assertEquals(true, a.isZero());
	}

	@Test
	void testMonomString() {
		Monom x=new Monom("2x^2");
		assertEquals(2,x.get_coefficient());
		assertEquals(2,x.get_power());
		
		
	}

	@Test
	void testAdd() {
		Monom x=new Monom("2x^2");
		Monom y=new Monom("6x^2");
		x.add(y);
		assertEquals(8, x.get_coefficient());
		assertEquals(2, x.get_power());
	}

	@Test
	void testMultipy() {
		Monom x=new Monom("2x^2");
		Monom y=new Monom("6x^2");
		x.multipy(y);
		assertEquals(12, x.get_coefficient());
		assertEquals(4, x.get_power());
		x.multipy(Monom.ZERO);
		assertEquals(true,Monom.ZERO.equals(x));
	}
	
	@Test
	void testToString(){
		Monom m=new Monom("5x^2");
		assertEquals(true,new Monom(m.toString()).equals(m));
	}

}
