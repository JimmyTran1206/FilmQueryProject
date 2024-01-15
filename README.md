# FilmQueryProject
## Description
A project using Java Database Connection (JDBC) and Object-Relational-Mapping (ORM) to query data from MySQL relational database and map the data into Java objects for film query application. Users are presented a menu with 3 choices
1. Look up a film by its id.
2. Look up a film by a search keyword.
3. Exit the application

When users choose to look up a film by its id, users are prompted to input a film id from 1-1000 and the details of the film including title, release year, rating, language, and casting actors are displays. These details are queried from the film database. At any time, the user can choose to return to main menu.

When users choose to look up films matching their keyword, a prompt to input the keyword and a list of films whose title or description matching the user-input-keyword will be displayed. At any time, the user can choose to return to main menu.

THe program only ends when users choose to quit.   

## Tech used
- MySQL and SQL query 
- Java Database Connection
- Object-Relational-Mapping from MySQL to Java Object

## Lessons Learned
- Open and close connection to database in Java using `Connection` interface.
- Formulating and executing query statement using `PreparedStatement` interface.
- Execute query with _bind variables_ using `executeQuery` method of `PreparedStatement` interface.
- Iterating the query virtual table using `ResultSet` cursor.
- Map database entities into Java classes and map row data to Java objects.