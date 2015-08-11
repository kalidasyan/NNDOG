package solutions;

import java.util.ArrayList;
import java.util.List;

public class SimplifyPath {
	
	private static final String PATH_DILIMITOR = "/";
	private static final String CURRENT_LEVEL = ".";
	private static final String UPPER_LEVEL = "..";
	private static final String EMPTY_STRING = "";
	
    public String simplifyPath(String path) {
        StringBuffer sb = new StringBuffer();
        if(path == null || path.length() == 0) {
            return sb.append(PATH_DILIMITOR).toString();
        }
        
        String[] paths = path.split(PATH_DILIMITOR);
        List<String> queue = new ArrayList<String>();
        for(int i = 0; i < paths.length; i++) {
        	String p = paths[i];
        	if(p.equals(CURRENT_LEVEL) || p.equals(EMPTY_STRING)){
        		continue;
        	} else if (p.equals(UPPER_LEVEL)){
        		if(!queue.isEmpty()){
        			queue.remove(queue.size()-1);
        		}
        	} else {
        		queue.add(p);
        	}
        }
        
        if(queue.isEmpty()){
        	return sb.append(PATH_DILIMITOR).toString();
        }
        
        for(String s : queue){
        	sb.append(PATH_DILIMITOR).append(s);
        }
        
        return sb.toString();
    }
    
    public void test(){
    	System.out.println(simplifyPath("/a/./b/../../c/"));
    	System.out.println(simplifyPath("/"));
    	System.out.println(simplifyPath("//"));
    	System.out.println(simplifyPath("/."));
    	System.out.println(simplifyPath("/../"));
    	System.out.println(simplifyPath("/home//foo/"));
    }
}
