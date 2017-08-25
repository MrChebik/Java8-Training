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