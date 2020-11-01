import java.util.*;
import java.io.*;
 

class Solution{
    static FastReader sc=new FastReader();
    static PrintWriter writer=new PrintWriter(System.out);
    static char[][] g; 
    static int[][] vis, dist;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static int bfs(int x, int y){
        Queue<ArrayList<Integer>> q=new LinkedList<ArrayList<Integer>>();
        q.add(new ArrayList<>(Arrays.asList(x, y)));
        vis[x][y]=1;
        dist[x][y]=0;
        while(q.size()!=0) {
        	x=q.peek().get(0);
        	y=q.poll().get(1);
        	
        	if(g[x][y]=='E') return dist[x][y];
        	
        	for(int i=0;i<4;i++) {
        		if(isValid(x+dx[i], y+dy[i])) {
        			q.add(new ArrayList<>(Arrays.asList(x+dx[i], y+dy[i])));
        			vis[x+dx[i]][y+dy[i]]=1;
        			dist[x+dx[i]][y+dy[i]]=dist[x][y]+1;
        		}
        	}
        	
        }
        return -1;
    }

    static boolean isValid(int x, int y){
        int n=g.length;
        if(x<0 || x>=n || y<0 || y>=n) return false;

        if(vis[x][y]==1 || g[x][y]=='T') return false;

        return true;
    }
    
	public static void main(String[] args){
        int n=sc.nextInt();
        g=new char[n][n]; vis=new int[n][n]; dist=new int[n][n];
        int x=0, y=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
            	g[i][j]=sc.next().charAt(0);
            	if(g[i][j]=='S') {
            		x=i; y=j;
            	}
            }
        }
        System.out.println(bfs(x, y));
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
