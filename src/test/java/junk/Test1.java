package junk;


public class Test1 {

    //Найти количество различных элементов массива. Пример: для 1 4 5 1 1 3 ответ 4.
    public static void main(String[] args) {
        int[] arr = {1, 4 , 5, 1, 1, 3};
        int count = 0;
        for(int k = 0; k < arr.length - 1; k++) {
            if (arr[k] != arr[k+1]) {
                count++;
            }
        }
        System.out.println(count);
    }

}
