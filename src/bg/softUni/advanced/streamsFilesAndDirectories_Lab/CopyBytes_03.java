package bg.softUni.advanced.streamsFilesAndDirectories_Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes_03 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\user\\javaAdvanced\\src\\bg\\softUni\\advanced\\streamsFilesAndDirectories_Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("copy-bytes-output.txt");

        int oneByte = inputStream.read();

        while (oneByte != -1){

            if(oneByte == 32){
                outputStream.write(' ');
            } else if (oneByte == 13){
                String symbol = String.valueOf(oneByte);
                for(char c : symbol.toCharArray()){
                    outputStream.write(c);
                }
                outputStream.write('\n');
            } else if (oneByte != 10){
                String code = String.valueOf(oneByte);
                for (char c : code.toCharArray()) {
                    outputStream.write(c);
                }

            }

            oneByte = inputStream.read();
        }

    }
}
