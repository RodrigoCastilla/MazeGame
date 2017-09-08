/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ARMC3PO
 */
public class MazeObject extends JLabel//inner class for each maze object, aka wall, player etc
    {
    private JLabel imageLabel;
    private JPanel newPanel;
    public MazeObject(JPanel panel, String filename){
            this.newPanel = panel;
            filename+=".png";
            JLabel fancyLabel;
            fancyLabel = new JLabel("",new ImageIcon(filename),JLabel.LEFT);
            newPanel.add(fancyLabel);
    }
    public JPanel getPanel(){
        return newPanel;
    }
    }
