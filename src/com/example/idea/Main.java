package com.example.idea;

public class Main {

    public static void main(String[] args) {
        Team besiktas = new Team("Besiktas","vodafone arena",1903,20,100000);
        Player aboubakar = new Forward("Aboubakar",Positions.FORWARD,10,27);
        Player talisca = new Midfielder("Talisca",Positions.MIDFIELDER,31,26);
        Player vanDjik = new Defender("Van Djik",Positions.DEFENDER,4,27);
        Player fabri = new GoalKeeper("Fabri",Positions.GOALKEEPER,1,30);
        System.out.println(besiktas.addPlayers(aboubakar));
        System.out.println(besiktas.addPlayers(talisca));
        System.out.println(besiktas.addPlayers(vanDjik));
        System.out.println(besiktas.addPlayers(fabri));
        System.out.println(aboubakar.getInfo());
    }
}
