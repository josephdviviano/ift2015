import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class MyMainClass {

	private static Element start, end;
	
	public static void main(String args[]) {
		//read the data from the file
		readData("data.in");
		
		//find the maximum in your list
		double max = findMax(start);
		System.out.println("Max in list " + max);
		
	}


	
	private static double findMax(Element list){
		double max = -Double.MAX_VALUE;
		Element currentElement = list.getNext();

		while (currentElement!=end){
			if (max < currentElement.getValue()){
				max = currentElement.getValue();
			}
			currentElement = currentElement.getNext();
		}
		return max;
	}
	
	/**
	 * 
	 * @param filename The file from which we are reading the data 
	 */
	private static void readData(String filename){
		String line;
		double v;
		BufferedReader br = null;
		
		//initialize the sentinels
		end = new Element();
		start = new Element();
		start.setNext(end);
		
		try {
			br = new BufferedReader(new FileReader(filename));
			//read the list line by line
			while ((line = br.readLine()) != null) {
				v = Double.parseDouble(line); //read the number of elements in the list
				Element e = new Element(v);
				e.setNext(start.getNext());
				start.setNext(e);
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try{
				if (br != null){
					br.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
