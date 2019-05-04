package charts;

public class ChartData {

    private String nameOfNode;
    private float valueOfNode;

    public ChartData(String nameOfNode, float valueOfNode) {
        this.nameOfNode = nameOfNode;
        this.valueOfNode = valueOfNode;
    }

    @Override
    public String toString() {
        return "{ y: " + valueOfNode +
                " ,label: \"" + nameOfNode + "\", indexLabel: \"" + valueOfNode + "\" }";
    }
}
