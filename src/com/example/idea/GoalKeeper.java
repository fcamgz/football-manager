package com.example.idea;

public class GoalKeeper extends Player {
    public GoalKeeper(String name,Positions position, int number, int age){
        super(name,position, number, age);
        setGoalKeepingRating(50);
    }
    public String getInfo(){
        String s = "Player: " + name +
                "\nNumber: " + number +
                "\nAge: " + age +
                "\nPosition: " + position +
                "\nGoalKeeping Rating: " + getGoalKeepingRating();
        return s;
    }
}
