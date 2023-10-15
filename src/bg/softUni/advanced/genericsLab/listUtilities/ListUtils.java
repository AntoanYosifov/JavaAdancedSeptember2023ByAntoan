package bg.softUni.advanced.genericsLab.listUtilities;

import java.util.Collections;
import java.util.List;

public class ListUtils {
    public static <T extends Comparable<? super T>> T getMin(List<T> list) {
        if(list.isEmpty()){
             throw new IllegalArgumentException();
        }
        return Collections.min(list);
    }

    public static <T extends Comparable<? super T>> T getMax(List<T> list) {
        if(list.isEmpty()){
            throw new IllegalArgumentException();
        }
      return   Collections.max(list);
    }
}
