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

	static int partition(int[] quick, int first, int end) {
		int key = quick[end];
		int i= first-1;
		for(int j = first; j<end; j++) {
			if(quick[j]<key) {
				swap(quick, i++, j);
			}
		}
		swap(quick, i+1, end);
		return i+1;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] quick = new int[Integer.parseInt(br.readLine())];
		// 베열에 저장
		for (int i = 0; i < quick.length; i++) {
			quick[i] = Integer.parseInt(br.readLine());
		}
		// 정렬
		for (int i = 0; i < quick.length; i++) {

		}
	}
}
