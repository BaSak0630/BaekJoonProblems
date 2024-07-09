
import java.lang.Math;
public class parallel {

    class Solution {
        public int solution(int[][] dots) {
            int answer = 0;
            int x1 = dots[0][0];
            int y1 = dots[0][1];
            int x2 = dots[1][0];
            int y2 = dots[1][1];
            int x3 = dots[2][0];
            int y3 = dots[2][1];
            int x4 = dots[3][0];
            int y4 = dots[3][1];
       /* double[] inclinations = new double [6];
        inclinations[0] = Math.abs((y1 - y2)/(x1 - x2) + (y1 - y2)%(x1 - x2));
        inclinations[1] = Math.abs((y1 - y3)/(x1 - x3) + (y1 - y3)%(x1 - x3));
        inclinations[2] = Math.abs((y1 - y4)/(x1 - x4) + (y1 - y4)%(x1 - x4));
        inclinations[3] = Math.abs((y2 - y3)/(x2 - x3) + (y2 - y3)%(x2 - x3));
        inclinations[4] = Math.abs((y2 - y4)/(x2 - x4) + (y2 - y4)%(x2 - x4));
        inclinations[5] = Math.abs((y3 - y4)/(x3 - x4) +(y3 - y4)%(x3 - x4));

        for(int i= 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                if(inclinations[i] == inclinations[j] && i != j) answer = 1;
                break;
            }
        }*/
            double slope1 = (double) (y2 - y1) / (x2 - x1);
            double slope2 = (double) (y4 - y3) / (x4 - x3);
            if (slope1 == slope2) answer = 1;

            slope1 = (double) (y3 - y1) / (x3 - x1);
            slope2 = (double) (y2 - y4) / (x2 - x4);
            if (slope1 == slope2) answer = 1;

            slope1 = (double) (y4 - y1) / (x4 - x1);
            slope2 = (double) (y2 - y3) / (x2 - x3);
            if (slope1 == slope2) answer = 1;

            return answer;
        }
    }
}
