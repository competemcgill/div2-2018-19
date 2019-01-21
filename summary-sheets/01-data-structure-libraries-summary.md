# Workshop 01: Data Structures and Libraries.

## Overview and Motivation
A data structure is a **tool for storing and organizing data.**
There are lots of different types of data structures, **each with their own strengths and weaknesses**.
**As a Competitive Programmer, it is crucial that you understand the pros, cons and time/space complexities of each of the typical data strucures**.

## Linear Data Structures:
**Definition**: *A data structure is linear if its elements form a linear sequence, i.e its elements are arranged from left to right or top to bottom.*

### Static Arrays:
**What**: A list of a specific size, with each index in the list containing a relevant data object.
**When to use it**: If there is a collection of sequential data to be stored and later accessed using their indices.

Arrays are typically **1D, 2D or 3D** in programming contests. They rarely have higher dimensions (this just becomes tedious and isn't really challenging your problem solving abilities anymore).

#### Operations and Runtimes:
| Operation                                                           | Runtime                |
|---------------------------------------------------------------------|------------------------|
| Access by Index (eg. `int x = array[2];`)                           | O(1)                   |
| Insert at Index (eg. `array[3] = x;`)                               | O(1)                   |
| Sort Elements (Discussed during Later Workshop)                     | O(n^2), O(nlogn), O(n) |
| Linear Scan (Loop through elements to find what you're looking for) | O(n)                   |

#### Example:
```java
import java.utils.*;

// Empty Array of Size 10
int[] myNumbers = new int[10];
myNumbers[0] = 1;
myNumbers[1] = 3;
myNUmbers[2] = 5;
System.out.println(myNumbers[0]); // Prints 1;
System.out.println(myNumbers[6]); // Prints 0 - this is the default value for integers in an array.

// Initializing with Values
int[] myNewNumbers = new int[] {4,3,2,1}; // Array with elements, of size 4.
int[] yourNumbers = {1,2,3,4}; // Equivalent to above. 

// Grab size
System.out.println(myNewNumbers.size); // Prints 4.

// Sort with Java Built in 
Arrays.sort(myNewNumbers); // myNewNumber is now {1,2,3,4}

// Compare Arrays
Arrays.equals(myNewNumbers, yourNumbers); // Returns true BUT DOES NOT WORK FOR MULTIDIMENSIONAL ARRAYS
// FOR MULTIDEMINSION ARRAYS USE Arrays.deepEquals(myNewNumbers, yourNumbers);
myNewNumbers == yourNumbers; // Returns false
myNewNumbers.equals(yourNumbers); // Returns false
```

### Dynamically Resizable Arrays - Array Lists

**What**: A list of *variable* size, with each index in the list containing a relevant data object.
**When to use it**: If there is a collection of sequential data to be stored and later accessed using their indices ** *and we don't know a strict upper bound for the size of the list when creating.* ** 

ArrayLists are extremely useful data structures. Their underlying implementation in Java is done with an Array - while this is not really knowledge that you need to keep in mind when beginning to code, you can look up why the runtimes are the way they are to understand what's going on!

#### Operations and Runtimes:
| Operation          | Runtime |
|--------------------|---------|
| add(Object o)      | O(1)    |
| remove(Object o)   | O(n)    |
| remove(int index)  | O(1)    |
| contains(Object o) | O(n)    |

#### Example:
```java
import java.utils.*;

ArrayList<Integer> numbers = new ArrayList<Integer>();

numbers.add(0);
int[] moreNumbers = new int[] {1,2,3};

numbers.addAll(moreNumbers); // adds all numbers at the end of above array list. - {0,1,2,3}
numbers.add(2, 7); // adds 7 to index 2 of the array list. - {0, 1, 7, 2, 3}
numbers.remove(1); // removes value at INDEX 2. - {0, 7, 2, 3}
numbers.remove(Integer.valueOf(7)); // removes integer 7. - {0, 2, 3}
numbers.removeAll(moreNumbers); // attempts to remove all numbers from above array, if can't remove all - remove none. - {0, 2, 3}
numbers.get(0); // retrieve integer at index 0. - {0, 2, 3}
numbers.contains(11); // test whether array list contains the integer 11. - {0, 2, 3}
numbers.size(); // return number of elements in array list - {0, 2, 3}
numbers.isEmpty(); // test whether array list is empty
numbers.indexOf(11); // returns index of first occurence of specified element, -1 if not found.
numbers.lastIndexOf(2); // returns index of last occurence of specified element, -1 if not found.

// Sorting 
Collections.sort(numbers);

// Sorting in reverse order
Collections.sort(numbers, Collections.reverseOrder());

// Reverse List
Collections.reverse(numbers)
```

### Java Linked List - Queues

**What**: A list of *variable* size, with each index in the list containing a relevant data object and reference to next element in the list.
**When to use it**: Really only used for Queues.

**Remember**: Queue is a FIFO (**F**irst **I**n **F**irst **O**ut) structure. 

**Problems with LinkedLists**: In order to access an element at a given index of your list, you need to loop through from the head or tail of your LinkedList, which takes O(N) time - a lot less efficient than their ArrayList and Array counterparts. This is not n issue for Queues.

**Note: Instantiate a LinkedList for use as a Queue as a Queue type. Queue is an interface that LinkedList implements and you can thus instantiate a LinkedList object as its type.**

#### Operations and Runtimes:
| Operation          | Runtime |
|--------------------|---------|
| add(Object o)      | O(1)    |
| element() / peek() | O(1)    |
| remove() / poll()  | O(1)    |
| size()             | O(1)    |
| isEmpty()          | O(1)    |

#### Example:

```java
import java.utils.*;

Queue<Integer> q = new LinkedList<Integer>();
int[] moreNumbers = new int[] {5,6,7};

// Add elements to the Queue
q.add(1);
q.add(2);
q.add(3);

// Add elements at specified index 
q.add(3,4); // Add integer 4 at index 3.

// Add all elements of an array at once
q.addAll(moreNumbers);

// Ad all elements of an array at once at a given index
q.addAll(7, moreNumbers);

// Dequeue an element
int first = q.poll(); // Returns null if not found.
try{
  first = q.remove(); // Throws NoSuchElementException if not found.
} catch(NoSuchElementException e){
  e.printStackTrace();
}

// View next element in Queue without dequeueing.
int next = q.peek(); // Returns null if not found.
try{
  next = q.element(); // Throws NoSuchElementException if not found.
} catch(NoSuchElementException e){
  e.printStachTrace();
}

// Grab size of Queue
int size = q.size();

// Test if Queue is empty
q.isEmpty();
```

### Stack

**What**: A list of *variable* size, conforming to the LIFO rule. (**L**ast **I**n **F**irst **O**ut)
**When to use it**: Lots of applications, often used as a type of buffer to specify order of processing elements.

#### Operations and Runtimes:
| Operation        | Runtime |
|------------------|---------|
| push(Object o)   | O(1)    |
| pop()            | O(1)    |
| peek()           | O(1)    |
| size()           | O(1)    |
| isEmpty()        | O(1)    |
| search(Object o) | O(n)    |

#### Example

```java
import java.util.*

Stack<Integer> s = new Stack<Integer>();

// Add onto top of the Stack
s.push(1);
s.push(2);
s.push(3);

// Stack s:
// ========
//
//   3
//   2
//   1
//  ====

// Pop from top of the Stack
int x;
try{
  x = s.pop(); // Throws EmptyStackException if Stack is empty.
} catch(EmptyStackException e) {
  e.printStackTrace();
}

// Stack s:
// ========
//
//   2
//   1
//  ====

// Peek at top of the Stack, without removing the element.
int y;
try{
  y = s.peek(); // Throws EmptyStackException if Stack is empty.
} catch(EmptyStackException e) {
  e.printStackTrace();
}

// Stack s:
// ========
//
//   2
//   1
//  ====

// Get Stack size
int z = s.size();

// Get Index of Given Element in Stack
int index = s.search(2); // Indexed from top, **starting at 1**!
// Stack s:
// ========
//
//   2 <-- Element 1
//   1 <-- Element 2
//  ====

```

## Non-Linear Data Structures

### General Trees

**What**: A structure organized such that elements are stored in nodes, and each node has a reference to a left and right child (which could be null in the case of leaf nodes.
**When to use**: Binary Search Trees, Heaps, Regular Trees.

#### Example Tree
```
       7
     /   \
    3     6
   / \   / \
  10  9 11  1
```
#### Example
```java

public class Node {
  int val;
  Node left;
  Node right;
  
  public Node(int val){
    this.val = val;
  }
}
```

**We can also Wrap the whole Tree in a class**
```java
public class Tree{
  Node root;
 
 public Tree(Node root){
  this.root = root;
 }
}
```

### Binary Search Trees

**What**: A tree conforming to the property that every element in a Node's left subtree is strictly less than the Node, and every element in its right subtree is strictly greater than or equal to the Node.
**When to use**: Allows faster searching (**O(logn)**).

#### Example Binary Search Tree
```
       10
    /      \
   4       15
 /   \    /   \
2    7   12    17
```

### Heaps

**What**: A tree conforming to the property that every element is greater (Max-Heap) or less than (Min-Heap) both of its children.
**When to use**: Repeatedly extracting Min or Max element.

**We will cover builtin Java data structure for Heaps later, for now ensure that you revise the runtimes for Heaps**

#### Operations and Runtimes (abstract)
| Operation             | Runtime |
|-----------------------|---------|
| extractMin/extractMax | O(logn) |
| insert                | O(logn) |

#### Example Heaps
```
    Min Heap
  =============
        4   <--- Minimum Element Always On Top
     /     \
   10       8
  /  \     /  \
14   21   11   10

    Max Heap
  =============
       20   <--- Maximum Element Always on Top
     /    \
   15      13
  /  \    /  \
 8    9  1    7

```

#### Implementing Heaps within an Array

To avoid dealing with creating our own data structure for heaps (or importing the Java PriorityQueue structure), we can implement a heap inside of a static or dynamic array. To do so, we fill in elements **starting at index 1** (we leave index 0 empty, because otherwise it breaks the relationships stated below), and by filling the elements in level-order into the array, we get a list that conforms to the following relationships:

**For a given element at index i:**

**Parent** - Found at index **floor(i/2)**
**Left Child** - Found at index **i\*2**
**Right Child** - FOund at index **i\*2 + 1**

##### Example Heap Array (From above Max Heap)
```
[0, 20, 15, 13, 8, 9, 1, 7] (note index 0 is left at 0)

Parent of 15:
15 is at index 2, its parent is at index floor(2/2) = 1. (20 is the parent of 15)

Left Child of 15:
15 is at index 2, its parent is at index 2*2 = 4. (8 is the left child of 15)

Right Child of 15:
15 is at index 2, its parent is at index 2*2 + 1 = 5 (9 is the right child of 15)
```

### Hash Maps

**What**: A storage of elements in pairs of Keys and Values.
**When to use**: Accessing elements by a given key. 

#### Operations and Runtimes
| Operation                              | Runtime |
|----------------------------------------|---------|
| get(Key k)                             | O(1)    |
| put(Key k, Value v) (Also putIfAbsent) | O(1)    |
| contains(Key k)                        | O(1)    |
| remove(Key k) / remove(Key k, Value v) | O(1)    |

#### Example
```java
import java.util.*;

HashMap<Character, Integer> charCount = new HashMap<>();

// Inserting a key-value pair. 
charCount.put('c', 1);

// Inserting a key-value pair, only if key is absent.
charCount.putIfAbsent('c', 2); 

// Checking if a key is contained within a HashMap
charCount.containsKey('c') // Return true;

// Checking if a value is contained within a HashMap
charCount.containsValue(2); // Return false

// Modifying the value associated with a given Key.
charCount.put('c', 2); // Now c is mapped to 2.

// Testing if a map is Empty
charCount.isEmpty(); // Return false;

// Removing a key from a HashMap, returning associated value if key exists, else null.
charCount.remove('a'); // Returns null.

// Removing a key from a HashMap, only if it is associated with the given value, returning true / false if value is removed..
charCount.remove('c', 1); // Return false;

// Obtaining the Set of Keys
Set<Character> chars = charCount.keySet();

// Obtaining the Collection of Values
Collection<Integer> counts = charCount.values();
```

