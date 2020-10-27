package com.example.idea;

public class Player {
   protected String name;
   protected Positions position;
   protected int number,age,shootingRating,passingRating,defendingRating,goalKeepingRating,trainCount;

    public Player(String name, Positions position, int number, int age) {
        this.name = name;
        this.position = position;
        this.number = number;
        this.age = age;
        shootingRating = 0;
        passingRating = 0;
        defendingRating = 0;
        goalKeepingRating = 0;
        trainCount = 0;
    }

    public int getShootingRating() {
        return shootingRating;
    }

    public void setShootingRating(int shootingRating) {
        this.shootingRating = shootingRating;
    }

    public int getPassingRating() {
        return passingRating;
    }

    public void setPassingRating(int passingRating) {
        this.passingRating = passingRating;
    }

    public int getDefendingRating() {
        return defendingRating;
    }

    public void setDefendingRating(int defendingRating) {
        this.defendingRating = defendingRating;
    }

    public int getGoalKeepingRating() {
        return goalKeepingRating;
    }

    public void setGoalKeepingRating(int goalKeepingRating) {
        this.goalKeepingRating = goalKeepingRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Positions getPosition() {
        return position;
    }

    public void setPosition(Positions position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInfo(){
        String s = "\nPlayer: " + name +
                "\nNumber: " + number +
                "\nAge: " + age +
                "\nPosition: " + position;
        return s;
    }

}
