create database payroll;
use payroll;

create table employee(
	Employee_Id int primary key auto_increment,
	Employee_Name varchar(50) not null,
    E_Mail varchar(50) not null,
    Phone_Number varchar(50) not null,
    Gender varchar(50) not null,
    Date_of_Birth varchar(50) not null,
    Address varchar(200) not null,
    Designation varchar(50) not null,
    Employee_Type varchar(50) not null,
    Date_of_Joining varchar(50) not null,
    Location varchar(50) not null,
    BasicSalary double not null
);

create table user(
	Employee_Id int primary key auto_increment,
    Fname varchar(50),
    Lname varchar(50),
    Designation varchar(50),
    Email varchar(50),
	Username varchar(50),
    Password varchar(50)
);

alter table employee auto_increment=22101;

alter table user auto_increment=22001;

select * from employee;

select * from user;

drop table employee;

drop table user;
