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
package net.kaoaki.ksl.math;

import java.util.Random;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * 2 plus 2 equals 5... right?
 *
 * @since 1.0.0
 */
public final class Mth {
  private Mth() {
  }

  /**
   * Clamps {@code value} between {@code min} and {@code max}.
   *
   * @param value the value
   * @param min the min value
   * @param max the max value
   * @return the clamped value
   * @since 1.0.0
   */
  @SuppressWarnings("ManualMinMaxCalculation") // intentional
  public static double clamp(final double value, final double min, final double max) {
    if(value < min) return min;
    if(value > max) return max;
    return value;
  }

  /**
   * Clamps {@code value} between {@code min} and {@code max}.
   *
   * @param value the value
   * @param min the min value
   * @param max the max value
   * @return the clamped value
   * @since 1.0.0
   */
  @SuppressWarnings("ManualMinMaxCalculation") // intentional
  public static float clamp(final float value, final float min, final float max) {
    if(value < min) return min;
    if(value > max) return max;
    return value;
  }

  /**
   * Clamps {@code value} between {@code min} and {@code max}.
   *
   * @param value the value
   * @param min the min value
   * @param max the max value
   * @return the clamped value
   * @since 1.0.0
   */
  @SuppressWarnings("ManualMinMaxCalculation") // intentional
  public static int clamp(final int value, final int min, final int max) {
    if(value < min) return min;
    if(value > max) return max;
    return value;
  }

  /**
   * Clamps {@code value} between {@code min} and {@code max}.
   *
   * @param value the value
   * @param min the min value
   * @param max the max value
   * @return the clamped value
   * @since 1.0.0
   */
  @SuppressWarnings("ManualMinMaxCalculation") // intentional
  public static long clamp(final long value, final long min, final long max) {
    if(value < min) return min;
    if(value > max) return max;
    return value;
  }

  // todo(kashike): should the 'between' methods have an 'is' prefix?

  /**
   * Checks if {@code value} is greater than or equal to {@code min} and less than or equal to {@code max}.
   *
   * @param value the value
   * @param min the min value, inclusive
   * @param max the max value, inclusive
   * @return {@code true} if between {@code min} and {@code max}, {@code false} otherwise
   * @since 1.0.0
   */
  public static boolean between(final double value, final double min, final double max) {
    return min <= value && value <= max;
  }

  /**
   * Checks if {@code value} is greater than or equal to {@code min} and less than or equal to {@code max}.
   *
   * @param value the value
   * @param min the min value, inclusive
   * @param max the max value, inclusive
   * @return {@code true} if between {@code min} and {@code max}, {@code false} otherwise
   * @since 1.0.0
   */
  public static boolean between(final float value, final float min, final float max) {
    return min <= value && value <= max;
  }

  /**
   * Checks if {@code value} is greater than or equal to {@code min} and less than or equal to {@code max}.
   *
   * @param value the value
   * @param min the min value, inclusive
   * @param max the max value, inclusive
   * @return {@code true} if between {@code min} and {@code max}, {@code false} otherwise
   * @since 1.0.0
   */
  public static boolean between(final int value, final int min, final int max) {
    return min <= value && value <= max;
  }

  /**
   * Checks if {@code value} is greater than or equal to {@code min} and less than or equal to {@code max}.
   *
   * @param value the value
   * @param min the min value, inclusive
   * @param max the max value, inclusive
   * @return {@code true} if between {@code min} and {@code max}, {@code false} otherwise
   * @since 1.0.0
   */
  public static boolean between(final long value, final long min, final long max) {
    return min <= value && value <= max;
  }

  // todo(kashike): extract logic to common method, add new interface for getters

  /**
   * Gets a random value between {@code min} and {@code max}.
   *
   * @param random the random source
   * @param min the minimum value, inclusive
   * @param max the maximum value, inclusive
   * @return a value
   * @since 1.0.0
   */
  public static double random(final @NonNull Random random, final double min, final double max) {
    return (random.nextDouble() * (max - min)) + min;
  }

  /**
   * Gets a random value between {@code min} and {@code max}.
   *
   * @param random the random source
   * @param min the minimum value, inclusive
   * @param max the maximum value, inclusive
   * @return a value
   * @since 1.0.0
   */
  public static float random(final @NonNull Random random, final float min, final float max) {
    return (random.nextFloat() * (max - min)) + min;
  }

  /**
   * Gets a random value between {@code min} and {@code max}.
   *
   * @param random the random source
   * @param min the minimum value, inclusive
   * @param max the maximum value, inclusive
   * @return a value
   * @since 1.0.0
   */
  public static int random(final @NonNull Random random, final int min, final int max) {
    return random.nextInt((max - min) + 1) + min;
  }

  /**
   * Squares {@code n}.
   *
   * @param n the value to square
   * @return the squared value
   * @since 1.0.0
   */
  public static double square(final double n) {
    return n * n;
  }

  /**
   * Squares {@code n}.
   *
   * @param n the value to square
   * @return the squared value
   * @since 1.0.0
   */
  public static float square(final float n) {
    return n * n;
  }

  /**
   * Squares {@code n}.
   *
   * @param n the value to square
   * @return the squared value
   * @since 1.0.0
   */
  public static int square(final int n) {
    return n * n;
  }

  /**
   * Tests if {@code a} equals {@code b}, using {@link Double#doubleToLongBits(double)}.
   *
   * @param a the first number
   * @param b the first number
   * @return {@code true} if {@code a} equals {@code b}, otherwise {@code false}
   * @since 1.0.0
   */
  public static boolean equals(final double a, final double b) {
    return Double.doubleToLongBits(a) == Double.doubleToLongBits(b);
  }

  /**
   * Tests if {@code a} equals {@code b}, using {@link Float#floatToIntBits(float)}.
   *
   * @param a the first number
   * @param b the first number
   * @return {@code true} if {@code a} equals {@code b}, otherwise {@code false}
   * @since 1.0.0
   */
  public static boolean equals(final float a, final float b) {
    return Float.floatToIntBits(a) == Float.floatToIntBits(b);
  }
}
