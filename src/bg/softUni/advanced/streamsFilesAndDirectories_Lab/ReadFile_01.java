package bg.softUni.advanced.streamsFilesAndDirectories_Lab;

import java.io.FileInputStream;
import java.io.IOException;


public class ReadFile_01 {
    public static void main(String[] args) throws IOException {
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        String path = "C:\\Users\\user\\javaAdvanced\\src\\bg\\softUni\\advanced\\streamsFilesAndDirectories_Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";


        FileInputStream inputStream = new FileInputStream(path);
            int oneByte = inputStream.read();

            while (oneByte >= 0){
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = inputStream.read();
            }

    }
}
