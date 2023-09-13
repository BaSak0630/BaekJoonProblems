import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekjoon_1463 {
    static int operationCount = 0;
    class MakeOne{
        MakeOne(int data){
            if(data == 1)
            {
                //return 1;
            }
            else{
                if(data % 3 == 0){
                    data /= 3;
                    operationCount++;
                } 
                else if(data % 2 == 0) {
                    data /= 2;
                    operationCount++;
                }
                else{
                    data -=1;
                    operationCount++;
                }
            }
            
        }
    }
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int data = Integer.parseInt(br.readLine());
        

        //MakeOne(data);

        
        
    }
}
