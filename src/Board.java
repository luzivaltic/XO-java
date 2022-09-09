public class Board {  
    static char[][] statusBoard = new char[3][3];

    public Board(){
        for(int i = 0 ;i < 3; i++){
            for(int j = 0 ;j < 3; j++){
                statusBoard[i][j] = '.';
            }
        }   
    }

    public void printBoard() {
        for(int i = 0 ;i < 3; i++){
            for(int j = 0 ; j < 3; j++){
                if( statusBoard[i][j] == '.' ){
                    System.out.print("[ ]");
                }
                else {
                    System.out.print("[" + statusBoard[i][j] + "]");    
                }
            }
            System.out.print("\n");   
        }
    }

    public boolean changeCell(int row , int col , char player) {
        if( Math.max(row , col) > 2 || Math.min(row, col) < 0 || statusBoard[row][col] != '.' ){
            return false;
        }
        statusBoard[row][col] = player;
        return true;
    }
}
