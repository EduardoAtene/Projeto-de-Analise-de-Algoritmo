package algoritm;

import java.util.HashMap;
import java.util.Map;

public class MergeSort {

  private static String[] stringOrdenada;
  private static String[] stringOrdenadaFrequenciaDesc;

  public static String[] getStringOrdenada(){
    return MergeSort.stringOrdenada;
  }
  public static String[] getStringOrdenadaFrequenciaDesc(){
    return MergeSort.stringOrdenadaFrequenciaDesc;
  }

  /**
   * Método que ordena um vetor de strings / curpos lido no arquivo files
   * Usando margesort
   * 
   * @param strings - Vetor de strings.
   */
  public static void mergeSort(String[] strings) {
    MergeSort.stringOrdenada = strings;
    mergeSort(MergeSort.stringOrdenada, 0, MergeSort.stringOrdenada.length - 1);
  }

  /**
   * Usar recursividade na função amrge. Inicio/Fim
   * Divisão/Conquista
   * 
   * @param strings - Vetor de strings.
   * @param int - inicio.
   * @param int - fim.
   */
  private static void mergeSort(String[] strings, int inicio, int fim) {
    // caso o inciio forr menor que o fim
    if (inicio < fim) {
      // pegar a metade
      int meio = (inicio + fim) / 2;
      
      // left margee
      mergeSort(strings, inicio, meio);
      // rifht marge
      mergeSort(strings, meio + 1, fim);
      
      // fazer procedimento
      merge(strings, inicio, meio, fim);
    }
  }
  
  private static void merge(String[] strings, int inicio, int meio, int fim) {
    int n1 = meio - inicio + 1;
    int n2 = fim - meio;
    
    String[] leftArray = new String[n1];
    String[] rightArrayyy = new String[n2];
    
    for (int i = 0; i < n1; i++) {
      leftArray[i] = strings[inicio + i];
    }
    for (int j = 0; j < n2; j++) {
      rightArrayyy[j] = strings[meio + 1 + j];
    }
    
    int i = 0, j = 0;
    int k = inicio;
    
    // comparar
    while (i < n1 && j < n2) {
      if (leftArray[i].compareTo(rightArrayyy[j]) <= 0) {
        strings[k] = leftArray[i];
        i++;
      } else {
        strings[k] = rightArrayyy[j];
        j++;
      }
      k++;
    }
    
    while (i < n1) {
      strings[k] = leftArray[i];
      i++;
      k++;
    }
    
    while (j < n2) {
      strings[k] = rightArrayyy[j];
      j++;
      k++;
    }
  }


  // Frquencia

  public static void mergeSortByFrequency(String[] words) {
      MergeSort.stringOrdenadaFrequenciaDesc = words;

      Map<String, Integer> frequenciaMap = new HashMap<>();
      for (String word : MergeSort.stringOrdenadaFrequenciaDesc) {
          frequenciaMap.put(word, frequenciaMap.getOrDefault(word, 0) + 1);
      }

      mergeSortByFrequency(MergeSort.stringOrdenadaFrequenciaDesc, 0, MergeSort.stringOrdenadaFrequenciaDesc.length - 1, frequenciaMap);

  }

  /**
   * Usar recursividade na função marge por frequenciaa
   * Divisão/Conquista
   * 
   * @param strings - Vetor de strings.
   * @param int - inicio.
   * @param int - fim.
   * @param Map<String, Integer> - frequencyMap.  

    */
  private static void mergeSortByFrequency(String[] words, int start, int end, Map<String, Integer> frequencyMap) {
    if (start < end) {
        int mid = (start + end) / 2;

        mergeSortByFrequency(words, start, mid, frequencyMap);
        mergeSortByFrequency(words, mid + 1, end, frequencyMap);

        mergeByFrequency(words, start, mid, end, frequencyMap);
    }
  }

  private static void mergeByFrequency(String[] words, int start, int mid, int end, Map<String, Integer> frequencyMap) {
    int leftLength = mid - start + 1;
    int rightLength = end - mid;

    String[] leftArray = new String[leftLength];
    String[] rightArray = new String[rightLength];

    for (int i = 0; i < leftLength; i++) {
        leftArray[i] = words[start + i];
    }
    for (int j = 0; j < rightLength; j++) {
        rightArray[j] = words[mid + 1 + j];
    }

    int i = 0, j = 0;
    int k = start;

    while (i < leftLength && j < rightLength) {
        String word1 = leftArray[i];
        String word2 = rightArray[j];

        // Comparação por frequência
        int frequencyCompare = frequencyMap.get(word1).compareTo(frequencyMap.get(word2));

        if (frequencyCompare > 0 || (frequencyCompare == 0 && word1.compareTo(word2) < 0)) {
            words[k] = leftArray[i];
            i++;
        } else {
            words[k] = rightArray[j];
            j++;
        }
        k++;
    }

    while (i < leftLength) {
        words[k] = leftArray[i];
        i++;
        k++;
    }

    while (j < rightLength) {
        words[k] = rightArray[j];
        j++;
        k++;
    }
  }
}