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
}
