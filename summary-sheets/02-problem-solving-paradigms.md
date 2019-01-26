# Worskshop 02: Problem Solving Paradigms
## Overview and Motivation
**What is a paradigm?** A paradigm is : 
* A method of approaching and solving a specific problem
* A guiding methodology to use when approaching a particular type pf problem
* A tool used to attack and solve a problem
* Crucial for competitive programming compertitions with repeated problem types
These paradigms are very important since by using the right paradigm for a problem, we can get the **lowest Big O** runtime.

We will discuss four different types of problem solving paradigms: **Complete Search** (Brute Force), **Divide and Conquer**, **The Greedy Approach**,
and **Dynmaic Programming**.

## Complete Search (Brute Force)
### Definition
Also known as force or recursive backtracking, The Complete Search technique is a
method for solving a problem by traversing the entire (or part of the) search space to obtain
the required solution.

During the search, we are allowed to *prune*, e.g., choose not to explore parts of the search soace if we know that 
that these parts cannot contain the solution.

**When to use:** 
* When there is clearly no other algorithm available (e.g. the task of enumerating all permutations
of {0, 1, 2, . . .,N − 1} will require **_O(N!)_** regardless.
* When better algorithms exist, but are overkill as the input size is small (e.g. N < 100)

In ICPC (International Collegiate Programming Contest), Complete Search should be the first solution considered 
as it is easy to come up with and code it. A A bug-free Complete Search solution should never receive the
Wrong Answer (WA) response in programming contests as it explores the entire search space. However, it can excede 
(most probably does) the time limit and therefore we need a better solution.

**Example**: Given 6 < k < 13 integers, enumerate all oissible subsets of size 6 of these integers in sorted order.

**Answer**: 
~~~java
// S is array of k integers
 for (int a = 0; a < k - 5; a++)
  for (int b = a += 1; b < k - 4; b++)
    for (int c = b + 1; c < k - 3; c++)
      for (int d = c + 1; d < k - 2; d++)
        for (int e = d + 1; e < k - 1; e++)
          for (int f = e + 1; f < k; f ++)
            System.out.printf("%d %d %d %d %d %d\n", S[a], S[b], S[c], S[d], S[e], S[f]);
~~~
### Tips for Complete Search
#### Tip 1:  Filtering versus Generating
**Filters:** Programs that examine lots of (if not all) candidate solutions and choose the ones that are
correct (or remove the incorrect ones).

**Generators:** Programs that gradually build the solutions and immediately prune invalid partial solutions.

**Generally:** 
* Generators are easier to implement when written recursively as it gives greater flexibility for pruning the 
search space.
* Filters are easier to code than generators but run slower, given that it is usually far more difficult to 
prune more of the search space iteratively.

#### Tip 2: Prune Infeasible/Inferior Search Space Early
1. When generating solutions using recursive backtracking, we build partial potential solution.
2. We may encounter a partial solution that will never lead to a full solution.
3. Prune search there and explore other parts of the search.

#### Tip 3: Utilize Symmetries
To elaborate this tip, assume that there are 92 solutions for a problem; however, only 12 solutions are unique, as 
there are rotational and line symmetries on the problem. Take advantage by generating the 12 unique solutions and, 
if needed, generate the whole 92 by rotating and reflecting these 12 unique solutions.

**Note:** Symmetries can sometimes complicate code. Use them only if there is an obvious benefit, such as simplicity 
and runtime speed.

#### Tip 4: Optimizaing your souce code:
Understanding computer hardware and how it is organized, can help you design better code, e.g:
1. Use `BufferedReader/BufferedWriter` classes instead of `System.out.print()` and `java.util.Scanner` class.

Example:
~~~java

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


BufferedReader br = new BufferedReader(       // speedup
  new InputStreamReader(System.in));
// Note: String splitting and/or input parsing is needed afterwards

PrintWriter pr = new PrintWriter(new BufferedWriter(        // speedup
  new OutputStreamWriter(System.out)));
// PrintWriter allows us to use the pr.printf() function
// do not forget to call pr.close() before exiting your Java program

~~~

2. Acess a 2D array row by row (row-major fashion) rather than column by column, since multidimensional arrays are 
stored in row-major order in memory.
3. Declare most data structures globally once, and allocate enough memory to deal with the largest input of the 
problem. This way, you can avoid passing data structures as function arguments.
4. Array access in (nested) loops can be slow. If you frequently access the value A[i] of an array A without changing it, 
it may be beneficial to use a local variable `temp = A[i]` and work with `temp` instead.
5. Be careful with `String` manipulation as Java `String` objects are immutable. Operations on Java `Strings` can thus be very
slow. Use Java `StringBuilder` instead.



## Divide and Conquer
### Definition
Divide and Conquer (D&C) is a problem-solving paradigm in which a problem
is made simpler by ‘dividing’ it into smaller parts and then conquering each part.
Divide and Conquer is recursive in nature.
**The steps:**
1. **_Divide_** the original problem into sub-problems that are similar to the original but smaller 
in size
2. **_Conquer_** the sub-problems by solving them recursively. If they are small enough, just solve 
them in a straightforward manner
3. **_combine_** the sub-solutions to get a complete solution for the main problem

Many algorithms use Divide and Conquer strategu, e.g. Merge Sort, Quick Sort, Heap Sort, and Binary Search.

Example Code: Binary Search
~~~java
// arr[] is array, l is left index, r is right index, x is desired entry being searched for
int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)             // if element is at mid point
                return mid;
            if (arr[mid] > x)			 // if element is smaller than midpoint, must be in left subarray
                return binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);  // else in right subarray
        }
        return -1;    // x is not in the array
    }

~~~

## Greedy
### Definition
An algorithm is said to be greedy if it makes the locally optimal choice at each step with the
hope of eventually reaching the globally optimal solution. In some cases, greedy works—the
solution is short and runs efficiently.

A problem must exhibit these two properties in order for a greedy algorithm to work:
1. It has optimal sub-structures i.e. optimal solution to the problem contains optimal solutions to the sub-problems.
2.It has the greedy property (difficult to prove in time-critical contest environment!).
If we make a choice that seems like the best at the moment and proceed to solve the
remaining subproblem, we reach the optimal solution. We will never have to reconsider
our previous choices.

### Example: Dragons of Loowater
* There are n dragon heads and m knights (1 ≤ n,m ≤ 20000). 
* Each dragon head has a diameter and each knight has a height. 
* A dragon head with diameter D can be chopped off by a knight with height H if D ≤ H. 
* A knight can only chop off one dragon head. 
* Given a list of diameters of the dragon heads and a list of heights of the knights, is it possible to chop off 
all the dragon heads? 
* If yes, what is the minimum total height of the knights used to chop off the dragons’ heads?

**The problem can be solved greedily:**
* Each dragon head should be chopped by a knight with the shortest height that is at least as tall as the 
diameter of the dragon’s head.
* However, the input is given in an arbitrary order. 
* If we sort both the list of dragon head diameters and knight heights in O(n log n + mlogm), we can use
the O(min(n,m)) scan below to determine the answer.

**NOTE:** this is one of many questions where sorting the input can help produce the greedy strategy.

~~~java
gold = d = k = 0; // array dragon+knight are sorted in non decreasing order
  while (d < n && k < m) { // still have dragon heads or knights
    while (dragon[d] > knight[k] && k < m) k++; // find the required knight
      if (k == m)
        break; // no knight can kill this dragon head, doomed :S
      gold += knight[k]; // the king pay this amount of gold
      d++; k++; // next dragon head and knight please
}
if (d == n) 
  System.out.printf("%d\n", gold); // all dragon heads are chopped
else
  System.out.printf("Loowater is doomed!\n");
~~~

## Dynamic Programming - DP
Dynamic programming programming is the most challenging problem-solving technique among the four 
paradigms, as there is a lot of recursion and recurrence relations!

**The key?**
* Determine problem states.
* Determine the relationships and transitions between current problems and their sub-problems.

**When?** 
Primarily: DP is used to solve optimization problems and counting and problems.If you encounter a problem that
says:
  * "minimize this"
  * "maximize that"
  * "count the ways to do that"
  
 Most DP problems in contests ask for the optimal value and not the optimal solution itself. This makes the 
 problem easier to solve by removing the need to backtrack and produce the solution. However, some harder DP 
 problems also require the optimal solution.
 
 **_Vocab_**: **State** - a unique subproblem
 
### Top-Down DP
1. Start from biggest subproblems (top).
2. Recursively go downwards (down) till you reach the smallest subproblems.
3. Solve these and chain recursion back up

#### Top-Down DP solution:
1. Initialize DP ‘memo’ table with dummy values e.g. ‘-1’. Table dimensions correspond to the problem states.
2. At the start of recursive function, check if this state has been computed before.
(a) * If it has been computed, return the value from the DP memo table, O(1).
(b) * If it has not been computed
  * Perform the computation once, O(?) - varies based on task
  * Store this computed value in table, O(1)
  * Future calls to this sub-problem (state) return answer immediately, O(1)
  * **NOTE:** The process is called Memoization
 
 
### Bottom-Up DP
Solve subcases and build solution “upwards” using existing small problem solutions to solve big problems
#### Bottom-up DP solution :
1. Determine the required set of parameters that uniquely describe a subproblem (a state). 
2. If there are N parameters required to represent the states, prepare an N dimensional DP table, with 
one entry per state. In bottom-up DP, we only need to initialize some cells of the DP table with known initial values (the base cases). 
3. Now, with the base-case cells/states in the DP table already filled, determine the cells/states that can be filled next (the transitions). 
4. Repeat this process until the DP table is complete. This is usually accomplished through iterations (loops)

### Top-Down vs Bottom-Up

| Top-Down  | Bottom-Up  |
|---|---|
| **Pros**:<br/>1. It is a natural transformation from the normal Complete Search recursion <br/>2. Computes the sub-problems only when necessary (sometimes this is faster)| **Pros**: <br/>1. Faster if many sub-problems are revisited as there is no overhead from recursive calls <br/>2. Can save memory space with the 'space saving trick' technique|
| **Cons**:<br/>1. Slower if many sub-problems are revisited due to function call overhead (this is not usually penalized in programming contests)<br/> 2. If there are M states, an O(M) table size is required, which can lead to MLE for some harder problems.  | **Cons:**<br/>1. For programmers who are inclined to recursion, this style may not be intuitive <br/>2. If there are M states, bottom-up DP visits and fills the value of all these M states  |

### DP Example: Coin Change

**Problem:** Given a value V, if we want to make change for V cents, and we have infinite supply of 
each of C = { C1, C2, .. , Cm} valued coins, what is the minimum number of coins to make the change?

**Example**
~~~
Input: coins[] = {25, 10, 5}, V = 30
Output: Minimum 2 coins required
We can use one coin of 25 cents and one of 5 cents 

Input: coins[] = {9, 6, 5, 1}, V = 11
Output: Minimum 2 coins required
We can use one coin of 6 cents and 1 coin of 5 cents
~~~

The brute-force solution can be obtained using the recursive formula:
~~~
If V == 0, then 0 coins required.
If V > 0
   minCoin(coins[0..m-1], V) = min {1 + minCoins(V-coin[i])} <br/>
                               where i varies from 0 to m-1  <br/>
                               and coin[i] <= V 
~~~

**Java implementation:**

~~~java
// A Naive recursive JAVA program to find minimum of coins 
// to make a given change V 

class coin 
{ 
    // m is size of coins array (number of different coins) 
    static int minCoins(int coins[], int m, int V) 
    { 
       // base case 
       if (V == 0) return 0; 
       // Initialize result 
       int res = Integer.MAX_VALUE; 
       
      // Try every coin that has smaller value than V 
       for (int i=0; i<m; i++) 
       { 
         if (coins[i] <= V) 
         { 
             int sub_res = minCoins(coins, m, V-coins[i]); 
       
             // Check for INT_MAX to avoid overflow and see if 
             // result can minimized 
             if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res) 
                res = sub_res + 1; 
         } 
       } 
       return res; 
    } 
    public static void main(String args[]) 
    { 
       int coins[] =  {9, 6, 5, 1}; 
       int m = coins.length; 
       int V = 11; 
       System.out.println("Minimum coins required is "+ minCoins(coins, m, V) ); 
    } 

}/* This code is contributed by Rajat Mishra */
~~~

**Output**
~~~
Minimum coins required is 2
~~~

If we draw the recursive tree, you can see that many subrpoblems are solved more than once. For example, 
when we start from V = 11, we can reach 6 by subtracting one 5 times and by subtracting 5 one times. 
So the subproblem for 6 is called twice.

In other words, this problem has Overlapping Subprolems property. We can use memoization to avoid 
recomputing the overlapping subproblems. This can be done by constructing a temporary array table[][] in 
bottom up manner. Below is Dynamic Programming based solution.

~~~java
// A Dynamic Programming based Java 
// program to find minimum of coins 
// to make a given change V 

import java.io.*; 

  

class GFG  
{ 
    // m is size of coins array  
    // (number of different coins) 
    static int minCoins(int coins[], int m, int V) 
    { 
        // table[i] will be storing  
        // the minimum number of coins 
        // required for i value. So  
        // table[V] will have result 
        int table[] = new int[V + 1]; 
        
        // Base case (If given value V is 0) 
        table[0] = 0; 

        // Initialize all table values as Infinite 
        for (int i = 1; i <= V; i++) 
        table[i] = Integer.MAX_VALUE; 

        // Compute minimum coins required for all 
        // values from 1 to V 

        for (int i = 1; i <= V; i++) 
        { 
            // Go through all coins smaller than i 
            for (int j = 0; j < m; j++) 
            if (coins[j] <= i) 
            { 
                int sub_res = table[i - coins[j]]; 
                if (sub_res != Integer.MAX_VALUE  
                       && sub_res + 1 < table[i]) 
                       table[i] = sub_res + 1; 
            } 
        } 
        return table[V]; 
    } 
    // Driver program  
    public static void main (String[] args)  
    { 
        int coins[] = {9, 6, 5, 1}; 
        int m = coins.length; 
        int V = 11; 
        System.out.println ( "Minimum coins required is " 
                            + minCoins(coins, m, V)); 
    } 
} 

//This article is contributed by vt_m. 
~~~

**Output**
~~~
Minimum coins required is 2
~~~








