import Graph.ListGraph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.LinkedList;

public class GraphUI extends JPanel implements ActionListener, MouseListener {
    private static GraphUI ourInstance = new GraphUI();
    private Timer timer = new Timer(25,this);
    private ListGraph<String> g = new ListGraph<String>(true);
    HashMap<String,Point> v = new HashMap<>();
    public static GraphUI getInstance() {
        return ourInstance;
    }

    private GraphUI() {
        timer.start();
        setSize(1000,1000);
        setBackground(Color.WHITE);

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        timer.restart();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
