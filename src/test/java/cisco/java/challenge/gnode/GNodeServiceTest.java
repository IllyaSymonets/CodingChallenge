package cisco.java.challenge.gnode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


public class GNodeServiceTest {

    GNode[] nodeCChildren = {new GNodeImpl("G"),
            new GNodeImpl("H"), new GNodeImpl("I")};
    GNode[] nodeBChildren = {new GNodeImpl("E"),
            new GNodeImpl("F")};
    GNode[] nodeAChildren = {new GNodeImpl("B", nodeBChildren),
            new GNodeImpl("C", nodeCChildren), new GNodeImpl("D")};
    GNode testNode = new GNodeImpl("A", nodeAChildren);

    GNodeService gNodeService = new GNodeService();

    @Test
    public void walkGraph() {
        ArrayList<String> gNodeNames = gNodeService.walkGraph(testNode);
        Assert.assertTrue((gNodeNames.size() == 9)
                && (gNodeNames.contains("A")) && (gNodeNames.contains("B"))
                && (gNodeNames.contains("C")) && (gNodeNames.contains("D"))
                && (gNodeNames.contains("E")) && (gNodeNames.contains("F"))
                && (gNodeNames.contains("G")) && (gNodeNames.contains("H"))
                && (gNodeNames.contains("I")));
    }

    @Test
    public void paths() {
        ArrayList<ArrayList<String>> gNodePaths = gNodeService.paths(testNode);
        Assert.assertTrue((gNodePaths.size() == 6)
                && (gNodePaths.get(0).size() == 3)
                && (gNodePaths.get(0).contains("A"))
                && (gNodePaths.get(0).contains("B"))
                && (gNodePaths.get(0).contains("E"))
                && (gNodePaths.get(1).size() == 3)
                && (gNodePaths.get(1).contains("A"))
                && (gNodePaths.get(1).contains("B"))
                && (gNodePaths.get(1).contains("F"))
                && (gNodePaths.get(2).size() == 3)
                && (gNodePaths.get(2).contains("A"))
                && (gNodePaths.get(2).contains("C"))
                && (gNodePaths.get(2).contains("G"))
                && (gNodePaths.get(3).size() == 3)
                && (gNodePaths.get(3).contains("A"))
                && (gNodePaths.get(3).contains("C"))
                && (gNodePaths.get(3).contains("H"))
                && (gNodePaths.get(4).size() == 3)
                && (gNodePaths.get(4).contains("A"))
                && (gNodePaths.get(4).contains("C"))
                && (gNodePaths.get(4).contains("I"))
                && (gNodePaths.get(5).size() == 2)
                && (gNodePaths.get(5).contains("A"))
                && (gNodePaths.get(5).contains("D")));
    }
}