import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Play implements match.Game {
    public static void main(String[] args) {
        Play play1 = new Play();
        Play play2 = new Play();

        Scanner scanner = new Scanner(System.in);

        System.out.println("1. FootBall");
        System.out.println("2. BasketBall");
        System.out.println("3. Cricket");

        System.out.print("Enter Option : ");
        int option = scanner.nextInt();

        ArrayList<Double> statsTeam1;
        ArrayList<Double> statsTeam2;

        if (option == 1) {
            statsTeam1 = play1.playGame("FootBall");
            statsTeam2 = play2.playGame("FootBall");
        } else if (option == 2) {
            statsTeam1 = play1.playGame("BasketBall");
            statsTeam2 = play2.playGame("BasketBall");
        } else if (option == 3) {
            statsTeam1 = play1.playGame("Cricket");
            statsTeam2 = play2.playGame("Cricket");
        } else {
            statsTeam1 = play1.playGame("FootBall");
            statsTeam2 = play2.playGame("FootBall");
        }

        scanner.close();
    }

    public ArrayList<Double> playGame(String game) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Name : ");
        String name = scanner.nextLine();

        System.out.print("Enter No of Games Played : ");
        String gamesPlayed = scanner.nextLine();

        System.out.print("Enter No of Members : ");
        String members = scanner.nextLine();

        int teamPoints = 0;
        for (int i = 0; i < Integer.parseInt(members); i++) {
            System.out.print("Enter points scored : ");
            String points = scanner.nextLine();

            teamPoints += Integer.parseInt(points);
        }

        System.out.print("Enter No of Wins : ");
        String wins = scanner.nextLine();

        ArrayList<String> statistics = new ArrayList<>();

        statistics.add(gamesPlayed);
        statistics.add(String.valueOf(teamPoints));
        statistics.add(wins);

        ArrayList<Double> stats = new ArrayList<>();

        if (game == "FootBall") {
            FootBall footBall = new FootBall();

            footBall.setName(name);

            footBall.setStatistics(statistics);

            stats.add(Double.parseDouble(footBall.getStatistics().get(0)));
            stats.add(Double.parseDouble(footBall.getStatistics().get(1)));

            System.out.println(footBall.getName());
            System.out.println("Stats of " + footBall.getStatistics().get(2) + " : " + footBall.getStatistics().get(0));
            System.out.println("Stats of matches won : " + footBall.getStatistics().get(1));

        } else if (game == "BasketBall") {
            BasketBall basketBall = new BasketBall();
            basketBall.setName(name);

            basketBall.setStatistics(statistics);

            stats.add(Double.parseDouble(basketBall.getStatistics().get(0)));
            stats.add(Double.parseDouble(basketBall.getStatistics().get(1)));

            System.out.println(basketBall.getName());
            System.out.println(
                    "Stats of " + basketBall.getStatistics().get(2) + " : " + basketBall.getStatistics().get(0));
            System.out.println("Stats of matches won : " + basketBall.getStatistics().get(1));

        } else if (game == "Cricket") {
            Cricket cricket = new Cricket();
            cricket.setName(name);

            cricket.setStatistics(statistics);

            stats.add(Double.parseDouble(cricket.getStatistics().get(0)));
            stats.add(Double.parseDouble(cricket.getStatistics().get(1)));

            System.out.println(cricket.getName());
            System.out.println("Stats of " + cricket.getStatistics().get(2) + " : " + cricket.getStatistics().get(0));
            System.out.println("Stats of matches won : " + cricket.getStatistics().get(1));
        }

        scanner.close();

        return stats;
    }
}
