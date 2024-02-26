package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Peretiint3 extends Tile
{
    public Peretiint3(int id)
    {
        super(Assets.peretiint3, id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
