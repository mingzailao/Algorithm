package Fundamentals.UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by apple on 16/7/4.
 */
public class UF {
    private int[] id;
    private int count;

    public UF(int count) {
        this.count = count;
        id=new int[count];
        for (int i = 0; i < count; i++) {
            id[i]=i;
        }
    }

    public int getCount() {
        return count;
    }
    public boolean connected(int p,int q){
        return find(p)==find(q);
    }
    public int find(int p){
        return id[p];
    }
    public void union(int p,int q){
        int pID=find(p);
        int qID=find(q);
        if (pID==qID){
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i]==pID){
                id[i]=qID;
            }
        }
        count--;
    }
    public static void main(String[] args){
        int N= StdIn.readInt();
        UF uf=new UF(N);
        while (!StdIn.isEmpty()){
            int p= StdIn.readInt();
            int q= StdIn.readInt();
            if (uf.connected(p,q)) continue;
            uf.union(p,q);
            StdOut.println(p+" "+q);
        }
        StdOut.println(uf.getCount()+" components");
    }
}
