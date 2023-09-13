import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_15649 {
    static int N, M;
    static int[] arr = new int[9];
    static boolean[] isUsed = new boolean[9];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //Scanner sc = new Scanner(System.in); //런타임 에러

        N =Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());

        back(0);
    }

    private static void back(int flow) {
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
    byte a = in.nextByte(); 		// byte 형 입력 및 리턴
    short b = in.nextShort(); 		// short 형 입력 및 리턴
    int c = in.nextInt(); 			// int 형 입력 및 리턴
	long d = in.nextLong(); 		// long 형 입력 및 리턴

	float e = in.nextFloat(); 		// float 형 입력 및 리턴
	double f = in.nextDouble(); 	// double 형 입력 및 리턴

	boolean g = in.nextBoolean(); 	// boolean 형 입력 및 리턴
*/