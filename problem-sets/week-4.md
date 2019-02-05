# Week 4 Problem Set

## Notes
For this problem set, problems have been taken from the [UVa Online Solver](https://uva.onlinejudge.org/index.php).

Test your ability to come up with a creative solution **with an efficient runtime** (aim to make it in a limited time). 


## Question 1 - Dynammic Programming

**Coin Change - UVa 674** [[Link]](https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=615)

Suppose there are 5 types of coins: 50-cent, 25-cent, 10-cent, 5-cent, and 1-cent. We want to make
changes with these coins for a given amount of money.

  For example, if we have 11 cents, then we can make changes with one 10-cent coin and one 1-cent
coin, two 5-cent coins and one 1-cent coin, one 5-cent coin and six 1-cent coins, or eleven 1-cent coins.
So there are four ways of making changes for 11 cents with the above coins. Note that we count that
there is one way of making change for zero cent.

  Write a program to find the total number of different ways of making changes for any amount of
money in cents. Your program should be able to handle up to 7489 cents. 

### Input
The input file contains any number of lines, each one consisting of a number for the amount of money
in cents.

### Output
For each input line, output a line containing the number of different ways of making changes with the
above 5 types of coins.

### Sample Input
```
11
26
```

### Sample Output
```
4
13
```

## Question 2 - Divide & Conquer

**Where's the Marble? - UVa 10474** [[Link]](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=661&page=show_problem&problem=1415)

Raju and Meena love to play with Marbles. They have got a lot of
marbles with numbers written on them. At the beginning, Raju would
place the marbles one after another in ascending order of the numbers
written on them. Then Meena would ask Raju to find the first marble
with a certain number. She would count 1...2...3. Raju gets one point
for correct answer, and Meena gets the point if Raju fails. After some
fixed number of trials the game ends and the player with maximum
points wins. Today it’s your chance to play as Raju. Being the smart
kid, you’d be taking the favor of a computer. But don’t underestimate
Meena, she had written a program to keep track how much time you’re
taking to give all the answers. So now you have to write a program,
which will help you in your role as Raju.

### Input
There can be multiple test cases. Total no of test cases is less than 65. Each test case consists begins
with 2 integers: N the number of marbles and Q the number of queries Mina would make. The next
N lines would contain the numbers written on the N marbles. These marble numbers will not come
in any particular order. Following Q lines will have Q queries. Be assured, none of the input numbers
are greater than 10000 and none of them are negative.
  
  Input is terminated by a test case where N = 0 and Q = 0.

### Output 
For each test case output the serial number of the case.
  For each of the queries, print one line of output. The format of this line will depend upon whether
or not the query number is written upon any of the marbles. The two different formats are described below:

• ‘x found at y’, if the first marble with number x was found at position y. Positions are numbered
1, 2, . . . , N.

• ‘x not found’, if the marble with number x is not present.

Look at the output for sample input for details.

### Sample Input
```
4 1
2
3
5
1
5
5 2
1
3
3
3
1
2
3
0 0
```
### Sample Output
```
CASE# 1:
5 found at 4
CASE# 2:
2 not found
3 found at 3
```


## Question 3 - Greedy Algorithms

**Work Reduction - UVa 10670** [Link](https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1611)
 
Paperwork is beginning to pile up on your desk, and tensions at the workplace are starting to mount. Your boss hasthreatened to fire you if you don’t make any progress by the
end of the day. You currently have N units of paperworkon your desk, and your boss demands that you have exactly M units of paperwork left by the end of the day.

The only hope for you now is to hire help. There are various agencies which offer paperwork reduction plans:

  • For $A they will reduce your paperwork by one unit.
  
  • For $B they will reduce your entire paperwork by half (rounding down when necessary).

  Note that work can never be reduced to less than 0.
  Your task now is to produce a sorted table of agency names and their respective minimum costs to solve your workload problem.

### Input
The first line of input consists of a single positive integer representing the number of cases to follow.
Each case begins with three positive integers separated by spaces:
  N - your starting workload, M - your target workload, and L - the number of work reduction
agencies available to you, (1 ≤ M ≤ N ≤ 100000, 1 ≤ L ≤ 100). The next L lines have the format
‘agency name:A,B’, where A and B are the rates as described above for the given agency. (0 ≤
A, B ≤ 10000). The length of the agency name will be between 1 and 16, and will consist only of
capital letters. Agency names will be unique.

### Output
For each test case, print ‘Case X’, with X being the case number, on a single line, followed by the
table of agency names and their respective minimum costs, sorted in non-decreasing order of minimum
costs. Sort job agencies with identical minimum costs in alphabetical order by agency name. For each
line of the table, print out the agency name, followed by a space, followed by the minimum required
cost for that agency to solve your problem.

### Sample Input
```
2
100 5 3
A:1,10
B:2,5
C:3,1
1123 1122 5
B:50,300
A:1,1000
C:10,10
D:1,50
E:0,0
```

### Sample Output
```
Case 1
C 7
B 22
A 37
Case 2
E 0
A 1
D 1
C 10
B 50
```
