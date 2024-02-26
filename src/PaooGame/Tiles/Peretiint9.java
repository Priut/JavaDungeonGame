package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Peretiint9 extends Tile
{
    public Peretiint9(int id)
    {
        super(Assets.peretiint9, id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
