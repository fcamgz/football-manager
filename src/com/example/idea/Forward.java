package com.example.idea;

public class Forward extends Player {
    public Forward(String name,Positions position, int number, int age){
        super(name,position, number, age);
        setShootingRating(50);
    }
    public String getInfo(){
        String s = "Player: " + name +
                "\nNumber: " + number +
                "\nAge: " + age +
                "\nPosition: " + position +
                "\nShootingRating: " + getShootingRating();
        return s;
    }
}
