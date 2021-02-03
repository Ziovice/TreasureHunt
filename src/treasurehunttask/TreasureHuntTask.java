
package treasurehunttask;

import java.util.*;

public class TreasureHuntTask {

    
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        
        
        int score = 0;
       
        String [][] board = new String[11][11];
        String[] numbers = {"[ 1 ]","[ 2 ]","[ 3 ]","[ 4 ]","[ 5 ]","[ 6 ]","[ 7 ]","[ 8 ]","[ 9 ]","[10 ]"};
        String[] letters = {"[ A ]","[ B ]","[ C ]","[ D ]","[ E ]","[ F ]","[ G ]","[ H ]","[ I ]","[ J ]"};

        for(int i = 0;i < 11;i++){
            for(int j = 0; j < 11;j++){
                board[i][j] = "[   ]";
            }
        }
 
        for(int i = 1;i < 11;i++){
            int j = 0;
            board[i][j]= letters[i-1];
        }

        for(int j = 1;j < 11;j++){
            int i = 0;
            board[i][j]= numbers[j-1];
        }


        int amountOfTreasure = random.nextInt((20-10)+1)+10;
        int[][] treasure = new int[amountOfTreasure][3];
        
        for(int i = 0; i<amountOfTreasure;i++){
            treasure[i][0] = random.nextInt((11-1)+1)+1;
            treasure[i][1] = random.nextInt((11-1)+1)+1;
            treasure[i][2] = random.nextInt((50-10)+1)+10;
        }
        
        int total = 0;
        for(int i = 0; i<amountOfTreasure;i++){
            total = total +treasure[i][2];
        }

        while(score<total){
            System.out.println("Score: "+score);

            for(int i = 0;i <11;i++){
                for(int j = 0;j < 11;j++){ 
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            System.out.println("Please guess the Coordinates of the ships (use the format A1)");
            String coords = input.next();
            String ycoord = "[ "+ coords.toUpperCase().charAt(0)+" ]";
            String xcoord = "[ "+coords.charAt(1)+" ]";



            int ycount =-1;
            do{
                ycount++;
            }while(!ycoord.equals(letters[ycount]) );

            int xcount = -1;
            if(coords.length()==3){
                xcount = 9;
            }
            else{
                do{
                    xcount++;
                }while(!xcoord.equals(numbers[xcount]) );
            }
            ycount++;
            xcount++;
            
            if(!"[ X ]".equals(board[ycount][xcount])){
                board[ycount][xcount] = "[ X ]";
                for(int j=0; j<amountOfTreasure;j++){
                    if((ycount == treasure[j][1])&&(xcount == treasure[j][0])){
                        score = score + treasure[j][2];
                        board[ycount][xcount] = "["+treasure[j][2]+" ]";
                    }
                }
            }

        }
    }
    }
    
