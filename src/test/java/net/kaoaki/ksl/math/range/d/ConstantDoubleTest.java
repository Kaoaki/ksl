/*
 * This file is part of ksl, licensed under the MIT License.
 *
 * Copyright (c) 2021 Kaoaki
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.kaoaki.ksl.math.range.d;

import com.google.common.testing.EqualsTester;
import net.kaoaki.ksl.random.RandomSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConstantDoubleTest {
  @Test
  void testConstantZero() {
    assertSame(ConstantDoubleImpl.ZERO, ConstantDouble.constantly(0d));
  }

  @Test
  void testConstant() {
    final ConstantDouble r0 = ConstantDouble.constantly(2d);
    assertEquals(2d, r0.value());
  }

  @ParameterizedTest
  @ValueSource(doubles = {1d, 3d})
  void testWithOutOfRangeValue(final double input) {
    final ConstantDouble r0 = ConstantDouble.constantly(2d);
    assertFalse(r0.test(input));
  }

  @Test
  void testWithInRangeValue() {
    final ConstantDouble r0 = ConstantDouble.constantly(2d);
    assertTrue(r0.test(2d));
  }

  @Test
  void testConstantRandom() {
    final ConstantDouble r0 = ConstantDouble.constantly(2d);
    final RandomSource random = RandomSource.threadLocal();
    for(int i = 0; i < 100; i++) {
      assertEquals(2d, r0.getDouble(random));
    }
  }

  @Test
  void testEquality() {
    new EqualsTester()
      .addEqualityGroup(ConstantDouble.constantly(2d))
      .addEqualityGroup(ConstantDouble.constantly(3d))
      .testEquals();
  }
}
