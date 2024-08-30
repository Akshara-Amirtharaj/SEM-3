package unit_1;

public class q3 {

    public static void main(String[] args) {

        // Find the length of a one-dimensional array
        int[] oneDimensionalArray = {1, 2, 3, 4, 5};
        System.out.println("Length of one-dimensional array: " + oneDimensionalArray.length);

        // Demonstrate a one-dimensional array
        System.out.println("One-dimensional array elements:");
        for (int i = 0; i < oneDimensionalArray.length; i++) {
            System.out.print(oneDimensionalArray[i] + " ");
        }
        System.out.println();

        // Demonstrate a two-dimensional array
        int[][] twoDimensionalArray = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Two-dimensional array elements:");
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                System.out.print(twoDimensionalArray[i][j] + " ");
            }
            System.out.println(); // Move to the next row
        }

        // Demonstrate a multi-dimensional array (3D array in this case)
        int[][][] multiDimensionalArray = {
                {
                        {1, 2, 3},
                        {4, 5, 6}
                },
                {
                        {7, 8, 9},
                        {10, 11, 12}
                }
        };
        System.out.println("Three-dimensional array elements:");
        for (int i = 0; i < multiDimensionalArray.length; i++) {
            for (int j = 0; j < multiDimensionalArray[i].length; j++) {
                for (int k = 0; k < multiDimensionalArray[i][j].length; k++) {
                    System.out.print(multiDimensionalArray[i][j][k] + " ");
                }
                System.out.println(); // Move to the next 2D slice
            }
            System.out.println(); // Separate the blocks in the 3D array
        }
    }
}
