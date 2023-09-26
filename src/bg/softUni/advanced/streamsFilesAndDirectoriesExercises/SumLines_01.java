package bg.softUni.advanced.streamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumLines_01 {
    public static void main(String[] args) {
        String path = "C:\\JavaSoftUniProjects\\JavaAdancedSeptember2023ByAntoan\\src\\bg\\softUni\\advanced\\streamsFilesAndDirectoriesExercises\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader bf = new BufferedReader(new FileReader(path))){

            String line = bf.readLine();
            while (line != null){
                int sum = 0;
                for (char c : line.toCharArray()) {
                    sum += c;
                }

                line = bf.readLine();
                System.out.println(sum);
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
