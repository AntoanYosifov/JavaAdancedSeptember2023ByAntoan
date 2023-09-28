package bg.softUni.advanced.streamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

public class CountCharacterTypes_04 {
    public static void main(String[] args) {
        String inputPath = "C:\\JavaSoftUniProjects\\JavaAdancedSeptember2023ByAntoan\\src\\bg\\softUni\\advanced\\streamsFilesAndDirectoriesExercises\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\JavaSoftUniProjects\\JavaAdancedSeptember2023ByAntoan\\src\\bg\\softUni\\advanced\\streamsFilesAndDirectoriesExercises\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuation = Set.of('!', ',', '.', '?');


        try (BufferedReader reader = Files.newBufferedReader(Path.of(inputPath));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath))) {
            int vowelsCount = 0;
            int punctuationsCount = 0;
            int othersCount = 0;

            String line = reader.readLine();
            while (line != null) {
                for (char c : line.toCharArray()) {

                    if (vowels.contains(c)) {
                        vowelsCount++;
                    } else if (punctuation.contains(c)) {
                        punctuationsCount++;
                    } else if (c != ' ') {
                        othersCount++;
                    }
                }


                line = reader.readLine();

            }
            writer.write(String.format("Vowels: %d\n" +
                    "Other symbols: %d\n" +
                    "Punctuation: %d", vowelsCount, othersCount, punctuationsCount
            ));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
