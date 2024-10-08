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
    Polynomial summedPolynomial = new SparsePolynomial();
//    for (int i = getDegree(); i >= 0; i--) {
//      summedPolynomial.addTerm(getCoefficient(i), i);
//    }
    for (Term term : realPolynomialList) {
      summedPolynomial.addTerm(term.getCoefficient(), term.getExponent());
    }
    for (int i = other.getDegree(); i >= 0; i--) {
      summedPolynomial.addTerm(other.getCoefficient(i), i);
    }
    return summedPolynomial;
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
    Polynomial newPolynomial = new SparsePolynomial();
    for (int i = realPolynomialList.size()-1; i >= 0; i--) {
      Term firstPoly = realPolynomialList.get(i);
      for (int j = other.getDegree(); j >= 0; j--) {

        if (firstPoly.getCoefficient() != 0 && other.getCoefficient(j) != 0) {
          int newCoefficient = firstPoly.getCoefficient() * other.getCoefficient(j);
          int newDegree = firstPoly.getExponent() + j;
          newPolynomial.addTerm(newCoefficient, newDegree);
        }
      }
    }
    return newPolynomial;
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
    Polynomial derivedPolynomial = new SparsePolynomial();
    for (Term term : realPolynomialList) {
      Term derivedTerm = term.derive();

      if(derivedTerm.getExponent() > 0) {
        derivedPolynomial.addTerm(derivedTerm.getCoefficient(),
                derivedTerm.getExponent());
      }

    }
    return derivedPolynomial;
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
    if (power < 0) {
      throw new IllegalArgumentException("Power cant be negative");
    }
    if (coefficient == 0) {
      return;
    }
    maxDegree = Math.max(maxDegree, power);
    for (int i = 0; i < realPolynomialList.size(); i++) {
      Term term = realPolynomialList.get(i);
      if (term.getExponent() == power) {
        term.updateCoefficient(coefficient);
        if (term.getCoefficient() == 0) {
          realPolynomialList.remove(i);
        }
        return;
      } else if (term.getExponent() < power) {
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
    return maxDegree;
  }

  /**
   * Evaluate the value of this polynomial at the given value of the variable.
   *
   * @param x the value at which the polynomial is to be evaluated.
   * @return the value of the polynomial at x
   */
  @Override
  public double evaluate(double x) {
    double total = 0;
    for (Term term : realPolynomialList) {
      double solvedTerm = term.solve(x);
      total += solvedTerm;
    }

    return total;
  }

  /**
   * Return the coefficient of the term with the given power.
   *
   * @param power the power whose coefficient is sought
   * @return the coefficient at the given power
   */
  @Override
  public int getCoefficient(int power) {
    if (power < 0) {
      return 0;
    }
    for(Term term : realPolynomialList) {
      if(term.getExponent() == power) {
        return term.getCoefficient();
      }
    }
    return 0;
  }

  @Override
  public String toString() {
//    StringBuilder resultString = new StringBuilder();
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < realPolynomialList.size(); i++) {
      Term term = realPolynomialList.get(i);
      if (i > 0 && term.getCoefficient() > 0) {
        result.append("+");
      }
      result.append(term);
    }

    return result.toString();
//    for (int i = 0; i < realPolynomialList.size(); i++) {
//      Term term = realPolynomialList.get(i);
//      if(term.getCoefficient() > 0) {
//        resultString.append(term);
//      } else if (term.getCoefficient() < 0) {
//        resultString.append(new Term(Math.abs(term.getCoefficient()),
//                term.getExponent()));
//      }
//      int nextIndex = i + 1;
//      if (nextIndex >= realPolynomialList.size()) {
//        nextIndex = realPolynomialList.size() - 1;
//      }
//      if (realPolynomialList.get(nextIndex).getCoefficient() >= 0) {
//        resultString.append("+");
//      } else {
//        resultString.append("-");
//      }
//
//    }
//    while(resultString.charAt(resultString.length() - 1) == '+'
//            || resultString.charAt(resultString.length() - 1) == '-') {
//      resultString.deleteCharAt(resultString.length() - 1);
//    }
//    return resultString.toString();
  }
}
