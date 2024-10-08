package polynomial;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SparsePolynomialTest {
  private SparsePolynomial sparsePolynomial;

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
    sparsePolynomial.addTerm(3, 0);
    sparsePolynomial.addTerm(0, 0);
    sparsePolynomial.addTerm(3, 4);
    sparsePolynomial.addTerm(1, 3);
    assertEquals(" ", sparsePolynomial.toString());

  }
}