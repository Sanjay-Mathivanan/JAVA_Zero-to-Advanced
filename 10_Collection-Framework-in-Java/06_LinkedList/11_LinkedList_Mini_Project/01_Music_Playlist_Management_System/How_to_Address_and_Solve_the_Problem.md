# How to Address and Solve This Problem

The main challenge in this project is to build a playlist system where songs can be played, navigated, replayed, and removed while maintaining the correct order of songs.

To solve this problem, the project is divided into three separate classes, each with a specific responsibility.

## Step 1: Create the `Song` Class

The `Song` class stores the details of a song.

Each song contains:

* Song title
* Song duration

This class acts as the basic building block of the application.

---

## Step 2: Create the `Album` Class

The `Album` class manages a collection of songs.

Responsibilities:

* Store songs using an `ArrayList<Song>`.
* Add new songs to the album.
* Prevent duplicate songs.
* Search for songs by title.
* Add only existing songs to the playlist.

This ensures that users cannot add songs they do not own.

---

## Step 3: Store Albums

Multiple albums are stored in an `ArrayList<Album>`.

Example:

```text
Albums

├── Evolve
│   ├── Believer
│   ├── Thunder
│   └── Demons
│
└── Divide
    ├── Perfect
    ├── Shape of You
    └── Photograph
```

---

## Step 4: Create the Playlist

A `LinkedList<Song>` is used to represent the playlist.

```java
LinkedList<Song> playlist = new LinkedList<>();
```

The playlist contains songs from different albums while preserving the order in which they are added.

---

## Step 5: Add Songs to the Playlist

Before adding a song:

1. Search for the song in the album.
2. If the song exists, add it to the playlist.
3. Otherwise, display an appropriate message.

This satisfies the requirement that only owned songs can be played.

---

## Step 6: Navigate the Playlist

A `ListIterator<Song>` is used for playlist navigation.

It supports:

* Next song
* Previous song
* Replay current song
* Remove current song

Unlike a normal `Iterator`, `ListIterator` allows traversal in both forward and backward directions.

---

## Step 7: Handle Playlist Operations

The application displays a menu and performs the selected operation.

Available operations include:

* Quit
* Play next song
* Play previous song
* Replay current song
* Display playlist
* Remove current song

The program repeats these operations until the user chooses to quit.

---

## Solution Workflow

```text
Start
   │
   ▼
Create Songs
   │
   ▼
Create Albums
   │
   ▼
Store Albums in ArrayList
   │
   ▼
Create Playlist (LinkedList)
   │
   ▼
Add Songs from Albums
   │
   ▼
Create ListIterator
   │
   ▼
Display Menu
   │
   ▼
Perform User Operation
   │
   ▼
Update Playlist
   │
   ▼
Continue Until User Quits
   │
   ▼
End
```

---

## Why This Solution?

This design follows Object-Oriented Programming principles:

* **Song** manages song information.
* **Album** manages a collection of songs.
* **Main** manages playlist operations and user interaction.

The solution also demonstrates the practical use of:

* `ArrayList`
* `LinkedList`
* `ListIterator`
* Classes and Objects
* Encapsulation
* Menu-driven programming

---

## Benefits of This Approach

* Modular and easy to understand.
* Prevents invalid playlist entries.
* Efficient forward and backward navigation.
* Easy to extend with features such as shuffle, repeat, search, and favorites.
* Demonstrates real-world usage of the Java Collection Framework.
