package CommonCode;

public class CommonCode {

	public static void printArray2D(int array[][], int n) {
		for(int i = 0; i<n ; i++) {
			for(int j = 0 ; j<n ; j++) {
				System.out.print(array[i][j]+"  ");
			}
			System.out.println();
		}
	}
	public static void printArray(int array[], int n) {
		for(int i =0; i<n ; i++)
			System.out.print(array[i]+" ");
	}
	
}
