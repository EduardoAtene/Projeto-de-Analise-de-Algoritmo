import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWriterEntry {
    private String outputFolder;

    public FileWriterEntry(String outputFolder) {
        this.outputFolder = outputFolder;
    }

    public void writeCorpus(List<String> words, String outputFile) {
        String filePath = outputFolder + "/" + outputFile;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String word : words) {
                writer.write(word);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}