import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_9663 {
    static int N;
    static int [][] bord;
    static boolean [][] attackable;
    static int count;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N =Integer.parseInt(st.nextToken());
        bord = new int[N][N];
        attackable = new boolean[N][N];

        back(0);
    }
    private static void back(int degree)
    {
        if(degree == N) {
            return;
        }
        for(int i = 0; i < N; i++){

        }
        back(degree+1);
    }
}

// 대각선의 좌표가 같은선상에 있는지는 오른쪽으로 내려가는 대각선은 x+y가 동일
// 왼쪽으로 내려가는 대각선은 x-Y가 동일시 동일선상에 있다.
// 백트래킹느 해를 찾아가는 도중, 지금의 경로가 해가 될 것 같지 않으면 그 경로를 더이상 가지 않고 되돌아갑니다.