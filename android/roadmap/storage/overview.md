# Storage

On Android devices, storage refers to where your data such as apps, photos, videos, and music are saved. It can be categorized into two types: internal and external storage. Internal Storage is where data is stored that’s tied directly to your app. This data is private by default and not accessible by other apps. External Storage, on the other hand, is a shared space where all apps can read and write data. It can be further sub-categorized into Public and Private directories. Public directories are shared among all apps while private directories are specific to your app but can be accessed by other apps if they have the appropriate permissions.

# Shared Preferences

Shared Preferences in Android are used to store data in key-value pairs. It works similar to a tiny database where you can save small pieces of data such as settings or the state of an application. When data is saved to Shared Preferences, it persists across user sessions, even if your application is killed or gets deleted. Data in Shared Preferences is not typically used for large amounts of data. To perform actions such as saving, retrieving, or editing data in Shared Preferences, you use an instance of SharedPreferences.Editor.

# DataStore

DataStore is a new and improved data storage solution by Android, meant to supersede SharedPreferences. It is important to understand that it comes in two different implementations: Preferences DataStore and Proto DataStore. Preferences DataStore uses key-value pairs similar to SharedPreferences, but it’s more robust and handles runtime exceptions more efficiently. On the other hand, Proto DataStore uses custom data types to provide type safety. It lets you leverage the power of Protocol Buffers, a language-neutral, platform-neutral mechanism for serializing structured data, as the data storage format. Operating on data in DataStore is transactional, meaning that if an error occurs during an operation, all changes are rolled back, so the data remains in a consistent state.

# Room Database

“Room” is a persistence library introduced by Google that provides an abstraction layer over SQLite to help with robust database access while harnessing the full power of SQLite. Room supports the creation of databases and defines queries in compile-time-checked SQL strings. These databases belong to the data classes that you create representing your app’s data. Room comprises three main components: Database, a container that holds your app’s data tables; Entity, representing a table within the database; and DAO (Data Access Object), containing SQL query methods to interact with the database.

# File System

The Android operating system uses a specific File System structure to store and manage files. It’s primarily based on the Linux File system, with some specific Android features. The File System includes several key directories that are used for specific purposes. For instance, directories such as /system hold system apps and firmware, while /data contains user data, settings and installed applications, and /sdcard usually represents an internal or external SD card for additional storage. It’s worth mentioning directories like /proc, /dev, and /sys which are virtual file systems and house important system files. As an Android developer, understanding these directories can help you interact with Android’s file system more effectively. Note that access to some of these directories may be restricted depending on system permissions.

