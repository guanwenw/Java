import java.awt.Color;

/**
 * ShapeL.java is a tetronimo arranged in the "L" pattern.
 * 
 * @author Guanwen Wang
 */
public class ShapeL extends Tetronimo
{
    /**
     * Default constructor.
     * 
     * @param tetris TetrisStart
     */
    public ShapeL( Tetris tetris )
    {
        super( Color.YELLOW, tetris );
        config = new Configuration( 0, 1, 1, 1, 2, 1, 2, 2 );
        type = 4;
        draw( );
    }
}