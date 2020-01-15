package baekjoon1932;

//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
//		int n = Integer.parseInt(br.readLine());
		int n=sc.nextInt();
		int sum = 0;
		int array[][] = new int[n + 1][n + 1];
		array[0][0]=0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
//				array[i][j] = Integer.parseInt(br.readLine());
				array[i][j]=sc.nextInt();
				if (j == 1) {
					array[i][j] = array[i][j] + array[i - 1][j];
				} else if (i == j) {
					array[i][j] = array[i][j] + array[i - 1][j - 1];
				} else {
					array[i][j] = Math.max(array[i][j] + array[i - 1][j], array[i][j] + array[i - 1][j - 1]);
				}
				if (array[i][j] > sum) {
					sum = array[i][j];
				}
			}
		}
		System.out.println(sum);
	}

}

//import java.util.Scanner;

/*
 * public class Main {
 * 
 * public static void main(String[] args) {
 * 
 * Scanner sc = new Scanner(System.in);
 * 
 * int n = sc.nextInt();
 * 
 * int[][] list = new int[n + 1][n + 1];
 * 
 * int sum = 0;
 * 
 * for (int i = 1; i <= n; i++) {
 * 
 * for (int j = 1; j <= i; j++) {
 * 
 * list[i][j] = sc.nextInt();
 * 
 * if (j == 1) {
 * 
 * list[i][j] = list[i - 1][j] + list[i][j];
 * 
 * } else if (i == j) {
 * 
 * list[i][j] = list[i - 1][j - 1] + list[i][j];
 * 
 * } else {
 * 
 * list[i][j] = Math.max(list[i - 1][j], list[i - 1][j - 1]) + list[i][j];
 * 
 * }
 * 
 * if (list[i][j] > sum)
 * 
 * sum = list[i][j];
 * 
 * }
 * 
 * }
 * 
 * System.out.println(sum);
 * 
 * }
 * 
 * }
 */