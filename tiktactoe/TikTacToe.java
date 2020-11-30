/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiktactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Pollock
 */
public class TikTacToe {

    /**
     * @param args the command line arguments
     */
    public static char[][] board = {{' ', '|', ' ', '|', ' '},
    {'-', '+', '-', '+', '-'},
    {' ', '|', ' ', '|', ' '},
    {'-', '+', '-', '+', '-'},
    {' ', '|', ' ', '|', ' '}};
    static char[][] displayBoard = {{'1', '|', '2', '|', '3'},
    {'-', '+', '-', '+', '-'},
    {'4', '|', '5', '|', '6'},
    {'-', '+', '-', '+', '-'},
    {'7', '|', '8', '|', '9'}};

    static ArrayList<Integer> playerPos = new ArrayList<>();
    static ArrayList<Integer> cpuPos = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("\tWelcome To Tic-Tac-Toe\n\t    @Pollock Nag@");
        System.out.println("\t*************************");
        menu();
    }

    private static void menu() {
        System.out.println("\nPress 1 to Start the game, Quit Otherwise.");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println("This is your dummy board with positions that you "
                    + "have to choose!");
            creatingBoard(displayBoard);
            System.out.println("");
            mechanism();
        } else {
            System.out.println("Thank You!");
        }
    }

    private static void mechanism() {

        while (true) {
            Scanner sc = new Scanner(System.in);
            Random r = new Random();

            System.out.println("Your Turn...\nPlease Enter Position(1-9)");
            int pPos = sc.nextInt();

            while (playerPos.contains(pPos) || cpuPos.contains(pPos)) {
                System.out.println("Position is taken , please enter another position");
                pPos = sc.nextInt();
            }
            game(pPos, "Player");

            String ans = result();

            if (ans.length() > 0) {
                System.out.println(ans);
                break;
            }
            System.out.println("Computer's Turn...");
            int cpuPo = r.nextInt(9) + 1;
            
            while (playerPos.contains(cpuPo) || cpuPos.contains(cpuPo)) {
                //       System.out.println("Position is taken , please enter another position ,[CPU]");
                cpuPo = r.nextInt(9) + 1;
            }
            game(cpuPo, "CPU");

            ans = result();

            if (ans.length() > 0) {
                System.out.println(ans);
                break;
            }

        }

    }

    private static String result() {
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> lastRow = Arrays.asList(7, 8, 9);
        List<Integer> leftCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList(2, 5, 8);
        List<Integer> lastCol = Arrays.asList(3, 6, 9);
        List<Integer> cross1 = Arrays.asList(1, 5, 9);
        List<Integer> cross2 = Arrays.asList(3, 5, 7);

        List<List> win = new ArrayList<>();
        win.add(topRow);
        win.add(midRow);
        win.add(lastRow);
        win.add(leftCol);
        win.add(midCol);
        win.add(lastCol);
        win.add(cross1);
        win.add(cross2);

        for (List l : win) {
            if (playerPos.containsAll(l)) {
                return "You Win";
            }
            if (cpuPos.containsAll(l)) {
                return "Computer win";
            }
            if ((playerPos.containsAll(l)) && (playerPos.size()
                    + cpuPos.size() == 9)) {
                return "You Win";
            }

            if ((!(playerPos.containsAll(l))) && (playerPos.size()
                    + cpuPos.size() == 9)) {
                return "DRAW";
            }

        }
        return "";
    }

    private static void game(int pos, String user) {
        char symbol = 'X';

        if (user.equals("Player")) {
            symbol = 'X';
            playerPos.add(pos);
        } else if (user.equals("CPU")) {
            symbol = 'O';
            cpuPos.add(pos);
        } else {
            System.out.println("Player?CPU error");
        }

        if (pos == 1) {
            board[0][0] = symbol;
            creatingBoard(board);
        } else if (pos == 2) {
            board[0][2] = symbol;
            creatingBoard(board);
        } else if (pos == 3) {
            board[0][4] = symbol;
            creatingBoard(board);
        } else if (pos == 4) {
            board[2][0] = symbol;
            creatingBoard(board);
        } else if (pos == 5) {
            board[2][2] = symbol;
            creatingBoard(board);
        } else if (pos == 6) {
            board[2][4] = symbol;
            creatingBoard(board);
        } else if (pos == 7) {
            board[4][0] = symbol;
            creatingBoard(board);
        } else if (pos == 8) {
            board[4][2] = symbol;
            creatingBoard(board);
        } else if (pos == 9) {
            board[4][4] = symbol;
            creatingBoard(board);
        } else {
            System.err.println("Wrong Input ,Please Try Next After Oponent Try");
            creatingBoard(board);
        }

    }

    private static void creatingBoard(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println("");
        }
    }

}
