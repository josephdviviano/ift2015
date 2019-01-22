/**
 * 
 * @author Teodora DAN
 *
 */
public class Element {
	private double value;		
	private Element next, prev;	//pointers towards next and previous elements, respectively;
	
	public Element(){
		super();
		next = null;
		prev = null;
	}
	public Element(double _value) {
		value = _value;
		next = null;
		prev = null;
	}
	
	public Element(double _value, Element _next, Element _prev) {
		value = _value;
		next = _next;
		prev = _prev;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Element getNext() {
		return next;
	}

	public void setNext(Element _next) {
		next = _next;
	}

	public Element getPrev() {
		return prev;
	}

	public void setPrev(Element _prev) {
		prev = _prev;
	}
	
}
