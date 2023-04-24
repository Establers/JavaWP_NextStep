
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrCalculator {
	int add(String text) {
		
		// 유효하지 않은 입력이 들어왔을 때
//		if(text == null || text.isEmpty()) {
//			return 0;
//		}
		
		if(!isValid(text)) {
			return 0;
		}
		
		// 입력으로 하나가 들어왔을 때
//		if(text.length() == 1) {
//			return Integer.parseInt(text);
//		}
		
		// 구분자가 있을 때
//		if(text.contains(",") || text.contains(":")) {
//			String[] nums = text.split(",|:");
//			
//			return sumStringArray(nums);
//		}
				
		
		// 커스텀 구분자 추출하기
//		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
//		if(m.find()) {
//			String customDelimeter = m.group(1);
//			String[] tokens = m.group(2).split(customDelimeter);
//		}
		
//		String[] nums = text.split(",|:");	
//		return sumStringArray(nums);
		
		return sumStringArray(splitText(text));
		
	}
	
	private int sumStringArray(String[] str) {
		int val = 0;
		
		for(int i=0; i<str.length; i++) {
//			val += Integer.parseInt(str[i]);
			val += toPositive(str[i]);
		}
		
		return val;
	}
	
	private int toPositive(String s) {
		int n = Integer.parseInt(s);
		if(n < 0) {
			throw new RuntimeException();
		}
		
		return n;
	}
	
	
	private String[] splitText(String text) {
		// 커스텀 구분자 있을 때
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		if(m.find()) {
			String customDelimeter = m.group(1);
			return m.group(2).split(customDelimeter);
		}
		
		// 커스텀 구분자 없음
		return text.split(",|:");
	}
	
	private boolean isValid(String text) {
		if(text == null || text.isEmpty()) {
			return false;
		}
		return true;
	}
	
	
}
