import java.util.*;

public class SelectionSort {
    public static void main(String[] args) {
        String[] corpora = {"corpus1.txt", "corpus2.txt", "corpus3.txt"}; // Nomes dos arquivos de corpus

        for (String corpus : corpora) {
            CorpusReader corpusReader = new CorpusReader(corpus);
            List<String> words = corpusReader.readCorpus();

            List<String> sortedWords = selectionSort(words);

            // Restante do código para processar a lista de palavras ordenadas...
        }
    }

    /*
     * Função
     */
    public static List<String> selectionSort(List<String> words) {
        List<String> sortedWords = new ArrayList<>();

        while (!words.isEmpty()) {
            String selectedWord = selectWord(words);
            sortedWords.add(selectedWord);
            words.remove(selectedWord);
        }

        return sortedWords;
    }

    private static String selectWord(List<String> words) {
        String selectedWord = words.get(0);

        for (int i = 1; i < words.size(); i++) {
            String currentWord = words.get(i);

            // Compara as palavras pela frequência (em ordem decrescente)
            int frequencyComparison = compareByFrequency(currentWord, selectedWord);

            // Se houver empate na frequência, compara as palavras lexicograficamente
            if (frequencyComparison == 0) {
                if (currentWord.compareTo(selectedWord) < 0) {
                    selectedWord = currentWord;
                }
            }
            // Caso a frequência seja maior, atualiza a palavra selecionada
            else if (frequencyComparison > 0) {
                selectedWord = currentWord;
            }
        }

        return selectedWord;
    }

    private static int compareByFrequency(String word1, String word2) {
        int frequency1 = Collections.frequency(words, word1);
        int frequency2 = Collections.frequency(words, word2);
        return Integer.compare(frequency2, frequency1); // Ordem decrescente
    }
}