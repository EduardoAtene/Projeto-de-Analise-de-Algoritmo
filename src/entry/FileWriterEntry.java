package entry;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileWriterEntry {
    private static String outputFolder = "src/filesResults";

    /*
     * Escrever os arquivos gerados nas ordenaçãoes/frequencia em um arquivo
     */
    public static void writeCorpus(String[] words, String outputFile) {
        List<String> wordsList = Arrays.asList(words);
        String filePath = FileWriterEntry.outputFolder + "/" + outputFile;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String word : wordsList) {
                writer.write(word);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
