/**
 * Created with IntelliJ IDEA.
 * User: Reviara
 * Date: 21-10-13
 * Time: 11:43
 * To change this template use File | Settings | File Templates.
 */
public class HashTable
{
    public static final int ARRAY_SIZE = 29;
    public static final int PRIME_SIZE = 5;
    public static final int EMPTY	 = -1000000;
    public static final int DELETED	 = -1000001;

    private	int[]	array = new int[ARRAY_SIZE];

    public HashTable()
    {
        for ( int n=0; n<ARRAY_SIZE; n++ )
            array[n] = EMPTY;
    }

    private int primaryHashcode( int key )
    {
        return key % ARRAY_SIZE;
    }

    private int secundaryHashcode( int key )
    {
        return PRIME_SIZE - ( key % PRIME_SIZE );
    }

    private int nextPosition( int pos, int step )
    {
        int position = pos + step;
        if ( position >= ARRAY_SIZE )
            position = position % ARRAY_SIZE;
        return position;
    }

    public int find( int value )
    {
        int position 	= primaryHashcode ( value ),
                step	= secundaryHashcode( value );

        while( array[position] != EMPTY )
        {
            if ( array[position] != DELETED
                    && array[position] == value )
                return position;

            position = nextPosition( position, step );
        }

        return -1;
    }

    public int remove( int value )
    {
        int position = find( value );

        if ( position != -1 )
            array[position] = DELETED;

        return position;
    }
}