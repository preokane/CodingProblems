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

public class TimeInWords {

	private static Map<Integer,String> englishDict = new HashMap<>();
	static {
		englishDict.put(1, "one");
		englishDict.put(2, "two");
		englishDict.put(3, "three");
		englishDict.put(4, "four");
		englishDict.put(5, "five");
		englishDict.put(6, "six");
		englishDict.put(7, "seven");
		englishDict.put(8, "eight");
		englishDict.put(9, "nine");
		englishDict.put(10, "ten");
		englishDict.put(11, "eleven");
		englishDict.put(12, "twelve");
		englishDict.put(13, "thirteen");
		englishDict.put(14, "fourteen");
		englishDict.put(15, "quarter");
		englishDict.put(16, "sixteen");
		englishDict.put(17, "seventeen");
		englishDict.put(18, "eighteen");
		englishDict.put(19, "nineteen");
		englishDict.put(20, "twenty");
		englishDict.put(21, "twenty one");
		englishDict.put(22, "twenty two");
		englishDict.put(23, "twenty three");
		englishDict.put(24, "twenty four");
		englishDict.put(25, "twenty five");
		englishDict.put(26, "twenty six");
		englishDict.put(27, "twnety seven");
		englishDict.put(28, "twenty eight");
		englishDict.put(29, "twenty nine");
		englishDict.put(30, "half");
	}

    public static String timeInWords(int h, int m) {
        if (m == 0)
            return englishDict.get(h) + " o' clock";
        String joiner = "";
        if (m%30 != 15 && m%30 != 0)
            joiner = m%30 == 1 ? " minute" : " minutes";
        if (m <= 30)
            return englishDict.get(m) + joiner + " past " + englishDict.get(h);
        else 
            return englishDict.get(30-m%30) + joiner + " to " + englishDict.get(h+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
