import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekjoon_2455 {
    public static void main(String[] args) {
        String[] buffer = new String [4];
        String[] stationBuffer = new String[2];
        int[] people =new int[8];

        int max = 0;
        int in =0;
        int j = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            for(int i = 0; i < buffer.length; i++)
            {
                buffer[i] = br.readLine(); 
                stationBuffer = buffer[i].split(" ");
                people[j] = Integer.parseInt(stationBuffer[0]);
                people[j+1] = Integer.parseInt(stationBuffer[1]);
                j += 2;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
       
        j = 0;
        for(int i = 0; i < 4; i++)
        {
             in -= people[j];
             in += people[j+1];
             if(in > max)
             {
                max = in;
             }
             j +=2;
        }
        System.out.println(max);
    }
}
