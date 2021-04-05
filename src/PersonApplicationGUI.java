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
import javax.swing.filechooser.FileNameExtensionFilter;

import java.time.LocalDate;


public class PersonApplicationGUI implements ActionListener{
	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;
	private JPanel northPanel = new JPanel();
	private JPanel middlePanel = new JPanel();
	private JPanel southPanel = new JPanel();
	private JButton saveChangesButton, cancelButton;
	private JMenuItem quitButton, helpButton, sourceButton, newFileButton, saveButton, saveAsButton, openButton;
	private JFrame frame = new JFrame();
	private JMenu fileMenu, helpMenu;
	private JMenuBar menuBar;
	private ArrayList<OCCCPerson> personList = new ArrayList<OCCCPerson>();
	private OCCCDate odate = new OCCCDate();
	private Person person = new Person("John", "Doe", odate); //Blank person
	private RegisteredPerson RPerson = new RegisteredPerson(person, "null"); //Blank rperson
	private OCCCPerson OPerson = new OCCCPerson(RPerson, "null"); //Blank operson
	private JLabel firstNameLabel = new JLabel("Enter first name:");
	private JTextField firstNameField = new JTextField();
	private JLabel lastNameLabel = new JLabel("Enter last name:");
	private JTextField lastNameField = new JTextField();
	private JLabel birthdateLabel = new JLabel("Enter birthdate (mm/dd/yyyy):");
	private JTextField birthdateField = new JTextField();
	private JLabel govIDLabel = new JLabel("Enter government ID number:");
	private JTextField govIDField = new JTextField();
	private JLabel OCCCIDLabel = new JLabel("Enter OCCC ID number:");
	private JTextField OCCCIDField = new JTextField();
	private JRadioButton personButton = new JRadioButton("Person", true);
	private JRadioButton rPersonButton = new JRadioButton("RegisteredPerson");
	private JRadioButton oPersonButton = new JRadioButton("OCCCPerson");
	private ButtonGroup buttonGroup = new ButtonGroup();
	private String fileName;
	
	
	public static void main(String[] args) {
		PersonApplicationGUI idk = new PersonApplicationGUI();
	}
	
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
		middlePanel.setLayout(new GridLayout(5, 2));
		frame.add(middlePanel, BorderLayout.CENTER);
		southPanel.setLayout(new FlowLayout());
		frame.add(southPanel, BorderLayout.SOUTH);
		
		buttonGroup.add(personButton);
		buttonGroup.add(rPersonButton);
		buttonGroup.add(oPersonButton);
		
		northPanel.add(personButton);
		northPanel.add(rPersonButton);
		northPanel.add(oPersonButton);
		
		middlePanel.add(firstNameLabel);
		middlePanel.add(firstNameField);
		middlePanel.add(lastNameLabel);
		middlePanel.add(lastNameField);
		middlePanel.add(birthdateLabel);
		middlePanel.add(birthdateField);
		middlePanel.add(govIDLabel);
		middlePanel.add(govIDField);
		middlePanel.add(OCCCIDLabel);
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

		//Save button
		saveChangesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OCCCDate oDate;
				
				if(isValidDate(birthdateField.getText())) {
					String[] stringArray = birthdateField.getText().split("/");
					System.out.println(stringArray[0]);
					System.out.println(stringArray[1]);
					System.out.println(stringArray[2]);
					oDate = new OCCCDate(Integer.valueOf(stringArray[1]), Integer.valueOf(stringArray[0]), 
							Integer.valueOf(stringArray[2]));
					if(personButton.isSelected()) {
						personList.add(new OCCCPerson(firstNameField.getText(), lastNameField.getText(), oDate,
								"null", "null"));
					} else if(rPersonButton.isSelected()) {
						personList.add(new OCCCPerson(firstNameField.getText(), lastNameField.getText(), oDate,
								govIDField.getText(), "null"));
					} else if(oPersonButton.isSelected()) {
						personList.add(new OCCCPerson(firstNameField.getText(), lastNameField.getText(), oDate,
								govIDField.getText(), OCCCIDField.getText()));
						
						try{
						    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName+".dat", false)); 

						    objectOutputStream.writeObject(personList);
						    objectOutputStream.close();

						} catch (IOException b) {
						    b.printStackTrace();
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "You entered an invalid date, try again in mm/dd/yyyy format","Error", JOptionPane.ERROR_MESSAGE);
				}				
			}
		});	
		
		//Open file button
		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Supported file types","txt");
				fileChooser.setFileFilter(filter);
			    int returnVal = fileChooser.showOpenDialog(frame);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       fileName = fileChooser.getSelectedFile().getName();
			    }
			}
		});	
		
		//Save button
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName+".dat", false)); 

				    objectOutputStream.writeObject(personList);
				    objectOutputStream.close();

				} catch (IOException b) {
				    b.printStackTrace();
				}
			}
		});	
				
		frame.setJMenuBar(menuBar);
        frame.setVisible(true);
        
	}

	/**
	 * Check if input string is a valid date in mm/dd/yyyy format. DOES NOT HANDLE WRAPPING
	 * @param s input string
	 * @return true if valid, false if not
	 */
	private boolean isValidDate(String s) {
		if(s.length() != 10) {
			return false;
		}
		
		Character[] charArray = new Character[s.length()];
		for(int i = 0; i < charArray.length; i ++) {
			charArray[i] = s.charAt(i);
		}
		
		
		if(Character.isDigit(charArray[0]) && Character.isDigit(charArray[1]) && isChar(charArray[2], '/') && 
				Character.isDigit(charArray[3]) && Character.isDigit(charArray[4]) && isChar(charArray[5], '/') && 
				Character.isDigit(charArray[6]) && Character.isDigit(charArray[7]) && Character.isDigit(charArray[8]) && 
				Character.isDigit(charArray[9])) {
			return true;
		}
		return false;
	}
	
	/***
	 * Checks if input char is equal to another input char
	 * @param input char to be checked
	 * @param c char to be checked against
	 * @return true if equal, false if not
	 */
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
