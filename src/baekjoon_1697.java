import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] visited = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        if (N == K) {
            System.out.println("0");
        }else {
            while (!queue.isEmpty()){
                Integer poll = queue.poll();
                if (poll - 1 == K || poll + 1 == K || poll * 2 == K ){
                    System.out.println(visited[poll]+1);
                    break;
                }
                if (poll - 1 >= 0) {
                    if (visited[poll - 1] == 0) {
                        queue.add(poll - 1);
                        visited[poll - 1] = visited[poll] + 1;
                    }
                }
                if (poll + 1 < visited.length) {
                    if (visited[poll + 1] == 0) {
                        queue.add(poll + 1);
                        visited[poll + 1] = visited[poll] + 1;
                    }
                }
                if (poll * 2 < visited.length) {
                    if(visited[poll *2] == 0){
                        queue.add(poll * 2);
                        visited[poll * 2] = visited[poll] + 1;
                    }
                }
            }
        }
    }
}
