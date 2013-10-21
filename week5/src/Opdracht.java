import java.util.LinkedList;

public class Opdracht
{
    private SpelObject[] objArray;

    public Opdracht()
    {
        objArray = new SpelObject[500];
        int aantalKeren = 10000;
        int aantalObjecten = 3;

        for(int i = 0; i < objArray.length; i++)
        {
            if(i >= aantalObjecten)
                objArray[i] = new SpelObject(700, i);
            else
                objArray[i] = new SpelObject(600, 100);
        }

        Long start2 = System.currentTimeMillis();

        // root node, parent is null
        Node rootNode = null;
        for(int i = 0; i < aantalKeren; i++)
            rootNode = sortArray(0, (objArray.length - 1), 0, null);

        if(rootNode instanceof SplitNode)
        {
            SplitNode temp = (SplitNode) rootNode;
            temp.fillArray();
        }

        LinkedList<SpelObject> ll = new LinkedList<SpelObject>();
        Long start1 = System.currentTimeMillis();

        for(int i = 0; i < aantalKeren; i++)
            rootNode.searchCoordinates(new double[] { 600, 100 }, ll);

        Long eind2 = System.currentTimeMillis();
        Long eind1 = System.currentTimeMillis();


        Long start3 = System.currentTimeMillis();

        for(int i = 0; i < aantalKeren; i++)
            findArray(new double[] { 600, 100 } );

        Long eind3 = System.currentTimeMillis();

        System.out.println("Methode 1: " + (eind1 - start1));
        System.out.println("Methode 2: " + (eind2 - start2));
        System.out.println("Methode 3: " + (eind3 - start3));
    }

    private void printNodes(Node node) {
        if (node != null) {
            if (node instanceof SplitNode) {
                printNodes(((SplitNode)node).getLinkerKind());
                printNodes(((SplitNode)node).getRechterKind());
            } else
                ((EndNode)node).printSpelObject();
        }
    }

    private void swap(int first, int second)
    {
        SpelObject temp = objArray[first];
        objArray[first] = objArray[second];
        objArray[second] = temp;
    }

    private SpelObject[] findArray(double[] coordinates)
    {
        SpelObject[] returnValue = new SpelObject[10];
        int objectsFound = 0;
        for(int i = 0; i < objArray.length; i++)
        {
            if(objArray[i].getPosition(0) == coordinates[0] && objArray[i].getPosition(1) == coordinates[1])
            {
                returnValue[objectsFound] = objArray[i];
                objectsFound++;
            }
        }
        return returnValue;
    }

    public Node sortArray(int left, int right, int dimensionIndex, Node parentNode)
    {
        Node node = null; // dit wordt onze return value

        if (right - left <= 0) // array is 1 groot
            node = new EndNode(parentNode, objArray[left]); // endnode, deze gaat op return en we gaan weer terug
        else if ( (right - left) == 1) // array is 2 groot
        { // ook nog splitnode
            if (objArray[right].getPosition(dimensionIndex) < objArray[left].getPosition(dimensionIndex))
                swap(left, right);
            node = new SplitNode(parentNode);
            EndNode leftNode = new EndNode(node, objArray[left]);
            EndNode rightNode = new EndNode(node, objArray[right]);
            ((SplitNode)node).setLinkerKind(leftNode);
            ((SplitNode)node).setRechterKind(rightNode);
        }
        else // splitnode
        {
            int mediaanIndex = partition(left, right, dimensionIndex);

            // dimension een omhoog (of weer 0)
            if (dimensionIndex < SpelObject.DIMENSION -1)
                ++dimensionIndex;
            else
                dimensionIndex = 0;

            node = new SplitNode(parentNode); // node is nieuwe parent

            // linkerhelft: left ... <= mediaan
            ((SplitNode)node).setLinkerKind(sortArray(left, mediaanIndex, dimensionIndex, node));

            // rechterhelft: mediaan >= ...
            ((SplitNode)node).setRechterKind(sortArray(mediaanIndex+1, right, dimensionIndex, node));
        }

        return node; // node komt terug bij de vorige en wordt ingesteld als linker of rechter kind, of hij komt weer terug bij de eerste call
    }

    private int partition(int initialLeft, int initialRight, int dimensionIndex)
    {
        //Bepalen van de mediaan, door middel van de mediaan van 3
        int left = initialLeft;
        int right = initialRight;
        int middle = (left+right) / 2;

        if(objArray[left].getPosition(dimensionIndex) > objArray[middle].getPosition(dimensionIndex))
            swap(left, middle);
        if(objArray[middle].getPosition(dimensionIndex) > objArray[right].getPosition(dimensionIndex))
            swap(middle, right);
        if(objArray[left].getPosition(dimensionIndex) > objArray[middle].getPosition(dimensionIndex))
            swap(left, middle);

        swap(right-1, middle);
        double mediaanWaarde = objArray[right-1].getPosition(dimensionIndex);
        left++;
        right -= 2;
        //Einde bepalen mediaan van 3

        while (left <= right)
        {
            // ga door totdat je een waarde vind die hoger is dan de mediaan waarde
            while (objArray[left].getPosition(dimensionIndex) < mediaanWaarde)
                left++;
            // ga door totdat je een waarde vind die lager is dan de mediaan waarde
            while (mediaanWaarde < objArray[right].getPosition(dimensionIndex))
                right--;

            // zolang i en j elkaar niet kruisen,
            if (left <= right) {
                swap(left, right);
                ++left;
                --right;
            }
        }
        swap(left, initialRight-1);
        return left;
    }
}
