# AuthorSeeker 📚

AuthorSeeker is a Java console application that fetches academic article data from the SerpApi Google Scholar service, parses the information, and stores it in a PostgreSQL database. Users can interact with the application through a command-line menu to add new articles or display the content currently saved in the database.

## Features

* **Interactive Menu:** A simple and intuitive command-line interface to navigate the application's features.
* **Fetch from API:** Fetches article data for specified researchers from a live web API.
* **Data Persistence:** Saves article information (title, authors, publication date, etc.) to a PostgreSQL database.
* **Display Data:** Retrieves and displays all saved articles from the database in a clean, formatted list.

## Technology Stack

- **Language:** Java 17
- **Build Tool:** Maven
- **Database:** PostgreSQL
- **Libraries:**
    * **Apache HttpClient:** For making HTTP requests to the web API.
    * **Jackson Databind:** For parsing the JSON response from the API.
    * **PostgreSQL JDBC Driver:** For connecting to and interacting with the database.

## Architecture 

The project uses the **Model-View-Controller (MVC)** design pattern.

* **Model (`ArticleInfo`, `ArticleRepository`):** Represents the data and handles all database interactions.
* **View (`InfoDisplay`):** Responsible for all user interaction. It prints menus and results to the console and reads input from the user.
* **Controller (`SeekerLogic`):** The brain of the application. It coordinates the flow of data between the View, the Services, and the Model.
* **Services (`ApiService`, `JsonParser`):** A layer of specialized "worker" classes that handle distinct tasks like making API calls or parsing JSON, keeping the Controller clean.

### Structure
src/main/java/org/example/
├── Main.java               // The application entry point
├── Controller/
│   └── SeekerLogic.java    // The main controller (brain)
├── Model/
│   ├── ArticleInfo.java    // The data blueprint for an article
│   └── ArticleRepository.java // Handles all database communication
├── Services/
│   ├── ApiService.java     // Makes HTTP requests to the API
│   └── JsonParser.java     // Parses the JSON response
└── View/
    └── InfoDisplay.java    // Handles all console input and output

### Requisites

* Java 17 or later
* Maven
* A running PostgreSQL server
