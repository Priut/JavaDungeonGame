package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.Items.Hero;
import PaooGame.Maps.Map;
import PaooGame.RefLinks;

import java.awt.*;

public class NoMoney extends State{
    private String[] optionsMenu;
    private static final String Optiunea1 = "Go back to the shop";
    private int selected;
    public NoMoney(RefLinks refLink) {
        super(refLink);
        this.optionsMenu = new String[] {Optiunea1};
        this.selected = 10;
    }

    @Override
    public void Update() {
        if (refLink.GetMouseManager().getMouseX() > 0 && refLink.GetMouseManager().getMouseX() < 100 &&
                refLink.GetMouseManager().getMouseY() > 190 && refLink.GetMouseManager().getMouseY() < 240) {
            selected = 0;
            if (refLink.GetMouseManager().isLeftPressed()) {
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                SetState(new ShopState(refLink));
                                refLink.GetGame().getWindow().GetWndFrame().requestFocusInWindow();
                            }
                        },
                        200
                );
            }
        }



    }

    @Override
    public void Draw(Graphics g) {
        {
            g.setColor(new Color(230, 30, 70));
            g.drawImage(Assets.meniu,0,0,null);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.PLAIN, 32));
            g.drawString("Sadly you don't have", 70, 50 );
            g.drawString("enough money...", 95, 85 );
            for(int i=0;i<this.optionsMenu.length;i++) {
                if(i==this.selected) g.setColor(Color.WHITE);
                else g.setColor(Color.LIGHT_GRAY);
                g.drawString("Back", 10, 230);
            }
        }

    }
}
