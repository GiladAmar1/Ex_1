package MyMathTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import MyMath.ComplexFunction;
import MyMath.Operation;
import MyMath.Polynom;
import MyMath.function;

class ComplexFunctionTest {

	@Test
	void testComplexFunctionFunction() {
		ComplexFunction x=new ComplexFunction(new Polynom("x^2+2"));
		Polynom y=new Polynom("x^2+2");
		assertEquals(x.left(),y);
	}

	@Test
	void testComplexFunctionOperationFunctionFunction() {
		ComplexFunction x=new ComplexFunction(Operation.Plus,new Polynom("x^2+2"),new Polynom("x"));
		Polynom y1=new Polynom("x^2+2");
		Polynom y2=new Polynom("x");
		assertEquals(x.left(),y1);
		assertEquals(x.right(),y2);
		assertEquals(x.getOp(),Operation.Plus);
	}

	@Test
	void testComplexFunctionStringFunctionFunction() {
		ComplexFunction x=new ComplexFunction("mul",new Polynom("x^2+2"),new Polynom("x"));
		Polynom y1=new Polynom("x^2+2");
		Polynom y2=new Polynom("x");
		assertEquals(x.left(),y1);
		assertEquals(x.right(),y2);
		assertEquals(x.getOp(),Operation.Times);
	}

	@Test
	void testInitFromString() {
		ComplexFunction x=new ComplexFunction();
		String s="Divid(x^5+3x+2x^2,x^2+3x)";
		ComplexFunction y=(ComplexFunction) x.initFromString(s);
		function y1=new Polynom("x^5+3x+2x^2");
		function y2=new Polynom("x^2+3x");
		assertEquals(true,y1.equals(y.left()));
		assertEquals(true,y2.equals(y.right()));
		assertEquals(Operation.Divid,y.getOp());
		
		ComplexFunction x2=new ComplexFunction();
		String s1="Error(x^5+3x+2x^2+3,null)";
		ComplexFunction z=(ComplexFunction) x2.initFromString(s1);
		System.out.println(z.right());
		System.out.println(z.left());

		function z1=new Polynom("x^5+3x+2x^2+3");
		assertEquals(true,z1.equals(z.left()));
		assertEquals(true,z.right()==null);
		assertEquals(Operation.Error,z.getOp());

		
	}

	@Test
	void testCopy() {
		fail("Not yet implemented");
	}

	@Test
	void testPlus() {
		fail("Not yet implemented");
	}

	@Test
	void testMul() {
		fail("Not yet implemented");
	}

	@Test
	void testDiv() {
		fail("Not yet implemented");
	}

	@Test
	void testMax() {
		fail("Not yet implemented");
	}

	@Test
	void testMin() {
		fail("Not yet implemented");
	}

	@Test
	void testComp() {
		fail("Not yet implemented");
	}

	@Test
	void testLeft() {
		fail("Not yet implemented");
	}

	@Test
	void testRight() {
		fail("Not yet implemented");
	}

	@Test
	void testGetOp() {
		fail("Not yet implemented");
	}

	@Test
	void testF() {
		fail("Not yet implemented");
	}

}
