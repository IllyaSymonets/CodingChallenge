package cisco.java.challenge.gnode;

import java.util.ArrayList;

public class GNodeService {

    private ArrayList<String> graphsGNodes = new ArrayList<String>();
    private ArrayList<String> path = new ArrayList<String>();
    private ArrayList<ArrayList<String>> paths =
            new ArrayList<ArrayList<String>>();

    public ArrayList<String> walkGraph(GNode node) {
        graphsGNodes.add(node.getName());
        for (GNode child : node.getChildren()) {
            walkGraph(child);
        }
        return graphsGNodes;
    }

    public ArrayList<ArrayList<String>> paths(GNode node) {
        path.add(node.getName());
        for (GNode child : node.getChildren()) {
            paths(child);
        }
        if (node.getChildren().length == 0) {
            paths.add(new ArrayList<String>(path));
        }
        path.remove(node.getName());
        return paths;
    }

    ;
}
