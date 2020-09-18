package com.company;
import java.util.*;

public class Main {
    public static void by_stack (int []play_1, int [] play_2) {
        Stack<Integer> player_1 = new Stack<Integer>();
        Stack<Integer> player_2 = new Stack<Integer>();
        Stack<Integer> temp = new Stack<Integer>();
        int steps = 0;
        for (int i = 4; i > -1; i--) {
            player_1.push(play_1[i]);
            player_2.push(play_2[i]);
        }
        while (!player_1.empty() && !player_2.empty()) {
            if (steps != 106) {
                steps++;
                if (player_1.peek() == 0 && player_2.peek() == 9) {
                    temp.push(player_1.pop());
                    temp.push(player_2.pop());
                    temp.addAll(player_1);
                    player_1.clear();
                    player_1.addAll(temp);
                    temp.clear();
                } else if (player_1.peek() == 9 && player_2.peek() == 0) {
                    temp.push(player_1.pop());
                    temp.push(player_2.pop());
                    temp.addAll(player_2);
                    player_2.clear();
                    player_2.addAll(temp);
                    temp.clear();
                } else if (player_1.peek() > player_2.peek()) {
                    temp.push(player_1.pop());
                    temp.push(player_2.pop());
                    temp.addAll(player_1);
                    player_1.clear();
                    player_1.addAll(temp);
                    temp.clear();
                } else if (player_1.peek() < player_2.peek()) {
                    temp.push(player_1.pop());
                    temp.push(player_2.pop());
                    temp.addAll(player_2);
                    player_2.clear();
                    player_2.addAll(temp);
                    temp.clear();
                }
                if (!player_1.empty()) {
                    System.out.print("first " + steps);
                } else if (!player_2.empty()) {
                    System.out.print("second " + steps);
                }
            }
            else {
                System.out.print("botva");
                break;
            }
        }
    }

    public static void by_queue (int []play_1, int []play_2) {
        Queue<Integer> player_1 = new LinkedList<Integer>();
        Queue<Integer> player_2 = new LinkedList<Integer>();
        int steps=0;
        for (int i=0;i<5;i++) {
            player_1.add(play_1[i]);
            player_2.add(play_2[i]);
        }
        while (player_1.size()!=0 && player_2.size()!=0) {
            if (steps != 106) {
                steps++;
                if (player_1.peek() == 0 && player_2.peek() == 9) {
                    player_1.add(player_1.remove());
                    player_1.add(player_2.remove());
                } else if (player_1.peek() == 9 && player_2.peek() == 0) {
                    player_2.add(player_1.remove());
                    player_2.add(player_2.remove());
                } else if (player_1.peek() > player_2.peek()) {
                    player_1.add(player_1.remove());
                    player_1.add(player_2.remove());
                } else if (player_1.peek() < player_2.peek()) {
                    player_2.add(player_1.remove());
                    player_2.add(player_2.remove());
                }
            }
            else {
                System.out.print("botva");
                break;
            }
        }
        if(player_1.size()==0) {
            System.out.print("second "+steps);
        }
        else if (player_2.size()==0) {
            System.out.print("first "+steps);
        }
    }

    public static void by_deque(int []play_1, int [] play_2)  {
        Deque<Integer> player_1 =  new LinkedList<Integer>();
        Deque<Integer> player_2 = new LinkedList<Integer>();
        int steps=0;
        for (int i=0;i<5;i++) {
            player_1.add(play_1[i]);
            player_2.add(play_2[i]);
        }
        while (player_1.size()!=0 && player_2.size()!=0) {
            if (steps != 106) {
                steps++;
                if (player_1.peek() == 0 && player_2.peek() == 9) {
                    player_1.add(player_1.remove());
                    player_1.add(player_2.remove());
                } else if (player_1.peek() == 9 && player_2.peek() == 0) {
                    player_2.add(player_1.remove());
                    player_2.add(player_2.remove());
                } else if (player_1.peek() > player_2.peek()) {
                    player_1.add(player_1.remove());
                    player_1.add(player_2.remove());
                } else if (player_1.peek() < player_2.peek()) {
                    player_2.add(player_1.remove());
                    player_2.add(player_2.remove());
                }
            }
            else {
                System.out.print("botva");
                break;
            }
        }
        if(player_1.size()==0) {
            System.out.print("second "+steps);
        }
        else if (player_2.size()==0) {
            System.out.print("first "+steps);
        }
    }

    public static void main(String[] args) {
        int[] arr1= new int[5];
        int[] arr2 = new int[5];
        Scanner input = new Scanner(System.in);
        for (int i=0;i<5;i++) {
            int value = input.nextInt();
            arr1[i] = value;
        }
        input = new Scanner(System.in);
        for (int i=0;i<5;i++) {
            int value = input.nextInt();
            arr2[i] = value;
        }
        System.out.print("ON STACK\n");
        by_deque(arr1, arr2);
        System.out.print("\nON QUEUE\n");
        by_queue(arr1, arr2);
        System.out.print("\nON DEQUE\n");
        by_deque(arr1, arr2);
    }
}
