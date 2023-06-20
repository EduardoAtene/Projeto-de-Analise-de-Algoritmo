package algoritm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SelectionSort {

    private static String[] stringOrdenada;
    private static String[] stringOrdenadaFrequenciaDesc;

    public static String[] getStringOrdenada(){
        return SelectionSort.stringOrdenada;
    }
    public static String[] getStringOrdenadaFrequenciaDesc(){
        return SelectionSort.stringOrdenadaFrequenciaDesc;
    }

    /*
     * Função Selection Sorte. Ordena de forma lexiograficamente. de A até Z
     */
    public static void selectionSort(String[] words) {
        SelectionSort.stringOrdenada = words;
        String[] sortedWords = Arrays.copyOf(SelectionSort.stringOrdenada, SelectionSort.stringOrdenada.length);

        // Percorrer
        for (int i = 0; i < sortedWords.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < sortedWords.length; j++) {
                String word1 = sortedWords[j];
                String word2 = sortedWords[minIndex];

                // Compara as palavras lexicograficamente
                if (word1.compareTo(word2) < 0) {
                    minIndex = j;
                }
            }

            // Troca a posição da palavra encontrada com a posição atual. Caso for diferente mpinima
            if (minIndex != i) {
                String temp = sortedWords[i];
                sortedWords[i] = sortedWords[minIndex];
                sortedWords[minIndex] = temp;
            }
        }

        SelectionSort.stringOrdenada = sortedWords;
    }
    
    /*
     * Função Selection Sort. Ordena Por Frequencia Decrescente
     */
    public static void selectionSortByFrequency(String[] words) {
        SelectionSort.stringOrdenadaFrequenciaDesc = words;

        Map<String, Integer> frequenciaMap = new HashMap<>();
        for (String word : SelectionSort.stringOrdenadaFrequenciaDesc) {
            frequenciaMap.put(word, frequenciaMap.getOrDefault(word, 0) + 1);
        }

        String[] sortWordsAuxx = Arrays.copyOf(SelectionSort.stringOrdenadaFrequenciaDesc, 
                                            SelectionSort.stringOrdenadaFrequenciaDesc.length);

        for (int i = 0; i < sortWordsAuxx.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < sortWordsAuxx.length; j++) {
                String word1 = sortWordsAuxx[j];
                String word2 = sortWordsAuxx[maxIndex];

                // Comparação por frequência
                int frequenciaComparar = frequenciaMap.get(word1).compareTo(frequenciaMap.get(word2));

                if (frequenciaComparar > 0 || (frequenciaComparar == 0 && word1.compareTo(word2) < 0)) {
                    maxIndex = j;
                }
            }
            // Troca a posição da palavra encontrada com a posição atual. Caso for diferente mpinima
//a
            if (maxIndex != i) {
                String temp = sortWordsAuxx[i];
                sortWordsAuxx[i] = sortWordsAuxx[maxIndex];
                sortWordsAuxx[maxIndex] = temp;
            }
        }

        SelectionSort.stringOrdenadaFrequenciaDesc = sortWordsAuxx;
    }
}