package bg.softUni.advanced.streamsFilesAndDirectories_Lab;

import java.io.*;

public class SerAndDeSer  {
    static class Cube implements Serializable{
        String color;
        double width;
        double height;
        double depth;

        public Cube(String color, double width, double height, double depth) {
            this.color = color;
            this.width = width;
            this.height = height;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cube cube = new Cube("green",15, 20, 10 );

        FileOutputStream outputStream = new FileOutputStream("cube-data.ser");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(cube);
        objectOutputStream.close();

        FileInputStream inputStream = new FileInputStream("cube-data.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Cube cube2 = (Cube) objectInputStream.readObject();


    }
}
