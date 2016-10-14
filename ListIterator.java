
public class ListIterator {
	DoublePoint current;
	
	//Constructor
	public ListIterator(DoublePoint Point) {
		current = Point;
	}
	
	//Check if current position on list is valid.
	public boolean isValid(){
		return current != null;
	}
	
	//Advance to next node of current node.
	public void advance(){
		if(isValid()){
			current = current.next;
		}
	}
	
	//Return stored node.
	public DoublePoint retrieve(){
		return isValid() ? current : null;
		}
	}

