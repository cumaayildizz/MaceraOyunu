import java.util.Scanner;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private boolean food ;
    private boolean water;
    private boolean firewood;
    private Player player;
    public Scanner scanner = new Scanner(System.in);
    private Monster monster;

    public Inventory(){
        this.weapon = new Weapon("Ciplak El" , -1 , 0 , 0 );
        this.armor = new Armor(-1 , "Ciplak" , 0 , 0);
    }


    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    /////////////////////////////////////////////////////
    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }
}

/*
 public void snakeLoot(){
        String yesOrNo;
        int snakeLoot = (int)(Math.random() * 1000);
        if (snakeLoot >= 0  &&  snakeLoot < 150){

            if (snakeLoot >= 0  &&  snakeLoot <= 30){
                System.out.println( getWeapon().getWeaponName() + "kazandiniz");
                System.out.print("Silahi kusanmak istiyorsan < Y > istemiyorsan < N > bas : ");
                yesOrNo = scanner.nextLine().toUpperCase();
                if (yesOrNo.equals("Y")){
                    setWeapon(new Weapon("Tufek" , 3 , 7 , 45));
                }

            }
            if (snakeLoot > 30  &&  snakeLoot <= 90){
                System.out.println( getWeapon().getWeaponName() + "kazandiniz");
                System.out.print("Silahi kusanmak istiyorsan < Y > istemiyorsan < N > bas : ");
                yesOrNo = scanner.nextLine().toUpperCase();
                if (yesOrNo.equals("Y")){
                    setWeapon(new Weapon("Tabanca" , 2 , 3 , 35));
                }
            }
            if (snakeLoot > 90  &&  snakeLoot < 150){
                System.out.println( getWeapon().getWeaponName() + "kazandiniz");
                System.out.print("Silahi kusanmak istiyorsan < Y > istemiyorsan < N > bas : ");
                yesOrNo = scanner.nextLine().toUpperCase();
                if (yesOrNo.equals("Y")){
                    setWeapon(new Weapon("Kilic" , 1 , 2 , 25));
                }
            }

        }else if (snakeLoot >= 150  &&  snakeLoot < 300){

            if (snakeLoot >= 150  &&  snakeLoot <= 180){
                System.out.println( getArmor().getArmorName() + " zirh kazandiniz");
                System.out.print("Zirhi kusanmak istiyorsan < Y > istemiyorsan < N > bas : ");
                yesOrNo = scanner.nextLine().toUpperCase();
                if (yesOrNo.equals("Y")){
                    setArmor(new Armor(1 , "Agir" , 5 , 40));
                }
            }
            if (snakeLoot > 180  &&  snakeLoot <= 240){
                System.out.println( getArmor().getArmorName() + " zirh kazandiniz");
                System.out.print("Zirhi kusanmak istiyorsan < Y > istemiyorsan < N > bas : ");
                yesOrNo = scanner.nextLine().toUpperCase();
                if (yesOrNo.equals("Y")){
                    setArmor(new Armor(2 , "Orta" , 3 , 25));
                }
            }
            if (snakeLoot > 240  &&  snakeLoot < 300){
                System.out.println( getArmor().getArmorName() + " zirh kazandiniz");
                System.out.print("Zirhi kusanmak istiyorsan < Y > istemiyorsan < N > bas : ");
                yesOrNo = scanner.nextLine().toUpperCase();
                if (yesOrNo.equals("Y")){
                    setArmor(new Armor(1 , "Hafif" , 1 , 15));
                }
            }
        }else if (snakeLoot >= 300  &&  snakeLoot < 650){

            if (snakeLoot >= 300  &&  snakeLoot <= 350){
                this.getMonster().setMonsterLoot(getMonster().getMonsterLoot() + 10); // Anakondanin para degeri normalde 0 iken biz setter metodu ile 10 yaptik
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getMonsterLoot());
                System.out.println( this.getMonster().getMonsterLoot()   + " coin kazandiniz");
            }
            if (snakeLoot > 350  &&  snakeLoot <= 425){
                this.getMonster().setMonsterLoot(getMonster().getMonsterLoot() + 5); // Anakondanin para degeri normalde 0 iken biz setter metodu ile 5 yaptik
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getMonsterLoot());
                System.out.println( this.getMonster().getMonsterLoot()   + " coin kazandiniz");
            }
            if (snakeLoot > 425  &&  snakeLoot < 650){
                this.getMonster().setMonsterLoot(getMonster().getMonsterLoot() + 1); // Anakondanin para degeri normalde 0 iken biz setter metodu ile 1 yaptik
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getMonsterLoot());
                System.out.println( this.getMonster().getMonsterLoot()   + " coin kazandiniz");
            }

        }else {
            System.out.println("Bugun sansli gununde degilsin. Hicbir sey kazanamadin :((( ");

        }
    }
 */
