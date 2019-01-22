Deliver your HuffmanCode.java file, only.
Do not forget to remove the package declaration, if you added it.
Make sure the delivered file compiles with javac and is encoded in UTF-8.

If you are in a team of two, please only submit your file once.

Huffman coding is a data compression algorithm that uses a prefix code, of variable length. The code is determined from a estimate of occurrence frequency for each symbol in a source. The principle of Huffman coding is based on the creation of a binary tree. Its leaves represent each character and its frequency. Its internal nodes represent the sum of the frequencies of their subtrees. The goal is to get a binary code, which uses the least bits for most common symbols. Either "Who powers Whooper", the sentence to code. Here is an example of the tree and the corresponding table:


| char | freq | code |
| h    |  2   | 000  | (last cell is path through the tree)
nb: leaf nodes contain 'char' and 'int', interna;l nodes contain 'left' and 'right' pointers.

They were generated as follows:

    echo Who powers Whooper | java HuffmanCode graph | dot -Tpdf -o graph.pdf
    echo Who powers Whooper | java HuffmanCode table | pandoc -o table.pdf

For this assignment, you must:

- [x] Complete the Node class, which represents a node (internal or leaf) in the Huffman tree.
- [x] Complete the function getCharacterFrequencies, which returns an array with the frequency of all the characters represented in ASCII on 8 bits, from a string from the standard input (stdin).
- [x] Complete the function getHuffmanTree which takes as parameter the table of frequencies, generates a Huffman tree, and returns the root node of this tree.
- [ ] Complete the printTable function, which prints a table in the format Markdown, performing an depth first search (DFS).
- [ ] Complete the printGraph function, which prints a graph in the format DOT, performing a breadth first search (BFS).

For this assignment you can:
+ Use any class from the standard Java library, which implements the Queue interface <E>, including java.util.PriorityQueue.
+ Refer to the table.md file, which contains the example table of the statement to get an idea of the format to use.
+ Refer to the graph.dot file, gracefully provided, which contains the example of the statement tree, as well as comments explaining the format to use.

It is also recommended to refer to section 10.1.2 of Weiss's book. The third volume of the book The Art of Computer Programming can be a good extra charge. Please submit your completed HuffmanCode.java file on StudiUM with the names and the numbers of the authors in comment of header.

