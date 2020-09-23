package baekjoon14501;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static public int N;
	static public int[] t;
	static public int[] p;
	static public int[] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		t = new int[N + 1];
		p = new int[N + 1];
		dp = new int[N + 2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = N; i >= 1; i--) {
			if(i + t[i] - 1 <= N) {
				dp[i] = Math.max(p[i] + dp[i+t[i]], dp[i+1]);
			}else {
				dp[i] = dp[i+1];
			}
		}
		bw.write(dp[1] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
