package baekjoon11725;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] parents;
	static ArrayList<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine()); // 노드의 갯수

		list = new ArrayList[N + 1];
		parents = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		// 그래프 생성(무향)
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		DFS(1);
		for (int i = 2; i <= N; i++) {
			bw.write(parents[i] + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}

	public static void DFS(int start) {
		// DFS 과정을 통해 부모 노드를 등록
		visited[start] = true;
		for (int i : list[start]) {
			if (!visited[i]) {
				parents[i] = start;
				DFS(i);
			}
		}
	}
}
