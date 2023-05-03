package teletubies;

public class Food {
    private int foodID;
    private String foodName;
    private double foodPrice;
    
    public Food(){
        
    }
    
    public Food(int foodID,String foodName,double foodPrice){
        this.foodID = foodID;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }
    
    public int getfoodID(){
        return foodID;
    }
    
    public void setfoodID(int foodID){
        this.foodID = foodID;
    }
    
    public String getfoodName(){
        return foodName;
    }
    
    public void setfoodName(String foodName){
        this.foodName = foodName;
    }
    
    public double getfoodPrice(){
        return foodPrice;
    }
    
    public void setfoodPrice(int foodPrice){
        this.foodPrice = foodPrice;
    }
}
