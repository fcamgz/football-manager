package com.example.idea;

public class Midfielder extends Player{
    public Midfielder(String name,Positions position, int number, int age, double worth){
        super(name,position, number, age, worth);
        setPassingRating(50);
        setShootingRating(40);
        setGoalKeepingRating(0);
        setDefendingRating(30);
    }
    public String getInfo(){
        String s = "\nPlayer: " + name +
                "\nNumber: " + number +
                "\nAge: " + age +
                "\nPosition: " + position +
                "\nPassing Rating: " + getPassingRating() +
                "\nShooting Rating: " + getShootingRating() +
                "\nDefending Rating: " + getDefendingRating() +
                "\nWorth: " + worth;
        return s;
    }
}
