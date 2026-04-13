# Java Setup Guide for Apple Silicon (M1/M2/M3)

This guide explains how to set up Java development on Apple Silicon Macs using ARM-compatible tools.

---

## Step 1: Install Homebrew

Open Terminal and run:

```bash id="c9x2mj"
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```

Add Homebrew to PATH:

```bash id="2d8l0k"
echo 'eval "$(/opt/homebrew/bin/brew shellenv)"' >> ~/.zprofile
eval "$(/opt/homebrew/bin/brew shellenv)"
```

Verify installation:

```bash id="9v7k1p"
brew -v
```

---

## Step 2: Install Java (ARM Version)

Install OpenJDK using Homebrew:

```bash id="lq3w8s"
brew install openjdk
```

Link the JDK:

```bash id="h3k2fd"
sudo ln -sfn /opt/homebrew/opt/openjdk/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk.jdk
```

---

## Step 3: Set Environment Variables

Edit the shell configuration file:

```bash id="p8x4zn"
nano ~/.zshrc
```

Add:

```bash id="7m2dqp"
export JAVA_HOME=$(/usr/libexec/java_home)
export PATH=$JAVA_HOME/bin:$PATH
```

Apply changes:

```bash id="v5n1qe"
source ~/.zshrc
```

---

## Step 4: Verify Installation

Run:

```bash id="y4k8tr"
java -version
javac -version
```

---

## Step 5: Install IDE

Recommended tools:

* IntelliJ IDEA (Apple Silicon version)
* Visual Studio Code (ARM version)

---

## Step 6: Install Git

Install using Homebrew:

```bash id="z1p6rt"
brew install git
```

Verify:

```bash id="x8n3lm"
git --version
```

---

## Step 7: First Java Program

Create a file named HelloWorld.java

```java id="w6c9az"
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, Java!");
    }
}
```

---

## Step 8: Compile and Run

```bash id="n2v7ks"
javac HelloWorld.java
java HelloWorld
```

---

## Notes

* Homebrew installs packages in /opt/homebrew
* Always use ARM-compatible tools for best performance
* Avoid mixing Intel (Rosetta) and ARM environments

---

## Common Issues

* JAVA_HOME not set correctly
* Incorrect symlink for JDK
* Terminal not refreshed after configuration
* Using incompatible (Intel-based) tools

---

## Conclusion

Java is now installed and configured for development on Apple Silicon systems.
