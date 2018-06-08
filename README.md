# ecommerce
Online web based ecommerce system.
..
## Getting started.
* Clone this repo using ``` git clone git@github.com:dineshdb/ecommerce.git```
* Update all submodules using ``` git submodule update --init --recursive```
* Build the project using ``` ./gradlew build ```. It will build the backend components.
* Create database from [here](#create_database)
* Run the project using ``` ./gradlew bootRun```. Go to http://localhost:8080 to see the output.
* To sync new updates ``git pull --recurse-submodules``.
## If ecommerce-frontend not up to date
  pull all changes in the repo including changes in the submodules
* git pull --recurse-submodules

## Create Database
Install mysql or mariadb and get into its root shell. Then execute:
```mysql
mysql> create database db_example; -- Create the new database
mysql> create user 'springuser'@'localhost' identified by 'ThePassword'; -- Creates the user
mysql> grant all on db_example.* to 'springuser'@'localhost'; -- Gives all the privileges to the new user on the newly created database
```

**Note**: Don't forget to change password in production.