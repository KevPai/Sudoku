package p1;

import java.util.Random;

public class SudokuScrambler {
    
    private int[][] scrambledBoard;
    
    public SudokuScrambler(int[][] scrambleThis) {
        
        setScrambledBoard(scramble(scrambleThis));
    }
    
    private static int[][] scramble(int[][] setThisBoard) {
        int[] row = new int[81];
        int[] column = new int[81];
        Random rand = new Random();
        
        for (int i = 0; i < 81; i++) {

            row[i] = rand.nextInt(9);
            column[i] = rand.nextInt(9);
            
            setThisBoard[row[i]][column[i]] = 0;
        }
        
        return setThisBoard;
    }
    
    public void setScrambledBoard(int[][] inputBoard) {
        scrambledBoard = inputBoard;
    }
    
    public int[][] getScrambledBoard() {
        return scrambledBoard;
    }
}
