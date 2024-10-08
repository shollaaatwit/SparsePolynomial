package polynomial;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SparsePolynomialTest {
  private SparsePolynomial sparsePolynomial;
  private SparsePolynomial sparsePolynomial2;

  @Before
  public void setUp() throws Exception {
    sparsePolynomial = new SparsePolynomial();
    sparsePolynomial.addTerm(3, 4);
  }

  @Test
  public void testAddTerm0() {
    sparsePolynomial.addTerm(5, 6);
    assertEquals(" ", sparsePolynomial.toString());

  }

  @Test
  public void testAddTerm1() {
    sparsePolynomial.addTerm(5, 6);
    sparsePolynomial.addTerm(3, 6);
    assertEquals(" ", sparsePolynomial.toString());

  }

  @Test
  public void testAddTerm2() {
    sparsePolynomial.addTerm(5, 6);
    sparsePolynomial.addTerm(3, 6);
    sparsePolynomial.addTerm(-3, 0);
    sparsePolynomial.addTerm(0, 0);
    sparsePolynomial.addTerm(3, 4);
    sparsePolynomial.addTerm(1, 3);
    assertEquals(" ", sparsePolynomial.toString());

  }

  @Test
  public void testAddTerm3() {
    sparsePolynomial.addTerm(5, 6);
    sparsePolynomial.addTerm(3, 6);
    sparsePolynomial.addTerm(-3, 0);
    sparsePolynomial.addTerm(0, 0);
    sparsePolynomial.addTerm(-7, 4);
    sparsePolynomial.addTerm(1, 3);
    assertEquals(" ", sparsePolynomial.toString());
  }

  @Test
  public void testDerivative0() {
    sparsePolynomial.addTerm(5, 6);
    assertEquals(" ", sparsePolynomial.derivative().toString());

  }

  @Test
  public void testDerivative1() {
    sparsePolynomial.addTerm(5, 6);
    sparsePolynomial.addTerm(3, 6);
    sparsePolynomial.addTerm(3, 0);
    sparsePolynomial.addTerm(0, 0);
    sparsePolynomial.addTerm(3, 4);
    sparsePolynomial.addTerm(1, 3);
    assertEquals(" ", sparsePolynomial.derivative().toString());

  }

  @Test
  public void testDerivative2() {
    sparsePolynomial.addTerm(5, 6);
    sparsePolynomial.addTerm(3, 6);
    sparsePolynomial.addTerm(-3, 0);
    sparsePolynomial.addTerm(0, 0);
    sparsePolynomial.addTerm(-7, 4);
    sparsePolynomial.addTerm(1, 3);
    assertEquals(" ", sparsePolynomial.derivative().toString());

  }


  @Test
  public void testEvaluate0() {
    sparsePolynomial.addTerm(5, 6);
    assertEquals(0, sparsePolynomial.evaluate(3), 0);

  }

  @Test
  public void testEvaluate1() {
    sparsePolynomial.addTerm(5, 6);
    sparsePolynomial.addTerm(3, 6);
    sparsePolynomial.addTerm(3, 0);
    sparsePolynomial.addTerm(0, 0);
    sparsePolynomial.addTerm(3, 4);
    sparsePolynomial.addTerm(1, 3);
    assertEquals(0, sparsePolynomial.evaluate(3), 0);

  }

  @Test
  public void testEvaluate2() {
    sparsePolynomial.addTerm(5, 6);
    sparsePolynomial.addTerm(3, 6);
    sparsePolynomial.addTerm(-3, 0);
    sparsePolynomial.addTerm(0, 0);
    sparsePolynomial.addTerm(-7, 4);
    sparsePolynomial.addTerm(1, 3);
    assertEquals(0, sparsePolynomial.evaluate(3), 0);

  }

  @Test
  public void testEvaluate3() {
    sparsePolynomial.addTerm(5, 6);
    sparsePolynomial.addTerm(3, 6);
    sparsePolynomial.addTerm(-3, 0);
    sparsePolynomial.addTerm(0, 0);
    sparsePolynomial.addTerm(-7, 4);
    sparsePolynomial.addTerm(1, 3);
    assertEquals(0, sparsePolynomial.evaluate(-3), 0);

  }

  @Test
  public void testAddPolynomials() {
    sparsePolynomial2 = new SparsePolynomial();
    sparsePolynomial2.addTerm(5, 6);
    sparsePolynomial.addTerm(3, 6);
    assertEquals(" ", sparsePolynomial.add(sparsePolynomial2).toString());
  }

//  @Test
//  public void stressTest() {
//    sparsePolynomial2 = new SparsePolynomial();
//    for(int i = 0; i < 100000; i++) {
//      sparsePolynomial.addTerm(i, i);
//    }
//
//    assertEquals(" ", sparsePolynomial.toString());
//
//  }

  @Test
  public void testMultiplyPolynomial() {
    sparsePolynomial2 = new SparsePolynomial();
    sparsePolynomial.addTerm(5, 6);
    sparsePolynomial.addTerm(3, 6);
    sparsePolynomial.addTerm(-3, 0);
    sparsePolynomial.addTerm(0, 0);
    sparsePolynomial.addTerm(-7, 4);
    sparsePolynomial.addTerm(1, 3);
    sparsePolynomial2.addTerm(5, 6);
    sparsePolynomial2.addTerm(5, 3);
    sparsePolynomial2.addTerm(5, 2);

    assertEquals(" ",
            sparsePolynomial.multiply(sparsePolynomial2).toString());
  }
}