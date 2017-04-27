package com.company;

public class Main {

    public static void main(String[] args) {

        Stack<String> stack = new Stack<String>(11) {
        };
        stack.push("hello");
        stack.push("world");
        stack.push("world");

        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);
    }

    public static void reverse(Stack stack){

        Stack es1= new Stack(9);
        while (stack.getSize()>0){
            es1.push(stack.pop());
        }
        Stack es2= new Stack(9);
        while (es1.getSize()>0){
            es2.push(es1.pop());
        }
        while (es2.getSize()>0){
            stack.push(es2.pop());
        }
    }

    public static  void remove(Stack stack,Object obj){
        Stack es1= new Stack(9);
        for (int i = 0; i < stack.getSize(); i++) {
            Object o=stack.pop();
            if(!o.equals(obj)){
                es1.push(o);
            }
        }
    }

    public static void sortStack(Stack<Comparable> stack){

    }

}

