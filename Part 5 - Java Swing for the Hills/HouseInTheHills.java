/**
***********************************************
 @Author      : Fardin Abbassi
 @Last Modified: 2022-12-02
 @Description: Creates grass, a sky, a house, a door, a window and a sun.

***********************************************
*/

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("House of Abbassi");
		frame.addWindowListener
		(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
				}
			}
		);
		frame.setSize(400,400);
		JPanel pane = (JPanel) frame.getContentPane();
		pane.add(new Picture(),BorderLayout.CENTER);
		frame.setVisible(true);
	}
}

class Picture extends JComponent {
	public Picture() {
		repaint();
	}

	public void paint(Graphics g){
        // sky //
        g.setColor(Color.cyan);
        g.fillRect(0,0, 400,400);
        
        // grass //
        g.setColor(Color.green);
        g.fillRect(0, 340, 400, 60);
        g.setColor(Color.black);
        g.drawRect(0, 340, 400, 60);

        // walls //
        g.setColor(Color.red);
        g.fillRect(50, 175, 300, 165);
        g.setColor(Color.black);
        g.drawRect(50, 175, 300, 165);
        
        // roof //
        int x[] = {25, 200, 375};
        int y[] = {175, 75, 175};
        g.setColor(Color.magenta);
        g.fillPolygon(x, y, 3);
        g.setColor(Color.black);
        g.drawPolygon(x, y, 3);
        
        // door //
        g.setColor(Color.magenta);
        g.fillRect(100,240, 50,100);
        g.setColor(Color.black);
        g.drawRect(100,240, 50,100);
        
        // window //
        g.setColor(Color.yellow);
        g.fillRect(225, 220, 40,40);
        g.setColor(Color.black);
        g.drawRect(225, 220, 40,40);
        g.drawLine(245, 220, 245, 260);
        g.drawLine(225, 240, 265, 240);

		// sun
		g.setColor(Color.yellow);
		g.fillOval(15,15, 60,60);
	}
}
