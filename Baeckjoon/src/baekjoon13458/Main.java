package baekjoon13458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // ����� ��
		int[] A = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken()); // �� ���ǽ� �� ���û� �Ҵ�
		}

		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken()); // �Ѱ����� �����ϴ� �ο���(�Ѱ����� ������ �� �Ѹ�)
		int C = Integer.parseInt(st.nextToken()); // �ΰ����� �����ϴ� �ο���(�����忡 ������ ����)
		int numOfVice; // �� ����� �� �ΰ��� ��
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
