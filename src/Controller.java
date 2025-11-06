import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
    private final Tile[][] board = new Tile[4][4];
    private final int Empty = 0;

    public Controller(){
        Newgame();
    }
    public void Newgame(){
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= 15; i++) numbers.add(i);
        numbers.add(Empty);

        do{
            Collections.shuffle(numbers);
        }while(!Solvable(numbers));

        for(int i = 0; i <16; i++){
            board[i / 4][i % 4] = new Tile(numbers.get(i));
        }
    }

    public Tile getTile(int row, int col){
        return board[row][col];
    }
    public boolean moveTile(int row,int col){
        int[] emptyPos = findEmpty();
        assert emptyPos != null;
        int er = emptyPos[0], ec = emptyPos[1];

        if ((Math.abs(row - er) == 1 && col == ec) || (Math.abs(col -ec) == 1 && row == er)){
            Tile temp = board[row][col];
            board[row][col] = board[er][ec];
            board[er][ec] = temp;
            return  true;


        }
        return false;
    }
    public boolean isGameWon(){
        int count = 1;
        for(int row = 0; row < 4; row++){
            for(int col = 0; col < 4; col++){
                if(row == 3 && col == 3)return board[row][col].isEmpty();
                if(board[row][col].getValue() != count++) return  false;
            }
        }
        return true;
    }
    private int[] findEmpty(){
        for(int row = 0; row < 4; row++){
            for(int col = 0; col < 4; col++){
                if(board[row][col].isEmpty()) return new int[]{row,col};

            }
        }
        return null;
    }
    private boolean Solvable(List<Integer> numbers){
        int inversions = 0;
        for(int i = 0; i < numbers.size(); i++){
            for(int j = i +1; j < numbers.size(); j++){
                int a = numbers.get(i), b = numbers.get(j);
                if(a != Empty && b != Empty && a > b ) inversions++;
            }
        }
        int emptyRow = numbers.indexOf(Empty) / 4;
        int rowFromBotton = 3 - emptyRow;
        return (inversions % 2 == 0) == (rowFromBotton % 2 == 0);
    }


}

