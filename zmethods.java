public static boolean useIntel(int playerNumb, int opponentNumb)
  {
  
    int playerIntel = player[playerNumb].getIntel();
    int enemyIntel = player[opponentNumb].getIntel();
    
    if(playerIntel>enemyIntel){
      c2.println("SUCCESS");
      return true;
    
    }
    else if(playerIntel==enemyIntel){
      if((int)(Math.random()*2+0)==1){
      c2.println("success");
      return true;
      }
      else{
      c2.println("FAILLLLL");
      return false;
      }
    }
    else{
    c2.println("fail bitchhhh");
    return false;
    }
    
    
  
  }
  
  public static boolean useCharisma(int playerNumb, int opponentNumb)
  {
  
    int playerCharisma = player[playerNumb].getCharisma();
    int enemyCharisma = player[opponentNumb].getCharisma();
    
    if(playerCharisma>enemyCharisma){
      c2.println("SUCCESS");
      return true;
    
    }
    else if(playerCharisma==enemyCharisma){
      if((int)(Math.random()*2+0)==1){
      c2.println("success");
      return true;
      }
      else{
      c2.println("FAILLLLL");
      return false;
      }
    }
    else{
    c2.println("fail bitchhhh");
    return false;
    }
    
    
  
  }
  
  
  public static int attack(int playerNumb,int opponentNumb)            //ATTACK METHOD
  {
  int range = player[playerNumb].getRange();
  int position = player[opponentNumb].getPosition();
  
  int strength1 = player[playerNumb].getStrength();
  int strength2 = player[opponentNumb].getStrength();
  
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
  
  public static void drawBg() // DRAWS BG AND 
  {
    Image img,player;  //The image to draw
    
    //Try to import the image from the file
    try{
      
     img = ImageIO.read(new File("bg.jpg"));
     player = ImageIO.read(new File("knight.png"));
     
    }
    catch(IOException e)  //File not found
    {
      img = null;
      player = null;  
    }
    
    //Draw the image (Image, x location, y location, null)
    c.drawImage(img,10,10,null);
    c.drawImage(player,20,140,null);
    
  } 
  public static boolean levelOne()                                             //LEVEL one
{
    
 
    String option = "";
    
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
    
    c.drawImage(enemy,1000,400,null);
    
    
    
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
      c.drawImage(enemy,1000,400,null);
        statBars(0);
        statBars(1);
        option = c2.readLine();
      if(option.equalsIgnoreCase("a")){
        x = attack(0,1);
       option = ""; 
      }
      }
      if(x==3){
        c.clear();      
        drawBg();
        c.drawImage(enemy,1000,400,null);
        statBars(0);
        statBars(1);
        
        c2.println("battle won");
        return true;
      }
      else{
      c2.println("u died");
      
      return false;
      
      }
      
      
    }
    
    else if(option.equalsIgnoreCase("b")){
      
      if(useCharisma(0,1)){
      c2.println("the enemy is flattered , he gives you his number and slaps ur butt");
      return true;
      }
      else
      {
        c2.print("he wasnt impressed and turned out to be an ISIS member and blew himself up and you died :D");
        return false;
      }
    
    }
    
    else if(option.equalsIgnoreCase("c")){
      
      if(useIntel(0,1)){
      c2.println("You stick your head inside the ground and the enemy is so dumb that he thinks you have vanished and then goes home to eat dinner giving you the opportunity to pass him");
      return true;
      }
      else
      {
        c2.println("You stick your head inside the ground thinking that he won't be able to you but then the enemy slices your dumbass off");
        return false;
      }
    
    }
    
    else{
      
      return false;
    }
    
    
    
}
  
  
  
 public static void statBars(int character)      //STAT BARRSSS
 {
   if(character == 1){
  int h = player[character].getHealth();
  

  c.setCursor(10,115);  
 c.println("HEALTH");
c.setColor(Color.RED); 
 for(int x = 1;x<=h;x++)
{

 c.fillRect(1000+(x*25),170,20,20);
}

 int s = player[character].getStrength();
  

  c.setCursor(11,115);  
 c.println("STRENGTH");
c.setColor(Color.RED); 
 for(int x = 1;x<=s;x++)
{

 c.fillRect(1000+(x*25),195,20,20);
}

 int i = player[character].getIntel();
  

  c.setCursor(12,115);  
 c.println("INTEL");
c.setColor(Color.RED); 
 for(int x = 1;x<=i;x++)
{

 c.fillRect(1000+(x*25),220,20,20);
}

 int ch = player[character].getIntel();
  

  c.setCursor(13,115);  
  c.println("CHARISMA");
  c.setColor(Color.RED); 
 for(int x = 1;x<=ch;x++)
{

 c.fillRect(1000+(x*25),245,20,20);
}
   }
   else{
     
     int h = player[character].getHealth();
  

  c.setCursor(5,13);  
 c.println("HEALTH");
c.setColor(Color.RED); 
 for(int x = 1;x<=h;x++)
{

 c.fillRect(150+(x*25),75,20,20);
}

 int s = player[character].getStrength();
  

  c.setCursor(6,13);  
 c.println("STRENGTH");
c.setColor(Color.RED); 
 for(int x = 1;x<=s;x++)
{

 c.fillRect(150+(x*25),100,20,20);
}

 int i = player[character].getIntel();
  

  c.setCursor(7,13);  
 c.println("INTEL");
c.setColor(Color.RED); 
 for(int x = 1;x<=i;x++)
{

 c.fillRect(150+(x*25),125,20,20);
}

 int ch = player[character].getIntel();
  

  c.setCursor(8,13);  
  c.println("CHARISMA");
  c.setColor(Color.RED); 
 for(int x = 1;x<=ch;x++)
{

 c.fillRect(150+(x*25),150,20,20);
}
   
   }
 
 }
  