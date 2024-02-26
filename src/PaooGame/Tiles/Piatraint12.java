package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Piatraint12 extends Tile
{
    public Piatraint12(int id)
    {
        super(Assets.pint12, id);
    }
    public boolean IsSolid() {
        return false;
    }
}
