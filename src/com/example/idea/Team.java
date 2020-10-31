package com.example.idea;

import java.util.ArrayList;

public class Team {
    public String name,stadium;
    public int since,teamCapacity,numberOfPlayers;
    private int balance;
    public ArrayList<Player> playerList;
    public ArrayList<Character> winLossHistory;
    public ArrayList<Integer> scoredGoals;
    public Coach coach;

    public Team(String name, String stadium, int since, int teamCapacity, int balance) {
        this.name = name;
        this.stadium = stadium;
        this.since = since;
        this.teamCapacity = teamCapacity;
        this.balance = balance;
        numberOfPlayers = 0;
        playerList = new ArrayList<>(teamCapacity);
        scoredGoals = new ArrayList<>();
        winLossHistory = new ArrayList<>(34);
    }

    public double teamWorth(){
        double clubWorth = 0;
        for(Player i : playerList){
           clubWorth += i.worth;
        }
        return clubWorth;
    }

    public String transferPlayer(Team otherTeam, Player player){
        String s = "";
        if(balance > player.worth){
            playerList.add(player);
            balance -= player.worth;
            otherTeam.playerList.remove(player);
            otherTeam.balance += player.worth;
            s = player + " is successfully transferred from " + otherTeam + "\n" +
                    "Balance - " + player.worth + " current Balance: " + balance;
        }
        s = "You don't have enough money to buy this player";
        return s;
    }

    public String getName(){
        return name;
    }
    public void addCoach(Coach coach){
        this.coach = coach;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean findPlayerInPlayerList(Player player){
        for(Player i : playerList){
            if(i.getNumber() == player.getNumber()){
                return true;
            }
        }
        return false;
    }

    public int teamPower(){
        int teamShootingRate = 0;
        int teamPassingRate = 0;
        int teamDefendingRate = 0;
        int teamGoalKeepingRate = 0;
        int teamPowerRate = 0;
        for(Player i : coach.starting11List){
           teamShootingRate += i.getShootingRating();
           teamPassingRate += i.getPassingRating();
           teamDefendingRate += i.getDefendingRating();
           teamGoalKeepingRate += i.getGoalKeepingRating();
        }
        teamPowerRate = teamShootingRate + teamPassingRate + teamDefendingRate + teamGoalKeepingRate;
        return teamPowerRate;
    }

    public String addPlayer(Player player){
        String s = "";
        if(findPlayerInPlayerList(player)) {
            s = "Player is already in the list";
            return s;
        }
        else if(!findPlayerInPlayerList(player) && playerList.size() < teamCapacity) {
            playerList.add(player);
            numberOfPlayers++;
            s = "Player successfully added";
            return s;
        }
        s = "Out of capacity";
        return s;
    }

    public String removePlayer(Player player){
        String s = "";
        for(Player i : playerList){
            if(player.getNumber() == i.getNumber()){
                playerList.remove(i);
                s = "Player " + i + " has been removed";
                return s;
            }
        }
        s = "Something is wrong";
        return s;
    }

    public String viewPlayer(Player player){
        String s = "";
        for(Player i : playerList){
            if(player.getNumber() == i.getNumber()){
                return player.getInfo();
            }
        }
        s = "Player couldn't be found";
        return s;
    }

    public int numberOfWins(){
        int winsCount = 0;
        int lossCount = 0;
        int drawCount = 0;
        int totalPoints = 0;
        for(int x = 0; x < winLossHistory.size(); x++){
            if(winLossHistory.get(x) == 'w'){
                winsCount++;
            }
            else if(winLossHistory.get(x) == 'l'){
                lossCount++;
            }
            drawCount++;
        }
        totalPoints = winsCount * 3 + drawCount * 1;
        return totalPoints;
    }

    public String viewAllPlayers(){
        String s = "";
        for(Player i : playerList){
            s += i.getInfo();
        }
        s += "\nThese are all the players";
        return s;
    }
    public String getInfo(){
        String s = "\nTeam: " + name +
                "\nFounded in: " + since +
                "\nTeam Capacity: " + teamCapacity +
                "\nNumber of Players In The Team: " + numberOfPlayers +
                "\nStadium: " + stadium +
                "\nCoach: " + coach.getName() +
                "\nCurrent Balance: " + balance +
                "\nTeam Worth: " + teamWorth();
        return s;
    }
}
