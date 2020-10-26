package com.example.idea;

import java.util.ArrayList;

public class Team {
    public String name,stadium;
    public int since,teamCapacity,numberOfPlayers;
    private int balance;
    public ArrayList<Player> playerList;

    public Team(String name, String stadium, int since, int teamCapacity, int balance) {
        this.name = name;
        this.stadium = stadium;
        this.since = since;
        this.teamCapacity = teamCapacity;
        this.balance = balance;
        numberOfPlayers = 0;
        playerList = new ArrayList<>(teamCapacity);
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


    public String addPlayers(Player player){
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

    public void viewAllPlayers(){
        for(Player i : playerList){
            System.out.println(i);
        }
    }

}
