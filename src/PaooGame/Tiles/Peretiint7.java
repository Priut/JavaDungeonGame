package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Peretiint7 extends Tile
{
    public Peretiint7(int id)
    {
        super(Assets.peretiint7, id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
