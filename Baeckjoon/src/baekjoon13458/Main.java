package baekjoon13458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 고사장 수
		int[] A = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken()); // 각 강의실 별 응시생 할당
		}

		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken()); // 총감독이 감시하는 인원수(총감독은 시험장 당 한명)
		int C = Integer.parseInt(st.nextToken()); // 부감독이 감시하는 인원수(시험장에 여려명 가능)
		int numOfVice; // 각 고사장 별 부감독 수
		long sum = (long) N;

		for (int i = 0; i < N; i++) {
			A[i] -= B;
			if (A[i] > 0) {
				numOfVice = A[i] / C;
				if (A[i] % C != 0) {
					numOfVice += 1;
				}
				sum += numOfVice;
			}
		}
		System.out.println(sum);
	}

}
