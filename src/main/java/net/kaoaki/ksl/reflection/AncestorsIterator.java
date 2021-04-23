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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.Nullable;

final class AncestorsIterator<T> implements Iterator<Class<? super T>> {
  private final Deque<Class<? super T>> types = new ArrayDeque<>();
  private final Set<Class<? super T>> seen = new HashSet<>();

  AncestorsIterator(final Class<? super T> type) {
    this.types.add(type);
  }

  @Override
  public boolean hasNext() {
    return !this.types.isEmpty();
  }

  @Override
  public Class<? super T> next() {
    final Class<? super T> type = this.types.remove();
    this.add(type.getSuperclass());
    this.addAll(type.getInterfaces());
    return type;
  }

  @SuppressWarnings("unchecked")
  private void addAll(final Class<?>... types) {
    final int length = types.length;
    if(length > 0) {
      for(int i = 0; i < length; i++) {
        this.add((Class<? super T>) types[i]);
      }
    }
  }

  private void add(final @Nullable Class<? super T> type) {
    if(type != null) {
      if(this.seen.add(type)) {
        this.types.add(type);
      }
    }
  }
}
