package junk;

public class Test5 {
    //Создать класс с двумя переменными. Добавить функцию вывода на экран и функцию изменения этих переменных.
    // Добавить функцию, которая находит сумму значений этих переменных, и функцию которая находит наибольшее значение
    // из этих двух переменных.

    int first;
    int second;

    public void printFirst() {
        System.out.println(first);
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public void printSecond() {
        System.out.println(second);
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int sum() {
        return first+second;
    }

    public int theBiggest() {
        if (first > second) {
            return first;
        } else {
            return second;
        }
    }
}
