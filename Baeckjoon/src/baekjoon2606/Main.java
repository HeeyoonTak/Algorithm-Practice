package baekjoon2606;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int l;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int count;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine()); // 컴퓨터의 수(노드)
		l = Integer.parseInt(br.readLine()); // 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수

		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < l; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		DFS(1);
		count = 0;
		for (int i = 1; i < visited.length; i++) {
			if (visited[i]) {
				count++;
			}
		}
		bw.write(count - 1 + "\n"); // 1번 컴퓨터 본인이 감염시킨 컴퓨터 갯수 이므로 1을 빼준다
		bw.flush();
		br.close();
		bw.close();
	}

	public static void DFS(int start) {
		visited[start] = true;
		for (int i : list[start]) {
			if (!visited[i]) {
				DFS(i);
			}
		}
	}

}
