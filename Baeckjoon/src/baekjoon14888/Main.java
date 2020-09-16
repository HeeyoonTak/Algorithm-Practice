package baekjoon14888;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static int N;
	public static int[] numbers;
	public static int[] operator;
	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		numbers = new int[N];
		operator = new int[4];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		DFS(numbers[0], 1);

		bw.write(max + "\n");
		bw.write(min + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void DFS(int num, int start) {
		if (start == N) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}

		for (int i = 0; i < 4; i++) {
			
			// 연산자가 있을 경우
			if (operator[i] > 0) {
				operator[i]--;
				
				switch(i) {
				
				case 0: DFS(num + numbers[start], start +1); break;
				case 1: DFS(num - numbers[start], start +1); break;
				case 2: DFS(num * numbers[start], start +1); break;
				case 3: DFS(num / numbers[start], start +1); break;
				
				}
				operator[i]++;
			}
		}
	}
}
