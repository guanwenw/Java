import java.awt.Color;

/**
 * ShapeO.java is a tetronimo arranged in the "O" pattern.
 * 
 * @author Guanwen Wang
 */
public class ShapeO extends Tetronimo
{
    /**
     * Default constructor.
     * 
     * @param tetris TetrisStart
     */
    public ShapeO( Tetris tetris )
    {
        super( Color.CYAN, tetris );
        config = new Configuration( 1, 1, 1, 2, 2, 1, 2, 2 );
        type = 3;
        setRC( row - 1, col );
        draw( );
    }
}