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
		for (int i = 0; i < sort.length; i++) {
			sort[i] = Integer.parseInt(br.readLine());
		}
		int temp;
		Arrays.sort(sort);
		for (int i = 0; i < sort.length; i++) {
			for (int j = 1; j < sort.length; j++) {
				if(sort[j-1]>sort[j]) {
					temp=sort[j];
					sort[j]=sort[j-1];
					sort[j-1]=temp;
				}
			}
		}
		for (int i = 0; i < sort.length; i++) {
			System.out.println(sort[i]);
		}
	}

}
