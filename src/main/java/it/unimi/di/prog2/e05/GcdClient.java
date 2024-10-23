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

import java.util.Scanner;

/** Esercizio 3.1 di PDJ. */
public class GcdClient {

  /** . */
  private GcdClient() {}
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      do{
        String linea = sc.nextLine();
        String[] riga = linea.split(" ");
        int n1 = Integer.parseInt(riga[0]);
        int n2 = Integer.parseInt(riga[1]);
        System.out.println(GcdClient.gcd(n1,n2));
      }while(sc.hasNext());
      
    }
    
  
  public static int gcd(int a, int b){
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
  }
  return a;
  }
  // Aggiunga qui un main che invochi il metodo gcd (che può sviluppare in
  // questa o altra classe) descritto dall'esercizio 3.1 di PDJ.

  // Il main legge dal flusso di ingresso coppie di numeri ed emette nel flusso
  // d'uscita il loro gcd.

}
