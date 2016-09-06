import java.awt.Color;

/**
 * ShapeJ.java is a tetronimo arranged in the "J" pattern.
 * 
 * @author Guanwen Wang
 */
public class ShapeJ extends Tetronimo
{
    /**
     * Default constructor.
     * 
     * @param tetris TetrisStart
     */
    public ShapeJ( Tetris tetris )
    {
        super( Color.MAGENTA, tetris );
        config = new Configuration( 0, 2, 1, 2, 2, 2, 2, 1 );
        type = 5;
        draw( );
    }
}