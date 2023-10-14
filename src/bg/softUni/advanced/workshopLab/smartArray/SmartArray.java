package bg.softUni.advanced.workshopLab.smartArray;

import java.util.function.Consumer;

public class SmartArray<T> {
    private Object[] data;
    private int index;

    public SmartArray() {
        this.data = (T[])new Object[2];
        this.index = 0;
    }

    public void add(T element) {
        if (index == data.length) {
            data = resize(data.length * 2);
        }

        data[index] = element;
        index++;
    }

    private T[] resize(int newSize) {
        T[] newData = (T[])new Object[newSize];

        System.arraycopy(data, 0, newData, 0, this.index);
        return newData;
    }

    public int size() {
        return index;
    }
@SuppressWarnings("unchecked")
    public T get(int index) {
        return (T)data[index];
    }

    public boolean contains(T element) {
        for (int i = 0; i < this.index; i++) {
            if (this.data[i] == element) {
                return true;
            }
        }
        return false;
    }

    public T remove(int index) {
        T element = get(index);

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

    public void add(int index, T element) {

        T lastElement = get(this.index - 1);

        for (int i = this.index - 1; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }

        this.data[index] = element;

        this.add(lastElement);
    }
    public void forEach(Consumer<T> consumer) {
        for (int i = 0; i < this.index; i++) {
            consumer.accept(get(i));
        }
    }
}
