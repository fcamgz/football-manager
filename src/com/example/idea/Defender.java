package com.example.idea;

public class Defender extends Player {
    public Defender(String name,Positions position, int number, int age){
        super(name,position, number, age);
        setDefendingRating(50);
        setGoalKeepingRating(0);
        setPassingRating(30);
        setShootingRating(25);
    }
    public String getInfo(){
        String s = "\nPlayer: " + name +
                "\nNumber: " + number +
                "\nAge: " + age +
                "\nPosition: " + position +
                "\nDefending Rating: " + getDefendingRating() +
                "\nPassing Rating: " + getPassingRating() +
                "\nShooting Rating: " + getShootingRating();
        return s;
    }
}
