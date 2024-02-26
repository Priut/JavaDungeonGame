package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Start extends Tile
{
    public Start(int id)
    {
        super(Assets.start, id);
    }

    public boolean IsSolid() {
        return false;
    }
}

