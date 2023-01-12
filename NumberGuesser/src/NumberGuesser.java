 /* 2021-CE-04
Syeda Rabia Batool
Computer Engineering
 */
import java.util.Random;
import java.util.Scanner;
    public class NumberGuesser {
        private int guesses = 10;
        private int warning = 1;
        private int guessedNo;
        private int cub;
        private int[] alreadyTold = new int[10];

        public void setAlreadyTold(int number) {
            int index=cub;
            alreadyTold[index]=number;

        }

        public Boolean isAlreadyTold(int number) {
            for (int i=0; i<cub+1;i++){
                if (alreadyTold[i]==number){

                    return true;
                }
            }

            return false;
        }

        public void play() {

            int min = 0;
            int max = 1000;

            System.out.println("Random value of type double between " + min + " to " + max + ":");
            int secret_number = (int) (Math.random() * (max - min + 1) + min);
            System.out.println(secret_number);

            cub = 0;
            System.out.println("Welcome to the Number Guessing game!");
            System.out.println("I am thinking of a number between 0-1000");
            System.out.println("You have 1 warning.");
            while (cub < 10) {
                System.out.println("---------------------");
                System.out.println("you have " + guesses + " guesses left");
                System.out.println("you have " + warning + " warnings left");
                System.out.print("guessed number:\n");
                for (int i = 0; i < cub; i++) {
                    System.out.print(" " + alreadyTold[i]);
                }
                System.out.println("\nPlease Enter a number as guess:");
                Scanner input = new Scanner(System.in);
                if (input.hasNextInt()) {
                    guessedNo = input.nextInt();
                    if (isAlreadyTold(guessedNo)) {
                        System.out.println("Warning!You have already entered this number!!!!!");
                        warning--;
                    }
                    if (warning < 0) {
                        System.out.println(" Oopss!! Sorry you have lost, your warnings finished ");
                        System.out.println("The number was "
                                + secret_number);
                        break;
                    }
                    setAlreadyTold(guessedNo);
                    cub++;
                    guesses--;
                    if (guessedNo > secret_number) {
                        System.out.println("Your guess is greater!!!");
                    }
                    if (guessedNo < secret_number) {
                        System.out.println("Your guess is smaller!!!");
                    }
                    if (guessedNo == secret_number) {
                        System.out.println("Bravo!!!!!you have guessed the number");
                        System.out.println("----------");
                        break;
                    }
                } else {
                    warning--;
                    if (warning < 0) {
                        System.out.println("Oops!! Sorry you lose because your warnings finished, ");
                        System.out.println("The number was "
                                + secret_number);
                        break;
                    }
                    System.out.println("warning!!invalid only numbers are valid");
                }
                if (guesses == 0) {
                    System.out.println("Oops!! Sorry you lose, the number of guesses finished. The number was "
                            + secret_number);
                }


            }
        }
        public static void main(String args[]) {
            NumberGuesser n = new NumberGuesser();
            n.play();
        }}

