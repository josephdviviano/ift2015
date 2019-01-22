/**
 * 
 * @author Teodora DAN
 *
 */
public class Heap {
	int maximumHeapSize;
	int heapSize;
	HeapElement heap[];
	
	/**
	 * 
	 * @param _maximumHeapSize create a heap of size _maximumHeapSize
	 */
	public Heap(int _maximumHeapSize) {
		/**
		 * INSERT YOUR CODE HERE
		 * create a heap of size _maximumHeapSize
		 */
	}
	
	/**
	 * 
	 * @param he insert element he at the end, then percolate up
	 */
	public void insert(HeapElement he){
		/**
		 * INSERT YOUR CODE HERE
		 * add the element at the end, then percolate up
		 */
	}
	
	/**
	 * 
	 * @return return the root element, 
	 */
	public HeapElement deleteMin(){
		/**
		 * INSERT YOUR CODE HERE
		 * 
		 * delete and return the root element, replace it with the last element in the heap, then percolate down 
		 */
	}
	
	
	private void percolateDown(){
		/**
		 * INSERT YOUR CODE HERE
		 * compare the current element with its child/children
		 * if the current element is greater than one of its children, swap it with the minimum of its children
		 * otherwise stop
		 */
	}	

}
