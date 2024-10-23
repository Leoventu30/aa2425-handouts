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
 * href="https://github.com/mapio/labprog/blob/master/esercizi/lettera_piu_frequente/Testo.md">testo</a>,
 */
import java.util.*;

/**
 * Vedi <a
 * href="https://github.com/mapio/labprog/blob/master/esercizi/lettera_piu_frequente/Testo.md">testo</a>,
 */
public class LetteraPiùFrequente {
  private Map<Character, Integer> elencoCaratteri;

  public LetteraPiùFrequente() {
    elencoCaratteri = new HashMap<Character, Integer>();
  }

  private void conteggia(char[] array) {
    for (int i = 0; i < array.length; i++) {
      // System.out.println(array[i]);
      if (this.elencoCaratteri.containsKey(array[i])) {
        int vecchioValore = elencoCaratteri.get(array[i]);
        int nuovoValore = vecchioValore + 1;
        elencoCaratteri.replace(array[i], vecchioValore, nuovoValore);
      } else {
        if (Character.isLetter(array[i])) {
          elencoCaratteri.put(array[i], 1);
        }
      }
    }
  }

  private Integer getMax() {
    Collection<Integer> elencoValori = elencoCaratteri.values();
    Integer valoreMassimo = Collections.max(elencoValori);
    return valoreMassimo;
  }

  public static void main(String[] args) {
    LetteraPiùFrequente lpf = new LetteraPiùFrequente();
    try (Scanner s = new Scanner(System.in)) {
      while (s.hasNext()) {
        final String parola = s.nextLine();
        char[] arrayCaratteri = parola.toCharArray();
        lpf.conteggia(arrayCaratteri);
      }
      System.out.println(lpf.getMax().toString());
    }
  }
}

