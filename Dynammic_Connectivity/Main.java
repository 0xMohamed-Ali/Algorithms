public class Main {
    public static void main(String[] args) {
        WQUPC inst = new WQUPC(100000000);

        inst.union(4, 5);
        inst.union(5, 6);
        inst.union(8,9);
        inst.union(555,9);
        inst.union(999,90);
        inst.union(200,209);
        inst.union(8,90);
        inst.union(990,10000);
        inst.union(444,99900);
        inst.union(5500,80000);
        inst.union(50000,1);
        inst.union(22222,505);
        inst.union(3333,22222);

        System.out.println(inst.connected(4, 6));
        System.out.println(inst.connected(8, 9));
        System.out.println(inst.connected(4, 9));
        inst.union(9, 4);
        System.out.println(inst.connected(5, 9));
    }
}
