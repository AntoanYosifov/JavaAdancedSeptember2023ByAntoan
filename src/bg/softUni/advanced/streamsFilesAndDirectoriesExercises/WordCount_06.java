package bg.softUni.advanced.streamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class WordCount_06 {
    public static void main(String[] args) {

        String pathWords = "C:\\JavaSoftUniProjects\\JavaAdancedSeptember2023ByAntoan\\src\\bg\\softUni\\advanced\\streamsFilesAndDirectoriesExercises\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String pathText = "C:\\JavaSoftUniProjects\\JavaAdancedSeptember2023ByAntoan\\src\\bg\\softUni\\advanced\\streamsFilesAndDirectoriesExercises\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String pathResult = "C:\\JavaSoftUniProjects\\JavaAdancedSeptember2023ByAntoan\\src\\bg\\softUni\\advanced\\streamsFilesAndDirectoriesExercises\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\result.txt";

        try (BufferedReader readerWords = new BufferedReader(new FileReader(pathWords));
             BufferedReader readerText = new BufferedReader(new FileReader(pathText));
             BufferedWriter writerResult = new BufferedWriter(new FileWriter(pathResult))) {
            Map<String, Integer> wordOccurrences = new TreeMap<>();

            String lineWords = readerWords.readLine();
            String[] words = lineWords.split(" ");

            for (String word : words) {
                wordOccurrences.put(word, 0);
            }

            String lineText = readerText.readLine();
            String[] textWords = lineText.split("[\\s,.]+");

            for (String word : textWords) {
                if (wordOccurrences.containsKey(word)) {
                    wordOccurrences.put(word, wordOccurrences.get(word) + 1);
                }
            }

            wordOccurrences.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue())).forEach(entry -> {
                try {
                    writerResult.write(entry.getKey() + " - " + entry.getValue() + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
