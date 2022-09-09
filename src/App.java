import java.util.Scanner;

public class App {
    static Board curBoard = new Board();

    static boolean is_win(char cur_player){
        boolean res = false;
        for(int i = 0 ;i < 3; i++){
            if( Board.statusBoard[2][i] == Board.statusBoard[1][i] 
            && Board.statusBoard[1][i] == Board.statusBoard[0][i] && 
            Board.statusBoard[0][i] == cur_player ) {
                return true;   
            }
            
            if( Board.statusBoard[i][2] == Board.statusBoard[i][1] 
            && Board.statusBoard[i][1] == Board.statusBoard[i][0] && 
            Board.statusBoard[i][0] == cur_player ) {
                return true;   
            }
        }

        if( Board.statusBoard[2][2] == Board.statusBoard[1][1] && 
            Board.statusBoard[1][1] == Board.statusBoard[0][0] && 
            Board.statusBoard[0][0] == cur_player ){
                return true;
            }

        if( Board.statusBoard[2][0] == Board.statusBoard[1][1] && 
            Board.statusBoard[1][1] == Board.statusBoard[0][2] && 
            Board.statusBoard[0][2] == cur_player ){
                return true;
            }

        return res;   
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] players = {'X', 'O'};
        boolean playing = true;
        int cur_player = 0;
        int turn_count = 0;
        while( playing ) {
            System.out.println(players[cur_player] + " turn!");   
            boolean validInput = false;
            int cur_row , cur_col;
            turn_count++;
            do {
                cur_row = scanner.nextInt() - 1;
                cur_col = scanner.nextInt() - 1;
                if( curBoard.changeCell(cur_row, cur_col, players[cur_player]) ){
                    validInput = true;   
                }
            }
            while( !validInput );

            curBoard.printBoard();
            if( is_win(players[cur_player]) ) {
                System.out.println(players[cur_player] + " won!");   
                playing = false;
            }
            else {
                cur_player = 1 - cur_player;
            }

            if( turn_count == 9 ) {
                playing = false;
                System.out.println("Draw!");   
            }
        }
    }
}
