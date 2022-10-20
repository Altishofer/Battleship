package player;

public class User implements Player{
    public void setFleet()
    {
        System.out.println("DEFINE FLEET by following rules");
        System.out.println("- type the coordinates seperated by commas");
        System.out.println("- all coordinates need form a line (vertical or horizontal)");
        System.out.println("- type as many coordinates as asked by the system\n");
    }
}
