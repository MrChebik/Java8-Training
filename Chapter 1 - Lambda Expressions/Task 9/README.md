# Task 9
Form a subclass `Collection2` from `Collection` and add a default method `void forEachIf(Consumer<T> action, 
Predicate<T> filter)` that applies `action` to each element for which `filter` returns `true`. How could you use it?