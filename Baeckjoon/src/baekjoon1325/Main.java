package baekjoon1325;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int[] countNode;
	static int N, M;
	static int count;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 컴퓨터 수
		M = Integer.parseInt(st.nextToken()); // 연결 수

		list = new ArrayList[N + 1];
		countNode = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[b].add(a);
		}

		for (int i = 1; i < N + 1; i++) {
			visited = new boolean[N + 1];
			DFS(i);
			countNode[i] = count;
		}

		int maxNum = 0;
		for (int i = 1; i < N + 1; i++) {
			if(maxNum < countNode[i])
				maxNum = countNode[i];
		}

		for (int i = 1; i < N + 1; i++) {
			if (countNode[i] == maxNum) {
				bw.write(i + " ");
			}
		}
		bw.write("\n");

		bw.flush();
		bw.close();
		br.close();
	}

	public static void DFS(int start) {
		visited[start] = true;
		count = 0;
		for (int i : list[start]) {
			if (!visited[i]) {
				DFS(i);
				count++;
			}
		}
	}
}
