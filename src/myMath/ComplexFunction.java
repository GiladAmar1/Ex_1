package myMath;

import javax.management.RuntimeErrorException;

public class ComplexFunction implements complex_function {

	private function left;
	private function right;
	private Operation op;
	private String type="ComplexFunction";


	//constractors
	public ComplexFunction() {
		this.left=null;
		this.right=null;
		this.op=Operation.None;
	}
	public ComplexFunction(function left) {
		this.left=left;
		this.right=null;
		this.op=Operation.None;
	}

	public ComplexFunction( Operation op, function left,function right) {
		this.left=left;
		this.right=right;
		this.op=op;
	}

	public ComplexFunction(String s,function left,function right) {
		this.left=left;
		this.right=right;
		this.op=getOpFromString(s);
	}
	//	public  ComplexFunction(String s) {
	//		String run="";
	//		int counter=0;
	//		for(int i=0;i<s.length();i++) {
	//			if(s.charAt(i)=='(') {
	//				run=s.substring(0,i);
	//				this.op=getOpFromString(run);
	//				counter=i+1;
	//				i=s.length();
	//			}
	//		}
	//		for(int i=counter;i<s.length();i++) {
	//			if(s.charAt(i)==',') {
	//				run=s.substring(counter, i);
	//				function x=new Polynom(run);
	//				this.left=x;
	//				run=s.substring(i+1,s.length()-1);
	//				function y= new Polynom(run);
	//				this.right=y;
	//				if(this.op==Operation.None) {
	//					this.op=Operation.Error;
	//				}
	//			}
	//		}
	//		run=s.substring(counter, s.length()-1);
	//		function x=new Polynom(run);
	//		this.left=x;
	//
	//	}


	//Function for determining operation
	private Operation getOpFromString(String op) {
		op=op.toLowerCase();
		switch (op) {
		case "plus":
			return Operation.Plus;
		case "times":
			return Operation.Times;
		case "mul":
			return Operation.Times;
		case "divid":
			return Operation.Divid;
		case "div":
			return Operation.Divid;
		case "max":
			return Operation.Max;
		case "min":
			return Operation.Min;
		case "comp":
			return Operation.Comp;
		case "none":
			return Operation.None;
		default:
			throw new RuntimeException("op is not from operturs in the enum");
		}
	}

	@Override
	//	build new complex function from String
	public function initFromString(String s) {
		s=deleteSpace(s);
		if (s.contains("error")||s.contains("null")&&s.indexOf(("null"))!=s.length()-5)
			throw new RuntimeException("not can be a complex function");
		if (s.indexOf('(')==-1) {
			return new Polynom(s);
		}
		int i=0;
		int nums=0;
		while(s.charAt(i)!='(') {
			i++;
		}
		nums++;
		Operation op=getOpFromString(s.substring(0, i));
		s=s.substring(i+1,s.length()-1);
		i=0;
		while(nums!=1||s.charAt(i+1)!=',') {
			i++;
			if(s.charAt(i)=='(')
				nums++;
			if(s.charAt(i)==')')
				nums--;
		}
		if(s.indexOf("null")==s.length()-5)
			return new ComplexFunction(op,initFromString(s.substring(0, i+1)),null);
		return new ComplexFunction(op,initFromString(s.substring(0, i+1)),initFromString(s.substring(i+2, s.length())));
	}

	//	the function delet oll the space from the String
	private String deleteSpace(String s) {
		String t="";
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)!=' ')
				t+=s.charAt(i);
		}
		return t;

	}

	@Override
	public function copy() {
		function co=new ComplexFunction(this.op, this.left,this.right);
		return co;
	}

	@Override
	public void plus(function f1) {

		if(this.right()==null) {
			this.right=f1;
			this.op=Operation.Plus;
		}
		else {
			this.left=new ComplexFunction(this.op, this.left,this.right);
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
			this.left=new ComplexFunction(this.op, this.left,this.right);
			;
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
			this.left=new ComplexFunction(this.op, this.left,this.right);
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
			this.left=new ComplexFunction(this.op, this.left,this.right);
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
			this.left=new ComplexFunction(this.op, this.left,this.right);
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
			this.left=new ComplexFunction(this.op, this.left,this.right);
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
		double le=this.left.f(x);
		double ri=this.right.f(x);

		switch (this.op) {
		case  None: {
			return le;
		}
		case  Comp: {
			return this.left.f(ri);
		}
		case  Divid: {
			if(ri==0) {
				throw new RuntimeException("Dont divid 0");
			}
			return le/ri;
		}
		case  Max: {
			if(le>ri)
				return le;
			return ri;
		}
		case  Min: {
			if(le<ri)
				return le;
			return ri;
		}
		case  Plus: {
			return le+ri;
		}
		case  Times: {
			return le*ri;
		}
		default :
			throw new RuntimeException("error");
		}
	}

	public String toString() {
		return this.getOp()+"("+this.left()+","+this.right()+")";
	}



}
