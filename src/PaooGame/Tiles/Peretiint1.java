package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Peretiint1 extends Tile
{
    public Peretiint1(int id)
    {
        super(Assets.peretiint1, id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
