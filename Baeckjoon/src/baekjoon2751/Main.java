package baekjoon2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static void swap(int[] quick, int i, int j) {
		int temp = quick[j];
		quick[j] = quick[i];
		quick[i] = temp;
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] quick = new int[Integer.parseInt(br.readLine())];
		// ������ ����
		for (int i = 0; i < quick.length; i++) {
			quick[i] = Integer.parseInt(br.readLine());
		}
		// ����
		for (int i = 0; i < quick.length; i++) {

		}
	}
}
