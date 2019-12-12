package myMathTest;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import myMath.ComplexFunction;
import myMath.Operation;
import myMath.Polynom;
import myMath.function;

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
	}

	@Test
	void testCopy() {
		ComplexFunction x=new ComplexFunction(Operation.Plus,new Polynom("x^2"),new Polynom("x+2"));
		ComplexFunction z=(ComplexFunction) x.copy();
		assertEquals(true, x.left().equals(z.left()));
		assertEquals(true,x.right().equals(z.right()));
		assertEquals(true,x.getOp().equals(z.getOp()));
		x.div(new Polynom("x^5"));
		assertEquals(false,x.left().equals(z.left()));
		assertEquals(false,x.right().equals(z.right()));
		assertEquals(false,x.right().equals(z.right()));
	}

	@Test
	void testPlus() {
		ComplexFunction x=new ComplexFunction(Operation.Plus,new Polynom("x^2"),new Polynom("x+2"));
		ComplexFunction z1=new ComplexFunction();
		ComplexFunction z=(ComplexFunction) z1.initFromString("Plus(Plus(x^2,x+2),x^5)");
		x.plus(new Polynom("x^5"));
		//System.out.println(x);
		//System.out.println(z);
		assertEquals(true,x.left().toString().equals(z.left().toString()));
		assertEquals(true,x.right().toString().equals(z.right().toString()));
		assertEquals(true,x.getOp().toString().equals(z.getOp().toString()));
	}

	@Test
	void testMul() {
		ComplexFunction x=new ComplexFunction(Operation.Times,new Polynom("x^2"),new Polynom("x+2"));
		ComplexFunction z1=new ComplexFunction();
		ComplexFunction z=(ComplexFunction) z1.initFromString("Times(Times(x^2,x+2),x^5)");
		x.mul(new Polynom("x^5"));
		//System.out.println(x);
		//System.out.println(z);
		assertEquals(true,x.left().toString().equals(z.left().toString()));
		assertEquals(true,x.right().toString().equals(z.right().toString()));
		assertEquals(true,x.getOp().toString().equals(z.getOp().toString()));
	}

	@Test
	void testDiv() {
		ComplexFunction x=new ComplexFunction(Operation.Divid,new Polynom("x^2"),new Polynom("x+2"));
		ComplexFunction z1=new ComplexFunction();
		ComplexFunction z=(ComplexFunction) z1.initFromString("Divid(Divid(x^2,x+2),x^5)");
		x.div(new Polynom("x^5"));
		//System.out.println(x);
		//System.out.println(z);
		assertEquals(true,x.left().toString().equals(z.left().toString()));
		assertEquals(true,x.right().toString().equals(z.right().toString()));
		assertEquals(true,x.getOp().toString().equals(z.getOp().toString()));
	}

	@Test
	void testMax() {
		ComplexFunction x=new ComplexFunction(Operation.Max,new Polynom("x^2"),new Polynom("x+2"));
		ComplexFunction z1=new ComplexFunction();
		ComplexFunction z=(ComplexFunction) z1.initFromString("Max(max(x^2,x+2),x^5)");
		x.max(new Polynom("x^5"));
		//System.out.println(x);
		//System.out.println(z);
		assertEquals(true,x.left().toString().equals(z.left().toString()));
		assertEquals(true,x.right().toString().equals(z.right().toString()));
		assertEquals(true,x.getOp().toString().equals(z.getOp().toString()));
	}

	@Test
	void testMin() {
		ComplexFunction x=new ComplexFunction(Operation.Min,new Polynom("x^2"),new Polynom("x+2"));
		ComplexFunction z1=new ComplexFunction();
		ComplexFunction z=(ComplexFunction) z1.initFromString("Min(min(x^2,x+2),x^5)");
		x.min(new Polynom("x^5"));
		//System.out.println(x);
		//System.out.println(z);
		assertEquals(true,x.left().toString().equals(z.left().toString()));
		assertEquals(true,x.right().toString().equals(z.right().toString()));
		assertEquals(true,x.getOp().toString().equals(z.getOp().toString()));
	}

	@Test
	void testComp() {
		ComplexFunction x=new ComplexFunction(Operation.Min,new Polynom("x^2"),new Polynom("x+2"));
		ComplexFunction z1=new ComplexFunction();
		ComplexFunction z=(ComplexFunction) z1.initFromString("Min(min(x^2,x+2),x^5)");
		x.min(new Polynom("x^5"));
		//System.out.println(x);
		//System.out.println(z);
		assertEquals(true,x.left().toString().equals(z.left().toString()));
		assertEquals(true,x.right().toString().equals(z.right().toString()));
		assertEquals(true,x.getOp().toString().equals(z.getOp().toString()));
	}

	@Test
	void testLeft() {
		ComplexFunction x=new ComplexFunction(Operation.Divid,new Polynom("x^2"),new Polynom("x+2"));
		assertEquals(true,x.left().equals(new Polynom("x^2")));
		ComplexFunction x1=new ComplexFunction();
		assertEquals(true, x1.left()==null);

	}

	@Test
	void testRight() {
		ComplexFunction x=new ComplexFunction(Operation.Divid,new Polynom("x^2"),new Polynom("x+2"));
		assertEquals(true,x.right().equals(new Polynom("x+2")));
		ComplexFunction x1=new ComplexFunction();
		assertEquals(true, x1.right()==null);
		ComplexFunction z=new ComplexFunction(new Polynom("x"));
		assertEquals(true, z.right()==null);
		z.plus(new Polynom("x+3+x^2"));
		assertEquals(true, z.right().equals(new Polynom("x+3+x^2")));
	}

	@Test
	void testGetOp() {
		ComplexFunction x=new ComplexFunction(Operation.Divid,new Polynom("x^2"),new Polynom("x+2"));
		assertEquals(true,x.getOp()==Operation.Divid);
		ComplexFunction x2=new ComplexFunction(new Polynom("x+3+x^2"));
		assertEquals(true,x2.getOp()==Operation.None);
	}

	@Test
	void testF() {
		ComplexFunction x=new ComplexFunction(Operation.Divid,new Polynom("x^2"),new Polynom("x+2"));
		double y=x.f(2);
		assertEquals(1, y);
		
	}

}
