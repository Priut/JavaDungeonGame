package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Piatraint13 extends Tile
{
    public Piatraint13(int id)
    {
        super(Assets.pint13, id);
    }

    public boolean IsSolid() {
        return false;
    }
}
