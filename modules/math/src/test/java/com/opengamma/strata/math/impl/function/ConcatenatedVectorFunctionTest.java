/**
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.strata.math.impl.function;

import org.testng.annotations.Test;

import com.opengamma.strata.math.impl.differentiation.VectorFieldFirstOrderDifferentiator;
import com.opengamma.strata.math.impl.matrix.DoubleMatrix1D;
import com.opengamma.strata.math.impl.matrix.DoubleMatrix2D;
import com.opengamma.strata.math.impl.util.AssertMatrix;

/**
 * Create a few {@link VectorFunction} (as anonymous inner classes) and check they concatenate correctly 
 */
@Test
public class ConcatenatedVectorFunctionTest {

  private static final VectorFieldFirstOrderDifferentiator DIFF = new VectorFieldFirstOrderDifferentiator();

  private static final int NUM_FUNCS = 3;
  private static final VectorFunction[] F = new VectorFunction[NUM_FUNCS];

  private static final DoubleMatrix1D[] X = new DoubleMatrix1D[3];
  private static final DoubleMatrix1D[] Y_EXP = new DoubleMatrix1D[3];
  private static final DoubleMatrix2D[] JAC_EXP = new DoubleMatrix2D[3];

  static {
    F[0] = new VectorFunction() {

      @Override
      public DoubleMatrix1D evaluate(DoubleMatrix1D x) {
        return DoubleMatrix1D.filled(1, x.get(0) + 2 * x.get(1));
      }

      @Override
      public DoubleMatrix2D calculateJacobian(DoubleMatrix1D x) {
        DoubleMatrix2D jac = DoubleMatrix2D.filled(1, 2);
        jac.getData()[0][0] = 1.0;
        jac.getData()[0][1] = 2.0;
        return jac;
      }

      @Override
      public int getLengthOfDomain() {
        return 2;
      }

      @Override
      public int getLengthOfRange() {
        return 1;
      }
    };

    F[1] = new VectorFunction() {

      @Override
      public DoubleMatrix1D evaluate(DoubleMatrix1D x) {
        double x1 = x.get(0);
        double x2 = x.get(1);
        double y1 = x1 * x2;
        double y2 = x2 * x2;
        return DoubleMatrix1D.of(y1, y2);
      }

      @Override
      public DoubleMatrix2D calculateJacobian(DoubleMatrix1D x) {
        double x1 = x.get(0);
        double x2 = x.get(1);
        double j11 = x2;
        double j12 = x1;
        double j21 = 0.0;
        double j22 = 2 * x2;
        return new DoubleMatrix2D(new double[][] { {j11, j12 }, {j21, j22 } });
      }

      @Override
      public int getLengthOfDomain() {
        return 2;
      }

      @Override
      public int getLengthOfRange() {
        return 2;
      }
    };

    F[2] = new VectorFunction() {

      @Override
      public DoubleMatrix1D evaluate(DoubleMatrix1D x) {
        double x1 = x.get(0);
        double y1 = x1;
        double y2 = Math.sin(x1);
        return DoubleMatrix1D.of(y1, y2);
      }

      @Override
      public DoubleMatrix2D calculateJacobian(DoubleMatrix1D x) {
        double x1 = x.get(0);
        double j11 = 1.0;
        double j21 = Math.cos(x1);
        return new DoubleMatrix2D(new double[][] { {j11 }, {j21 } });
      }

      @Override
      public int getLengthOfDomain() {
        return 1;
      }

      @Override
      public int getLengthOfRange() {
        return 2;
      }
    };

    X[0] = DoubleMatrix1D.of(-2., 2.);
    X[1] = DoubleMatrix1D.of(1., 2.);
    X[2] = DoubleMatrix1D.of(Math.PI);

    Y_EXP[0] = DoubleMatrix1D.of(2.0);
    Y_EXP[1] = DoubleMatrix1D.of(2.0, 4.0);
    Y_EXP[2] = DoubleMatrix1D.of(Math.PI, 0.0);
    JAC_EXP[0] = new DoubleMatrix2D(new double[][] {{1.0, 2.0 } });
    JAC_EXP[1] = new DoubleMatrix2D(new double[][] { {2.0, 1.0 }, {0.0, 4.0 } });
    JAC_EXP[2] = new DoubleMatrix2D(new double[][] { {1.0 }, {-1.0 } });
  }

  /**
   * /check individual functions first
   */
  @Test
  public void functionsTest() {

    for (int i = 0; i < 3; i++) {
      DoubleMatrix1D y = F[i].evaluate(X[i]);
      DoubleMatrix2D jac = F[i].calculateJacobian(X[i]);
      AssertMatrix.assertEqualsVectors(Y_EXP[i], y, 1e-15);
      AssertMatrix.assertEqualsMatrix(JAC_EXP[i], jac, 1e-15);
    }
  }

  @Test
  public void conCatTest() {
    DoubleMatrix1D cx = X[0].concat(X[1]).concat(X[2]);
    DoubleMatrix1D cyExp = Y_EXP[0].concat(Y_EXP[1]).concat(Y_EXP[2]);
    ConcatenatedVectorFunction cf = new ConcatenatedVectorFunction(F);
    DoubleMatrix1D cy = cf.evaluate(cx);
    AssertMatrix.assertEqualsVectors(cyExp, cy, 1e-15);

    DoubleMatrix2D cJac = cf.calculateJacobian(cx);
    DoubleMatrix2D fdJac = DIFF.differentiate(cf).evaluate(cx);
    AssertMatrix.assertEqualsMatrix(fdJac, cJac, 1e-10);
  }

}
