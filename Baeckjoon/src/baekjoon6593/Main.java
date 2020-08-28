package baekjoon6593;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location {
	int x, y, z;

	public Location(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main {

	static int L, R, C; // Ãþ,Çà,·Ä
	static char[][][] building;
	static boolean[][][] visited;
	static int[][][] count;
	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };
	static int minute;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());

			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			if (L == 0 && R == 0 && C == 0) {
				break;
			}
			building = new char[R][C][L];
			visited = new boolean[R][C][L];
			count = new int[R][C][L];

			for (int k = 0; k < L; k++) {
				for (int i = 0; i < R; i++) {
					String floor = br.readLine();
					for (int j = 0; j < C; j++) {
						building[i][j][k] = floor.charAt(j);
					}
				}
				bw.write("\n");
				bw.flush();
			}
			BFS();
			String message = "Escaped in " + minute + " minute(s).";
			if(L == 1 && R == 1 && C == 1) {
				message = "Trapped!";
			}
			for (int k = 0; k < L; k++) {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (building[i][j][k] == 'E') {
							message = "Trapped!";
						}
					}
				}
			}
			bw.write(message + "\n");
			bw.flush();
			bw.write("\n");
			bw.flush();
		}
	}

	public static void BFS() {
		Queue<Location> q = new LinkedList<>();
		for (int k = 0; k < L; k++) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (building[i][j][k] == 'S') {
						q.offer(new Location(i, j, k));
						count[i][j][k] = 0;
					}
				}
			}
		}
		minute = 0;
		while (!q.isEmpty()) {
			Location l = q.poll();
			for (int i = 0; i < 6; i++) {
				int nextX = l.x + dx[i];
				int nextY = l.y + dy[i];
				int nextZ = l.z + dz[i];

				if (nextX < 0 || nextY < 0 || nextZ < 0 || nextX > R - 1 || nextY > C - 1 || nextZ > L - 1) {
					continue;
				}
				if (visited[nextX][nextY][nextZ]) {
					continue;
				}
				if (building[nextX][nextY][nextZ] == '#') {
					continue;
				}
				visited[nextX][nextY][nextZ] = true;
				building[nextX][nextY][nextZ] = building[l.x][l.y][l.z];
				count[nextX][nextY][nextZ] = count[l.x][l.y][l.z] + 1;
				minute = count[nextX][nextY][nextZ];
				q.add(new Location(nextX, nextY, nextZ));

			}
		}

	}
}
