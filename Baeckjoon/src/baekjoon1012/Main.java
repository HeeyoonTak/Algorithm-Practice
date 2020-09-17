package baekjoon1012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location {
	int x;
	int y;

	public Location(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int M, N, K, count;
	static int[][] farm;
	static boolean[][] visited;
	static int[] dirX = { -1, 1, 0, 0 };
	static int[] dirY = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int j = 0; j < T; j++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			count = 0;
			farm = new int[M][N];
			visited = new boolean[M][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				farm[x][y] = 1;
			}
			for (int x = 0; x < M; x++) {
				for (int y = 0; y < N; y++) {
					if (!visited[x][y] && farm[x][y] == 1) {
						bfs(x, y);
						count++;
					}
				}
			}
			System.out.println(count);
		}
		br.close();
	}

	public static void bfs(int x, int y) {
		Queue<Location> q = new LinkedList<>();
		visited[x][y] = true;
		q.offer(new Location(x, y));
		while (!q.isEmpty()) {
			Location l = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = dirX[i] + l.x;
				int nextY = dirY[i] + l.y;
				if (nextX > M - 1 || nextY > N - 1 || nextX < 0 || nextY < 0)
					continue;
				if (visited[nextX][nextY])
					continue;
				if (farm[nextX][nextY] != 1)
					continue;
				visited[nextX][nextY] = true;
				q.add(new Location(nextX, nextY));
			}
		}
	}
}