# Chapter 2 - The Stream API

## Task 1
Write a parallel version of the `for` loop in Section 2.1, "From Iteration to Stream Operations", on page 22. Obtain 
the number of processors. Make that many separate threads, each working on a segment of the list, and total up the 
result as they come in. (You don't want the threads to update a single counter. Why?)