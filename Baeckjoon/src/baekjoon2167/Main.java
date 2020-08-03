package baekjoon2167;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); // ù° �ٿ� �迭�� ũ�� N, M(1 �� N, M �� 300)�� �־�����.
		int[][] array = new int[N][M];
		int sum = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken()); // ���� N���� �ٿ��� M���� ������ �迭�� �־�����.
			}
		}

		int K = Integer.parseInt(st.nextToken()); // �� ���� �ٿ��� ���� ���� �κ��� ���� K(1 �� K �� 10,000)�� �־�����.

		for (int r = 0; r < K; r++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int i = x1; i <= x2; i++) {
				for (int j = y1; j <= y2; j++) {
					sum += array[i][j];
				}
			}
			bw.write(sum);
			bw.write("\n");
		}
		bw.flush();
        bw.close();
        br.close();
	}

}
