package beakjoon2748;

//피보나치 DP
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] array = new long[91];
		array[0] = 0;
		array[1] = 1;
		for(int i=2;i<n+1;i++) {
			array[i]=array[i-2]+array[i-1];
		}
		System.out.println(array[n]);
	}

}
