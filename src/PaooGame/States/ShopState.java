package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.Items.Hero;
import PaooGame.RefLinks;

import java.awt.*;

public class ShopState extends State{
    private String[] optionsMenu;
    private static final String Optiunea1 = "Buy Axe - 20 coins";
    private static final String Optiunea2 = "Buy Faraday Armour- 40 coins";
    private static final String Optiunea3 = "Buy Extra Life - 10 coins";
    private static final String Optiunea4 = "Next level...";
    private int selected;
    public ShopState(RefLinks refLink) {
        super(refLink);
        this.optionsMenu = new String[] {Optiunea1,Optiunea2,Optiunea3,Optiunea4};
        this.selected = 10;
    }

    public void Update() {
        //daca cumpara axe
        int money = Hero.getInstance(refLink).getMoney();
        int l = Hero.getInstance(refLink).getLevel()+1;
        if (refLink.GetMouseManager().getMouseX() > 30 && refLink.GetMouseManager().getMouseX() < 390 &&
                refLink.GetMouseManager().getMouseY() > 60 && refLink.GetMouseManager().getMouseY() < 105) {
            selected = 0;
            if (refLink.GetMouseManager().isLeftPressed()) {
                if (money >= 20) {
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    SetState(new PlayState(refLink,l));
                                    refLink.GetGame().getWindow().GetWndFrame().requestFocusInWindow();
                                    Hero.getInstance(refLink).setWeapon(1);
                                    Hero.getInstance(refLink).setMoney(money-20);
                                    Hero.getInstance(refLink).setLevel(l);
                                }
                            },
                            20
                    );
                }
                else{
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    SetState(new NoMoney(refLink));
                                    refLink.GetGame().getWindow().GetWndFrame().requestFocusInWindow();
                                }
                            },
                            20
                    );
                }
            }
        }
        //daca cumpara armura
        if (refLink.GetMouseManager().getMouseX() > 30 && refLink.GetMouseManager().getMouseX() < 390 &&
                refLink.GetMouseManager().getMouseY() > 105 && refLink.GetMouseManager().getMouseY() < 150) {
            selected = 1;
            if (refLink.GetMouseManager().isLeftPressed()) {
                if (money >= 40) {
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    Hero.getInstance(refLink).setMoney(money-40);
                                    SetState(new LevelWon(refLink));
                                    refLink.GetGame().getWindow().GetWndFrame().requestFocusInWindow();
                                }
                            },
                            20
                    );
                }
                else if(l==3){
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    System.out.println("Ai pierdut");
                                }
                            },
                            20
                    );
                }
                else {
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    SetState(new NoMoney(refLink));
                                    refLink.GetGame().getWindow().GetWndFrame().requestFocusInWindow();
                                }
                            },
                            20
                    );
                }
            }

        }

        if (refLink.GetMouseManager().getMouseX() > 30 && refLink.GetMouseManager().getMouseX() < 390 &&
                refLink.GetMouseManager().getMouseY() > 150 && refLink.GetMouseManager().getMouseY() < 195) {
            selected = 2;
            if (refLink.GetMouseManager().isLeftPressed()) {
                if (money >= 10) {
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    SetState(new PlayState(refLink,l));
                                    refLink.GetGame().getWindow().GetWndFrame().requestFocusInWindow();
                                    Hero.getInstance(refLink).setMoney(money-10);
                                    Hero.getInstance(refLink).SetExtraLife(1);
                                    Hero.getInstance(refLink).SetLife(Hero.getInstance(refLink).GetMaxLife());
                                    Hero.getInstance(refLink).setLevel(l );
                                }
                            },
                            20
                    );
                }
                else{
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    SetState(new NoMoney(refLink));
                                }
                            },
                            20
                    );
                    refLink.GetGame().getWindow().GetWndFrame().requestFocusInWindow();
                }
            }
        }
        //daca nu cumpara nimic
        if (refLink.GetMouseManager().getMouseX() > 30 && refLink.GetMouseManager().getMouseX() < 390 &&
                refLink.GetMouseManager().getMouseY() > 195 && refLink.GetMouseManager().getMouseY() < 240) {
            selected = 3;
            if (refLink.GetMouseManager().isLeftPressed()) {
                if (money >= 0) {
                    super.SetState(new PlayState(refLink,l));
                    Hero.getInstance(refLink).setLevel(l);
                    Hero.getInstance(refLink).setMoney(money);
                    refLink.GetGame().getWindow().GetWndFrame().requestFocusInWindow();


                }
                else{
                    super.SetState(new NoMoney(refLink));
                    refLink.GetGame().getWindow().GetWndFrame().requestFocusInWindow();
                }
            }
        }


    }
    @Override
    public void Draw(Graphics graphics) {
        graphics.setColor(new Color(230, 30, 70));
        graphics.drawImage(Assets.meniu,0,0,null);
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Arial", Font.PLAIN, 32));
        graphics.drawString("You have "+Hero.getInstance(refLink).getMoney()+" coins!", 80, 40 );
        graphics.setFont(new Font("Arial", Font.PLAIN, 28));
        for(int i=0;i<this.optionsMenu.length;i++) {
            if(i==this.selected) graphics.setColor(Color.WHITE);
            else graphics.setColor(Color.LIGHT_GRAY);
            graphics.drawString(this.optionsMenu[i], 30, 90 + i * 45);
        }
    }
}
