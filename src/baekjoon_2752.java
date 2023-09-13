import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
//세수정령
public class baekjoon_2752
{
    public static void main(String[] args)
    {
        String buffer = "";
        int A = 0;
        int B = 0;
        int C = 0;

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        try
        {
            buffer = br.readLine();
        } 
        catch (Exception e)
        {
        }

        StringTokenizer st = new StringTokenizer(buffer);
        String tmp;
        tmp = st.nextToken();
        A = Integer.parseInt(tmp);
        tmp = st.nextToken();
        B = Integer.parseInt(tmp);
        tmp = st.nextToken();
        C = Integer.parseInt(tmp);

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(A,B,C));

        list.sort(Comparator.naturalOrder());

        String s = "";
        for(int i = 0 ; i <3; i++)
        {
            s += list.get(i) + " ";
        }
        System.out.println(s);
        
    }
}
