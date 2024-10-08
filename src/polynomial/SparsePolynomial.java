package polynomial;

import java.util.LinkedList;

public class SparsePolynomial implements Polynomial {

  private final LinkedList<Term> realPolynomialList = new LinkedList<>();
  private int maxDegree = 0;

  public SparsePolynomial() {
    String polynomialString = "0";
  }
  /**
   * Add this polynomial with another and return the result as another
   * polynomial. All implementations must ensure that neither of the two operand
   * polynomials are changed as a result of this operation.
   *
   * @param other the other polynomial to be added
   * @return the resulting polynomial
   */
  @Override
  public Polynomial add(Polynomial other) {
    return null;
  }

  /**
   * Multiply this polynomial to another and return the result as another
   * polynomial. All implementations must ensure that neither of the two operand
   * polynomials are changed as a result of this operation.
   *
   * @param other the other polynomial to be multiplied
   * @return the resulting polynomial
   */
  @Override
  public Polynomial multiply(Polynomial other) {
    return null;
  }

  /**
   * Compute and return the first derivative of this polynomial. All implementations
   * must ensure that the calling polynomial is not changed as a result of this
   * operation.
   *
   * @return the polynomial that is the first derivative of this polynomial
   */
  @Override
  public Polynomial derivative() {
    return null;
  }

  /**
   * Add a term to this polynomial with the specified coefficient and power.
   *
   * @param coefficient the coefficient of the term to be added
   * @param power       the power of the term to be added
   * @throws IllegalArgumentException if the power is negative
   */
  @Override
  public void addTerm(int coefficient, int power) throws IllegalArgumentException {
    realPolynomialList.add(new Term(0, 0));
    if(power < 0) {
      throw new IllegalArgumentException();
    }
    if(coefficient == 0) {
      return;
    }

    for(int i = 0; i < realPolynomialList.size(); i++) {
      Term term = realPolynomialList.get(i);
      if(term.getExponent() == power) {
        term.updateCoefficient(coefficient);
        if(term.getCoefficient() == 0) {
          realPolynomialList.remove(i);
        }
        return;
      }
      else if(term.getExponent() < power) {
        realPolynomialList.add(i, new Term(coefficient, power));
        return;
      }
    }
    realPolynomialList.addLast(new Term(coefficient, power));
  }

  /**
   * Get the degree of this polynomial. The degree of a polynomial is defined as the
   * highest power in the polynomial.
   *
   * @return the degree of this polynomial as a whole number
   */
  @Override
  public int getDegree() {
    return 0;
  }

  /**
   * Evaluate the value of this polynomial at the given value of the variable.
   *
   * @param x the value at which the polynomial is to be evaluated.
   * @return the value of the polynomial at x
   */
  @Override
  public double evaluate(double x) {
    return 0;
  }

  /**
   * Return the coefficient of the term with the given power.
   *
   * @param power the power whose coefficient is sought
   * @return the coefficient at the given power
   */
  @Override
  public int getCoefficient(int power) {
    return 0;
  }

  @Override
  public String toString() {
    StringBuilder resultString = new StringBuilder();
    for (int i = 0; i < realPolynomialList.size(); i++) {
      Term term = realPolynomialList.get(i);
      if(term.getCoefficient() != 0) {
        resultString.append(term);
      }
      int nextIndex = i + 1;
      if (nextIndex >= realPolynomialList.size()) {
        nextIndex = realPolynomialList.size() - 1;
      }
      if (realPolynomialList.get(nextIndex).getCoefficient() > 0) {
        resultString.append("+");
      } else {
        resultString.append("-");
      }

    }
    while(resultString.charAt(resultString.length() - 1) == '+'
            || resultString.charAt(resultString.length() - 1) == '-') {
      resultString.deleteCharAt(resultString.length() - 1);
    }
    return resultString.toString();
  }
}
