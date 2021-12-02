package Passport.src.UserDetails;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOError;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;
import javax.lang.model.element.Name;
import javax.swing.*;

public class User {

  String Name;
  int Applicationid;
  String Month;
  int Day, Year;
  int Age;
  String Address;
  String Gender;
  String Marital_Status;
  int Aadhaar_Number;
  String Email;
  int Phonenumber;
  String username;
  String password;
  String ApplicationStatus;
  String RenewalStatus;
  boolean renewal = false;

  User(
    String Name,
    int Applicationid,
    int Age,
    int Day,
    String Month,
    int Year,
    String Gender,
    String Marital_Status,
    int Aadhaar_Number,
    String Email,
    int Phonenumber,
    String Address,
    String username,
    String password
  ) {
    this.Name = Name;
    this.Applicationid = Applicationid;
    this.Age = Age;
    this.Day = Day;
    this.Month = Month;
    this.Year = Year;
    this.Gender = Gender;
    this.Marital_Status = Marital_Status;
    this.Aadhaar_Number = Aadhaar_Number;
    this.Email = Email;
    this.Phonenumber = Phonenumber;
    this.Address = Address;
    this.username = username;
    this.password = password;
  }

  void Ren(boolean ren) {
    ren = renewal;
  }
}
