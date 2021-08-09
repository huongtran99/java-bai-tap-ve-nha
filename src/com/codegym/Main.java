package com.codegym;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String array[] = creatProduct();
        showProduct(array);
        String newArray[] = addProduct(array);
        showProduct(newArray);
        String newArrayDelete[] = deleteProduct(newArray);
        showProduct(newArrayDelete);
        searchProduct(newArrayDelete);
        System.out.println("Sau khi sắp xếp");
        String arrayNew[] = sortProduct(newArrayDelete);
        showProduct(arrayNew);
        String updateArray[] = updateProduct(arrayNew);
        showProduct(updateArray);
    }

    public static String[] creatProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập độ dài của mảng: ");
        int size = scanner.nextInt();
        String array[] = new String[size];
        scanner.nextLine();

        for (int i = 0; i < size; i++) {
            System.out.print("Nhập vào sản phẩm thứ " + i + ": ");
            array[i] = scanner.nextLine();
        }

        return array;
    }

    public static void showProduct(String array[]) {
        System.out.print("Danh sách sản phẩm: ");
        for (String list : array) {
            System.out.print(list + " ");
        }
        System.out.println();
    }

    public static String[] addProduct(String array[]) {
        Scanner scanner = new Scanner(System.in);
        String newArray[] = new String[array.length + 1];
        System.out.println();
        System.out.print("Nhập sản phẩm muốn thêm: ");
        String value = scanner.nextLine();
        System.out.print("Nhập vị trí: ");
        int index = scanner.nextInt();
        for (int i = 0; i < newArray.length; i++) {
            if (i < index) {
                newArray[i] = array[i];
            } else if (i == index) {
                newArray[i] = value;
            } else {
                newArray[i] = array[i - 1];
            }
        }
        return newArray;
    }

    public static String[] deleteProduct(String array[]) {
        Scanner scanner = new Scanner(System.in);
        String newArray[] = new String[array.length - 1];
        System.out.println();
        System.out.print("Nhập sản phẩm muốn xóa: ");
        String value = scanner.nextLine();
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].equals(value)) {
                newArray[i] = array[i + 1];
            } else {
                newArray[i] = array[i];
            }
        }
        return newArray;
    }

    public static void searchProduct(String array[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tìm kiếm sản phẩm gì ?? : ");
        String value = scanner.nextLine();
        boolean check = false;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                check = true;
                index = i;
            }
        }

        if (check) {
            System.out.println("Sản phẩm " + value + " ở vị trí " + index);
        } else {
            System.out.print("Không tìm thấy sản phẩm");
        }
    }

    public static String[] sortProduct(String array[]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].compareTo(array[j]) > 0) {
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }

    public static String[] updateProduct(String array[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập sản phẩm muốn sửa: ");
        String value = scanner.nextLine();
        System.out.println();
        System.out.print("Nhập sản phẩm muốn thay thế: ");
        String edit = scanner.nextLine();
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                array[i] = edit;
            }
        }

        return array;
    }

}
