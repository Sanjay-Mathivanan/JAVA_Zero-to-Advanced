# Software Tools Catalog for Java Development

This guide lists and compares the development tools recommended for writing, compiling, debugging, and running Java programs across different operating systems.

---

## Platform-Specific Software Stacks

Choosing tools native to your hardware setup prevents emulation overhead and ensures a smooth development experience.

### Windows Setup
| Tool Category | Recommended Option | Description |
| :--- | :--- | :--- |
| **JDK Distribution** | Oracle JDK or Eclipse Temurin (LTS 17/21) | Core platform runtime and development compiler tools. |
| **Primary IDE** | IntelliJ IDEA (Community/Ultimate) or VS Code | High-performance environments with built-in Java toolchains. |
| **Command Terminal** | PowerShell / Windows Terminal | Standard CLI environments for compiling and running programs. |
| **Version Control** | Git for Windows (includes Git Bash) | Distributed version control CLI and emulation tools. |

---

### macOS (Intel-based Macs)
| Tool Category | Recommended Option | Description |
| :--- | :--- | :--- |
| **JDK Distribution** | Eclipse Temurin (LTS 17/21) via Homebrew | Installed natively or manually through macOS installer. |
| **Primary IDE** | IntelliJ IDEA or VS Code | Smooth performance with excellent workspace integration. |
| **Command Terminal** | Terminal / iTerm2 (using `zsh`) | Default shell terminal for interacting with the compiler and JVM. |
| **Package Manager** | Homebrew | Package manager for macOS; simplifies tool maintenance. |

---

### macOS (Apple Silicon M1/M2/M3 Macs)
| Tool Category | Recommended Option | Description |
| :--- | :--- | :--- |
| **JDK Distribution** | Eclipse Temurin or Azul Zulu (ARM64 Native) | Specifically built for Apple Silicon to avoid Rosetta translation layers. |
| **Primary IDE** | IntelliJ IDEA (Apple Silicon Edition) | Extremely fast startup and compilation speeds running natively. |
| **Command Terminal** | Native Terminal (ARM64 native `zsh`) | Standard shell environment running natively on Apple Silicon. |
| **Compatibility Layer** | Rosetta 2 (Optional) | Kept only for older, legacy command-line tools if strictly required. |

---

## Common Tools (Cross-Platform)

These tools are essential for all developers, regardless of the operating system:

* **Git and GitHub**: Used for source code versioning, branch management, and repository backups.
* **Debugger Tools**: Built-in IDE debuggers let you pause program execution, inspect the stack frame, and watch variables live.
* **SDKMAN!**: A convenient CLI tool for managing parallel versions of multiple Software Development Kits (including Java JDK) on Unix-based systems.

---

## Pro-Tip: Choosing between IntelliJ IDEA and VS Code

> [!TIP]
> * **Choose IntelliJ IDEA** if you want the industry-standard Java experience. It understands Java code deeper than any other IDE, offers superior refactoring tools, and has the best out-of-the-box support for Maven/Gradle build systems.
> * **Choose VS Code** if you prefer a lightweight editor, work on polyglot codebases (e.g., Java + Python + Frontend), or have limited system RAM. Remember to install the "Extension Pack for Java" by Microsoft.

---

**Back to Module Home:** [01_SETUP README](README.md)
