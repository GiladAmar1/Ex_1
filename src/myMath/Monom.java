
package myMath;

import java.util.Comparator;

/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */
public class Monom implements function{

	private static Monom getNewZeroMonom() {return new Monom(ZERO);}
	private double _coefficient; 
	private int _power;


	public static final Monom ZERO = new Monom(0,0);
	public static final Monom MINUS1 = new Monom(-1,0);
	public static final double EPSILON = 0.0000001;
	public static final Comparator<Monom> _Comp = new Monom_Comperator();
	public static Comparator<Monom> getComp() {return _Comp;}

	/**
	 * Initializing constructor with int
	 * @param a coefficient
	 * @param b power
	 */
	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
	}

	/**
	 * Copy constructor
	 * @param ot monom
	 */
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}

	/**
	 * Get coefficient
	 * @return coefficient
	 */
	public double get_coefficient() {
		return this._coefficient;
	}
	/**
	 * Get power
	 * @return power
	 */
	public int get_power() {
		return this._power;
	}

	/**
	 * Set coefficient
	 * @return coefficient
	 */
	private void set_coefficient(double a){
		this._coefficient = a;
	}

	/**
	 * Set power
	 * @return power
	 */
	private void set_power(int p) {
		if(p<0) {throw new RuntimeException("ERR the power of Monom should not be negative, got: "+p);}
		this._power = p;
	}


	/** 
	 * this method returns the derivative monom of this.
	 * @return
	 */
	public Monom derivative() {
		if(this.get_power()==0) {return getNewZeroMonom();}
		return new Monom(this.get_coefficient()*this.get_power(), this.get_power()-1);
	}

	/**
	 * The function get value and return a solve of the monom 
	 */
	public double f(double x) {
		double ans=0;
		double p = this.get_power();
		ans = this.get_coefficient()*Math.pow(x, p);
		return ans;
	} 

	/**
	 *
	 * @return monom is 0
	 */
	public boolean isZero() {return this.get_coefficient() == 0;}

	// ***************** add your code below **********************

	/**
	 * Initializing constructor with string
	 * @param s
	 */
	public Monom(String s)
	{
		s=s.toLowerCase();
		if (s.charAt(0)=='-') {
			monoPositive(s.substring(1));
			this._coefficient=this._coefficient*(-1);
		}
		else
			if (s.charAt(0)=='+') {
				monoPositive(s.substring(1));
			}
			else 
				monoPositive(s);

		this._coefficient=Double.parseDouble(String.format("%.5g%n", this.get_coefficient()));
	}


	/**
	 * Add m monom with the same power to my monom
	 * @param m
	 */
	public void add(Monom m) {
		if(this._coefficient==0) {
			this._coefficient=m._coefficient;
			this._power=m._power;
		}
		else if(this._power==m._power)
			this._coefficient=this._coefficient+m._coefficient;
		else throw new RuntimeException("ERR the power of Monom should be the saem");
		this._coefficient=Double.parseDouble(String.format("%.5g%n", this.get_coefficient()));
	}

	/**
	 * Multiply d with my monom
	 * @param d
	 */
	public void multipy(Monom d) {
		if(d._coefficient==0) {
			this._coefficient=0;
			this._power=0;
		}
		else {
			this._coefficient=this._coefficient*d._coefficient;
			this._power=this._power+d._power;
		}
	}

	/**
	 * Print my monom
	 */
	public String toString() {

		if(this._power==0)
			return this._coefficient+"";
		String ans = this._coefficient+ "x^"+this._power;
		return ans;

	}
	// you may (always) add other methods.

	//****************** Private Methods and Data *****************

	/**
	 * the function get positive monom and restart the monom
	 * @param d
	 */
	private void monoPositive(String d) {
		int i=d.indexOf('x') ;
		if(i==-1) {
			this._power=0;
			this._coefficient=Double.parseDouble(d);
		}		
		else if(d.equals("x")) {
			this._coefficient=1.0;
			this._power=1;
		}
		else if(i==0) {
			this._coefficient=1.0;
			parsePower(d.substring(i+1));
		}
		else if(i==d.length()-1) {
			this._power=1;
			this._coefficient=Double.parseDouble(d.substring(0, i));
		}
		else {

			parsePower(d.substring(i+1));
			this._coefficient=Double.parseDouble(d.substring(0, i));
		}
	}

	/**
	 * the function restart the power
	 * @param a
	 */
	private void parsePower(String a) {
		if (a.charAt(0)=='^'&&a.charAt(1)!='-') {
			a=a.substring(1);
			this._power=(int)Double.parseDouble(a);
		}
		else 
			throw new RuntimeException("ERR the string can't be monom");
	}
	
	public boolean equals(Monom m) {
		if(this._coefficient==m.get_coefficient()&&this._power==m.get_power())return true;
		return false;
	}

	@Override
	public function initFromString(String s) {
		// TODO Auto-generated method stub
		return new Monom(s);
	}

	@Override
	public function copy() {
		// TODO Auto-generated method stub
		return new Monom(this);
	}




}