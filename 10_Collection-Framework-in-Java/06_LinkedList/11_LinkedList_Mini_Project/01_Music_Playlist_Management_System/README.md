# Music Playlist Management System

## Introduction

The **Music Playlist Management System** is a mini project developed using Java's **LinkedList**, **ArrayList**, and **ListIterator** classes from the Java Collection Framework.

The project simulates a real-world music player where songs are organized into albums, and songs from different albums can be added to a playlist. The playlist supports forward navigation, backward navigation, replaying the current song, displaying all songs, and removing the currently playing song.

This project demonstrates the practical usage of the **LinkedList** data structure and **ListIterator** for bidirectional traversal.

---

# Problem Statement

Create a playlist management system with the following requirements:

* Create a `Song` class containing song title and duration.
* Create an `Album` class containing multiple songs.
* Store albums in an `ArrayList`.
* Allow only songs that exist in an album to be added to the playlist.
* Store the playlist using a `LinkedList`.
* Provide a menu-driven application that allows users to:

  * Quit
  * Play the next song
  * Play the previous song
  * Replay the current song
  * Display the playlist
  * Remove the currently playing song

---

# Solution

The project is divided into three classes:

* **Song** – Stores information about a song.
* **Album** – Stores songs and allows songs to be added to the playlist.
* **Main** – Creates albums, creates the playlist, and provides the menu-driven application.

---

# Project Features

* Add songs to albums.
* Prevent duplicate songs within an album.
* Add songs from different albums to one playlist.
* Traverse the playlist in both directions.
* Replay the current song.
* Remove the currently playing song.
* Display all songs in the playlist.
* User-friendly menu system.

---

# Project Structure

```text
01_Music_Playlist_Management_System/

│── Song.java

│── Album.java

│── Main.java

└── README.md
```

---

# Java Files

## 1. Song.java

Responsible for:

* Storing song title.
* Storing song duration.
* Returning song information.

---

## 2. Album.java

Responsible for:

* Creating albums.
* Adding songs.
* Searching songs.
* Printing album songs.
* Adding songs to the playlist.

---

## 3. Main.java

Responsible for:

* Creating albums.
* Creating playlist.
* Displaying menu.
* Playing songs.
* Navigating playlist.
* Removing songs.
* Printing playlist.

---

# Collection Classes Used

| Collection   | Purpose                               |
| ------------ | ------------------------------------- |
| ArrayList    | Stores albums                         |
| LinkedList   | Stores playlist                       |
| ListIterator | Traverses playlist in both directions |

---

# LinkedList Methods Used

| Method         | Purpose               |
| -------------- | --------------------- |
| add()          | Add song              |
| listIterator() | Traverse playlist     |
| hasNext()      | Check next song       |
| next()         | Move forward          |
| hasPrevious()  | Check previous song   |
| previous()     | Move backward         |
| remove()       | Remove current song   |
| isEmpty()      | Check playlist status |
| size()         | Number of songs       |

---

# Program Flow

```text
Start

   │

   ▼

Create Albums

   │

   ▼

Add Songs to Albums

   │

   ▼

Create Playlist

   │

   ▼

Add Songs from Albums

   │

   ▼

Display Menu

   │

   ▼

User Selects Option

   │

   ▼

Perform Playlist Operation

   │

   ▼

Repeat Until Quit

   │

   ▼

End
```

---

# Sample Input

```text
1
1
3
4
2
6
0
```

---

# Sample Output

```text
Now Playing : Believer : 3.45 mins

========== PLAYLIST MENU ==========
0 - Quit
1 - Next Song
2 - Previous Song
3 - Replay Current Song
4 - Display Playlist
5 - Print Menu
6 - Remove Current Song

Enter your choice : 1

Now Playing : Thunder : 3.2 mins

Enter your choice : 3

Replaying : Thunder : 3.2 mins

Enter your choice : 4

--------- PLAYLIST ---------
Believer : 3.45 mins
Thunder : 3.2 mins
Perfect : 4.1 mins
Photograph : 4.25 mins
Demons : 4.05 mins
----------------------------

Enter your choice : 0

Playlist Finished.
```

---

# Method Explanation

## addSong()

Adds a new song to an album.

Returns `false` if the song already exists.

---

## findSong()

Searches for a song inside an album.

Returns the corresponding `Song` object.

---

## addToPlaylist()

Checks whether the requested song exists in the album.

If found, the song is added to the playlist.

---

## play()

The core method of the project.

It:

* Displays the menu.
* Reads user input.
* Navigates through songs.
* Replays songs.
* Removes songs.
* Stops when the user quits.

---

## printMenu()

Displays all available playlist operations.

---

## printPlaylist()

Prints every song currently available in the playlist.

---

# Java Concepts Used

* Classes and Objects
* Constructors
* Encapsulation
* Method Overriding
* ArrayList
* LinkedList
* ListIterator
* Enhanced for Loop
* Scanner Class
* Object-Oriented Programming
* Menu-Driven Programming

---

# Challenges Faced

* Managing forward and backward navigation.
* Replaying the current song correctly.
* Preventing duplicate songs inside an album.
* Removing the currently playing song safely.
* Maintaining iterator position after removal.

---

# Possible Improvements

* Shuffle playlist.
* Sort songs alphabetically.
* Search songs by title.
* Save playlists to a file.
* Load playlists from a file.
* Add song ratings.
* Display total playlist duration.
* Support multiple playlists.
* Add favourite songs.
* Implement repeat-all and shuffle modes.

---

# Interview Questions

1. Why is LinkedList used for the playlist?
2. Why are albums stored in an ArrayList?
3. What is the purpose of ListIterator?
4. Why can't a normal Iterator traverse backwards?
5. How does replay work internally?
6. Why is the `forward` boolean required?
7. Why must a song exist in an album before adding it to the playlist?
8. Why is `iterator.remove()` preferred over `playlist.remove()` during iteration?
9. Which collection stores albums?
10. Which collection stores songs in the playlist?

---

# Learning Outcomes

After completing this project, you will understand:

* How to use LinkedList in a real-world application.
* How ListIterator works.
* Bidirectional traversal of collections.
* Menu-driven Java applications.
* Interaction between multiple classes.
* Relationship between ArrayList and LinkedList.
* Practical implementation of Object-Oriented Programming.
* Safe modification of collections during iteration.

---

# Conclusion

The **Music Playlist Management System** demonstrates how Java's Collection Framework can be used to build a practical application. By combining **ArrayList**, **LinkedList**, and **ListIterator**, the project efficiently manages albums and playlists while supporting forward and backward navigation, replay functionality, and safe song removal. It serves as an excellent mini project for understanding LinkedList operations, iterator-based traversal, and object-oriented design in Java.
