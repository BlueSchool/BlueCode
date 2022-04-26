
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 12345
 */
class DFS{
    int n, m, d;
    int[][] a;  // luu su lien ket u <-> v: a[u][v] = 1;
    int[] fre;  // danh dau da den dinh u ch? u:ok  => fre[u] = 1;
    int[] res;  // mang luu ket qua

    public DFS() {
        d = 0;
        a = new int[101][101];
        fre = new int[101];
        res = new int[1000];
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <= m; i++){
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            a[u][v] = 1;
            a[v][u] = 1;
        } 
        d = 0;
    }
    
    public void run(int u){
        for(int i = 1; i <= n; i++){// duyet tat ca cac dinh
            if(fre[i] == 0 && a[u][i] == 1){    // neu dinh i ch di va u den dc i
                fre[i] = 1;
                d++;
                res[d] = i;
                run(i);         // thi minh di dinh i
                fre[i] = 0;     // tra ve ch di??? => lat co quay lai thi con co cai de di
            }
        }
    }

    public void output(){
        //System.out.println();
        //System.out.println("---------");
        for(int i = 0; i < n; i++){
            System.out.println(res[i]);
        }
    }
}

public class Program {
    public static void main(String[] args) {
        DFS go = new DFS();
        go.input();
        go.fre[1] = 1;
        go.res[0] = 1;
        go.run(1);
        go.output();
    }
}
