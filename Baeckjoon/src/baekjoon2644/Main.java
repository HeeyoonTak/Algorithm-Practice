package baekjoon2644;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static ArrayList<Integer>[] list;
	public static boolean[] visited;
	public static int N;
	public static int start, end;
	public static int result = -1;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(br.readLine()); // 전체 사람 수
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken()); // 촌수를 계산해야 하는 서로 다른 두 사람의 번호

		int m = Integer.parseInt(br.readLine()); // 부모 자식들 간의 관계의 개수

		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}
		DFS(start, end, 0);
		bw.write(result + "\n");
		bw.flush();
		br.close();
		bw.close();
	}

	public static void DFS(int start, int end, int count) {
		visited[start] = true;
		for (int i : list[start]) {
			if (!visited[i]) {
				if (i == end) {
					result = count + 1;
				}
				DFS(i, end, count+1);
			}
		}
	}
}
