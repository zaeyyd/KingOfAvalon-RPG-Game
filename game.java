
import hsa.Console;
import java.awt.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;

public class game
  
{
  static Console c;                                                //console for images
  static Console c2;                                               //console for text
  static Characters[] player = new Characters[10];                 //array for characters in game
  static weapon[] wep = new weapon[3];                             //array for weapons in game
  static Potion[] pot = new Potion[5];                             //array for potion possibilities in mystery box
  static Image img;                                               //images
  static String playAgain;                                        //variable to play again
  static Image troll;                                             //youll find out
  
  public static void main (String[] args)  
  {
    c = new Console(45,290);
    c2 = new Console();
    
     
    
    //Try to import the image from the file
    try{
      
      troll = ImageIO.read(new File("troll.png"));
     
      
    }
    catch(IOException e)  //File not found
    {
      troll = null;
    }
    
    //Draw the image (Image, x location, y location, null)
    c.drawImage(troll,10,10,null);
    
    
    
    while(true){
      
      c.clear();
      
      int x = prologue();                                       //variable for integer returned for outcome of prologue
      
      while(x==2){
        x= prologue();
        
        
      }
      if(x==1){
        
        chooseWeapon();
        
        
        if(levelOne())
        {
          c2.println("LEVEL 1 passed");
          c.clear();
          
          if(levelTwo())
          {
            c2.println("LEVEL 2 passed");
            c.clear();
            if(levelThree())
            {
              c2.println("LEVEL 3 passed");
              if(levelFour())
              {
                c2.println("LEVEL 4 passed");
                levelFive();
                if(levelSix())
                {
                  c2.println("LEVEL 6 passed");
                  epilogue();
                }
                else{
                  c2.println("GAME OVER");
                  c2.println("play again? [Y/N]");
                  c.drawImage(troll,10,10,null);
                  playAgain = c2.readLine();
                }
                
                
              }
              else{
                c2.println("GAME OVER");
                c2.println("play again? [Y/N]");
                  c.drawImage(troll,10,10,null);
                  playAgain = c2.readLine();
              }
              
              
            }
            else{
              c2.println("GAME OVER");
              c2.println("play again? [Y/N]");
                  c.drawImage(troll,10,10,null);
                  playAgain = c2.readLine();
            }
            
          }
          else{
            c2.println("GAME OVER");
            c2.println("play again? [Y/N]");
                  c.drawImage(troll,10,10,null);
                  playAgain = c2.readLine();
          }
          
        }
        else{
          c2.println("GAME OVER");
          c2.println("play again? [Y/N]");
                  c.drawImage(troll,10,10,null);
                  playAgain = c2.readLine();
        }
        
        
      }
      
      else if(x==3){
        c2.println("GAME OVER");
        break;
        
        
      }
      
      
      
    } 
  }//main
  
  
  //draws enemy character
  public static void drawEnemy(int playerNumb,Image enemy)
  {
    int x;                            //variable for integer in switch
    
    switch(x=player[playerNumb].getPosition()){
      
      case 0:
        c.drawImage(enemy,750,250,null);
        break;
        
      case 1:
        c.drawImage(enemy,500,400,null);
        break;        
      case 2:
        c.drawImage(enemy,660,400,null);
        break;
      case 3:  
        c.drawImage(enemy,820,400,null);
        break;
      case 4:
        c.drawImage(enemy,980,400,null);
        break;
      case 5:
        c.drawImage(enemy,1150,400,null);
        break;
        
        
    }
    
  }
  
  //method for user to select weapon following prologue
  public static void chooseWeapon()
  {
    String option;                 //variable for weapon user selects
    
    c.println("CHOOSE A WEAPON");
    c.println("(A) SWORD");
    c.println("(B) BOW AND ARROW");
    c.println("(C) AXE");
    
    option = c2.readLine();
    
    if(option.equalsIgnoreCase("a")){
      c2.println("GREAT CHOICE KNIGHT"+player[0].getName());
      
      player[0].addStrength(wep[0].getDamage());
      player[0].addRange(wep[0].getRange());
      player[0].updateWeaponEquipped(1);
      
    }
    
    
    if(option.equalsIgnoreCase("b")){
      c2.println("GREAT CHOICE KNIGHT"+player[0].getName());
      
      player[0].addStrength(wep[1].getDamage());
      player[0].addRange(wep[1].getRange());
      player[0].updateWeaponEquipped(2);
    }
    
    if(option.equalsIgnoreCase("c")){
      c2.println("GREAT CHOICE KNIGHT"+player[0].getName());
      
      player[0].addStrength(wep[2].getDamage());
      player[0].addRange(wep[2].getRange());
      player[0].updateWeaponEquipped(3);
    }
  }
  
  
  
  //compares the intelligence between user and enemy. Depletes strength and increases intelligence
  public static boolean useIntel(int playerNumb, int opponentNumb)
  {
    
    int playerIntel = player[playerNumb].getIntel();              //gets player intelligence level
    int enemyIntel = player[opponentNumb].getIntel();             //gets enemy's intelligence level
    
    if(playerIntel>enemyIntel){
      c2.println("SUCCESS");
      player[0].addIntel(1);
      player[0].subStrength(1);
      return true;
      
      
      
    }
    else if(playerIntel==enemyIntel){
      if((int)(Math.random()*2+0)==1){
        c2.println("success");
        player[0].addIntel(1);
        player[0].subStrength(1);
        return true;
        
      }
      else{
        c2.println("FAILLLLL");
        return false;
      }
    }
    else{
      c2.println("FAIL");
      return false;
    }
    
    
    
  }
  
  //compares your charisma to enemy. Depletes intelligence and increases charisma
  public static boolean useCharisma(int playerNumb, int opponentNumb)
  {
    
    int playerCharisma = player[playerNumb].getCharisma();
    int enemyCharisma = player[opponentNumb].getCharisma();
    
    if(playerCharisma>enemyCharisma){
      c2.println("SUCCESS");
      player[0].addCharisma(1);
      player[0].subIntel(1);
      return true;
      
      
    }
    else if(playerCharisma==enemyCharisma){
      if((int)(Math.random()*2+0)==1){
        c2.println("success");
        
        player[0].addCharisma(1);
        player[0].subIntel(1);
        return true;
      }
      
      else{
        c2.println("FAILLLLL");
        return false;
      }
    }
    else{
      c2.println("FAIL");
      return false;
    }
    
    
    
  }
  
  //attack method used in battles
  public static int attack(int playerNumb,int opponentNumb)            
  {
    int range = player[playerNumb].getRange();                   //gets player and enemy's range
    int position = player[opponentNumb].getPosition();           //gets position
    
    int strength1 = player[playerNumb].getStrength();           //gets player's strength
    int strength2 = player[opponentNumb].getStrength();         //gets enemy strength
    
    if(strength1>strength2)
    {
      if(range>=position){
        player[opponentNumb].subHealth(player[playerNumb].getStrength());
        
        if(player[opponentNumb].getHealth()<1){
          c2.println("YOU SAVAGE BROOOO ");
          return 3;
        }
        else {
          c2.println("You hit the enemy");
          
          return 2;}
      }
      
      else
      {
        c2.println("You are ded");
        return 1;
      }
      
    }
    
    if(strength1==strength2)
    {
      
      int randNumber = (int)(Math.random()*2+0);
      
      if(randNumber==1){
        
        if(range>=position){
          player[opponentNumb].subHealth(player[playerNumb].getStrength());
          
          if(player[opponentNumb].getHealth()<1){
            c2.println("YOU SAVAGE BROOOO ");
            return 3;
          }
          else {
            c2.println("You hit the enemy");
            
            return 2;}
        }
        
        else
        {
          c2.println("You are ded");
          return 1;
        }
      }
      else{
        c2.println("You are ded");
        return 1;
      }
    }
    else
    {
      c2.println("You are ded");
      return 1;
      
    }
  }
  
  //draws background
  public static void drawBg() 
  {
    Image bg,player,pos,face;  //The image to draw
    
    //Try to import the image from the file
    try{
      
      bg = ImageIO.read(new File("bg.jpg"));
      player = ImageIO.read(new File("knight.png"));
      pos = ImageIO.read(new File("1-5.png"));
      face = ImageIO.read(new File("azzamface.png"));
      
    }
    catch(IOException e)  //File not found
    {
      bg = null;
      player = null;  
      pos = null;
      face = null;
    }
    
    //Draw the image (Image, x location, y location, null)
    c.drawImage(bg,10,10,null);
    c.drawImage(player,20,200,null);
    c.drawImage(pos,530,700,null);
    c.drawImage(face,200,140,null);
    
    
  }
  
  //Level One
  public static boolean levelOne()                                             
  {
    
    
    String option = "";                        //variable to store user decisions in battle
    
    drawBg();
    
    Image enemy;  //The image to draw
    
    //Try to import the image from the file
    try{
      
      
      enemy = ImageIO.read(new File("badguy.png"));
    }
    catch(IOException e)  //File not found
    {
      
      enemy = null;
      
    }
    //Draw the image (Image, x location, y location, null)
    
    drawEnemy(1,enemy);
    
    
    
    statBars(0);
    statBars(1);
    
    c2.setColor(Color.RED);
    
    c2.println("AN ENEMY HAS APPEARED!!!!");
    
    c2.println("WHAT WILL YOU DO.."); 
    
    c2.println("A: Battle enemy");
    
    c2.println("B: Call him pretty");
    
    c2.println("C: Create distraction and escape situation");
    
    option = c2.readLine();
    
    if(option.equalsIgnoreCase("a"))
    {
      int x = attack(0,1);
      
      while(x==2){
        
        c2.println("attack successful");
        c2.println("press A to ATTACK AGAIN");
        c.clear();      
        drawBg();
        drawEnemy(1,enemy);
        statBars(0);
        statBars(1);
        option = c2.readLine();
        if(option.equalsIgnoreCase("a")){
          x = attack(0,1);
          option = ""; 
        }
      }
      if(x==3){
        changeWeapon(0,1);
        c.clear();      
        drawBg();
        drawEnemy(1,enemy);
        statBars(0);
        statBars(1);
        
        c2.println("battle won");
        
        
        if(statChecker()){
          return true;
        }
        else{
          return false;
        }
      }
      else{
        c2.println("u died");
        
        return false;
        
      }
      
      
    }
    
    else if(option.equalsIgnoreCase("b")){
      
      if(useCharisma(0,1)){
        c2.println("the enemy is flattered , he gives you his number");
        if(statChecker()){
          return true;
        }
        else{
          return false;
        }
      }
      else
      {
        c2.print("he wasnt impressed and stabbed you");
        return false;
      }
      
    }
    
    else if(option.equalsIgnoreCase("c")){
      
      if(useIntel(0,1)){
        c2.println("You stick your head inside the ground and the enemy is so dumb that he thinks you have vanished and then goes home to eat dinner giving you the opportunity to pass him");
        if(statChecker()){
          return true;
        }
        else{
          return false;
        }
      }
      else
      {
        c2.println("You stick your head inside the ground thinking that he won't be able to you but then the enemy slices your butt off");
        return false;
      }
      
    }
    
    else{
      
      return false;
    }
    
    
    
  }
  
  //level two
  public static boolean levelTwo()                                             
  {
    
    
    String option = "";                  //variable to store user decision in battles
    
    drawBg();
    
    Image enemy;  //The image to draw
    
    //Try to import the image from the file
    try{
      
      
      enemy = ImageIO.read(new File("badguy.png"));
    }
    catch(IOException e)  //File not found
    {
      enemy = null;
      
    }
    //Draw the image (Image, x location, y location, null)
    
    drawEnemy(2,enemy);
    
    
    
    statBars(0);
    statBars(2);
    
    c2.setColor(Color.RED);
    
    c2.println("AN ENEMY HAS APPEARED!!!!");
    
    c2.println("WHAT WILL YOU DO.."); 
    
    c2.println("A: Fight him");
    
    c2.println("B: Call him pretty");
    
    c2.println("C: Create distraction and escape situation");
    
    option = c2.readLine();
    
    if(option.equalsIgnoreCase("a"))
    {
      int x = attack(0,2);
      
      while(x==2){
        
        c2.println("attack successful");
        c2.println("press A to ATTACK AGAIN");
        c.clear();      
        drawBg();
        drawEnemy(2,enemy);
        statBars(0);
        statBars(2);
        option = c2.readLine();
        if(option.equalsIgnoreCase("a")){
          x = attack(0,2);
          option = ""; 
        }
      }
      if(x==3){
        player[0].addStrength(1);
        player[0].subCharisma(1);
        changeWeapon(0,2);
        c.clear();      
        drawBg();
        drawEnemy(2,enemy);
        statBars(0);
        statBars(2);
        
        c2.println("");
        if(statChecker()){
          return true;
        }
        else{
          return false;
        }
      }
      else{
        c2.println("u died");
        
        return false;
        
      }
      
      
    }
    
    else if(option.equalsIgnoreCase("b")){
      
      if(useCharisma(0,2)){
        c2.println("The enemy is flattered , he gives you his number ");
        if(statChecker()){
          return true;
        }
        else{
          return false;
        }
      }
      else
      {
        c2.print("he wasnt impressed and stabbed you");
        return false;
      }
      
    }
    
    else if(option.equalsIgnoreCase("c")){
      
      if(useIntel(0,2)){
        c2.println("You stick your head inside the ground and the enemy is so dumb that he thinks you have vanished and then goes home to eat dinner giving you the opportunity to pass him");
        if(statChecker()){
          return true;
        }
        else{
          return false;
        }
      }
      else
      {
        c2.println("You stick your head inside the ground thinking that he won't be able to you but then the enemy slices your butt off");
        return false;
      }
      
    }
    
    else{
      
      return false;
    }
    
    
    
  }
  
  //level three
  public static boolean levelThree()                                             
  {
    
    
    String option = "";                           //variable to store user decision in battles
    
    drawBg();
    
    Image enemy;  //The image to draw
    
    //Try to import the image from the file
    try{
      
      
      enemy = ImageIO.read(new File("badguy.png"));
    }
    catch(IOException e)  //File not found
    {
      enemy = null;
      
    }
    //Draw the image (Image, x location, y location, null)
    
    drawEnemy(3,enemy);
    
    
    
    statBars(0);
    statBars(3);
    
    c2.setColor(Color.RED);
    
    c2.println("AN ENEMY HAS APPEARED!!!!");
    
    c2.println("WHAT WILL YOU DO.."); 
    
    c2.println("A: Fight him");
    
    c2.println("B: Call him pretty");
    
    c2.println("C: Create distraction and escape situation");
    
    option = c2.readLine();
    
    if(option.equalsIgnoreCase("a"))
    {
      int x = attack(0,3);
      
      while(x==2){
        
        c2.println("attack successful");
        c2.println("press A to ATTACK AGAIN");
        c.clear();      
        drawBg();
        drawEnemy(3,enemy);
        statBars(0);
        statBars(3);
        option = c2.readLine();
        if(option.equalsIgnoreCase("a")){
          x = attack(0,3);
          option = ""; 
        }
      }
      if(x==3){
        player[0].addStrength(1);
        player[0].subCharisma(1);
        changeWeapon(0,3);
        c.clear();      
        drawBg();
        drawEnemy(3,enemy);
        statBars(0);
        statBars(3);
        
        c2.println("");
        if(statChecker()){
          return true;
        }
        else{
          return false;
        }
      }
      else{
        c2.println("u died");
        
        return false;
        
      }
      
      
    }
    
    else if(option.equalsIgnoreCase("b")){
      
      if(useCharisma(0,3)){
        c2.println("the enemy is flattered , he gives you his number");
        if(statChecker()){
          return true;
        }
        else{
          return false;
        }
      }
      else
      {
        c2.print("he wasnt impressed and stabbed you");
        return false;
      }
      
    }
    
    else if(option.equalsIgnoreCase("c")){
      
      if(useIntel(0,3)){
        c2.println("You stick your head inside the ground and the enemy is so dumb that he thinks you have vanished and then goes home to eat dinner giving you the opportunity to pass him");
        if(statChecker()){
          return true;
        }
        else{
          return false;
        }
      }
      else
      {
        c2.println("You stick your head inside the ground thinking that he won't be able to you but then the enemy slices your butt off");
        return false;
      }
      
    }
    
    else{
      
      return false;
    }
    
    
    
  }
  
  //level four
  public static boolean levelFour()                                             
  {
    
    
    String option = "";                                 //variable to store user decision in battles
    
    drawBg();
    
    Image enemy;  //The image to draw
    
    //Try to import the image from the file
    try{
      
      
      enemy = ImageIO.read(new File("badguy.png"));
    }
    catch(IOException e)  //File not found
    {
      enemy = null;
      
    }
    //Draw the image (Image, x location, y location, null)
    
    drawEnemy(4,enemy);
    
    
    
    statBars(0);
    statBars(4);
    
    c2.setColor(Color.RED);
    
    c2.println("AN ENEMY HAS APPEARED!!!!");
    
    c2.println("WHAT WILL YOU DO.."); 
    
    c2.println("A: Battle Him");
    
    c2.println("B: Call him pretty");
    
    c2.println("C: Create distraction and escape situation");
    
    option = c2.readLine();
    
    if(option.equalsIgnoreCase("a"))
    {
      int x = attack(0,4);
      
      while(x==2){
        
        c2.println("attack successful");
        c2.println("press A to ATTACK AGAIN");
        c.clear();      
        drawBg();
        drawEnemy(4,enemy);
        statBars(0);
        statBars(4);
        option = c2.readLine();
        if(option.equalsIgnoreCase("a")){
          x = attack(0,4);
          option = ""; 
        }
      }
      if(x==3){
        player[0].addStrength(1);
        player[0].subCharisma(1);
        changeWeapon(0,4);
        c.clear();      
        drawBg();
        drawEnemy(4,enemy);
        statBars(0);
        statBars(4);
        
        c2.println("");
        if(statChecker()){
          return true;
        }
        else{
          return false;
        }
      }
      else{
        c2.println("u died");
        
        return false;
        
      }
      
      
    }
    
    else if(option.equalsIgnoreCase("b")){
      
      if(useCharisma(0,4)){
        c2.println("the enemy is flattered , he gives you his number");
        if(statChecker()){
          return true;
        }
        else{
          return false;
        }
      }
      else
      {
        c2.print("he wasnt impressed and stabbed you");
        return false;
      }
      
    }
    
    else if(option.equalsIgnoreCase("c")){
      
      if(useIntel(0,4)){
        c2.println("You stick your head inside the ground and the enemy is so dumb that he thinks you have vanished and then goes home to eat dinner giving you the opportunity to pass him");
        if(statChecker()){
          return true;
        }
        else{
          return false;
        }
      }
      else
      {
        c2.println("You point to the sky and yell "+ "WITHCES :0!!!"+" The enemy didn't buy it and just stabbed you");
        return false;
      }
      
    }
    
    else{
      
      return false;
    }
    
    
    
  }
  
  //level six
  public static boolean levelSix()                                             
  {
    
    
    String option = "";                 //variable to store user decision in battles
    
    drawBg();
    
    
    
    Image enemy,dragon;  //The image to draw
    
    //Try to import the image from the file
    try{
      
      
      enemy = ImageIO.read(new File("dragon.png"));
      dragon = ImageIO.read(new File("dragon2.png"));
    }
    catch(IOException e)  //File not found
    {
      enemy = null;
      dragon = null;
      
    }
    //Draw the image (Image, x location, y location, null)
    
    drawEnemy(5,enemy);
    
    if(player[0].getDragon()==1)
    {
      c.drawImage(dragon,20,140,null);
    }
    
    
    
    statBars(0);
    statBars(5);
    
    c2.setColor(Color.RED);
    
    c2.println("As you walk, a mighty and fierce dragon appears in front of you, breathing out fire.");
    
    c2.println("WHAT WILL YOU DO.."); 
    
    c2.println("A: Battle him");
    
    c2.println("B: Flatter him.");
    
    c2.println("C: Create distraction and escape situation");
    
    option = c2.readLine();
    
    if(option.equalsIgnoreCase("a"))
    {
      int x = attack(0,5);
      
      while(x==2){
        
        c2.println("attack successful");
        c2.println("press A to ATTACK AGAIN");
        c.clear();      
        drawBg();
        drawEnemy(5,enemy);
        statBars(0);
        statBars(5);
        option = c2.readLine();
        if(option.equalsIgnoreCase("a")){
          x = attack(0,5);
          option = ""; 
        }
      }
      if(x==3){
        player[0].addStrength(1);
        player[0].subCharisma(1);
        changeWeapon(0,5);
        c.clear();      
        drawBg();
        drawEnemy(5,enemy);
        statBars(0);
        statBars(5);
        
        c2.println("");
        if(statChecker()){
          return true;
        }
        else{
          return false;
        }
      }
      else{
        c2.println("u died");
        
        return false;
        
      }
      
      
    }
    
    else if(option.equalsIgnoreCase("b")){
      
      if(useCharisma(0,5)){
        c2.println("the enemy is flattered , he gives you his number");
        if(statChecker()){
          return true;
        }
        else{
          return false;
        }
      }
      else
      {
        c2.print("he wasnt impressed and burned you to a crisp");
        return false;
      }
      
    }
    
    else if(option.equalsIgnoreCase("c")){
      
      if(useIntel(0,5)){
        c2.println("You stick your head inside the ground and the enemy is so dumb that he thinks you have vanished and then goes home to eat dinner giving you the opportunity to pass him");
        if(statChecker()){
          return true;
        }
        else{
          return false;
        }
      }
      else
      {
        c2.println("You point to the sky and yell "+ "WITHCES :0!!!"+" The enemy didn't buy it and burned");
        return false;
      }
      
    }
    
    else{
      
      return false;
    }
    
    
    
  }
  
  //epilogue
  public static void epilogue()
  {
    c.clear();
    c2.clear();
    Image epilogue;                          //variable for the epilogue image
    
    //Try to import the image from the file
    try{
      
      
      epilogue = ImageIO.read(new File("epilogue.jpg"));
      
    }
    catch(IOException e)  //File not found
    {
      c.clear();
      c2.clear();
      epilogue = null;
      
      
    }
    //Draw the image (Image, x location, y location, null)
    
    c.drawImage(epilogue,10,10,null);
    
    c2.println("You walk up to the castle as the beautiful princess steps out.");
    c2.println("\"Thank you noble Knight\", she says");
    c2.println("You bow as the Princess passes you, and you escort her safely back to the kingdom");
    c2.readString();
  }
  
  
  //prints stat bars
  public static void statBars(int character)      
  {
    if(character>0){
      int h = player[character].getHealth();           //prints enemy health
      
      
      c.setCursor(5,115);  
      c.println("HEALTH");
      c.setColor(Color.RED); 
      for(int x = 1;x<=h;x++)
      {
        
        c.fillRect(1000+(x*25),75,20,20);
      }
      
      int s = player[character].getStrength();        //prints enemy strength
      
      
      c.setCursor(6,115);  
      c.println("STRENGTH");
      c.setColor(Color.RED); 
      for(int x = 1;x<=s;x++)
      {
        
        c.fillRect(1000+(x*25),100,20,20);
      }
      
      int i = player[character].getIntel();           //prints enemy intelligence
      
      
      c.setCursor(7,115);  
      c.println("INTEL");
      c.setColor(Color.RED); 
      for(int x = 1;x<=i;x++)
      {
        
        c.fillRect(1000+(x*25),125,20,20);
      }
      
      int ch = player[character].getCharisma();      //prints enemy charisma
      
      
      c.setCursor(8,115);  
      c.println("CHARISMA");
      c.setColor(Color.RED); 
      for(int x = 1;x<=ch;x++)
      {
        
        c.fillRect(1000+(x*25),150,20,20);
      }
      
      
      int range = player[character].getAttackRange();    //prints enemy range
      
      
      c.setCursor(9,115);  
      c.println("RANGE");
      c.setColor(Color.RED); 
      for(int x = 1;x<=range;x++)
      {
        
        c.fillRect(1000+(x*25),175,20,20);
      }
    }   
    else{
      
      int h = player[character].getHealth();      //prints player health
      
      
      c.setCursor(5,13);  
      c.println("HEALTH");
      c.setColor(Color.RED); 
      for(int x = 1;x<=h;x++)
      {
        
        c.fillRect(150+(x*25),75,20,20);
      }
      
      int s = player[character].getStrength();    //prints player strength
      
      
      c.setCursor(6,13);  
      c.println("STRENGTH");
      c.setColor(Color.RED); 
      for(int x = 1;x<=s;x++)
      {
        
        c.fillRect(150+(x*25),100,20,20);
      }
      
      int i = player[character].getIntel();      //prints player intelligence
       
      
      c.setCursor(7,13);  
      c.println("INTEL");
      c.setColor(Color.RED); 
      for(int x = 1;x<=i;x++)
      {
        
        c.fillRect(150+(x*25),125,20,20);
      }
      
      int ch = player[character].getCharisma();     //prints player charisma
      
      
      c.setCursor(8,13);  
      c.println("CHARISMA");
      c.setColor(Color.RED); 
      for(int x = 1;x<=ch;x++)
      {
        
        c.fillRect(150+(x*25),150,20,20);
      }
      
      int range = player[character].getAttackRange();      //prints player range
      
      
      c.setCursor(9,13);  
      c.println("RANGE");
      c.setColor(Color.RED); 
      for(int x = 1;x<=range;x++)
      {
        
        c.fillRect(150+(x*25),175,20,20);
      }
      
      
    }
    
  }
  
  //prologue
  public static int prologue()
  {
    
    String playAgain = "n";                      //option to play again 
    String optionSavePrincess = "n";            //first option to save the princess
    String optionEnterForest = "n";             //second option, enter forest
    
    //Try to import the image from the file
    
    
    try
    {
      img = ImageIO.read(new File("disclamer.jpg"));
    }
    catch(IOException e)  //File not found
    {
      img = null;
    }
    
    //Draw the image (Image, x location, y location, null)
    c.drawImage(img,10,10,null);
    
    c2.println("Press any key and press return to continue dialogue.");
    c2.println("Try now.");
    
    c2.readString();
    c2.clear();
    
    c2.println("BEWARE: DO NOT PLAY IF YOU HAVE A SHORT TEMPER!!!");
    c2.readString();
    c2.clear();
    
    c2.println("WARNING: If any of the player's stats reach a level of 0, you will die.");
    c2.println("***********************************************************************");
    c2.println("Game automatically restarts following player's death.");
    c2.readString();
    c2.clear();
    c2.println("If you attack, Charisma decreases.");
    c2.println("If you use Intelligence, Strength decreases.");
    c2.println("If you use Charisma, Intelligence decreases.");
    c2.readString();
    c2.clear();
    c.clear();
    //Try to import the image from the file
    
    
    try
    {
      img = ImageIO.read(new File("MAEngland.jpg"));
    }
    catch(IOException e)  //File not found
    {
      img = null;
    }
    
    //Draw the image (Image, x location, y location, null)
    c.drawImage(img,10,10,null);
    
    
    
    c2.println("15th century England.");
    c2.println();
    
    
    c2.readString();
    
    
    c2.clear();
    c2.println("Prepatations are underway for the princess' coronation to become Queen. The entire country has arrived at London to witness the historic event.");
    c2.println("It is almost time for the princess to arrive, when the King is approached by her maid.");
    c2.println("\"The Princess has been kidnapped! The Princess has been kidnapped!\"");
    
    
    c2.readString();
    
    
    
    c.clear();
    c2.clear();
    //Try to import the image from the file
    try
    {
      img = ImageIO.read(new File("distressedking.jpg"));
    }
    catch(IOException e)  //File not found
    {
      img = null;
    }
    
    //Draw the image (Image, x location, y location, null)
    c.drawImage(img,40,40,null);
    
    c2.println("The King looks distressed as you overhear the conversation.");
    c2.println();
    c2.println("You approach him slowly.");
    c2.println();
    c2.println("\"What is your name, Knight?\", the King asks you.");
    c2.println();
    
    
    c2.readString();
    
    
    
    c.clear();
    c2.clear();
    //Try to import the image from the file
    try
    {
      img = ImageIO.read(new File("darkknight.jpg"));
    }
    catch(IOException e)  //File not found
    {
      img = null;
    }
    
    //Draw the image (Image, x location, y location, null)
    c.drawImage(img,30,30,null);
    
    c2.print("Enter your name: ");
    player[0] = new Characters(c2.readLine());
    c2.clear();
    c2.println("Stats");
    c2.println("*****");
    c2.println("Health: "         + player[0].getHealth() + "/10");       
    c2.println("Strength: "       + player[0].getStrength() + "/10");
    c2.println("Intelligence: "   + player[0].getIntel() + "/10");
    c2.println("Charisma: "       + player[0].getCharisma() + "/10");
    c2.println();
    
    c2.readString();
    
    
    
    c2.clear();
    c2.println("Hello Knight " + player[0].getName());
    c2.println("Are you ready to risk your life for the Princess?");
    c2.println();
    c2.print(" A. Yes     B. No [A/B]: ");
    optionSavePrincess = c2.readString();
    
    while(optionSavePrincess.equalsIgnoreCase("Y"))
    {
      c2.println("Invalid selection.");
      c2.println("Are you ready to risk your life for the Princess?");
      c2.println();
      c2.print(" A. Yes     B. No [A/B]: ");
      optionSavePrincess = c2.readString();
    }
    while(optionSavePrincess.equalsIgnoreCase("N"))
    {
      c2.println("Invalid selection.");
      c2.println("Are you ready to risk your life for the Princess?");
      c2.println();
      c2.print(" A. Yes     B. No [A/B]: ");
      optionSavePrincess = c2.readString();
    }
    
    if(optionSavePrincess.equalsIgnoreCase("B"))
    {
      c2.clear();
      c.clear();
      //Try to import the image from the file
      try
      {
        img = ImageIO.read(new File("gameover.jpg"));
      }
      catch(IOException e)  //File not found
      {
        img = null;
      }
      
      //Draw the image (Image, x location, y location, null)
      c.drawImage(img,0,10,null);
      
      c2.println("The King shuns you away, and you leave the square..");
      c2.println("Game over, coward.");
      
      c2.println();
      c2.print("Play again? [Y/N]: ");
      playAgain = c2.readString();
      
      if(playAgain.equalsIgnoreCase("Y"))
      {
        c2.clear();
        return 2;
      }
      return 3;
    }
    
    else if(optionSavePrincess.equalsIgnoreCase("A"))
    {
      c2.clear();
      c2.println("The King embraces you in a hug and demands you be brought your armour");
      c2.println("\"You are a brave Knight! If you bring back my daughter safe and sound, I will make sure you are looked after!\"");
      c2.println();
      
      c2.readString();
      
      player[1] = new Characters();                     //level one villain
      player[2] = new Characters();                     //level 2 villian
      player[3] = new Characters();                     //level 3 villian
      player[4] = new Characters();                     //level 4 villian
      player[5] = new Characters(13055);                //final boss
      
      wep[0] = new weapon(0);                     //sword
      wep[1] = new weapon(1);                     //bow and arrow
      wep[2] = new weapon(2);                     //axe
      
      for(int x = 1;x<=5;x++){
        int y;
        switch(y=player[x].getWeaponEquipped()){
          case 0:
            break;
          case 1:
            player[x].addStrength(wep[0].getDamage());
            player[x].addRange(wep[0].getRange());
            break;
          case 2:
            player[x].addStrength(wep[1].getDamage());
            player[x].addRange(wep[1].getRange());
            break;
          case 3:
            player[x].addStrength(wep[2].getDamage());
            player[x].addRange(wep[2].getRange());
            break;
        }
      }
      
      pot[0] = new Potion(3);       //strength potion
      pot[1] = new Potion(4);       //intelligence potion
      pot[2] = new Potion(5);       //charisma potion
      pot[3] = new Potion(6);       //poison LOL
      pot[4] = new Potion(7);        //DRAGON POTION BROOOOO
      
      
      c2.clear();
      c.clear();
      
      //Try to import the image from the file
      try
      {
        img = ImageIO.read(new File("armor.png"));
      }
      catch(IOException e)  //File not found
      {
        img = null;
      }
      
      //Draw the image (Image, x location, y location, null)
      c.drawImage(img,40,40,null);
      
      c2.println("You don your battle dress, sheath your weapon and call your horse.");
      c2.println("The lookout from the Northern Wall comes running up to you and advises you that the Princess was taken East, towards the forest by 3 masked men.");
      c2.println("You get the King's blessing and venture on towards your quest. You are determined to rescue the Princess and bring her back alive.");
      c2.println();
      
      
      c2.readString();
      
      
      
      c2.clear();
      c.clear();
      //Try to import the image from the file
      try
      {
        img = ImageIO.read(new File("title.jpg"));
      }
      catch(IOException e)  //File not found
      {
        img = null;
      }
      
      //Draw the image (Image, x location, y location, null)
      c.drawImage(img,40,40,null);
      
      
      c2.readString();
      c2.clear();
      c.clear();
      
      //Try to import the image from the file
      try
      {
        img = ImageIO.read(new File("2days.jpg"));
      }
      catch(IOException e)  //File not found
      {
        img = null;
      }
      
      //Draw the image (Image, x location, y location, null)
      c.drawImage(img,10,10,null);
      
      
      c2.readString();
      
      
      c2.clear();
      c.clear();
      //Try to import the image from the file
      try
      {
        img = ImageIO.read(new File("forest.jpg"));
      }
      catch(IOException e)  //File not found
      {
        img = null;
      }
      
      //Draw the image (Image, x location, y location, null)
      c.drawImage(img,10,10,null);
      
      c2.println("You have been travelling for 6 nights and 7 days when you finally arrive at the Ashgate Forests.");
      c2.println("Do you enter, brave Knight?");
      c2.println("A. Yes     B. No  [A/B]: ");
      optionEnterForest = c2.readString();
      
      while(optionEnterForest.equalsIgnoreCase("Y"))
      {
        c2.println("Invalid Selection.");
        c2.println("You have been travelling for 6 nights and 7 days when you finally arrive at the Ashgate Forests.");
        c2.println("Do you enter, brave Knight?");
        c2.println("A. Yes     B. No  [A/B]: ");
        optionEnterForest = c2.readString();
      }
      while(optionEnterForest.equalsIgnoreCase("N"))
      {
        c2.println("Invalid Selection.");
        c2.println("You have been travelling for 6 nights and 7 days when you finally arrive at the Ashgate Forests.");
        c2.println("Do you enter, brave Knight?");
        c2.println("A. Yes     B. No  [A/B]: ");
        optionEnterForest = c2.readString();
      }
      
      
      
      if(optionEnterForest.equalsIgnoreCase("B"))
      {
        c2.clear();
        c.clear();
        //Try to import the image from the file
        try
        {
          img = ImageIO.read(new File("gameover.jpg"));
        }
        catch(IOException e)  //File not found
        {
          img = null;
        }
        
        //Draw the image (Image, x location, y location, null)
        c.drawImage(img,10,10,null);
        
        c2.println("You return to the Palace and inform the King that you were not able to save the Princess. You are sent away and are disgraced.");
        c2.println("Game over, coward.");
        
        c2.println();
        c2.print("Play again? [Y/N]: ");
        playAgain = c2.readString();
        
        if(playAgain.equalsIgnoreCase("Y"))
        {
          c2.clear();
          return 2;
          
        }
        return 3;
      }
      
      else if(optionEnterForest.equalsIgnoreCase("A"))
      {
        return 1;
      }
      
      
      
      
      
      
    }
    
    return 3;
  }
  
  
  //method that allows player to change weapon
  public static void changeWeapon(int playerNumb, int enemy)
  {
    String option;                            //variable for option to change weapon
    
    if(player[enemy].getWeaponEquipped()>0)
    {
      if(player[enemy].getWeaponEquipped()==player[playerNumb].getWeaponEquipped()){
        c2.clear();
        c2.println("You have the same weapon as the enemy");
        c2.println("You have the choice to forge the 2 weapons and wield a more powerful weapon");
        c2.println("You have a "+(player[playerNumb].getIntel())*20+"% chance of a successful");
        c2.println("Would you like to forge weapon? [Y/N]");
        option = c2.readString();
        
        if(option.equalsIgnoreCase("y")){
          
          int chance = (int)(Math.random()*5+1);
          
          if(chance<=player[playerNumb].getIntel())
          {
            c2.println("FORGE SUCCESSFULL");
            player[playerNumb].addStrength(2);
            player[playerNumb].addRange(2);
            
          }
          else{
            c2.println("FORGE UNSUCCESSFUL YOU HAVE LOST BOTH WEAPONS ;(");
            player[playerNumb].subStrength(wep[player[playerNumb].getWeaponEquipped()-1].getDamage());
            player[playerNumb].subRange(wep[player[playerNumb].getWeaponEquipped()-1].getRange());
            
            
          }
          
        }
      }
      else{
        c2.clear();
        c2.println("Would you like to change your weapon from "+wep[player[playerNumb].getWeaponEquipped()-1].getName()+" to "+wep[player[enemy].getWeaponEquipped()-1].getName()+"[Y/N]");
        
        option = c2.readString();
        if(option.equalsIgnoreCase("y")){
          
          player[playerNumb].subStrength(wep[player[playerNumb].getWeaponEquipped()-1].getDamage());
          player[playerNumb].subRange(wep[player[playerNumb].getWeaponEquipped()-1].getRange());
          player[playerNumb].updateWeaponEquipped(player[enemy].getWeaponEquipped());
          player[playerNumb].addStrength(wep[player[playerNumb].getWeaponEquipped()-1].getDamage());
          player[playerNumb].addRange(wep[player[playerNumb].getWeaponEquipped()-1].getRange());
        }
        
      }
      
      
      
    }
  }
  
  //level 5
  public static void levelFive()   
  {
    String killWitch;          //prompt to kill witch
    
    
    
    c2.clear();
    c.clear();
    
    //Try to import the image from the file
    try
    {
      img = ImageIO.read(new File("witchmeet.jpg"));
    }
    catch(IOException e)  //File not found
    {
      img = null;
    }
    
    //Draw the image (Image, x location, y location, null)
    c.drawImage(img,10,10,null);
    
    
    
    
    
    c2.println("You wait a few moments before getting onto your horse and continuing along the forest path.");
    c2.println("A few moments later, you encounter a beautiful young woman standing in your path.");
    c2.println("\"I am a witch. I offer you a mystery chest, but cannot tell you what it contains. It could lead to immense riches, or to your own demise.");
    c2.println();
    
    c2.readString();
    
    
    
    
    
    c.clear();
    c2.clear();
    //Try to import the image from the file
    try
    {
      img = ImageIO.read(new File("mysterybox.jpg"));
    }
    catch(IOException e)  //File not found
    {
      img = null;
    }
    
    //Draw the image (Image, x location, y location, null)
    c.drawImage(img,10,10,null);
    
    c2.println("Do you take the mystery box?");
    c2.println("A. Take the box    B. \"I will pass this offer\"   C. Kill the Witch  [A/B/C]");
    String optionAcceptBox = c2.readString();
    
    if(optionAcceptBox.equalsIgnoreCase("B"))
    {
      c2.clear();
      c.clear();
      
      //Try to import the image from the file
      try
      {
        img = ImageIO.read(new File("afterbox.jpg"));
      }
      catch(IOException e)  //File not found
      {
        img = null;
      }
      
      //Draw the image (Image, x location, y location, null)
      c.drawImage(img,10,10,null);
      
      c2.println("\"I am fine for now, I do not need your box\"");
      
      
      c2.println("You ride away from the witch and continue your journey");
      c2.println("As you ride along, you realize that you should have accepted the box. You head back to where you met the witch, however she is no longer there.");
      c2.println("\"Damn it..\", you say to yourself as you continue on along the path.");
    }
    else if(optionAcceptBox.equalsIgnoreCase("C"))
    {
      c2.clear();
      c.clear();
      
      //Try to import the image from the file
      try
      {
        img = ImageIO.read(new File("killwitch.jpg"));
      }
      catch(IOException e)  //File not found
      {
        img = null;
      }
      
      //Draw the image (Image, x location, y location, null)
      c.drawImage(img,10,10,null);
      c2.println("You contemplate the situation before you for a few minutes before reaching for your dagger.");
      c2.println("**Press Q to kill the witch**");
      killWitch = c2.readString();
      if(killWitch.equalsIgnoreCase("Q"))
      {
        if(player[0].getIntel() <= 2)
        {
          c2.clear();
          c2.println("You cut the witch's head off and she falls to the ground.");
          c2.println("You reach down for the box, but it disappears into dust with her body.");
          c2.println("\"I am such an idiot. I should not have killed her. Now I have also lost the box..\"");
          c2.println("You shake your head and scold yourself as you continue on down the path.");
        }
        if(player[0].getIntel() > 2)
        {
          c2.clear();
          c2.println("You distract the witch by unsheathing your blade, grab the box from her hands and begin riding off.");
          c2.println("She screams in a fit of rage and begins chasing after you.");
          c2.println("She attempts to uproot a tree to block your path, however you cross beneath at the last second and outrun the witch.");
          c2.println("\"I will hunt you down!!\", screams the witch behind you.");
          c2.println("You chuckle at your intelligence and place the box in your satchel as you ride off down the path.");
          
          mysteryBox();
        }
      }
    }
    else if(optionAcceptBox.equalsIgnoreCase("A"))
    {
      c2.clear();
      c.clear();
      
      //Try to import the image from the file
      try
      {
        img = ImageIO.read(new File("afterbox.jpg"));
      }
      catch(IOException e)  //File not found
      {
        img = null;
      }
      
      //Draw the image (Image, x location, y location, null)
      c.drawImage(img,10,10,null);
      
      c2.println("You reach out for the box and take it from her");
      c2.println("The witch cackles out loud and disappears, whispering in your ear, \"Good luck Knight. You'll need it..\"");
      c2.println("You shake off the feeling and slowly set out on your journey again.");
      
      mysteryBox();
    }
    
    c2.println();
    
    
    c2.readString();
    
    
    c2.clear();
    
    
    
  }
  
  //checks players stats
  public static boolean statChecker()
  {
    int a = player[0].getStrength();    //gets strength
    int b = player[0].getIntel();       //gets intelligence
    int c = player[0].getCharisma();    //gets charisma
    int d = player[0].getHealth();      //gets health
    
    if(a==0)
    {
      c2.println("You became to weak that when a leaf fell on your head, your head cracked");
      return false;
    }
    else if(b==0)
    {
      c2.println("you became so dumb that you forgot how to breathe");
      return false;
      
      
    }
    
    else if(c==0)
    {
      c2.println("You became so savage and disliked that a bunch of deers ran at you and kicked you to death");
      return false;
    }
    
    else if(d<=0)
    {
      c2.println("Your health became very bad and you died");
      return false;
    }
    else{
      return true;
    }
  }
  
  
  public static void mysteryBox()
    
  {
    int x = (int)(Math.random()*6+1);
    
    switch(x){
      case 1:
        changeWeapon(0,((int)(Math.random()*5+1)));
        break;
        
      case 2:
        player[0].addStrength(pot[0].getStrength());
        c2.println("YOU DRANK A STRENGTH POTION");
        break;
        
      case 3:
        player[0].addIntel(pot[1].getIntel());
        c2.println("YOU DRANK INTEL POTION");
        break;
      case 4:
        
        player[0].addCharisma(pot[2].getCharisma());
        c2.println("YOU DRANK THE CHARISMA POTION");
        break;
        
      case 5:
        player[0].subHealth(pot[3].getPoison());
        c2.println("you drank poison");
        break;
        
      case 6:
        player[0].updateDragon();
        c2.println("you drank the dragon potion");
      int y = (int)(Math.random()*3+1);
      
      switch(y){
        case 1:
          player[0].addStrength(9);
          break;
        case 2:
          player[0].addIntel(9);
          break;
        case 3:
          player[0].addCharisma(9);
          break;
      
      }
        
        break;
        
    }
    
    
    
    
    
    
    
    
  }
}//class
