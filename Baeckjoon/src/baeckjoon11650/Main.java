package baeckjoon11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] location = new int[N][2];
		for(int i=0; i<location.length; i++) {
			location[i][0]=Integer.parseInt(br.readLine());
			location[i][1]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(location, new Comparator<int[]>() {

			@Override
			public int compare(int[] x, int[] y) {
				// TODO Auto-generated method stub
				if(x[0] == y[0]) {
					return Integer.compare(x[1], y[1]);
				}
				return Integer.compare(x[0], y[0]);
			}
			
		});
		for(int i=0; i<location.length; i++) {
			System.out.println(location[i][0] + " " + location[i][1]);
		}
	}

}
