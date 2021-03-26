package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public abstract class NumbersInArmenian {

    public static void numbersInArmenianUntilMilliard() {

        HashMap<Integer, String> numbersHash = new HashMap<>();
        numbersHash.put(0, "");
        numbersHash.put(1, "մեկ");
        numbersHash.put(2, "երկու");
        numbersHash.put(3, "երեք");
        numbersHash.put(4, "չորս");
        numbersHash.put(5, "հինգ");
        numbersHash.put(6, "վեց");
        numbersHash.put(7, "յոթ");
        numbersHash.put(8, "ութ");
        numbersHash.put(9, "ինը");
        HashMap<Integer, String> numbersHashTasn = new HashMap<>();
        numbersHashTasn.put(1, "տասն");
        numbersHashTasn.put(2, "քսան");
        numbersHashTasn.put(3, "երեսուն");
        numbersHashTasn.put(4, "քառասուն");
        numbersHashTasn.put(5, "հիսուն");
        numbersHashTasn.put(6, "վաթսուն");
        numbersHashTasn.put(7, "յոթանասուն");
        numbersHashTasn.put(8, "ութանասուն");
        numbersHashTasn.put(9, "իննսուն");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number:");
        String string = scanner.next();
        LinkedList<Integer> numbers = new LinkedList<>();
        int number = Integer.parseInt(string);
        while (number > 0) {
            numbers.add(number % 10);
            number /= 10;
        }

        Integer haz = 0;
        if (numbers.size() >= 5) {
            haz = numbers.get(3);
        }
        Integer tasHaz = 0;
        if (numbers.size() >= 5) {
            tasHaz = numbers.get(4);
        }
        Integer haryurHaz = 0;
        if (numbers.size() >= 6) {
            haryurHaz = numbers.get(5);
        }

        if (numbers.size() == 0) {
            System.out.print("զրո");
        } else if (numbers.size() == 1) {
            System.out.print(numbersHash.get(numbers.get(0)));
        } else if (numbers.size() < 10) {
            while (numbers.size() > 0) {
                if (numbers.size() == 9) {
                    int haryurMillion = numbers.pollLast();
                    if (haryurMillion == 0) {
                    } else if (haryurMillion == 1) {
                        System.out.print("հարյուր" + " ");
                    } else {
                        System.out.print(numbersHash.get(haryurMillion) + " հարյուր" + " ");
                    }
                } else if (numbers.size() == 8) {
                    int tasMillion = numbers.pollLast();
                    if (tasMillion == 0) {
                    } else {
                        System.out.print(numbersHashTasn.get(tasMillion));
                    }
                } else if (numbers.size() == 7) {
                    int million = numbers.pollLast();
                    System.out.print(numbersHash.get(million) + " միլլիոն ");
                } else if (numbers.size() == 6) {
                    int haryurHazar = numbers.pollLast();
                    if (haryurHazar == 0) {
                    } else if (haryurHazar == 1) {
                        System.out.print("հարյուր" + " ");
                    } else {
                        System.out.print(numbersHash.get(haryurHazar) + " հարյուր ");
                    }
                } else if (numbers.size() == 5) {
                    int tasHazar = numbers.pollLast();
                    if (tasHazar == 0) {
                    } else {
                        System.out.print(numbersHashTasn.get(tasHazar));
                    }
                    if (haz == 0 && (tasHaz != 0 || haryurHaz != 0)) {
                        System.out.print(" հազար ");
                    }
                } else if (numbers.size() == 4) {
                    int hazar = numbers.pollLast();
                    if (hazar == 0) {
                    } else {
                        System.out.print(numbersHash.get(hazar) + " հազար" + " ");
                    }
                } else if (numbers.size() == 3) {
                    int haryur = numbers.pollLast();
                    if (haryur == 0) {
                    } else if (haryur == 1) {
                        System.out.print("հարյուր" + " ");
                    } else {
                        System.out.print(numbersHash.get(haryur) + " հարյուր" + " ");
                    }
                } else if (numbers.size() == 2) {
                    int tasnordakan = numbers.pollLast();
                    if (tasnordakan == 0) {
                    } else {
                        System.out.print(numbersHashTasn.get(tasnordakan));
                    }
                } else if (numbers.size() == 1) {
                    int miavor = numbers.pollLast();
                    if (miavor != 0) {
                        System.out.print(numbersHash.get(miavor));
                    }
                }
            }
        }
    }
}
