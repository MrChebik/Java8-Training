# Task 8
What happens when a lambda expression captures values in an enhanced for loop such as this one?
```
String[] names = { "Peter", "Paul", "Mary" };
List<Runnable> runners = new ArrayList<>();
for (String name : names)
    runners.add(() -> System.out.println(name));
```
Is it legal? Does each lambda expression capture a different value or do they all get the last value? What happens if 
you use a traditional loop `for (int i = 0; i < names.length; i++)`?