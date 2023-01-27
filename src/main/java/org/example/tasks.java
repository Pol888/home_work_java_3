package org.example;

import java.util.ArrayList;
import java.util.Collections;


public class tasks {
    static void task1() {
        ArrayList <Integer> aba = new ArrayList <> ();
        for (int i = 0; i < 11; i++) {
            aba.add((int)(Math.random() * 10));
        }
        System.out.println("До");
        System.out.println(aba);

        for (int i = 0; i < aba.size(); i++) {    // удаляет четные значения
            if (aba.get(i) % 2 == 0){
                    aba.remove(i);
                    i--; // позволяет не пропустить ни одного элемента
            }
        }
        System.out.println("После");
        System.out.println(aba);
    }
    static void task2(){
        ArrayList <Integer> bab = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            bab.add((int)(Math.random() * 10));
        }
        System.out.println("Список: ");
        System.out.println(bab);

        System.out.printf("Максимальный элемент = %d%n", Collections.max(bab));
        System.out.printf("Минимальный элемент = %d%n", Collections.min(bab));

        Double m = (double) sum_f(bab) / bab.size();

        System.out.printf("Среднее арифмитичесое = %f%n", m);
        }

        static int sum_f (ArrayList<Integer> a){    // считает сумму элементов списка
            int sum = 0;
            for (Object o : a) {
                sum += Integer.parseInt(o.toString());
            }
            return sum;
        }

    static void task3(){
        ArrayList <Integer> a = new ArrayList<>();
        a.add(3);
        a.add(8);
        a.add(-2);
        a.add(4);
        a.add(-3);
        a.add(9);
        a.add(1);
        a.add(8);
        a.add(-1);

        System.out.println("Начальный список");
        System.out.println(a);
        ArrayList<Integer> s = split_and_merge_list(a);
        System.out.println("Результат");
        System.out.println(s);
    }
    // слияние двух отсортированных списков
    static ArrayList<Integer> merge_list(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList <Integer> c = new ArrayList<>();

        int N = a.size();
        int M = b.size();
//
        int i = 0;
        int j = 0;
        while (i < N && j < M) {
            if (Integer.parseInt(a.get(i).toString()) <= Integer.parseInt(b.get(j).toString())) { // если n-ый элемент
                                                                // 1 го списка меньше или равен n-ому элементу второго,
                                                                 // добавляем его в новый список с
                c.add(Integer.parseInt(a.get(i).toString()));
                i += 1;
            } else {                                           // наоборот
                c.add(Integer.parseInt(b.get(j).toString()));
                j += 1;
            }
        }

        for (Object x: a.subList(i, a.size())) {   // добиваем остатки элементов
            c.add((int)x);
        }
        for (Object x: b.subList(j, b.size())) {
            c.add((int)x);
        }
        return c;  // возвращаем список
    }

    static ArrayList<Integer> split_and_merge_list(ArrayList<Integer> a) {
        int N1 = a.size() / 2;
        ArrayList<Integer> a1 = new ArrayList<>(a.subList(0, N1));        // деление массива на 2
        ArrayList<Integer> a2 = new ArrayList<>(a.subList(N1, a.size()));

        if (a1.size() > 1) {                                 // если длина 1 списка больше 1, то продолжаем деление
            a1 = split_and_merge_list(a1);
        }
        if (a2.size() > 1) {                               // если длина 2 списка больше 1 ...делим дальше
            a2 = split_and_merge_list(a2);
        }

        return merge_list(a1, a2);     // слияние
    }
}



