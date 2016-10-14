
public class DoublePoint {
	public double x; // x coordinate of point.
	public double y; // y coordinate of point.
	public DoublePoint next; //reference to next node.
	
	
	//Constructor of class DoublePoint
	public DoublePoint(double x, double y, DoublePoint next){
		//initialize variables
		this.x = x;
		this.y = y;
		this.next = next;
	}
	
	public void clear(){
		x = 0.0;
		y= 0.0;
		next = null;
	} 
	
	
} //end class
