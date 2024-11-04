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

package it.unimi.di.prog2.e05;

import java.util.ArrayList;
import java.util.Scanner;

/** Esercizio 3.2 di PDJ.
 * 
 * @author Corrado Francesco Emanuele
 */
public class SumClient {

  /**
   * Sums the elements of a int[] array and returns the result
   * 
   * @param a an array of int
   * @return sum of the values of a
   */

  public static int sum (int[] a){
    //MODIFIES: result
    //EFFECTS: Sums all the elements of a and saves the result in result
    int s=0;
    for (int i=0; i < a.length; i++){
      s += a[i];
    }
    return s;
  }

  public static void main(String[] args) {
    ArrayList<String> valueList = new ArrayList<>();
    try (Scanner s = new Scanner(System.in)){
      while (s.hasNextLine()){
        String number = s.nextLine();
        valueList.add(number);
      }
    }
    String[] values = valueList.toArray(String[]::new);
      int[] numbers = new int[values.length];
      for (int i=0; i < values.length; i++){
        numbers[i] = Integer.parseInt(values[i]);
      }
      int result = sum(numbers);
      System.out.println(result);
  }

  /** . */
  private SumClient() {}

  // Aggiunga qui un main che invochi il metodo sum (che può sviluppare in
  // questa o altra classe) descritto dall'esercizio 3.2 di PDJ.

  // Il main riceve un elenco di interi come parametri sulla linea di comando e
  // ne emette la somma nel flusso d'ingresso.

}
