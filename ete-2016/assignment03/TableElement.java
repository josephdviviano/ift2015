/**
 * 
 * @author Teodora DAN
 *
 */
public class TableElement {
	int visited;
	double distance;
	int parent;
	
	
	public TableElement(int visited, double distance, int parent) {
		super();
		this.visited = visited;
		this.distance = distance;
		this.parent = parent;
	}

	public int getVisited() {
		return visited;
	}
	
	public void setVisited(int visited) {
		this.visited = visited;
	}
	
	public double getDistance() {
		return distance;
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public int getParent() {
		return parent;
	}
	
	public void setParent(int parent) {
		this.parent = parent;
	}
	
}
