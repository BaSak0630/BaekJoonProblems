import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//소문난 칠공주
public class baekjoon_1914 {
    public static class Pos {
        int pos_x;
        int pos_y;

        Pos(int x, int y) {
            pos_x = x;
            pos_y = y;
        }
    }

    public static void main(String[] args) throws Exception{
        int [][] board = new int[5][5];
        int [] dx = {1, 0, -1, 0};
        int [] dy = {0, 1, 0, -1};
        Queue<Pos> bfs = new LinkedList<>();
        Queue<Pos> startQueue = new LinkedList<>();
        int count;
        int result;
        String buffer;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 5; i++){
            buffer = br.readLine();
            for(int j = 0; j < 5;j ++){
                if(buffer.charAt(j) == 'S'){
                    board[i][j] = 0;
                    if(j == 0){
                        startQueue.add(new Pos(i,j));
                    }
                }else if(buffer.charAt(j) == 'Y'){
                    board[i][j] = 1;
                }
            }
        }
        while (!startQueue.isEmpty()){
            Pos startTmp = startQueue.poll();
            bfs.add(startTmp);
            count = 0;
            while (!bfs.isEmpty()) {
                Pos tmp = bfs.poll();
                int startX = tmp.pos_x;
                int startY = tmp.pos_y;
                for(int i=0; i<4; i++){
                    int nX = startX + dx[i];
                    int nY = startY + dy[i];

                    if (nX < 0 || nX >= 5 || nY < 0 || nY >= 5) {
                        if (board[nX][nY] != board[startX][startY]) {
                            bfs.add(new Pos(nX,nY));
                            
                        }
                    }
                }
            }
        }


        /*for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }*/
    }
}
