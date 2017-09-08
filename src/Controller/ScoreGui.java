package Controller;

import View.ScoreView;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import java.util.*;
import java.io.*;
public class ScoreGui /*extends JDialog*/ implements ActionListener
{
    public ScoreView vistaPuntajes;

    /*public ScoreGui()
    {
        vistaPuntajes = new ScoreView();
        //super();
    }*/
    public /*JLabel*/ ScoreGui()//the ScoreGui Method displays the scores in order from lowest to highest.
    {
        vistaPuntajes = new ScoreView();
        vistaPuntajes.getOkBtb().addActionListener(this);
        //JLabel mainLabel = null;
        Container cp = vistaPuntajes.getContenedor();
        int lineNum=0;
             try{
                    String line = "";
                    String[] myScoreArray = new String[100];
                    for(int i=0; i<myScoreArray.length;i++)
                        myScoreArray[i]=" ";
                        String line1="";
                    BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream("scores.txt")));//read in the scores data
                    int recordsCount=0;
                    while((line = br1.readLine()) != null) 
                    {
                        line = br1.readLine();
                        if(line!="")
                        {
                            recordsCount+=1;
                            int tempPOS = line.indexOf("*");//use the star to indicate the next charator is going to be the maze level which we will sort by.
                            String pos=line.substring(tempPOS+1);
                            int index = Integer.parseInt(pos);
                            if(myScoreArray[index] == " ")
                                myScoreArray[index]=line;//add in the score to the array.
                          else
                          {
                               for(int i=0; i<myScoreArray.length;i++)
                               {
                                   if(index+i<myScoreArray.length)//prevent array out of bounds errors.
                                   {
                                   if(myScoreArray[index+i].equals(" "))
                                   {
                                       myScoreArray[index+1]=line;//add in a score to the next available area of the array
                                   }
                                   }//end first if
                               }//end for loop
                           }//end else
                             JPanel scorePanel = new JPanel();
                             scorePanel.setLayout(new GridLayout(recordsCount,recordsCount));
                             String scoreContent = "";
                                 for(int i=0; i<myScoreArray.length;i++)
                                 {
                                     if(myScoreArray[i]!=" ")
                                     {
                                         //mainLabel=new JLabel(myScoreArray[i], JLabel.LEFT);//display the score on the screen
                                         scoreContent += (myScoreArray[i] +"\n");
                                         //System.out.println(myScoreArray[i]);
                                         //scorePanel.add(mainLabel);
                                         //vistaPuntajes.setScorePanel(scorePanel);
                                     }
                                 }//end for loop
                                 vistaPuntajes.getTextScore().setText(scoreContent);
                                cp.add(scorePanel);
                                vistaPuntajes.setContenedor(cp);
                           }//end very first if
                     }//end first while loop            
                }//end try
                catch(IOException ex) {
                    JFrame frame = new JFrame("Alert");
                    JOptionPane.showMessageDialog(frame, "Problem with scores.txt file.  Cant load high Scores");
                }//end catch
        vistaPuntajes.pack();
        vistaPuntajes.setVisible (true);
        //return mainLabel;
    }//end constructor
    
    public void actionPerformed(ActionEvent e)
    {
        vistaPuntajes.dispose();
    }
}//end class