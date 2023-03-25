# JAVA-Labs
# Bithday Paradox
The goal of this lab is to write a class, Birthday, for conducting experiments to test the
“Birthday Paradox,” which states that if 23 people gather, the chances are 50-50 that there are
two people in the group having the same birthdays.
This observation comes from the following analysis. Assume that there are 365 days in a year
and the birthdays of people are evenly distributed on the 365 possible dates. In other words, for
each day of a year, the expected proportion of the people born on that day is 1/365 of the entire
population. Under these assumptions, the probability that randomly selected 23 people have 23
distinct birthdays collectively is:/n
365*364*...*343/365^23
/n
The denominator represents the number of possible choices for the birthdays collectively given to
the 23 people. The numerator represents the number of possibilities for the 23 people to select
their birthdays so that no two people choose the same birthdays. There, the first person has 365
possibilities, the second has 364 because she must not pick the one that the first person has chosen,
the third person has 363 because she must not pick the ones that the first and the second persons
have chosen, and so on. The fraction has the value approximately equal to 0.50, so the chances are
almost 50-50 that there are two people having the same birthdays.
First Experiment:
The centerpiece of the code is a method, oneTrial, that, given a number of people as its parameter,
randomly selects birthdays for those people and produces for each day how many people
have selected that day as birthdays. More formally, the method receives the number of people,
nPeople, as its formal parameter and returns an array of int whose length is 365. The method first
instantiates an array of 365 elements, named theCounts. Then, it enters a for-loop that iterates
1, ..., nPeople with some iteration variable. In each iteration of the loop, the method selects a
random integer between 0 and 364, and then increases the element of the array theCounts at the
selected position by 1. After quitting the loop, the method returns the array theCounts. Since the
elements of arrays of numbers are initialized with the value 0, explicit initialization is not needed.
After receiving the return value of oneTrial, we examine the elements of the array, looking for
an element with the value greater than or equal to 2. Such an element indicates the existence of
multiple people having the same birthdays. We write a method, hasAHit, for executing this search.
The method receives an int array as its parameter and returns a boolean. Using a for-loop,
the method scans the elements of the array given as the formal parameter. On encountering an
element whose value is greater than or equal to 2, the method immediately returns true, ignoring
1
the remaining elements of the array. If this does not happen, the loop terminates. At that point,
the method returns false.
Using the above two methods, we write another method, experiment1. This method has two
formal parameters. The first is an int named nPeople. This is the value to be passed to oneTrial
as the number of people. The second is an int as well and is named nReps. This is the number
of times to execute oneTrial. Use a for-loop to count the executions of oneTrial. After each
execution, feed the return array of oneTrial to hasAHit. If hasAHit returns true, increase the
value of a double variable, hitRate, by 1. The initial value of hitRate is 0. After completing
the loop, we divide hitRate by nReps. The value of hitRate then becomes the proportion of the
repetitions in which the random birthday selections generated multiple people having the same
birthdays. The method experiment1 reports this ratio before terminating.
The main method receives the quantities for nPeople and nReps and calls experiment1 with
these two values as the actual parameters.
To print the average, use "%.3f" in printf so that exactly three digits appear after the decimal
point.
Second Experiment:
Given the return value of oneTrial, we want to count the birthdays with no people, exactly one
person, exactly two people, and more than two people. Write a method, summarize, that receives
an array named theCounts, which is expected to be an array returned by oneTrial, as its formal
parameter, and returns an array that takes an inventory of the array as an array of int. The method
examines the elements of the array and finds the largest value appearing in it. To determine the
large value, the method uses an int variable named largest with the initial value of 0. Then the
method scans the array. It compares each element against the largest and replaces it with the
larger of the present value of largest and the element being scanned. Once the largest element
has been found, the method instantiates an int array values with largest + 1 elements. Then
it scans the array again. The element it encounters during the scan is between 0 and largest and
so can be thought of as a position in the array values. The method increases the element at the
position.
After the inventory has been taken, the method reports the result:
System.out.printf( "\%d Hits: \%d\n", i, values[ i ] );
with the value of i iterating from 0 to largest.
Here are some execution examples:

Experiment #1
Enter the no. of people: 23
Enter the no. of repetitions: 100
Experiment 1
Probability Of Hits: 0.440
Experiment #2
Enter the no. of people again: 600
Experiment 2
0 hits: 61
2
1 hits: 132
2 hits: 89
3 hits: 54
4 hits: 21
5 hits: 6
6 hits: 1
7 hits: 0
8 hits: 1

Experiment #1
Enter the no. of people: 35
Enter the no. of repetitions: 100
Experiment 1
Probability Of Hits: 0.830
Experiment #2
Enter the no. of people again: 365
Experiment 2
0 hits: 134
1 hits: 136
2 hits: 67
3 hits: 19
4 hits: 7
5 hits: 2
3
