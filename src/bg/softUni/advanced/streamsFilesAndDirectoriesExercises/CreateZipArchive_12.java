package bg.softUni.advanced.streamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive_12 {
    public static void main(String[] args) {
        String path1 = "C:\\JavaSoftUniProjects\\JavaAdancedSeptember2023ByAntoan\\src\\bg\\softUni\\advanced\\streamsFilesAndDirectoriesExercises\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String path2 = "C:\\JavaSoftUniProjects\\JavaAdancedSeptember2023ByAntoan\\src\\bg\\softUni\\advanced\\streamsFilesAndDirectoriesExercises\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String path3 = "C:\\JavaSoftUniProjects\\JavaAdancedSeptember2023ByAntoan\\src\\bg\\softUni\\advanced\\streamsFilesAndDirectoriesExercises\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\JavaSoftUniProjects\\JavaAdancedSeptember2023ByAntoan\\src\\bg\\softUni\\advanced\\streamsFilesAndDirectoriesExercises\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\files.zip";

        List<String> paths = List.of(path1, path2, path3);

        try (FileOutputStream fileOutputStream = new FileOutputStream(outputPath);
             ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream)) {

            for (String path : paths) {
                File fileToZip = new File(path);
                FileInputStream fileInputStream = new FileInputStream(fileToZip);
                ZipEntry zipEntry = new ZipEntry(fileToZip.getName());

                zipOutputStream.putNextEntry(zipEntry);
                int oneByte = fileInputStream.read();
                while (oneByte != -1) {

                    zipOutputStream.write(oneByte);
                    oneByte = fileInputStream.read();
                }
                fileInputStream.close();


            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
