/**
 * 
 * @author Teodora DAN
 *
 */
public class HeapElement {
	double priority;
	int node;


	public HeapElement(double priority, int node) {
		super();
		this.priority = priority;
		this.node = node;
	}
	
	public double getPriority() {
		return priority;
	}
	
	public void setPriority(double priority) {
		this.priority = priority;
	}
	
	public int getNode() {
		return node;
	}
	
	public void setNode(int node) {
		this.node = node;
	}	
}
