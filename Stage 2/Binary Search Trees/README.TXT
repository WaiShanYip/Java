PROJECT TITLE: Binary Search Trees
PURPOSE OF PROJECT: Stage 2 of University. Algorithms, Correctness and Efficiency ~ Assignment 2
VERSION or DATE: 02/11/2019
AUTHORS: Wai Shan (Karen) Yip, Lecturer: Stefan Kahrs
EXPLANATION: 
This focused on the implementation of Binary Search Trees.
All the tree nodes are stored in the Comparable[] array.
Every index position in the array corresponds to a subtree.
The array int[]sizes stores the sizes of the subtrees.
A size of 0 means the subtree is empty.
If the index is out of bounds of the array then the subtree is empty as well.

The method findIndex() returns the index position of the value x in the array, or where it would be placed in the array.
The method contains() returns true if the value entered is in the tree.
The method get() returns the i-th value in the tree, and null will be returned if the index is out of bounds.
The method insert() inserts the parameter value into the tree if the value is not already in the tree and then returns true.
The method grow() makes the tree bigger when the arrays are too small to insert new values.
The method delete() deletes the element from the tree and returns true after.
