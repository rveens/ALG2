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
            System.out.printf("%d: x:%f y:%f\n", i, test[i].getPosition(1), test[i].getPosition(0));
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
        double mediaanWaarde = objArray[(left + right) / 2].getPosition(dimensionIndex);

        do {
            while (objArray[i].getPosition(dimensionIndex) < mediaanWaarde)
                i++;
            while (mediaanWaarde < objArray[j].getPosition(dimensionIndex))
                j--;

            if (i <= j) {
                // omdraaien
                SpelObject temp = objArray[i];
                objArray[i] = objArray[j];
                objArray[j] = temp;
                ++i;
                --j;
            }
        } while (i <= j);

        // linkerhelft: left ... <= mediaan
        if (left < j)
            sortArray(objArray, left, j, dimensionIndex);

        // dimension een omhoog (of weer 0)
        if (dimensionIndex < SpelObject.DIMENSION -1)
            ++dimensionIndex;
        else
            dimensionIndex = 0;

        // rechterhelft: mediaan >= ...  right
        if (i < right)
            sortArray(objArray, i, right, dimensionIndex);
    }

    private static SpelObject[] partition(SpelObject objArray[], int left, int right, int dimensionIndex)
    {
        int i = left, j = right;
        SpelObject temp;
        double mediaanWaarde = objArray[(left + right) / 2].getPosition(dimensionIndex);

        while (i <= j) {
            while (objArray[i].getPosition(dimensionIndex) < mediaanWaarde)
                i++;
            while (objArray[j].getPosition(dimensionIndex) > mediaanWaarde)
                j--;

            if (i <= j) {
                // omdraaien
                temp = objArray[i];
                objArray[i] = objArray[j];
                objArray[j] = temp;
                ++i;
                --j;
            }
        }

        return objArray;
    }
}
