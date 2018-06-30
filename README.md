# ictc events
Online web based ICTC events database.
..
## Getting started.
* Clone this repo using ``` git clone git@github.com:dineshdb/dbms.git```
* Update all submodules using ``` git submodule update --init --recursive```
* Build the project using ``` ./gradlew build ```. It will build the backend components.
* Create database from [here](#create_database)
* Run the project using ``` ./gradlew bootRun```. Go to http://localhost:8080 to see the output.
* To sync new updates ``git pull --recurse-submodules``.

## Getting started in docker
* build this project using ``./gradlew build``
* build this image using ``docker build -t dbms_project .``.
* then start the service stack using ``docker-compose up``
* Note that any other name for docker image will not work, otherwise you will need to change the ``docker-compose`` file.

## Create Database
Install mysql or mariadb and get into its root shell. Then execute:
```mysql
mysql> create database dbms_project; -- Create the new database
mysql> create user 'dbms_project'@'localhost' identified by 'ThePassword'; -- Creates the user
mysql> grant all on dbms_project.* to 'dbms_project'@'localhost'; -- Gives all the privileges to the new user on the newly created database
```
**Note**: Don't forget to change password in production.
