package baekjoon6359;

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

		int T = Integer.parseInt(br.readLine());
		// �� �׽�Ʈ ���̽��� ���� �� ������ �޶����Ƿ� for �ȿ� �ִ´�
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			boolean[] array = new boolean[n+1];
			int count = 0;
			// �� ���� ���� ���� ���ݾƾ� �ϹǷ� 2�� ����
			for (int round = 1; round < array.length; round++) {
				for (int room = 1; room*round < array.length; room++) {
					if (array[room * round] ) {
						array[room * round] = false;
					} else {
						array[room * round] = true;
					}
				}
			}
			for (int i = 1; i < array.length; i++) {
				if(array[i]) {
					count++;
				}
			}
			bw.write(count+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}

}
