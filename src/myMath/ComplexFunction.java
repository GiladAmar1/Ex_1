package myMath;

import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.tree.TreeNode;

import org.hamcrest.core.SubstringMatcher;

public class ComplexFunction implements complex_function {

	private function left;
	private function right;
	private Operation op;
	
	
	public ComplexFunction(function left) {
		this.left=left;
		this.right=null;
		this.op=Operation.None;
	}
	
	public ComplexFunction(function left,function right, Operation op) {
		this.left=left;
		this.right=right;
		this.op=op;
	}

	public  ComplexFunction(String s) {
		String run="";
		int counter=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='(') {
				run=s.substring(0,i);
				this.op=getOpFromString(run);
				counter=i+1;
				i=s.length();
			}
		}
		for(int i=counter;i<s.length();i++) {
			if(s.charAt(i)==',') {
				run=s.substring(counter, i);
				function x=new Polynom(run);
				this.left=x;
				run=s.substring(i+1,s.length()-1);
				function y= new Polynom(run);
				this.right=y;
				if(this.op==Operation.None) {
					this.op=Operation.Error;
				}
			}
		}
		run=s.substring(counter, s.length()-1);
		function x=new Polynom(run);
		this.left=x;
		
	}
	//Function for determining operation
	private Operation getOpFromString(String op) {
		if(op.equals("Plus")) {
			return Operation.Plus;
		}
		if(op.equals("Times")) {
			return Operation.Times;
		}
		if(op.equals("Divid")) {
			return Operation.Divid;
		}
		if(op.equals("Max")) {
			return Operation.Max;
		}
		if(op.equals("Min")) {
			return Operation.Min;
		}
		if(op.equals("Comp")) {
			return Operation.Comp;
		}
		return Operation.None;
	}

	@Override
	public function initFromString(String s) {
		for(int i=s.length();i>0;i--) {

		}

		return null;
	}

	@Override
	public function copy() {
		function co=new ComplexFunction(left(),right(),getOp());
		return co;
	}

	@Override
	public void plus(function f1) {
		if(this.right()==null) {
			this.right=f1;
			this.op=Operation.Plus;
		}
		else {
			this.left=new ComplexFunction(left(),right(),getOp());
			this.right=f1;
			this.op=Operation.Plus;
		}
	}

	@Override
	public void mul(function f1) {
		if(this.right()==null) {
			this.right=f1;
			this.op=Operation.Times;
		}
		else {
			this.left=new ComplexFunction(left(),right(),getOp());
			this.right=f1;
			this.op=Operation.Times;
		}
	}

	@Override
	public void div(function f1) {
		if(this.right()==null) {
			this.right=f1;
			this.op=Operation.Divid;
		}
		else {
			this.left=new ComplexFunction(left(),right(),getOp());
			this.right=f1;
			this.op=Operation.Divid;
		}
	}


	@Override
	public void max(function f1) {
		if(this.right()==null) {
			this.right=f1;
			this.op=Operation.Max;
		}
		else {
			this.left=new ComplexFunction(left(),right(),getOp());
			this.right=f1;
			this.op=Operation.Max;
		}
	}

	@Override
	public void min(function f1) {
		if(this.right()==null) {
			this.right=f1;
			this.op=Operation.Min;
		}
		else {
			this.left=new ComplexFunction(left(),right(),getOp());
			this.right=f1;
			this.op=Operation.Min;
		}
	}

	@Override
	public void comp(function f1) {
		if(this.right()==null) {
			this.right=f1;
			this.op=Operation.Comp;
		}
		else {
			this.left=new ComplexFunction(left(),right(),getOp());
			this.right=f1;
			this.op=Operation.Comp;
		}
	}

	@Override
	public function left() {	
		return this.left;
	}

	@Override
	public function right() {
		return this.right;
	}

	@Override
	public Operation getOp() {
		return this.op;
	}

	@Override
	public double f(double x) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String toString() {
		return this.getOp()+"("+this.left()+","+this.right()+")";
	}


}
