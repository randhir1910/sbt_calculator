package com.knoldus;

/**
 * all database query perform here.
 *
 * @author randhir
 * database mysql
 * version 5.1.6
 */

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DbQuery {
  public static void allRead() {
    try {
      Statement statement = Database.getConn().createStatement();
      ResultSet result = statement.executeQuery("select "
          + "* from calculator");
      System.out.println("id  date       time        left_operand "
          + "  right_operand   operator    result");
      while (result.next()) {
        System.out.println(result.getInt(1) + "   " + result.getTimestamp(2)
            + "     " + result.getDouble(3) + "          " + result.getDouble(4)
            + "            " + result.getString(5) + "          " + result.getDouble(6));
      }
      Database.getConn().close();

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void specificRead(String val) {
    try {
      Statement statement = Database.getConn().createStatement();
      ResultSet result = statement.executeQuery("select * from"
          + " calculator where operator ='" + val + "'");
      System.out.println("id  date       time        left_operand  "
          + " right_operand   operator    result");
      while (result.next()) {
        System.out.println(result.getInt(1) + "   "
            + result.getTimestamp(2) + "     "
            + result.getDouble(3) + "          "
            + result.getDouble(4) + "            "
            + result.getString(5) + "          "
            + result.getDouble(6));
      }
      Database.getConn().close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("press 1 for see all recors and press 2 for specific record");
    int val = input.nextInt();
    if (val == 1) {
      allRead();
    } else {
      System.out.println("enter operator name of first three digit "
          + ":- (sum,sub,mul,div,mod,pow,min.max)");
      input.nextLine();
      String val1 = input.nextLine();
      specificRead(val1);
    }
  }
}
