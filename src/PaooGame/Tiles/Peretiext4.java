package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Peretiext4 extends Tile
{
    public Peretiext4(int id)
    {
        super(Assets.peretiext4, id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
