/**
 * Created with IntelliJ IDEA.
 * User: Sander van Leeuwen & Rick Veens
 * Date: 26-8-13
 * Time: 16:19
 */
public class Opdrachta {
    public Opdrachta()
    {

    }

    // 1. Als n! = 1 x 2 x 3 x ... x (n-1) x n dan is (n k ) = n! / k!(n-k)!
    private int formule1(int n, int k)
    {
        return (faculteit(n) / (faculteit(k) * faculteit(n - k)) );
    }

    private int formule2(int n, int k)
    {
        int retVal = 0;

        for (int kt = 1; kt <= k; ++kt)
            retVal *= (n - kt + 1) / kt;

        return retVal;
    }

    private int formule3(int n, int k)
    {
        // niet helemaal zeker of deze onderstaande controle 100% jusit is
        if (k > n)
            return 0;
        else if (n == k)
            return 1;

        // recursie
        return formule3(n-1, k-1) * n / k;
    }

    private int formule4(int n, int k)
    {
        // niet helemaal zeker of deze onderstaande controle 100% jusit is
        if (k > n)
            return 0;
        else if (n == k)
            return 1;

        // recursie
        return formule4(n-1, k) + formule4(n-1, k-1);
    }

    public int faculteit(int n)
    {
        if(n <= 0)
            return 0;
        return faculteit(n-1) * n;
    }
}
