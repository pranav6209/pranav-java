package com.pranav.code;

import java.util.ArrayList;

public class scratch {

    public static void merge2List(){


    List<Integer> list1  = new ArrayList<Integer>();

    list1.add(1);
    list1.add(2);
    list1.add(3);


    List<Integer> list2  = new ArrayList<Integer>();

    list2.add(4);
    list2.add(5);
    list2.add(6);


        list2.addAll(list1);


    }

    public static void main(String[] args) {
        merge2List();
    }

}
