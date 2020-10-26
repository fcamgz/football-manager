package com.example.idea;

public class Midfielder extends Player{
    public Midfielder(String name,Positions position, int number, int age){
        super(name,position, number, age);
        setPassingRating(50);
    }
    public String getInfo(){
        String s = "Player: " + name +
                "\nNumber: " + number +
                "\nAge: " + age +
                "\nPosition: " + position +
                "\nPassingRating: " + getPassingRating();
        return s;
    }
}
