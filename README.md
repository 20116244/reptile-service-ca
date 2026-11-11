# 🦎 Reptile Database App

A console app written in **Kotlin** for keeping track of your reptiles: their identity, morphs, health, diet, and the terrarium setup each one needs.

Built as a college project in software engineering.

---

## ✨ Features

- **Add** a reptile with a full care profile
- **List** reptiles: all of them, or filtered by name, species, size, morphs, diet or health
- **Update** a reptile's details
- **Delete** a reptile
- **Archive** reptiles you no longer keep, and **restore** them later
- **Search** for a reptile
- **Save and load** profiles to and from a JSON file (`notes.json`)
- **Safe exit:** data is saved automatically when you quit. If loading failed at startup, the app does **not** save, so your existing file can't be overwritten with an empty list
- **Logging** with [kotlin-logging](https://github.com/oshai/kotlin-logging)

---

## 📋 What gets stored for each reptile

| Field | Example | Type |
|---|---|---|
| Scientific name | *Heterodon nasicus* | Text |
| Nickname | Noodle | Text |
| Subspecies | Western hognose | Text |
| Sex | Female | Text |
| Age | 1 | Number (years) |
| Morphs | Albino, Anaconda | Text |
| Adoption date | 27/09/2026 | Text (day/month/year) |
| Weight | 45 | Grams |
| Length | 30 | Number (cm) |
| Diet | Frozen/thawed mice | Text |
| Health | Healthy | Text |
| Friendliness | 7 | Number (0–10) |
| Terrarium size | 90 | Number (cm) |
| Habitat | Sandy grasslands | Text |
| Hot side temperature | 32 | Number (°C) |
| Cold side temperature | 24 | Number (°C) |
| Humidity | 30–40% | Text |

---

## 🖥️ Main menu

```
 ----------------------------------
 |     Reptile Database App       |
 ----------------------------------
 | NOTE MENU                      |
 |   1) Add a Reptile             |
 |   2) List All Reptiles         |
 |   3) Update a Reptile Info     |
 |   4) Delete a Reptile Info     |
 |   5) Save a Reptile Profile    |
 |   6) Load a Reptile Profile    |
 |   7) Archive a Reptile Profile |
 |   8) Search a Reptile          |
 |   9) Restore a Reptile Profile |
 ----------------------------------
 |   0) Exit                      |
 ----------------------------------
```

### List submenu

```
 1) List all Reptiles
 2) List Reptile by name
 3) List Reptile by species
 4) List Reptile by size
 5) List Reptile by morphs
 6) List Reptile by diet
 7) List Reptile by health
 8) List All Archived Reptile Notes
```

---

## 🚀 Getting started

### Requirements

- JDK 21
- IntelliJ IDEA (recommended). The Gradle wrapper is included, so you don't need to install Gradle

### Run it

```bash
git clone https://github.com/20116244/reptile-service-ca.git
cd reptile-service-ca
```

Open the project in IntelliJ IDEA and run `main()` in `src/main/kotlin/Main.kt`.

When it starts, the app looks for `notes.json` in the working directory and loads it if it's there.

### Run the tests

```bash
./gradlew test
```

---

## 🗂️ Project structure

```
src/
└── main/kotlin/
    ├── Main.kt                  # Entry point, menus, user input
    ├── model/
    │   └── Reptile.kt           # Reptile data class
    ├── service/
    │   └── ReptileNote.kt       # Reptile store logic (add, list, update, archive…)
    ├── persistance/
    │   ├── Serializer.kt        # Save/load interface
    │   └── JSONSerializer.kt    # JSON save/load with Jackson
    └── utils/
        └── UserInput.kt         # Input helpers (readNextInt, readNextLine)
└── test/kotlin/
    └── service/
        └── ReptileNoteTest.kt   # Unit tests
```

---

## 🛠️ Built with

- [Kotlin](https://kotlinlang.org/)
- [kotlin-logging](https://github.com/oshai/kotlin-logging) for logging
- [Jackson](https://github.com/FasterXML/jackson) for JSON storage
- [JUnit 5](https://junit.org/junit5/) for testing
- Gradle (Kotlin DSL)

---

## 🔮 Future improvements

- Feeding and shedding log for each reptile
- Weight history to track growth over time
- Vet visit and medication tracking
- Alerts when terrarium temperature or humidity is out of range
- More unit tests to cover every menu option

---

## 👩‍💻 Author

**Melanie**: software engineering student

📄 This project was made for educational purposes.
