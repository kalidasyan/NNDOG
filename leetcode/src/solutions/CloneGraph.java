package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return node;
        }
        
        Map<Integer, UndirectedGraphNode> existingNodes = new HashMap<Integer, UndirectedGraphNode>();
        List<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        nodes.add(node);
        while(!nodes.isEmpty()) {
            nodes = cloneNodes(nodes, existingNodes);
        }
        
        return existingNodes.get(node.label);
    }
    
    private List<UndirectedGraphNode> cloneNodes(List<UndirectedGraphNode> nodes, Map<Integer, UndirectedGraphNode> existingNodes) {
        List<UndirectedGraphNode> next = new ArrayList<UndirectedGraphNode>();
        for(UndirectedGraphNode node : nodes){
            UndirectedGraphNode nodecopy = existingNodes.get(node.label);
            if(nodecopy == null){
                nodecopy = new UndirectedGraphNode(node.label);
                existingNodes.put(node.label, nodecopy);
            } else if(!nodecopy.neighbors.isEmpty()){
                //if the node exists and is complete(with complete neighbors connection), then, continue.
                continue;
            }
            
            List<UndirectedGraphNode> neighbors = node.neighbors;
            for(UndirectedGraphNode neighbor : neighbors) {
                UndirectedGraphNode neighborcopy = existingNodes.get(neighbor.label);
                if(neighborcopy == null) {
                    neighborcopy = new UndirectedGraphNode(neighbor.label);
                    existingNodes.put(neighbor.label, neighborcopy);
                }
                nodecopy.neighbors.add(neighborcopy);
                next.add(neighbor);
            }
        }
        
        return next;
    }
    
    public void test() {
    	UndirectedGraphNode n0 = new UndirectedGraphNode(0);
    	UndirectedGraphNode n1 = new UndirectedGraphNode(1);
    	UndirectedGraphNode n2 = new UndirectedGraphNode(2);
    	n0.neighbors.add(n1);
    	n1.neighbors.add(n2);
    	n2.neighbors.add(n2);
    	cloneGraph(n0);
    }
}
