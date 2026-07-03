# Java Development Setup Guide for macOS (Intel-Based)

This guide provides a comprehensive walkthrough to install and configure the Java development environment on Intel-based macOS systems.

> [!NOTE]
> If you are using a modern Mac with Apple Silicon (M1/M2/M3 chips), please refer to the optimized [Apple Silicon Java Setup Guide](file:///d:/New%20folder/PROJECTS/JAVA_Zero-to-Advanced/01_SETUP/apple-silicon-java-setup.md) for native ARM64 setup instructions.

---

## Installation Checklist
- [ ] Install Homebrew Package Manager
- [ ] Download and Install Java JDK (LTS 17 or 21)
- [ ] Set `JAVA_HOME` in Zsh configuration (`.zshrc`)
- [ ] Verify JDK Installation via Terminal
- [ ] Install IDE (IntelliJ IDEA / VS Code)
- [ ] Install Git Version Control
- [ ] Write, compile, and run your first Java test program

---

## Step 1: Install Homebrew (Recommended)

Homebrew is the standard package manager for macOS, making it simple to install and update software.

1. Open your Terminal (found in `/Applications/Utilities/` or via Spotlight).
2. Run the following installation command:

```bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```

3. Once installed, verify that Homebrew is working:

```bash
brew -v
```

---

## Step 2: Install Java JDK

### Option A: Installing via Homebrew (Recommended)
This installs the latest open-source JDK distribution and links it directly to macOS System frameworks.

```bash
brew install openjdk
```

After installation finishes, create a symbolic link so the macOS system Java wrapper can discover it:

```bash
sudo ln -sfn /usr/local/opt/openjdk/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk.jdk
```

---

### Option B: Manual Installation (Alternate)
1. Go to Adoptium's official website: [Adoptium Temurin Releases](https://adoptium.net/temurin/releases/).
2. Choose **macOS** as the operating system and **x64** (Intel) as the architecture.
3. Download the `.dmg` installer.
4. Open the `.dmg` package and double-click the installer icon to run the wizard.

---

## Step 3: Configure Environment Variables

Modern macOS uses `zsh` as the default shell. You need to configure it to automatically export the `JAVA_HOME` path.

1. Open your shell profile configuration:
   ```bash
   nano ~/.zshrc
   ```

2. Add the following lines to configure dynamic version lookup and update the path search priorities:
   ```bash
   export JAVA_HOME=$(/usr/libexec/java_home)
   export PATH=$JAVA_HOME/bin:$PATH
   ```

3. Save and close the file (`Ctrl + O`, then `Enter`, then `Ctrl + X` to exit nano).
4. Apply changes immediately to the current terminal window:
   ```bash
   source ~/.zshrc
   ```

---

## Step 4: Verify the Installation

Execute the following commands to confirm that Java compiles and runs successfully:

```bash
java -version
javac -version
```

### Expected Output:
```text
openjdk version "21.0.1" 2023-10-17 LTS
OpenJDK Runtime Environment Temurin-21.0.1+12 (build 21.0.1+12-LTS)
OpenJDK 64-Bit Server VM Temurin-21.0.1+12 (build 21.0.1+12-LTS, mixed mode, sharing)

javac 21.0.1
```

---

## Step 5: Install Recommended IDEs and Tools

Install one of the primary code editors below:

* **IntelliJ IDEA (Recommended)**: Industry-standard Java IDE.
  * [Download IntelliJ IDEA for macOS](https://www.jetbrains.com/idea/download/?section=mac) (Choose Intel macOS version).
* **VS Code**: Lightweight and modular.
  * [Download VS Code for macOS](https://code.visualstudio.com/) (Choose Intel chip version).

---

## Step 6: Install Git Version Control

1. Install Git directly using Homebrew:
   ```bash
   brew install git
   ```
2. Verify the command line version:
   ```bash
   git --version
   ```

---

## Step 7: Write, Compile, and Run Your First Program

Let's test the command line compiler interface:

1. Create a file named `HelloWorld.java` in any workspace directory:
   ```java
   public class HelloWorld {
       public static void main(String[] args) {
           System.out.println("Hello, macOS Java!");
       }
   }
   ```

2. Open Terminal, navigate to the folder where you created the file, and run:
   ```bash
   javac HelloWorld.java
   java HelloWorld
   ```

### Output:
```text
Hello, macOS Java!
```

---

## Common Issues and Troubleshooting

> [!WARNING]
> ### Permission Denied during symlinking
> * **Cause**: The symlink command requires root privileges.
> * **Fix**: Ensure you prefix the command with `sudo` (`sudo ln -sfn ...`). Enter your Mac administrator login password when prompted.

> [!IMPORTANT]
> ### Terminal changes not loading
> * **Cause**: You added variables to `~/.zshrc` but did not refresh or restart the active terminal session.
> * **Fix**: Run `source ~/.zshrc` in your active tab or close and reopen Terminal.

---

**Back to Module Home:** [01_SETUP README](file:///d:/New%20folder/PROJECTS/JAVA_Zero-to-Advanced/01_SETUP/README.md)
