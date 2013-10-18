/*
 * Snake.java
 * 
 * Version:
 *          $Id$
 * 
 * Revisions:
 *          $Log$
 * 
 */

/*
*@Problem       : To create a Snake and Ladder game using Java Swing
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4003-707
*@Author        : Pratik Dilip Mehta : Batch : 4003-707
*@Version       : 1.0.1
*@LastModified  : 11/4/2012 7.15 PM
*
*/

//package snake;
import java.awt.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.TransferHandler;
import javax.swing.border.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


 public class Snake extends JFrame  
 {
     
     //JLabel move;    
     //JPanel board;
     
     // Represents each block in the board    
     JPanel block[]=new JPanel[36];
     //Each Block on board is labelled with number
     static JLabel number[]=new JLabel[36];
     //To roll the dice
     JButton Dice;
     //Button for player 1
     JButton Player1;
     //Button for player 2
     JButton Player2;
     //Button for resetting the game
     JButton Reset;
     //Text area for player 1
     JTextArea P1;
     //Text area for player 2
     JTextArea P2;
     //Text area for dice result
     JTextArea DiceVal;
     //To track player1 play
     static int store1=0;
     //To track player2 play
     static int store2=0;
     //Tracks the turn for players
     static int turn=1;
      /*
     * Snake    Constructor : Creates the boards and add necessary actionListeners
     * 
     */
     public Snake() 
     {
         //Specifiying a dimension object : for frame
         Dimension obj=new Dimension(800,800);
         setPreferredSize(obj);
         //Making the current frame into flowlayout to house the board and play options
         setLayout(new FlowLayout());
         JPanel pane1=new JPanel();
         //Grid layout for the board
         pane1.setLayout(new GridLayout(6,6));
         //Setting border 
         pane1.setBorder(BorderFactory.createLineBorder(Color.black));
         //Setting the board size
         pane1.setPreferredSize(new Dimension(600,600));
         add(pane1);
         
         JPanel pane2=new JPanel();
         add(pane2);
         
         Dice=new JButton("P1 Roll Dice");
         pane2.add(Dice);
         DiceVal=new JTextArea("0");
         DiceVal.setPreferredSize(new Dimension(50,20));
         pane2.add(DiceVal);
         
         Player1=new JButton("Move P1");
         Player2=new JButton("Move P2");
         P1=new JTextArea("0");
         P1.setPreferredSize(new Dimension(50,20));
         P2=new JTextArea("0");
         P2.setPreferredSize(new Dimension(50,20));
         
         Reset=new JButton("Reset");
         
         //Add all components to the frame
         pane2.add(Player1);
         pane2.add(P1);
         pane2.add(Player2);
         pane2.add(P2);
         pane2.add(Reset);
         
         setPreferredSize(obj);           
         
         int arr[]=new int[36];
         
         int j=36;
         //Creating the board : using blocks 
         for(int i=0;i<36;i++)
         {
             //if((i/6)%2==0)                 
                 
         block[i]=new JPanel(new BorderLayout());
         block[i].setBorder(new EmptyBorder(10, 10, 10, 10));
         block[i].setPreferredSize(new Dimension(100,100));
         //Alternate blocks of lightgray and red color 
         int temp=(i/6)%2;
         if(temp==0)
         {
             if(i%2==0)
         block[i].setBackground(Color.lightGray);
             else
                 block[i].setBackground(Color.red);
         }
         else
         {
             if(i%2==0)
             block[i].setBackground(Color.red);
             else
                 block[i].setBackground(Color.lightGray);
         }
         
         //Also creating labels for each block        
         number[i]=new JLabel();
         number[i].setText(new Integer(i+1).toString());
         
         if(i==0)
         {
             number[i].setText("START: P1 P2 ");
         }
         
         if(i==35)
         {
             number[i].setText("      FINISH");
         }
         //Setting border for each block
         block[i].setBorder(BorderFactory.createLineBorder(Color.black));
         //adding the block to the gridlayout
         pane1.add(block[i]);
         //adding the number label to the block
         block[i].add(number[i]);
         
         
         //Creating ladders
         if(i==8 || i==21 || i==17)
         {
         JLabel piece = new JLabel(new ImageIcon("ladder.png"));
         JLabel numb=new JLabel();
         numb.setText(new Integer(i+1).toString());
         piece.setText(new Integer(i+1).toString());
         block[i].add(piece);
         }
         
         //Creating snakes
          if(i==12 || i==25 || i==34)
         {
         JLabel piece = new JLabel(new ImageIcon("snake.png"));
         JLabel numb=new JLabel();
         numb.setText(new Integer(i+1).toString());
         piece.setText(new Integer(i+1).toString());
         block[i].add(piece);
         }
          
         j--;        
         }
     
         /*
        * Dice    ActionListener for dice : Gives random value from 1-6
        *         Keeps track of players turn
        * 
        */
         
         Dice.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                  Integer rand=1+((int)(Math.random()*1000)%6);
                  DiceVal.setText(rand.toString());
                  if(turn%2==1)
                  {
                      P1.setText(rand.toString());
                      Player1.setBackground(Color.green);
                      Player2.setBackground(Color.red);
                      P2.setText("0");
                      turn++;
                  }
                  else
                  {
                      P2.setText(rand.toString());
                      Player2.setBackground(Color.green);
                      Player1.setBackground(Color.red);
                      P1.setText("0");
                      turn++;
                  }
                  
                  Dice.setBackground(Color.red);
                  
                 //DiceVal.setText("hi");
             }
         });
         
     /*
     * Player1  ActionListener : Moves steps w.r.t dice value for player 1
     *                           Tracks position of player 2    
     * 
     */
         
         Player1.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 String temp=P1.getText();
                 P1.setText("0");
                 int index=Integer.parseInt(temp);
                 if(index>0){
                     
                     if(number[store1].getText().contains("P1 P2")){
                 number[store1].setText(new Integer(store1+1).toString()+" P2");
                 number[store1].setFont(new Font("Serif",Font.BOLD,20));
                 number[store1].setForeground(Color.white);}
                 
                     else{
                 number[store1].setText(new Integer(store1+1).toString());
                 number[store1].setForeground(null);
                 number[store1].setFont(null);}
                     
                     
                 
                 if(number[store1+index].getText().contains("P2"))
                     number[store1+index].setText(new Integer(store1+index+1).toString()+"P1 P2");
                 else
                 {
                     if(store1+index==8 || store1+index==21 || store1+index==17)store1=store1+5;
                     if(store1+index==12 || store1+index==26 || store1+index==34)store1=store1-5;
                     if(store1+index==35)
                          JOptionPane.showMessageDialog(rootPane,"PLAYER 1 WINS ");
                     
                 number[store1+index].setText(new Integer(store1+index+1).toString()+" P1");
                 
                 number[store1+index].setFont(new Font("Serif",Font.BOLD,20));
                 number[store1+index].setForeground(Color.white);                
                 
                 store1=store1+index;
                 
                 Dice.setText("P2 Roll Dice");
                 Dice.setBackground(Color.green);
                 Player1.setBackground(Color.red);
                 
                }
             }
           }
         });
         /*
     * Player2  ActionListener : Moves steps w.r.t dice value for player 2
     *                           Tracks position of player 1
     */
        
         Player2.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 String temp=P2.getText();
                 P2.setText("0");
                 int index=Integer.parseInt(temp);
                 if(index>0){
                     if(number[store2].getText().contains("P1 P2")){
                 number[store2].setText(new Integer(store2+1).toString()+" P1");
                 number[store2].setFont(new Font("Serif",Font.BOLD,20));
                 number[store2].setForeground(Color.white);}
                 
                     else{
                 number[store2].setText(new Integer(store2+1).toString());
                 number[store2].setForeground(null);
                 number[store2].setFont(null);}
                 
                 if(number[store2+index].getText().contains("P1"))
                     number[store2+index].setText(new Integer(store2+index+1).toString()+"P1 P2");
                 else{
                     if(store2+index==8 || store2+index==21 || store2+index==17)store2=store2+5;
                      if(store2+index==12 || store2+index==26 || store2+index==34)store2=store2-5;
                      if(store2+index==35)
                          JOptionPane.showMessageDialog(rootPane,"PLAYER 2 WINS ");
                          
                      
                 number[store2+index].setText(new Integer(store2+index+1).toString()+" P2");
                 
                 number[store2+index].setFont(new Font("Serif",Font.BOLD,20));
                 number[store2+index].setForeground(Color.white);                
                 
                 store2=store2+index;
                 
                 Dice.setText("P1 Roll Dice");
                 Dice.setBackground(Color.green);
                 Player2.setBackground(Color.red);
                 
             }}}
         });
         
         /*
     * Reset  ActionListener : creates and new frame and a new game board
     * 
     */
        
         Reset.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 store1=0;
                 store2=0;
                 turn=1;
                 setVisible(false);
                 JFrame temp=new Snake();
                 temp.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
                 temp.pack();
                 temp.setResizable(true);
                 temp.setLocationRelativeTo( null );
                 temp.setVisible(true);
                
             }
         });           

     }  
     
 //Invoking main function    
 public static void main(String[] args) 
 {
  //Creating a new Frame 
  JFrame frame = new Snake();
  frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
  frame.pack();
  frame.setResizable(true);
  frame.setLocationRelativeTo( null );
  frame.setVisible(true);
 }   
}