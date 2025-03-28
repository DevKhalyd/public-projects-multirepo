# Mixin

In Flutter, mixins are a way to reuse code in multiple classes without using inheritance. They allow you to add functionalities to a class without making it a subclass of another class. This can be useful when you want to add the same functionality to multiple classes that are not related to each other in the class hierarchy

- Code Reusability: Mixins allow you to reuse code across different classes without the constraints of single inheritance.

- Flexibility: You can add specific functionalities to classes as needed without affecting their main inheritance hierarchy.

```dart
mixin MusicPlayer {
  void playMusic(String song) {
    print('Playing $song');
  }

  void stopMusic() {
    print('Music stopped');
  }
}

class Car with MusicPlayer {
  String model;

  Car(this.model);

  void drive() {
    print('Car is driving');
  }
}

class Boat with MusicPlayer {
  String name;

  Boat(this.name);

  void sail() {
    print('Boat is sailing');
  }
}

void main() {
  var myCar = Car('Sedan');
  myCar.drive();
  myCar.playMusic('Highway to Hell');
  myCar.stopMusic();

  var myBoat = Boat('Sailboat');
  myBoat.sail();
  myBoat.playMusic('Calypso');
  myBoat.stopMusic();
}
```