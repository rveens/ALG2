/**
 * Created with IntelliJ IDEA.
 * User: Reviara
 * Date: 2-9-13
 * Time: 15:35
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public Main()
    {

    }

    public static void main(String[] args)
    {
        SpelObject test[] = createTestData();
        sortArray(test, 0, test.length-1, 0);

        for (int i = 0; i < test.length; i++) {
            System.out.printf("%d: x:%f y:%f\n", i, test[i].getPosition(0), test[i].getPosition(1));
        }
    }

    private static SpelObject[] createTestData()
    {
        SpelObject[] array = new SpelObject[8];
        array[0] = new SpelObject(900, 100);
        array[1] = new SpelObject(100, 100);
        array[2] = new SpelObject(50, 750);
        array[3] = new SpelObject(110, 90);
        array[4] = new SpelObject(950, 50);
        array[5] = new SpelObject(60, 800);
        array[6] = new SpelObject(40, 800);
        array[7] = new SpelObject(700, 850);

        return array;
    }

    private static void sortArray(SpelObject[] objArray, int left, int right, int dimensionIndex)
    {
        int i = left, j = right;
        double mediaanWaarde = objArray[left + (right - left) / 2].getPosition(dimensionIndex);

        while (i <= j)
        {
            // ga door totdat je een waarde vind die hoger is dan de mediaan waarde
            while (objArray[i].getPosition(dimensionIndex) < mediaanWaarde)
                i++;
            // ga door totdat je een waarde vind die lager is dan de mediaan waarde
            while (mediaanWaarde < objArray[j].getPosition(dimensionIndex))
                j--;

            // zolang i en j elkaar niet kruisen,
            if (i <= j) {
                // draai om
                SpelObject temp = objArray[i];
                objArray[i] = objArray[j];
                objArray[j] = temp;
                ++i;
                --j;
            }
        }

        // i is nu in het midden, en j is dat ook

        // dimension een omhoog (of weer 0)
        if (dimensionIndex < SpelObject.DIMENSION -1)
            ++dimensionIndex;
        else
            dimensionIndex = 0;

        // linkerhelft: left ... <= mediaan deelarray heeft een size of van 1 als left == j
        if (left < j)
            sortArray(objArray, left, j, dimensionIndex);

        // rechterhelft: mediaan >= ...  right deelarray heeft een size of van 1 als i == right
        if (i < right)
            sortArray(objArray, i, right, dimensionIndex);
    }
}
