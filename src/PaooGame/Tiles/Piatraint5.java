package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Piatraint5 extends Tile
{
    public Piatraint5(int id)
    {
        super(Assets.pint5, id);
    }
    public boolean IsSolid() {
        return false;
    }
}
