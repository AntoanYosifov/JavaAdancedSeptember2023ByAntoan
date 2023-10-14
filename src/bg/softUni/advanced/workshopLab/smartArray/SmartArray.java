package bg.softUni.advanced.workshopLab.smartArray;

import java.util.function.Consumer;

public class SmartArray {
    private int[] data;
    private int index;

    public SmartArray() {
        this.data = new int[2];
        this.index = 0;
    }

    public void add(int element) {
        if (index == data.length) {
            data = resize(data.length * 2);
        }

        data[index] = element;
        index++;
    }

    private int[] resize(int newSize) {
        int[] newData = new int[newSize];

        System.arraycopy(data, 0, newData, 0, this.index);
        return newData;
    }

    public int size() {
        return index;
    }

    public int get(int index) {
        return data[index];
    }

    public boolean contains(int element) {
        for (int i = 0; i < this.index; i++) {
            if (this.data[i] == element) {
                return true;
            }
        }
        return false;
    }

    public int remove(int index) {
        int element = this.data[index];

        for (int i = index; i < this.index - 1; i++) {
            this.data[i] = data[i + 1];
        }

        this.data[this.index - 1] = 0;

        this.index--;

        if (this.index == this.data.length / 4) {
            this.data = resize(this.data.length / 2);
        }

        return element;
    }

    public void add(int index, int element) {

        int lastElement = this.data[this.index - 1];

        for (int i = this.index - 1; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }

        this.data[index] = element;

        this.add(lastElement);
    }
    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.index; i++) {
            consumer.accept(this.data[i]);
        }
    }
}
