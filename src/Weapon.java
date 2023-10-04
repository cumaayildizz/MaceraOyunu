public class Weapon {
    private String weaponName;
    private int weaponID;
    private int getWeaponDamage;
    private int weaponFee;

    public Weapon(String weaponName, int weaponID, int getWeaponDamage, int weaponFee) {
        this.weaponName = weaponName;
        this.weaponID = weaponID;
        this.getWeaponDamage = getWeaponDamage;
        this.weaponFee = weaponFee;
    }

    public static Weapon[] weapons(){
        Weapon[] weaponList = new Weapon[3];
        weaponList[0] = new Weapon("Kilic" , 1 , 2 , 25);
        weaponList[1] = new Weapon("Tabanca" , 2 , 3 , 35);
        weaponList[2] = new Weapon("Tufek" , 3 , 7 , 45);
        return weaponList;
    }
    public static Weapon getWeaponObjByID(int ID){
        for(Weapon w : Weapon.weapons()){
            if(w.getWeaponID() == ID ){
                return w;
            }
        }
        return null;
    }
    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getWeaponID() {
        return weaponID;
    }

    public void setWeaponID(int weaponID) {
        this.weaponID = weaponID;
    }

    public int getGetWeaponDamage() {
        return getWeaponDamage;
    }

    public void setGetWeaponDamage(int getWeaponDamage) {
        this.getWeaponDamage = getWeaponDamage;
    }

    public int getWeaponFee() {
        return weaponFee;
    }

    public void setWeaponFee(int weaponFee) {
        this.weaponFee = weaponFee;
    }
}
