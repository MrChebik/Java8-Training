# Task 19
## Task
Look at the `Stream<T>` method 
`<U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)`. Should `U` be declared 
as `? super U` in the first type argument to `BiFunction`? Why or why not?

## Answer
We add `? super` to any argument type that is not also a return type. So, `U` is the return type.