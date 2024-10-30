# Overview

The first thing that you need to know about vim is: Vim is a modal editor. This means that vim has different modes that can be used to interact with it. If you are asking why, remember that when the original vi editor was created in 1976, there were no graphical interfaces (GUI) or mouse, and even displays were not as powerful as todays.
Now, in order to edit text or navigate around, you need to switch between the different modes.

## Modes

- Normal Mode: (a.k.a Command Mode): here is where you can do things like copy, paste, find, or replace, and execute commands like (:w to save,or :q to quit).

- Visual Mode: here is where you can select text.

- Insert Mode: here is where you can edit your text.

An important tip: look at the bottom left of vim’s screen and you’ll see which mode is currently in use. You can see INSERT or VISUAL for the respective modes, or when you don’t see anything it means you are in NORMAL/COMMAND mode.

Reference: https://vimschool.netlify.app/basics/vimmodes/

# Explaning in detail

## Normal mode aka Command mode

To switch to this mode, type the ESC key. This mode is where you navigate around the file and you can execute commands such as dd to remove the line under the cursor, for example.

You can also perform tasks such as copy, paste, cut, find/replace, etc…

To access this mode, you need to be in Normal Mode, then type the : key.
This mode is where you will execute commands such as updating vim configurations, saving, quitting, opening new files, tabs, buffers, etc…

Ref: Vim Modes :: Vimschool

## Insert Mode

Insert Mode is where you can write/edit your documents. From Normal/Command mode.

## Visual Mode

Visual Mode is where you can select words, lines, blocks, etc…