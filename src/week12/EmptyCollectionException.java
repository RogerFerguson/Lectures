package week12;

/**
 * Created with IntelliJ IDEA.
 * User: fergusor
 * Date: 11/30/12
 * Time: 10:42 AM
 * To change this template use File | Settings | File Templates.
 */

public class EmptyCollectionException extends RuntimeException
{
    /**
     * Sets up this exception with an appropriate message.
     */
    public EmptyCollectionException (String collection)
    {
        super ("The " + collection + " is empty.");
    }
}
