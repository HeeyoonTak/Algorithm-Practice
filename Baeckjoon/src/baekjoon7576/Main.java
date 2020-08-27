package baekjoon7576;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location {
	int x, y;

	public Location(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int M, N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int count = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); // °¡·Î Ä­ ¼ö
		N = Integer.parseInt(st.nextToken()); // ¼¼·ÎÄ­ ¼ö

		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		BFS();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					count = -1;
				}
			}
		}
		bw.write(count + "\n");
		bw.flush();
		br.close();
		bw.close();

	}

	public static void BFS() {
		Queue<Location> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					q.offer(new Location(i, j));
				}
			}
		}
		while (!q.isEmpty()) {
			Location l = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = l.x + dx[i];
				int nextY = l.y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX > N - 1 || nextY > M - 1) {
					continue;
				}
				if (visited[nextX][nextY]) {
					continue;
				}
				if (map[nextX][nextY] != 0) {
					continue;
				}
				visited[nextX][nextY] = true;
				map[nextX][nextY] = map[l.x][l.y] + 1;
				count = map[nextX][nextY] - 1;
				q.add(new Location(nextX, nextY));
			}
		}
	}
}
