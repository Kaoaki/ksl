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
package net.kaoaki.ksl.math.range.f;

import java.util.Random;
import net.kaoaki.ksl.math.Mth;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

final class ConstantFloatImpl implements ConstantFloat {
  private final float value;

  ConstantFloatImpl(final float value) {
    this.value = value;
  }

  @Override
  public float value() {
    return this.value;
  }

  @Override
  public boolean test(final float value) {
    return Mth.equals(value, this.value);
  }

  @Override
  public float getFloat(final @NonNull Random random) {
    return this.value; // intentionally not random
  }

  @Override
  public String toString() {
    return "ConstantFloat[value=" + this.value + "]";
  }

  @Override
  public boolean equals(final @Nullable Object other) {
    if(this == other) return true;
    if(other == null || this.getClass() != other.getClass()) return false;
    final ConstantFloatImpl that = (ConstantFloatImpl) other;
    return Mth.equals(this.value, that.value);
  }

  @Override
  public int hashCode() {
    return Float.hashCode(this.value);
  }
}
