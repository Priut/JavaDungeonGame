package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Peretiext1 extends Tile
{
    public Peretiext1(int id)
    {
        super(Assets.peretiext1, id);
    }

    @Override
    public boolean IsSolid() {
        return true;
    }
}
