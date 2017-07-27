# Chapter 1 - Lambda Expressions

## Task 1
Is the comparator code in the `Arrays.sort` method called in the same thread as the call to `sort` or a different 
thread?

## Task 2
Using the `listFiles(FileFilter)` and `isDirectory` methods of the `java.io.File` class, write a method that returns 
all subdirectories of a given directory. Use a lambda expression instead of a `FileFilter` object. Repeat with a method 
expression.

## Task 3
Using the `list(FilenameFilter)` method of the `java.io.File` class, write a method that returns all files in a given 
directory with a given extension. Use a lambda expression, not a `FilenameFilter`. Which variables from the enclosing 
scope does it capture?

## Task 4
Given an array of `File` objects, sort it so that directories come before the files, and within each group, elements 
are sorted by path name, Use a lambda expression, not a `Comparator`.

## Task 5
Take a file from one of your projects that contains a number of `ActionListener`, `Runnable`, or other like. Replace 
them with lambda expression. How many lines did it save? Was the code easier to read? Where you able to use method 
references?

## Task 6
Didn't you always hate it that you had to deal with checked exceptions in a `Runnable`? Write a method `uncheck` that 
catches all checked exceptions and turns them into unchecked exceptions. For example,
```
new Thread(uncheck(
    () -> { System.out.println("Zzz"); Thread.sleep(1000); })).start();
       // Look, no catch (InterruptedException)!
```
Hint: Define an interface `RunnableEx` whose run method may throw any exceptions. Then implement `public static 
Runnable uncheck(RunnableEx runner)`. Use a lambda expression inside the `uncheck` function.

Why can't you just use `Callable<Void>` instead of `RunnableEx`?

## Task 7
Write a static method `andThen` that takes as parameters two `Runnable` instances and returns a `Runnable` that runs 
the first, then the second. In the `main` method, pass two lambda expressions into a call to `andThen`, and run the 
returned instance.

## Task 8
What happens when a lambda expression captures values in an enhanced for loop such as this one?
```
String[] names = { "Peter", "Paul", "Mary" };
List<Runnable> runners = new ArrayList<>();
for (String name : names)
    runners.add(() -> System.out.println(name));
```
Is it legal? Does each lambda expression capture a different value or do they all get the last value? What happens if 
you use a traditional loop `for (int i = 0; i < names.length; i++)`?

## Task 9
Form a subclass `Collection2` from `Collection` and add a default method `void forEachIf(Consumer<T> action, 
Predicate<T> filter)` that applies `action` to each element for which `filter` returns `true`. How could you use it?

## Task 10
Go through the methods of the `Collections` class. If you were king for a day, into which interface would you place 
each method? Would it be a default method or a static method?

## Task 11
Suppose you have a class that implements two interfaces `I` and `J`, each of which has a method `void f()`. Exactly, 
what happens if `f` is an abstract, default, or static method of `I` and an abstract, default or static method of `J`? 
Repeat where a class extends a superclass `S` and implements an interface `I`, each of which has a method `void f()`.

## Task 12
In the past, you were told that it's bad form to add methods to an interface because it would break existing code. Now 
you are told that it's okay to add new methods, provided you also supply a default implementation. How safe is that? 
Describe a scenario where the new `stream` method of the `Collection` interface causes legacy code to fail compilation. 
What about binary compatibility? Will legacy code from a JAR file still run?