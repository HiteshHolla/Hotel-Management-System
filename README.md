# Hotel Management System

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

<!-- About the project -->

## About the project

Java Swing based project for operations related to running a Hotel. This project was done as part of my journey to understand the concepts of Object oriented design (OOPs), Database design and to familiarize myself with the basics of SQL CRUD operations plus querying.

### Built with

* Java
* MySQL

<!-- Getting Started -->

## Getting Started

### Prerequisites

* Basic understanding of Java and SQL. 
* One of the resources I personally found useful for understanding SQL : [SQL Zoo](https://sqlzoo.net/wiki/SQL_Tutorial)
* Download Link for MySQL : [MySQL](https://dev.mysql.com/downloads/)
* Below are the commands to be typed in MySQL Command Line Client to set up the required database and tables:
1. Creating the database
```sh
create database hms;
use hms;
```
2. Creating the login table with admin and 12345 as default username and password.
```sh
create table login(username varchar(40), password varchar(40));
insert into login values('admin','12345');
```
3. Creating the remaining tables: customer, room, driver, employee
```sh
create table customer(id int(30), number int(30), name varchar(30), gender varchar(30), country varchar(30), room_number int(10), status varchar(30), deposit int(10));

create table room(room_number int(20), availability varchar(20), clean_status varchar(20), price int(10), bed_type varchar(30));

create table employee(name varchar(30), age int(10), gender varchar(30), job varchar(30), salary int(10), phone int(10), aadhar int(30), email varchar(40));

create table driver(name varchar(30), age int(10), gender varchar(20), company varchar(30), brand varchar(30), available varchar(10), location varchar(50));
```

### Installation

Since I'm still new to how Git works, I'd recommend downloading the entire folder and running it on your local machine after the database and tables have been set up. Will add a detailed installation guide once I've found my way around Git.

## Usage

1. Run the main class of Hotel Management System.
2. Login using username: admin and password: 12345. 
3. After that you can play around with the various classes of adding rooms, guest details etc.

More than how the use cases, the project is a great way to understand how object oriented design based programming works. It helps understand how classes can be reused and each functionality uses the same base but is still built separately. It also helps understand how a database should be designed while thinking ahead about the joining keys and how each piece of information should fit in the overall database+table structure.

## Contact

* [LinkedIn](https://www.linkedin.com/in/hitesh-holla-13b8661b5/)
* [Gmail](mailto:hiteshholla@gmail.com)

## Acknowledgments

The below resources were tremedously helpful for inspiration and help whenever I found myself to be stuck at any issue:
* [Kunal Tyagi](https://github.com/kunaltyagi9)
* [Youtube](https://www.youtube.com/) 
* [Stack Overflow](https://stackoverflow.com/)
