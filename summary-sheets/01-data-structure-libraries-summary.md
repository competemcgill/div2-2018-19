# Workshop 01: Data Structures and Libraries.

## Overview and Motivation
A data structure is a **tool for storing and organizing data.**
There are lots of different types of data structures, **each with their own strengths and weaknesses**.
**As a Competitive Programmer, it is crucial that you understand the pros, cons and time/space complexities of each of the typical data strucures**.

## Linear Data Structures:
**Definition**: *A data structure is linear if its elements form a linear sequence, i.e its elements are arranged from left to right or top to bottom.*

### Static Arrays:
**What**: A list of a specific size, with each index in the lsit containing a relevant data object.
**When to use it**: If there is a collection of sequential data to be stored and later accessed using their indices.

Arrays are typically **1D, 2D or 3D** in programming contests. They rarely have higher dimensions (this just becomes tedious and isn't really challenging your problem solving abilities anymore).

**What we do with arrays**: 
* Access elements by indices - **O(1)**
* Insert element at an index - **O(1)**
* Sort Elements - **O(n^2), O(nlogn), O(n)** - We'll discuss this more later.
* Linearly Scan (scan through elements, e.g. when list is unsorted) - **O(n)**

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
