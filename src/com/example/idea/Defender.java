package com.example.idea;

public class Defender extends Player {
    public Defender(String name,Positions position, int number, int age){
        super(name,position, number, age);
        setDefendingRating(50);
    }
    public String getInfo(){
        String s = "Player: " + name +
                "\nNumber: " + number +
                "\nAge: " + age +
                "\nPosition: " + position +
                "\nDefending Rating: " + getDefendingRating();
        return s;
    }
}
