import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekjoon_3003 {
    public static void main(String[] args) {
        String buffer = "";
        int[] sample =new int[] {1,1,2,2,2,8};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            buffer = br.readLine();
        } catch (Exception e) {
            // TODO: handle exception
        }
        String[] strArray = buffer.split(" ");
        int[] set = new int [strArray.length];

        for(int i = 0; i < strArray.length; i++)
        {
            set[i] = Integer.parseInt(strArray[i]);
        }
        for(int i = 0; i < set.length; i++)
        {
            if(sample[i] > set[i])
            {
                set[i] = sample[i] - set[i];
            }
            else if(sample[i] < set[i])
            {
                set[i] = sample[i] - set[i];
            }
            else if(sample[i] == set[i])
            {
                set[i] = 0;
            }
        }
        buffer = "";
        for(int i = 0; i < set.length; i++)
        {
            buffer = buffer.concat(Integer.toString(set[i]));
            buffer = buffer.concat(" ");
        }
        System.out.println(buffer);
       }
}
