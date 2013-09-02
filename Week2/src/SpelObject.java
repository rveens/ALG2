/**
 * Created with IntelliJ IDEA.
 * User: rick
 * Date: 2-9-13
 * Time: 16:01
 * To change this template use File | Settings | File Templates.
 */
public class SpelObject
{
    public static final int DIMENSION = 2;
    private double[] position = new double[DIMENSION];

    // 0 = x, y = 1
    public double getPosition(int index )
    {
        return position[index];
    }
}
