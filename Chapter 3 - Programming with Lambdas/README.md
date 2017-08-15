# Chapter 3 - Programming with Lambas

## Task 1
Enhance the lazy logging technique by providing conditional logging. A typical call would be 
`logIf(Level.FINEST, () -> i == 10, () -> "a[10] = " + a[10])`. Don't evaluate the condition if the logger won't log 
the message.

## Task 2
When you use a `ReentrantLock`, you are required to lock and unlock with the idiom
```
    myLock.lock();
    try {
        some action
    } finally {
        myLock.unlock();
    }
```
Provide a method `withLock` so that one can call
```
    withLock(myLock, () -> { some action })
```

## Task 3
Java 1.4 added assertions to the language, with an `assert` keyword. Why were assertions not supplied as a library 
feature? Could they be implemented as a library feature in Java 8?

## Task 4
How many functional interfaces with `Filter` in their name can you find in the Java API? Which ones add value over 
`Predicate<T>`?

## Task 5
Here is a concrete example of a `ColorTransformer`. We want to put a frame around an image, like this: 

![Photo](https://github.com/MrChebik/Java8-Training/blob/master/Chapter%203%20-%20Programming%20with%20Lambdas/task5-photo.png?raw=true)

First, implement a variant of the `transform` method of Section 3.3, "Choosing a Functional Interface", on page 50, 
with a `ColorTransformer` instead of an `UnaryOperator<Color>`. Then call it with an appropriate lambda expression to 
put a 10 pixel gray frame replacing the pixels on the border of an image.

## Task 6
Complete the method
```
    public static <T> Image transform(Image in, BiFunction<Color, T> f, T arg)
```
from Section 3.4, "Returning Functions", on page 53.

## Task 7
Write a method that generates a `Comparator<String>` that can be normal or reversed, case-sensitive or case-insensitive 
or space-insensitive, or any combination thereof. Your method should return a lambda expression.

## Task 8
Generalize Exercise 5 by writing a static method that yields a `ColorTransformer` that adds a frame of arbitrary 
thickness and color to an image.

## Task 9
Write a method `lexicographicComparator(String... fieldNames)` that yields a comparator that compares the given fields 
in the given order. For example, a `lexicographicComparator("lastname", "firstname")` takes two objects and, using 
reflection, gets the values of the `lastname` field. If they are different, return the difference, otherwise move on to 
the `firstname` field. If all fields match, return `0`.

## Task 10
Why can't one call
```
    UnaryOperator op = Color::brighter;
    Image finalImage = transform(image, op.compose(Color::grayscale));
```
Look carefully at the return type of the `compose` method of `UnaryOperator<T>`. Why is it not appropriate for the 
`transform` method? What does that say about the utility of structural and nominal types when it comes to function 
composition?