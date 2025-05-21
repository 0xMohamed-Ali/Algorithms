public class WQUPC {
    private int id[];
    private int size[];
    public WQUPC(int len)
    {
        id = new int[len];
        size = new int[len];
        for(int i = 0; i < id.length; i++)
            id[i] = i;
        for(int i = 0; i < size.length; i++)
            size[i] = 1;
    }
    private int root(int i){
        while(i != id[i]){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    public boolean connected(int p, int q){
        return root(p) == root(q);
    }
    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        if(j == i)
            return;
        if(size[i] < size[j]){
            id[i] = j;
            size[j] += size[i];
        }
        else
        {
            id[j] = i;
            size[i] += size[j];
        }
    }
}
