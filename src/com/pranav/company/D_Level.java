package com.pranav.company;
// https://leetcode.com/problems/string-compression/
//https://www.techiedelight.com/run-length-encoding-rle-data-compression-algorithm/
//https://www.geeksforgeeks.org/run-length-encoding/
//https://www.geeksforgeeks.org/run-length-decoding-in-linked-list/?ref=rp
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// run-length encoding:
// aaaabbbcc => a4b3c2
// a4b3c2 => aaaabbbcc
// aaaaaaaaaab => a10b1

public class D_Level {


//aaaabbbcc

    public static String encode(String input){

        int slow = 0;
        int fast = slow +1 ;
        char [] ch = input.toCharArray();
        StringBuffer sb = new StringBuffer();

        if(input.isEmpty()) return "";

        while(fast < ch.length){

            if(ch[slow] == ch[fast]){

                fast++;

            } else {

                sb.append(ch[slow]);
                sb.append(fast-slow);
                slow = fast;
                fast++;

            }


        }

        sb.append(ch[slow]);
        sb.append(fast-slow);

        return sb.toString();


    }

    public static String decode(String input){

        // a4b3c1 -> aaaabbbcc

        char [] ch = input.toCharArray();
        StringBuffer sb = new StringBuffer();
        int i = 0;

        if(input.isEmpty()) return "";
        while(i < ch.length - 1){

            char c = ch[i]; //a
            int  count = Character.getNumericValue(ch[i+1]); //10

            while(count > 0){

                sb.append(c);
                count--;
            }

            i=i+2;
        }



        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(encode("a1")); // => a111
        System.out.println(decode("a10b1"));
    }
}

