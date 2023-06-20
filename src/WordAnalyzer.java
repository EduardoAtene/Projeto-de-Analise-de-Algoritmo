import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import entry.FileReaderEntry;

public class WordAnalyzer {
    public static void main(String[] args) {
        String[] palavrasFiles = FileReaderEntry.getPalavrasFiles();
        for (String palavraFileUnique : palavrasFiles) {
            FileReaderEntry fileReader =  new FileReaderEntry(palavraFileUnique);
            List<String> words = fileReader.readCorpus();


            // Medição de tempo para lista lexicograficamente ordenada
            long startTimeLexicographic = System.nanoTime();
            List<String> lexicographicSorted = lexicographicSort(words);
            long endTimeLexicographic = System.nanoTime();
            long durationLexicographic = endTimeLexicographic - startTimeLexicographic;

            // Medição de tempo para lista ordenada por frequência
            long startTimeFrequency = System.nanoTime();
            List<String> frequencySorted = frequencySort(words);
            long endTimeFrequency = System.nanoTime();
            long durationFrequency = endTimeFrequency - startTimeFrequency;

            // Exibir resultados
            // System.out.println("Corpus: " + palavraFileUnique);
            // System.out.println("Lista lexicograficamente ordenada: " + lexicographicSorted);
            System.out.println("Tempo médio (lexicográfico): " + durationLexicographic + " nanossegundos");
            // System.out.println("Lista ordenada por frequência: " + frequencySorted);
            System.out.println("Tempo médio (frequência): " + durationFrequency + " nanossegundos");
            System.out.println("----------------------------------------");
        }
    }

    private static List<String> lexicographicSort(List<String> words) {
        List<String> sortedWords = new ArrayList<>(words);
        Collections.sort(sortedWords);
        return sortedWords;
    }

    private static List<String> frequencySort(List<String> words) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        List<String> sortedWords = new ArrayList<>(words);
        sortedWords.sort((w1, w2) -> {
            int freqCompare = wordFrequency.get(w2).compareTo(wordFrequency.get(w1));
            if (freqCompare == 0) {
                return w1.compareTo(w2);
            }
            return freqCompare;
        });

        return sortedWords;
    }
}