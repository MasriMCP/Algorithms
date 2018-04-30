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
    private ListGraph<String> graph = new ListGraph<String>(true);
    HashMap<String,Point> coordinateList = new HashMap<>();
    private Font nameFont= new Font("monospace",Font.BOLD,14);
    public static GraphUI getInstance() {
        return ourInstance;
    }
    private static final int R = 40;
    private GraphUI() {
        timer.start();
        setSize(1000,1000);
        setBackground(Color.WHITE);
        addMouseListener(this);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(nameFont);

        for(String vertex: graph){
            g.setColor(Color.RED);
            if(vertex!=null) //TODO vertex is null for some reason
            g.fillOval(coordinateList.get(vertex).x,coordinateList.get(vertex).y,R,R);
            g.setColor(Color.BLACK);
            g.drawString(vertex,coordinateList.get(vertex).x+R/2, coordinateList.get(vertex).y+R/2);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        timer.restart();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String temp = JOptionPane.showInputDialog(null,"name?");
        graph.insert(temp);
        coordinateList.put(temp,new Point(e.getX(),e.getY()));
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
