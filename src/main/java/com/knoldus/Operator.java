package com.knoldus;

public interface Operator {
  double sum(double a, double b);

  double sub(double a, double b);

  double mul(double a, double b);

  double div(double a, double b);

  double pow(double a, double b);

  void abs(double a, double b);

  double mod(double a, double b);

  double max(double a, double b);

  double min(double a, double b);

}