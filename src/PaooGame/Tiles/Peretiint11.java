package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Peretiint11 extends Tile
{
    public Peretiint11(int id)
    {
        super(Assets.peretiint11, id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
