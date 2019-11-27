package myMath;

import java.util.Iterator;
import java.util.LinkedList;


import myMath.Monom;

/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Boaz
 *
 */
public class Polynom implements Polynom_able{
	private Monom_Comperator comp=new Monom_Comperator();
	private  LinkedList<Monom> p=  new LinkedList<>();

	/**
	 * Zero (empty polynom)
	 */
	public Polynom() {
		p.add(new Monom(0,0));
	}
	/**
	 * init a Polynom from a String such as:
	 *  {"x", "3+1.4X^3-34x", "(2x^2-4)*(-1.2x-7.1)", "(3-3.4x+1)*((3.1x-1.2)-(3X^2-3.1))"};
	 * @param s: is a string represents a Polynom
2	 */
	public Polynom(String s) {
		int i=0;
		while(s.length()-1!=i) {
			i++;
			if(s.charAt(i)=='+'||s.charAt(i)=='-') {
				p.add(new Monom(s.substring(0, i)));
				s=s.substring(i);
				i=0;
			}
		}
		p.add(new Monom(s));
		p.sort(comp);

	}
	/**
	 * The function get value and solve this polynom with this value
	 */
	@Override
	public double f(double x) {
		// TODO Auto-generated method stub
		double ans=0;
		Iterator<Monom> m=p.iterator();
		while (m.hasNext()) {
			Monom t=m.next();
			ans+=t.f(x);
		}
		return ans;	
	}
	
	/**
	 * Add p1 polynom to this polynom
	 */

	@Override
	public void add(Polynom_able p1) {
		// TODO Auto-generated method stub
		Iterator<Monom> m=p1.iteretor(); 
		while (m.hasNext()) {
			Monom t=m.next(); 
			this.add(t);
		}
	}

	/**
	 * Add monom to this polynom
	 */
	@Override
	public void add(Monom m1) {
		// TODO Auto-generated method stub

		boolean b=false;
		Iterator<Monom> monoms=this.iteretor(); 
		while (monoms.hasNext()) {
			Monom t=monoms.next(); 
			try{
				t.add(m1);
				if(t.get_coefficient()==0) {
					monoms.remove();
				}
				b=true;
			}
			catch(Exception e){
				monoms.hasNext();
			}
		}
		if(!b)
			p.add(m1);
		p.sort(comp);
	}

	
	/**
	 * Substract p1  from this polynom
	 */
	@Override
	public void substract(Polynom_able p1) {
		// TODO Auto-generated method stub
		Monom t=new Monom(-1,0);
		p1.multiply(t);
		this.add(p1);
	}

	/**
	 * Multiply p1 with this polynom
	 */
	@Override
	public void multiply(Polynom_able p1) {
		// TODO Auto-generated method stub

		Polynom_able temp=new Polynom();
		Polynom sum=new Polynom();
		Iterator<Monom> it=p1.iteretor();
		while(it.hasNext()) {
			temp=this.copy();
			temp.multiply(it.next());
			sum.add(temp);
		}
		this.p=sum.p;
	}

	/**
	 * Test if p1 is logically equals to this polynom
	 * 
	 */
	@Override
	public boolean equals(Polynom_able p1) {
		// TODO Auto-generated method stub

		return this.toString().equals(p1.toString());
	}
	
	/**
	 * Test if this polynom is the Zero Polynom
	 */
	@Override
	public boolean isZero() {
		// TODO Auto-generated method stub

		if(this.iteretor().hasNext()) {
			if(this.iteretor().next().get_coefficient()!=0)
				return false;
		}
		return true;
	}

	/**
	 * 
	 * @param x0 starting range
	 * @param x1 end range
	 * @param eps step positive value
	 * @return the value that solve f(x)=0
	 */
	@Override
	public double root(double x0, double x1, double eps) {
		// TODO Auto-generated method stub
		
		if (this.f(0)==0&&x0<=0&&x1>=0)
			return 0;
		if(this.f(x0)*this.f(x1)>=0) 
			throw new RuntimeException("not can solve in this range");
		double mid=(x0+x1)/2;
		if(Math.abs(this.f(mid))<eps)
			return mid;
		if(this.f(mid)<0)
			return root(mid,x1,eps);
		return root (x0,mid,eps);
	}
	
	/**
	 * Create deep polynom of this polynom
	 */
	@Override
	public Polynom_able copy() {
		// TODO Auto-generated method stub

		Polynom pcopy = new Polynom();
		Iterator<Monom> it=this.iteretor();
		while( it.hasNext())
			pcopy.add(new Monom(it.next()));
		return pcopy;
	}

	/**
	 * Calculates the derivative of the given function 
	 * More information: "https://en.wikipedia.org/wiki/Derivative"
	 */
	@Override
	public Polynom_able derivative() {
		// TODO Auto-generated method stub

		Polynom_able der=new Polynom();
		Iterator<Monom> it= this.iteretor();
		while(it.hasNext()) {
			//if(it.next().get_power()!=0)
			der.add(it.next().derivative());
		}
		return der;
	}


	/**
	 * Compute a Riman's integral from x0 to x1 in eps steps.
	 * @param x0 starting range
	 * @param x1 end range
	 * @param eps step positive value
	 * @return the approximated area above X-axis below this function bounded in the range of [x0,x1]
	 */
	@Override
	public double area(double x0, double x1, double eps) {
		// TODO Auto-generated method stub

		double ans=0;
		for (double i = x0; i <= x1; i+=eps) {
			ans+=this.f(i)*eps;
		}
		return ans;
	}

	/**
	 * Iterator for this LinkList
	 */
	@Override
	public Iterator<Monom> iteretor() {
		// TODO Auto-generated method stub
		return p.iterator();
	}
	@Override
	/**
	 * Multiply monom m1 with this polynom
	 */
	public void multiply(Monom m1) {
		// TODO Auto-generated method stub
		Iterator<Monom> mu=p.iterator();
		while(mu.hasNext())
			mu.next().multipy(m1);
	}
	
	/**
	 * print this polynom
	 */
	public String toString() {
		return this.p.toString();		
	}

}
