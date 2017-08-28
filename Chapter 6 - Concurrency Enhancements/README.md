# Chapter 6 - Concurrency Enhancements

## Task 1
Write a program that keeps track of the longest string that is observed by a number of threads. Use an 
`AtomicReference` and an appropriate accumulator.

## Task 2
Does a `LongAdder` help with yielding a sequence of increasing IDs? Why or why not?

## Task 3
Generate 1,000 threads, each of which increments a counter 100,000 times. Compare the performance of using `AtomicLong` 
versus `LongAdder`.