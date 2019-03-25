
public class weapon                                             //ZAYYED
{
  private int damage;     //damage level of weapon
  private int range;      //range of weapon
  private String name;   //name of weapon
  private int weaponID;    //weapon's identification(0-3)
   
  //constructor to create weapons
  public weapon(int weaponIden)
  {
    
    if(weaponIden == 0)
    {
      
      this.name = "Sword";
      this.damage = 3;
      this.range = 2; 
      
      
    }
    else if(weaponIden == 1)
    {
      
      this.name = "Bow And Arrow";
      this.damage = 2;
      this.range = 3; 
      
      
    }
    
    else if(weaponIden == 2)
    {
      
      
      this.name = "AXE";
      this.damage = 5;
      this.range = 0;
    }
  }
  
  //damage increase
  public int getDamage()
  {
    return(damage);
  }
  
  //range increase
  public int getRange()
  {
    return(range);
  }
   
  //name of weapon
  public String getName()
  {
    return(name);
  }
}

