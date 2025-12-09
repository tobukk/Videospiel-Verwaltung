Videospiel-Verwaltung 

Eine Java Swing Desktop-Anwendung zur Verwaltung einer Videospiel-Sammlung.

Projektarbeit: Programmiertechnik  
Semester: WiSe 2025/26  
Hochschule: Neu-Ulm

---

Beschreibung

Diese Anwendung ermöglicht es, eine Sammlung von Videospielen zu verwalten. Spiele können hinzugefügt, gefiltert, sortiert und analysiert werden. Die Anwendung verfügt über eine grafische Benutzeroberfläche (GUI) basierend auf Java Swing.

---

Features

- Spiele hinzufügen: Neue Videospiele mit Titel, Genre, Altersfreigabe, Multiplayer-Status und Preis speichern
- Filter-Funktion: Spiele nach beliebigen Attributen filtern
- Sortierung: Nach Titel, Genre, Altersfreigabe, Multiplayer oder Preis sortieren
- Gesamtpreis-Berechnung: Berechnet den Wert der gesamten Sammlung
- Eingabevalidierung: Umfassendes Exception Handling für sichere Dateneingabe
- Standardspiele: 5 vorkonfigurierte Spiele beim Start

---

Technologien

- Sprache: Java
- GUI-Framework: Swing
- IDE: IntelliJ IDEA (mit UI Designer)
- Testing: JUnit 5
- Versionskontrolle: Git & GitHub

---

Projektstruktur
```
Videospiel-Verwaltung/
├── src/
│   ├── java/
│   │   └── Spiel.java              # Modellklasse für Videospiele
│   └── VideospielGUI/
│       ├── VideospielGUI.java      # GUI und Hauptlogik
│       └── VideospielGUI.form      # IntelliJ UI Designer Form
├── tests/
│   └── SpielTest.java              # JUnit Tests (kommt noch)
├── docs/
│   └── UML_Klassendiagramm.pdf     # UML-Diagramm (kommt noch)
└── README.md
```

---

Installation & Ausführung

Voraussetzungen
- Java JDK 11 oder höher
- IntelliJ IDEA (empfohlen) oder andere Java IDE

Schritte
1. Repository klonen:
```bash
   git clone https://github.com/tobukk/Videospiel-Verwaltung.git
```

2. Projekt in IntelliJ öffnen:
   - File → Open → Projektordner auswählen

3. Programm ausführen:
   - Rechtsklick auf `VideospielGUI.java` → Run 'VideospielGUI.main()'

---

Verwendung

Spiel hinzufügen
1. Fülle die Felder aus:
   - Titel: Name des Spiels
   - Genre: Z.B. Shooter, Survival, Action
   - Altersfreigabe: 0, 6, 12, 16, 18
   - Multiplayer: Checkbox aktivieren falls zutreffend
   - Preis: Preis in Euro
2. Klicke auf "Speichern"

Filtern
- Gib einen Suchbegriff in das Filterfeld ein
- Klicke auf "Filtern"
- Beispiel: "Shooter" zeigt alle Shooter-Spiele

Sortieren
- Wähle ein Attribut aus der Dropdown-Liste
- Klicke auf "Sortieren"

Gesamtpreis berechnen
- Klicke auf "Berechne"
- Der Gesamtwert aller Spiele wird angezeigt

---

Tests

JUnit-Tests für die Kernfunktionalität (in Entwicklung):

Getestete Methoden:
- gesamtpreis() - Berechnung des Gesamtpreises
- FilterSpiele() - String-Generierung für Filter
- standartspiele() - Initialisierung der Standardspiele

---

UML-Klassendiagramm

Das vollständige UML-Diagramm wird unter `docs/` hinzugefügt.

Klassen-Übersicht

Spiel
- Attribute: titel, genre, altersfreigabe, istMultiplayer, preis
- Methoden: Getter, standartspiele(), FilterSpiele()

VideospielGUI
- Attribute: GUI-Komponenten, spieleListe, table
- Methoden: initObjekte(), filterSpiele(), gesamtpreis(), refresh()

---

Erfüllte Anforderungen

Aufgabe 1
- [x] Mindestens 2 Klassen (Spiel, VideospielGUI)
- [x] Mindestens 3 Attribute mit verschiedenen Datentypen
- [x] Mindestens 1 testbare Methode
- [ ] JUnit-Tests (in Arbeit)
- [x] ArrayList mit mindestens 3 Startobjekten
- [x] GUI mit Swing
- [x] Exception Handling
- [x] Filter- und Sortierfunktion
- [x] Kommentare im Code

Aufgabe 3 (Optional - Bonus)
- [x] GitHub Repository
- [x] Strukturierte Ordner
- [x] Regelmäßige Commits
- [x] README.md Dokumentation

---

Autor

- Name: Krist Tobias, Martinez Tim
- Studiengang: Digital Enterprise Managment

---

Lizenz

Dieses Projekt wurde im Rahmen einer Hochschul-Projektarbeit erstellt.

---


Letztes Update: Dezember 2025
