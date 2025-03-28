# Streams

Streams are an essential part of asynchronous programming in Dart and Flutter. They allow your app to handle continuous, real-time data like user inputs, WebSocket messages, or network responses in a structured and efficient way.

## Stream

Streams are an essential part of asynchronous programming in Dart and Flutter. They allow your app to handle continuous, real-time data like user inputs, WebSocket messages, or network responses in a structured and efficient way.

```dart
Stream<int> numberStream = Stream<int>.periodic(Duration(seconds: 1), (count) => count);
```

## StreamController

StreamController is responsible for creating a stream and adding data to it. You can think of it like a "producer" of data. The StreamController is where the data is sent from (e.g., the backend server or another part of your application).

```dart
final controller = StreamController<int>();
controller.add(1); // Add data to the stream
controller.add(2);

// Listen to the stream
controller.stream.listen((data) {
  print('Received: $data');
});

controller.close(); // Close the stream when done
```

## StreamSubscription

To handle data from a stream, you must subscribe to it. This subscription allows you to listen for the events as they are emitted and take action in response. You can cancel the subscription at any time to stop listening.

```dart
numberStream.listen((data) {
  print('Received: $data');
});
```

## Stream Transformers


You can manipulate data coming through a stream using StreamTransformer. This is useful when you need to modify the data before it is processed by the listener.


```dart
Stream<int> numberStream = Stream<int>.periodic(Duration(seconds: 1), (count) => count);
var transformedStream = numberStream.transform(
  StreamTransformer.fromHandlers(handleData: (data, sink) {
    sink.add(data * 2); // Double the data before sending it downstream
  }),
);
transformedStream.listen((data) {
  print('Transformed: $data');
});
```


## StreamBuilder

The StreamBuilder widget in Flutter is used to listen to streams and update the UI as data is received. For other cases, you might use methods like listen() or await for in Dart to listen to the stream data and take action.

```dart
StreamBuilder<int>(
  stream: numberStream,
  builder: (context, snapshot) {
    if (snapshot.connectionState == ConnectionState.waiting) {
      return CircularProgressIndicator();
    } else if (snapshot.hasError) {
      return Text('Error: ${snapshot.error}');
    } else if (snapshot.hasData) {
      return Text('Received: ${snapshot.data}');
    } else {
      return Text('No data');
    }
  },
);
```

# Types of stream

Single-Subscription Stream:

A stream that can only be listened to by a single listener at a time. The listener receives data from the stream in the order it was emitted. Once the stream is closed, it cannot be listened to again.

```dart
void main() async {
  Stream<int> singleStream = Stream<int>.periodic(Duration(seconds: 1), (count) => count).take(5);

  // First listener (this will work)
  singleStream.listen((data) {
    print('Listener 1 received: $data');
  });

  // Second listener (this will cause an error)
  await Future.delayed(Duration(seconds: 2));
  singleStream.listen((data) {
    print('Listener 2 received: $data');
  });
}
```

Broadcast Stream:

A stream that can have multiple listeners. Once data is emitted, all listeners are notified. Broadcast streams are useful when you want multiple parts of your app to react to the same event or data.

```dart
void main() async {
  StreamController<int> controller = StreamController<int>.broadcast();

  // First listener
  controller.stream.listen((data) {
    print('Listener 1 received: $data');
  });

  // Second listener (it will work fine)
  controller.stream.listen((data) {
    print('Listener 2 received: $data');
  });

  // Adding data to the stream
  for (int i = 0; i < 5; i++) {
    await Future.delayed(Duration(seconds: 1));
    controller.add(i);
  }

  // Close the stream when done
  await Future.delayed(Duration(seconds: 1));
  controller.close();
}
```

# Sink StreamController property

The sink property in a StreamController is used to add data into a stream. It acts as the input of the stream, while the stream itself acts as the output.

```dart
void main() {
  // Create a StreamController
  StreamController<String> controller = StreamController<String>();

  // Listen to the stream
  controller.stream.listen((data) {
    print('Listener received: $data');
  });

  // Add data using sink
  controller.sink.add('Hello');
  controller.sink.add('World');

  // Close the stream when done
  controller.close();
}
```