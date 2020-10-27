package com.example.idea;

public class Forward extends Player {
    public Forward(String name,Positions position, int number, int age){
        super(name,position, number, age);
        setShootingRating(50);
        setPassingRating(30);
        setGoalKeepingRating(0);
        setDefendingRating(10);
    }
    public String getInfo(){
        String s = "\nPlayer: " + name +
                "\nNumber: " + number +
                "\nAge: " + age +
                "\nPosition: " + position +
                "\nShooting Rating: " + getShootingRating() +
                "\nPassing Rating: " + getPassingRating() +
                "\nDefending Rating: " + getDefendingRating();
        return s;
    }
}
