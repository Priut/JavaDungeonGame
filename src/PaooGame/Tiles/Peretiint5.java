package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Peretiint5 extends Tile
{
    public Peretiint5(int id)
    {
        super(Assets.peretiint5, id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
