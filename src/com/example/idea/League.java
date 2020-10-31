package com.example.idea;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class League {
    public String name,country;
    public ArrayList<Team> listOfTeams;

    public League(String name, String country){
        this.name = name;
        this.country = country;
        listOfTeams = new ArrayList<Team>();
    }

    public String showStandings(){
        ArrayList<Team> standings = new ArrayList<>();
        int[] sorted = new int[listOfTeams.size()];
        String[] result = new String[listOfTeams.size()];
        int count = 0;
        String s = "";
        int standing = 1;
        for(Team i : listOfTeams){
           sorted[count] = i.numberOfWins();
           count++;
        }
        Arrays.sort(sorted);
        for(int j = listOfTeams.size() - 1; 0 > j; j++) {
            for(int i = 0; i < listOfTeams.size(); i++){
                if(listOfTeams.get(i).numberOfWins() == sorted[j]){
                    result[i] = standing + " " + listOfTeams.get(i) + " " + listOfTeams.get(i).numberOfWins();
                }
            }
        }
        for(int x = 0; x < listOfTeams.size(); x++){
            s += "\n" + result[x];
        }
        return s;
    }

    public double leagueWorth(){
        double worth = 0;
        for(Team i : listOfTeams){
           worth += i.teamWorth();
        }
        return worth;
    }

    public String addTeamToLeague(Team team){
        String s = "";
        for(Team i : listOfTeams)
            if(team.name != i.name){
                listOfTeams.add(team);
                s = "Team " + team + " is successfully added to the league!";
                return s;
            }
            s = "Team is already in the league!";
            return s;
    }

    public String decideLeagueWinner(){
        String s = "";
        int teamWithMaxWins = listOfTeams.get(0).numberOfWins();
        Team maxWinTeam = listOfTeams.get(0);
        for(Team i : listOfTeams){
            if(i.numberOfWins() > teamWithMaxWins){
                teamWithMaxWins = i.numberOfWins();
                maxWinTeam = i;
            }
        }
        s = "Team: " + maxWinTeam + " is the league winner!";
        return s;
    }
}
