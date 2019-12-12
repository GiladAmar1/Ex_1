package myMath;

public class TempDrow {
	private int Width;
	private int Height;
	private int Resolution;
	private int[] Range_X= {0,1};
	private int[] Range_Y= {0,1};
	
	
	
	public TempDrow () {
		Width=512;
		Height=512;
		Resolution=500;
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
	public  int[] getRange_X() {
		return this.Range_X;
	}
	public  int[] getRange_Y() {
		return this.Range_Y;
	}
	
	
	
	
}
