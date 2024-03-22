import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class baekjoon_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (binarySearch(A,x,0,A.length) >= 0) {
                System.out.println("1");
            } else System.out.println("0");
        }
    }
    static int binarySearch(int[] A, int key, int low, int high) {
        int mid;

        while(low <= high) {
            mid = (low + high) / 2;
            if (mid >= A.length) {
                return -1;
            }
            if(key == A[mid]) {
                return mid;
            } else if(key < A[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1; // 탐색 실패
    }
}
