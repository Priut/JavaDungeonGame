package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Peretiint2 extends Tile
{
    public Peretiint2(int id)
    {
        super(Assets.peretiint2, id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
