package bg.softUni.advanced.streamsFilesAndDirectoriesExercises;

import java.io.*;

public class LineNumbers_05 {
    public static void main(String[] args) {

        String inputPath = "C:\\JavaSoftUniProjects\\JavaAdancedSeptember2023ByAntoan\\src\\bg\\softUni\\advanced\\streamsFilesAndDirectoriesExercises\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outputPath = "C:\\JavaSoftUniProjects\\JavaAdancedSeptember2023ByAntoan\\src\\bg\\softUni\\advanced\\streamsFilesAndDirectoriesExercises\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath))) {

            String line = bufferedReader.readLine();
            int counter = 0;
            while (line != null){
                counter++;
                bufferedWriter.write(counter + ". " + line);
                bufferedWriter.newLine();


                line = bufferedReader.readLine();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
