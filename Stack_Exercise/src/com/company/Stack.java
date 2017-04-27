package com.company;

public class Stack<E> implements Stackable<E> {
    private E[] arr = null;
    private int CAP;
    private int top = -1;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public Stack(int cap) {
        this.CAP = cap;
        this.arr = (E[]) new Object[cap];
    }

    public E pop() {
        if(this.size == 0){
            return null;
        }

        this.size--;
        E result = this.arr[top];
        this.arr[top] = null;
        this.top--;

        return result;
    }

    public boolean push(E e) {
        if (isEmpty())
            return false;

        if(this.arr.length==size){
            E[] temp= (E[]) new Object[CAP*2];
            for (int i = 0; i <arr.length ; i++) {
                temp[i]=arr[i];
            }
            arr=temp;
        }


        this.size++;
        this.arr[++top] = e;
        return false;
    }

    public boolean isEmpty() {
        if (this.size == this.CAP)
            return true;
        return false;
    }






    public String toString() {
        if(this.size==0){
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<this.size; i++){
            sb.append(this.arr[i] + ", ");
        }

        sb.setLength(sb.length()-2);
        return sb.toString();
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
