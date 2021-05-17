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

import java.util.function.DoublePredicate;
import net.kaoaki.ksl.math.DoubleSource;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * A {@code double} range.
 *
 * @since 1.0.0
 */
public interface DoubleRange extends DoublePredicate, DoubleSource {
  /**
   * Creates a {@code double} range.
   *
   * @param min the minimum value, inclusive
   * @param max the maximum value, inclusive
   * @return a {@code double} range
   * @since 1.0.0
   */
  static @NonNull DoubleRange between(final double min, final double max) {
    return new DoubleRangeImpl(min, max);
  }

  /**
   * Gets the minimum value, inclusive.
   *
   * @return the minimum value, inclusive
   * @since 1.0.0
   */
  double min();

  /**
   * Gets the maximum value, inclusive.
   *
   * @return the maximum value, inclusive
   * @since 1.0.0
   */
  double max();
}
