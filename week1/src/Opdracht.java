/**
 * Created with IntelliJ IDEA.
 * User: Sander van Leeuwen & Rick Veens
 * Date: 26-8-13
 * Time: 16:19
 */
public class Opdracht {
    public Opdracht()
    {
    }

    //Berekenen van de faculteit (recursief)
    public double f(double n)
    {
        if(n <= 0)
            return 0;

        if(n == 1)
            return 1;

        return f(n-1) * n;
    }

    public double NoverK1(int n, int k)
    {
        if(k > n)
            return 0;

        if(n == k)
            return 1;

        return f(n) / (f(k) * f(n-k));
    }

    public double NoverK2(int n, int k)
    {
        if(k > n)
            return 0;

        if(n == k)
            return 1;

        double antwoord = n / 1;
        for(int count = 2; count <= k; count++)
            antwoord = antwoord * (n - count + 1) / count;

        return antwoord;
    }

    public double NoverK3(int n, int k)
    {
        if(k > n)
            return 0;

        if(n == k)
            return 1;

        if(k == 0)
            return 1;

        return NoverK3(n-1, k-1) * n / k;
    }

    public double NoverK4(int n, int k)
    {
        if(k > n)
            return 0;

        if(n == k)
            return 1;

        if(k == 0)
            return 1;

        return NoverK4(n-1, k) + NoverK4(n-1, k-1);
    }

    public static void main(String[] args)
    {
        Opdracht opdracht = new Opdracht();
        long time = System.currentTimeMillis();
        int n = 80; // Het n getal
        int k = 38; // Het k getal
        double antwoord = 0;
        for (int i = 0; i < 1000000; i++) //De 1 hier is het aantal berekeningen
            antwoord = opdracht.NoverK1(n, k); //De 1 hier is de methode
        System.out.println("De uitkomst als n = " + n + " en k = " + k + " is: " + antwoord);
        System.out.println("Calculation took " + (System.currentTimeMillis() - time) + " miliseconds.");
    }
}
