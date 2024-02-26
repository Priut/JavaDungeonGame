package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Peretiint10 extends Tile
{
    public Peretiint10(int id)
    {
        super(Assets.peretiint10, id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
