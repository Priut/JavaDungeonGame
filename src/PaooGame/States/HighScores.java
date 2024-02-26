package PaooGame.States;

import PaooGame.Exceptions.Cheater;
import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.List;

/*! \class public class AboutState extends State
    \brief Implementeaza notiunea de credentiale (about)
 */
public class HighScores extends State
{
    private int selected;
    /*! \fn public AboutState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public HighScores(RefLinks refLink)
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
                        100
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
        HashMap<String, Integer> top = new HashMap<String, Integer>();
        String[] key=new String[10];
        Integer[] values=new Integer[10];

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:game.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Scores;" );
            while ( rs.next() ) {
                int money = rs.getInt("Money");
                //Daca scorul e mai mare decat scorul maxim ai trisat
                if(money>42)
                    throw new Cheater("Too good to be true!");
                String Name =rs.getString("PlayerName");
                top.put(Name,money);
            }
            LinkedHashMap<String, Integer> sortedtop= sortHashMapByValues(top);
            key = sortedtop.keySet().toArray(new String[0]);
            values = sortedtop.values().toArray(new Integer[0]);
            //System.out.println(key[key.length-1]);
            //System.out.println(values[values.length-1]);

            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        g.setColor(Color.LIGHT_GRAY);
        g.drawImage(Assets.meniu,0,0,null);
        if(selected==0) {
            g.setFont(new Font("Arial", Font.PLAIN, 32));

            g.setColor(Color.WHITE);
            g.drawString("HighScores", 120, 50);
            g.setFont(new Font("Arial", Font.PLAIN, 24));
            g.drawString(key[key.length - 1], 100, 90);
            g.drawString(key[key.length - 2], 100, 120);
            g.drawString(key[key.length - 3], 100, 150);
            g.drawString(key[key.length - 4], 100, 180);
            g.drawString(String.valueOf(values[values.length - 1]), 280, 90);
            g.drawString(String.valueOf(values[values.length - 2]), 280, 120);
            g.drawString(String.valueOf(values[values.length - 3]), 280, 150);
            g.drawString(String.valueOf(values[values.length - 4]), 280, 180);
            g.setColor(Color.LIGHT_GRAY);
            g.drawString("Back", 10, 230);
        }
        else
        {
            g.setFont(new Font("Arial", Font.PLAIN, 32));

            g.setColor(Color.LIGHT_GRAY);
            g.drawString("HighScores", 120, 50);
            g.setFont(new Font("Arial", Font.PLAIN, 24));
            g.drawString(key[key.length - 1], 100, 90);
            g.drawString(key[key.length - 2], 100, 120);
            g.drawString(key[key.length - 3], 100, 150);
            g.drawString(key[key.length - 4], 100, 180);
            g.drawString(String.valueOf(values[values.length - 1]), 280, 90);
            g.drawString(String.valueOf(values[values.length - 2]), 280, 120);
            g.drawString(String.valueOf(values[values.length - 3]), 280, 150);
            g.drawString(String.valueOf(values[values.length - 4]), 280, 180);
            g.setColor(Color.WHITE);
            g.drawString("Back", 10, 230);
        }

    }
    public LinkedHashMap<String, Integer> sortHashMapByValues(
            HashMap<String, Integer> passedMap) {
        List<String> mapKeys = new ArrayList<>(passedMap.keySet());
        List<Integer> mapValues = new ArrayList<>(passedMap.values());
        Collections.sort(mapValues);
        Collections.sort(mapKeys);

        LinkedHashMap<String, Integer> sortedMap =
                new LinkedHashMap<>();

        Iterator<Integer> valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            int val = valueIt.next();
            Iterator<String> keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                String key = keyIt.next();
                Integer comp1 = passedMap.get(key);
                Integer comp2 = val;

                if (comp1.equals(comp2)) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }
        return sortedMap;
    }


    }