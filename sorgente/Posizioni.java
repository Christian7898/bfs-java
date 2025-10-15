/**
 *
 * @author alunno
 */
public class Posizioni {
    private int x;
    private int y;
    
    public Posizioni(){
        
    }
    
    public Posizioni(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    
    public void set(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
}
