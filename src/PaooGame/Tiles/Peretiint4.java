package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Peretiint4 extends Tile
{
    public Peretiint4(int id)
    {
        super(Assets.peretiint4, id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
