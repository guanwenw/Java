import wheelsunh.users.*;
import java.awt.Color;
import java.util.*;
import java.awt.Point;
import java.awt.event.*;


/**
 * Tetronimo.java is the base class for all the tetronimos.
 * 
 * @author Guanwen Wang
 */
public class Tetronimo
{
    protected int row = 0, col = ( Specs.COLS / 2 ) - 2;
    protected Configuration config;
    protected int type;
    protected Vector< Tile > tiles;
    protected Tetris tetrisStart;
    
    /**
     * Default Constructor. Input color determines the color of the tiles.
     * 
     * @param c Color
     * @param tetris TetrisStart
     */
    public Tetronimo( Color c, Tetris tetris )
    {
        tetrisStart = tetris;
        config = new Configuration( );
        tiles = new Vector< Tile >( );
        
        for( int i = 0; i < 4; i++ )
        {
            tiles.add( new Tile( c ) );
        }
        
        tetrisStart.startTimer( );
    }
    
    /**
     * Uses the current configuration to draw the tetronimo.
     */
    public void draw( )
    {
        Configuration graphics = config.getGraphics( row, col );
        Configuration board = config.getBoard( row, col );
        
        for( int i = 0; i < 4; i++ )
        {
            Point p = graphics.get( i );
            tiles.get( i ).setLocation( p.x, p.y );
            
            Point pb = board.get( i );
            tiles.get( i ).setRow( pb.x );
        }
    }
    
    /**
     * returns the type number of the tetronimo.
     * 
     * @return int
     */
    public int getType( )
    {
        return type;
    }
    
    /**
     * Checks if the input configuration intersects with anything on the board.
     * 
     * @param board Configuration
     * @return boolean
     */
    public boolean tryConfig( Configuration board )
    {
        for( Point p : board )
        {
            try
            {
                if( tetrisStart.getCellAt( p.x, p.y + 1 ) )
                    return false;
            }
            catch( java.lang.ArrayIndexOutOfBoundsException e )
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Sets the row and column.
     * 
     * @param r int
     * @param c int
     */
    public void setRC( int r, int c )
    {
        row = r;
        col = c;
        draw( );
    }
    
    /**
     * Gets the row and column of the tetronimo as a point.
     * 
     * @return Point
     */
    public Point getRC( )
    {
        return new Point( row, col );
    }
    
    /**
     * Gets the location in (x,y) coordinates as a point.
     * 
     * @return Point
     */
    public Point getLocation( )
    {
        return new Point( Specs.XBOARD + ( col * Specs.TSIZE ),
                         Specs.YBOARD + ( row * Specs.TSIZE ) );
    }
    
    /**
     * Sets the location of the Tetronimo.
     * 
     * @param x int
     * @param y int
     */
    public void setLocation( int x, int y )
    {
        for( int i = 0; i < 4; i++ )
        {
            Point p = config.getGraphics( 0, 0 ).get( i );
            int nx = p.x - Specs.XBOARD + x;
            int ny = p.y - Specs.YBOARD + y;
            
            tiles.get( i ).setLocation( nx, ny );
        }
    }
    
    /**
     * Hides all the tiles in the tetronimo.
     */
    public void hide( )
    {
        for( Tile t : tiles )
            t.hide( );
    }
    
    /**
     * Rotates the shape.
     */
    public void rotate( )
    {
        if( tryConfig( config.rotate( ).getBoard( row, col ) ) )
            config = config.rotate( );
        draw( );
    }
    
    /**
     * Moves the tetronimo down one row.
     * 
     * @return boolean
     */
    public boolean fall( )
    {
        boolean out = true;
        if( tryConfig( config.getBoard( row + 1, col ) ) 
               && tetrisStart.isRunning( ) )
        {
            row++;
            draw( );
        }
        else
        {
            out = false;
            
            if( tetrisStart.isRunning( ) )
            {
                tetrisStart.stopTimer( );
                tetrisStart.createRandomShape( );
                
                /* For first assignmen and debugging.
                 System.out.println( "Board Coordinates:\n" 
                 + config.getBoard( row, col ) );
                 */
                
                for( int i = 0; i < config.size( ); i++ )
                {
                    Point p = config.getBoard( row, col ).get( i );
                    tetrisStart.setCellAt( p.x, p.y + 1, true );
                    
                    if( p.x == 0 )
                        tetrisStart.gameOver( );
                    
                    Tile t = tiles.get( i );
                    tetrisStart.addTile( t );
                }
                
                tetrisStart.breakRows( );
            }
        }
        return out;
    }
    
    /**
     * Moves the Tetronimo one column to the left.
     */
    public void left( )
    {
        if( tryConfig( config.getBoard( row, col - 1 ) ) )
            col--;
        draw( );
    }
    
    /**
     * Moves the Tetronimo one column to the right.
     */
    public void right( )
    {
        if( tryConfig( config.getBoard( row, col + 1 ) ) )
            col++;
        draw( );
    }
}