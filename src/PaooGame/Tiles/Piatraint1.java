package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

public class Piatraint1 extends Tile {
    public Piatraint1(int id) {
        super(Assets.pint1, id);
    }

    public boolean IsSolid() {
        return false;
    }
}