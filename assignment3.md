1. (1 point) Hash for chains
It has been said in the course that it is possible to do the modulo as and when measure in the calculation of the hashing function (Horner rule).

If we perform the operation a <- b mod M we get a such that a = b (mod M) and a (element of) [0, M - 1]. We are interested in the case where a, b, x and M are non-negative integers.

Show that (((ax)) mod M) + b) mod M = (ax + b) mod M.

2. (1/2 point) Sewn trees
The motivation for sewn trees is not to waste the fields that contain null references in a binary tree (which is perhaps eg a binary search tree): use these fields to other types of operation.

If there are N keys in the tree, how many null references? Explain (
It's trivial for you now).

3. (1 point) Prim / Dijkstra
In Prim's algorithm there is a field of the table T, ie T [v].p, which contains the value of p, and the pairs (v, p) give the edges in the tree underlying minimal.

We saw the small modification of Prim's algorithm that gives the Dijkstra algorithm. Give pseudo-code a recursive procedure which gives, for the Dijkstra algorithm, the path of the starting point (v4 in the example presented in the course) to the specified node. For example,
for the example presented in the course, a call with v6 would give:

v4 to v5 to v7 to v6

4. (1/2 point) Uniqueness Prim
Weiss, page 419, Exercise 9.15, (a) and (b), with Prim's algorithm alone for part (a).

5. (1 point) Splay Tree
Weiss, page 163, Exercises 4.27, 4.28 and 4.29.

