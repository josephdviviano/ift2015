import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Devoir2 {
	public static BinaryTree tree = null;
	
	public static void main(String args[]){
		tree = new BinaryTree();
		readData("data.in");
		int pre[] = tree.preorderTraversal();
		int post[] = tree.postorderTraversal();
		verifyAncesters(pre, post, tree.getN(), "data2.in");
		
	}
	
	public static void verifyAncesters(int[] pre, int[] post, int n, String filename ){
		String line;		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(filename));
			while ((line = br.readLine()) != null) {
				String[] v = line.split(" ");
				int node1 = Integer.parseInt(v[0]);
				int node2 = Integer.parseInt(v[1]);
				int pos1pre = -1, pos1post = -1, pos2pre = -1, pos2post = -1;
				
				//look for positions of node1 and node2
				for (int i = 0; i<n; i++){
					pos1pre = pre[i] == node1? i:pos1pre; 
					pos1post = post[i] == node1? i:pos1post;
					pos2pre = pre[i] == node2? i:pos2pre; 
					pos2post = post[i] == node2? i:pos2post;
					if(pos1pre != -1 && pos1post != -1 && pos2pre != -1 && pos2post != -1){
						break;
					}
				}
				//check who's the ancester
				if (pos1pre == -1){
					System.out.println("The value " + node1 + " is not a valid value");
				}else if (pos2pre == -1){
					System.out.println("The value " + node2 + " is not a valid value");
				}else{
					if (pos1pre<pos2pre && pos1post>pos2post){
						System.out.println("Node " + node1 + " is an ancester of node " + node2);
					}else if (pos1pre>=pos2pre && pos1post<=pos2post){
						System.out.println("Node " + node2 + " is an ancester of node " + node1);
					}else{
						System.out.println("Node " + node2 + " is an not ancester of node " + node1 + " and node " + node1 + " is an not ancester of node " + node2);
					}
				}
				
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readData(String filename ){
		String line;
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(filename));
			while ((line = br.readLine()) != null) {
				int value = Integer.parseInt(line);
				tree.insert(value);
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
