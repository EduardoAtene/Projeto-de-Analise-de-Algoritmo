package entry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderEntry {
    private String palavrasFileUnique;
    private static String[] palavrasFiles = {
            "src/files/palavras_100k.txt",
            "src/files/palavras_200k.txt",
            "src/files/palavras_300k.txt",
            "src/files/palavras_400k.txt",
            "src/files/palavras_500k.txt",
            "src/files/palavras_600k.txt",
            "src/files/palavras_700k.txt"
    }; // Nomes dos arquivos de corpus

    public FileReaderEntry(String palavrasFileUnique) 
    {
        this.palavrasFileUnique = palavrasFileUnique;
    }

    public static String[] getPalavrasFiles(){
        return FileReaderEntry.palavrasFiles;
    }
    public List<String> readCorpus() {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(palavrasFileUnique))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.trim().split("\\s+");
                for (String word : lineWords) {
                    words.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
}





