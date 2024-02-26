package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Piatraint8 extends Tile
{
    public Piatraint8(int id)
    {
        super(Assets.pint8, id);
    }
    public boolean IsSolid() {
        return false;
    }
}
