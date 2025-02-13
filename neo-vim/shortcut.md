# NeoVim Commands Reference

## Basic Commands

| Command   | Description                     |
|-----------|---------------------------------|
| `:q`      | Quit NeoVim                     |
| `:q!`     | Quit without saving             |
| `:w`      | Save file                       |
| `:wq` or `:x` | Save and quit              |
| `:e <filename>` | Open a file              |
| `:saveas <filename>` | Save file as a new name |
| `:noh`    | Remove search highlighting      |

## Navigation

| Command      | Description                         |
|-------------|-------------------------------------|
| `h`        | Move left                           |
| `j`        | Move down                           |
| `k`        | Move up                             |
| `l`        | Move right                          |
| `gg`       | Go to the beginning of the file    |
| `G`        | Go to the end of the file          |
| `0`        | Go to the beginning of the line    |
| `^`        | Go to the first non-whitespace character |
| `$`        | Go to the end of the line          |
| `Ctrl + d` | Scroll down half a page            |
| `Ctrl + u` | Scroll up half a page              |
| `Ctrl + f` | Scroll down one full page          |
| `Ctrl + b` | Scroll up one full page            |

## Editing

| Command   | Description                           |
|-----------|---------------------------------------|
| `i`       | Insert mode                          |
| `a`       | Append after cursor                  |
| `A`       | Append at end of line                |
| `o`       | Open a new line below                |
| `O`       | Open a new line above                |
| `x`       | Delete character under the cursor    |
| `r<char>` | Replace character under the cursor   |
| `J`       | Join the current line with the next  |
| `u`       | Undo last change                     |
| `Ctrl + r` | Redo last change                    |

## Copy, Cut, and Paste

| Command   | Description                           |
|-----------|---------------------------------------|
| `yy`      | Copy (yank) current line             |
| `y<number>y` | Copy multiple lines              |
| `yw`      | Copy (yank) a word                   |
| `y$`      | Copy to the end of the line          |
| `p`       | Paste after the cursor               |
| `P`       | Paste before the cursor              |
| `dd`      | Delete (cut) current line            |
| `d<number>d` | Delete multiple lines            |
| `dw`      | Delete a word                        |
| `d$`      | Delete to the end of the line        |
| `D`       | Delete the rest of the line          |

## Find & Replace

| Command   | Description                                     |
|-----------|-------------------------------------------------|
| `/word`   | Search forward for "word"                     |
| `?word`   | Search backward for "word"                    |
| `n`       | Repeat last search forward                    |
| `N`       | Repeat last search backward                   |
| `:%s/old/new/g` | Replace all occurrences of "old" with "new" |
| `:s/old/new/g` | Replace all occurrences in the current line |
| `:%s/old/new/gc` | Replace all occurrences with confirmation |

## Visual Mode

| Command     | Description                     |
|------------|---------------------------------|
| `v`        | Enter visual mode              |
| `V`        | Enter visual line mode         |
| `Ctrl + v` | Enter visual block mode        |
| `y`        | Yank (copy) selected text      |
| `d`        | Delete selected text           |
| `>`        | Indent selected text           |
| `<`        | Unindent selected text         |

## Buffers & Windows

| Command         | Description                         |
|---------------|-------------------------------------|
| `:bn`        | Next buffer                        |
| `:bp`        | Previous buffer                    |
| `:bd`        | Close current buffer               |
| `:ls`        | List open buffers                  |
| `:sp <file>` | Open file in a horizontal split    |
| `:vsp <file>` | Open file in a vertical split     |
| `Ctrl + w + h` | Move to the left window         |
| `Ctrl + w + l` | Move to the right window        |
| `Ctrl + w + j` | Move to the bottom window       |
| `Ctrl + w + k` | Move to the top window          |
| `Ctrl + w + =` | Make splits equal size         |
| `Ctrl + w + q` | Close current window           |

## Tabs

| Command         | Description                  |
|---------------|------------------------------|
| `:tabnew <file>` | Open file in a new tab     |
| `:tabn`       | Next tab                      |
| `:tabp`       | Previous tab                  |
| `:tabclose`   | Close current tab             |

## Macros

| Command       | Description                          |
|-------------|--------------------------------------|
| `q<letter>` | Start recording macro in register `<letter>` |
| `q`         | Stop recording                      |
| `@<letter>` | Play macro from register `<letter>` |
| `@@`        | Replay last macro                   |

## Marks and Jumps

| Command      | Description                        |
|------------|------------------------------------|
| `m<letter>` | Set mark at cursor position      |
| `' <letter>` | Jump to mark                    |
| `` ``       | Jump back to last cursor position |

