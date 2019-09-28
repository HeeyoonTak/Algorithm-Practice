package baekjoon1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//sort inside
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] sort = new int[N];
		for(int i=0; i<sort.length; i++) {
			sort[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(sort);
		for(int i=sort.length-1; i>-1; i--) {
			System.out.println(sort[i]);
		}
	}

}
