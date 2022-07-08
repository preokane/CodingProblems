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

	private static List<String> englishDict = new ArrayList<>();
	static {
		englishDict.add("zero");
		englishDict.add("one");
		englishDict.add("two");
		englishDict.add("three");
		englishDict.add("four");
		englishDict.add("five");
		englishDict.add("six");
		englishDict.add("seven");
		englishDict.add("eight");
		englishDict.add("nine");
		englishDict.add("ten");
		englishDict.add("eleven");
		englishDict.add("twelve");
		englishDict.add("thirteen");
		englishDict.add("fourteen");
		englishDict.add("quarter");
		englishDict.add("sixteen");
		englishDict.add("seventeen");
		englishDict.add("eighteen");
		englishDict.add("nineteen");
		englishDict.add("twenty");
		englishDict.add("twenty one");
		englishDict.add("twenty two");
		englishDict.add("twenty three");
		englishDict.add("twenty four");
		englishDict.add("twenty five");
		englishDict.add("twenty six");
		englishDict.add("twnety seven");
		englishDict.add("twenty eight");
		englishDict.add("twenty nine");
		englishDict.add("half");
	}

    public static String timeInWords(int h, int m) {
        if (m == 0)
            return englishDict.get(h) + " o' clock";
        String joiner = "";
        if (m%30 != 15 && m%30 != 0)
            joiner = m == 1 || m == 59 ? " minute" : " minutes";
        if (m <= 30)
            return englishDict.get(m) + joiner + " past " + englishDict.get(h);
        else 
            return englishDict.get(30-m%30) + joiner + " to " + englishDict.get(h);
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
