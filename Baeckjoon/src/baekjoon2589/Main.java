package baekjoon2589;

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

	static char[][] map;
	static boolean[][] visited;
	static int[][] count;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int L, W;
	static int day;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken()); // За
		W = Integer.parseInt(st.nextToken()); // ї­

		map = new char[L][W];
		visited = new boolean[L][W];
		count = new int[L][W];

		for (int i = 0; i < L; i++) {
			String line = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		int maxNum = 0;
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 'L') {
					maxNum = Math.max(maxNum, BFS(i, j));
				}
			}
		}
		bw.write(maxNum + "\n");
		bw.flush();
		br.close();
		bw.close();
	}

	public static int BFS(int x, int y) {
		Queue<Location> q = new LinkedList<>();
		q.offer(new Location(x, y));
		visited[x][y] = true;
		count[x][y] = 0;
		day = 0;
		while (!q.isEmpty()) {
			Location l = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = l.x + dx[i];
				int nextY = l.y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX > L - 1 || nextY > W - 1) {
					continue;
				}
				if (visited[nextX][nextY]) {
					continue;
				}
				if (map[nextX][nextY] != 'L') {
					continue;
				}
				visited[nextX][nextY] = true;
				count[nextX][nextY] = count[l.x][l.y] + 1;
				day = Math.max(day, count[nextX][nextY]);
				q.add(new Location(nextX, nextY));
			}
		}
		return day;
	}
}
