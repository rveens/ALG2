import java.util.LinkedList;

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

    public void printSpelObject() {
        System.out.printf("x:%f, y:%f\n", spelObject.getPosition(0), spelObject.getPosition(1));
    }

    public double lowerBound( int index )
    {
        return spelObject.getPosition(index);
    }

    public double upperBound( int index )
    {
        return spelObject.getPosition(index);
    }

    @Override
    public void searchCoordinates(double[] coordinates, LinkedList<SpelObject> result) {
        boolean check = true;
        for(int i = 0; i < SpelObject.DIMENSION; i++)
            if(spelObject.getPosition(i) != coordinates[i])
                check = false;

        if(check)
            result.add(spelObject);
    }
}

