/**
 * @author Joseph Viviano - 20115694
 * @author Marzieh Mehdizadeh - C8478
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class Node implements Comparable<Node> {

    // Attributes
    public final char symbol;
    public final int frequency;
    public final Node left, right;
	public String code;

    // Leaf Node
    Node(char symbol, int frequency) {
        this.frequency = frequency;
        this.symbol = symbol;
        this.left = null;    // init to null
        this.right = null;   //
        this.code = "";
    }

    // Internal Node
    Node(Node left, Node right) {
    	// sum of frequencies -- @ root, sum is length of string
    	//this.frequency = left.frequency + right.frequency;

        if ((this.left = left) != null)
            frequency += left.frequency;

        if ((this.right = right) != null)
            frequency += right.frequency;


    	this.symbol = '\0'; // use null representation of null
        this.left = left;   // pointers to left and right children
        this.right = right; //
    }

    boolean isLeaf() {
        // left and right node must be null
        return (left == null) && (right == null);
    }

    @Override
    public int compareTo(Node node) {
        // 'node' is the external node we are comparing our frequency to,
        // 'this' is the current node.
        if (this.frequency < node.frequency)
            return -1;
        else if (this.frequency > node.frequency)
            return 1;
        return 0;
    }

    @Override
    public String toString() {
        // get the representation of a node in DOT format

        // node information common to all types of nodes
        // Obj.hashCode() [label=Obj.frequency, shape=rectangle, width=.5]
        // String.format(%d [label=\"{{'%c'|%d}}\", shape=record]", hashCode(), symbol, frequency)
        String set = (this.hashCode() + " [label=" + this.frequency + ", shape=rectangle, width=.5]" + System.lineSeparator());

        // write the symbols for the leaf
        // Obj.hashCode() [label="{{'Obj.symbol'|Obj.frequency}}", shape=record]
        if (isLeaf()) {
        	set = set.concat(this.hashCode() + " [label=\"{{'" + this.symbol + "'|" + this.frequency + "}}\", shape=record]" + System.lineSeparator());

        // write information pointing to the two children
        // edge left:   Obj.hashCode() -- Obj.left.hashCode() [label=0]
        // edge right:  Obj.hashCode() -- Obj.right.hashCode() [label=1]
        } else {
            set = set.concat(this.hashCode() + " -- " + this.left.hashCode() + " [label=0]" + System.lineSeparator());
            set = set.concat(this.hashCode() + " -- " + this.right.hashCode() + " [label=1]" + System.lineSeparator());
        }

        return set;
    }
}


  class NodeComparator implements Comparator<Node>{

      // Overriding compare() method of Comparator for descending order of node
      // frequency. -1 if node 1 has a higher frequency than node 2, 1 if node 2
      // has higher frequency than node 1, and 0 if they are equal.
      public int compare(Node n1, Node n2) {
          if (n1.frequency < n2.frequency)
              return -1;
          else if (n1.frequency > n2.frequency)
              return 1;
          return 0;
          }
      }


class HuffmanCode {

    /**
     * @param text text to analyze
     * @return frequency of each ASCII character (8 bit)
     */
    private static int[] getCharacterFrequencies(String text) {

        char[] input = text.toCharArray();
        int[] freq = new int[256]; // 256 ASCII chars in 8 bit

        // increment frequency at the correct idx in character array
        for (int i = 0; i < input.length; i++)
            freq[input[i]]++;

        // for (char c : text.toCharArray())
        //     if (c < 256)
        //         freq[c]++;


        return freq;
    }

    /**
     * @param charFreq character frequency
     * @return root node of the tree
     */
    private static Node getHuffmanTree(int[] charFreq) {

        PriorityQueue<Node> heap = new PriorityQueue<Node>();

        for (int i = 0; i < charFreq.length; i++) {
            if (charFreq[i] > 0) {
                // add all frequencies > 0  as Node(symbol, frequency) to heap
                char symbol = (char) i;
                heap.add(new Node(symbol, charFreq[i]));
            }
        }

        // if (nodes.size() == 1)
        //     return new Node(heap.poll(), null);
        ////     return new Node(heap.poll(), New node())

        while (heap.size() > 1) {
            // build tree from the bottom (2 lowest freq nodes)
            Node node1 = heap.poll();
            Node node2 = heap.poll();

            // newNode is new parent of node1 and node2
            // frequencies of node 1 and 2 are added as part of constructor
            Node newNode = new Node(node1, node2);

            // push new internal node back into heap
            heap.add(newNode);
        }

        Node root = heap.poll();
        return root;
    }


    /**
     * @param node current node
     * @param code Huffman Code
     * @throws IOException
     */
    private static void printTable(Node node, String code) throws IOException {

    	// depth first search -- preorder / postorder / inorder? -- stack
        Stack<Node> s = new Stack<Node>();
        ArrayList<Node> visited = new ArrayList<Node>();

        s.add(node); // add root node

        if (node == null);
            return

        // ...
        // } else {
        //     printTable(Node.left, code+'0')
        //     printTable(Node.right, code+'1')


        while (s.size() > 0) {
        	Node currNode = s.pop();

        	// if this is a leaf, print some stuff
        	if (currNode.isLeaf()) {
        		if (currNode.symbol != '\0') {
        		    System.out.printf("%-4s %3s %5s %n", currNode.symbol, currNode.frequency, currNode.code);
        		} else {
        			System.out.printf("    ");
        			System.out.printf("%4d ", currNode.frequency);
        			System.out.printf("%s %n", currNode.code); // 4 spaces for empty char

        		}
        	}

        	// if we haven't already visited this node

    		if (!visited.contains(currNode.right) && currNode.right != null ) {
    			if (currNode.code != null) {
    				currNode.right.code = currNode.code + "1";
    			} else  {
    			    currNode.right.code = "1";
    			}
    			s.add(currNode.right);
    		}

        	if (!visited.contains(currNode)) {
        		visited.add(currNode);

        		if (!visited.contains(currNode.left) && currNode.left != null ) {
        			if (currNode.code != null) {
        			    currNode.left.code = currNode.code + "0";
        			} else {
        				currNode.left.code = "0";
        			}
        			s.add(currNode.left);

        	    } // children visited?
            } // current visited?
        } // while
    }


    /**
     * @param node Node to begin printing from
     * @throws IOException
     */
    private static void printGraph(Node node) throws IOException {

        Queue<Node> q = new LinkedList<>();

        // header
        System.out.println("graph{" + System.lineSeparator());
        System.out.println("    node [style=rounded]" + System.lineSeparator());

        // breadth first search to add node information -- uses queue
        q.add(node); // adds the root node

        // continue until all nodes in tree have been processed
        while (q.size() > 0) {

        	// dequeue
        	Node currNode = q.poll();

        	// write contents of node
        	System.out.println(currNode.toString());

        	// enqueue left to right
        	if (currNode.left != null) {
        	    q.add(currNode.left);
        	}

        	if (currNode.right != null) {
            	q.add(currNode.right);
        	}
        }

        // footer
        System.out.println("}" + System.lineSeparator());
    }

    // do not modify!
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Node root = getHuffmanTree(getCharacterFrequencies(reader.readLine()));

        // Table
        if (args.length == 0 || Arrays.asList(args).contains("table")) {
            System.out.println("Char Freq Code\n---- ---- ----");
            printTable(root, "");
        }

        // Graph
        if (args.length == 0 || Arrays.asList(args).contains("graph")) {
            printGraph(root);
        }
    }
}

