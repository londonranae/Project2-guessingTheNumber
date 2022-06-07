import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner guess = new Scanner(System.in);
        Scanner replay = new Scanner(System.in);
        Scanner name = new Scanner(System.in);
        boolean playing = true;

        while (playing) {
            int num = (int) (1 + 20 * Math.random());
            int guessCount = 6;
            int i;
            int a = guessCount;
            boolean validation = false;
            String input = "";
            System.out.println("Welcome! Please enter your name.");
            System.out.print("> ");
            String name2 = name.nextLine();
            System.out.println("Hello, " + name2 + ", let's play a game! Guess a number between 1 and 20.");


            int guessAction = -1;
            do {
                try {
                    System.out.print("> ");
                    guessAction = Integer.parseInt(guess.nextLine());
                    validation = false;                             // <- if ok, set false
                } catch (NumberFormatException e) {
                    System.out.println("This is not a number. Please retry");
                    validation = true;                              // <- if catch block is entered, set true
                }
            } while (validation);
            {

                for (i = 0; i < guessCount && guessAction >= 0 && guessAction <= 20; i++) {
                    validation = true;

                    if (num == guessAction) {
                        System.out.println("Great job, " + name2 + ", you are correct! You had " + guessCount + " guesses left.");
                        System.out.println("Would you like to play another round? y/n");
                        playing = replay.nextLine().trim().equalsIgnoreCase("y");
                        if (!playing) {
                            validation = false;

                        }break;
                    }  else if (num < guessAction) {
                        System.out.println("Sorry, but your guess is too high!");
//                        a--;
                        System.out.println("Guess a number! Guesses left: " + a);
                    }  else if (num > guessAction) {
                        System.out.println("Sorry, but your guess is too low!");
//                        a--;
                        System.out.println("Guess a number! Guesses left: " + a);
                    }
                    a--;
                    System.out.print("> ");
                    guessAction = Integer.parseInt(guess.nextLine());

                }
                if (i == guessCount) {
                    System.out.println("You have no more guesses!");
                    System.out.println("The answer was " + num);
                    System.out.println("Would you like to play again? y/n");
                    playing = replay.nextLine().trim().equalsIgnoreCase("y");
                    if (!playing) {
                        validation = false;
                        break;
                    }
                }

            }


        }
    }
}