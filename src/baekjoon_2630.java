import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2630 {
    public static int[][] paper;
    public static int bluePaper = 0;
    public static int whitePaper= 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int paperSize = Integer.parseInt(br.readLine());

        paper = new int[paperSize][paperSize];

        for (int i = 0; i < paperSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < paperSize; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        paperDivide(0,0,paperSize);

        System.out.println(whitePaper);
        System.out.println(bluePaper);
    }

    public static void paperDivide(int startX, int startY, int size) {
        int cutSize = size/2;

        if(checking(startX, startY, size)){
            int standard = paper[startX][startY];
            if(standard == 0) whitePaper++;
            else if(standard == 1) bluePaper++;
            return;
        }

        paperDivide(startX, startY, cutSize);
        paperDivide(startX + cutSize, startY, cutSize);
        paperDivide(startX, startY + cutSize, cutSize);
        paperDivide(startX + cutSize, startY + cutSize, cutSize);
    }
    public static boolean checking(int startX, int startY, int size){
        int standard = paper[startX][startY];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (standard != paper[startX + i][startY + j]) return false;
            }
        }
        return  true;
    }
}