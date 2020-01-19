package baekjoon9507;

//²á ÇÇº¸³ªÄ¡
public class Main {

	public static void main(String[] args) {

		
	}

	public int koong(int n) {
		if (n < 2) {
			return 1;
		} else if (n == 2) {
			return 2;
		} else if (n == 3) {
			return 4;
		} else {
			return koong(n - 1) + koong(n - 2) + koong(n - 3) + koong(n - 4);
		}
	}
}
