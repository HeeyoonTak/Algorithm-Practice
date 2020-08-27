package baekjoon7569;

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

	public static int M; // 상자의 가로 칸의 수
	public static int N; // 상자의 세로칸 수
	public static int H; // 쌓아 올리는 상자 수
	public static int[][][] box;
	public static boolean[][][] visited;
	public static int[] dx = { -1, 1, 0, 0, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1, 0, 0 };
	public static int[] dz = { 0, 0, 0, 0, -1, 1 };
	public static int count = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		box = new int[N][M][H];
		visited = new boolean[N][M][H];
		
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		BFS();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < H; k++) {
					if(box[i][j][k] == 0) {
						count = -1;
					}
				}
			}
		}
		bw.write(count + "\n");
		bw.flush();
		br.close();
		bw.flush();
	}

	public static void BFS() {
		Queue<Location> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < H; k++) {
					if (box[i][j][k] == 1) {
						q.offer(new Location(i, j, k));
					}
				}
			}
		}

		while (!q.isEmpty()) {
			Location l = q.poll();
			for (int i = 0; i < 6; i++) {
				int nextX = l.x + dx[i];
				int nextY = l.y + dy[i];
				int nextZ = l.z + dz[i];

				if (nextX < 0 || nextY < 0 || nextZ < 0 || nextX > N - 1 || nextY > M - 1 || nextZ > H - 1) {
					continue;
				}
				if (visited[nextX][nextY][nextZ]) {
					continue;
				}
				if (box[nextX][nextY][nextZ] != 0) {
					continue; 
				}
				visited[nextX][nextY][nextZ]=true;
				box[nextX][nextY][nextZ] = box[l.x][l.y][l.z] + 1;
				count = box[nextX][nextY][nextZ] - 1;
				q.add(new Location(nextX, nextY, nextZ));
			}
		}
	}
}
