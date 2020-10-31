package com.example.idea;

public class Main {

    public static void main(String[] args) {
        League superlig = new League("Superlig","Turkey");
        Team besiktas = new Team("Besiktas","vodafone arena",1903,20,100000);
        Team madrid = new Team("Real Madrid","santiago bernabeu",1901,20,1000000);
        Coach senol = new Coach("Senol Gunes",20,besiktas);
        Player aboubakar = new Forward("Aboubakar",Positions.FORWARD,10,27,20000);
        Player talisca = new Midfielder("Talisca",Positions.MIDFIELDER,31,26,10000);
        Player vanDjik = new Defender("Van Djik",Positions.DEFENDER,4,27,15000);
        Player fabri = new GoalKeeper("Fabri",Positions.GOALKEEPER,1,30,5000);
        Player ronaldo = new Player("ronaldo",Positions.FORWARD,7,33,200000);
        madrid.addPlayer(ronaldo);
        Coach zidane = new Coach("zidane",20,madrid);
        madrid.addCoach(zidane);
        besiktas.addPlayer(aboubakar);
        besiktas.addPlayer(talisca);
        besiktas.addPlayer(vanDjik);
        besiktas.addPlayer(fabri);
        besiktas.addCoach(senol);
        senol.trainShooting(aboubakar);
        senol.trainPassing(aboubakar);
        senol.trainShooting(aboubakar);
        Match match = new Match(superlig,besiktas,madrid);
        System.out.println(match.kickOff("vodafone arena",besiktas,madrid));
    }
}
