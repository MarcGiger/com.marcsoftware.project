import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *   JMenuFrame: includes one JMenuBar,2 JMenus and 8 JMenuItem objects. 
 *   When a menu item is selected, a string
 *   showing which menu choice is selected will appear in a label on the frame.
 */
public class JMenuFrame extends JFrame implements ActionListener
{
   JMenu fileMenu;  
   JMenu editMenu;
   JLabel response; // to hold a result from the menus

    public static void main(String[] args) {
        JMenuFrame frame = new JMenuFrame();
        frame.setVisible(true);
    }

    public JMenuFrame() {
        Container cPane;

        //set the frame properties
        setTitle     ("JMenuFrame");
        setSize      (300,200);
        setResizable (false);
        setLocation  (250,200);
        // shut down the program when the window is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cPane = getContentPane( );
        cPane.setLayout(new FlowLayout());

        //invoke a user-written method create two menus and their menu items
        // done by separate method to make the constructor shorter
        createFileMenu();
        createEditMenu();

        //and add them to the menubar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.yellow);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        //create and position reponse label
        response = new JLabel("Hello, this is your menu tester." );
        response.setSize(250, 50); // optional
        cPane.add(response);
    } // end constructor

    /** when an item is clicked, response starts here */
    public void actionPerformed(ActionEvent event) {
        String  menuName;
        menuName = event.getActionCommand(); // what's written on the item that was clicked
        // note the String comparison
        if (menuName.equals("Quit")) {
           System.exit(0);
        } // end if
        else {
           response.setText("Menu Item '" + menuName + "' is selected.");
        } // end else
    } // end actionPerformend

    /**  Creates File menu and its menu items */
    private void createFileMenu( ) {
        JMenuItem    item; // declare a re-usable JMenuItem object
        
	// first, create the menu: then you can start on the items
        fileMenu = new JMenu("File");
        
	// create the first item
        item = new JMenuItem("New");        //New
    // make sure the program is listening for clicks: handle them in 'this' class
        item.addActionListener( this );
    // attach the item to the menu
        fileMenu.add( item );

       // repeat for all the other menu items in the File menu 
        item = new JMenuItem("Open...");    //Open...
        item.addActionListener( this );
        fileMenu.add( item );

        item = new JMenuItem("Save");       //Save
        item.addActionListener( this );
        fileMenu.add( item );

        item = new JMenuItem("Save As..."); //Save As...
        item.addActionListener( this );
        fileMenu.add( item );

        fileMenu.addSeparator();           //add a horizontal separator line

        item = new JMenuItem("Quit");       //Quit
        item.addActionListener( this );
        fileMenu.add( item );
    } // end createFileMenu

    private void createEditMenu( ) {
        JMenuItem    item;

        editMenu = new JMenu("Edit");

        item = new JMenuItem("Cut");      //Cut
        item.addActionListener( this );
        editMenu.add( item );

        item = new JMenuItem("Copy");    //Copy
        item.addActionListener( this );
        editMenu.add( item );

        item = new JMenuItem("Paste");    //Paste
        item.addActionListener( this );
        editMenu.add( item );
    } // end createEditMenu
} // end class
