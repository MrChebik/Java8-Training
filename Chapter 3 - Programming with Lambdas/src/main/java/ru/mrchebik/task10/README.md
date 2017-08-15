# Task 10
## Task
Why can't one call
```
    UnaryOperator op = Color::brighter;
    Image finalImage = transform(image, op.compose(Color::grayscale));
```
Look carefully at the return type of the `compose` method of `UnaryOperator<T>`. Why is it not appropriate for the 
`transform` method? What does that say about the utility of structural and nominal types when it comes to function 
composition?

## Answer
`UnaryOperator` inherit methods from `java.util.function.Function`, such as `compose` and that method return a 
`Function<V, R>`. We must to use `Function<V, R>` in `transform` method.