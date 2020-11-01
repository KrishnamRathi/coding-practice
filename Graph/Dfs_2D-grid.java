import java.util.*;
import java.io.*;
 

class Solution{
    static FastReader sc=new FastReader();
    static PrintWriter writer=new PrintWriter(System.out);
    static int[][] g, vis;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dfs(int x, int y){
        vis[x][y]=1;
        
        for(int i=0;i<4;i++){
            if(isValid(x+dx[i], y+dy[i])){
                dfs(x+dx[i], y+dy[i]);
            }
        }
    }

    static boolean isValid(int x, int y){
        int n=g.length;
        if(x<0 || x>=n || y<0 || y>=n) return false;

        if(vis[x][y]==1 || g[x][y]==0) return false;

        return true;
    }
    
	public static void main(String[] args){
        int n=sc.nextInt(), m=sc.nextInt();
        g=new int[n][m]; vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) g[i][j]=sc.nextInt();
        }
        int connected_components=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && g[i][j]==1){
                    connected_components++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(connected_components);
  }
  static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }
}
/*
0 0 1 0 1 1
0 1 1 0 0 1
0 1 0 0 0 0
1 0 1 1 0 0
0 0 0 1 0 0
0 1 1 0 1 1
*/
