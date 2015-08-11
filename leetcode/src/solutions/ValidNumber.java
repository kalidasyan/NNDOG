package solutions;

public class ValidNumber {
	public boolean isNumber(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}

		s = s.trim();
		StringBuffer sb = new StringBuffer();
		int dotIndex = -1;
		int eIndex = -1;
		int signIndex = -1;

		// First path: trim and filter out invalid characters.
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// only alow '.', 'e', number, '+' and '-'
			if (isNumber(c)) {
				sb.append(c);
			} else if (c == '.') {
				if (dotIndex >= 0) {
					return false;
				}
				dotIndex = sb.length();
				sb.append(c);
			} else if (isE(c)) {
				if (eIndex >= 0) {
					return false;
				}
				eIndex = sb.length();
				sb.append(c);
			} else if (c == '+' || c == '-') { 
				// '+' or '-' must appear at the beginning, or before 'e'
				if(signIndex < 0) {
					if(sb.length() == 0 || isE(sb.charAt(sb.length() - 1))) {
						signIndex = sb.length();
					} else {
						return false;
					}
				} else if(signIndex == 0) {
					if(sb.length() != 0 && isE(sb.charAt(sb.length() - 1))){
						signIndex = sb.length();
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		}

		// A valid number must contain at least one digit
		if (sb.length() == 0) {
			return false;
		}

		// check sign again: sign should follow with a number
//		if (sb.charAt(0) == '+' || sb.charAt(0) == '-') {
//			sb.deleteCharAt(0);
//			eIndex--;
//			dotIndex--;
//		}

		if (eIndex == sb.length() - 1 || eIndex == 0) {
			return false;
		}

		// dot should appear before 'e' or 'E', and should not appear at the end
		// of a number
		if (dotIndex >= 0 && eIndex > 0) {
			if (dotIndex > eIndex) {
				return false;
			}
			
			if(eIndex == 1){
				return false;
			}
		}

		if (dotIndex >= 0) {
			sb.deleteCharAt(dotIndex);
			eIndex--;
		}

		if (eIndex > 0) {
			sb.deleteCharAt(eIndex);
		}

		// A valid number must contain at least one digit
		if (sb.length() == 0) {
			return false;
		}

		return true;
	}

	private boolean isNumber(char c) {
		return c >= '0' && c <= '9';
	}

	private boolean isE(char c) {
		return c == 'e' || c == 'E';
	}

	public void test() {
		// String s = "1 ";
//		String s = "+.8";
		String s = " +005047e+6";
//		String s = "6+1";
		System.out.println(isNumber(s));
	}
}
