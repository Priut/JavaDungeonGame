package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Piatraint2 extends Tile
{
    public Piatraint2(int id)
    {
        super(Assets.pint2, id);
    }
    public boolean IsSolid() {
        return false;
    }
}