# Overview

A file that contains the most used commands to edit files.

See the OVERVIEW.md file for more explained information.

# Modes

**Normal Mode:** (a.k.a Command Mode): here is where you can do things like copy, paste, find, or replace, and execute commands like (:w to save,or :q to quit).

**Visual Mode:** here is where you can select text.

**Insert Mode:** here is where you can edit your text.

## Insert Mode -> Editing a file

| Command | Description                                      |
|---------|--------------------------------------------------|
| `i`     | Enter insert mode.                               |
| `I`     | Enter insert mode at the beginning of the line. |
| `a`     | Append after the cursor.                         |
| `A`     | Append at the end of the line.                   |
| `o`     | Open a new line below the current line and enter insert mode. |
| `O`     | Open a new line above the current line and enter insert mode. |
| `Esc`   | Exit insert mode.                                |

## Normal mode or Command mode -> Copy, Paste, Save, Working in vim enviroment

| Command   | Description                                      |
|-----------|--------------------------------------------------|
| `:`       | Enter command-line mode.                         |
| `w`       | Save the current file.                           |
| `q`       | Quit Vim.                                       |
| `wq`      | Save and quit Vim.                              |
| `q!`      | Quit without saving changes.                    |
| `x`       | Save and quit (equivalent to `wq`).             |
| `e filename` | Open a file named `filename`.                  |
| `r filename` | Read the contents of `filename` into the current buffer. |
| `u`       | Undo the last action.                           |
| `Ctrl + r` | Redo the last undone action.                    |
| `/pattern`| Search forward for `pattern`.                   |
| `?pattern`| Search backward for `pattern`.                   |
| `n`       | Repeat the last search in the same direction.   |
| `N`       | Repeat the last search in the opposite direction.|


## Visual mode -> Select words, lines, blocks

| Command        | Description                                      |
|----------------|--------------------------------------------------|
| `v`            | Enter visual mode (character-wise selection).   |
| `V`            | Enter visual line mode (select whole lines).    |
| `Ctrl + v`     | Enter visual block mode (select rectangular blocks). |
| `Esc`          | Exit visual mode.                                |
| `y`            | Yank (copy) the selected text.                  |
| `d`            | Delete the selected text.                        |
| `c`            | Change (delete and enter insert mode) the selected text. |
| `p`            | Paste the yanked or deleted text after the cursor. |
| `P`            | Paste the yanked or deleted text before the cursor. |
| `>`            | Indent the selected text.                        |
| `<`            | Unindent the selected text.                      |
| `g~`           | Toggle case of the selected text.                |

<!--# Navigating inside a file
     # Navigating through a project-->