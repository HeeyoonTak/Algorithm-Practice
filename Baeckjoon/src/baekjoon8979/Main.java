package baekjoon8979;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		int[][] array = new int[N][4];
		// 국가 수 등록
		for (int i = 0; i < N; i++) {
			array[i][0] = i + 1;
		}
		for (int j = 1; j < 4; j++) {
			for (int i = 0; i < N; i++) {
				
			}
		}
	}

}
