# Week 5 Problem Set

## Notes
For this problem set, problems have been taken from the [UVa Online Solver](https://uva.onlinejudge.org/index.php).

Test your ability to come up with a creative solution **with an efficient runtime** (aim to make it in a limited time). 


## Question 1 - Graph Traversal

**Wedding of Sultan - UVa 12582** [[Link]](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=666&page=show_problem&problem=4027)

As usual Sultan Mahmud is very busy. He works days and nights at office. If you ask him, "Sultan,which day of the week is this?" He will look at you for a while and say, "I think I have 3 more days till deadline!" But one day the scenario changed after receiving a call. He usually ignores phone calls from everyone (even from his fiance) but this time he couldn't ignore because of the importance of the person! This person was his to-be mother-in-law. So he received the call and heard, "Son, only 30 days left of your wedding ceremony, so I am sending a tailor for the measurement for your suit." Sultan now remembered, he is about to get married but looking at thyself, he got surprised! When did he get so fat! "Umm.. Mom can it be arranged 10 days later?" He wants to buy some time so that he can exercise and lose extra weight. So he immediately went out with his bicycle to the large garden beside his house.There are several trails in the garden. A trail starts from one water sprinkler to another and the sprinklers are marked by distinct letters from 'A' to 'Z'. The trails are designed in such a way that from the sprinkler at entrance you can go to any other sprinkler using exactly one path if you do not traverse a trail more than once. While traversing the trails with his cycle, Sultan notes the names of the sprinklers in his notepad. He will write down the name of a sprinkler if he enters the sprinkler for the first time or leaves this sprinkler for the last time. And not surprisingly, geek Sultan follows a peculiar method to ensure that he visits all the trails of the garden. When he comes to a sprinkler he looks for a trail which he has not traversed yet. If he finds such trail, he follows that one. Otherwise, he uses the trail that he used to come here for the first time except if it's the entrance he stops exercising. He always starts from the entrance and guess what, his peculiar strategy always guarantees to finish him at the entrance and all the trails are also visited.

<p align="center"> <img src="https://puu.sh/CKrze/bd8485f0f3.png" /> </p>

For example, in the above garden the main entrance is at A. So Sultan will start from A. When Sultan is at A, he can choose either of the trails. Say he chooses the trail leading to E. Then he canchoose the trail to G or trail to F. Say he chooses F. Now he does not have any unvisited trail from F, so he will go back to E. Now he must choose trail to G and then similarly will come back to E and back to A. Then he will go towards B. Now he again has two choices. He can go to C or D, say he goes to C, then he will be back to B, then will go to D, and hence back to B and also back to A thus finishing his exercise. So after his exercise you will find: AEFFGGEBDDCCBA in his notepad. Can you  ndthe number of trails attached to the sprinklers just looking at the sequence written in the notepad?

### Input
First line of the test  le contains a positive integer T (T>=100) denoting the number of test cases. Hence follows T lines, each containing a valid sequence of sprinkler names. A sprinkler name will always be capital Latin letter (`'A', 'B', . . . , 'Z'`). You may assume that there will be at least two sprinklers in garden, otherwise there would have been no meaning of exercise right?

### Output
For each case output the case number in the first line, followed by the number of trails for each sprinkler. First print the sprinkler name followed by the count of trails. These lines should be in lexicographical order of sprinkler name. Note that, you should not print about a sprinkler which is not present in the garden. Look at the sample input output for more specific format of input output.

### Sample Input
```
2
AEFFGGEBDDCCBA
ZAABBZ
```

### Sample Output
```
Case 1
A = 2
B = 3
C = 1
D = 1
E = 3
F = 1
G = 1
Case 2
A = 1
B = 1
Z = 2
```

## Question 2 - Graph Traversal

**Theseus and the Minotaur - UVa 168** [[Link]](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=666&page=show_problem&problem=104)

Those of you with a classical education may remember the legend of Theseus and the Minotaur. This is an unlikely tale involving a bull headed monster, an underground maze full of twisty little passages all alike, love-lorn damsels and balls of silk. In line with the educational nature of this contest, we will now reveal the true story. The maze was actually a series of caverns connected by reasonably straight passages, some of which could only be traversed in one direction. In order to trap the Minotaur, Theseus smuggled a large supply of candles into the Labyrinth, as he had discovered that the Minotaur was afraid of light. Theseus wandered around somewhat aimlessly until he heard the Minotaur approaching along a tunnel. At this point he lit a candle and set off in pursuit. The Minotaur retreated into the cavern it had just left and fled by another passage. Theseus followed, slowly gaining, until he reached the k’th cavern since lighting the candle. Here he had enough time to place the lighted candle in the middle of the cavern, light another one from it, and continue the chase. As the chase progressed, a candle was left in each k’th cavern passed through, thereby limiting the movement of the Minotaur. Whenever the Minotaur entered a cavern, it would check the exits in a particular order, fleeing down the first that did not lead directly to a lit cavern. (Remember that as Theseus was carrying a lit candle, the Minotaur never exited a cavern by the tunnel used to enter it.) Eventually the Minotaur became trapped, enabling Theseus to defeat it. Consider the following Labyrinth as an example, where in this case the Minotaur checks the exits from a cavern in alphabetical order:

<p align="center"> <img src="https://puu.sh/CKrK8/957850465d.png" /> </p>

Assume that Theseus is in cavern C when he hears the Minotaur approaching from A, and that forthis scenario, the value of k is 3. He lights a candle and gives chase, pursuing it through A, B, D (leaves a candle), G, E, F (another candle), H, E, G (another), H, E (trapped). Write a program that will simulate Theseus’s pursuit of the Minotaur. The description of a labyrinth will identify each cavern by an upper case character and will list the caverns reachable from that cavern in the order that the Minotaur will attempt them, followed by the identifiers for the caverns which the Minotaur and Theseus were in when contact was first made, followed by the value of k.

### Input
Input will consist of a series of lines. Each line will describe a scenario in the format shown below (which describes the above example). No line will contain more than 255 characters. The file will be terminated by a line consisting of a single ‘#’

### Output 
Output will consist of one line for each Labyrinth. Each line will identify the lit caverns, in the orderin which the candles were left, and the cavern in which the Minotaur was trapped, following the format shown in the example below.

### Sample Input
```
A:BCD;B:AD;D:BG;F:H;G:DEH;E:FGH;H:EG;C:AD. A C 3
#
```
### Sample Output
```
D F G /E
```


## Question 3 - Minimum Spanning Tree

**Oreon - UVa 1208** [Link](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=673&page=show_problem&problem=3649)
 
In the 25th century, civilization is struck by a series of calamities that eventually led mankind to build walled cities interconnected by tunnel bridges to facilitate transportation.  Each walled city possesses a unique ore required to build and repair all infrastructure including the tunnels. This material which when  combined  with  other  ores  from  all  others  cities  form  an  almost  indestructible  material called "oreon". 
   Outside the walled cities are uncivilized barbarians armed with antiquated but destructive weaponry which can effectively shoot down any air transport, but only damage and not penetrate tunnel bridges. Thus each city is interconnected to more than one city in order to have access redundancy in case one of its interconnecting tunnels is damaged. 
   If a tunnel is damaged, it becomes impassable and would require a substantial amount of "oreon" to repair the damage. When a single city is  made isolated, meaning all of its interconnections are damaged, "oreon" cannot be manufactured which may lead to the eventual  destruction of the wall fortifying the city. You, being the head of the homeland defense unit, are tasked to ensure that all cities remain accessible even by at least a single interconnecting tunnel at all times. Faced with only a limited manpower in the defense unit, you have to determine which tunnel to protect using the least number of people and ensure that no city will be isolated. 
   Figure 2 shows a map of the walled cities, their interconnecting tunnels and the number of security personnel.

<p align="center"> <img src="https://puu.sh/CKrW8/22b8bc4f99.png" /> </p>

### Input
The input will contain several test cases. The first line will indicate the number of test cases. Each testcase begins with a number representing the number of walled cities. Cities are labeled alphabetically using the letters in the English alphabet. The subsequent lines contain the number of security personnel needed to protect the tunnel connecting each city to all other cities. A value of zero implies no security personnel needed since no tunnel exists.  You are to output which tunnel should be protected and how many personnel are needed for each tunnel.

### Output
The output shows the tunnel connection which is named after the cities that it connects and the number of personel needed to protect the tunnel.

### Sample Input
```
1
6
0, 8, 12, 0, 0, 7
8, 0, 0, 3, 0, 0
12, 0, 0, 0, 6, 0
0, 3, 0, 0, 0, 4
0, 0, 6, 0, 0, 5
7, 0, 0, 4, 5, 0
```

### Sample Output
```
Case 1:
B-D 3
D-F 4
E-F 5
C-E 6
```

## Question 4 - Minimum Spanning Tree

**IP-TV - UVa 1174** [Link](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=673&page=show_problem&problem=3615)

A consortium of European Internet providers manages a large backbone network, with direct links(connections) between a large number of European cities. A link between a pair of cities is bidirectional.The transmission of a message in a link has an associated cost. As it is common in the Internet, it is possible to use a (unbounded) sequence of direct links to indirectly transfer data between any pair of cities. For allowing the broadcast of TV programs using this backbone, it is necessary to continuously send data to all nodes in the network. For helping to minimize costs, it is necessary to select the network links that will be used for transmitting data. The set of selected links must be connected and include all nodes in the network.For helping the consortium to manage its network, you have been asked to create a program that computes the minimum cost for transmitting data to all cities of the backbone. Given a set of network links, compute the minimum transmission cost for reaching all nodes.

### Input

Input consists of multiple test cases the first line of the input contains the number of test cases.
   There is a blank line before each dataset.
   The first line of each dataset contains a positive integer *M*, not greater than 2,000, with the number of cities that have network connections. The second line contains an integer *N* not greater than 50,000, with the number of existing links. Each of the following *N* lines contains the representation of a link. Each line contains two strings and one integer, separated by empty spaces, *B E C*, where *B* and *E* are the city names of the endpoints of the network link, with no more than 8 characters, and *C* is apositive integer, not greater than 30, representing the cost of transmitting in the link.

### Output

For each test case, the output consists of one single line that contains an integer with the minimum transmission cost for sending data to all cities.
   Print a blank line between datasets.

### Sample Input
```
1
4
5
lisbon  london  6
lisbon  paris  5
london  paris  1
london  berlin  2
paris  berlin  10
```

### Sample Output
```
8
```


