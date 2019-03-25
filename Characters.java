

public class Characters
{
  private  String name;       //The name of the player
  private  int strength;      //The strength of the character
  private  int health;        //The health of the character
  private  int intel;         //The intelligence of the character
  private int charisma;       //The charisma of the character
  private int position;       //Position character stands from left side of screen
  private int attackrange;    //The range you can attack an enemy
  private int weaponEquipped; //Represents the weapon you have equipped
  private int dragon;
  
  
  
  public Characters(String playersName)      //Constructor for user's Character
  {
    this.name = playersName;
    this.strength =(int)(Math.random()*5+4);
    this.health = 10;
    this.intel = (int)(Math.random()*5+4);
    this.charisma = (int)(Math.random()*5+4);
    this.position = 0;
    this.attackrange = 1;
    this.weaponEquipped = 0;
    this.dragon = 100;
  }
  
  public Characters()                      //Constructor for enemy characters
  {
    this.name ="";
    this.strength =(int)(Math.random()*4+2);
    this.health = 10;
    this.intel = (int)(Math.random()*4+6);
    this.charisma = (int)(Math.random()*4+6);
    this.position = (int)(Math.random()*5+1);
    this.weaponEquipped = (int)(Math.random()*4);
    this.attackrange = 2;
    
  }
  public Characters(int boss)                 //Constructor for BOSS CHARACTER    zayyed
  {
    this.name ="DRAGON";
    this.strength =(int)(Math.random()*4+9);
    this.health = 10;
    this.intel = (int)(Math.random()*4+9);
    this.charisma = (int)(Math.random()*4+9);
    this.position = 0;
    this.weaponEquipped = (int)(Math.random()*4);
    this.attackrange = 2;
  }
  
  //method if player becomes dragon
  public void updateDragon(){
    this.dragon = 1;
  }
  
  //returns if player is dragon
  public int getDragon(){
    
    return this.dragon;
  }
  
  public int getWeaponEquipped()//Returns number that represents what weapon the player has
  {
    return this.weaponEquipped;
  }
  
  
  
  public void updateWeaponEquipped(int wep)//updates the number that represents what weapon the player has
  {
    this.weaponEquipped = wep;  
  } 
  
  
  
  public int getAttackRange()//Returns player attack range
  {
    return this.attackrange;
  }
  
  
  
  public void changeName(String playerName)//Changes player name
  {
    this.name = playerName;
  }
  
  
  //returns name
  public String getName()//
  {
    return(name);
  }
  
  
  //returns strength
  public int getStrength()
  {
    return(strength);
  }
  
  
  //retirns health
  public int getHealth()
  {
    return(health);
  }
  
  
  //returns intelligence
  public int getIntel()
  {
    return(intel);
  }
  
  
  //returns charisma
  public int getCharisma()
  {
    return(charisma);
  }
  
  
  //returns potion retrieved from mystery box
  public int getPosition()
  {
    return position;
  }
  
  
  //returns range
  public int getRange()
  {
    return this.attackrange;
  }
  
  
  //adds strength 
  public void addStrength(int addition)
  {
    this.strength = this.strength+addition;
    
    while(this.strength>10)
    {
      this.strength = this.strength-1;
    }
  }
  
  
  //depletes strength
  public void subStrength(int subtraction)
  {
    this.strength = this.strength-subtraction;
  }
  
  
  //adds intelligence
  public void addIntel(int addition)
  {
    this.intel = this.intel+addition;
    
    while(this.strength>10)
    {
      this.intel = this.intel-1;
    }
  }
  
  
  //depletes intelligence
  public void subIntel(int subtraction)
  {
    this.intel = this.intel-subtraction;
  }
  
  
  //adds charisma
  public void addCharisma(int addition)
  {
    this.charisma = this.charisma+addition;
    
    while(this.charisma>10)
    {
      this.charisma = this.charisma-1;
    }
  }
  
  
  //depletes charisma
  public void subCharisma(int subtraction)
  {
    this.charisma = this.charisma-subtraction;
  }
  
  
  //depletes health
  public void subHealth(int subtraction){
    this.health = this.health-subtraction;
  }
  
  
  //adds range
  public void addRange(int addition)
  {
    this.attackrange = this.attackrange+addition;
    while(this.attackrange>10){
      
      this.attackrange = this.attackrange-1;
    }
  }
  
  
  //depletes range
  public void subRange(int subtraction)
  {
    this.attackrange = this.attackrange-subtraction;
    
  }
  
  
  
}