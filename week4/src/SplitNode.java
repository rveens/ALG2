import java.util.LinkedList;

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
    private Double[] lowerArray;
    private Double[] upperArray;

    public SplitNode(Node ouder) {
        super(ouder);
        lowerArray = new Double[SpelObject.DIMENSION];
        upperArray = new Double[SpelObject.DIMENSION];
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

    public double lowerBound( int index )
    {
        return lowerArray[index];
    }

    public double upperBound( int index )
    {
        return upperArray[index];
    }

    @Override
    public LinkedList<SpelObject> searchCoordinates(double[] coordinates) {
        LinkedList<SpelObject> returnValue = new LinkedList<SpelObject>();

        boolean checkLinker, checkRechter;

        checkLinker = checkRechter = true;

        for (int i = 0; i < SpelObject.DIMENSION; i++) {
            if (coordinates[i] > linkerKind.upperBound(i) ||
                    coordinates[i] < linkerKind.lowerBound(i))
                checkLinker = false;
            if (coordinates[i] > rechterKind.upperBound(i) ||
                    coordinates[i] < rechterKind.lowerBound(i))
                checkRechter = false;
        }

        if (checkLinker)
            returnValue.addAll(linkerKind.searchCoordinates(coordinates));

        if (checkRechter)
            returnValue.addAll(rechterKind.searchCoordinates(coordinates));

        return returnValue;
    }

    public void fillArray()
    {
        if(linkerKind instanceof SplitNode)
        {
            SplitNode temp = (SplitNode) linkerKind;
            temp.fillArray();
        }
        if(rechterKind instanceof SplitNode)
        {
            SplitNode temp = (SplitNode) rechterKind;
            temp.fillArray();
        }
        for(int i = 0; i < SpelObject.DIMENSION; i++)
        {
            if(linkerKind.lowerBound(i) < rechterKind.lowerBound(i))
                lowerArray[i] = linkerKind.lowerBound(i);
            else
                lowerArray[i] = rechterKind.lowerBound(i);

            if(linkerKind.upperBound(i) > rechterKind.upperBound(i))
                upperArray[i] = linkerKind.upperBound(i);
            else
                upperArray[i] = rechterKind.upperBound(i);
        }
    }
}
