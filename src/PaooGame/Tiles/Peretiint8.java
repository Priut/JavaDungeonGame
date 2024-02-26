package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Peretiint8 extends Tile
{
    public Peretiint8(int id)
    {
        super(Assets.peretiint8, id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
