import java.util.Random;

public class ListDoublePoints {
	
	DoublePoint header; //reference to first node on list.
	
	
	//Constructor.
	public ListDoublePoints(){
		 //initialize to null cause there are no elements on list yet.
		header = new DoublePoint(0.0, 0.0, null);
		
	}
	
	
	//Return true if List is Empty.
	public boolean isEmpty(){
		return (header == null);
	}
	
	
	//Empties list
	public void makeEmpty( )
	{
	header.next = null;
	}
	

	//Creates an iterator that represents the header of list.
	public ListIterator zeroth(){
		return new ListIterator(header);
	}
	
	
	//Creates an iterator that represents first node/point of list.
	public ListIterator first(){
		return new ListIterator(header.next);
	}
	
	
	//Displays all the items of List. If List is empty then prints a message.
	public static void printList( ListDoublePoints List){
		if( List.isEmpty( ) )
			System.out.print( "Empty list, there are no items." );
		else {
			for(ListIterator itr = List.first(); itr.isValid(); itr.advance())
				System.out.print( "{" +itr.retrieve().x + " , " +itr.retrieve().y+ "}" + "\n" );
			}
		System.out.println();
	}
	
	
	//Insert new items into list.
	public void insert(double x, double y, ListIterator itr){
		if( itr != null && itr.current != null )
			itr.current.next = new DoublePoint( x, y, itr.current.next );
	}
	
	
	//Find previous item of list.
	public ListIterator findPrevious(double x, double y){
		DoublePoint pnt = header;
		while( pnt.next != null && pnt.next.x != x && pnt.next.y != y )
			pnt = pnt.next;
		return new ListIterator(pnt);	
	}
	
	
	//Deletes an Item of the List.
	public void delete(double x, double y) {
		ListIterator itr = findPrevious(x,y);
		if( itr.current.next != null )
		itr.current.next = itr.current.next.next; 
	}
	
	
	//Selection sorting.
	public void selectionSort(ListDoublePoints List) {
		
		//initialize iterators.
		ListIterator min = new ListIterator(header.next);
		ListIterator in = new ListIterator(header.next);
		ListIterator out = new ListIterator(header.next);
		
		for(; out.retrieve().next != null; out.advance()){
			
			min.current = out.current;
			
			for(in.current = out.current.next; in.isValid() ; in.advance()){
				if(in.retrieve().x +in.retrieve().y < min.retrieve().x + min.retrieve().y)
					min.current = in.current;
				
			} //end inner for loop.
			
			swap(out, min);
			
		} //end outer for loop.
		
		//ListDoublePoints.printList(List);
	} 
	
	
	//Swap values of two nodes, using iterators.
	private void swap(ListIterator one, ListIterator two) {
		
		//temporary variables.
		double tempX;
		double tempY;
		
		//temp = one
		tempX = one.retrieve().x;
		tempY = one.retrieve().y;
		
		//one = two
		one.retrieve().x = two.retrieve().x;
		one.retrieve().y = two.retrieve().y;
		
		//two = temp
		two.retrieve().x = tempX;
		two.retrieve().y = tempY;
	}
	

	//Create N points/nodes, according to user's input, with random x,y coordinates within [0, 10.000].
	public void makePoints(ListDoublePoints List,ListDoublePoints List_2 , int N, ListIterator itr, ListIterator itr_2){
		Random rand = new Random();
		
		for(int i = 0; i < N; i++) {
			
			//generate random double numbers ranged from 0 to 10.000.
			double x = rand.nextDouble() * 10000;
			double y = rand.nextDouble() * 10000;
			
			//insert numbers into lists.
			List.insert(x, y, itr);
			List_2.insert(x, y, itr_2);
			
			itr.advance();
			itr_2.advance();
		} // end for loop.
	}

} //end class.
