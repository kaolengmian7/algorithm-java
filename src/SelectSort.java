package src;

public class SelectSort<E> {

    private SelectSort(){}

    public static<E> int Search(E[] array, E target){
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
