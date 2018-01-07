package com.knoldus;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class Calculator {
  private static double leftOperand;
  private static double rightOperand;
  private static String operation;
  private static double result;

  public static void resultSave() {
    try {
      PreparedStatement preparedStatement = Database.getConn()
          .prepareStatement("insert into calculator"
              + "(timestamp,leftOperand,rightOperand,operator,result)"
              + " values (?,?,?,?,?)");
      java.util.Date date = new java.util.Date();
      java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
      preparedStatement.setTimestamp(1, sqlTime);
      preparedStatement.setDouble(2, leftOperand);
      preparedStatement.setDouble(3, rightOperand);
      preparedStatement.setString(4, operation);
      preparedStatement.setDouble(5, result);
      int record = preparedStatement.executeUpdate();
      System.out.println(record + " record saved");
      Database.getConn().close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

  public static void main(String[] args) {
    Operation operator = new Operation();
    Scanner in = new Scanner(System.in);
    System.out.println("enter first operand");
    leftOperand = in.nextDouble();
    System.out.println("enter second operand");
    rightOperand = in.nextDouble();
    System.out.println("enter operation ");
    in.nextLine();
    operation = in.nextLine().substring(0, 3).toLowerCase();

    switch (operation) {
      case "sum": {
        result = operator.sum(leftOperand, rightOperand);
        System.out.println("result : " + result);
        break;
      }
      case "sub": {
        result = operator.sub(leftOperand, rightOperand);
        System.out.println("result : " + result);
        break;
      }
      case "mul": {
        result = operator.mul(leftOperand, rightOperand);
        System.out.println("result : " + result);
        break;
      }
      case "div": {
        if (rightOperand != 0) {
          result = operator.div(leftOperand, rightOperand);
          System.out.println("result : " + result);
        } else {
          System.out.println("divide by zero");
        }
        break;
      }
      case "mod": {
        result = operator.mod(leftOperand, rightOperand);
        System.out.println("result : " + result);
        break;
      }
      case "pow": {
        result = operator.pow(leftOperand, rightOperand);
        System.out.println("result : " + result);
        break;
      }
      case "min": {
        result = operator.min(leftOperand, rightOperand);
        System.out.println("result : " + result);
        break;
      }
      case "max": {
        result = operator.max(leftOperand, rightOperand);
        System.out.println("result : " + result);
        break;
      }
      case "add": {
        result = operator.sum(leftOperand, rightOperand);
        System.out.println("result : " + result);
        break;
      }
      case "abs": {
        operator.abs(leftOperand, rightOperand);
        break;
      }
      default: {
        System.out.println("please give valid operator");
      }

    }
    System.out.println("do you want to save record in database :(Yes/No)");
    String val = in.nextLine();
    if (val.equalsIgnoreCase("yes")) {
      resultSave();
    }
  }
}
