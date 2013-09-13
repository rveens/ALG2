/**
 * Created with IntelliJ IDEA.
 * User: Reviara
 * Date: 2-9-13
 * Time: 15:35
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args)
    {
        SpelObject test[] = createTestData();
        sortArray(test, 0, test.length-1, 0);

        for (int i = 0; i < test.length; i++)
            System.out.printf("%d: x:%f y:%f\n", i, test[i].getPosition(0), test[i].getPosition(1));
    }

}
