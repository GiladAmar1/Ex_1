package myMath;



public class TestForMe {

	public static void main(String[] args) {

//		Polynom x=new Polynom("2x^2+2x+6");
//		Polynom y=new Polynom("2x^2+2x+6");
		complex_function z=new ComplexFunction(new Polynom("x^2+5+x^3"));
		function c=z.copy();
		System.out.println("c;  "+c);
		System.out.println("z;  "+z);
		
		z.plus(new Polynom("x^5"));
		System.out.println("c;  "+c);
//		System.out.println(z.right());
//		System.out.println(z.left());
//		System.out.println(z.getOp());
		System.out.println("z;  "+z);
		z.mul(new Monom(5,3));
		z.div(new Monom(1,2));
		System.out.println("z;  "+z);
		
		
		System.out.println(z.f(0));

}
}