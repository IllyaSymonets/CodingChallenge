package cisco.java.challenge.gnode;


public class GNodeImpl implements GNode {

    private String name;
    private GNode[] children = new GNode[0];

    public GNodeImpl(String name, GNode[] children) {
        this.name = name;
        this.children = children;
    }

    public GNodeImpl(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public GNode[] getChildren() {
        return children;
    }
}
