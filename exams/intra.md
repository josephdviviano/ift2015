ete 2014
--------

1. Binary search trees

(a) What is the name of the order (in the sense of "travel order") normally used in the binary search trees?

preorder

(b) Using just three capital letters, give the definition of this order.

Root-Left-Rright

(c) Explain how to create a tree that respects this order, assuming available separate keys.

Increment through a list of the values in the array/list A, extracting each value 'x' one by one. Begin at the root node of the binary search tree T. If thid root is null, insert x there. Otherwise, if x is less than the data stored in this root, Otherwise, the value of the data store in the root, In both cases, you can apply this algorithm recursively (meaning, the left and right of the child to the new root).

(d) Show the result of using your "tree creation" algorithm in the case of keys F, E, D, C, B, A, K. (The keys are ordered by the lexicographic order and they are processed in the order indicated.)


    K
F <
    E <
        D <
            C <
                B <
                    A


2. Orthogonal matrices

In the Duty 2 you have implemented three functions related to the calculations with the matrices orthogonal, whose function vectorTTimesM atrix. Briefly describe the function vectorTTimesMatrix you have written.

3.

We were able to find an estimate of the expected value of I (internal path length). In fact, we have been able to demonstrate that this expected value, denoted D(N), is approximately equal to

N+1(2 x sum(1/i))

With what we know about Harmonic Numbers HN, it showed us that the average number of comparisons needed to search a tree random, is O (log N). It was a surprising result, but still a happy result. (Note here that (1) does not enter this question at all, I put it just to remind you a bit of what I'm talking about.)

The recurrence we found to make this proof was 'D is the average internal path length (mean(I))'.

    D(N) = 2 x [1/N sum(D(j))] + N-1

It would be reassuring to confirm that (2) gives the right result, at least for small values of N.

Take for example N=2. There are two permutations of two keys, so in total two possible trees, let us say the tree with B at the root and A as the left child, and the tree with A at the root and B as the right child. The value of I in both cases is equal to 1, the average value is 1, and the recurrence (2) does indeed give D(2)=1. We are reassured. By imitating this last sentence, show that the recurrence (2) gives the good result in the case N=3.


First, we solve the recurrance:

D(3) = 2 x [1/3] sum(D(j))] + 3-1; D(0)=0, D(1)=0, D(2)=1

therefore,

D(3) = 2 x [1/3 x 0+0+1] + 2
D(3) = 2 x [1/3] + 2
D(3) = 2/3 + 6/3
D(3) = 8/3

now the trees:

A-B-C, I=3
B-A-C, I=3
B-C-A, I=3

    B
A <    , I=2
    C

    A
C <    , I=2
    B

    A
B <    , I=2
    C

therefore, average internal path length D is

3+3+3+2+2+2 / 6 trees
15/6

Since 15/6 ~ 16/6, we show that

N+1(2 x sum(1/i))

= 3 + 1 (2 x (1/3 + 1/4))
= 4 (2 x (4+3 / 12))
= 4 (2 x (7/12))
= 4 (14/12)
= 55 / 12
~ 27.5 / 6


4. Monceau and bag

In the Priority TAD TAD there is the remove operation. Assuming you use a heap, explain briefly how this is done, and how bring the cost of the operation.

First, find and remove the element. This operation costs O(n) if this element is permitted to be any element, and operation costs O(1).

To delete this item, first remove it, and replace it with a bubble. We then take the final value of the heap (as represented in the array, i.e., the right-most value in the array) with the bubble. Then, do successive comparisons of this newly-placed value and it's children to 'percolate down' this number until the heap property is maintained: the bottom of the tree is filled left to right, and (in the case of a min heap), all parents are smaller than their children, or (in the case of the max heap), all parents are larger than their children.

Operation either costs O(n) + O(logn) or O(1) + O)logn).



In the TAD bag (example: particle simulation), there is the operation remove (x). Assuming you are using a linear array, and in suppose x already found, explain briefly how this is done, and comment on the cost of the operation.


5. Balanced trees

(a) Balanced trees can be used not only to find information associated with the key x, but also the information associated with the kth item in the structure (TAD List). To do this, we add to each node a field that gives the rank of the node, either

r = 1 + the number of nodes in the left subtree.

Assuming this information is available, give pseudo-code to find the kth item in the structure.

IDX = target_item_in_list
CTR = 0
# r is the rank of each node

def get_list(node):
    if IDX - CTR > r:
        CTR += r
        get_list(node.right)

    elif IDX - CTR <= r:
        CTR += 1
        get_list(node.left)

    elif IDX - CTR == 1:
        return(node.value)

(b) Indicate how to modify the r field when inserting data, in the case where we know a priori that the data is not already present.

The data will be placed at the bottom of the tree, in the first left-to right position at the shallowest level with empty nodes. When this is done, if the node is a left child, the r value for the parent will be incremented by 1, and this procedure will be continued recursively on the parents we reach the parent node, which will be incremented as well. If this addition is a right, child, we do nothing.

if left child -- all get +1
if right child -- all get +1 except it's parent


6.

(a) Express the relation between the generalized lists, and the "puisne" representation (first sibling after me + my first child) for the trees.

Each node of the tree points to the first child (beginning a list at the next level) and a second pointer to that node's next sibing. It is an example of a non-linear linked list.


(b) Express the relationship between the binary trees and the two things mentioned in part (a) of the question.

root = i, left child = 2i, right child = 2i+1

In binary trees you maintain an explicit pointer to the left and right child, but no pointer to any siblings.

7. Using the definition of n, show that if a function is omega(log N), then it is also omega(loglogN). Note: loglogN means log (log (N)).

There exists a constant c that is the element of the real+ numbers.
There exists a threshold n0 that is the element of the real+ numbers.

c log(n) > c loglog(n), since log(n) > loglog(n) for all n, and omega is a lower bound, omega(logn) is in omega(loglogn) for all n.



8. Suppose in an AVL tree that I found, after inserting a key, a lack of sway of the form d, d+2 at node P. Suppose also that the left child of P is TI, the right child of P is S, the children of S are T2 and T3, and I have inserted to the right of S. Show how to make the necessary rotation, and show that the order did not not changed after. (Note: it is not necessary to talk about the heights of subtrees.)

       d   d+2
         P               S
        / \             / \
      T1   S      =>   P   T3
          / \         / \    \
        T2   T3     T1   T2   X
              \
               X


9. For TAD Priority Queues, with remove, insert and initialize operations, give the costs using the notation 0(...), for the following two choices of structure of data: the heap, and a list sorted in a table.

heap
----
insert -- O(logn)
remove -- O(1) + O(logn)
initialize -- O(n) // assuming floyds algorithm

list
----
insert -- O(n)
remove -- O(n)
initalize -- O(nlogn)



ete 2015
--------
(a) Using just three capital letters, give the definition of the order (in the sense of "travel order") normally used in binary trees of research.

Root-Left-right

(b) Explain how to create a tree that respects this order, assuming available separate keys.

Preorder (see recursive answer to ete 2014).

(c) In the case of keys that may be identical (therefore not necessarily distinct), we can insist that all the keys in the left subtree of a node are strictly inferior to the key in the node. That is to say that the keys equals are always put in the right subtree. Show the result of using the algoritlune of "creation of tree" in the case of keys F, E, D, F, E, A, E. (The keys are ordered by the usual lexicographic order, and they are treated in the order indicated.) Explain also the advantage of insisting that all the keys in the left subtree of a node are strictly inferior to the key in the node.

    F
F <     E
    E <
        D <
            A


2.O n page 118 of Weiss's book, a lazy withdrawal strategy is suggested for trees, useful if the keys removed may be reinserted. Rather than removing a key, we will simply mark the node as removed (R). To start, if jrunais the key is reinserted, it will not be necessary to allocate space again. But in more, if the number of nodes that are still present in the tree is about the same as the number of nodes marked "R", then the increase in the depth of the tree should not be more than a small constant. Weiss asks you why. Why?

roughtly 1/2 of the number of nodes at the root, so if 1/2 nodes are added, it should add (on average) one layer to the tree.


3. Implantation of topological sorting In Duty 2 you have implemented topological sorting. What was the role of the class Element in this implantation? (Note: PhD students who do Predoc 1 are not obliged to do homework. These students can simply reply here uPrédoc l ".)


4. We noticed an alternative way of representing a tree (not necessarily binary), or the "puine" representation, where each node sc remembers its rightmost child, and his rightmost "sibling" one after him. If I see this as a example of a generalized list, what is the subclass of the generalized list?

Since this is a tree, there is only one path from the root to each leaf node. A PURE generalized list has this property.

Types of generalized lists:

+ LINEAR -- only one path from beginning to end
+ PURE -- one path from root to each leaf
+ REENTRANT -- can have repeat entries
+ CYCLIC -- can form cycles

GRAPH superset CYCLIC superset REENTRANT superset PURE superset LINEAR.


5. Heaps

(a) Give a simple proof that the creation of a heap is O(NlogN).

Insertion costs O(log n). We insert N times for the N element list to have sorted in a heap, which results in a total runtime of O(N logN).

(b) In fact, there is a better algorithm.
i. What is the name of this algorithm?

Floyd.

ii. What is the complexity of this algoritlune?

O(n)

iii. Briefly explain the operation of this algorithm.

Create a complete binary tree with all element filled at random. Then so a set of downs on the root node until the heap property (parents are greater than / less than their children, depending on whether we use min or max heaps).


6. Monceau and bag

(a) In the priority queue TAO there is the insert operation. Assuming you use a heap, explain briefly how this is done, and give the complexity (the cost) of the operation.

Insertion begins at the bottom leftmost location in the tree (since they are filled left-to-right and the trees are kept complete).

This value is then percolated up: one layer by one, this inserted value is compared with it's parent. In the case of a min tree, the value is percolated up if it is smaller than it's parent. Similarly for max trees, the value is percolated up if it is larger than it's parent. This procedure continues until the heap property is satified, or we reach the root.

Since there are O(logn) layers of the tree, this operation takes O(logn). It could also be in the correct location initially, so this operation is also omega(1).


(b) In the TAO bag {English "bag") (example: particle simulation), there is the operation remove {x). Assuming you are using a linear array, and in suppose x already found, explain briefly how this is done, and give the complexity (the cost) of the operation.


7. Suppose we have a reference to a Node node AVL, where

p.left = T1
p.right = S

and S (also of type AVL node) has

s.left = T2
s.right = T3

Suppose also that we have inserted a new node in T3 (this is the example of the course).

If I now have to do a simple rotation to bring S to the root, I start by taking note of P.

temp <- p.right

and I make two other assignments (which ones?) for (a) (b) before returning Temp as root.
Give the drawings (before and after the rotation), and give the assignments (a} and (b).
Hint: Both assignments involve Temp.xxx.

p.right = temp.left
temp.left = p


8. Weiss gives a proof similar to that which we gave in the case of the foundry of a medium binary search tree. This also serves for the analysis of quicksort. In his notation we have

    NT(N) = (N+1)T(N-1) + 2cN

where c is a constant. (Also, let's take T(l) = 0.)

Using the principle of "telescoping", and the fact that the harmonic numbers H_N are 9(N), demonstrate that T(N) = O(N logN).

nb: sum_n=0^k ((n) - (n-1)) = k - (0-1) = k+1



9.  Complexity
Note that is Tbest <= Tworst. Explain in both cases:

(a) Is it possible that Tbest is O(N^3), at the same time as Tworst is O(NlogN)?

No, best=N^3 > worst=NlogN, but tbest <= tworst, therefore this is impossible.

(b) Is it possible that Tbest is omega(N^2), at the same time as Tworst is O(NlogN)?

No, best N^2 > worst NlogN, but  Tbest should be < Tworst. Therefore this is impossible.

(c) Using the definition of omega(N), show that if a function is omega(1og N), then it is also omega(1/NlogN).

The definition of omega(N) is, there exists a constant c element of real+ numbers, there exists a threshold N0 element of real+ numbers, for all n > N0, then cg(n) is in f(n).

Since c * logN is always > c * 1/N logN, we can say that the function bounded from below by logN is also bounded from below by 1/N logN.


10. Briefly explain the 2 main approaches to collision resolution in the Hashing method.


1) seperate chaining -- the hash table contains a linked list at each hash location. collisions are stored in the linked list. so long as the number of collisions is reasonable, the length of these lists will be small and we will still have O(1) access.

2) probing -- comes in many forms, linear, quadratic, and double hashing. In all cases, you apply the original hash. If there is a collision, you apply a second 'increment' to the original hash location and try again. In linear probing, you add one to the index. In quadratic probing, you multiply the index by 2. In double hashing, you obtain the increment from a second fxn hash of the data. With each attempt you increment by this number. In all probing cases, you pay a penalty when many values cluster together, requiring many attempts before a successful insert or retrieval, otherwise you maintain O(1) function.


intra 2016
----------

4. we saw the case of rebalancing when the node P had factors d, d + 2,
and a left subtree Tl of height d. The child on the right of Pa
been noted S, and we looked at the case where the insertion was to the left of
S: indeed, for d 2 ::! the left child of S was rated R, R had two children T2
and T3, and the new node has been inserted as child of T2 or T3. The right
subtree of S is T4 (of height d).

I noted later in the course that in the case d = 0 the subtree T^ becomes
a single node, R and his children are replaced by the inserted node, and T& also
becomes a single node. We now have that T2 = T3 = A, and the R node
is absent. Both rotations, however, work as usual.

+ Draw the tree in the even more extreme case of d = -1.
    -- in this case T^ and T& are empty.

+ We always have in this case that T2 = T3 = A, and the node R is absent. The
  subtrees T^ and T& are what now?
+ Show the two rotations needed to rebalance the tree.

(b) Noting that in both cases, the insertion to the left of Set the insertion
on the right deS, the height of the tree does not change after the rotation (s),
someone arrives to the conclusion that we no longer need external memory
(disks, by example), because AVL trees in internal memory never change
height, regardless of the number of keys we insert into the tree. And
however, it seems to me that he should have a catch somewhere in this idea!
How can the height of the tree become larger?

6. The heaps
Store the keys of a heap in a linear structure, with the first key
in box 1, as we did in the course.
(a) Draw the "Complete" tree which has the following 12 keys:
    2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37.

                      2
                     / \
                    3   5
                  / |   | \
                 7  11 13  17
                /|  /\  ... lah blah


(b) Draw the "Complete" tree with 11 keys after the delete_min operation.
    Explain briefly the exchanges that have been made to get there.

                      3
                     /
                    7
                   ...
                 /
               37 (at bottom because its the largest one)

10.
Discrete Addressing (Hashing)

(a) In the External Lists method, we choose in practice a value
of NI (number of boxes) according to N, the expected value of the number of keys.
The purpose of this choice is to keep how much (what function of N and M)
small?

(b) What would be the point of replacing linear lists in the List method
External, by an AVL tree?

