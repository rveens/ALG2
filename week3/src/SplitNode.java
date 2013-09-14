/**
 * Created with IntelliJ IDEA.
 * User: rick
 * Date: 10-9-13
 * Time: 15:12
 * To change this template use File | Settings | File Templates.
 */
public class SplitNode extends Node
{
    private Node    linkerKind,
                    rechterKind;

    public SplitNode(Node ouder) {
        super(ouder);
    }

    public Node getLinkerKind() {
        return linkerKind;
    }

    public void setLinkerKind(Node linkerKind) {
        this.linkerKind = linkerKind;
    }

    public Node getRechterKind() {
        return rechterKind;
    }

    public void setRechterKind(Node rechterKind) {
        this.rechterKind = rechterKind;
    }
}
