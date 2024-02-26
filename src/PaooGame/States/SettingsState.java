package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.Items.Hero;
import PaooGame.Maps.Map;
import PaooGame.RefLinks;
import PaooGame.States.MenuState;
import PaooGame.States.State;

import java.awt.*;
import java.sql.*;

/*! \class public class SettingsState extends State
    \brief Implementeaza notiunea de settings pentru joc.

    Aici setarile vor trebui salvate/incarcate intr-un/dintr-un fisier/baza de date sqlite.
 */
public class SettingsState extends State
{
    private String[] optionsMenu;
    private static final String Optiunea1 = "Easy";
    private static final String Optiunea2 = "Normal";
    private static final String Optiunea3 = "Hard";
    private static final String Optiunea4 = "Back..";
    private int selected;
    /*! \fn public SettingsState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public SettingsState(RefLinks refLink)
    {
            ///Apel al construcotrului clasei de baza.
        super(refLink);
        this.optionsMenu = new String[] {Optiunea1, Optiunea2,Optiunea3,Optiunea4};//optiunile meniului
        this.selected = 0;//variabila pentru selectie,modul implicit e cel easy
        selected=0;
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea setarilor.
     */
    @Override
    public void Update()
    {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:game.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            if (refLink.GetMouseManager().getMouseX() > 30 && refLink.GetMouseManager().getMouseX() < 390 &&
                    refLink.GetMouseManager().getMouseY() > 60 && refLink.GetMouseManager().getMouseY() < 105) {
                selected = 0;
                if (refLink.GetMouseManager().isLeftPressed()) {
                    String sql = "UPDATE GameSettings set Dificultate = 'Easy' where Id=1;";
                    stmt.executeUpdate(sql);
                    c.commit();
                    sql = "UPDATE GameSettings set EnemyLife = 5 where ID=1;";
                    stmt.executeUpdate(sql);
                    c.commit();
                    ResultSet rs = stmt.executeQuery( "SELECT * FROM GameSettings where Id=1;" );
                    SetState(new PlayState(refLink, 1));
                    refLink.GetGame().getWindow().GetWndFrame().requestFocusInWindow();
                    refLink.GetMap().getEnemies().forEach(enemy1 -> {
                        try {
                            enemy1.setHp(rs.getInt("EnemyLife"));
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    });
                }
            }
            //daca cumpara hammer
            if (refLink.GetMouseManager().getMouseX() > 30 && refLink.GetMouseManager().getMouseX() < 390 &&
                    refLink.GetMouseManager().getMouseY() > 105 && refLink.GetMouseManager().getMouseY() < 150) {
                selected = 1;
                if (refLink.GetMouseManager().isLeftPressed()) {
                    String sql = "UPDATE GameSettings set Dificultate = 'Normal' where Id=1;";
                    stmt.executeUpdate(sql);
                    c.commit();
                    sql = "UPDATE GameSettings set EnemyLife = 10 where ID=1;";
                    stmt.executeUpdate(sql);
                    c.commit();
                    ResultSet rs = stmt.executeQuery( "SELECT * FROM GameSettings where Id=1;" );
                    SetState(new PlayState(refLink, 1));
                    refLink.GetGame().getWindow().GetWndFrame().requestFocusInWindow();
                    refLink.GetMap().getEnemies().forEach(enemy1 -> {
                        try {
                            enemy1.setHp(rs.getInt("EnemyLife"));
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    });
                }

            }

            if (refLink.GetMouseManager().getMouseX() > 30 && refLink.GetMouseManager().getMouseX() < 390 &&
                    refLink.GetMouseManager().getMouseY() > 150 && refLink.GetMouseManager().getMouseY() < 195) {
                selected = 2;
                if (refLink.GetMouseManager().isLeftPressed()) {
                    String sql = "UPDATE GameSettings set Dificultate = 'Normal' where Id=1;";
                    stmt.executeUpdate(sql);
                    c.commit();
                    sql = "UPDATE GameSettings set EnemyLife = 15 where ID=1;";
                    stmt.executeUpdate(sql);
                    c.commit();
                    ResultSet rs = stmt.executeQuery( "SELECT * FROM GameSettings where Id=1;" );
                    super.SetState(new PlayState(refLink, 1));
                    refLink.GetGame().getWindow().GetWndFrame().requestFocusInWindow();
                    refLink.GetMap().getEnemies().forEach(enemy1 -> {
                        try {
                            enemy1.setHp(rs.getInt("EnemyLife"));
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    });
                }
            }
            //daca nu cumpara nimic
            if (refLink.GetMouseManager().getMouseX() > 30 && refLink.GetMouseManager().getMouseX() < 390 &&
                    refLink.GetMouseManager().getMouseY() > 195 && refLink.GetMouseManager().getMouseY() < 240) {
                selected = 3;
                if (refLink.GetMouseManager().isLeftPressed()) {
                    super.SetState(new MenuState(refLink));
                    refLink.GetGame().getWindow().GetWndFrame().requestFocusInWindow();
                }

            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch(Exception e)
        {

        }
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran setarile.

        \param g Contextul grafic in care trebuie sa deseneze starea setarilor pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.setColor(new Color(230, 30, 70));
        g.drawImage(Assets.meniu,0,0,null);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 32));
        g.drawString("Settings", 125, 40 );
        for(int i=0;i<this.optionsMenu.length;i++) {
            if(i==this.selected) g.setColor(Color.WHITE);
            else g.setColor(Color.LIGHT_GRAY);
            g.drawString(this.optionsMenu[i], 40, 90 + i * 45);
        }

    }



}
