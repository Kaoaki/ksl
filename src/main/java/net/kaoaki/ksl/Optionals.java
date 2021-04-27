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
package net.kaoaki.ksl;

import java.util.Optional;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * {@link Optional}s.
 *
 * @since 1.0.0
 */
public final class Optionals {
  private Optionals() {
  }

  /**
   * Casts {@code optional} to an optional of type {@code type} if the value held by {@code optional} is an instance of {@code type}.
   *
   * @param optional the optional
   * @param type the type
   * @param <T> the type
   * @return the optional
   * @since 1.0.0
   */
  @SuppressWarnings("unchecked")
  public static <T> @NonNull Optional<T> cast(final @NonNull Optional<?> optional, final @NonNull Class<T> type) {
    return isInstance(optional, type)
      // not necessary to re-wrap, we can just cast
      ? (Optional<T>) optional
      : Optional.empty();
  }

  /**
   * Tests if the value held by {@code optional} is an instance of {@code type}.
   *
   * @param optional the optional
   * @param type the type
   * @return {@code true} if the value held by {@code optional} is an instance of {@code type}, {@code false} otherwise
   * @since 1.0.0
   */
  public static boolean isInstance(final @NonNull Optional<?> optional, final @NonNull Class<?> type) {
    return optional.isPresent() && type.isInstance(optional.get());
  }
}
