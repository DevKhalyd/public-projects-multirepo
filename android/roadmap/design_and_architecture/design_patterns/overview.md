# Design Patterns

Design patterns are proven solutions to common software design problems. They focus on specific coding structures and object interactions, making systems more reusable, maintainable, and scalable. Unlike architectural patterns, which define the system's overall structure, design patterns solve localized issues within that architecture.

# Repository Pattern

The Repository Pattern separates the data sources from the rest of the application. It acts as a mediator between different data sources, such as persistent models, web services, or caches. Instead of having the network and database calls spread out throughout your ViewModel, they are encapsulated within a Repository class. This separation will make the code clean, easy to read and testable. It provides a simple API for data access, the rest of the app doesn’t need to know where the data is coming from it just asks the repository.

In Android, the Repository Pattern is commonly used with ViewModel and LiveData (or Flow) to manage data efficiently while keeping the UI layer decoupled from data sources like a database (Room) or a network API (Retrofit).

1. Data Model (Entity)

```kt
// This represents a football match stored in Room Database.

@Entity(tableName = "matches")
data class Match(
    @PrimaryKey val id: Int,
    val teamA: String,
    val teamB: String,
    val score: String
)
```

2. DAO (Data Access Object) – Room Database

Defines how we interact with the database.

```kt
@Dao
interface MatchDao {
    @Query("SELECT * FROM matches")
    fun getAllMatches(): Flow<List<Match>>  // Using Flow for reactivity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMatch(match: Match)
}
```

3. Repository – Handles Data Logic (Database + API)

The repository acts as an abstraction layer between the database and API, ensuring the ViewModel doesn’t directly depend on them.

```kt
class MatchRepository(private val matchDao: MatchDao, private val apiService: ApiService) {

    // Fetch matches from Room database
    fun getMatches(): Flow<List<Match>> = matchDao.getAllMatches()

    // Fetch matches from API and save to database
    suspend fun fetchMatchesFromApi() {
        val matches = apiService.getMatches()  // Retrofit API call
        matchDao.insertMatch(matches)  // Save to Room database
    }
}
```

4. ViewModel – Uses Repository

The ViewModel fetches match data and exposes it to the UI.

```kt
class MatchViewModel(private val repository: MatchRepository) : ViewModel() {

    val matches: LiveData<List<Match>> = repository.getMatches().asLiveData()

    fun refreshMatches() {
        viewModelScope.launch {
            repository.fetchMatchesFromApi()
        }
    }
}
```

# Builder Pattern

The Builder Pattern in Android is used to construct complex objects step by step. It separates the construction of an object from its representation. The pattern involves a Builder class which is used to construct the Product class. The Builder class typically has a method for each part that may be used to construct a Product. It also has a method for returning the final product. The Builder pattern is useful in situations where you might have multiple ways to create an object or when an object requires a large number of parameters for its constructor.

A common example in Android is the AlertDialog.Builder, which allows chaining methods to configure a dialog before calling .create() or .show().

```java
public class User {
    private final String name;
    private final int age;
    private final String email;

    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
    }

    public static class Builder {
        private String name;
        private int age;
        private String email;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
```

Usage example:

```java
User user = new User.Builder()
    .setName("John Doe")
    .setAge(30)
    .setEmail("john@example.com")
    .build();
```

# Factory Pattern

The Factory Pattern is part of the Creational Design Patterns. This pattern provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created. It introduces an abstraction layer between the client code and the concrete objects. Normally, this is achieved by using a factory method to create objects instead of using constructors. The instance of the class is usually created by a method, referred to as a factory method, which is either specified in an interface and implemented in implementing classes or implemented in a base class which may be optionally overridden by derived classes. The Factory Method is used when we want to provide users with a way to create an instance of a class from one of several possible classes that share a common super class.

```java
public abstract class Animal {
    public abstract String makeSound();
}

public class Dog extends Animal {
    @override
    public String makeSound() {
        return "Woof";
    }
}

public class Cat extends Animal {
    @override
    public String makeSound() {
        return "Meow";
    }
}

public class AnimalFactory {
    public Animal createAnimal(String type) {
        if ("Dog".equals(type)) {
            return new Dog();
        } else if ("Cat".equals(type)) {
            return new Cat();
        }
        return null;
    }
}
```

# Observer Pattern

The Observer Pattern is a software design pattern in which an object, known as the subject, maintains a list of its dependents, called observers, and notifies them automatically of any state changes. This is usually done by calling one of their methods. It’s mainly used for implementing distributed event handling systems and is viewed as a good practice to follow, making your design more robust, flexible, and scalable. The subject to be observed triggers events and observers react to the change or the event that they are listening to. In Android, observable libraries like LiveData, RxJava, Flow, and other reactive streams allow the implementation of observer pattern.

## Flow

Flow in Android development is part of the Kotlin Coroutines library. It is a type that can emit multiple values sequentially, making it perfect for working with any data streams or any streams of events that aren’t instantaneous. Like Observables, Flow is also based on the observer pattern, meaning it can emit values and these emissions can be observed and reacted to. However, Flow comes with built-in back pressure handling and the ability to transform, filter, or combine these flows in a sequence. Along with Coroutines, Flow encourages a more predictable and simplified concurrency design without callback hell problem.

## RxKoltin

RxKotlin is a lightweight library that adds convenient extension functions to RxJava. It allows developers to use RxJava with Kotlin in a more idiomatic way, thus making code more readable and understandable. While RxJava is a Java-based implementation of Reactive Extensions, RxKotlin is essentially a wrapper that includes extension functions and other constructs to take full advantage of Kotlin’s features, such as its syntactic simplicity and ease of use.

## LiveData

LiveData is a data holder class that can be observed within a given lifecycle. This means that an Observer can be added in a pair with a LifecycleOwner, and this observer will be notified about modifications of the LiveData object only if the associated LifecycleOwner is in active state. LiveData respects the lifecycle state of app components, such as activities, fragments, or services, and it only updates app-component observers that are in an active lifecycle state. Furthermore, LiveData automatically removes the observers when their associated LifecycleOwner moves to the Destroyed state. This combination of LiveData and LifecycleOwner helps you to manage appropriate and efficient updates because LiveData takes into consideration the lifecycle state of your app components.

# Dependency Injection

Dependency Injection is a technique where an object does not need to create its own dependencies; instead, dependencies are provided (or injected) at runtime. This technique is highly beneficial in Android Development. It helps in creating loosely coupled and easily testable code. For example, the Retrofit instance that your application requires to make network calls can be created somewhere else and can be injected whenever required using libraries like Dagger, Koin or Hilt. The ViewModel instances can also be injected rather than being created in the required classes directly. Through dependency injection, plugins ensure the code becomes easier to change, understand, and maintain, hence, improving the quality of the code.

## Dagger

Dagger is a fully static, compile-time dependency injection framework for both Java and Android. It is an adaptation of an earlier version created by Square that’s focused on simplicity and speed. Dagger’s primary focus is on compile-time analysis of dependencies, code simplicity, and clarity. It uses annotations to define dependencies, thus aiding in easy readability and understanding of the code. Dagger also eliminates the use of reflection to inject dependencies, thus boosting performance. It offers custom scopes to control the lifespan of instances and ensures that dependencies are Singleton across the entire lifespan of certain scopes.

## Hilt

Hilt is a dependency injection library for Android that reduces the boilerplate code that you would normally need to write when setting up manual dependency injection in your project. It is based on the Dagger library, but it simplifies the implementation process and streamlines the use of Dagger in Android apps. To set it up, you must annotate your Android classes and Hilt will automatically generate and provide the necessary dependencies for you.

