# JavaFX JPA MySQL Application

This project is a JavaFX application that connects to a MySQL database using JPA (Java Persistence API). It provides a user interface for selecting a country from a list populated from the database.

## Project Structure

```
javafx-jpa-mysql-app
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── app
│   │   │   │   ├── MainApp.java
│   │   │   │   ├── controller
│   │   │   │   │   └── CountryController.java
│   │   │   │   ├── model
│   │   │   │   │   └── Country.java
│   │   │   │   └── util
│   │   │   │       └── JpaUtil.java
│   │   └── resources
│   │       ├── app
│   │       │   └── view
│   │       │       └── country_screen.fxml
│   │       └── META-INF
│   │           └── persistence.xml
├── pom.xml
└── README.md
```

## Setup Instructions

1. **Clone the Repository**: Clone this repository to your local machine.

2. **Docker Setup**: Ensure you have Docker installed and running. Use the provided Dockerfile to set up a MySQL database. You can build and run the Docker container with the following commands:
   ```bash
   docker build -t mysql-docker .
   docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=root_password -e MYSQL_DATABASE=my_database -e MYSQL_USER=my_user -e MYSQL_PASSWORD=my_password -p 3306:3306 -d mysql-docker
   ```

3. **Maven Dependencies**: This project uses Maven for dependency management. Ensure you have Maven installed. Navigate to the project directory and run:
   ```bash
   mvn clean install
   ```

4. **Database Initialization**: Upon application startup, the JPA will create a table for country management and insert the records for Ecuador, Colombia, and Perú.

5. **Run the Application**: You can run the application using the following command:
   ```bash
   mvn javafx:run
   ```

## Usage

- Upon launching the application, you will see a screen with a label "Seleccione el país" and a combo box displaying the list of countries fetched from the MySQL database.
- Select a country from the combo box to interact with the application.

## Notes

- Ensure that the MySQL database is running and accessible before starting the application.
- Modify the database connection properties in `persistence.xml` if necessary to match your setup.