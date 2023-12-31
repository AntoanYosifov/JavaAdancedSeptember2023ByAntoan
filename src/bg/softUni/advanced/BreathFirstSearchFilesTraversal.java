package bg.softUni.advanced;

import java.io.File;
import java.util.ArrayDeque;

public class BreathFirstSearchFilesTraversal {
    public static void main(String[] args) {


        String path = "C:\\Users\\user\\javaAdvanced\\src\\bg\\softUni\\advanced\\streamsFilesAndDirectories_Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.offer(new File(path));

        int counter = 0;
        while(!queue.isEmpty()){

         File f = queue.poll();
         counter++;

            File[] files = f.listFiles();
            if(files != null){
                for (File file : files) {
                    queue.offer(file);
                }

            }


        }
        System.out.println(counter);

    }
}
