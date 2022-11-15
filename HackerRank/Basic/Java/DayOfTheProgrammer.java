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

class DayOfTheProgrammer {

    /*
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */

    public static String dayOfProgrammer(int year) {
		int daysInFebruary = getDaysInFebruary(year);
		int[] daysInMonths = {31, daysInFebruary, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int days = 256;

		for (int m = 0; m < daysInMonths.length; m++) {
			if (days <= daysInMonths[m]) {
				return String.format("%02d.%02d.%04d", days, m+1, year);
			}

			days = days - daysInMonths[m];
		}
		return "";
    }

	public static int getDaysInFebruary(int year) {
		if (year == 1918) {
			return 15;
		}
		// Gregorian Calendar
		else if (year > 1918) {
			return ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) ? 29 : 28;
		}
		// Julian Calendar
		else {
			return (year % 4 == 0) ?  29 : 28;
		}
	}

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
