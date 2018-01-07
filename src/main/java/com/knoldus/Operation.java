package com.knoldus;

public class Operation implements Operator {
  public double sum(double leftOperand, double rightOperand) {
    return (leftOperand + rightOperand);
  }

  public double sub(double leftOperand, double rightOperand) {
    return (leftOperand - rightOperand);
  }

  public double mul(double leftOperand, double rightOperand) {
    return (leftOperand * rightOperand);
  }

  public double div(double leftOperand, double rightOperand) {

    return (leftOperand / rightOperand);
  }

  public double pow(double leftOperand, double rightOperand) {
    double sum = 1;
    for (int i = 0; i < rightOperand; i++) {
      sum = sum * leftOperand;
    }
    return (sum);
  }

  public double mod(double leftOperand, double rightOperand) {
    return (leftOperand % rightOperand);
  }

  public void abs(double leftOperand, double rightOperand) {
    if (leftOperand < 0) {
      leftOperand = -leftOperand;
    }
    if (rightOperand < 0) {
      rightOperand = -rightOperand;
    }
    System.out.println(leftOperand + "   " + rightOperand);
  }

  public double min(double leftOperand, double rightOperand) {
    if (leftOperand < rightOperand) {
      return leftOperand;
    } else {
      return rightOperand;
    }
  }

  public double max(double leftOperand, double rightOperand) {
    if (leftOperand > rightOperand) {
      return leftOperand;
    } else {
      return rightOperand;
    }
  }

}
