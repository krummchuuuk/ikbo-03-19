package com.company;

public class Main {

    public static void main(String[] args)
    {
	    int[]arr = new int[10];
	    for (int i=0;i<10;i++)
        {
            arr[i] = 1+(int)(Math.random()*20);
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
	    for(int i =0;i<9;i++)
        {
            for(int j=i+1;j<10;j++)
            {
                if(arr[i]>arr[j])
                {
                    int rem = arr[i];
                    arr[i] = arr[j];
                    arr[j]=rem;
                }
            }
        }
	    for(int i =0;i<10;i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
