import com.example.TriangleSum;
import junit.framework.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EulerTriangleTest {

    @Test
    public void itFindsMaximumSumForBigTriangle() throws IOException {
        TriangleSum solver = new TriangleSum();
        int[][] triangle = readTriangle();
        solver.findLargestSum(triangle);
        Assert.assertEquals(solver.findLargestSum(triangle), 7273);
    }

    private int[][] readTriangle() throws IOException {
        int[][] t = new int[100][];
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File("problem/triangle.txt")));
            String line = null;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] numbers = line.split(" ");
                t[i] = new int[numbers.length];

                for (int j = 0; j < numbers.length; j++) {
                    t[i][j] = Integer.parseInt(numbers[j]);
                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                br.close();
        }
        return t;
    }

    @Test
    public void itFindsMaximumSumForASampleTriangle() {
        TriangleSum solver = new TriangleSum();
        int[][] triangle = {
                {59},
                {73, 41},
                {52, 40, 9},
                {26, 53, 6, 34},
                {10, 51, 87, 86, 81},
                {61, 95, 66, 57, 25, 68},
                {90, 81, 80, 38, 92, 67, 73}
        };
        Assert.assertEquals(solver.findLargestSum(triangle), 473);
    }
}
