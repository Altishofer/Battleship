import player.Computer;
import player.User;

import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        User user = new User();
        Computer computer = new Computer();

        Random rand = new Random();
        boolean user_turn = rand.nextInt(2) == 0; // rand.nextInt(2) randomly returns 0 or 1
        boolean game_over = false;
        user.setFleet();
        computer.setFleet();
        System.out.println("hello world");
/*        while(!game_over){
            if(user_turn){

            }
            */

    }
}