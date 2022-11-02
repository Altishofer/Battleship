package fleet;

public enum ShipType {
    BATTLESHIP(4,2),
    CARRIER(6,1),
    PATROLBOAT(2,4),
    SUBMARINE(3,3),
    NULL(0,0);

    final int size;
    public final int quantity;

    ShipType(int size, int quantity){
        this.quantity = quantity;
        this.size = size;
    }

    @Override
    public String toString(){
        String name = this.name();
        return name.substring(0,1)+name.substring(1).toLowerCase();
    }
}
