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

package it.unimi.di.prog2.e04;
import java.math.BigInteger;
import java.util.Scanner;
/**
 * Vedi <a
 * href="https://github.com/mapio/labprog/blob/master/esercizi/somma_strana/Testo.md">testo</a>,
 * ma leggendo gli addendi dal flusso di ingresso.
*/
public class SommaStrana {
  private BigInteger n1, n2;
  /** . */ private SommaStrana(BigInteger n1, BigInteger n2) {
    this.n1= n1;
    this.n2=n2;
  }

  public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      BigInteger numero1 = new BigInteger(sc.nextLine());
      BigInteger numero2 = new BigInteger(sc.nextLine());
      sc.close();
      SommaStrana ss = new SommaStrana(numero1,numero2);
      BigInteger somma = ss.somma();
      System.out.println(somma.toString(0));
  }

  private BigInteger somma(){
        String str1 = this.n1.toString();
        String str2 = this.n2.toString();
        while (str1.length() < str2.length()) str1 = "0" + str1;
        while (str2.length() < str1.length()) str2 = "0" + str2;
        StringBuilder risultato = new StringBuilder();
        int riporto = 0; 
        for (int i = str1.length() - 1; i >= 0; i--) {

            int cifra1 = str1.charAt(i) - '0';
            int cifra2 = str2.charAt(i) - '0';
            int somma = cifra1 + cifra2 + riporto;

            if (somma >= 10) {
                int cifraRisultato = 9 - (somma % 10);
                risultato.append(cifraRisultato);
                riporto = 1; 
            } else {
                risultato.append(somma);  
                riporto = 0; 
            }
        }
        if (riporto > 0) {
            risultato.append(riporto);
        }
        return new BigInteger(risultato.reverse().toString()); 
  }
}