# SEProject
# Architectural Design
The whole system is based on the MVC (Model-View-Controller) architectural design pattern that allows us to separate the business logic (Controller), data management (Model) and how the data are presented to the user (View).
We have chosen this pattern because it uses an Object-Oriented approach which is very suitable for our context, the representation of our data as models. 

# Architectural Decisions

## Singleton Design Pattern

The application will implement a GUI(Graphical User Interface) so the user will trigger events interacting with it. The events will be captured by the MVC controller that will use an unique instance of the class DrawingEditor to perform the related actions. 
Moreover this pattern is used also for:
- ZoomPane: a class used for the zoom operations.
- Clonator: a class used for the copy, cut and paste operations.
- SelectedShape:a class used for keeping the reference to the selected shape.

## State Design Pattern
Given that the user can perform several operations on different shapes, it has been decided to use the State Design Pattern so that the actions triggered by the user aren't directly dependent from the DrawingEditor object but from its state.

## Command Design Pattern
All the operations that change the drawing must be undoable. This means that there is an operation which works on other operations. In order to implement this behavior it has been decided to use the Command Design Pattern. In this way, operations will be transformed into objects(Commands) and the undo operation could work on them.

