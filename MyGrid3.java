import javax.swing.*; import java.awt.*; import java.awt.event.*;
public class MyGrid3 extends JPanel implements ActionListener {
int rows = 4, columns=6;
JButton a[][] = new JButton [rows][columns];
JLabel status = new JLabel();
public static void main (String[] args){
MyGrid3 content = new MyGrid3();
JFrame window = new JFrame("2D using 2D Arrays");
window.setContentPane( content);
window.setSize(300,175);
window.setLocation( 100, 100);
window.setVisible(true);
}//end main
public MyGrid3 () {
JPanel g = new JPanel (new GridLayout (rows, columns));
JPanel g2 = new JPanel();
for (int i = 0 ; i < rows ; i++) {
for (int j=0; j < columns; j++) {
a [i][j] = new JButton (" ");
a [i][j].addActionListener (this);
a [i][j].setActionCommand ("" + (i*10+j));
g.add (a [i][j]);
}
}
g2.add(status);
status.setText(" ");
add (g);
add (g2);
}//end constructor
public void actionPerformed (ActionEvent e) {
int n = Integer.parseInt (e.getActionCommand ());
int x = n / 10;
int y = n % 10;
status.setText("You pressed: " + "(" + x + ", " + y + ")");
}//end actionPerformed
}//end class