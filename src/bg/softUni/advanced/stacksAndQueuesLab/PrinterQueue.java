package bg.softUni.advanced.stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String file = scanner.nextLine();
        ArrayDeque<String> printerQueue = new ArrayDeque<>();
        while(!"print".equals(file)){
            if(file.equals("cancel")){
                 if(printerQueue.isEmpty()){
                     System.out.println("Printer is on standby");
                 }else{
                     System.out.println("Canceled " + printerQueue.poll());
                 }
            }else{
             printerQueue.offer(file);
            }

            file = scanner.nextLine();
        }

        while(!printerQueue.isEmpty()){
            System.out.println(printerQueue.poll());
        }


    }
}
/*
Presentation.pptx
cancel
Text.txt
cancel
cancel
cancel
print

 */