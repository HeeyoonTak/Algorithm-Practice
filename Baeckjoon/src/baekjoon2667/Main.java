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

		// ������ ��ȸ�Ͽ� 1�̰� �湮����� ������ �װ����� bfs ����
		for (int i = 0; i < Size; i++) {
			for (int j = 0; j < Size; j++) {
				if (danji[i][j] == 1 && !visited[i][j])
					BFS(i, j);
			}
		}
		
		// �켱����ť�� ����� ���� ����
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

			// ��ǥ ������ ������� �˻�
			if (currX < 0 || currY < 0 || currX >= Size || currY >= Size)
				continue;
			// ��ǥ�� 0�̸� �湮X
			if (danji[currY][currX] == 0)
				continue;
			// �̹� �湮 �ߴ��� Ȯ��
			if (visited[currY][currX])
				continue;

			// �ش� ��ǥ �湮 ������ ǥ���ϰ� count ����
			visited[currY][currX] = true;
			count++;

			// ��ó �����¿� ��ǥ�� ť�� �Է�
			queue.offer(new int[] { currY + 1, currX });
			queue.offer(new int[] { currY - 1, currX });
			queue.offer(new int[] { currY, currX + 1 });
			queue.offer(new int[] { currY, currX - 1 });
		}
		// ���� ���� ���� �켱���� ť�� ����
		pq.offer(count);
	}
}
