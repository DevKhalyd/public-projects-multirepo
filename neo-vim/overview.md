# Overview

Vim is a powerful text editor with a big community that is constantly growing. Even though the editor is about two decades old, people still extend and want to improve it, mostly using Vimscript or one of the supported scripting languages.

## Motivation

Over its more than 20 years of life, Vim has accumulated about 300k lines of scary C89 code that very few people understand or have the guts to mess with.

Another issue is that as the only person responsible for maintaining Vim's big codebase, Bram Moolenaar, has to be extra careful before accepting patches, because, once merged, the new code will be his responsibility.

These problems make it very difficult to have new features and bug fixes merged into the core. Vim just can't keep up with the development speed of its plugin ecosystem.

## Extensible

API is first-class: discoverable, versioned, documented.
MessagePack structured communication enables extensions in any language.
Remote plugins run as co-processes, safely and asynchronously.
GUIs, IDEs, web browsers can --embed Neovim as an editor or script host.
Lua plugins are easy to create just like Vimscript plugins. Your config can live in init.lua!
AST-producing parsing engine enables faster, more accurate syntax highlighting, code navigation, refactoring, text objects, and motions.

## Usable

Strong defaults including a unique, minimalist colorscheme.
Builtin LSP client for semantic code inspection and refactoring (go-to definition, "find references", format, …).
Client-server architecture allows you to detach the UI and keep the editor session running (like tmux). Attach multiple UIs to any Nvim session.
Works the same everywhere: one build-type, one command.
Modern terminal features such as cursor styling, focus events, bracketed paste.
Builtin :terminal set the standard for "TTY as a basic component".

GitHub: https://github.com/neovim/neovim?tab=readme-ov-file

Website: https://neovim.io/

# Next steps

- Try using nvim in the normal files and cmd when making this research

1. Invesigate how to use the plugins or what are the recommended