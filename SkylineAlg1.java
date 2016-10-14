import java.util.concurrent.TimeUnit;


public class SkylineAlg1 {
	static long myTime;
	public static double timeElapsed;
	
	public void Algorithm1(ListDoublePoints List) {
		
		long initialTime = System.currentTimeMillis();
		long start = System.nanoTime();	

		
		
		//Iterate trough list using Iterators p and q
		for ( ListIterator p = List.first(); p.isValid(); p.advance()){
			for(ListIterator q = List.first(); q.isValid(); q.advance()) {
				//check for dominance (p dominates q). If true then q is removed
				if(((p.retrieve().x <= q.retrieve().x) && (p.retrieve().y <= q.retrieve().y)) &&
						((p.retrieve().x < q.retrieve().x) || (p.retrieve().y < q.retrieve().y))) {
					//remove q from list.
					List.delete(q.retrieve().x, q.retrieve().y);
				}
				//check for q dominance.
				 else if(((q.retrieve().x <= p.retrieve().x) && (q.retrieve().y <= p.retrieve().y)) &&
						((q.retrieve().x < p.retrieve().x)|| (q.retrieve().y < p.retrieve().y))) {
					 //remove p from list
					 List.delete(p.retrieve().x, p.retrieve().y);
				
				break;
				 }
			} // end inner for loop
		} // end outer for loop	
		
		long finalTime = System.currentTimeMillis();
		
		myTime = finalTime - initialTime;

		long elapsedTime = System.nanoTime() - start;
		timeElapsed = TimeUnit.MICROSECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS)/1000.0;
		System.out.println("\n " +"Time elapsed for Algorithm1: " +timeElapsed+ " miliseconds \n");
	}
} //end of class
