package com.tinnkyou.demo.demo4;

import org.springframework.jdbc.core.namedparam.NamedParameterBatchUpdateUtils;

/**
 * @author wb-cq355812
 * @create 2019/05/27
 */
public class TestDemo {
    private static int nums[];
    public static int[] init(){
        int a[] = new int[10];
        for (int i=0;i<10;i++){
            a[i] = (int)(Math.random() * 100);
        }
        nums = a;
        return a;
    }
    //选择排序
    public static void sortNums(int[] numList){
        for (int num : numList) {
            System.out.print(num+",");
        }
        System.out.println("-------------------------------------");
        int minNum;
        int target;
        for (int i = 0; i < numList.length; i++) {
            minNum = numList[i];
            target = i;
            for (int j = i+1; j < numList.length; j++) {
                if (numList[j] < minNum){
                    minNum = numList[j];
                    target = j;
                }
            }
            int tmp = numList[i];
            numList[i] = minNum;
            numList[target] = tmp;
        }
        for (int num : numList) {
            System.out.print(num+",");
        }
    }
    public static void sortNums2(int[] numList){
        for (int num : numList) {
            System.out.print(num+",");
        }
        System.out.println("-------------------------------------");
        for (int i = 1; i < numList.length; i++) {
            int t = numList[i];
            int j = i - 1 ;
            while (j>=0 && t < numList[j]){
                numList[j + 1] = numList[j];
                j--;
            }
            numList[j+1] = t;
        }

        for (int num : numList) {
            System.out.print(num+",");
        }

    }

    public static void main(String[] args) {
        //选择排序
        //sortNums(init());
        //插入排序
        sortNums2(init());

    }

}
