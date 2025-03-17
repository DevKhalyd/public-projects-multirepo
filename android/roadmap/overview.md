# Android Overview

“The Fundamentals” of Android primarily concentrate on 5 components; Activities, Services, Broadcast Receivers, Content Providers, and Intents. Activities are essentially what you see on your screen; each screen in an app is a separate activity. Services run in the background to perform long-running operations or to perform work for remote processes. They do not provide a user interface. Broadcast Receivers respond to broadcast messages from other applications or from the system itself. These messages are often in the form of Intents. Content Providers manage a shared set of app data that other apps can query or modify, through a structured interface. Finally, Intents are messaging objects which facilitate the communication between the aforementioned components.

# Kotlin

Kotlin is a concise, multi-platform, and fun language developed by JetBrains. Learn how to use Kotlin for Android, server-side, and cross-platform development, and explore its features, news, and community. Kotlin is a statically-typed programming language that runs on the Java Virtual Machine (JVM) and can be used to develop all types of Android apps. It is Google’s preferred language for Android app development.

Ref: https://kotlinlang.org/docs/getting-started.html

# What is and how to use Gradle?

Gradle is a powerful build system used in Android development that allows you to define your project and dependencies, and distinguish between different build types and flavors. Gradle uses a domain-specific language (DSL) which gives developers almost complete control over the build process. When you trigger a build in Android Studio, Gradle is the tool working behind the scenes to compile and package your app. It looks at the dependencies you declared in your build.gradle files and create a build script accordingly. Using Gradle in Android development requires continuous editing of the build.gradle files to manage app dependencies, build variants, signing configurations, and other essential aspects related to building your app.