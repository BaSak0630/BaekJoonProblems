import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1002 {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int numOfTestCase =Integer.parseInt(br.readLine());
        double[][] posData = new double[numOfTestCase][6];
        int[] result = new int [numOfTestCase];
        double x1;
        double y1;
        double r1;
        double x2;
        double y2;
        double r2;
        double distance;


        for(int i = 0; i < numOfTestCase; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 6; j++){
                posData[i][j] = Double.parseDouble(st.nextToken());
            }
        }

        for(int i = 0; i < numOfTestCase; i++){
            x1 = posData[i][0];
            y1 = posData[i][1];
            r1 = posData[i][2];
            x2 = posData[i][3];
            y2 = posData[i][4];
            r2 = posData[i][5];
            distance = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
        
            if(x1 == x2 && y1 == y2){
                //동심원인 경우
                if(r1 == r2) result[i] = -1;
                else result[i] = 0;
            }
            else{
                //동심원이 아닌경우
                if(r1 + r2 == distance) result[i] = 1;  //한접점에서 만남
                else if(r1 +r2 > distance){         
                    if(distance + r1 == r2 || distance + r2 == r1) result[i] = 1;
                    else if(r1 + distance < r2||  r2 + distance < r1 )result[i] = 0;
                    else result[i] = 2;
                }
                else if(r1 + r2 < distance) result[i] = 0;
            }
        }
        for(int i = 0; i < result.length; i++)
        {
            System.out.println(result[i]);
        }
        
    }
}
/*

        for(int i = 0; i < numOfTestCase; i++){
            x1 = posData[i][0];
            y1 = posData[i][1];
            r1 = posData[i][2];
            x2 = posData[i][3];
            y2 = posData[i][4];
            r2 = posData[i][5];
            distance = Math.sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)));
            
            if(x1 == x2 && y1 == y2){
                if(r1 == r2) result[i] = -1;
                else result[i] = 0;
            }
            else{
                if(distance == r1 +r2) result[i] = 1;
                else if(distance > r1 + r2) result[i] = 0;
                else if(distance < r1 +r2){
                     if(r1 + distance == r2 || r2 + distance == r1 ) result[i] = 1;
                     else result[i] = 2;
                }
            }
        }
        for(int i = 0; i < result.length; i++)
        {
            System.out.println(result[i]);
        }
        
 */