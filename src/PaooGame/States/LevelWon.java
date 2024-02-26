package PaooGame.States;

import PaooGame.Exceptions.Cheater;
import PaooGame.Graphics.Assets;
import PaooGame.Items.Hero;
import PaooGame.RefLinks;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LevelWon extends State{
    public LevelWon(RefLinks refLink) {

        super(refLink);
        System.out.println("Please write your name so we can save your score:");
        Scanner scanner = new Scanner(System.in);
        String Player = scanner.nextLine();
        Connection c = null;
        Statement stmt = null;
        boolean exista=false;
        try {
            if(Hero.getInstance(refLink).getMoney()>42)
                throw new Cheater("Too good to be true!");
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:game.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Scores;" );
            while ( rs.next() ) {
                String name = rs.getString("PlayerName");
                if(name.equals(Player))
                    exista=true;
            }
            if(exista)
            {
                rs = stmt.executeQuery( "SELECT * FROM Scores where PlayerName='"+Player+"';" );
                int money = rs.getInt("Money");
                if(money<Hero.getInstance(refLink).getMoney())
                {
                    String sql = "UPDATE Scores set Money = '"+Hero.getInstance(refLink).getMoney()+"' where PlayerName='"+Player+"';";
                    stmt.executeUpdate(sql);
                    String query="SELECT * FROM Scores ORDER BY Money DESC";
                    stmt.executeUpdate(query);
                }

            }
            else{
                String sql = "INSERT INTO Scores (PlayerName,Money) " +
                        "VALUES ('"+Player+"', "+ Hero.getInstance(refLink).getMoney()+" );";
                stmt.executeUpdate(sql);
                String query="SELECT * FROM Scores ORDER BY Money DESC";
                stmt.executeQuery( query);
            }
            stmt.close();
            c.commit();
            c.close();
        }
        catch (Exception e)
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );

        }


        scanner.close();
    }

    @Override
    public void Update() {

    }

    @Override
    public void Draw(Graphics g)  {
        g.setColor(Color.LIGHT_GRAY);
        g.drawImage(Assets.meniu,0,0,null);

        g.setFont(new Font("Arial", Font.PLAIN, 32));
        g.drawString("You WON !", 125, 125);

    }
}
