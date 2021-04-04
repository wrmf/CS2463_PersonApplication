import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.*;

public class PersonApplicationGUI extends JPanel implements KeyListener, ActionListener{
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 800;
	private JPanel northPanel = new JPanel(); //Remove later idk?
	private JMenuItem quitButton, helpButton, sourceButton, newFileButton, newPersonButton, newRPersonButton, 
	newOPersonButton, saveButton, saveAsButton, saveChangesButton, openButton, cancelButton;
	private JFrame frame = new JFrame();
	private JMenu fileMenu, helpMenu, newMenu;
	private JMenuBar menuBar;
	private ArrayList<Person> personList = new ArrayList<Person>();
	private ArrayList<RegisteredPerson> rPersonList = new ArrayList<RegisteredPerson>();
	private ArrayList<OCCCPerson> oPersonList = new ArrayList<OCCCPerson>();
	
	
	
	public PersonApplicationGUI() {
		
		frame.setTitle("Person Application GUI");
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		fileMenu = new JMenu("File");
		newMenu = new JMenu("New");
		helpMenu = new JMenu("Help");
		menuBar = new JMenuBar();
		quitButton = new JMenuItem("Exit");
		helpButton = new JMenuItem("Info");
		newFileButton = new JMenuItem("File");
		newPersonButton = new JMenuItem("Person");
		newRPersonButton = new JMenuItem("RegisteredPerson");
		newOPersonButton = new JMenuItem("OCCCPerson");
		saveButton = new JMenuItem("Save");
		saveAsButton = new JMenuItem("Save As");
		openButton = new JMenuItem("Open");
		sourceButton = new JMenuItem("Source");
		
		//Add buttons to menus
		newMenu.add(newFileButton);
		newMenu.add(newPersonButton);
		newMenu.add(newRPersonButton);
		newMenu.add(newOPersonButton);
		fileMenu.add(newMenu);
		fileMenu.add(openButton);
		fileMenu.add(saveButton);
		fileMenu.add(saveAsButton);
		fileMenu.add(quitButton);
		helpMenu.add(helpButton);
		helpMenu.add(sourceButton);
		
		//add menus to menu bar
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		
		//Quit button closes program/gui
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//Source button opens github
		sourceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URL("https://github.com/wrmf/PersonApplication").toURI());
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
		
		//Help button gives some amount of help
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "This program helps to easily view Person/RegisteredPerson/OCCCPerson","Help", JOptionPane.NO_OPTION);
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
