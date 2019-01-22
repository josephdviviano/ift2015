The 10 points "Practical part" for the E18 course will probably be distributed in the same way
Next: Duty # 1 (1 point), Duty # 2 (3 points), Duty # 3 (6 points).


1. A vector is a one-dimensional array of elements. In several applications, the
elements of the vector may be zero. Such a vector is called hollow.

It is inefficient to use a table for storing a hollow vector. Consequently, we must choose a better representation.

One approach, among others, is to use a chained list. Each nonzero element of the hollow vector is associated with
a node in the chained list, containing its index, its value, and a pointer to the
next node, as follows:

You need to implement this data structure in Java. A skeleton file named SparseVector.java
you are already provided. Please submit your full version of the file on StudiUM, with the names
and matricles of the authors in comment at the beginning of the file.

1.

The omega(.) And Îsigma(.) Style markers are especially useful in a context where you do not know
the value of the function T (N): the process of interest is normally complicated,
and we are not able to say exactly the value of the function T (N). So at the moment
analysis, in tedious cases, we say "Phew, in all cases T (N) is never
bigger than . . . ", Or" Whew, in all cases T (N) is never smaller than. . . "
and we obtain terminals omega(...) and Îsigma(...). In case the approximations do not imply
that, for example, the choice of larger or smaller multiplicative constants we
will also have a bound Î (...).

This being said, here is a simple fact that makes me noticed. Suppose that T (N) is
known explicitly: any non-negative function, for example

T(N) = exp(N^3)/lg(N), 2 < N.

Find a function g(N) such that T(N) = O(g(N)), T(N) = Îsigma(g (N)), and T(N) =
Îtheta(g(N)). Give the proofs.

2.

Suppose a data structure queues. In the input suite we scan from
left to right: a letter means "tail" (add the letter to the tail), and a
"Star" means "tail-tail" (remove a letter from the tail). Give the sequence of
values returned if we apply the following sequence of operations, assuming the tail
empty at the start.

QUE*ST*I*ON***FAC***ILE*****

Show also, in a single drawing, the contents of the tail: strike the letter at the moment
to do tail-tail.

Let's now imagine different input sequences from this one. Suppose the
number of letters is equal to the number of stars. State a condition on the sequence that '
ensures that the sequence will produce an answer similar to the response produced by the
Sequence above

3.

(a) Weiss, Exercise 2.2, page 50, part (c) only. Give a proof or give a
simple counter-example.
(b) Weiss, Exercise 2.5, page 50

4.

Let Ti (mj, N) be the cost of solving a problem of size N using the method mj. In
the notation of the book (and the course), the average cost

...


the cost in the worst case

...

and the cost in the best case

where n is the number of problems of size N.

It is not possible that Tworst = O (N log N) and Tworst = sigma(N) at the same time as Tavg =
O (N log2 N) and Tavg = Îsigma(N log2 N). Give a formal proof that it is impossible.

5. Weiss, Exercise 2.7, page 50, part (a) only, and only cases (2), (3), (4) and (5).

6. We saw in the Course Introduction how to use a binary search tree,
with keys organized to satisfy the order in-order (Left-Root-Right), to search
a key in a time normally less than O (N). How to work in practice
for the tree to meet the condition Left-Root-Right? Index: Exercise 4.9 (a),
Weiss page 161.

7. Weiss, Exercise 4.7, page 161. (Proof is not needed for the second part
"Determine when the equality is true.")

