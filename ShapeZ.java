import java.awt.Color;

/**
 * ShapeZ.java is a tetronimo arranged in the "Z" pattern.
 * 
 * @author Guanwen Wang
 */
public class ShapeZ extends Tetronimo
{
    /**
     * Default constructor.
     * 
     * @param tetris TetrisStart
     */
    public ShapeZ( Tetris tetris )
    {
        super( Color.GREEN, tetris );
        config = new Configuration( 1, 1, 1, 2, 2, 2, 2, 3 );
        type = 7;
        setRC( row - 1, col );
        draw( );
    }
}