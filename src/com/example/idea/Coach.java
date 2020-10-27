package com.example.idea;

import java.util.ArrayList;

public class Coach {
    public String name;
    public Team team;
    public int yearsOfExperience;
    public ArrayList<Player> starting11List;

    public Coach(String name, int yearsOfExperience, Team team) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.team = team;
        starting11List = new ArrayList<>();
    }

    public boolean findPlayerInStarting11List(Player player) {
        for (Player i : starting11List) {
            if (i.getNumber() == player.getNumber()) {
                return true;
            }
        }
        return false;
    }

    public String createStarting11(Player player) {
        String s = "";
        if (!findPlayerInStarting11List(player) && starting11List.size() < 11) {
            starting11List.add(player);
            s = player.getName() + " added to Starting 11";
            return s;
        } else if (!findPlayerInStarting11List(player) && starting11List.size() >= 11) {
            s = "There can't be more than 11 players in starting 11";
            return s;
        }
        s = "Player with same number is already in the starting 11";
        return s;
    }

    public String trainShooting(Player player) {
        String s = "";
        if (player.getShootingRating() <= 100) {
            switch (player.position) {
                case FORWARD:
                    player.setShootingRating(player.getShootingRating() + 5);
                    s += player.getShootingRating();
                    return s;
                case MIDFIELDER:
                    player.setShootingRating(player.getShootingRating() + 3);
                    s += player.getShootingRating();
                    return s;
                case DEFENDER:
                    player.setShootingRating(player.getShootingRating() + 2);
                    s += player.getShootingRating();
                    return s;
                case GOALKEEPER:
                    player.setShootingRating(player.getShootingRating() + 1);
                    s += player.getShootingRating();
                    return s;
            }
            s = "Something went wrong";
            return s;
        }
        s = "Maximum rating is reached";
        return s;
    }

    public String trainDefending(Player player) {
        String s = "";
        if (player.getDefendingRating() <= 100) {
            switch (player.position) {
                case FORWARD:
                    player.setDefendingRating(player.getDefendingRating() + 2);
                    s += player.getDefendingRating();
                    return s;
                case MIDFIELDER:
                    player.setDefendingRating(player.getDefendingRating() + 3);
                    s += player.getDefendingRating();
                    return s;
                case DEFENDER:
                    player.setDefendingRating(player.getDefendingRating() + 5);
                    s += player.getDefendingRating();
                    return s;
                case GOALKEEPER:
                    player.setDefendingRating(player.getDefendingRating() + 1);
                    s += player.getDefendingRating();
                    return s;
            }
            s = "Something went wrong";
            return s;
        }
        s = "Maximum rating is reached";
        return s;
    }

    public String trainPassing(Player player) {
        String s = "";
        if (player.getPassingRating() <= 100) {
            switch (player.position) {
                case FORWARD:
                    player.setPassingRating(player.getPassingRating() + 3);
                    s += player.getPassingRating();
                    return s;
                case MIDFIELDER:
                    player.setPassingRating(player.getPassingRating() + 5);
                    s += player.getPassingRating();
                    return s;
                case DEFENDER:
                    player.setPassingRating(player.getPassingRating() + 2);
                    s += player.getPassingRating();
                    return s;
                case GOALKEEPER:
                    player.setPassingRating(player.getPassingRating() + 1);
                    s += player.getPassingRating();
                    return s;
            }
            s = "Something went wrong";
            return s;
        }
        s = "Maximum rating is reached";
        return s;
    }

    public String trainGoalKeeping(Player player) {
        String s = "";
        if (player.getGoalKeepingRating() <= 100) {
            switch (player.position) {
                case GOALKEEPER:
                    player.setGoalKeepingRating(player.getGoalKeepingRating() + 5);
                    s += player.getGoalKeepingRating();
                    return s;
            }
            player.setGoalKeepingRating(player.getGoalKeepingRating() + 1);
            s += player.getGoalKeepingRating();
            return s;
        }
        s = "Maximum rating is reached";
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
