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