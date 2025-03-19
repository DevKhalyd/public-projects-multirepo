# Intent

Intent in Android is a software mechanism used for late runtime binding between components, such as activities, content providers, and services. It is essentially a passive data structure holding an abstract description of an operation that the Android system is requested to perform.

# Implicit Intents

Implicit Intents do not specify the target component explicitly like Explicit Intents. Instead, they allow the system to find a suitable component matching the Intent description to handle the request. The system will find an activity that can handle this intent by comparing the <intent-filter> section in the AndroidManifest.xml of all apps installed on the device against the Implicit Intent.

# Explicit Intents

Explicit Intents are primarily used within an application’s own boundaries. In explicit intents you specify the component that needs to be responded to the intent. Therefore, the target component must be specified by calling methods such as setComponent(ComponentName), setClass(Context, Class), or setClassName(String, String). This means that explicit intents are typically used for launching activities, broadcasting messages, starting services within the app. Explicit intents are not resolved by the system but are passed to the component identified in the intent.

# Intent Filters

Intent Filters in Android are essential components of the Android system where you can declare the capabilities of your activities, services, and broadcast receivers. An intent filter is an expression found in your app’s manifest file, defined in the <intent-filter> XML element. Android uses these filters to determine the appropriate components for incoming intents, which can be either explicit or implicit. Your app’s ability to respond to intents depends on the filters you define. The filters are set of conditions comprised of action, category, and data which your activity or service is able to perform. If the incoming Intent matches with defined Intent Filters, Android system will permit that Intent to your Component (Activity, Service, or Broadcast Receiver).

