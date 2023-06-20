import java.util.*;

import entry.FileReaderEntry;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        String[] corpora = {"corpus1.txt", "corpus2.txt", "corpus3.txt"}; // Nomes dos arquivos de corpus

        for (String corpus : corpora) {
            FileReaderEntry corpusReader = new FileReaderEntry(corpus);
            List<String> words = corpusReader.readCorpus();

            GreedyResult result = runGreedyAlgorithm(words);

            // Restante do código para processar o resultado do algoritmo guloso...
        }
    }

    public static GreedyResult runGreedyAlgorithm(List<String> words) {
        Map<String, Integer> wordFrequency = countWordFrequency(words);

        List<String> lexicographicallySortedWords = sortLexicographically(words);
        List<String> frequencySortedWords = sortByFrequency(wordFrequency);

        return new GreedyResult(lexicographicallySortedWords, frequencySortedWords);
    }

    private static Map<String, Integer> countWordFrequency(List<String> words) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        return wordFrequency;
    }

    private static List<String> sortLexicographically(List<String> words) {
        List<String> sortedWords = new ArrayList<>(words);
        Collections.sort(sortedWords);
        return sortedWords;
    }

    private static List<String> sortByFrequency(Map<String, Integer> wordFrequency) {
        List<String> sortedWords = new ArrayList<>(wordFrequency.keySet());
        sortedWords.sort((word1, word2) -> {
            int freqComparison = wordFrequency.get(word2).compareTo(wordFrequency.get(word1));
            if (freqComparison != 0) {
                return freqComparison;
            } else {
                return word1.compareTo(word2);
            }
        });
        return sortedWords;
    }
}