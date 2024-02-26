package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Piatraint9 extends Tile
{
    public Piatraint9(int id)
    {
        super(Assets.pint9, id);
    }
    public boolean IsSolid() {
        return false;
    }
}
