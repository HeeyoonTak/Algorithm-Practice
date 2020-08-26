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

	public static int l; // 체스판 길이
	public static int startX;
	public static int startY;
	public static int endX;
	public static int endY; // 시작점 끝점
	public static int dx[] = { -2, -1, -2, -1, 2, 1, 2, 1 };
	public static int dy[] = { -1, -2, 1, 2, -1, -2, 1, 2 };
	public static int[][] map;
	public static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); // 테스트케이스

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
		q.offer(new Location(x, y)); // 현재 좌표 대입
		while (!q.isEmpty()) {
			Location lo = q.poll();
			for (int i = 0; i < 8; i++) {
				// 다음에 방문할 좌표(현재 좌표 + 이동 가능 좌표)
				int nextX = lo.x + dx[i];
				int nextY = lo.y + dy[i];
				
				// 다음 좌표가 범위를 넘어가면 건너뛰기
				if (nextX < 0 || nextY < 0 || nextX > l - 1 || nextY > l - 1) {
					continue;
				}
				// 다음 좌표가 이미 방문했으면 건너뛰기
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
