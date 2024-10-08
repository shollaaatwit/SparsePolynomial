package polynomial;

public class Term {

  int coefficient;
  int exponent;

  public Term(int coefficient, int exponent) {
    this.coefficient = coefficient;
    this.exponent = exponent;
  }

  public int getCoefficient() {
    return coefficient;
  }

  public int getExponent() {
    return exponent;
  }

  public void updateCoefficient(int newCoefficient) {
    coefficient += newCoefficient;
  }

  public void updateExponent(int newExponent) {
    exponent += newExponent;
  }

  public double solve(double x) {
    return coefficient * Math.pow(x, exponent);
  }

  public Term derive() {
    if(exponent == 0) {
      coefficient = 0;
    }
    return new Term(coefficient * exponent,exponent - 1);
  }

  @Override
  public String toString() {
    if(exponent > 0) {
      return coefficient + "x" + "^" + exponent;
    } else if (exponent == 0) {
      return coefficient + "";
    } else {
      return "";
    }

  }


}
