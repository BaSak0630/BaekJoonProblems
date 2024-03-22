import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon_2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Stack<int[]> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(stack.isEmpty()) {
                sb.append(0+" ");
            }
            else{
                while(true) {
                    int[] data = stack.peek();
                    int tIdx = data[0];
                    int tHeight = data[1];
                    if(tHeight > num) {
                        sb.append(tIdx+" ");
                        break;
                    }else {
                        stack.pop();
                    }

                    if(stack.isEmpty()) {
                        sb.append(0+" ");
                        break;
                    }
                }
            }
            stack.push(new int[] {i+1, num});
        }
        System.out.println(sb.toString());
    }
}
