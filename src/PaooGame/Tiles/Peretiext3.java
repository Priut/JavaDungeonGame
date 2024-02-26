package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Peretiext3 extends Tile
{
    public Peretiext3(int id)
    {
        super(Assets.peretiext3, id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
