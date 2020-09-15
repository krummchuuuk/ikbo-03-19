package com.company;
import java.util.Scanner;

public class Main {
    public static final void num_13() {
        Scanner scan = new Scanner(System.in);
        int value = scan.nextInt();
        if (value != 0)
        {
            System.out.println(value);
            scan = new Scanner(System.in);
            value = scan.nextInt();
            if (value != 0) num_13();
        }
    }

    public static final void cout(int num) {
        int len=0, temp = num;
        while (temp>0) {
            len++;
            temp/=10;
        }
        System.out.print((int)(num/(Math.pow(10,len-1)))+" ");
        for (int i=0;i<len-1;i++) {
            System.out.print(0+" ");
        }
    }

    public static final void num_14(int num) {
        int raz = (int)(Math.pow(10, Integer.toString(num).length()-1));
        if (raz!= 1) {
            while (raz/10>0 && (num / (raz / 10)) % 10 == 0) {
                raz /= 10;
            }
        }
        cout(num/raz);
        if (raz!=1) num_14(num%raz);
    }

    public static final void num_15(int num) {
        if (num>0) {
            System.out.print(num % 10 + " ");
            num_15(num / 10);
        }
    }

    public static void main(String[] args) {
    System.out.print("NUMBER 13\n");
    num_13();
    System.out.print("\nNUMBER 14\n for 4930: ");
    num_14(4930);
    System.out.print("\nNUMBER 15\n for 67032: ");
    num_15(67032);
    }
}
