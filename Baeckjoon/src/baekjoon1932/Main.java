package baekjoon1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		int array[][] = new int[n][];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				array[i][j] = Integer.parseInt(br.readLine());
			}
		}
	}

}
