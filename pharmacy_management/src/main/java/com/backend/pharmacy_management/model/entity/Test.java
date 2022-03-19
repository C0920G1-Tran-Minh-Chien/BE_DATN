package com.backend.pharmacy_management.model.entity;

public class Test {
//    public static int[] findNumber(int[] arr){
//        int[] result;
//        String[] stringNums;
//        for (int i = 0; i<arr.length;i++) {
//            if (arr[i]>=100&&arr[i]<=999){
//                String s= String.valueOf(arr[i]);
//            }
//        }
//    }
public static void main(String[] args) {
//    int[] i = {4,5,6};
//    int a = i[0];
//    System.out.println(a);
//    System.out.println(i);
    for (int i=100;i<1000;i++) {
        String s = Integer.toString(i);
        char[] stringArr = s.toCharArray();
        int a = stringArr[0];
        int b = stringArr[1];
        int c = stringArr[2];
        if (a==b*4&&a==(b-8)||b==a*4&&a==(b-8)){
            System.out.println(a+b+c);
        }
//        for (int j=0;j<stringArr.length;j++){
//            int a = stringArr[0];
//            int b = stringArr[1];
//            int c = stringArr[2];
//        }
    }
}
}
