package com.company;
import java.util.Collections;

interface Compareble {
    public boolean Compareto (Student first, Student second);
}

class Student {
    private String name;
    private String surname;
    private double avarage;

    Student(String name, String surname, double avarage) {
        this.name = name;
        this.surname = surname;
        this.avarage = avarage;
    }
    public String getName() {
        return name;
    }
    public String getSuranme() {
        return surname;
    }
    public double getAvarage() {
        return avarage;
    }
}

class InsertionSort implements Compareble {
    @Override
    public boolean Compareto(Student first, Student second) {
        char [] arr_first = first.getName().toCharArray();
        char [] arr_second = second.getName().toCharArray();
        if (arr_first[0] > arr_second[0]) return true;
        else return false;
    }
    public void sort(Student [] iDNumber) {
        for (int i=1; i<iDNumber.length; i++) {
            Student key = iDNumber[i];
            int j=i-1;
            while(j>=0 && Compareto(iDNumber[j], key)) {
                iDNumber[j+1] = iDNumber[j];
                j--;
            }
            iDNumber[j+1] = key;
        }
    }
}

class QuickSort implements Compareble {
    @Override
    public boolean Compareto(Student first, Student second) {
        if (first.getAvarage() < second.getAvarage()) return true;
        else return false;
    }

    public void sort(Student[] iDNumber, int left, int right)
    {
        if (iDNumber.length == 0 || left>=right) return;
        int mid = left + (right - left) / 2;
        Student pivot = iDNumber[mid];
        int i = left, j = right;
        while (i <= j)
        {
            while (Compareto(pivot, iDNumber[i])) i++;
            while (Compareto(iDNumber[j], pivot)) j--;
            if (i <= j) {
                Student temp = iDNumber[i];
                iDNumber[i] = iDNumber[j];
                iDNumber[j] = temp;
                i++;
                j--;
            }
        }

        if (left < j) sort(iDNumber, left, j);
        if (right > i) sort(iDNumber, i, right);
    }
}

class MergeSort implements Compareble {
    @Override
    public boolean Compareto(Student first, Student second) {
        char [] arr_first = first.getName().toCharArray();
        char [] arr_second = second.getName().toCharArray();
        if (arr_first[0] < arr_second[0]) return true;
        else return false;
    }

    public Student [] start_sort(Student [] first, Student [] second) {
        Student [] arr = new Student[first.length+ second.length];
        System.arraycopy(first, 0, arr, 0,first.length);
        System.arraycopy(second, 0, arr, first.length, second.length);
        sort(arr, 0, arr.length-1);
        return arr;
    }
    public void sort(Student[] arr, int left, int right) {
        if (right <= left) return;
        int mid = (left+right)/2;
        sort(arr, left, mid);
        sort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    public void merge(Student[] arr, int left, int mid, int right) {
        Student left_arr[] = new Student[mid - left + 1];
        Student right_arr[] = new Student[right - mid];

        for (int i = 0; i < left_arr.length; i++)
            left_arr[i] = arr[left + i];
        for (int i = 0; i < right_arr.length; i++)
            right_arr[i] = arr[mid + i + 1];

        int left_index = 0,right_index = 0;
        for (int i = left; i < right + 1; i++) {
            if (left_index < left_arr.length && right_index < right_arr.length) {
                if (Compareto(left_arr[left_index], right_arr[right_index])) {
                    arr[i] = left_arr[left_index];
                    left_index++;
                }
                else {
                    arr[i] = right_arr[right_index];
                    right_index++;
                }
            }
            else if (left_index < left_arr.length) {
                arr[i] = left_arr[left_index];
                left_index++;
            }
            else if (right_index < right_arr.length) {
                arr[i] = right_arr[right_index];
                right_index++;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
	    Student first = new Student("Polina", "Ivanova", 4.67);
	    Student second = new Student("Maxim", "Petrov", 3.76);
	    Student third = new Student ("Anna", "Sidorova", 4.03);
	    Student [] arr_1 = new Student[] {first, second, third};
        for (int i=0;i<arr_1.length;i++) {
            System.out.print(arr_1[i].getName()+" "+arr_1[i].getSuranme()+" "+arr_1[i].getAvarage()+"\n");
        }

	    System.out.print("\nNUMBER 1:\n");
	    InsertionSort sort_1 = new InsertionSort();
	    sort_1.sort(arr_1);
	    for (int i=0;i<arr_1.length;i++) {
	        System.out.print(arr_1[i].getName()+" "+arr_1[i].getSuranme()+" "+arr_1[i].getAvarage()+"\n");
        }

	    System.out.print("\nNUMBER 2:\n");
	    QuickSort sort_2 = new QuickSort();
	    sort_2.sort(arr_1, 0, arr_1.length-1);
        for (int i=0;i<arr_1.length;i++) {
            System.out.print(arr_1[i].getName()+" "+arr_1[i].getSuranme()+" "+arr_1[i].getAvarage()+"\n");
        }

        System.out.print("\nNUMBER 3:\n");
        Student fourth = new Student("Dasha", "Tarasova", 4.00);
        Student fifth = new Student("Zhenya", "Pak", 3.17);
        Student sixth = new Student ("Kate", "Fedorova", 5.00);
        Student[] arr_2 = new Student[] {fourth, fifth, sixth};
        MergeSort sort_3 = new MergeSort();
        Student []finish_arr = sort_3.start_sort(arr_1,arr_2);
        for (int i=0;i<finish_arr.length;i++) {
            System.out.print(finish_arr[i].getName()+" "+finish_arr[i].getSuranme()+" "+finish_arr[i].getAvarage()+"\n");
        }
    }
}
