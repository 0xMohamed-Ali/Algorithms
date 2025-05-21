public class QuickUnion {
    private int id[];
    public QuickUnion(int size){
        id = new int[size];
        for(int i = 0; i < id.length; i++)
            id[i] = i;
    }
    private int root(int i){
        while (i != id[i])
            i = id[i];
        return i;
    }
    public boolean connected(int q, int p){
        return root(p) == root(q);
    }
    public void union(int q, int p){
        int i = root(p);
        int j = root(q);
        id[i] = j;
    } 
}
