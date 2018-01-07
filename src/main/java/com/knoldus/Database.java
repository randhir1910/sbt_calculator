package com.knoldus;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
  private static Connection conn;

  private Database() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/knoldus_db", "root", "root");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static Connection getConn() {
    return conn;
  }
}
