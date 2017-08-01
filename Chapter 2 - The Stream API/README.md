# Chapter 2 - The Stream API

## Task 1
Write a parallel version of the `for` loop in Section 2.1, "From Iteration to Stream Operations", on page 22. Obtain 
the number of processors. Make that many separate threads, each working on a segment of the list, and total up the 
result as they come in. (You don't want the threads to update a single counter. Why?)

## Task 2
Verify that asking for the first five long words does not call the filter method once the fifth long word has been 
found. Simply log each method call.

## Task 3
Measure the difference when counting long words with a `parallelStream` instead of a `stream`. Call 
`System.currentTimeMillis` before and after the call, and print the difference. Switch to a larger document (such as 
_War and Peace_) if you have a fast computer.