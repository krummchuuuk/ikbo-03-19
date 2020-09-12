package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int [10];
        int sum = 0;
        for (int i=0;i<10;i++)
        {
            arr[i] = i*i;
            sum +=arr[i];
        }
        System.out.print(sum);
    }
}
