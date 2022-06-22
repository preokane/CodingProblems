import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'surfaceArea' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY A as parameter.
     */

    public static int surfaceArea(List<List<Integer>> A) {
        /*
         * Subtract method
         * Add all 4 faces (upside and downside already accounted for)
         * If a cell is NOT on an edge we subtract the common areas
         * Which are mutually hidden
         */
        int rows = A.size();
        int colls = A.get(0).size();
        int area = 2*rows*colls;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < colls; j++){
                area+=4*A.get(i).get(j);
                if(i != rows-1){
                    area -= 2 * min(A.get(i).get(j),A.get(i+1).get(j));
                }
                if( j != colls-1){
                    area -= 2 * min(A.get(i).get(j),A.get(i).get(j+1));
                }
            }
        }
        
        return area;
    }
    
    private static int min(int a, int b){
        return a <= b ? a : b;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int H = Integer.parseInt(firstMultipleInput[0]);

        int W = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> A = new ArrayList<>();

        IntStream.range(0, H).forEach(i -> {
            try {
                A.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
