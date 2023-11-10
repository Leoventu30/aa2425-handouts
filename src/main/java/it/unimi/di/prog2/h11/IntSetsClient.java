/*

Copyright 2021 Luca Prigioniero, Massimo Santini
Copyright 2023 Massimo Santini

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

package it.unimi.di.prog2.h11;

public class IntSetsClient {

  public static void main(String args[]) {
    IntSet C, S = new IntSet(), T = new IntSet();
    C = S;
    for (String s : args) {
      if (s.equals("-")) {
        C = T;
        continue;
      }
      int x = Integer.parseInt(s);
      C.insert(x);
    }
    System.out.println(S.equals(T));
  }
}
