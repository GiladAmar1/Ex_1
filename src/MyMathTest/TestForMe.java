package MyMathTest;

import MyMath.ComplexFunction;
import MyMath.Polynom;
import MyMath.complex_function;
import MyMath.function;

public class TestForMe {

	public static void main(String[] args) {
//
////		Polynom x=new Polynom("2x^2+2x+6");
////		Polynom y=new Polynom("2x^2+2x+6");
		complex_function z=new ComplexFunction(new Polynom("x^2+5+x^3"));
//		function c=z.copy();
//		System.out.println("c;  "+c);
//		System.out.println("z;  "+z);
//		
//		z.plus(new Polynom("x^5"));
//		System.out.println("c;  "+c);
////		System.out.println(z.right());
////		System.out.println(z.left());
////		System.out.println(z.getOp());
//		System.out.println("z;  "+z);
//		z.mul(new Monom(5,3));
//		z.div(new Monom(1,2));
//		System.out.println("z;  "+z);
//		
//		
//		System.out.println(z.f(0));
		String s="min(min(min(min(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x -4.0)),2.0)),div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)),-1.0x^4 +2.4x^2 +3.1),+0.1x^5 -1.2999999999999998x +5.0)";
		
		function cf= z.initFromString(s);
		System.out.println(cf);

}
}