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
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 600;
	private JPanel northPanel = new JPanel();
	private JPanel middlePanel = new JPanel();
	private JPanel southPanel = new JPanel();
	private JPanel westPanel = new JPanel();
	private JButton saveChangesButton, cancelButton, deletePersonButton;
	private JMenuItem quitButton, helpButton, sourceButton, newFileButton, saveButton, saveAsButton, openButton;
	private JFrame frame = new JFrame();
	private JMenu fileMenu, helpMenu;
	private JMenuBar menuBar;
	private ArrayList<OCCCPerson> personList = new ArrayList<OCCCPerson>();
	private OCCCDate odate = new OCCCDate();
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
	private String fileName = "output";
	private JScrollPane scrollPane;
	private JList<String> JList;
	private DefaultListModel<String> model = new DefaultListModel<String>();
	private int numInList;
	
	
	public static void main(String[] args) {
		PersonApplicationGUI paGUI = new PersonApplicationGUI();
	}
	
	public PersonApplicationGUI() {
		
		//Initialize JFrame
		frame.setTitle("Person Application GUI");
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		//Initialize OCCCDate
		odate.setDayName(odate.HIDE_DAY_NAME);
		odate.setStyleFormat(odate.STYLE_NUMBERS);
		odate.setDateFormat(odate.FORMAT_US);
		
		//Initialize everything else
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
		deletePersonButton   = new JButton("Delete Person");
	    cancelButton = new JButton("Discard Changes");
	    
	    model.addElement("                                                                                 ");
	    JList = new JList<String>(model);
	    scrollPane = new JScrollPane();
	    scrollPane.setViewportView(JList);
	    JList.setLayoutOrientation(JList.VERTICAL);
	    westPanel.add(scrollPane);
		
	    //Create panels
		northPanel.setLayout(new FlowLayout());
		frame.add(northPanel, BorderLayout.NORTH);
		middlePanel.setLayout(new GridLayout(5, 2));
		frame.add(middlePanel, BorderLayout.CENTER);
		southPanel.setLayout(new FlowLayout());
		frame.add(southPanel, BorderLayout.SOUTH);
		westPanel.setLayout(new FlowLayout());
		frame.add(westPanel, BorderLayout.WEST);
		
		//Create button group
		buttonGroup.add(personButton);
		buttonGroup.add(rPersonButton);
		buttonGroup.add(oPersonButton);
		
		//North panel
		northPanel.add(personButton);
		northPanel.add(rPersonButton);
		northPanel.add(oPersonButton);
		
		//Middle panel
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
		
		//South panel
		southPanel.add(deletePersonButton);
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
		
		JList.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        if (e.getClickCount() == 1) {
		        	personButton.setSelected(true);
		            numInList = JList.locationToIndex(e.getPoint());
		            firstNameField.setText(personList.get(numInList).getFirstName());
					lastNameField.setText(personList.get(numInList).getLastName());
					birthdateField.setText((personList.get(numInList).getDOBString()));
					govIDField.setText(null);
					OCCCIDField.setText(null);
					if(!personList.get(numInList).getGovernmentID().equalsIgnoreCase("null")) {
						rPersonButton.setSelected(true);
						govIDField.setText(personList.get(numInList).getGovernmentID());
					} if(!personList.get(numInList).getStudentID().equalsIgnoreCase("null")) {
						OCCCIDField.setText(personList.get(numInList).getStudentID());
						oPersonButton.setSelected(true);
					}
					
					
		        } 
		    }
		});
		
		deletePersonButton.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
	        	personList.remove(numInList);
	        	numInList = personList.size();
	        	model.clear();
				for(int i = 0; i < personList.size(); i ++) {
					model.addElement(personList.get(i).toString());
				}
				JList.setModel(model);
				
				firstNameField.setText(null);
				lastNameField.setText(null);
				birthdateField.setText(null);
				govIDField.setText(null);
				OCCCIDField.setText(null);
		    }
		});
		
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
					oDate = new OCCCDate(Integer.valueOf(stringArray[1]), Integer.valueOf(stringArray[0]), 
							Integer.valueOf(stringArray[2]));
					
					if(numInList == personList.size()) {
						personList.add(new OCCCPerson("null", "null", oDate, "null", "null"));
					}
					if(personButton.isSelected()) {
						personList.get(numInList).setFirstName(firstNameField.getText());
						personList.get(numInList).setLastName(lastNameField.getText());
					} else if(rPersonButton.isSelected()) {
						personList.get(numInList).setFirstName(firstNameField.getText());
						personList.get(numInList).setLastName(lastNameField.getText());
						personList.get(numInList).setGovernmentID(govIDField.getText());
					} else if(oPersonButton.isSelected()) {
						personList.get(numInList).setFirstName(firstNameField.getText());
						personList.get(numInList).setLastName(lastNameField.getText());
						personList.get(numInList).setGovernmentID(govIDField.getText());
						personList.get(numInList).setStudentID(OCCCIDField.getText());
					}
					
					try{
					    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("output", false)); 

					    objectOutputStream.writeObject(personList);
					    objectOutputStream.close();

					} catch (IOException b) {
					    b.printStackTrace();
					}
					
					firstNameField.setText(null);
					lastNameField.setText(null);
					birthdateField.setText(null);
					govIDField.setText(null);
					OCCCIDField.setText(null);
					
					model.clear();
					for(int i = 0; i < personList.size(); i ++) {
						model.addElement(personList.get(i).toString());
					}
					JList.setModel(model);
					
					numInList = personList.size();
					
				} else {
					JOptionPane.showMessageDialog(null, "You entered an invalid date, try again in mm/dd/yyyy format","Error", JOptionPane.ERROR_MESSAGE);
				}				
			}
		});	
		
		//Save button
		saveAsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = (String)JOptionPane.showInputDialog(null, "Enter file name", "Save As", 
						JOptionPane.WARNING_MESSAGE);
				try{
				    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName, false)); 
				    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(name));
				    
				    objectOutputStream.writeObject(objectInputStream);
				    objectOutputStream.close();

				} catch (IOException b) {
				    b.printStackTrace();
				}
				firstNameField.setText(null);
				lastNameField.setText(null);
				birthdateField.setText(null);
				govIDField.setText(null);
				OCCCIDField.setText(null);
			}
		});
		
		//Help button gives some amount of help
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNameField.setText(null);
				lastNameField.setText(null);
				birthdateField.setText(null);
				govIDField.setText(null);
				OCCCIDField.setText(null);
			}
		});
		
		//Open file button
		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
			    int returnVal = fileChooser.showOpenDialog(frame);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       fileName = fileChooser.getSelectedFile().getPath();
			       personList.clear();
			       ObjectInputStream objectInputStream;
				try {
					objectInputStream = new ObjectInputStream(new FileInputStream(fileChooser.getSelectedFile().getPath()));
					try {
						personList = (ArrayList<OCCCPerson>) objectInputStream.readObject();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					objectInputStream.close();
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			       
			    }
			    model.clear();
				for(int i = 0; i < personList.size(); i ++) {
					model.addElement(personList.get(i).toString());
				}
				JList.setModel(model);
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
				
				model.clear();
				for(int i = 0; i < personList.size(); i ++) {
					model.addElement(personList.get(i).toString());
				}
				JList.setModel(model);
				
				firstNameField.setText(null);
				lastNameField.setText(null);
				birthdateField.setText(null);
				govIDField.setText(null);
				OCCCIDField.setText(null);
			}
		});	

		//Create new file button
		newFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileName = (String)JOptionPane.showInputDialog(null, "Enter file name", "New file", 
						JOptionPane.WARNING_MESSAGE);
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
