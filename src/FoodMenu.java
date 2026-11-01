package src;

public class FoodMenu {
    private Food[] foods = new Food[50];
    private int count = 0;

    public FoodMenu(){
        addFood("Fish Ball", 1.00);
    }
    
    //Add Food
    public void addFood(String name,double price){

        if(count < foods.length){
            foods[count] = new Food(name,price);

            count++;
            System.out.println("Food added successfully!");
        }else{
             System.out.println("Food menu is full.");
        }
    }

    //Display Food
    public void viewFood(){
        System.out.println("\n =============== FOOD MENU =============== ");

        if (count == 0){
                System.out.println("No food available.");
        }
        else{
            for(int i = 0; i < count; i++){
                    System.out.println("Food number" +(i+1));//
                    foods[i].displayFood();
            }
        }
    }

    //Update Food
    public void updateFood(int number, String newName, double newPrice){
        int index = number - 1;

        if(index >= 0 && index < count){
            foods[index].setName(newName);
            foods[index].setPrice(newPrice);

             System.out.println("Food updated successfully!");
        }else{
            System.out.println("Invalid food number.");
        }
    }

    //Delete Food
    public void deleteFood(int number){
        int index = number - 1;

        if(index >= 0 && index < count){
            for(int i = index; i < count - 1; i++){
                foods[i] = foods[i + 1];
            }
            foods[count - 1] = null;
            count --;

            System.out.println("Food deleted successfully!");
        }else{
            System.out.println("Invalid food number.");
        }
    }

    //Get selected food
    public Food getFood(int number){
        int index = number - 1;

        if(index >= 0 && index < count){
            return foods[index];
        }

        return null;
    }

    public int getCount(){
        return count;
    }
}
