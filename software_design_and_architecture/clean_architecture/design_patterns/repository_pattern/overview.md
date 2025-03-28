# Repository Pattern

The Repository Pattern acts as an intermediary between your business logic and the data layer (e.g., database, API). Instead of directly accessing the database (or API) inside your use cases, you delegate all data operations to a repository.

# Domain Layer

1. Match Model

```dart
class Match {
  final String id;
  final String homeTeam;
  final String awayTeam;
  final String score;

  Match({required this.id, required this.homeTeam, required this.awayTeam, required this.score});
}
```

2. Repository Interface (Abstraction)


```dart
abstract class MatchRepository {
  Future<Match?> getMatchById(String matchId);
}
```

3. Use Case: Get Match Detail

```dart
import '../repositories/match_repository.dart';
import '../models/match.dart';

class GetMatchUseCase {
  final MatchRepository repository;

  GetMatchUseCase(this.repository);

  Future<Match?> execute(String matchId) {
    return repository.getMatchById(matchId);
  }
}
```

# Data Layer

This layer interacts with APIs, Databases, or Local Storage.

1. Datasource

```dart
class MatchRemoteDataSource {
  final FirebaseFirestore firestore = FirebaseFirestore.instance;

  Future<Match?> fetchMatchById(String matchId) async {
    var doc = await firestore.collection("matches").doc(matchId).get();
    if (doc.exists) {
      var data = doc.data()!;
      return Match(
        id: matchId,
        homeTeam: data["home_team"],
        awayTeam: data["away_team"],
        score: data["score"],
      );
    }
    return null;
  }
}
```

2. Repository Implementation

```dart
import '../../domain/repositories/match_repository.dart';
import '../../domain/models/match.dart';
import '../datasources/match_remote_data_source.dart';

class MatchRepositoryImpl implements MatchRepository {
  final MatchRemoteDataSource remoteDataSource;

  MatchRepositoryImpl(this.remoteDataSource);

  @override
  Future<Match?> getMatchById(String matchId) {
    return remoteDataSource.fetchMatchById(matchId);
  }
}
```

# Presentation Layer

Inject all the usecases in riverpod to be used by the app










