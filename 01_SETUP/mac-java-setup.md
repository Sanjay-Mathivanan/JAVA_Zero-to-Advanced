# Java Setup Guide for macOS (Apple)

This guide explains how to set up Java development on macOS systems, including Intel and Apple Silicon (M1/M2/M3).

---

## Step 1: Install Homebrew (Recommended)

Homebrew is a package manager that simplifies installation.

Open Terminal and run:

```bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```

Verify installation:

```bash
brew -v
```

---

## Step 2: Install Java JDK

### Option 1: Using Homebrew

```bash
brew install openjdk
```

After installation, link Java:

```bash
sudo ln -sfn /opt/homebrew/opt/openjdk/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk.jdk
```

---

### Option 2: Manual Installation

1. Visit: https://www.oracle.com/java/technologies/downloads/
2. Download the macOS JDK (.dmg file)
3. Install by following the setup wizard

---

## Step 3: Set Environment Variables

Open Terminal and edit the profile file:

```bash
nano ~/.zshrc
```

Add the following lines:

```bash
export JAVA_HOME=$(/usr/libexec/java_home)
export PATH=$JAVA_HOME/bin:$PATH
```

Save and apply changes:

```bash
source ~/.zshrc
```

---

## Step 4: Verify Installation

Run:

```bash
java -version
javac -version
```

If installed correctly, Java version details will be displayed.

---

## Step 5: Install IDE

Recommended options:

* IntelliJ IDEA
* Visual Studio Code

---

## Step 6: Install Git

Install using Homebrew:

```bash
brew install git
```

Verify:

```bash
git --version
```

---

## Step 7: First Java Program

Create a file named HelloWorld.java

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, Java!");
    }
}
```

---

## Step 8: Compile and Run

```bash
javac HelloWorld.java
java HelloWorld
```

---

## Notes for Apple Silicon (M1/M2/M3)

* Use ARM-compatible JDK builds (OpenJDK recommended)
* Homebrew installs packages in /opt/homebrew
* Avoid using Intel-based tools unless necessary

---

## Common Issues

* JAVA_HOME not set properly
* Incorrect Java version in PATH
* Homebrew not configured correctly
* Terminal not reloaded after changes

---

## Conclusion

Java is now successfully installed and ready for development on macOS.
