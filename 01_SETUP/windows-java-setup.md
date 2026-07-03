# 🪟 Java Development Setup Guide for Windows

This guide provides a comprehensive, step-by-step walkthrough to configure your Microsoft Windows environment for Java development.

---

## 🚦 Installation Checklist
- [ ] Download & Install Java JDK (LTS 17 or 21)
- [ ] Configure `JAVA_HOME` System Variable
- [ ] Add JDK Binaries to the System `PATH`
- [ ] Verify JDK Installation via command-line
- [ ] Install IDE (IntelliJ IDEA / VS Code)
- [ ] Install Git & verify version control
- [ ] Compile and run a "Hello World" test program

---

## 📦 Step 1: Install Java JDK

1. Visit the official Oracle Java Downloads page or Eclipse Temurin (Adoptium):
   * [Oracle JDK Downloads](https://www.oracle.com/java/technologies/downloads/)
   * [Adoptium Temurin Downloads](https://adoptium.net/temurin/releases/)
2. Choose the **Windows** tab and download the **x64 Installer** (`.exe`).
3. Double-click the downloaded file (e.g., `jdk-21_windows-x64_bin.exe`) to launch the setup wizard.
4. Follow the default wizard prompt and note the installation path. It usually defaults to:
   ```text
   C:\Program Files\Java\jdk-21
   ```

---

## ⚙️ Step 2: Configure Environment Variables

For Windows to locate the Java compiler (`javac`) and launcher (`java`), you must register their paths in your environment variables.

### 1. Create `JAVA_HOME`
1. Press the `Win` key, type **Environment Variables**, and select **Edit the system environment variables**.
2. In the System Properties window, click the **Environment Variables...** button at the bottom.
3. Under the **System variables** section (bottom half), click **New...**.
4. Set the following values:
   * **Variable name**: `JAVA_HOME`
   * **Variable value**: `C:\Program Files\Java\jdk-21` *(Ensure this matches your actual installation folder path!)*
5. Click **OK**.

### 2. Update System `PATH`
1. Still inside the **System variables** list, scroll down, locate the **Path** variable, and click **Edit...**.
2. In the Edit Environment Variable window, click **New** on the right side.
3. Add the following entry:
   ```text
   %JAVA_HOME%\bin
   ```
4. Click **OK** on all open windows to save the changes.

---

## 🔍 Step 3: Verify the Installation

To verify that Java is installed and registered correctly:
1. Open a new instance of **Command Prompt** (`cmd`) or **PowerShell**.
2. Execute the following verification commands:

```bash
java -version
javac -version
```

### Expected Output
If correctly set up, you should see output similar to this:
```text
openjdk version "21.0.1" 2023-10-17 LTS
OpenJDK Runtime Environment Temurin-21.0.1+12 (build 21.0.1+12-LTS)
OpenJDK 64-Bit Server VM Temurin-21.0.1+12 (build 21.0.1+12-LTS, mixed mode, sharing)

javac 21.0.1
```

---

## 🛠️ Step 4: Install Recommended IDEs

Install one of the following recommended code editors for Java development:

* **IntelliJ IDEA (Recommended)**: Download the free Community Edition from JetBrains.
  * [Download IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
* **Visual Studio Code**: Ensure you install the **Extension Pack for Java** extension.
  * [Download VS Code](https://code.visualstudio.com/)

---

## 📦 Step 5: Install Git Version Control

1. Download the Windows installer from [Git SCM Windows](https://git-scm.com/download/win).
2. Run the installer, select default settings, and finish installation.
3. Open Command Prompt and verify:

```bash
git --version
```

---

## 🚀 Step 6: Write, Compile, and Run Your First Program

Let's test the environment manually from scratch:

1. Open notepad or your code editor and save the following code as `HelloWorld.java` in a local folder (e.g., `C:\JavaProjects\`):

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, Windows Java Development!");
    }
}
```

2. Open Command Prompt and navigate to your project directory:
   ```cmd
   cd C:\JavaProjects
   ```

3. Compile the Java class:
   ```cmd
   javac HelloWorld.java
   ```

4. Run the compiled bytecode program:
   ```cmd
   java HelloWorld
   ```

### Output:
```text
Hello, Windows Java Development!
```

---

## ⚠️ Common Issues & Troubleshooting

> [!WARNING]
> ### `'javac' is not recognized as an internal or external command`
> * **Cause**: The `PATH` environment variable does not point to your JDK `bin` directory.
> * **Fix**: Re-verify Step 2. Make sure `%JAVA_HOME%\bin` is added to your Path, and that you **opened a brand new Command Prompt** since applying those changes.

> [!IMPORTANT]
> ### `Error: JAVA_HOME points to a JRE instead of a JDK`
> * **Cause**: You might have downloaded the Java Runtime Environment (JRE) instead of the Java Development Kit (JDK). JRE can run programs but lacks compile tools like `javac`.
> * **Fix**: Uninstall JRE, download JDK from Adoptium or Oracle, and update your `JAVA_HOME` path.

---

➡️ **Back to Module Home:** [01_SETUP README](file:///d:/New%20folder/PROJECTS/JAVA_Zero-to-Advanced/01_SETUP/README.md)
