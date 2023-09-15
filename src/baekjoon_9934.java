import java.io.*;
import java.util.*;

//모르겠음
public class baekjoon_9934 {
    static int[][] tree;
    static int[] numbers;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int treeLevel = Integer.parseInt(br.readLine());

        int numOfNode = 2 ^ treeLevel - 1;
        numbers = new int[numOfNode];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < numOfNode; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        tree = new int[treeLevel][];
        for (int i = 0; i < treeLevel; i++) {
            if (i == 0) {
                tree[0] = new int[1];
            }
            tree[i] = new int [2^i];
        }
    }

}
/* static class CompleteBinaryTree{
        Node root;
        int level;
        Queue<Integer> number;
        public CompleteBinaryTree(int level,Queue<Integer> number) {
            this.level = level;
            this.number = number;
            root = new Node(1);
            root.makeNode(level);
            while(!number.isEmpty()){
                addNumber(number.poll());
            }
        }
        void addNumber(int data){
            root.addData(data);
        }
    }

    static class Node {
        Node left;
        int value;
        Node right;
        int lv;
        public Node(int lv) {
            left = right = null;
            value = -1;
            this.lv =  lv;
        }
        void makeNode(int level){
            if(level == 0){
                return;
            }else {
                left = new Node(this.lv+1);
                left.makeNode(level-1);
                right = new Node(this.lv+1);
                right.makeNode(level-1);
            }
        }
        void addData(int data){
            if (value == -1) {
                if(left == null){
                    value = data;
                }else {
                    if (left.value == -1) {
                        left.addData(data);
                    }else {
                        value = data;
                    }
                }
            }else {
                if(right != null){
                    if (right.value == -1) {
                        right.addData(data);
                    }
                }
            }
        }
    }*/