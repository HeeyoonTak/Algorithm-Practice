package baekjoon2178;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int N, M;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dx = { 1, -1, 0, 0 };
	public static int[] dy = { 0, 0, 1, -1 }; // (dx, dy): ��, ��, ��, ��

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map  = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		BFS(0, 0);
		bw.write(map[N-1][M-1] + "\n");
		bw.flush();
		br.close();
		bw.close();
	}

	public static void BFS(int x, int y) {
		Queue<Location> q = new LinkedList<>();
		q.offer(new Location(x, y));
		while (!q.isEmpty()) {
			Location l = q.poll();
			for (int i = 0; i < 4; i++) {
				// ���� �湮�� XY ��ǥ
				int nextX = l.x + dx[i];
				int nextY = l.y + dy[i];

				// ���� ��ǥ�� ������ �Ѿ�� �ǳʶٱ�
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
					continue;
				}
				// ���� ��ǥ�� �̹� �湮������ �ǳʶٱ�, ���� �ƴ� ��ǥ �ǳ� �ٱ�
				if (visited[nextX][nextY] || map[nextX][nextY] == 0) {
					continue;
				}

				// ������ �湮�� ��ǥ�� ť�� ����
				q.add(new Location(nextX, nextY));
				// �迭�ȿ� ���� �湮�� ���� ���� �湮�ߴ� ������ 1ĭ �� �����ϹǷ� +1
				map[nextX][nextY] = map[l.x][l.y] + 1;
				// ���� ��ǥ�� �湮�������� ǥ��
				visited[nextX][nextY] = true;
			}
		}
	}

}

class Location {
	int x, y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}