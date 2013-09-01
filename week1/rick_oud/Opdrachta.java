import java.util.concurrent.Callable;

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
        if (k > n)
            return 0;
        else if (n == k)
            return 1;
        else if (k == 0)
            return 1;

        // recursie
        return formule3(n-1, k-1) * n / k;
    }

    private int formule4(int n, int k)
    {
        if (k > n)
            return 0;
        else if (n == k)
            return 1;

        // recursie
        return formule4(n-1, k) + formule4(n-1, k-1);
    }

    private int faculteit(int n)
    {
        if(n <= 0)
            return 0;
        return faculteit(n - 1) * n;
    }





    // benchmarking
    public long Bereken1()
    {
        long start = System.currentTimeMillis();

        // acties hier
        bereken1werk();

        long finish = System.currentTimeMillis();

        return finish-start;
    }

    private void bereken1werk()
    {
        formule1(6, 3);
        formule1(10, 5);
        formule1(15, 8);
    }

    public long Bereken2()
    {
        long start = System.currentTimeMillis();

        // acties hier
        bereken2werk();

        long finish = System.currentTimeMillis();

        return finish-start;
    }

    private void bereken2werk()
    {
        for (int i = 0; i < 1000; i ++) {
            formule2(6, 3);
            formule2(10, 5);
            formule2(15, 8);
        }
    }

    public long Bereken3()
    {
        long start = System.currentTimeMillis();

        // acties hier
        bereken3werk();

        long finish = System.currentTimeMillis();

        return finish-start;
    }

    private void bereken3werk()
    {
        formule3(6, 3);
        formule3(10, 5);
        formule3(15, 8);
    }

    public long Bereken4()
    {
        long start = System.currentTimeMillis();

        // acties hier
        bereken4werk();

        long finish = System.currentTimeMillis();

        return finish-start;
    }

    private void bereken4werk()
    {
        formule4(6, 3);
        formule4(10, 5);
        formule4(15, 8);
    }
}
