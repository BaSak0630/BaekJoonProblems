class DNode {
    DNode left;
    int data;
    DNode right;
    DNode(int x) {
        data = x;
        left = right = this;
    }
    DNode foo(DNode p) {
        this.left = p.left;
        this.right = p;
        p.left.right = this;
        p.left = this;
        return this;
    }
    void print() {
        DNode p = this;
        for(int i = 0; i < 5; i++) {
            System.out.print(p.data + " ");
            p = p.left;
        }
        System.out.println();
    }
}
class Test {
    public static void main(String args[])
    {
        int data[] = { 1, 2, 3, 4, 5 };
        DNode x = new DNode(data[0]);
        for(int i = 1; i < 5; i++) {
            DNode y = new DNode(data[i]);
            x = y.foo(x);
        }
        x.print();
    }
}