package myMath;

public class TempDrow {
	private int Width;
	private int Height;
	private int Resolution;
	private Range Range_X;
	private Range Range_Y;
	
	
	
	public TempDrow () {
		Width=512;
		Height=512;
		Resolution=500;
		Range_X=new Range(0, 1);
		Range_Y=new Range(0, 1);
	}
	
	public  int getWidth() {
		return this.Width;
	}
	public  int getHeight() {
		return this.Height;
	}
	public  int getResolution() {
		return this.Resolution;
	}
	public  Range getRange_X() {
		return this.Range_X;
	}
	public  Range getRange_Y() {
		return this.Range_Y;
	}
	
	
	
	
}
