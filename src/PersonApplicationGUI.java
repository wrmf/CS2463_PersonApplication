import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.*;

public class PersonApplicationGUI extends JPanel implements KeyListener, ActionListener{
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 800;
	JPanel northPanel = new JPanel();
	private JMenuItem quitButton, helpButton, sourceButton;
	JFrame frame = new JFrame();
	private JMenu fileMenu, helpMenu;
	private JMenuBar menuBar;
	
	
	public PersonApplicationGUI() {
		
		frame.setTitle("Person Application GUI");
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		fileMenu = new JMenu("File");
		helpMenu = new JMenu("Help");https://github.com/wrmf/personapplication
		menuBar = new JMenuBar();
		quitButton = new JMenuItem("Exit");
		helpButton = new JMenuItem("Info");
		sourceButton = new JMenuItem("Source");
		fileMenu.add(quitButton);
		helpMenu.add(helpButton);
		helpMenu.add(sourceButton);
		
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		sourceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URL("http://www.google.com").toURI());
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		frame.setJMenuBar(menuBar);
        frame.setVisible(true);
	}

	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void main(String[] args) {
		PersonApplicationGUI pagui = new PersonApplicationGUI();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
