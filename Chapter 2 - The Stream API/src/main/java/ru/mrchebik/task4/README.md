# Task 4
## Task
Suppose you have an array `int[] values = { 1, 4, 9, 16 }`. What is `Stream.of(values)`? How do you get a stream of 
`int` instead?

## Answer
`Stream.of(values)` - convert an array of values to `Stream` with specified class. You can get `Stream` from an array:

- `Arrays.stream(array);`
- `Arrays.toList(array).stream();`

> We have an array of `int[]`, and must to use: `IntStream` instead `Stream`.