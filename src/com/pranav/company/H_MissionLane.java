package com.pranav.company;

/*
https://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/

 */

public class H_MissionLane {

    static class node{

        int val;
        node next;

        public node(int val) {

            this.val =val;

        }

    }
    static void removeDuplicate(node head){

        // hash to store value
        HashSet<Integer> set = new HashSet<>();

        node current = head;
        node prev = null;

        while(current!=null){

            int currentVal = current.val;

            if(set.contains(currentVal)){

                prev.next = current.next;



            } else{

                set.add(currentVal);
                prev = current;



            }

            current = current.next;
        }


    }

    static void printList(node head){

        while(head!=null){

            System.out.print(head.val+ "->");
            head = head.next;


        }


    }

    public static void main(String[] args) {

        node head = new node(5);
        head.next = new node(6);
        head.next.next = new node(5);
        head.next.next.next = new node(21);
        head.next.next.next.next  = new node(43);
        head.next.next.next.next.next  = new node(43);
        head.next.next.next.next.next.next  = new node(0);
        head.next.next.next.next.next.next.next  = new node(21);

        System.out.println("pre processibg");

        printList(head);

        removeDuplicate(head);
        System.out.println("post processibg");

        printList(head);



    }
}
