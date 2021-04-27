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
package net.kaoaki.ksl.reflection;

import java.lang.reflect.Type;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * A collection of utilities for working with {@link Type}s.
 *
 * @since 1.0.0
 */
public final class Types {
  private Types() {
  }

  /**
   * Gets a stream of all ancestors of {@code type}.
   *
   * @param type the source type
   * @param <T> the class type
   * @return a stream of ancestors
   * @since 1.0.0
   */
  public static <T> @NonNull Stream<Class<? super T>> ancestors(final @NonNull Class<T> type) {
    return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
      new AncestorsIterator<>(type),
      Spliterator.DISTINCT | Spliterator.ORDERED | Spliterator.NONNULL | Spliterator.IMMUTABLE
    ), false);
  }
}
