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

    public SpelObject getSpelObject() {
        return this.spelObject;
    }

    public void setSpelObject(SpelObject newSpelObject) {
        this.spelObject = newSpelObject;
    }

    public void printSpelObject() {
        System.out.printf("x:%f, y:%f\n", spelObject.getPosition(0), spelObject.getPosition(1));
    }
}

