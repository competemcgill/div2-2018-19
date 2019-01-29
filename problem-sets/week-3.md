# Week 3 Problem Set

## Notes
For this problem set, problems have been taken from the [UVa Online Solver](https://uva.onlinejudge.org/index.php).

Test your ability to come up with a creative solution **with an efficient runtime** (aim to make it in a limited time). 


## Question 1 - Iterative (One Loop, Linear Scan)

**Necklace - UVa 11001** [[Link]](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=640&page=show_problem&problem=1942)


The people of a certain tribe produce circular ceramic discs with equal diameter by some rare clay. A necklace is formed by connecting one or more discs. The  gure below shows a necklace made with 4 discs. Its length is 4 times the diameter of each disc.

<p align="center"> <img src="https://puu.sh/CDVWx/b2272d5692.png" /> </p>

The thickness of each disc is fixed. The diameter *D* and the volume of clay used *V* has the following relationship:
<p align="center"> <img src="https://puu.sh/CDVVC/7e3c5191cc.png" /> </p>

where V<sub>0</sub> is the volume consumed in the baking process, in the same unit of V. When V ≤ V<sub>0</sub>, no ceramic discs can be made. As an example, let V<sub>total</sub> = 10, V<sub>0</sub> = 1. If we use it to make 1 disc, V = V<sub>total</sub> = 10, D = 0.9. If we divide the clay into 2 parts, the volume of each part V = V<sub>total</sub>/2 = 5, and diameter of each disc formed is D' = 0.3SQRT(5-1) = 0.6, this the length of necklace formed this way is 1.2.

As per the above example, it is obvious that the lengths of necklaces differ as the number of discs made changes. Please write a program that computes the number of discs one should make so that the necklas formed is the longest.

### Input
Each line of input contains two numbers, V<sub>total</sub> (0<V<sub>total</sub>≤60000) and V<sub>0</sub> (0<V<sub>0</sub>≤600), as defined above. Input ends with a case where V<sub>total</sub>=V<sub>0</sub>=0.

### Output
Each line of output should give the number of discs one should make so that the necklace formed is the longest. If this number is not unique, or no necklaces can be formed at all, output '0' instead.

### Sample Input
```
10 1
10 2
0 0
```

### Sample Output
```
5
0
```

## Question 2 - Iterative (Two Nested Loops)

**Vito's Family - UVa 10041** [[Link]](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=641&page=show_problem&problem=982)

The world-known gangster Vito Deadstone is moving to New York. He has a very big family there, all of them living in Lamafia Avenue. Since he will visit all his relatives very often, he is trying to find a house close to them.

Vito wants to minimize the total distance to all of them and has blackmailed you to write a program that solves his problem.

### Input
The input consists of several test cases. The first line contains the number of test cases. For each test case you will be given the integer number of relatives r (0 < r < 500) and the street numbers (also integers) s<sub>1</sub>, s<sub>2</sub>, ..., s<sub>i</sub>, ..., s<sub>r</sub> where they live (0 < s<sub>i</sub> < 30000 ). Note that several relatives could live in the same street number.

### Output 
For each test case, your program must write the minimal sum of distances from the optimal Vito's house to each one of his relatives. The distance between two street numbers s<sub>i</sub> and s<sub>j</sub> is d<sub>ij</sub? = |s<sub>i</sub> - s<sub>j</sub>|

### Sample Input
```
2
2 2 4
3 2 4 6
```
### Sample Output
```
2
4
```


## Question 3 - Iterative (Three-or-More Nested Loops)

**The Wedding - UVa 10662** [Link](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=642&page=show_problem&problem=1603)
 
Felix and Leti are going to get married soon, everybody is preparing their gifts, but they have a big problem: the money, their budget is not very high. They would like to get a good restaurant, to “sleep” their first night in a nice hotel and to spend a marvellous honey-moon travelling around the world.

The best way to get the cheapest price is getting an all-included package, that is, we have to contract the travel, the restaurant and the hotel all together.

Is that possible?

We have to find the cheapest travel agency-restaurant-hotel combination.The problem is that not all the combinations are allowed.

### Input
Each test case has the following format:

* The first line consists of three integers T, R, H indicating the number of travel agencies, restaurants and hotels, respectively. Assume that T  < 20, R < 20 and H  < 20. Travel agencies, restaurants and hotels are numbered: 0, 1, 2, ...

* The next T + R + H lines are divided into three blocks:
    * The first block has T rows and R+1 columns. The first column are the travel agencies’ offer prices for the world-tour. In the rest of columns, cell (i; j) is ‘0’ if the travel agency (i) can be combined with the restaurant (j) and ‘1’ if not.
    * The second block has R rows and H+1 columns. The first column are the restaurants’ offer prices. In the rest of columns, cell(i; j) is ‘0’ if the restaurant (i) can be combined with the hotel (j) and ‘1’ if not.
    * The third block has H rows and T+1 columns. The first column are the hotels’ offer prices. In the rest of columns, cell (i; j) is ‘0’ if the hotel (i) can be combined with the travel-agency(j) and ‘1’ if not.
* The input ends with an empty line.

### Output
For each test case the output should consist of a single line with the number of the travel agency (T), restaurant (R) and hotel (H), and the cheapest total price (P). This values should be output in the format: T R H: P.

   If there is not any combination, the output should be a line with the text: ‘Don't get married!’

   If more than one possibility exists, you can output any of them.

### Sample Input
```
2 2 2
12 0 0
1 1 1
34 0 0
3 1 1
21 1 0
2 1 0
2 2 2
12 0 0
1 0 0
34 0 0
3 0 0
21 0 0
2 0 0
5 5 6
970 0 1 1 1 0
856 0 0 0 0 0
1290 1 0 0 1 0
1361 0 0 1 0 0
82 0 0 0 0 1
1182 0 0 0 1 1 0
450 0 1 1 0 0 1
895 0 0 1 0 1 1
1865 0 1 0 0 1 1
183 1 1 1 1 1 0
252 1 1 1 0 1
1813 1 0 0 1 1
1429 0 0 1 0 0
1522 1 1 1 0 0
1762 0 0 1 0 1
1946 0 1 0 0 0
```

### Sample Output
```
Don't get married!
1 1 1:6
4 1 3:2054
```

## Question 4 - Recursive Backtracking (Easy)

**The Sultan Successor - UVa 00167** [Link](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=645&page=show_problem&problem=103)


The Sultan of Nubia has no children, so she has decided that the country will be split into up tokseparate parts on her death and each part will be inherited by whoever performs best at some test. Itis possible for any individual to inherit more than one or indeed all of the portions. To ensure thatonly highly intelligent people eventually become her successors, the Sultan has devised an ingenioustest. In a large hall filled with the splash of fountains and the delicate scent of incense have beenplacedkchessboards. Each chessboard has numbers in the range 1 to 99 written on each square and issupplied with 8 jewelled chess queens. The task facing each potential successor is to place the 8 queenson the chess board in such a way that no queen threatens another one, and so that the numbers on thesquares thus selected sum to a number at least as high as one already chosen by the Sultan. (For those unfamiliar with the rules of chess, this implies that each row and column of the board contains exactlyone queen, and each diagonal contains no more than one.)Write a program that will read in the number and details of the chessboards and determine thehighest scores possible for each board under these conditions. (You know that the Sultan is both agood chess player and a good mathematician and you suspect that her score is the best attainable.)

### Input

Input will consist ofk(the number of boards), on a line by itself, followed byksets of 64 numbers,each set consisting of eight lines of eight numbers. Each number will be a positive integer less than 100.There will never be more than 20 boards.

### Output

Output will consist ofknumbers consisting of yourkscores, each score on a line by itself and rightjustified in a field 5 characters wide.

### Sample Input
```
1
1   2   3   4   5   6   7   8
9   10  11  12  13  14  15  16
17  18  19  20  21  22  23  24
25  26  27  28  29  30  31  32
33  34  35  36  37  38  39  40
41  42  43  44  45  46  47  48
48  50  51  52  53  54  55  56
57  58  59  60  61  62  63  64
```

### Sample Output
```
260
```

## Question 5 - Recursive Backtracking (Medium)

**Transportation - UVa 00301** [Link](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=646&page=show_problem&problem=237)

Ruratania is just entering capitalism and is establishing new enterprising activities in many fieldsincluding transport. The transportation company TransRuratania is starting a new express train fromcity A to city B with several stops in the stations on the way. The stations are successively numbered,city A station has number 0, city B station numberm. The company runs an experiment in order to improve passenger transportation capacity and thus to increase its earnings. The train has a maximum capacity n passengers. The price of the train ticket is equal to the number of stops (stations) betweenthe starting station and the destination station (including the destination station). Before the train starts its route from the city A, ticket orders are collected from all on route stations. The ticket order from the station S means all reservations of tickets from S to a fixed destination station. In case the company cannot accept all orders because of the passenger capacity limitations, its rejection policy is that it either completely accept or completely reject single orders from single stations.

Write a program which for the given list of orders from single stations on the way from A to Bdetermines the biggest possible total earning of the TransRuratania company. The earning from one accepted order is the product of the number of passengers included in the order and the price of their train tickets. The total earning is the sum of the earnings from all accepted orders.

### Input

The input file is divided into blocks. The first line in each block contains three integers: passenger capacity n of the train, the number of the city B station and the number of ticket orders from all stations. The next lines contain the ticket orders. Each ticket order consists of three integers: starting station, destination station, number of passengers. In one block there can be maximum 22 orders. The number of the city B station will be at most 7. The block where all three numbers in the first line are equal to zero denotes the end of the input file.

### Output

The output file consists of lines corresponding to the blocks of the input file except the terminatingblock. Each such line contains the biggest possible total earning.

### Sample Input
```
10  3  4
0  2  1
1  3  5
1  2  7
2  3  10
10  5  4
3  5  10
2  4  9
0  2  5
2  5  8
0  0  0
```

### Sample Output
```
19
34
```

## Question 6 - Recursive Backtracking (Hard)

**Pizza Anyone? - UVa 00565** [Link](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=647&page=show_problem&problem=506)


You are responsible for ordering a large pizza for you and your friends. Each of them has told you what he wants on a pizza and what he does not; of course they all understand that since there is only going to be one pizza, no one is likely to have all their requirements satisfied. Can you order a pizza that will satisfy at least one request from all your friends?

The pizza parlor you are calling offers the following pizza toppings; you can include or omit any of them in a pizza

Your friends provide you with a line of text that describes their pizza preferences. For example, theline
`+O-H+P;` 
reveals that someone will accept a pizza with onion, or without ham, or with pepperoni, and the line
`-E-I-D+A+J;`
indicates that someone else will accept a pizza that omits extra cheese, or Italian sausage, or diced garlic, or that includes anchovies or jalapenos.

### Input
The input consists of a series of pizza constraints. 
A pizza constraint is a list of 1 to 12 topping constraint lists each on a line by itself followed by a period on a line by itself. 
A topping constraint list is a series of topping requests terminated by a single semicolon.
An topping request is a sign character (+/-) and then an uppercase letter from ‘A’ to ‘P’.

### Output
For each pizza constraint, provide a description of a pizza that satisfies it. A description is the string ‘Toppings:’ in columns 1 through 10 and then a series of letters, in alphabetical order, listing the toppings on the pizza. So, a pizza with onion, anchovies, fresh broccoli and Canadian bacon would be described by:
`Toppings: ACFO`
If no combination toppings can be found which satisfies at least one request of every person, your program should print the string
`No pizza can satisfy these requests.`
on a line by itself starting in column 1.

### Sample Input
```
+A+B+C+D-E-F-G-H;
-A-B+C+D-E-F+G+H;
-A+B-C+D-E+F-G+H;
.
+A+B+C+D;
+E+F+F+H;
+A+B-G;
+O+J-F;
+H+I+C;
+P;
+O+M+L;
+M-L+P;
.
+A+B+C+D;
+E+F+F+H;
+A+B-G;
+P-O;
+O+J-F;
+H+I+C;
+P;
+O;
+O+M+L;
-O-P;
+M-L+P;
.
```

### Sample Output
```
Toppings:
Toppings: CELP
No pizza can satisfy these requests.
```

