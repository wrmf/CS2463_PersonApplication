/***
 * Person/RegisteredPerson/OCCCPerson GUI
 * @author William McGovern-Fagg
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.time.LocalDate;


public class PersonApplicationGUI implements ActionListener{
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 800;
	private JPanel northPanel = new JPanel();
	private JPanel middlePanel = new JPanel();
	private JPanel southPanel = new JPanel();
	private JButton saveChangesButton, cancelButton;
	private JMenuItem quitButton, helpButton, sourceButton, newFileButton, saveButton, saveAsButton, openButton;
	private JFrame frame = new JFrame();
	private JMenu fileMenu, helpMenu;
	private JMenuBar menuBar;
	private ArrayList<Person> personList = new ArrayList<Person>();
	private ArrayList<RegisteredPerson> rPersonList = new ArrayList<RegisteredPerson>();
	private ArrayList<OCCCPerson> oPersonList = new ArrayList<OCCCPerson>();
	private OCCCDate odate = new OCCCDate();
	private Person person = new Person("John", "Doe", odate); //Blank person
	private RegisteredPerson RPerson = new RegisteredPerson(person, "0"); //Blank rperson
	private OCCCPerson OPerson = new OCCCPerson(RPerson, "0"); //Blank operson
	private JTextField firstNameField = new JTextField("Enter first name");
	private JTextField lastNameField = new JTextField("Enter last name");
	private JTextField birthdateField = new JTextField("Enter birthdate (mm/dd/yyyy)");
	private JTextField govIDField = new JTextField("Enter government ID number");
	private JTextField OCCCIDField = new JTextField("Enter OCCC ID number");
	private JRadioButton personButton = new JRadioButton("Person", true);
	private JRadioButton rPersonButton = new JRadioButton("RegisteredPerson");
	private JRadioButton oPersonButton = new JRadioButton("OCCCPerson");
	private ButtonGroup buttonGroup = new ButtonGroup();
	
	
	
	
	public PersonApplicationGUI() {
		
		frame.setTitle("Person Application GUI");
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		odate.setDayName(odate.HIDE_DAY_NAME);
		odate.setStyleFormat(odate.STYLE_NUMBERS);
		
		fileMenu = new JMenu("File");
		helpMenu = new JMenu("Help");
		menuBar = new JMenuBar();
		quitButton = new JMenuItem("Exit");
		helpButton = new JMenuItem("Info");
		newFileButton = new JMenuItem("New");
		saveButton = new JMenuItem("Save");
		saveAsButton = new JMenuItem("Save As");
		openButton = new JMenuItem("Open");
		sourceButton = new JMenuItem("Source");
		saveChangesButton   = new JButton("Save Changes");
	    cancelButton = new JButton("Discard Changes");
		
		northPanel.setLayout(new FlowLayout());
		frame.add(northPanel, BorderLayout.NORTH);
		middlePanel.setLayout(new FlowLayout());
		frame.add(middlePanel, BorderLayout.CENTER);
		southPanel.setLayout(new FlowLayout());
		frame.add(southPanel, BorderLayout.SOUTH);
		
		buttonGroup.add(personButton);
		buttonGroup.add(rPersonButton);
		buttonGroup.add(oPersonButton);
		
		northPanel.add(personButton);
		northPanel.add(rPersonButton);
		northPanel.add(oPersonButton);
		middlePanel.add(firstNameField);
		middlePanel.add(lastNameField);
		middlePanel.add(birthdateField);
		middlePanel.add(govIDField);
		middlePanel.add(OCCCIDField);
		southPanel.add(cancelButton);
		southPanel.add(saveChangesButton);
		
		
		
		//Add buttons to menus
		fileMenu.add(newFileButton);
		fileMenu.add(openButton);
		fileMenu.add(saveButton);
		fileMenu.add(saveAsButton);
		fileMenu.add(quitButton);
		helpMenu.add(helpButton);
		helpMenu.add(sourceButton);
		//frame.add(taNote);
		
		//add menus to menu bar
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		
		firstNameField.selectAll();
		lastNameField.selectAll();
		birthdateField.selectAll();
		govIDField.selectAll();
		OCCCIDField.selectAll();
		
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

		//Help button gives some amount of help
		saveChangesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(personButton.isSelected()) {
					personList.add(person);
					personList.get(personList.size()-1).setFirstName(firstNameField.getText());
					personList.get(personList.size()-1).setLastName(lastNameField.getText());
					System.out.println(personList.get(personList.size()-1).toString());
				} else if(rPersonButton.isSelected()) {
					rPersonList.add(RPerson);
					rPersonList.get(rPersonList.size()-1).setFirstName(firstNameField.getText());
					rPersonList.get(rPersonList.size()-1).setLastName(lastNameField.getText());
					rPersonList.get(rPersonList.size()-1).setGovernmentID(govIDField.getText());
					System.out.println(rPersonList.get(rPersonList.size()-1).toString());
				} else if(oPersonButton.isSelected()) {
					oPersonList.add(OPerson);
					oPersonList.get(oPersonList.size()-1).setFirstName(firstNameField.getText());
					oPersonList.get(oPersonList.size()-1).setLastName(lastNameField.getText());
					oPersonList.get(oPersonList.size()-1).setGovernmentID(govIDField.getText());
					oPersonList.get(oPersonList.size()-1).setStudentID(OCCCIDField.getText());
					System.out.println(oPersonList.get(oPersonList.size()-1).toString());
				}
			}
		});
		
		//Help button gives some amount of help
		/*newPersonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNameNote.setVisible(true);
				lastNameNote.setVisible(true);
				birthdateNote.setVisible(true);
				govIDNote.setVisible(false);
				OCCCIDNote.setVisible(false);
				personList.add(person);
				//Help button gives some amount of help
				saveChangesButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						personList.get(personList.size()-1).setFirstName(firstNameNote.getText());
						personList.get(personList.size()-1).setLastName(lastNameNote.getText());
						System.out.println(personList.get(personList.size()-1).toString());
					}
				});
			}
		});*/
		
		
		frame.setJMenuBar(menuBar);
        frame.setVisible(true);
        firstNameField.selectAll();
		lastNameField.selectAll();
		birthdateField.selectAll();
		govIDField.selectAll();
		OCCCIDField.selectAll();
	}

	
	private boolean isValidDate(String s) {
		if(s.length() != 10) {
			return false;
		}
		
		Character[] charArray = new Character[s.length()];
		for(int i = 0; i < charArray.length; i ++) {
			charArray[i] = s.charAt(i);
		}
		
		if()
	}
	
	private boolean isNumber(char c) {
		return Character.isDigit(c);
	}
	
	private boolean isChar(char input, char c) {
		if(input == c) {
			return true;
		} else {
			return false;
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
