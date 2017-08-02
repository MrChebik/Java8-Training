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

## Task 4
Suppose you have an array `int[] values = { 1, 4, 9, 16 }`. What is `Stream.of(values)`? How do you get a stream of 
`int` instead?

## Task 5
Using `Stream.iterate`, make an infinite stream of random numbers — not by calling `Math.random` but by directly 
implementing a _linear congruential generator_. In such a generator, you start with _x[0] = seed_ and then produce 
_x[n + 1] = 1 (a x[n] + c) % m_, for appropriate values of _a_, _c_, and _m_. You should implement a method with 
parameters `a`, `c`, `m`, and `seed` that yields a `Stream<Long>`. Try out _a_ = 25214903917, _c_ = 11, and _m_ = 2^48.

## Task 6
The `characterStream` method in Section 2.3, "The `filter`, `map`, and `flatMap` Methods", on page 25, was a bit 
clumsy, first filling an array list and then turning it into a stream. Write a stream-based one-linear instead. One 
approach is to make a stream of integers from `0` to `s.length()` - `1` and map that with the `s::charAt` method 
reference.