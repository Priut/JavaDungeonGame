package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;

/*! \class public class AboutState extends State
    \brief Implementeaza notiunea de credentiale (about)
 */
public class AboutState extends State
{
    private int selected;
    /*! \fn public AboutState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public AboutState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza.
        super(refLink);
        selected=0;
    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniu about.
     */
    @Override
    public void Update()
    {
        if(refLink.GetMouseManager().getMouseX()>0&&refLink.GetMouseManager().getMouseX()<100&&
                refLink.GetMouseManager().getMouseY()>180&&refLink.GetMouseManager().getMouseY()<270)
        {
            selected=1;
            if(refLink.GetMouseManager().isLeftPressed()) {
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                SetState(new MenuState(refLink));
                            }
                        },
                        200
                );
                refLink.GetGame().getWindow().GetWndFrame().requestFocusInWindow();
            }
        }
        else
            selected=0;
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniu about.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.setColor(Color.LIGHT_GRAY);
        g.drawImage(Assets.meniu,0,0,null);

        g.setFont(new Font("Arial", Font.PLAIN, 32));
        if(selected==0)
        {
            g.setColor(Color.WHITE);
            g.drawString("ABOUT", 150, 50);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Use W, A, S, D to move", 30, 90);
            g.drawString("Use Arrows to attack", 30, 120);
            g.drawString("Collect as mush money as possible so you ", 30, 150);
            g.drawString("can buy the hammer and the armour.", 50, 180);
            g.setColor(Color.LIGHT_GRAY);
            g.drawString("Back", 10, 230);
        }
        else if (selected==1)
        {
            g.setColor(Color.LIGHT_GRAY);
            g.drawString("ABOUT", 150, 50);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Use W, A, S, D to move", 30, 90);
            g.drawString("Use Arrows to attack", 30, 120);
            g.drawString("Collect as mush money as possible so you ", 30, 150);
            g.drawString("can buy the hammer and the armour.", 50, 180);
            g.setColor(Color.WHITE);
            g.drawString("Back", 10, 230);
        }
    }

}
