# 🚀 Java Development Setup Guide for Apple Silicon (M1/M2/M3)

This guide provides a comprehensive walkthrough to configure a native ARM64 Java development environment optimized for Apple Silicon (M1/M2/M3) Macs.

---

## 🚦 Installation Checklist
- [ ] Install Homebrew Package Manager
- [ ] Add Homebrew to your shell environment paths
- [ ] Install native ARM64 Java JDK (LTS 17 or 21)
- [ ] Set `JAVA_HOME` environment variable
- [ ] Verify JDK installation via Terminal
- [ ] Install native ARM64 IDE (IntelliJ IDEA / VS Code)
- [ ] Install Git Version Control
- [ ] Write, compile, and run your first Java test program

---

## 📦 Step 1: Install Homebrew

Homebrew installs binary packages natively in `/opt/homebrew` on Apple Silicon Macs.

1. Open your Terminal.
2. Run the Homebrew installation script:

```bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```

3. **CRITICAL STEP**: Add Homebrew to your Zprofile so that the shell can find the `brew` command natively. Run the following commands in your Terminal:

```bash
echo 'eval "$(/opt/homebrew/bin/brew shellenv)"' >> ~/.zprofile
eval "$(/opt/homebrew/bin/brew shellenv)"
```

4. Verify Homebrew is working:

```bash
brew -v
```

---

## ☕ Step 2: Install Native ARM64 Java JDK

Avoid running Intel-compiled JDK versions through Rosetta translation, as they consume more power and run slower.

### Option A: Install via Homebrew (Recommended)
Install the default open-source JDK distribution:

```bash
brew install openjdk
```

Link the JDK to macOS system libraries so system frameworks can discover it:

```bash
sudo ln -sfn /opt/homebrew/opt/openjdk/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk.jdk
```

---

### Option B: Azul Zulu JDK (Excellent for ARM64 Performance)
Azul Systems provides high-performance, native ARM64 JDK builds for Apple Silicon:

```bash
brew install --cask zulu
```

---

## ⚙️ Step 3: Configure Environment Variables

1. Open your Zsh profile configuration:
   ```bash
   nano ~/.zshrc
   ```

2. Add these lines to resolve the path of the active JDK dynamically:
   ```bash
   export JAVA_HOME=$(/usr/libexec/java_home)
   export PATH=$JAVA_HOME/bin:$PATH
   ```

3. Save and close nano (`Ctrl + O`, then `Enter`, then `Ctrl + X`).
4. Reload the configurations in your current shell session:
   ```bash
   source ~/.zshrc
   ```

---

## 🔍 Step 4: Verify the Installation

Confirm that Java runs natively on Apple Silicon:

```bash
java -version
javac -version
```

### Expected Output:
Ensure that `aarch64` or `64-Bit` indicates a native ARM compiler.
```text
openjdk version "21.0.1" 2023-10-17 LTS
OpenJDK Runtime Environment Temurin-21.0.1+12 (build 21.0.1+12-LTS)
OpenJDK 64-Bit Server VM Temurin-21.0.1+12 (build 21.0.1+12-LTS, mixed mode, sharing)
```

---

## 🛠️ Step 5: Install Native ARM64 IDEs

Make sure you download the Apple Silicon builds of your favorite editors:

* **IntelliJ IDEA (Recommended)**: Download the macOS version. Click the dropdown and select the **Apple Silicon** option.
  * [Download IntelliJ IDEA](https://www.jetbrains.com/idea/download/?section=mac)
* **VS Code**: Download and run the native **Apple Silicon** zip/installer.
  * [Download VS Code](https://code.visualstudio.com/)

---

## 📦 Step 6: Install Git Version Control

1. Install native Git:
   ```bash
   brew install git
   ```
2. Verify the command line version:
   ```bash
   git --version
   ```

---

## 🚀 Step 7: Write, Compile, and Run Your First Program

Let's test compilation and execution:

1. Create a file named `HelloWorld.java` in a local folder:
   ```java
   public class HelloWorld {
       public static void main(String[] args) {
           System.out.println("Hello, Apple Silicon Java!");
       }
   }
   ```

2. Open Terminal, change directory (`cd`) to the folder containing the file, and run:
   ```bash
   javac HelloWorld.java
   java HelloWorld
   ```

### Output:
```text
Hello, Apple Silicon Java!
```

---

## 💡 Important Notes for Apple Silicon

> [!TIP]
> * **Check Architecture**: If you want to check whether your Java processes are running natively or through Rosetta translation, run `ps aux | grep java` while a program is running, or open Activity Monitor, find the `java` process, and check the type column (should say **Apple** and not **Intel**).
> * **Homebrew Paths**: Remember that Homebrew installs packages in `/opt/homebrew` for Apple Silicon instead of `/usr/local` which is used for Intel Macs. Keep this in mind when referencing libraries.

---

## ⚠️ Common Issues & Troubleshooting

> [!WARNING]
> ### `zsh: command not found: brew`
> * **Cause**: You installed Homebrew but forgot to configure shell environment variables to add the `/opt/homebrew/bin` path.
> * **Fix**: Rerun Step 1, part 3:
>   ```bash
>   echo 'eval "$(/opt/homebrew/bin/brew shellenv)"' >> ~/.zprofile
>   eval "$(/opt/homebrew/bin/brew shellenv)"
>   ```

---

➡️ **Back to Module Home:** [01_SETUP README](file:///d:/New%20folder/PROJECTS/JAVA_Zero-to-Advanced/01_SETUP/README.md)
