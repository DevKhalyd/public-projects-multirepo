# Activity

Activity in Android is a crucial component that represents a single screen with a user interface. It is just like a window in a desktop application. Android apps are typically made up of one or more activities, each having its interface which allows user interaction. When an app is launched, an instance of Activity is created, starting the lifecycle of that app. Every activity has its own lifecycle (create, start, resume, pause, stop, destroy) that keeps the state of a user’s progress, and Android manages these states automatically. Activities can also have Intent, which allows them to interact with other components, such as starting another activity or getting a result from that activity.

# Activity Lifecycle

The Activity Lifecycle in Android represents a series of states or events that an activity can go through from its creation to its destruction. The primary states or events are onCreate(), onStart(), onResume(), onPause(), onStop(), onDestroy(), and onRestart(). The method onCreate() is called when the activity is first created, followed by onStart() when the activity becomes visible to the user. The onResume() method executes when the user starts interacting with the application. onPause() and onStop() methods are invoked when the application is no longer in the foreground or visible to the user. The onDestroy() method is used when the activity is being completely removed from the memory. The onRestart() method is called after the system stops the activity and is about to start it again. The proper handling of these states ensures the efficient use of resources and a smooth user experience.

# State Changes

“Activity” is a crucial component that represents a single screen with a user interface. One or more active activities make up an Application. These activities can go through different states in their lifecycle, often due to user interaction or system interruption. The primary states of an Activity include Created, Started, Resumed, Paused, Stopped, Restarted, and Destroyed. The “Created” state occurs when an activity instance is being created. The “Started” state is when the activity is visible to the user, while “Resumed” is when the activity is interacting with the user. An activity is “Paused” when it loses focus but is partly visible, “Stopped” when it’s not visible, “Restarted” when the activity is about to be started, and “Destroyed” when the activity is finished or the system is temporarily destroying it.

# Tasks and Backstack

The tasks backstack in Android refers to the way Android manages and arranges tasks in a stack-like structure. Every task has a stack of activities, which is referred to as the task’s back stack. The activities are placed in the order they are opened. When a new activity is started, it is placed at the top of the stack and becomes the running activity, while the previous activity is paused and put into the back stack. When you press the back button, the current activity is destroyed and the activity at the top of the back stack becomes active again. Android defines how to navigate between tasks and activities using this back stack concept.

Ref: https://developer.android.com/guide/components/activities/tasks-and-back-stack
