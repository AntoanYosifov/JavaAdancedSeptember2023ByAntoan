package bg.softUni.advanced.streamsFilesAndDirectoriesExercises;

import java.io.*;

public class SerializeCustomObject_11 {
    public static void main(String[] args) {

        Course course = new Course("Java advanced", 250);
        String path = "C:\\JavaSoftUniProjects\\JavaAdancedSeptember2023ByAntoan\\src\\bg\\softUni\\advanced\\streamsFilesAndDirectoriesExercises\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\course.ser";
        try (FileOutputStream fileOutputStream = new FileOutputStream(path);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

             FileInputStream fileInputStream = new FileInputStream(path);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {


            objectOutputStream.writeObject(course);

            Course deserializedCourse = (Course) objectInputStream.readObject();
            System.out.println();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
