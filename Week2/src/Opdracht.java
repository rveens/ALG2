/**
 * Created with IntelliJ IDEA.
 * User: rick
 * Date: 9-9-13
 * Time: 16:15
 * To change this template use File | Settings | File Templates.
 */
public class Opdracht
{
    private SpelObject[] objArray;

    public Opdracht()
    {
        objArray = new SpelObject[8];

        objArray[0] = new SpelObject(900, 100);
        objArray[1] = new SpelObject(100, 100);
        objArray[2] = new SpelObject(50, 750);
        objArray[3] = new SpelObject(110, 90);
        objArray[4] = new SpelObject(950, 50);
        objArray[5] = new SpelObject(60, 800);
        objArray[6] = new SpelObject(40, 800);
        objArray[7] = new SpelObject(700, 850);
    }

    private void swap(int first, int second)
    {
        SpelObject temp = objArray[first];
        objArray[first] = objArray[second];
        objArray[second] = temp;
    }

    public void sortArray(int left, int right, int dimensionIndex)
    {
        if (right - left <= 0) // array is 1 groot
            return;
        else if ( (right - left) == 1) { // array is 2 groot
            if (objArray[right].getPosition(dimensionIndex) > objArray[left].getPosition(dimensionIndex))
                swap(left, right);
            return;
        } else {
            int partition = partition(left, right, dimensionIndex);

            // dimension een omhoog (of weer 0)
            if (dimensionIndex < SpelObject.DIMENSION -1)
                ++dimensionIndex;
            else
                dimensionIndex = 0;

            // linkerhelft: left ... <= mediaan
            if (left < partition)
                sortArray(left, partition, dimensionIndex);

            // rechterhelft: mediaan >= ...
            if (partition < right)
                sortArray(partition, right, dimensionIndex);
        }
    }

    private int partition(int left, int right, int dimensionIndex)
    {
        // TODO mediaan van 3
        double mediaanWaarde = objArray[right - 1].getPosition(dimensionIndex);

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
                // draai om
                SpelObject temp = objArray[left];
                objArray[left] = objArray[right];
                objArray[right] = temp;
                ++left;
                --right;
            }
        }

        return left;
    }
}
