package bg.softUni.advanced.streamsFilesAndDirectoriesExercises;

import java.io.File;

public class GetFolderSize_08 {
    public static void main(String[] args) {

        String path = "C:\\JavaSoftUniProjects\\JavaAdancedSeptember2023ByAntoan\\src\\bg\\softUni\\advanced\\streamsFilesAndDirectoriesExercises\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File directory = new File(path);
        int size = 0;
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            assert files != null;
            for (File file : files) {
                if (!file.isDirectory()) {
                    size += file.length();
                }
            }
        }
        System.out.printf("Folder size: %d", size);
    }
}
