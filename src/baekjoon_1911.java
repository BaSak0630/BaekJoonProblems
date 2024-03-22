import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class baekjoon_1911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] holes;
        int[] road;

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        holes = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            holes[i][0] =Integer.parseInt(st.nextToken());
            holes[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(holes, new Comparator<int []>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return Integer.compare(o1[1], o2[1]);
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int nulpan = 0;
        int range = 0;
        for(int i=0; i<N; i++) {
            if(holes[i][0] > range)
                range = holes[i][0];
            if(holes[i][1] >= range) {
                while(holes[i][1] > range) {
                    range += L;
                    nulpan ++;
                }
            }
        }

        System.out.println(nulpan);

    }
}
