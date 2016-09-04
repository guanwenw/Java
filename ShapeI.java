import java.awt.Color;

/**
 * ShapeI.java is a tetronimo arranged in the "I" pattern.
 * 
 * @author Guanwen Wang
 */
public class ShapeI extends Tetronimo
{
    /**
     * Default constructor.
     * 
     * @param tetris TetrisStart
     */
    public ShapeI( Tetris tetris )
    {
        super( Color.RED, tetris );
        config = new Configuration( 0, 1, 1, 1, 2, 1, 3, 1 );
        type = 1;
        draw( );
    }
}