package baekjoon1260;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
  
public class Main {
      
    static int[][] graph;
    static boolean visited[];
    static int N;
    static int E;
    static int startPoint;
          
    public static void dfs(int i){
        visited[i] = true;
        System.out.print(i+" ");
          
        for(int j=1; j<=N; j++){
            if(graph[i][j]==1&& visited[j]==false){
                dfs(j);
            }
        }
    }
      
    public static void bfs(int i){
  
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(i);
        visited[i] = true;
        System.out.print(i+" ");
          
        int temp;
        while(!q.isEmpty()){
            temp = q.poll();
            for(int j=0; j<N+1; j++){
                if(graph[temp][j]==1&&visited[j]==false){
                    q.offer(j);
                    visited[j]=true;
                    System.out.print(j+" ");
                }
            }                       
        }
    }
      
    public static void main(String[] args) {
                  
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        graph = new int[1001][1001];
        E = sc.nextInt();
        visited = new boolean[10001];
        startPoint = sc.nextInt();
          
        int a,b;
          
        for(int i=1; i<=E; i++){
            a = sc.nextInt();
            b = sc.nextInt();
              
            graph[a][b] = graph[b][a] = 1;
        }
          
        dfs(startPoint);
          
        for(int j=1; j<=N; j++){
            visited[j]=false;
        }
        System.out.println();
          
        bfs(startPoint);
    }
}


/*
 * import java.io.BufferedReader; import java.io.IOException; import
 * java.io.InputStreamReader; import java.util.Collections; import
 * java.util.LinkedList; import java.util.Queue; import
 * java.util.StringTokenizer;
 * 
 * public class Main { public static int nodeCnt; public static
 * LinkedList<Integer>[] nodeList;
 * 
 * public static void main(String[] args) throws IOException{ BufferedReader br
 * = new BufferedReader(new InputStreamReader(System.in)); StringTokenizer st =
 * new StringTokenizer(br.readLine());
 * 
 * nodeCnt = Integer.parseInt(st.nextToken()); int lineCnt =
 * Integer.parseInt(st.nextToken()); int startNode =
 * Integer.parseInt(st.nextToken());
 * 
 * nodeList = new LinkedList[nodeCnt+1];
 * 
 * for(int i=0; i <= nodeCnt; i++) { nodeList[i] = new LinkedList<Integer>(); }
 * 
 * for(int i=0; i < lineCnt; i++) { st = new StringTokenizer(br.readLine());
 * 
 * int node1 = Integer.parseInt(st.nextToken()); int node2 =
 * Integer.parseInt(st.nextToken());
 * 
 * nodeList[node1].add(node2); nodeList[node2].add(node1);
 * 
 * Collections.sort(nodeList[node1]); Collections.sort(nodeList[node2]); }
 * 
 * StringBuilder dfsResult = new StringBuilder(); StringBuilder bfsResult = new
 * StringBuilder();
 * 
 * boolean[] dfsVisited = new boolean[nodeCnt+1]; boolean[] bfsVisited = new
 * boolean[nodeCnt+1];
 * 
 * dfs(startNode, dfsVisited, dfsResult); bfs(startNode, bfsVisited, bfsResult);
 * 
 * System.out.println(dfsResult + "\n" + bfsResult); }
 * 
 * public static void dfs(int node, boolean[] visited, StringBuilder sb) {
 * if(visited[node]) return;
 * 
 * visited[node] = true; sb.append(node + " "); for(int nextNode:nodeList[node])
 * { dfs(nextNode, visited, sb); } }
 * 
 * public static void bfs(int node, boolean[] visited, StringBuilder sb) {
 * Queue<Integer> queue = new LinkedList<Integer>();
 * 
 * queue.offer(node);
 * 
 * while(!queue.isEmpty()) { node = queue.poll();
 * 
 * if(visited[node]) continue;
 * 
 * visited[node] = true; sb.append(node + " ");
 * 
 * for(int nextNode:nodeList[node]) { queue.add(nextNode); } } } }
 */