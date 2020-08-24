package baekjoon1697;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int N, K;
	public static int visited[] = new int[100001];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		BFS(N, K);

		bw.write(visited[K] - 1 + "\n");
		bw.flush();
		br.close();
		bw.close();
	}

	public static void BFS(int N, int K) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		visited[N] = 1;

		while (!q.isEmpty()) {
			N = q.poll();
			if (N == K) {
				break;
			}
			if (N + 1 <= 100000 && visited[N + 1] == 0) {
				q.add(N + 1);
				visited[N + 1] = visited[N] + 1;
			}
			if (N - 1 >= 0 && visited[N - 1] == 0) {
				q.add(N - 1);
				visited[N - 1] = visited[N] + 1;
			}
			if (N * 2 <= 100000 && visited[N * 2] == 0) {
				q.add(N * 2);
				visited[N * 2] = visited[N] + 1;
			}
		}
	}
}
