package jdk8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stremt();
	}

	
	public static void targetMethod() {
	    List<String> list = Arrays.asList("bcd", "cde", "def", "abc");
	    List<String> result = new LinkedList<>();

	    for (String str : list) {
	        if (str.length() >= 3) {
	            char e = str.charAt(0);
	            String tempStr = String.valueOf(e);
	            result.add(tempStr);
	        }
	    }
	    System.out.println("----------------------------");
	    System.out.println(result);
	}
	
	
	public static void Stremt() {
	    List<String> list = Arrays.asList("bcd", "cde", "def", "abc");
	    List<String> result = list.stream()
	            //.parallel()
	            .filter(e -> e.length() >= 3)
	            .map(e -> e.charAt(0))
	            //.peek(System.out :: println)
	            //.sorted()
	            //.peek(e -> System.out.println("++++" + e))
	            .map(e -> String.valueOf(e))
	            .collect(Collectors.toList());
	    System.out.println("----------------------------");
	    System.out.println(result);
	}
}
