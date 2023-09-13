import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_15650 {
    static int N,M;
    static int [] arr = new int[9];
    static boolean[] isUsed = new boolean[9];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        back(0);
    }
    private static void back(int flow){
        if (flow == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                arr[flow] = i;
                back(flow + 1); // arr의 인덱스를 +1 시켜준다.
                isUsed[i] = false;
            }
        }
    }
}

/*
 if (!isUsed[i]) {
 isUsed[i] = true;
 arr[flow] = i;
 back(flow + 1); // arr의 인덱스를 +1 시켜준다.
 isUsed[i] = false;
 }
 */
