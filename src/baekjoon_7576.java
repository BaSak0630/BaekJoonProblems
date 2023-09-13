import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_7576 {
    public static class Pos {
        int pos_x;
        int pos_y;
        Pos(){
            pos_y = 0;
            pos_x = 0; 
        }
        Pos(int x, int y){
            pos_x = x;
            pos_y = y; 
        }
    }
    public static void main(String args[]) throws Exception{
        int days = 0;
        int matrix_x;
        int matrix_y;
        int x; 
        int y;
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};  
        String buffer;
        Queue<Pos> queue = new LinkedList<Pos>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        buffer = br.readLine();     
        StringTokenizer st = new StringTokenizer(buffer," ");
        matrix_y = Integer.parseInt(st.nextToken());
        matrix_x = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[matrix_x][matrix_y];
        Pos posBuffer = new Pos();

        for(int i = 0; i < matrix_x; i++){ 
            buffer = br.readLine();     
            st = new StringTokenizer(buffer," ");
            for(int j = 0; j < matrix_y; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if(matrix[i][j]==1){
                    posBuffer.pos_x = i;
                    posBuffer.pos_y = j;
                    queue.add(posBuffer);
                }
            }
        }
        
        while(!queue.isEmpty()){
            Pos tomatPos = queue.poll();
            for(int i = 0; i < dx.length; i++){
                x = tomatPos.pos_x+dx[i];
                y = tomatPos.pos_y+dy[i];
                if(-1 < x && x < matrix_x && -1 < y && y < matrix_y){
                    if(matrix[x][y] == 0){
                        posBuffer.pos_x = x;
                        posBuffer.pos_y = y;
                        queue.add(posBuffer);
                        matrix[x][y] = matrix[tomatPos.pos_x][tomatPos.pos_y] + 1;
                    }
                }
            }
        }

        //독립된 토마토 검증
        for(int i = 0; i < matrix_x; i++){
            for(int j = 0; j < matrix_y; j++){
                if( days < matrix[i][j]) days = matrix[i][j];
                if(matrix[i][j] == 0){
                    days = -1;
                    break;
                }
            }
        }
        if(days != -1) days -= 1;
        
        System.out.println(days);
    }
}
//다차원배열 에서 너비를 우선해서 탐색하는 알고리즘 
// 그래프에서 사용 그래프는 정점과 간선으로 이루어지 자료구조

//add(pos(i,j)) c++는 페어가 존제