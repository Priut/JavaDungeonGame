package PaooGame.Tiles;
import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

public class Piatraint4 extends Tile
{
    public Piatraint4(int id)
    {
        super(Assets.pint4, id);
    }
    public boolean IsSolid() {
        return false;
    }
}
