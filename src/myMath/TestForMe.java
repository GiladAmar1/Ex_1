package myMath;

public class TestForMe {

	public static void main(String[] args) {

		Polynom x=new Polynom("2x^2+2x+6");
		Polynom y=new Polynom("2x^2+2x+6");
		complex_function z=new ComplexFunction("(x^2+3+2x+3)");
//		System.out.println(z.right());
//		System.out.println(z.left());
//		System.out.println(z.getOp());
		System.out.println(z);


}
}