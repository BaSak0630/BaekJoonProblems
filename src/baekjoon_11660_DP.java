import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_11660_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int matrixSize = Integer.parseInt(st.nextToken());
        int numOfAddcount = Integer.parseInt(st.nextToken());
        int[][] matrixArr = new int[matrixSize+1][matrixSize+1];
        int[][] dpArr = new int[matrixSize+1][matrixSize+1];
        
        for (int i = 1; i <= matrixSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= matrixSize; j++) {
                matrixArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= matrixSize; i++) {
            for (int j = 1; j <= matrixSize; j++) {
                dpArr[i][j] = dpArr[i-1][j] + dpArr[i][j-1] - dpArr[i-1][j-1] + matrixArr[i][j];
            }
        }
        for (int k = 1; k <= numOfAddcount; k++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int ans = dpArr[x2][y2] - dpArr[x2][y1-1] - dpArr[x1-1][y2] + dpArr[x1-1][y1-1];
            sb.append(ans + "\n");
        }
        System.out.print(sb);
    }
}
