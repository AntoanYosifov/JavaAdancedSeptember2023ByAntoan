package bg.softUni.advanced.streamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes_02 {
    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new FileReader("C:\\JavaSoftUniProjects\\JavaAdancedSeptember2023ByAntoan\\src\\bg\\softUni\\advanced\\streamsFilesAndDirectoriesExercises\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"))) {
            long sum = 0;
            String line = br.readLine();

            while(line != null){
                for (char c : line.toCharArray()) {
                    sum += c;
                }
                line = br.readLine();
            }
            System.out.println(sum);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
