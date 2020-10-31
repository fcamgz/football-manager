package com.example.idea;

import java.util.Random;

public class Match {
    public int season = 1;
    public String location;
    public Team team1;
    public Team team2;
    public League league;

    public Match(League league, Team team1, Team team2) {
        this.league = league;
        this.team1 = team1;
        this.team2 = team2;
    }

    public int winOrLose() {
        Random random = new Random();
        int upperBound = 10;
        int randomNum = random.nextInt(upperBound);
        return randomNum;
    }

    public int scoreGenerator(int high, int low) {
        Random random = new Random();
        int result = random.nextInt(high - low) + low;
        return result;
    }

    public String kickOff(String location, Team team1, Team team2) {
        String s = "";
        int week = 1;
        int team1WinningChance = 2;
        int team2WinningChance = 2;
        int winningBonus = 20000;
        int drawBonus = 5000;
        int losingBonus = 5000;
        int scoringBonus = 1000;
        if (team1.stadium == location) {
            team1WinningChance *= 2;
            team1.setBalance(team1.getBalance() + 5000);
        }

        if (team2.stadium == location) {
            team2WinningChance *= 2;
            team2.setBalance(team2.getBalance() + 5000);
        }

        if (team1.teamPower() > team2.teamPower()) {
            team1WinningChance *= 2;
        }

        if (team2.teamPower() > team1.teamPower()) {
            team2WinningChance *= 2;
        }
        if (week <= 34){
            if (team1WinningChance > team2WinningChance) {
                if (winOrLose() <= 6) {
                    team1.winLossHistory.add('w');
                    team2.winLossHistory.add('l');
                    if (team1WinningChance / team2WinningChance == 2) {
                        int team1Goals = scoreGenerator(4, 2);
                        int team2Goals = scoreGenerator(1, 0);
                        team1.scoredGoals.add(team1Goals);
                        team2.scoredGoals.add(team2Goals);
                        team1.setBalance(team1.getBalance() + winningBonus + team1Goals * scoringBonus);
                        team2.setBalance(team2.getBalance() + team2Goals * scoringBonus - losingBonus);
                        s = "\nWeek: " + week + " As expected, Team: " + team1.getName() + " - " + team1Goals + " won! and Team: " + team2.getName() + " - " + team2Goals + " lost!";
                        week++;
                        return s;
                    } else {
                        int team1Goals = scoreGenerator(8, 3);
                        int team2Goals = scoreGenerator(2, 0);
                        team1.setBalance(team1.getBalance() + winningBonus + team1Goals * scoringBonus);
                        team2.setBalance(team2.getBalance() + team2Goals * scoringBonus - losingBonus);
                        team1.scoredGoals.add(team1Goals);
                        team2.scoredGoals.add(team2Goals);
                        s = "\nWeek : " + week + " As expected, Team: " + team1.getName() + " - " + team1Goals + " won! and Team: " + team2.getName() + " - " + team2Goals + " lost!";
                        week++;
                        return s;
                    }
                } else if (winOrLose() >= 7 && winOrLose() <= 9) {
                    int bothGoals = scoreGenerator(4, 0);
                    team1.winLossHistory.add('d');
                    team1.setBalance(team1.getBalance() + drawBonus + bothGoals * scoringBonus);
                    team2.winLossHistory.add('d');
                    team2.setBalance(team2.getBalance() + drawBonus + bothGoals * scoringBonus);
                    team1.scoredGoals.add(bothGoals);
                    team2.scoredGoals.add(bothGoals);
                    s = "\nWeek: " + week + " That's surprising, Team: " + team1.getName() + " - " + bothGoals + " Team: " + team2.getName() + " - " + bothGoals + " draw!";
                    week++;
                    return s;
                }
                team1.winLossHistory.add('l');
                team2.winLossHistory.add('w');
                int team1Goals = scoreGenerator(1, 0);
                int team2Goals = scoreGenerator(3, 2);
                team1.setBalance(team1.getBalance() + scoringBonus * team1Goals - losingBonus);
                team2.setBalance(team2.getBalance() + winningBonus + scoringBonus * team2Goals);
                team1.scoredGoals.add(team1Goals);
                team2.scoredGoals.add(team2Goals);
                s = "\nWeek: " + week + " I can't believe it! Team: " + team1.getName() + " - " + team1Goals + " lost! and Team: " + team2.getName() + " - " + team2Goals + " won!";
                week++;
                return s;
            }
        if (team1WinningChance == team2WinningChance) {
            if (winOrLose() < 3) {
                int team1Goals = scoreGenerator(3, 2);
                int team2Goals = scoreGenerator(1, 0);
                team1.winLossHistory.add('w');
                team1.setBalance(team1.getBalance() + winningBonus + scoringBonus * team1Goals);
                team2.winLossHistory.add('l');
                team2.setBalance(team2.getBalance() + scoringBonus * team2Goals - losingBonus);
                team1.scoredGoals.add(team1Goals);
                team2.scoredGoals.add(team2Goals);
                s = "\nWeek: " + week + " Team: " + team1.getName() + " - " + team1Goals + " won! Team: " + team2.getName() + " - " + team2Goals + " lost!";
                week++;
                return s;
            } else if (winOrLose() > 6) {
                int team2Goals = scoreGenerator(3, 2);
                int team1Goals = scoreGenerator(1, 0);
                team1.winLossHistory.add('l');
                team1.setBalance(team1.getBalance() + scoringBonus * team1Goals - losingBonus);
                team2.winLossHistory.add('w');
                team2.setBalance(team2.getBalance() + winningBonus + scoringBonus * team2Goals);
                team1.scoredGoals.add(team1Goals);
                team2.scoredGoals.add(team2Goals);
                s = "\nWeek: " + week + " Team: " + team2.getName() + " - " + team2Goals + " won! Team: " + team1.getName() + " - " + team1Goals + " lost!";
                week++;
                return s;
            }
            int bothGoals = scoreGenerator(4, 2);
            team1.winLossHistory.add('d');
            team1.setBalance(team1.getBalance() + drawBonus + scoringBonus * bothGoals);
            team2.winLossHistory.add('d');
            team2.setBalance(team2.getBalance() + drawBonus + scoringBonus * bothGoals);
            team1.scoredGoals.add(bothGoals);
            team2.scoredGoals.add(bothGoals);
            s = "\nWeek: " + week + " Team: " + team1.getName() + " - " + bothGoals + " Team: " + team2.getName() + " - " + bothGoals + " draw!";
            week++;
            return s;
        } else if (team2WinningChance > team1WinningChance) {
            if (winOrLose() <= 6) {
                if (team2WinningChance / team1WinningChance == 2) {
                    int team2Goals = scoreGenerator(4, 2);
                    int team1Goals = scoreGenerator(1, 0);
                    team1.winLossHistory.add('l');
                    team1.setBalance(team1.getBalance() + team1Goals * scoringBonus - losingBonus);
                    team2.winLossHistory.add('w');
                    team2.setBalance(team2.getBalance() + winningBonus + team2Goals * scoringBonus);
                    team1.scoredGoals.add(team1Goals);
                    team2.scoredGoals.add(team2Goals);
                    s = "\nWeek: " + week + " As expected, Team: " + team2.getName() + " - " + team2Goals + " won! and Team: " + team1.getName() + " - " + team1Goals + " lost!";
                    week++;
                    return s;
                } else {
                    int team2Goals = scoreGenerator(8, 3);
                    int team1Goals = scoreGenerator(2, 0);
                    s = "\nWeek: " + week + " As expected, Team: " + team2.getName() + " - " + team2Goals + " won! and Team: " + team1.getName() + " - " + team1Goals + " lost!";
                    week++;
                    return s;
                }
            } else if (winOrLose() >= 7 && winOrLose() <= 9) {
                int bothGoals = scoreGenerator(3, 2);
                team1.winLossHistory.add('d');
                team2.winLossHistory.add('d');
                team1.scoredGoals.add(bothGoals);
                team2.scoredGoals.add(bothGoals);
                team1.setBalance(drawBonus + scoringBonus * bothGoals);
                team2.setBalance(drawBonus + scoringBonus * bothGoals);
                s = "\nWeek: " + week + " That's surprising, Team: " + team1.getName() + " - " + bothGoals + " Team: " + team2.getName() + " - " + bothGoals + " draw!";
                week++;
                return s;
            }
            int team1Goals = scoreGenerator(3, 2);
            int team2Goals = scoreGenerator(1, 0);
            team1.setBalance(team1.getBalance() + winningBonus + scoringBonus * team1Goals);
            team2.setBalance(team2.getBalance() + scoringBonus * team2Goals - losingBonus);
            team1.winLossHistory.add('w');
            team2.winLossHistory.add('l');
            s = "\nWeek: " + week + " I can't believe it! Team: " + team2.getName() + " - " + team2Goals + " lost! and Team: " + team1.getName() + " - " + team1Goals + " won!";
            week++;
            return s;
        }
    }
        else {
            s = "End of season: " + season;
            week = 1;
            season++;
            return s;
        }
        s = "End of match!";
        return s;
    }
}
