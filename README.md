# ictc events
Online web based ICTC events database.
..
## Getting started.
* Clone this repo using ``` git clone git@github.com:dineshdb/dbms.git```
* Update all submodules using ``` git submodule update --init --recursive```
* Build the project using ``` ./gradlew build ```. It will build the backend components.
* Create database from [here](#create_database)
* Run the project using ``` ./gradlew bootRun```. Go to http://localhost:8080 to see the output.
* To sync new updates ``git pull --recurse-submodules``. However submodules can get out of sync too soon so it is better to pull each submodule individually during development. Don't forget to sync the submodules before release.

## Create Database
Install mysql or mariadb and get into its root shell. Then execute:
```mysql
mysql> create database dbms_project; -- Create the new database
mysql> create user 'dbms_project'@'localhost' identified by 'ThePassword'; -- Creates the user
mysql> grant all on dbms_project.* to 'dbms_project'@'localhost'; -- Gives all the privileges to the new user on the newly created database
```
**Note**: Don't forget to change password in production.

## Authors
* **[Rupesh Shrestha](https://github.com/RUPESH1439)** <rupesh.shrestha96742@gmail.com>
* **[Dinesh Bhattarai](https://dbhattarai.info.np)** <dbhattarai252@gmail.com>
* **[Jeevan Thapa](https://github.com/JeevanThapa9111)** <jeevanthapa911@gmail.com>
* **[Aashutosh Poudel](https://github.com/atosh502)** <aashutoshpoudyal@gmail.com>
