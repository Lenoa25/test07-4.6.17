package com.company;

public class Main {

    public static void main(String[] args) {
	Animal a=new Dog();
	a.makeSound();
        Animal b=new Poodle();
        b.makeSound();
        Animal c=new Cat();
        c.makeSound();

        Dog d = new Poodle();
        Poodle p = (Poodle)d;
        p.roll(); //p מצביע על אותו אוביקט d
        //d.roll();
    }

    public static void handleDog(Dog d){
        if(d!=null)
            d.bark();
    }


}
