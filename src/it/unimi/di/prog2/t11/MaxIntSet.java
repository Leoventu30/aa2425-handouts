/*

Copyright 2022 Massimo Santini

This file is part of "Programmazione 2 @ UniMI" teaching material.

This is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This material is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this file.  If not, see <https://www.gnu.org/licenses/>.

*/

package it.unimi.di.prog2.t11;

import it.unimi.di.prog2.t07.spec.EmptyException;
import it.unimi.di.prog2.t10.IntSet;
import java.util.Iterator;

/**
 * Esempio di {@code MaxIntSet} tratto dalla sezione 7.4 del libro di testo di Liskov <em>et
 * al.</em>.
 *
 * <p><b>Attenzione</b>: questa classe estende {@link it.unimi.di.prog2.t10.IntSet} che corrisponde
 * all'implementazione di {@link it.unimi.di.prog2.t08.IntSet} a cui è stato aggiunto un iteratore.
 */
public class MaxIntSet extends IntSet {

  /** The biggest element, if set is not empty */
  private int biggest;

  // RI: size() == 0 oppure isIn(biggest) e per ogni x isIn(x) implica biggest >= x.
  // AF: coincide con quella di IntSet

  /** Construct an empty {@code MaxIntSet}. */
  public MaxIntSet() {
    super();
  }

  @Override
  public void insert(final int x) {
    if (size() == 0 || x > biggest) biggest = x;
    super.insert(x);
  }

  @Override
  public void remove(final int x) {
    super.remove(x);
    if (size() == 0 || x < biggest) return;
    Iterator<Integer> g = iterator();
    biggest = g.next();
    while (g.hasNext()) {
      final int z = g.next();
      if (z > biggest) biggest = z;
    }
  }

  /**
   * Returns the maximum value in the set, or rises {@link EmptyException} otherwise.
   *
   * @return the maximum value in the set.
   * @throws EmptyException if the set is empty.
   */
  public int max() throws EmptyException {
    if (size() == 0) throw new EmptyException();
    return biggest;
  }

  public boolean repOk() {
    // non serve controllare super.repok() perché non c'è condivisione di stato
    if (size() == 0) return true;
    boolean found = false;
    for (int z : this) {
      if (z > biggest) return false;
      if (z == biggest) found = true;
    }
    return found;
  }

  @Override
  public String toString() {
    if (size() == 0) return "Max" + super.toString();
    else return "Max" + super.toString() + ", max = " + biggest;
  }
}
