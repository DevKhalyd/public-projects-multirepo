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

# Factory Pattern

# Observer Pattern

# Dependency Injection

