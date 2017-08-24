# Chapter 4 - Java FX

# Task 1
Write a program with a text field and a label. As with the Hello, JavaFX program, the label should have the string 
Hello, FX in a 100 point font. Initialize the text field with the same string. Update the label as the user edits the 
text field.

# Task 2
Consider a class with many JavaFX properties, such as a chart or table. Chances are that in a particular application, 
most properties never have listeners attached to them. It is therefore wasteful to have a property object per property. 
Show how the property can be set up on demand, first using a regular field for storing the property value, and then 
using a property object only when the `xxxProperty()` method is called for the first time.

# Task 3
Consider a class with many JavaFX properties, most of which are never changed from a default. Show how the property can 
be set up on demand, when it is set to a nondefault value or when the `xxxProperty()` method is called for the first 
time.

# Task 4
Enhance the program in Section 4.5, "Bindings", on page 75 so that the circle stays centered and always touches at 
least two of the sides of the scene.

# Task 5
Write methods
```
    public static <T, R> ObservableValue<R> observe(
        Function<T, R> f, ObservableValue<T> t)
    public static <T, U, R> ObservableValue<R> observe(
        BiFunction<T, U, R> f, ObservableValue<T> t, ObservableValue<U> u)
```
that return observable values whose `getValue` method returns the value of the lambda expression, and whose 
invalidation and change listeners are fired when any of the inputs become invalid or change. For example,
```
    larger.disableProperty().bind(observe(
        t -> t >= 100, gauge.widthProperty()));
```

# Task 6
Center the top and bottom buttons in Figure 4-7.

# Task 7
Find out how to set the border of a control without using CSS.

# Task 8
Since there is no JavaFX-specific knowledge in parsing FXML files, come up with an example where you load an object 
that has nothing to do with JavaFX, with some nested objects, and set the properties in FXML syntax. Extra credit if 
you use injection.