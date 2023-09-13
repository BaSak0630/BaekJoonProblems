import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekjoon_10807 {
    public static void main(String[] args) {
        String buffer = "";
        int[] numArray;
        int N = 0;
        int v = 0;
        int count= 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            buffer = br.readLine();

        }catch (Exception e) {
          
        }
        N = Integer.parseInt(buffer);
        numArray = new int[N];
        try {
            buffer = br.readLine();
        } catch (Exception e) {
            // TODO: handle exception
        }
      
        String[] strArray = buffer.split(" ");
        for(int i = 0; i < numArray.length; i++)
        {
            numArray[i] = Integer.parseInt(strArray[i]);
        }
        try {
            buffer = br.readLine();
        } catch (Exception e) {
            // TODO: handle exception
        }
        v = Integer.parseInt(buffer);
        for(int i = 0; i < numArray.length; i++)
        {
            if(numArray[i] == v)
            {
                count++;
            }
        }
        System.out.println(count);
    }
}


