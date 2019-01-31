# Week 1 & 2 Problem Set

## Notes
This problem set is created as a sort of warm up. Most problems have been taken from Cracking the Coding Interview, and some from club execs' real interview experiences at Microsoft, Google, Facebook and Amazon. They are good to get the gears going, but should not be taken as a reference for the styles of questions that will be covered over the course of the semester.

> Competitive Programming questions tend to be longer to code than Interview Questions. Interview Questions test fundamental knowledge of Data Structures and Algorithms as well as your ability to think on your feet and discuss logic with interviewers, whereas Competitive Programming questions feature more involved algorithms and test your ability to come up with a creative solution **with an efficient runtime** with your teammates in the allowed time. 

## Question 1

*Taken from Cracking the Coding Interview*

**Implement a Queue Data Structure with the use of 2 Stacks.**

## Question 2

*Taken from Cracking the Coding Interview, covered briefly in a Workshop from last semester.*

**Given the head of a linked list, return whether or not the linked list contains any loops (aka is *corrupted*).**

**Extension: return the Node at which the loop of the linked list begins.**

## Question 3

*Taken from LeetCode*

**Given 2 linked lists containing numbers in reverse order, return a linked list representing the sum of the 2 numbers.**

```
In:
3->0->2      203
9->0->6    + 609
=======     -----
Out:         812
2->1->8
```

## Question 4

*Real Interview*

**Given a Binary Tree, output the traversal in zig-zag order (see below).**

```
In: Root Node of below tree (6)

      6 <-- In
    /   \
   3     2
  / \   / \
 4  7  9   8
 
=========

Out: 
 [6, 2, 3, 4, 7, 9, 8]
```

## Question 5

*Real Interview, twice*

**Reconstruct a binary tree given In-Order and Post-Order traversals.**

```
In:
inOrder = [4, 13, 2, 11, 1, 6, 8, 7]
postOrder = [13, 4, 11, 2, 6, 7, 8, 1]

========

Out : Root of below tree
          1
       /     \
     2        8
   /   \    /   \
  4    11  6     7
    \
      13
```

## Question 6

*Real Interview*

**Given an array of numbers, output another array where the element at each index, i, is the product of all elements in in the input array EXCEPT for the element at index i**

**Extension: do this in place. (No additional data structures).**

**Extension II: do this in place, without dividing. (You're allowed Constant Time Space ( O(1) ) additional data structures)**

> Remember to also consider edge cases!

```
In:
[5, 4, 3, 1]

=======

Out:
[12, 15, 20, 60]

Explanation:
12 = 4 * 3 * 1
15 = 5 * 3 * 1
20 = 5 * 4 * 1
60 = 5 * 4 * 3
```

