import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon_10026 {
    public static class Pos {
        int pos_x;
        int pos_y;

        Pos(int x, int y) {
            pos_x = x;
            pos_y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        int N;
        int x;
        int y;
        int numOfpaintR = 0;
        int numOfpaintG = 0;
        int numOfpaintB = 0;
        int numOfpaintRG = 0;
        String stringBuffer;
        int[][] paint;
        boolean[][] isUsed;
        boolean[][] isUsedGR;
        char[] charBuffer ;
        Queue<Pos> queueR = new LinkedList<>();
        Queue<Pos> queueG = new LinkedList<>();
        Queue<Pos> queueB = new LinkedList<>();
        Queue<Pos> queueRG = new LinkedList<>();
        Pos tmpPos;
        Pos posBuffer;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paint = new int[N][N];
        isUsed = new boolean[N][N];
        isUsedGR = new boolean[N][N];
        charBuffer = new char[N];

        for (int i = 0; i < N; i++) {
            stringBuffer = br.readLine();
            for (int j = 0; j < N; j++) {
                charBuffer[j] = stringBuffer.charAt(j);
                if (charBuffer[j]== 'R') {
                    paint[i][j] = 1;
                } else if (charBuffer[j] == 'G') {
                    paint[i][j] = 2;
                } else if (charBuffer[j] == 'B') {
                    paint[i][j] = 3;
                }
            }
        }
        /*
        //주어지는 입력이 String 한줄인데 착각으로 nextToken을 받으면 각으로 끝는걸 까먹음
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (st.nextToken() == "R") {
                    paint[i][j] = 1;
                } else if (st.nextToken() == "G") {
                    paint[i][j] = 2;
                } else if (st.nextToken() == "B") {
                    paint[i][j] = 3;
                }
            }
        }
        */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (paint[i][j] == 1 && !isUsed[i][j]) {
                    posBuffer = new Pos(i,j);
                    queueR.add(posBuffer);
                    numOfpaintR++;
                    while(!queueR.isEmpty()) {
                        tmpPos = queueR.poll();
                        for (int k = 0; k < dx.length; k++) {
                            x = tmpPos.pos_x + dx[k];
                            y = tmpPos.pos_y + dy[k];
                            if (-1 < x && x < N && -1 < y && y < N) {
                                if (paint[x][y] == 1 && !isUsed[x][y]){
                                    posBuffer = new Pos(x,y);
                                    queueR.add(posBuffer);
                                    isUsed[x][y] = true;
                                }
                            }
                        }
                    }
                }
                else if (paint[i][j] == 2 && !isUsed[i][j]) {
                    posBuffer = new Pos(i,j);
                    queueG.add(posBuffer);
                    numOfpaintG++;
                    while(!queueG.isEmpty()) {
                        tmpPos = queueG.poll();
                        for (int k = 0; k < dx.length; k++) {
                            x = tmpPos.pos_x + dx[k];
                            y = tmpPos.pos_y + dy[k];
                            if (-1 < x && x < N && -1 < y && y < N) {
                                if (paint[x][y] == 2 && !isUsed[x][y]){
                                    posBuffer = new Pos(x,y);
                                    queueG.add(posBuffer);
                                    isUsed[x][y] = true;
                                }
                            }
                        }
                    }
                }
                else if (paint[i][j] == 3 && !isUsed[i][j]) {
                    posBuffer = new Pos(i, j);
                    queueB.add(posBuffer);
                    numOfpaintB++;
                    while (!queueB.isEmpty()) {
                        tmpPos = queueB.poll();
                        for (int k = 0; k < dx.length; k++) {
                            x = tmpPos.pos_x + dx[k];
                            y = tmpPos.pos_y + dy[k];
                            if (-1 < x && x < N && -1 < y && y < N) {
                                if (paint[x][y] == 3 && !isUsed[x][y]) {
                                    posBuffer = new Pos(x, y);
                                    queueB.add(posBuffer);
                                    isUsed[x][y] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(numOfpaintR + numOfpaintG + numOfpaintB);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (((paint[i][j] == 1) ||(paint[i][j] == 2)) && !isUsedGR[i][j]) {
                    posBuffer = new Pos(i, j);
                    queueRG.add(posBuffer);
                    numOfpaintRG++;
                    while (!queueRG.isEmpty()) {
                        tmpPos = queueRG.poll();
                        for (int k = 0; k < dx.length; k++) {
                            x = tmpPos.pos_x + dx[k];
                            y = tmpPos.pos_y + dy[k];
                            if (-1 < x && x < N && -1 < y && y < N) {
                                if (((paint[x][y] == 1) || (paint[x][y] == 2)) && !isUsedGR[x][y]) {
                                    posBuffer = new Pos(x, y);
                                    queueRG.add(posBuffer);
                                    isUsedGR[x][y] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(numOfpaintRG + numOfpaintB);
    }
}
