package baekjoon2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static int Size;
	public static int[][] danji;
	public static boolean[][] visited;

	public static PriorityQueue<Integer> pq;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Size = Integer.parseInt(br.readLine());

		danji = new int[Size][Size];
		visited = new boolean[Size][Size];

		pq = new PriorityQueue<Integer>();

		for (int i = 0; i < Size; i++) {
			String str = br.readLine();
			for (int j = 0; j < Size; j++) {
				danji[i][j] = Integer.parseInt(str.substring(j, j + 1));
			}
		}

		// 단지를 조회하여 1이고 방문기록이 없으면 그곳에서 bfs 시작
		for (int i = 0; i < Size; i++) {
			for (int j = 0; j < Size; j++) {
				if (danji[i][j] == 1 && !visited[i][j])
					BFS(i, j);
			}
		}
		
		// 우선순위큐의 사이즈가 단지 갯수
		System.out.println(pq.size());
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

	public static void BFS(int y, int x) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { y, x });
		int count = 0;

		while (!queue.isEmpty()) {
			int currX = queue.peek()[0];
			int currY = queue.peek()[1];
			queue.poll();

			// 좌표 범위를 벗어나는지 검사
			if (currX < 0 || currY < 0 || currX >= Size || currY >= Size)
				continue;
			// 좌표가 0이면 방문X
			if (danji[currY][currX] == 0)
				continue;
			// 이미 방문 했는지 확인
			if (visited[currY][currX])
				continue;

			// 해당 좌표 방문 했음을 표시하고 count 증가
			visited[currY][currX] = true;
			count++;

			// 근처 상하좌우 좌표를 큐에 입력
			queue.offer(new int[] { currY + 1, currX });
			queue.offer(new int[] { currY - 1, currX });
			queue.offer(new int[] { currY, currX + 1 });
			queue.offer(new int[] { currY, currX - 1 });
		}
		// 현재 단지 수를 우선순위 큐에 삽입
		pq.offer(count);
	}
}
