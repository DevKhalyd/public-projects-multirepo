# Shortcuts


TODO: Create md table after complete all shortcurs for vim


**Screen Movemnts**

Ctrl + d = Scroll down half a screen
Ctrl + u = Scroll up half a screen
zz = Center the current line in the screen

**Jump Movements**


gg -> Jump to the beginning of the file
G -> Jump to the end of the file
:n -> Jump to the line **n** (e.g., :10 goes to line 10)
% -> Jump between matching parentheses, brackets, etc. (Example{$1})


**Movement**

h -> Move left
l -> Move right
j -> Move down
k -> Move up
w -> Move to the next word excluding the first character   
e -> Move to the final if the current word including the last character
b -> Jump to the start of the previous word
ge -> Jump to the end of the previous word
0 -> Jump to the beginning of the line
$ -> Jump to the end of the line
{ -> Jump to the beginning of the paragraph
} -> Jump to the end of the paragraph

W,E,B,gE -> Helps to navigate through whitespace-separated words

Word-Separate-Words-how-it-works?

Note: Take in consideration that when capittal letter is enabled, the behavior changes.

**Search Movements**

/text ->  Search forward for text
?text -> Search backward for text

**Files manipulation**

u -> undo
U -> undo a whole line (Restore the original state)
ctrl + r -> redo
x -> Delete the character after the cursor
a -> Insert mode and add characters
:wq -> Write and Quit the current file
:q! -> Delete all changes
vim name.file -> open the file with vim


**Edition**

dd -> Delete a whole line and store in the default register
dw -> Delete the word after cursor, until the beginning of the next word, excluding the fist character.
d$ -> Delete the whole line after the cursor
de -> Delete the word after the cursor, unti the final of the word, including the last character.
"+p -> Paste from the clipboard
p -> past from the default register
r$anyCharacter -> Remplaze with the given character


**Movement Counter**

$number with w -> onward two words  Eg. 2w
$number with e -> onward n words Eg. e

**Delete Counter**

d2w -> Delete two words

Note: All actions can use counters to do n times the same action

Continue with vimtutor 3.3

