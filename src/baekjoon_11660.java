import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_11660 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");   
        int numOfMatrix = Integer.parseInt(st.nextToken());
        int numOfAddCount = Integer.parseInt(st.nextToken());
        int [][] matrix = new int [numOfMatrix+1][numOfMatrix+1];

        for (int i = 1; i <= numOfMatrix; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= numOfMatrix; j++) {
                matrix[i][j] = matrix[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }
        for (int k = 1; k <= numOfAddCount; k++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int i = x1; i <= x2; i++) {
                sum = sum + (matrix[i][y2] - matrix[i][y1-1]);
            }
            sb.append(sum + "\n");
        }
        System.out.print(sb);
    }
}

        