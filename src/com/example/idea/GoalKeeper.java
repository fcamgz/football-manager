package com.example.idea;

public class GoalKeeper extends Player {
    public GoalKeeper(String name,Positions position, int number, int age, double worth){
        super(name,position, number, age, worth);
        setGoalKeepingRating(50);
        setDefendingRating(15);
        setPassingRating(30);
        setShootingRating(10);
    }
    public String getInfo(){
        String s = "\nPlayer: " + name +
                "\nNumber: " + number +
                "\nAge: " + age +
                "\nPosition: " + position +
                "\nGoalKeeping Rating: " + getGoalKeepingRating() +
                "\nWorth: " + worth;
        return s;
    }
}
