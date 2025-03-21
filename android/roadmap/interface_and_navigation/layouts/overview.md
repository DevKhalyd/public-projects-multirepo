# Overview

It is the style of paiting elements in the screen.

# Frame Layout

FrameLayout is a simple ViewGroup subclass in Android that is designed to hold a single child view or a stack of overlapping child views. It positions each child in the top-left corner by default and allows them to overlap on top of each other, which makes it useful for situations where you need to layer views on top of one another.

# LinearLayout

LinearLayout is a view group that aligns all children in a single direction, vertically or horizontally. You can specify the layout direction with the android:orientation attribute.

LinearLayout was commonly used in earlier Android development, but with the introduction of ConstraintLayout, it’s less frequently used in modern apps.

# RelativeLayout

A RelativeLayout in Android is a type of ViewGroup that allows you to position child views relative to each other or relative to the parent layout. It’s a flexible layout where you can arrange the child views in relation to one another based on certain rules, making it suitable for creating complex UI designs.

RelativeLayout was commonly used in earlier Android development, but with the introduction of ConstraintLayout, it’s less frequently used in modern apps.

# ConstraintLayout

Lets you create large, complex layouts with a flat view hierarchy—no nested view groups. It’s similar to RelativeLayout in that all views are laid out according to relationships between sibling views and the parent layout, but it’s more flexible than RelativeLayout and easier to use. Its available on xml and jetpack compose.

# RecyclerView

RecyclerView is the most commonly used and powerful list management tool in Android development. Witch makes it easy to efficiently display large sets of data. You supply the data and define how each item looks, and the RecyclerView library dynamically creates the elements when they’re needed.

As the name implies, RecyclerView recycles those individual elements. When an item scrolls off the screen, RecyclerView doesn’t destroy its view. Instead, RecyclerView reuses the view for new items that have scrolled onscreen. RecyclerView improves performance and your app’s responsiveness, and it reduces power consumption.

