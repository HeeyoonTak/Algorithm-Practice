package baekjoon9507;

import java.io.*;

//²á ÇÇº¸³ªÄ¡
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		long[] array = new long[68];

		array[0] = array[1] = 1;
		array[2] = 2;
		array[3] = 4;

		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			if (n > 3) {
				for (int i = 4; i <= n; i++) {
					array[i] = array[i - 1] + array[i - 2] + array[i - 3] + array[i - 4];
				}
			}
			bw.write(array[n] + "\n");
		}
		bw.close();
	}

}
