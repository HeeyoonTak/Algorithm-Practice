package baekjoon4963;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int w, h; // 너비, 높이
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
	public static int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			int island = 0;
			map = new int[h][w]; // y축 x축
			visited = new boolean[h][w];
			if (w == 0 && h == 0) {
				break;
			}
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(!visited[i][j] && map[i][j] == 1) {
						bfs(i,j);
						island++;
					}
				}
			}
			System.out.println(island);
		}
	}

	public static void bfs(int y, int x) {
		Queue<Location> q = new LinkedList<>();
		q.offer(new Location(y, x));
		visited[y][x] = true;
		while (!q.isEmpty()) {
			Location l = q.poll();
			for (int i = 0; i < 8; i++) {
				int nextX = l.x + dx[i];
				int nextY = l.y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX > w - 1 || nextY > h - 1)
					continue;
				if (visited[nextY][nextX])
					continue;
				if (map[nextY][nextX] == 0)
					continue;
				visited[nextY][nextX] = true;
				q.add(new Location(nextY, nextX));
			}
		}
	}

}

class Location {
	int x, y;

	public Location(int y, int x) {
		this.x = x;
		this.y = y;
	}
}