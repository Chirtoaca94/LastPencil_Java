package lastpencil;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberOfPencils;

        while (true) {
            System.out.println("How many pencils would you like to use: ");
            String input = scanner.nextLine().trim();
            if (input.matches("[0-9]+")) {
                numberOfPencils = Integer.parseInt(input);
                if (numberOfPencils > 0) {
                    break;
                } else {
                    System.out.println("The number of pencils should be positive");
                }
            } else {
                System.out.println("The number of pencils should be numeric");
            }
        }


        String firstPlayer;
        while (true) {
            System.out.println("Who will be the first (John, Jack): ");
            firstPlayer = scanner.nextLine().trim();
            if (firstPlayer.equals("John") || firstPlayer.equals("Jack")) {
                break;
            } else {
                System.out.println("Choose between 'John' and 'Jack'");
            }
        }

        String[] players = new String[2];
        players[0] = firstPlayer;
        players[1] = firstPlayer.equals("John") ? "Jack" : "John";
        int i = 0;
        int pencilsToTake;

        while (numberOfPencils > 0) {
            printPencils(numberOfPencils);
            System.out.println(players[i] + "'s turn!");

            while (true) {
                if (firstPlayer.equals("John")) {

                    String input = scanner.nextLine().trim();
                    if (input.matches("[1-3]")) {
                        pencilsToTake = Integer.parseInt(input);
                        if (pencilsToTake <= numberOfPencils) {
                            numberOfPencils -= pencilsToTake;
                            if(numberOfPencils == 0) {
                                System.out.println(players[1 - i] + " won!");
                                return;
                            } else {
                                i = 1 - i;
                                firstPlayer = "Jack";
                                break;
                            }
                        } else {
                            System.out.println("Too many pencils were taken");
                        }
                    } else {
                        System.out.println("Possible values: '1', '2' or '3'");
                    }
                } else {
                    if(numberOfPencils == 1) {
                        pencilsToTake = 1;
                        System.out.println(pencilsToTake);
                    } else if (numberOfPencils == 2 || numberOfPencils == 6 || numberOfPencils == 10
                            || numberOfPencils == 14 || numberOfPencils == 18) {
                        pencilsToTake = 1;
                        System.out.println(pencilsToTake);
                    } else if (numberOfPencils == 3 || numberOfPencils == 7 || numberOfPencils == 11 ||
                            numberOfPencils == 15 || numberOfPencils == 19) {
                        pencilsToTake = 2;
                        System.out.println(pencilsToTake);
                    } else if (numberOfPencils == 4 || numberOfPencils == 8 || numberOfPencils == 12 ||
                            numberOfPencils == 16 || numberOfPencils == 20) {
                        pencilsToTake = 3;
                        System.out.println(pencilsToTake);
                    } else {
                        pencilsToTake = random.nextInt(3) + 1;
                        System.out.println(pencilsToTake);
                    }
                    numberOfPencils -= pencilsToTake;
                    if(numberOfPencils == 0) {
                        System.out.println(players[1 - i] + " won!");
                        return;
                    } else {
                        i = 1 - i;
                        firstPlayer = "John";
                        break;
                    }
                }
            }
        }
    }

    public static void printPencils(int pencils) {
        for (int i = 0; i < pencils; i++) {
            System.out.print("|");
        }
        System.out.println();
    }
}
