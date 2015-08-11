package solutions;

public class ReverseWords {
    public String reverseWords(String s) {
        String[] strings = s.split("\\s");
        StringBuffer sb = new StringBuffer();
        
        for(int i = strings.length - 1; i > 0; i--) {
        	if(!strings[i].equals("")){
        		sb.append(strings[i]).append(" ");
        	}
        }
        
        if(strings.length != 0) {
            sb.append(strings[0]);
        }
        
        return sb.toString().trim();
    }
    
    public void test() {
    	reverseWords(" 1");
    }
}
