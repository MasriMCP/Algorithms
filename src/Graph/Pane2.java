package Graph;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Pane2 extends JPanel implements MouseListener,ActionListener{
	Timer mainTimer = new Timer(25,this);
	int x=0,y=0;
	public Pane2(){
		mainTimer.start();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.RED);
		g.fillOval(x, y, 100, 100);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		mainTimer.start();
		repaint();
		x = e.getX();
		y = e.getY();
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		mainTimer.stop();
		repaint();
	}
	
}
