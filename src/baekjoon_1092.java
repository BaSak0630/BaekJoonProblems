import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class baekjoon_1092 {
    public static void main(String[] args) {
        String[] buffer = new String [4];
        ArrayList<Integer> crane;
        ArrayList<Integer> box;
        int N = 0;
        int M = 0;
        int min = 0;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            for(int i = 0; i < buffer.length; i++)
            {
                buffer[i] = br.readLine();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        N = Integer.parseInt(buffer[0]);

        crane = new ArrayList<>();
        String[] bufferArr = buffer[1].split(" ");
        for(int i = 0; i < N; i++)
        {   
            crane.add(Integer.parseInt(bufferArr[i]));
        }

        M = Integer.parseInt(buffer[2]);

        box = new ArrayList<>();
        String[] boxWeightArr = buffer[3].split(" ");
        for(int i = 0; i < M; i++)
        {   
            box.add(Integer.parseInt(boxWeightArr[i]));
        }
        
        Collections.sort(crane,Comparator.reverseOrder());
        Collections.sort(box,Comparator.reverseOrder());

      
        if(box.get(0) > crane.get(0))
        {
            System.out.println(-1);
            return;
        }
    
        while(!box.isEmpty()) {
            int idx =0;
            for(int i=0; i< N; ) {
                if(idx == box.size()) break;
                else if(crane.get(i) >= box.get(idx)) {
                    box.remove(idx);
                    i++;
                }else idx++;
            }
            min++;
        }
        
        System.out.println(min);
    }
    
}
