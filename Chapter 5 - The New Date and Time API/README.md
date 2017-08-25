# Chapter 5 - The New Date and Time API

# Task 1
Compute Programmer's Day without using `plusDays`.

# Task 2
What happens when you add one year to `LocalDate.of(2000, 2, 29)`? Four years ? Four times one year?

# Task 3
Implement a method `next` that takes a `Predicate<LocalDate>` and returns an adjuster yielding the next date fulfilling 
the predicate. For example,
```
    today.with(next(w -> getDayOfWeek().getValue() < 6))
```
computes the next workday.

# Task 4
Write an equivalent of the Unix `cal` program that displays a calendar for a month. For example, `java Cal 3 2013` 
should display
```
                 1  2  3
     4  5  6  7  8  9 10
    11 12 13 14 15 16 17
    18 19 20 21 22 23 24
    25 26 27 28 29 30 31
```
indicating that March 1 is a Friday. (Show the weekend at the end of the week.)