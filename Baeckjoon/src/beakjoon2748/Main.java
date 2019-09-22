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
		int[] array = new int[n];
		array[0] = 0;
		array[1] = 1;
		int sum=0;
		for(int i=0;i<array.length;i++) {
			sum+=array[i];
		}
	}

}
