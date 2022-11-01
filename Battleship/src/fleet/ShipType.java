package fleet;

public enum ShipType {
    BATTLESHIP(4),
    CARRIER(6),
    PATROLBOAT(2),
    SUBMARINE(3),
    NULL(0);

    final int size;

    ShipType(int size){
        this.size = size;
    }

    @Override
    public String toString(){
        String name = this.name();
        return name.substring(0,1)+name.substring(1).toLowerCase();
    }
}
