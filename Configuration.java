import java.util.*;
import java.awt.*;

/**
 *  Represents the four row-column 2D array coordinates for the tiles 
 *  of a tetris shape. 
 *  
 * @author Guanwen Wang
 */ 
public class Configuration extends Vector< Point >
{
    /**
     * Constructor.  8 integers representing the four row-column 
     * coordinates for the four tiles of a tetris shape.
     * 
     * @param r1 int
     * @param c1 int
     * 
     * @param r2 int
     * @param c2 int
     * 
     * @param r3 int
     * @param c3 int
     * 
     * @param r4 int
     * @param c4 int
     * 
     */ 
    public Configuration(int r1, int c1, 
                         int r2, int c2,
                         int r3, int c3, 
                         int r4, int c4 )
    {
        add( new Point( r1, c1 ) );
        add( new Point( r2, c2 ) );
        add( new Point( r3, c3 ) );
        add( new Point( r4, c4 ) );
    }
    
    /**
     * Default Constructor. Constructs an empty collection.
     */ 
    public Configuration( )
    {
        
    }
    
    /**
     * getGraphicsCoordinates. Converts the local row, column coordinates
     * of a Shape to graphics x, y coordinates.
     * 
     * @param row int  
     * @param col int
     * @return Configuration
     */ 
    public Configuration getGraphics( int row, int col  )
    {
        Configuration board = getBoard( row, col );
        
        Configuration graphics = new Configuration( );
        
        int x = 0, y = 0;
        for( Point p : board )
        {
            x = Specs.XBOARD + ( p.y * Specs.TSIZE );
            y = Specs.YBOARD + ( p.x * Specs.TSIZE );
            graphics.add( new Point( x, y ) );
        }
        
        return graphics;
    }
    
    /**
     * getBoardCoordinates. Returns the board coordinates for this Shape.
     * 
     * @param r int
     * @param c int
     * @return Configuration
     */ 
    public Configuration getBoard( int r, int c  )
    {     
        Configuration board = new Configuration( );
        for( Point p : this )
        {
            board.add( new Point( p.x + r, p.y + c ) );
        }
        return board;
    }
    
    /**
     * Rotate clockwise.  returns a new Configuration withe the coordinates
     * transformed for a clockwise rotation.
     * 
     * @return Configuration
     */ 
    public Configuration rotate(   )
    {
        Configuration rotated  = new Configuration( );
        
        for( Point p : this )
        {
            rotated.add( new Point( p.y, 3 - p.x ) );
        }
        
        return rotated;
    }
    
    /**
     * Convert to a String.
     * StringBuilder is faster to concantenate String
     * 
     * @return String
     */ 
    public String toString( )
    { 
        if( size( ) == 0 )
            return "Empty configuration";
        
        String s = "" ;
        for( int i = 0; i < size( ); i++ )
            s += ( "(" +  get( i ).x + ", " +  get( i ).y + ")  " );
        
        return s; 
    }
}