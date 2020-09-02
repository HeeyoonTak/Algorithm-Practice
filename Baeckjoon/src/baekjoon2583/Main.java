package baekjoon2583;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Location {
	int y, x;

	public Location(int y, int x) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int M, N, K;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][] visited;
	static PriorityQueue<Integer> pq;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visited = new boolean[M][N];
		pq = new PriorityQueue<Integer>();

		for (int i = 0; i < K; K++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for( int y = y1; y < y2; y++) {
				for( int x = x1; x < x2; x++) {
					map[y][x] = 1;
				}
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 1 && !visited[i][j]) {
					BFS(i, j);
				}
			}
		}
		bw.write(pq.size());
		bw.flush();
		while(!pq.isEmpty()) {
			bw.write(pq.peek());
			bw.flush();
		}
		br.close();
		bw.close();
	}

	public static void BFS(int y, int x) {
		Queue<Location> q = new LinkedList<>();
		q.offer(new Location(y, x));
		visited[y][x] = true;
		int countNode = 0;
		while (!q.isEmpty()) {
			Location l = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextY = l.y + dy[i];
				int nextX = l.x + dx[i];

				if (nextY < 0 || nextX < 0 || nextY > M - 1 || nextX > N - 1)
					continue;
				if (map[nextY][nextX] == 1)
					continue;
				if (visited[nextY][nextX])
					continue;
				visited[nextY][nextX] = true;
				countNode++;
				q.add(new Location(nextY, nextX));
			}
		}
		pq.offer(countNode);
	}
}
