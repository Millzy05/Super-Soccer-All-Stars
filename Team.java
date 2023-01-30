/**
 * @author KCBANANA
 */

public class Team {
	
  private String name; 
  private int[] colour;
  

  public Team() { // this is a constructor
    this.name= ""; // "this" refers to an object in the class, which allows us to access the fields
    this.colour = new int[] {};
    
  }
  public Team(String n, int[] c){
    this.name = n;
    this.colour = c;
    
  }
  
  public String getName() {
    return this.name;
  }

  

  public void setName(String n) {
    this.name = n;
  }
  
  
  public int[] getColour() {
    return this.colour;
  }

  

  public void setColour(int[] c) {
    this.colour = c;
  }
  
}