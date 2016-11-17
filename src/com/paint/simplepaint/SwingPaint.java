package com.paint.simplepaint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class SwingPaint {
 
  JButton clearBtn, blackBtn, blueBtn, greenBtn, redBtn, magentaBtn;
  ArrayList<JButton> bl = new ArrayList<JButton>();
  DrawArea drawArea;
  ActionListener actionListener = new ActionListener() {
 
  public void actionPerformed(ActionEvent e) {
      if (e.getSource() == clearBtn) {
        drawArea.clear();
        initializeButtons();
      } else if (e.getSource() == blackBtn) {
        drawArea.black();
        colorSelected(blackBtn);
      } else if (e.getSource() == blueBtn) {
        drawArea.blue();
        colorSelected(blueBtn);
      } else if (e.getSource() == greenBtn) {
        drawArea.green();
        colorSelected(greenBtn);
      } else if (e.getSource() == redBtn) {
        drawArea.red();
        colorSelected(redBtn);
      } else if (e.getSource() == magentaBtn) {
        drawArea.magenta();
        colorSelected(magentaBtn);
      }
    }
  };
  public void colorSelected(JButton selected){
	  for(JButton x:bl){
		  if(x.equals(selected)){
			  if(x.equals(blackBtn))
				  x.setBackground(Color.GRAY);
			  else if(x.equals(blueBtn))
				  x.setBackground(Color.BLUE);
			  else if(x.equals(greenBtn))
				  x.setBackground(Color.GREEN);
			  else if(x.equals(redBtn))
				  x.setBackground(Color.RED);
			  else if(x.equals(magentaBtn))
				  x.setBackground(Color.MAGENTA);
		  }
		  else
			  x.setBackground(Color.WHITE);
	  }
  }
  //initializing the Buttons to default color "White"
  
  public void initializeButtons(){
	  for(JButton x:bl){
		  x.setBackground(Color.WHITE);
	  }
	  colorSelected(blackBtn);
  }
  public static void main(String[] args) {
    new SwingPaint().show();
  }
 
  public void show() {
    // create main frame
    JFrame frame = new JFrame("Swing Paint");
    Container content = frame.getContentPane();
    // set layout on content pane
    content.setLayout(new BorderLayout());
    // create draw area
    drawArea = new DrawArea();
 
    // add to content pane
    content.add(drawArea, BorderLayout.CENTER);
 
    // create controls to apply colors and call clear feature
    JPanel controls = new JPanel();
 
    clearBtn = new JButton("Clear");
    clearBtn.addActionListener(actionListener);
    blackBtn = new JButton("Black");
    blackBtn.addActionListener(actionListener);
    blueBtn = new JButton("Blue");
    blueBtn.addActionListener(actionListener);
    greenBtn = new JButton("Green");
    greenBtn.addActionListener(actionListener);
    redBtn = new JButton("Red");
    redBtn.addActionListener(actionListener);
    magentaBtn = new JButton("Magenta");
    magentaBtn.addActionListener(actionListener);
 
    // add to panel
    controls.add(greenBtn);
    controls.add(blueBtn);
    controls.add(blackBtn);
    controls.add(redBtn);
    controls.add(magentaBtn);
    controls.add(clearBtn);
 
    // add to content pane
    content.add(controls, BorderLayout.NORTH);
 
    //Button List Generation
    bl.add(blueBtn);
    bl.add(greenBtn);
    bl.add(magentaBtn);
    bl.add(redBtn);
    bl.add(blackBtn);
    
    initializeButtons();
    frame.setSize(600, 600);
    // can close frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // show the swing paint result
    frame.setVisible(true);
 
  }
 
}