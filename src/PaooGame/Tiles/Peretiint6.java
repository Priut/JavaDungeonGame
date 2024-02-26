package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Peretiint6 extends Tile
{
    public Peretiint6(int id)
    {
        super(Assets.peretiint6, id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
