/**
 * Created with IntelliJ IDEA.
 * User: rick
 * Date: 10-9-13
 * Time: 15:05
 * To change this template use File | Settings | File Templates.
 */
public abstract class Node
{
    private Node ouder;

    public Node(Node ouder) {
        this.ouder = ouder;
    }

    public abstract double lowerBound( int index );
    public abstract double upperBound( int index );
}
