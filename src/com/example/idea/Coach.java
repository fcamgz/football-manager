package com.example.idea;

import java.util.ArrayList;

public class Coach {
    public String name;
    public Team team;
    public int yearsOfExperience;
    public ArrayList<Player> starting11List;

    public Coach(String name, int yearsOfExperience,Team team) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.team = team;
        starting11List = new ArrayList<>();
    }

    public boolean findPlayerInStarting11List(Player player){
        for(Player i : starting11List){
            if(i.getNumber() == player.getNumber()){
                return true;
            }
        }
        return false;
    }

    public String createStarting11(Player player){
        String s = "";
        if(findPlayerInStarting11List(player) && starting11List.size() < 11){
            starting11List.add(player);
            s = player.getName() + " added";
            return s;
        }
        else if(findPlayerInStarting11List(player) && starting11List.size() >= 11){
            s = "There can't be more than 11 players in starting 11";
            return s;
        }
        s = "Player with same number is already in the starting 11";
        return s;
    }

    public String trainPlayer(Player player){
        String s = "";
        switch (player.getPosition()){
            case FORWARD:
                if(player.getShootingRating() <= 100){
                    player.setShootingRating(player.getShootingRating() + 1);
                    s += player.getShootingRating();
                    return s;
                }
                s = "Maximum rating is reached";
                return s;
            case MIDFIELDER:
                if(player.getPassingRating() <= 100){
                    player.setPassingRating((player.getPassingRating() + 1));
                    s += player.getPassingRating();
                    return s;
                }
                s = "Maximum rating is reached";
                return s;
            case DEFENDER:
                if(player.getDefendingRating() <= 100) {
                    player.setDefendingRating(player.getDefendingRating() + 1);
                    s += player.getDefendingRating();
                    return s;
                }
                s = "Maximum rating is reached";
                return s;
            case GOALKEEPER:
                if(player.getGoalKeepingRating() <= 100){
                    player.setGoalKeepingRating(player.getGoalKeepingRating() + 1);
                    s += player.getGoalKeepingRating();
                    return s;
                }
                s = "Maximum rating is reached";
                return s;
        }
        s = "Something went wrong";
        return s;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getInfo(){
        String s = "Name: " +
                "\nYears of Experience: " + yearsOfExperience +
                "\nCurrent Team: " + team;
        return s;
    }
}
