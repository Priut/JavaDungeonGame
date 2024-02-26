package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Piatraint6 extends Tile
{
    public Piatraint6(int id)
    {
        super(Assets.pint6, id);
    }
    public boolean IsSolid() {
        return false;
    }
}
