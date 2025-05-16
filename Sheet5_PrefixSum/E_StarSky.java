import java.util.*;

// Solution for the "Star Sky" problem
public class E_StarSky {
    public static void main(String[] args) {
        // Initialize scanner for input
        Scanner sc = new Scanner(System.in);

        // Read input: n (number of stars), q (number of queries), c (max brightness cycle)
        int n = sc.nextInt();
        int q = sc.nextInt();
        int c = sc.nextInt();

        // Store star data: x-coordinate, y-coordinate, initial brightness
        int[][] stars = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                stars[i][j] = sc.nextInt();
            }
        }

        // Create 3D array to store prefix sums for each time t (0 to c)
        int[][][] all_grids = new int[c + 1][101][101];

        // Compute brightness for each time t
        for (int t = 0; t <= c; t++) {
            // Initialize 2D grid for current time t
            int[][] grid = new int[101][101];

            // Add brightness of each star at time t to its position
            for (int i = 0; i < n; i++) {
                int x = stars[i][0];
                int y = stars[i][1];
                int b = stars[i][2];
                grid[x][y] += (b + t) % (c + 1); // Brightness cycles with period c+1
            }

            // Compute 2D prefix sums for efficient range queries
            for (int i = 1; i <= 100; i++) {
                for (int j = 1; j <= 100; j++) {
                    grid[i][j] = grid[i][j]
                            + grid[i - 1][j]
                            + grid[i][j - 1]
                            - grid[i - 1][j - 1];
                }
            }

            // Store computed grid for time t
            all_grids[t] = grid;
        }

        // Process each query
        for (int i = 0; i < q; i++) {
            // Read query: time t, rectangle coordinates (low_x, low_y, high_x, high_y)
            int t = sc.nextInt();
            int low_x = sc.nextInt();
            int low_y = sc.nextInt();
            int high_x = sc.nextInt();
            int high_y = sc.nextInt();

            // Normalize time t to fit within cycle c+1
            t %= (c + 1);

            // Get precomputed grid for time t
            int[][] grid = all_grids[t];

            // Calculate sum of brightness in the rectangle using inclusion-exclusion
            int ans = grid[high_x][high_y]
                    + grid[low_x - 1][low_y - 1]
                    - grid[low_x - 1][high_y]
                    - grid[high_x][low_y - 1];

            // Output the result
            System.out.println(ans);
        }

        // Close scanner to prevent resource leaks
        sc.close();
    }
}