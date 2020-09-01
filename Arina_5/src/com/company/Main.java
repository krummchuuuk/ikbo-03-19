package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	int value = input.nextInt();
	input.close();
	int result = 1;
	for (int i=1;i<=value;i++)
    {
        result *=i;
    }
	System.out.print(result);
    }
}
