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

## Task 11
Implement static methods that can compose two `ColorTransformer` objects, and a static method that turns a 
`UnaryOperator<Color>` into a `ColorTransformer` that ignores the _x-_ and _y-_ coordinates. Then use these methods to 
add a gray frame to a brightened image. (See Exercise 5 for the gray frame.)

## Task 12
Enhance the `LatentImage` class in Section 3.6, "Laziness", on page 56, so that it supports both `UnaryOperator<Color>` 
and `ColorTransformer`. Hint: Adapt the former to the latter.

## Task 13
Convolution filters such as blur or edge detection compute a pixel from neighboring pixels. To blur an image, replace 
each color value by the average of itself and its eight neighbors. For edge detection, replace each color value _c_ 
with _4c — n — e — s — w_, where the other colors are those of the pixel to the north, east, south, and west. Note that 
these cannot be implemented lazily, using the approach of Section 3.6, "Laziness", on page 56, since they require the 
image from the previous stage (or at least the neighboring pixels) to have been computed. Enhance the lazy image 
processing to deal with these operations. Force computation of the previous stage when one of these operators is 
evaluated.

## Task 14
To deal with lazy evaluation on a per-pixel basis, change the transformers so that they are passed a `PixelReader` 
object from which they can read other pixels in the image. For example, `(x, y, reader) -> reader.get(width - x, y)` is 
a mirroring operation. The convolution filters from the preceding exercises can be easily implemented in terms of such 
a reader. The straightforward operations would simply have the form `(x, y, reader) -> reader.get(x, y).grayscale()`, 
and you can provide an adapter from `UnaryOperation<Color>`. A `PixelReader` is at a particular level in the pipeline 
of operations. Keep a cache recently read pixels at each level in the pipeline. If a reader is asked for a pixel, it 
looks in the cache (or in the original image at level 0); if that fails, it constructs a reader that asks the previous 
transform.

## Task 15
Combine the lazy evaluation of Section 3.6, "Laziness", on page 56, with the parallel evaluation of Section 3.7, 
"Parallelizing Operations", on page 57.

## Task 16
Implement the `doInOrderAsync` of Section 3.8, "Dealing with Exceptions", on page 58, where the second parameter is a 
`BiConsumer<T, Throwable>`. Provide a plausible use case. Do you still need the third parameter?

## Task 17
Implement a `doInParallelAsync(Runnable first, Runnable second, Consumer<Throwable>)` method that executes `first` and 
`second` in parallel, calling the handler if either method throws an exception.

## Task 18
Implement a version of the `unchecked` method in Section 3.8, "Dealing with Exceptions", on page 58, that generates a 
`Function<T, U>` from a lambda that throws checked exceptions. Note that you will need to find or provide a functional 
interface whose abstract method throws arbitrary exceptions.

## Task 19
Look at the `Stream<T>` method 
`<U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)`. Should `U` be declared 
as `? super U` in the first type argument to `BiFunction`? Why or why not?

## Task 20
Supply a static method `<T, U> List<U> map(List<T>, Function<T, U>)`.