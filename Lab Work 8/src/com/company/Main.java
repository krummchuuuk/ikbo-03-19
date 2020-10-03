package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void write () {
        try {
            FileWriter w_file = new FileWriter("My_File.txt");
            //PrintWriter writer = new PrintWriter(w_file);
            String input;
            Scanner  console = new Scanner(System.in);
            input = console.nextLine();
            w_file.write(input);
            //writer.print(System.in);
            //writer.close();
            w_file.close();
        }
        catch(IOException ex2) {
            System.out.println(ex2.getMessage());
        }
    }
    public static void read() {
        try {
            FileReader r_file = new FileReader("My_File.txt");
            int symbol;
            while ((symbol=r_file.read())!=-1) {
                System.out.print ((char) symbol);
            }
            System.out.print ("\n");
            r_file.close();
        }
        catch (IOException ex1){
            System.out.println(ex1.getMessage());
        }
    }
    public static void append() {
        try {
            FileWriter w_file = new FileWriter("My_File.txt", true);
            Scanner scan = new Scanner(System.in);
            String text = scan.nextLine();
            w_file.append(text);
            w_file.close();
        }
        catch(IOException ex2) {
            System.out.println(ex2.getMessage());
        }
    }
    public static void main(String[] args) {
        write();
        read();
        write();
        append();
    }
}
