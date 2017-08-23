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