package solutions;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len = (v1.length >= v2.length) ? v2.length : v1.length;
        
        for(int i = 0; i < len; i++) {
        	int i1 = Integer.parseInt(v1[i]);
        	int i2 = Integer.parseInt(v2[i]);
            if(i1 > i2) {
                return 1;
            } else if (i1 < i2) {
                return -1;
            }
        }
        
        if(v1.length > v2.length) {
            return checkTrailing(v1, len);
        } else if (v1.length < v2.length) {
            return -1 * checkTrailing(v2, len);
        } else {
            return 0;
        }
        
    }
    
    private int checkTrailing(String[] strArray, int index) {
    	for(int i = index; i < strArray.length; i++) {
    		int num = Integer.parseInt(strArray[i]);
    		if(num != 0) return 1;
    	}
    	return 0;
    }
    
    public void test(String version1, String version2) {
    	compareVersion(version1, version2);
    }
}
