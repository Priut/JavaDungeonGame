package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Piatraint10 extends Tile
{
    public Piatraint10(int id)
    {
        super(Assets.pint10, id);
    }
    public boolean IsSolid() {
        return false;
    }
}
