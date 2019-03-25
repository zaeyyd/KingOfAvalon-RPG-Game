public class Potion{                                   //ZAYYED
  
  
  private int potionID;     //type of potion
  private int strength;     //potion strength
  private int charisma;     //potion charisma
  private int intel;        //potion intelligence
  private int dragon;       //potion dragon
  private int poison;       //potion poison
  private String name;      //name of potion
  
  
  //constructor for potions
  public Potion(int postionIden){
    
    int x;
    
    switch(x=postionIden){
      case 3:
        this.name = "Strength potion";
        this.strength = 10;
        break;
      case 4:
        this.name = "Intel potion";
        this.intel = 10;
        break;
      case 5:
        this.name = "Charisma potion";
        this.charisma = 10;
        break;
      case 6:
        this.name = "Poison LOL";
        this.poison = 0;
        break;
      case 7:
        this.name = "Dragon potion";
        this.dragon = 100;
        
        break;
    }
    
    
  }
  
  //strength increase
  public int getStrength()
  {
    return this.strength;
  }
  
  //intelligence increase
  public int getIntel()
  {
    return this.intel;
  }
  
  //charisma increase
  public int getCharisma()
  {
    return this.charisma;
  }
  
  //poison potion
  public int getPoison()
  {
    return this.poison;
  }
  
  //dragon potion
  public int getDragon()
  {
    return this.dragon;
  }
  
}