package final1;

import java.util.Iterator;
import java.util.Random;

public class InNOut {

    @SuppressWarnings({ })
	public static <I> void main(String[] args) {
    	
        /*
         * creates the stacks for each ingredient
         */
        linkedStack<I> bun = new linkedStack<I>();
        linkedStack<I> patty = new linkedStack<I>();
        linkedStack<I> lettuce = new linkedStack<I>();
        linkedStack<I> tomato = new linkedStack<I>();
        linkedStack<I> onion = new linkedStack<I>();
        linkedStack<I> cheese = new linkedStack<I>();
        /*
         * creates the queue for the customeromers to come in to order
         */
        linkedQueue<I> line = new linkedQueue<I>();
        /*
         * 
         */
        linkedDictonary<I, I> ld = new linkedDictonary<I, I>();
        
        /*
         * lists for the burger menu items and the ingredients that are poped from the stacks 
         * in order to fulfill them
         */
        list<linkedStack<I>> Burger = new list<linkedStack<I>>();
        Burger.add(bun);
        Burger.add(patty);
        Burger.add(lettuce);
        Burger.add(tomato);
        Burger.add(onion);
        
        list<linkedStack<I>> cheeseBurger = new list<linkedStack<I>>();
        cheeseBurger.add(bun);
        cheeseBurger.add(patty);
        cheeseBurger.add(lettuce);
        cheeseBurger.add(tomato);
        cheeseBurger.add(onion);
        cheeseBurger.add(cheese);
        
        list<linkedStack<I>> veganBurger = new list<linkedStack<I>>();
        veganBurger.add(lettuce);
        veganBurger.add(tomato);
        veganBurger.add(onion);
        veganBurger.add(lettuce);
        
        list<linkedStack<I>> BurgerNoOnion  = new list<linkedStack<I>>();
        BurgerNoOnion .add(bun);
        BurgerNoOnion .add(patty);
        BurgerNoOnion .add(lettuce);
        BurgerNoOnion .add(tomato);
        
        list<linkedStack<I>> CheeseBurgerNoOnion = new list<linkedStack<I>>();
        CheeseBurgerNoOnion.add(cheese);
        CheeseBurgerNoOnion.add(bun);
        CheeseBurgerNoOnion.add(patty);
        CheeseBurgerNoOnion.add(lettuce);
        CheeseBurgerNoOnion.add(tomato);
        
        list<linkedStack<I>> BurgerNoTomato = new list<linkedStack<I>>();
        BurgerNoTomato.add(bun);
        BurgerNoTomato.add(patty);
        BurgerNoTomato.add(lettuce);
        BurgerNoTomato.add(onion);
        
        int nxtShipmentSupply;//int for the amount of ingredients in th enew shipment
        int nxtShipment;// the amount of time until the next shimpnet arrives
        int dNum = 1;//dictinary number when a customer succefully orders an item

        Random rand = new Random();//random number generator
        nxtShipment = 0;//nexe shimpent arrives immediatly
        
        for(int i = 1201; i <= 1231; i++)//keep track of days
        {
        	/*
        	 * keeps track of customers loast items bought and igredients wasted
        	 */
            int countItemOne = 0;
            int countItemTwo = 0;
            int countItemThree = 0;
            int countItemFour = 0;
            int countItemFive = 0;
            int countItemSix = 0;
            int wasteCheese = 0;
            int wasteBun = 0;
            int wastePatty = 0; 
            int wasteLettuce = 0; 
            int wasteTomato = 0;
            int wasteOnion = 0;
            int lostCustomerDay = 0;
            if(nxtShipment == 0)
            {
              nxtShipment = rand.nextInt(4)+3; // generates teh amount of days until next shipment
              nxtShipmentSupply =  rand.nextInt(301)+700;// generates amount of items in teh next shipment
              addIng(nxtShipmentSupply, i, bun, patty, lettuce, tomato, onion, cheese);
            }
            else
                nxtShipment--;
            for(int j = 1; j <= 10; j++){
                int customer = rand.nextInt(100)+1; //generates teh amount of customers per hour
                if(customer > 50)//queue has  alimit of 50 customers
                {
                    lostCustomerDay = lostCustomerDay + (customer - 50);//if the customer count is higher than 50 the extra customers are lost
                    //and added into lost customers
                    customer = 50;
                }
                for(int k = 1; k <= customer; k++)
                {
                    int order = rand.nextInt(6)+1;//generates what the customer is going to order from the list menu
                    line.enqueue(order);
                }
                
                for(int m = 1; m <= customer; m++)
                {
                    switch((I)line.dequeue())
                    {
                    
                    /*
                     * has the six cases for each item on the menu list and uses them dependign on what the ustomer orderd
                     */
                    case 1:
                        if(bun.isEmpty() || patty.isEmpty() || lettuce.isEmpty() || tomato.isEmpty() || onion.isEmpty())
                                lostCustomerDay++;
                            else{
                                ld.add(dNum++, 1);
                                bun.pop();
                                patty.pop();
                                lettuce.pop();
                                tomato.pop();
                                onion.pop();
                                countItemOne++;
                            }
                            break;
                        case 2:
                            if(bun.isEmpty() || patty.isEmpty() || lettuce.isEmpty() || tomato.isEmpty() || onion.isEmpty() || cheese.isEmpty())
                                lostCustomerDay++;
                            else{
                                ld.add(dNum++, 2);
                                bun.pop();
                                patty.pop();
                                lettuce.pop();
                                tomato.pop();
                                onion.pop();
                                cheese.pop();
                                countItemTwo++;
                            }
                            break;
                        case 3:
                            if(lettuce.isEmpty() || tomato.isEmpty() || onion.isEmpty() || lettuce.size() < 2)
                                lostCustomerDay++;
                            else{
                                ld.add(dNum++, 3);
                                lettuce.pop();
                                lettuce.pop();
                                tomato.pop();
                                onion.pop();
                                countItemThree++;
                            }
                            break;
                        case 4:
                            if(bun.isEmpty() || patty.isEmpty() || lettuce.isEmpty() || tomato.isEmpty())
                                lostCustomerDay++;
                            else{
                                ld.add(dNum++, 4);
                                bun.pop();
                                patty.pop();
                                lettuce.pop();
                                tomato.pop();
                                countItemFour++;
                            }
                            break;
                        case 5:
                            if(bun.isEmpty() || patty.isEmpty() || lettuce.isEmpty() || tomato.isEmpty() || cheese.isEmpty())
                                lostCustomerDay++;
                            else{
                                ld.add(dNum++, 5);
                                bun.pop();
                                patty.pop();
                                lettuce.pop();
                                tomato.pop();
                                cheese.pop();
                                countItemFive++;
                            }
                            break;
                        case 6:
                            if(bun.isEmpty() || patty.isEmpty() || lettuce.isEmpty() || onion.isEmpty())
                                lostCustomerDay++;
                            else{
                                ld.add(dNum++, 6);
                                bun.pop();
                                patty.pop();
                                lettuce.pop();
                                onion.pop();
                                countItemSix++;
                            }
                            break;
                        }
                    }
                }
            line.clear();
            
            /*
             * assigns the experation dat efor the items until they go bad but they usaully run out before that
             */
            sort(bun);
            if(!bun.isEmpty()){
                while((I) bun.peek() == (i-5))
                {
                    bun.pop();
                    wasteBun++;
                    if(bun.isEmpty())
                        break;
                }
            }
            sort(patty);
            if(!patty.isEmpty()){
                while((I) patty.peek() == (i-4))
                {
                    patty.pop();
                    wastePatty++;
                    if(patty.isEmpty())
                        break;
                }
            }
            sort(lettuce);
            if(!lettuce.isEmpty()){
                while((I) lettuce.peek() == (i-3))
                {
                    lettuce.pop();
                    wasteLettuce++;
                    if(lettuce.isEmpty())
                        break;
                }
            }
            sort(tomato);
            if(!tomato.isEmpty()){
                while((I) tomato.peek() == (i-3))
                {
                    tomato.pop();
                    wasteTomato++;
                    if(tomato.isEmpty())
                        break;
                }
            }
            sort(onion);
            if(!onion.isEmpty()){
                while((I) onion.peek() == (i-5))
                {
                    onion.pop();
                    wasteOnion++;
                    if(onion.isEmpty())
                        break;
                }
            }
            sort(cheese);
            if(!cheese.isEmpty())
            {                
                while((I) cheese.peek() == (i-2))
                {
                    cheese.pop();
                    wasteCheese++;
                    if(cheese.isEmpty())
                        break;
                }
            }
            //literally all the prints statments
            System.out.println("12" + "/" + (i-1200) + "/" + "2017" + ":");
            System.out.println("customeromers Lost today: " + lostCustomerDay);
            System.out.println("Wasted Cheese: " + wasteCheese);
            System.out.println("Wasted Buns: " + wasteBun);
            System.out.println("Wasted Patties: " + wastePatty);
            System.out.println("Wasted Lettuce: " + wasteLettuce);
            System.out.println("Wasted Tomatos: " + wasteTomato);
            System.out.println("Wasted Onions: " + wasteOnion);
            System.out.println("Burgers sold: " + countItemOne);
            System.out.println("Cheeseburgers sold: " + countItemTwo);
            System.out.println("Vegan Lettuce Wrap Burgers sold: " + countItemThree);
            System.out.println("Burgers (no Onion) sold: " + countItemFour);
            System.out.println("Cheeseurgers (no Onion) sold: " + countItemFive);
            System.out.println("Burgers (no Tomato) sold: " + countItemSix);
            
            Iterator<I> kI = ld.getKeyIterator();//
            Iterator<I> vI = ld.getValueIterator();//
            
            while(kI.hasNext())
            {
            	//except this one this ones all alone
                System.out.println("customer " + kI.next() + 
                        " ordered a #" + vI.next());
            }
            System.out.println();
            ld.clear();
            dNum = 1;
        }
    }
    
    public static void addIng(int amount, int date, linkedStack<I> bun, linkedStack<I> patty, linkedStack<I> lettuce, 
            linkedStack<I> tomato, linkedStack<I> onion, linkedStack<I> cheese)
    {
        for(int i = 1; i <= amount; i++)
        {
        	/*
        	 * randomaly assigns each ingrediant with new inventory with thin the boundry of the amount of items in the new shipment
        	 */
            Random rand = new Random();
            System.out.println("hold up bro");
            int item = rand.nextInt(6)+1;
            switch(item){
                case 1: bun.push(date);
                case 2: patty.push(date);
                case 3: lettuce.push(date);
                case 4: tomato.push(date);
                case 5: onion.push(date);
                case 6: cheese.push(date);
            }
                
        }
    }   
    public static void sort(linkedStack<I> stack)
    {
    	//"sorts" the stacks of the inventory by poping them into a temp stack then onto a new stack 
        linkedStack<I> tempstack = new linkedStack<I>();
            while(stack.isEmpty()== false){
            int temp = (I) stack.pop();
            while(!tempstack.isEmpty() && (I) tempstack.peek() < temp) {
              stack.push(tempstack.pop());
            }
            tempstack.push(temp);
            }
            stack = tempstack;
    }  
}
