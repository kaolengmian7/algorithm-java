package src;

public class LinearSearch<E> {

    private LinearSearch(){}

    public static<E> int Search(E[] array, E target){
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // 示例用法
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"apple", "banana", "orange", "grape"};

        int intResult = LinearSearch.Search(intArray, 3);
        int strResult = LinearSearch.Search(strArray, "orange");

        System.out.println("Index of 3 in intArray: " + intResult);
        System.out.println("Index of 'orange' in strArray: " + strResult);
    }
}
