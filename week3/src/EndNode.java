/**
 * Created with IntelliJ IDEA.
 * User: rick
 * Date: 10-9-13
 * Time: 15:06
 * To change this template use File | Settings | File Templates.
 */
public class EndNode extends Node
{
    private SpelObject spelObject;

    public EndNode(Node ouder, SpelObject spelObject)
    {
        super(ouder);
        this.spelObject = spelObject;
    }
}
