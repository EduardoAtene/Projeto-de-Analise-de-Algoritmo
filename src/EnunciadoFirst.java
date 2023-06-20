import java.util.*;

import algoritm.MergeSort;
import algoritm.SelectionSort;
import entry.FileReaderEntry;
import entry.FileWriterEntry;

public class EnunciadoFirst {
    public static void main(String[] args) {
        String[] palavrasFiles = FileReaderEntry.getPalavrasFiles();
        for (String palavraFileUnique : palavrasFiles) {
            System.out.println("Processando Corpus " + palavraFileUnique + " ...");

            FileReaderEntry fileReader =  new FileReaderEntry(palavraFileUnique);
            List<String> words = fileReader.readCorpus();
            String[] wordsArray = words.toArray(new String[0]);
            String[] wordsArrayF = words.toArray(new String[0]);


            // Ordenação lexicográfica das palavras
            // 1 - Selection Sort
            // Algoritmo Guloso

            // Medição de tempo para lista lexicograficamente ordenada selection
            long inicioTempoLexiografo_S = System.nanoTime();
            SelectionSort.selectionSort(wordsArray);
            long finalTempoLexiografo_S = System.nanoTime();
            long duracaoOrdenacaoLexicográfico_S = finalTempoLexiografo_S - inicioTempoLexiografo_S;

            // Criar um arquivo com o resultado da ordenação acima
            String outputFileSO = "Corpus Ord L - Select - "+palavraFileUnique;
            FileWriterEntry.writeCorpus(SelectionSort.getStringOrdenada(), outputFileSO);


            // *Ordenação lexicográfica das palavras*
            // 2 - Marge Sorte
            // Algoritmo Divisão e Conquista

            // Medição de tempo para lista lexicograficamente ordenada marge
            long inicioTempoLexiografo_M = System.nanoTime();
            MergeSort.mergeSort(wordsArray);
            long finalTempoLexiografo_M = System.nanoTime();
            long duracaoOrdenacaoLexicográfico_M = finalTempoLexiografo_M - inicioTempoLexiografo_M;

            // Criar um arquivo com o resultado da ordenação acima
            String outputFileMO = "Corpus Ord L - Marge - "+palavraFileUnique;
            FileWriterEntry.writeCorpus(MergeSort.getStringOrdenada(), outputFileMO);

            /////////////////////

            // Ordenação por Frequencia das palavras
            // 1 - Selection Sort
            // Algoritmo Guloso

            // Medição de tempo 
            long inicioTempoFrequencia_S = System.nanoTime();
            SelectionSort.selectionSort(wordsArrayF);
            long finalTempoFrequencia_S = System.nanoTime();
            long duracaoOrdenacaoFrequencia_S = finalTempoFrequencia_S - inicioTempoFrequencia_S;

            // Criar um arquivo com o resultado da ordenação acima
            String outputFileSF = "Corpus Ord Freq- Select - "+palavraFileUnique;
            FileWriterEntry.writeCorpus(SelectionSort.getStringOrdenadaFrequenciaDesc(), outputFileSF);


            // Ordenação por Frequencia das palavras
            // 2 - Marge Sorte
            // Algoritmo Divisão e Conquista

            // Medição de tempo marg
            long inicioTempoFrequencia_M = System.nanoTime();
            MergeSort.mergeSortByFrequency(wordsArrayF);
            long finalTempoFrequencia_M = System.nanoTime();
            long duracaoOrdenacaoFrequencia_M = finalTempoFrequencia_M - inicioTempoFrequencia_M;

            // Criar um arquivo com o resultado da ordenação acima
            String outputFileMF = "Corpus Ord Freq - Marge - "+palavraFileUnique;
            FileWriterEntry.writeCorpus(MergeSort.getStringOrdenada(), outputFileMF);


            //  resultados lexiograficamente
            System.out.println("Palavras ordenadas Lexicograficamente: ");
            System.out.println("Tempo médio Selection Sort (lexicográfico): " + duracaoOrdenacaoLexicográfico_S + " nanossegundos");
            System.out.println("Tempo médio Marge     Sort (lexicográfico): " + duracaoOrdenacaoLexicográfico_M + " nanossegundos");

            //  resultados frequencia
            System.out.println("Palavras ordenadas por Frequência: ");
            System.out.println("Tempo médio Selection Sort (frequencia): " + duracaoOrdenacaoFrequencia_S + " nanossegundos");
            System.out.println("Tempo médio Marge     Sort (frequencia): " + duracaoOrdenacaoFrequencia_M + " nanossegundos");

            System.out.println("----------------------------------------");
            System.out.println();

        }
    }

}