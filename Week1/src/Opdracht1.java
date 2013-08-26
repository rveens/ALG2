/**
 * Created with IntelliJ IDEA.
 * User: Sander van Leeuwen & Rick Veens
 * Date: 26-8-13
 * Time: 16:19
 */
public class Opdracht1 {
    public Opdracht1()
    {
    }

    public int faculteit(int n)
    {
        if(n <= 0)
            return 0;
        return faculteit(n-1) * n;
    }
}
