/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

/**
 * mert batuhan do�aanay 
 * 02185076050
 */
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Lütfen virgül ile ayrılmış sayıları girin: ");
    String input = sc.nextLine();

    // Girilen say�lar� diziye at�yoruz
    String[] numbers = input.split(",");
    int[] array = new int[numbers.length];
    for (int i = 0; i < array.length; i++) {
      array[i] = Integer.parseInt(numbers[i]);
    }

    // Dizinin min heap olup olmad���n� kontrol ediyoruz
    boolean isMinHeap = true;
    for (int i = 0; i < array.length; i++) {
      int leftChild = 2 * i + 1;
      int rightChild = 2 * i + 2;

      if (leftChild < array.length && array[i] > array[leftChild]) {
        isMinHeap = false;
        break;
      }
      if (rightChild < array.length && array[i] > array[rightChild]) {
        isMinHeap = false;
        break;
      }
    }

    // Sonu�lar� yazd�r�yoruz
    if (isMinHeap) {
      System.out.println("Evet, min heap'tir.");
    } else {
      System.out.println("Hayır, min heap değildir.");
    }

    // Diziyi min heap'e �eviriyoruz
    for (int i = array.length / 2 - 1; i >= 0; i--) {
      heapify(array, array.length, i);
    }

    // Dizinin heap halini yazd�r�yoruz
    System.out.print("Heap hali: ");
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }

  // Diziyi min heap'e �evirme
  public static void heapify(int[] array, int heapSize, int i) {
    int smallest = i;
    int leftChild = 2 * i + 1;
    int rightChild = 2 * i + 2;

    if (leftChild < heapSize && array[leftChild] < array[smallest]) {
      smallest = leftChild;
    }
    if (rightChild < heapSize && array[rightChild] < array[smallest]) {
      smallest = rightChild;
    }
    if (smallest != i) {
      int temp = array[i];
      array[i] = array[smallest];
      array[smallest] = temp;

      heapify(array, heapSize, smallest);
    }
  }
}