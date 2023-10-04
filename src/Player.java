import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int originalHealth;
    private int money;
    private String name;
    private String charName;
    private Inventory inventory;
    public Scanner scanner = new Scanner(System.in);
    private Location location;
    private BattleLocation battleLocation;

    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar(){

        GameChar[] charList = {new Samurai() , new Archer() , new Knight() };

        System.out.println("                      ****KARAKTERLER*****");
        System.out.println("====================================================================");
        for ( GameChar gameChar : charList){
            System.out.println(gameChar.getId() + ".Karakter: " + gameChar.getName() +
                    "\t\t Hasar: "+ gameChar.getDamage() +
                    "\t\t Saglik: " + gameChar.getHealth() +
                    "\t\t Para: " + gameChar.getMoney());

        }
        System.out.println("====================================================================");

        int selectChar;
        do { //Karakter secimi 1 ve 3 arasinda olmak zorunda!!
            //System.out.println("Samuray için (1) --- Okçu için (2) --- Şovalye için (3)  basınız!! ");
            System.out.println(charList[0].getName() + " için < " + charList[0].getId() + " >  ---  "
                             + charList[1].getName() + " için < " + charList[1].getId() + " >  ---  "
                             + charList[2].getName() + " için < " + charList[2].getId() + " >   basiniz!! ");
            System.out.println();
            System.out.print("Lutfen Savascinizi Seciniz : ");
            selectChar = scanner.nextInt();
            if (selectChar > 3 || selectChar < 0){
                System.out.println();
                System.out.println("Secim Hatali!! Lutfen belirttigimiz Savascilardan birini seciniz(1 -2 - 3)");
                System.out.println();
            }
        }while (!(selectChar<=3 && selectChar>=1));


        switch (selectChar) {
            case 1 -> initPlayer(new Samurai());
            case 2 -> initPlayer(new Archer());
            case 3 -> initPlayer(new Knight());
            default -> initPlayer(new Samurai());
            /*
switch (selectChar){
        case 1:
        initPlayer(new Samurai());      >>>>>>     case 1 -> initPlayer(new Samurai());  ayni durumu ifade eder
        break;
        case 2:
        initPlayer(new Archer());       ******* Switc case yapisinin iki farkli gosterimi *******
        break;
        case 3:
        initPlayer(new Knight());
        break;
default:
        initPlayer(new Samurai());
        }
             */
        }
        System.out.println("*********************************************************************");
        System.out.println( this.getCharName() +   "  =---->>>     Hasar: " + this.getDamage()
                + "\t\tSaglik: "+ this.getHealth()
                + "\t\tPara: "  + this.getMoney());
        System.out.println("*********************************************************************");

    }

    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOriginalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printPLayerInfo(){
        System.out.println("**********************************************************************************");
        System.out.println("            -----------Mevcut durumunuz-----------");
        System.out.println(            "Silah: "  + getInventory().getWeapon().getWeaponName()
                +     "\tZirh: "  + getInventory().getArmor().getArmorName()
                +  "\t\tBlock: "  + getInventory().getArmor().getArmorBlock()
                +    "\tHasar: "  + this.getTotalDamage()
                +   "\tSaglik: "  + this.getHealth()
                +   "\t\tPara: "  + this.getMoney());

        System.out.println("**********************************************************************************");
    }




    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getGetWeaponDamage();
    }
    public int getDamage(){
        return damage;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        if (health < 0){
            health = 0 ;
        }
        this.health = health;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public int getMoney(){
        return money;
    }
    public void setMoney(int money){
        this.money = money;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getCharName(){
        return charName;
    }
    public void setCharName(String charName){
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public BattleLocation getBattleLocation() {
        return battleLocation;
    }

    public void setBattleLocation(BattleLocation battleLocation) {
        this.battleLocation = battleLocation;
    }
}




