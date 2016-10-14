
public class SkylineAlg2 {
	static long myTime;
	
	public void Algorithm2(ListDoublePoints List){
		
		//List sorting.
		List.selectionSort(List);
		
		long initialTime = System.currentTimeMillis();
		
		//Make iterators and Initialize.
		ListIterator p = new ListIterator(List.header.next);
		ListIterator q = new ListIterator(List.header.next);
		
		for (; p.isValid(); p.advance()){
			
			q.current = p.current.next;
			
			for(; q.isValid(); q.advance()){
				//check for dominance (p dominates q). If true then q is removed
				if(((p.retrieve().x <= q.retrieve().x) && (p.retrieve().y <= q.retrieve().y)) &&
						((p.retrieve().x < q.retrieve().x) || (p.retrieve().y < q.retrieve().y))) {
					//remove q from list.
					List.delete(q.retrieve().x, q.retrieve().y);
			}
		} // end inner for loop.
	 } // end outer for loop
		
		long finalTime = System.currentTimeMillis();
		
		myTime = finalTime - initialTime;
		System.out.println("\n " +"Time elapsed for Algorithm2: " +myTime+ " miliseconds \n");
  }
	
} //end of class
