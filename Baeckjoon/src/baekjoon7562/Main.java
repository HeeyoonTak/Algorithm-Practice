package baekjoon7562;

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

	public static int l; // ü���� ����
	public static int startX;
	public static int startY;
	public static int endX;
	public static int endY; // ������ ����
	public static int dx[] = { -2, -1, -2, -1, 2, 1, 2, 1 };
	public static int dy[] = { -1, -2, 1, 2, -1, -2, 1, 2 };
	public static int[][] map;
	public static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); // �׽�Ʈ���̽�

		for (int i = 0; i < N; i++) {
			l = Integer.parseInt(br.readLine());
			map = new int[l][l];
			visited = new boolean[l][l];

			StringTokenizer st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			
			BFS(startX,startY);
			if(startX == endX && startY == endY) {
				map[endX][endY] = 0;
			}
			bw.write(map[endX][endY] + "\n");
		}
		bw.flush();
		br.close();
		bw.close();

	}

	public static void BFS(int x, int y) {
		Queue<Location> q = new LinkedList<>();
		q.offer(new Location(x, y)); // ���� ��ǥ ����
		while (!q.isEmpty()) {
			Location lo = q.poll();
			for (int i = 0; i < 8; i++) {
				// ������ �湮�� ��ǥ(���� ��ǥ + �̵� ���� ��ǥ)
				int nextX = lo.x + dx[i];
				int nextY = lo.y + dy[i];
				
				// ���� ��ǥ�� ������ �Ѿ�� �ǳʶٱ�
				if (nextX < 0 || nextY < 0 || nextX > l - 1 || nextY > l - 1) {
					continue;
				}
				// ���� ��ǥ�� �̹� �湮������ �ǳʶٱ�
				if(visited[nextX][nextY]) {
					continue;
				}
				map[nextX][nextY] = map[lo.x][lo.y] + 1;
				q.add(new Location(nextX,nextY));
				visited[nextX][nextY] = true;
			}
		}
	}

}
