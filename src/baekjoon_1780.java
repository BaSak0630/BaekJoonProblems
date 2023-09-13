/*백준 1780 - 조잉의 개수 -재귀*/

/*문제
N×N크기의 행렬로 표현되는 종이가 있다. 종이의 각 칸에는 -1, 0, 1 중 하나가 저장되어 있다.
우리는 이 행렬을 다음과 같은 규칙에 따라 적절한 크기로 자르려고 한다.

1.만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
2.(1)이 아닌 경우에는 종이를 같은 크기의 종이 9개로 자르고,각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.

이와 같이 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수,
1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 37, N은 3k 꼴)이 주어진다. 다음 N개의 줄에는 N개의 정수로 행렬이 주어진다.

출력
첫째 줄에 -1로만 채워진 종이의 개수를, 둘째 줄에 0으로만 채워진 종이의 개수를, 셋째 줄에 1로만
 채워진 종이의 개수를 출력한다.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1780 {
    public static int[][] paper;
    public static int miunsCount;
    public static int zeroCount;
    public static int oneCount;

    static boolean oneChecking(int startX, int startY, int size){
        int standard = paper[startX][startY];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (standard != paper[startX+i][startY+j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void cuting(int startX, int startY, int size) {
        if (oneChecking(startX, startY, size)) {
            if(paper[startX][startY] == -1) miunsCount++;
            else if(paper[startX][startY] == 0) zeroCount++;
            else oneCount++;

            return;
        }
        int cutSize = size/3;

        cuting(startX, startY, cutSize);
        cuting(startX, startY + cutSize, cutSize);
        cuting(startX, startY + cutSize * 2, cutSize);

        cuting(startX + cutSize, startY, cutSize);
        cuting(startX + cutSize, startY + cutSize, cutSize);
        cuting(startX + cutSize, startY + cutSize * 2, cutSize);

        cuting(startX + cutSize * 2, startY, cutSize);
        cuting(startX + cutSize * 2, startY + cutSize, cutSize);
        cuting(startX + cutSize * 2, startY + cutSize * 2, cutSize);
    }

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

        cuting(0, 0, paperSize);

        System.out.println(miunsCount);
        System.out.println(zeroCount);
        System.out.println(oneCount);
    }
}
/*    static int[][] paper;
    static int miunsCount;
    static int zeroCount;
    static int oneCount;

    static boolean checking(int startX, int startY, int endX, int endY){
        //true => 한장     false => 여러장
        boolean flag = true;
        int standard = paper[startX][startY];
        int sizeX = endX - startX;
        int sizeY = endY - endX;
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if(standard != paper[i][j]){
                    flag = false;
                }
            }
        }
        return flag;
    }

    static void cut(int startX, int startY, int endX, int endY){
        int sizeX = endX - startX;
        int sizeY = endY - endX;
        int cutX = sizeX/3;
        int cutY = sizeY/3;
        if (sizeX == 1 && sizeY ==1 ) {
            if(paper[0][0] == -1) miunsCount++;
            else if(paper[0][0] == 0) zeroCount++;
            else if(paper[0][0] == 1) oneCount++;
        }else if (sizeX == 2 && sizeY ==2 ) {
            if(checking(startX, startY, endX, endY)){
                //한장
                System.out.println("2 한장");
                if(paper[0][0] == -1) miunsCount++;
                else if(paper[0][0] == 0) zeroCount++;
                else if(paper[0][0] == 1) oneCount++;
            }else{
                //여러장
                System.out.println("2 여러장");
                for (int i = 0; i < sizeX; i++) {
                    for (int j = 0; j < sizeY; j++) {
                        if(paper[i][j] == -1) miunsCount++;
                        else if(paper[i][j]  == 0) zeroCount++;
                        else if(paper[i][j]  == 1) oneCount++;
                    }
                }
            }
        }else {
            if(checking(startX,startY,endX,endY)){
                if(paper[startX][startY] == -1) miunsCount++;
                else if(paper[startX][startY] == 0) zeroCount++;
                else if(paper[startX][startY] == 1) oneCount++;
            }else if(!checking(startX,startY,endX,endY)){
                cut(startX, startY, cutX, cutY);
                cut(cutX, startY, cutX * 2, cutY);
                cut(cutX * 2, startY, sizeX, cutY);

                cut(startX, cutY, cutX, cutY * 2);
                cut(cutX, cutY, cutX * 2, cutY * 2);
                cut(cutX * 2, cutY, sizeX, cutY * 2);

                cut(startX, cutY * 2, cutX, sizeY);
                cut(cutX, cutY * 2, cutX * 2, sizeY);
                cut(cutX * 2, cutY * 2, sizeX, sizeY);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int paperSize = Integer.parseInt(br.readLine());
        paper = new int[paperSize][paperSize];

        for (int i = 0; i < paperSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < paperSize; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0, 0, paperSize, paperSize);

        System.out.println(miunsCount);
        System.out.println(zeroCount);
        System.out.println(oneCount);
    }*/
/*static class Paper{
       public static int miunsCount;
        public static int zeroCount;
        public  static int oneCount;
        public  static int[][] paper;
        int paperSize;
        Paper(int matrixSize){
            paperSize = matrixSize;
            paper = new int[paperSize][paperSize];
            miunsCount = 0;
            zeroCount = 0;
            oneCount = 0;
        }
        public static boolean checking(int startX, int startY, int endX ,int endY) {
            System.out.println("checking");
            boolean flag = false;
            int standard = paper[startX][startX];
            int sizeX = endX - startX;
            int sizeY = endY - startY;

            for (int i = 0; i < sizeX; i++) {
                for (int j = 0; j < sizeY; j++) {
                    if(paper[startX + i][startY +j] !=standard) {
                        flag = true;
                    }
                }
            }
            return flag;
        }
        public static void cut(int startX, int startY, int endX ,int endY){
            System.out.println("cut");
            int sizeX = endX - startX;
            int sizeY = endY - startY;
            if (sizeX == 1 && sizeY == 1) {
                if(paper[startX][startY] == -1) miunsCount++;
                else if(paper[startX][startY]== 0) zeroCount++;
                else if(paper[startX][startY]== 1) oneCount++;
            } else {
                if(checking(startX,startY,endX,endY)){
                    if(paper[startX][startY] == -1) miunsCount++;
                    else if(paper[startX][startY]== 0) zeroCount++;
                    else if(paper[startX][startY]== 1) oneCount++;
                }else {
                    int cutX = sizeX/3;
                    int cutY = sizeY/3;

                    cut(0, 0, cutX, cutY);
                    cut(cutX, 0, cutX * 2, cutY);
                    cut(cutX * 2, 0, sizeX, cutY);

                    cut(0, cutY, cutX, cutY * 2);
                    cut(cutX, cutY, cutX * 2, cutY * 2);
                    cut(cutX * 2, cutY, sizeX, cutY * 2);

                    cut(0, cutY * 2, cutX, sizeY);
                    cut(cutX, cutY * 2, cutX * 2, sizeY);
                    cut(cutX * 2, cutY * 2, sizeX, sizeY);
                }

            }
        }

    }


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int matrixSize = Integer.parseInt(br.readLine());

        Paper paper = new Paper(matrixSize);

        for (int i = 0; i < matrixSize; i++) {
            String buffer = br.readLine();
            for (int j = 0; j < matrixSize; j++) {
                paper.paper[i][j] = buffer.charAt(j);
                if(matrixSize == 1){
                    if(paper.paper[i][j] == -1){
                        paper.miunsCount++;
                        System.out.println(paper.miunsCount);
                    }
                    else if(paper.paper[i][j]== 0){
                        paper.zeroCount++;
                    }
                    else if(paper.paper[i][j]== 1){
                        paper.oneCount++;
                    }
                    System.out.println(paper.miunsCount);
                    System.out.println(paper.zeroCount);
                    System.out.println(paper.oneCount);
                    return;
                }
            }
        }
        paper.cut(0,0,matrixSize,matrixSize);

        System.out.println(paper.miunsCount);
        System.out.println(paper.zeroCount);
        System.out.println(paper.oneCount);
    }
*/
/*
* class Paper{
        private int[][] paperMatrix;
        private int paperSize;
        private int minusCount;
        private int zeroCount;
        private int oneCount;

        Paper(int size){
            paperSize = size;
            paperMatrix = new int[paperSize][paperSize];
            minusCount = 0;
            zeroCount = 0;
            oneCount = 0;
        }

        void cut(int size,int start,int end){
            if(checking(size, start, end)){
                countPlus(start,start);
            }
            else if(!checking(size, start, end)) {
                int cutNum = size/3;
                if(size == 1){
                    countPlus(start,end);
                } else if (size == 2) {
                    for (int i = 0; i < size; i++) {
                        for (int j = 0; j < size; j++) {
                            countPlus(i,j);
                        }
                    }
                } else {

                }
            }
        }
        boolean checking(int size,int start,int end){
            boolean flag = true;
            int standard = paperMatrix[start][start];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (standard != paperMatrix[i][j]) {
                        flag = false;
                    }
                }
            }
            return flag;
        }
        void countPlus(int s,int e){
            if(paperMatrix[s][e] == -1) minusCount++;
            else if(paperMatrix[s][e] == 0) zeroCount++;
            else if(paperMatrix[s][e] == 1) oneCount++;
        }

        void printAnswer(){
            System.out.println(minusCount);
            System.out.println(zeroCount);
            System.out.println(oneCount);
        }
    }

    public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Paper paper = new Paper(Integer.parseInt(br.readLine()));

        //데이터 입력
        for (int i = 0; i < paper.paperSize; i++) {
            String buffer = br.readLine();
            for (int j = 0; j < paper.paperSize; j++) {
                paper.paperMatrix[i][j] = buffer.charAt(j);
            }
        }
        paper.cut(paper.paperSize,0,paper.paperSize);

        paper.printAnswer();
    }*/
//마지막 한개남으면 count  ++
/*
if(checking(0, 0, matrixNum, paper)){
            System.out.println(minusCount);
            System.out.println(zeroCount);
            System.out.println(oneCount);
        }else {
            cut(matrixNum/3);
        }
    }
    public static void cut(int size){

    }
    public static boolean checking(int pieceX, int pieceY, int size, int[][] paper){
        boolean flag = true;
        int standard = paper[pieceX][pieceY];
        for(int i = 0; i < size; i++) {
            for (int j = 0; i < size; j++) {
                if(standard != paper[pieceX+i][pieceY+j]){
                    flag = false;
                }
                else{
                    if(standard == -1) minusCount++;
                    else if(standard == 0) zeroCount++;
                    else if (standard == 1) oneCount++;
                }
            }
        }
        return  flag;
    }
    */