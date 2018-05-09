import Graph.ListGraph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.LinkedList;
/*
this project is on hold for a while, or forever lol.
 */
public class GraphUI extends JPanel implements ActionListener, MouseListener,MouseMotionListener {
    private static GraphUI ourInstance = new GraphUI();
    private Timer timer = new Timer(10,this);
    private ListGraph<String> graph = new ListGraph<String>(true);
    private HashMap<String,Point> coordinateList = new HashMap<>();
    private Font nameFont= new Font("monospace",Font.BOLD,14);
    private String selected;
    private boolean connecting = false;
    private int mouseX, mouseY;
    public static GraphUI getInstance() {
        return ourInstance;
    }
    private static final int R = 40;
    private GraphUI() {
        timer.start();
        setSize(1000,1000);
        setBackground(Color.WHITE);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(nameFont);
        if(connecting){
            g.drawLine(coordinateList.get(selected).x+R/2, coordinateList.get(selected).y+R/2,
                    mouseX,mouseY);
        }
        for(String vertex: coordinateList.keySet()){
            if(vertex == selected) {
                g.setColor(Color.BLACK);
                g.fillOval((coordinateList.get(vertex)).x-2, (coordinateList.get(vertex)).y-2, R+4, R+4);
            }
            g.setColor(Color.RED);
            g.fillOval((coordinateList.get(vertex)).x, (coordinateList.get(vertex)).y, R, R);
            g.setColor(Color.BLACK);
            g.drawString(vertex, coordinateList.get(vertex).x + R / 2,
                    coordinateList.get(vertex).y + R / 2);

        }

        g.drawString(debugString(),20,20);
        g.dispose();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        timer.restart();
        repaint();
    }
    private String debugString(){
        String s = graph.toString();
        s += " \n" + selected;
        s += " \n" + coordinateList;
        return s;
    }
    private String over(int mx, int my){
        int x,y;
        for(String v:coordinateList.keySet()){
            x = coordinateList.get(v).x; y = coordinateList.get(v).y;
            if(Math.sqrt(Math.pow(x-mx,2)+Math.pow(y-my,2))<R+5){
                selected = v;
                return v;
            }
        }
        return null;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

        if(over(e.getX(),e.getY())==null) {
            String temp = JOptionPane.showInputDialog(null, "name?");
            if (temp != null) {
                graph.insert(temp);
                coordinateList.put(temp, new Point(e.getX(), e.getY()));
            }

        }

        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(over(e.getX(),e.getY())==null?false:over(e.getX(),e.getY()).equals(selected)?true:false){
            connecting = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        connecting = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(over(e.getX(),e.getY())==null?false:over(e.getX(),e.getY()).equals(selected)?true:false){
            coordinateList.get(selected).x = e.getX();
            coordinateList.get(selected).y = e.getY();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
