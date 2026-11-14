---
name: study-from-link
description: Turns a source link (docs page, article, tutorial) into a single study file with every example, explanations and expected outputs. Code topics become a runnable file in the topic's language; theory and architecture topics become a Markdown study file. Use when the user pastes a learning link and asks for study notes or a study file.
disable-model-invocation: true
---

# Study File From Link

Turn one source link into one study file the user can read top to bottom and, for code topics, run.

## Workflow

1. **Fetch** the URL with WebFetch. If it fails (login wall, 404, binary content), ask the user to paste the content.
2. **Scope**: if the URL has a section anchor (for example `#comparing-coroutines-and-jvm-threads`), use AskQuestion: whole page or only that section. Otherwise cover the whole page.
3. **Classify**:
   - Page has code examples: write a **code study file** in that language.
   - Page is theory, architecture, design or concepts without runnable code: write a **Markdown study file**.
   - Unclear (for example pseudocode, or examples in several languages): ask.
4. **Choose the path**: `<language-or-area>/<topic>/<FileName>` from the repo root.
   - List the existing top-level folders first and reuse a matching one (for example `kotlin/`).
   - Area folders for non-code topics: `architecture/`, `theory/`, `design-patterns/`, and so on.
   - File names follow the language convention: PascalCase for Kotlin, Java, C# (`CoroutinesBasics.kt`), snake_case for Python, Rust, Go (`asyncio_basics.py`), kebab-case for JavaScript, TypeScript and Markdown (`event-driven-basics.md`).
   - If the file already exists, ask before overwriting.
5. **Write the file** using the matching skeleton in [templates.md](templates.md) and the rules below.
6. **Verify**:
   - Recompute every expected output by hand (sums, string results, ordering). Never guess.
   - If the toolchain is installed (`kotlinc`, `python`, `node`, `go`, ...), compile or run the file and fix any mismatch. If not, say so in the summary.
   - Check for lint errors with ReadLints.
7. **Summarize** for the user in a few sentences: the file path, what it covers, any renames or additions to the doc's code, anything disabled by default, and the setup needed to run it.

Only ask questions when blocked (scope anchor, ambiguous language, page covering several unrelated topics, existing file). Otherwise use the defaults above.

## Rules for code study files

- **Header comment**: title, source URL, setup (dependencies with the exact versions from the page, given as build-file snippets), optional run flags (for example JVM options), and a note that the expected output is at the end of each example function and that concurrent or thread-dependent output can vary.
- **Do not create build files** (Gradle, package.json, pyproject). The header explains setup only.
- **One function per doc example**, named `exampleNN<Topic>` (or `example_nn_<topic>` in snake_case languages), numbered in page order. Group them under section divider comments that match the page headings.
- **Concept doc comment** above each example function: one to three lines on what it shows. No expected output here.
- **Expected output at the end of each example function body**, as a comment:
  ```
  // Expected output (order and worker numbers vary between runs):
  // line 1
  // line 2    (after ~1 s)
  ```
  Add timing notes like `(after ~1 s)` and say when the order or thread names vary.
- **No expected output for examples that fail to compile, crash, hang or run out of memory.** Put a `WARNING:` in their doc comment instead.
- **Guard dangerous or very heavy examples** with a constant that defaults to off (for example `const val RUN_THREAD_DEMO = false`) and check it in the entry point.
- **Keep the doc's code as written**, including its comments. Allowed changes:
  - Rename a name that clashes with another example (for example two `greet()` functions become `greetSimple()` and `greetOnThread()`).
  - Turn the doc's `main` into the example function body.
  - Add a line so a result becomes visible (for example a `println`).
  Mention every change in the summary.
- **Code that intentionally does not compile** stays in a block comment, labelled with why it fails.
- **Single entry point** (`main`, `if __name__ == "__main__":`, or a top-level call) runs every example in order and prints `=== N. Title ===` before each.
- **Key takeaways** block comment at the end of the file: five to eight bullets.

## Rules for Markdown study files

- Title, `Source:` link, and a two to three sentence summary.
- One `##` section per page section, in page order:
  - A plain explanation in your own words.
  - The original examples or snippets, in fenced blocks with a language tag.
  - A mermaid diagram wherever there is a flow, hierarchy, lifecycle or relationship.
- `## Key takeaways`: five to eight bullets.
- `## Self-check questions`: five to ten questions, each with its answer hidden in a `<details>` block.

Mermaid rules: no spaces in node IDs, quote labels containing special characters, no reserved words (`end`, `graph`) as IDs, no styling.

## Examples

**Code topic**

Input: `/study-from-link https://kotlinlang.org/docs/coroutines-basics.html`

Output: `kotlin/coroutines/CoroutinesBasics.kt`. It has a header with the `kotlinx-coroutines-core` dependency, examples `example01SuspendingFunctions()` through `example11ManyThreads()`, an expected output comment at the end of examples 1 to 10, example 11 (50,000 threads) guarded by `RUN_THREAD_DEMO = false` with a warning and no expected output, a `suspend fun main()` that runs them all, and key takeaways.

**Non-code topic**

Input: `/study-from-link https://martinfowler.com/articles/201701-event-driven.html`

Output: `architecture/event-driven/event-driven-basics.md`. It has one section per pattern (event notification, event-carried state transfer, event sourcing, CQRS), each with an explanation and a mermaid sequence or flow diagram, followed by key takeaways and self-check questions.
