import hsa.Console;
import java.awt.*;
import java.lang.Math;
import java.util.*;
import java.io.*;
import javax.imageio.*;

public class bg
{ 
  static Console c;
  public static void main (String[] args) throws IOException
  {//main method
    c = new Console(45,290);
    
    Image img,player,enemy;  //The image to draw
    
    //Try to import the image from the file
    try{
      
     img = ImageIO.read(new File("bg.jpg"));
     player = ImageIO.read(new File("knight.png"));
     enemy = ImageIO.read(new File("badguy.png"));
    }
    catch(IOException e)  //File not found
    {
      img = null;
      player = null;
      enemy = null;
      
    }
    
    //Draw the image (Image, x location, y location, null)
    c.drawImage(img,10,10,null);
    c.drawImage(player,20,140,null);
    c.drawImage(enemy,1000,400,null);
    
    
    
   
    
  }
}