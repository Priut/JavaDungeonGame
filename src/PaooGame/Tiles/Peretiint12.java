package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Peretiint12 extends Tile
{
    public Peretiint12(int id)
    {
        super(Assets.peretiint12, id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
