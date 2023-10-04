import java.util.Scanner;

public abstract class Location {
    private int locationID;
    private Player player;
    private String name;

    public static Scanner scanner = new Scanner(System.in);

    public Location(int locationID , Player player , String name){
        this.locationID = locationID;
        this.player = player;
        this.name = name;
    }

    abstract boolean onLocation();

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public Player getPlayer(){
        return player;
    }
    public void setPlayer(Player player){
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
