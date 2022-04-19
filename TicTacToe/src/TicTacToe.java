import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe{
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> computerPositions = new ArrayList<Integer>();
    public static void main(String args[]){
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '}, 
                {'-', '+', '-', '+', '-'}, 
                {' ', '|', ' ', '|', ' '}, 
                {'-', '+', '-', '+', '-'}, 
                {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);

        
        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your placement (1-9): ");
            int playerPlacement = scan.nextInt();
            while(playerPositions.contains(playerPlacement) || computerPositions.contains(playerPlacement)){
                System.out.println("Position taken! Enter another position: ");
                playerPlacement = scan.nextInt();
            }

            placePiece(gameBoard, playerPlacement, "player");

            String result = checkWinner();
            if(result.length() > 0){
                System.out.println(result);
                break;
            }

            Random rand = new Random();
            int computerPlacement = rand.nextInt(9) + 1;
            while(playerPositions.contains(computerPlacement) || computerPositions.contains(computerPlacement)){
                computerPlacement = rand.nextInt(9) + 1;
            }

            placePiece(gameBoard, computerPlacement, "computer");

            printGameBoard(gameBoard);

            result = checkWinner();
            if(result.length() > 0){
                System.out.println(result);
                break;
            }  
        } 
    }

    public static void printGameBoard(char[][] gameBoard){
        for(char[] row :gameBoard){
            for(char c : row){
                System.out.println(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard, int placement, String user){
        
        char symbol = ' ';

        if(user.equals("player")){
            symbol = 'X';
            playerPositions.add(placement);
        }else if(user.equals("computer")){
            symbol = 'O';
            computerPositions.add(placement);
        }
        
        switch(placement){
            case 1: 
                gameBoard[0][0] = symbol;
            case 2: 
                gameBoard[0][2] = symbol;
            case 3: 
                gameBoard[0][4] = symbol;
            case 4: 
                gameBoard[2][0] = symbol;
            case 5: 
                gameBoard[2][2] = symbol;
            case 6: 
                gameBoard[2][4] = symbol; 
            case 7: 
                gameBoard[4][0] = symbol; 
            case 8: 
                gameBoard[4][2] = symbol; 
            case 9: 
                gameBoard[4][4] = symbol;     
                break;
            default: 
                break;
        }
    }

    public static String checkWinner(){

        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List bottomRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(bottomRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for(List l : winning){
            if(playerPositions.containsAll((l))){
                return "Congratulations!";
            }else if(computerPositions.containsAll((l))){
                return "Computer wins!";
            }else if(playerPositions.size() + computerPositions.size() == 9){
                return "CAT!";
            }
        }

        return "";
    }
}