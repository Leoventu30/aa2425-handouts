/*

Copyright 2024 Massimo Santini

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

package it.unimi.di.prog2.e03;

/**
 * Vedi <a
 * href="https://github.com/mapio/labprog/blob/master/esercizi/genera_quadrato_magico/Testo.md">testo</a>,
 */

@SuppressWarnings("unused")
public class GeneraQuadratoMagico {

  public static void main(String[] args) {
    int N = Integer.parseInt(args[0]);
    GeneraQuadratoMagico gqm = new GeneraQuadratoMagico();
    gqm.genera(N);
  }

  private void genera(int n) {
    int[][] matrice = new int[n][n];
    Integer x = 0, y = 0;
    y = Math.round(n / 2);
    for (int i = 1; i <= Math.pow(n, 2); i++) {
      matrice[x][y] = i;

      int nX = (x - 1 + n) % n;
      int nY = (y + 1) % n;

      if (matrice[nX][nY] != 0) {
        nX = (x + 1) % n;
        nY = y;
      }

      x = nX;
      y = nY;
    }
    for (int i = 0; i < n; i++) {
      for (int p = 0; p < n; p++) {
        System.out.print(" " + matrice[i][p]);
      }
      System.out.println("");
    }
  }
}
