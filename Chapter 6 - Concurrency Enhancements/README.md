# Chapter 6 - Concurrency Enhancements

## Task 1
Write a program that keeps track of the longest string that is observed by a number of threads. Use an 
`AtomicReference` and an appropriate accumulator.

## Task 2
Does a `LongAdder` help with yielding a sequence of increasing IDs? Why or why not?

## Task 3
Generate 1,000 threads, each of which increments a counter 100,000 times. Compare the performance of using `AtomicLong` 
versus `LongAdder`.

## Task 4
Use a `LongAccumulator` to compute the maximum or minimum of the accumulated elements.

## Task 5
Write an application in which multiple threads read all words from a collection of files. Use a 
`ConcurrentHashMap<String, Set<File>>` to track in which files each word occurs. Use the `merge` method to update the 
map.

## Task 6
Repeat the preceding exercise, but use `computeIfAbsent` instead. What is the advantage of this approach?

## Task 7
In a `ConcurrentHashMap<String, Long>`, find the key with maximum value (breaking ties arbitrarily). Hint: 
`reduceEntries`.

## Task 8
How large does an array have to be for `Arrays.parallelSort` to be faster that `Arrays.sort` on your computer?

## Task 9
You can use the `parallelPrefix` method to parallelize the computation of Fibonacci numbers. We use the fact that the 
`n`th Fibonacci number is the top left coefficient of F^`n`, where F = ( 1 1 1 0 ). Make an array filled with 2 × 2 
matrices. Define a `Matrix` class with a multiplication method, use `parallelSetAll` to make an array of matrices, and 
use `parallelPrefix` to multiply them.

## Task 10
Write a program that asks the user for a URL, then rads the web page at that URL, and then displays all the links. Use 
a `CompletableFuture` for each stage. Don't call `get`. To prevent your program from terminating prematurely, call
```
    ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
```