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

package it.unimi.di.prog2.e06;

import java.io.IOException;
import java.util.ArrayList;

/** Esercizio 4.3 di PDJ. */
public class SumClient {

  /** . */
  private SumClient() {}
public static void main(String[] args) throws IOException{
    
    ArrayList<Integer> numeri = new ArrayList<Integer>();
    /*
     * non capisco come vengono passati i dati perchè non sono in input quindi non va lo scan
     * provando a fare args[0] e poi splittarlo non va
     */
    for(int i=0;i<args.length;i++){
      Integer numero = Integer.parseInt(args[i]);
      numeri.add(numero);
    }
    SumClient sumClient = new SumClient();
    System.out.println(sumClient.somma(numeri).toString());
  }


  private Integer somma(ArrayList<Integer> numeri){
    Integer somma=0;
    for(int i=0;i<numeri.size();i++){
      somma= somma + numeri.get(i);
    }
    return somma;
  }
}
