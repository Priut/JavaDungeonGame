package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Peretiext2 extends Tile
{
    public Peretiext2(int id)
    {
        super(Assets.peretiext2, id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
