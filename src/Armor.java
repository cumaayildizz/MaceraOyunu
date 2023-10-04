public class Armor {
    private int armorID;
    private String armorName;
    private int armorBlock;
    private int armorFee; //ucreti

    public Armor(int armorID, String armorName, int armorBlock, int armorFee) {
        this.armorID = armorID;
        this.armorName = armorName;
        this.armorBlock = armorBlock;
        this.armorFee = armorFee;
    }

    public static Armor[] armors(){
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor(1 , "Hafif" , 1 , 15);
        armorList[1] = new Armor(2 , "Orta" , 3 , 25);
        armorList[2] = new Armor(1 , "Agir" , 5 , 40);
        return armorList;
    }

    public static Armor getArmorObjByID(int ID){
        for(Armor a : Armor.armors()){
            if(a.getArmorID() == ID ){
                return a;
            }
        }
        return null;
    }

    public int getArmorID() {
        return armorID;
    }

    public void setArmorID(int armorID) {
        this.armorID = armorID;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getArmorBlock() {
        return armorBlock;
    }

    public void setArmorBlock(int armorBlock) {
        this.armorBlock = armorBlock;
    }

    public int getArmorFee() {
        return armorFee;
    }

    public void setArmorFee(int armorFee) {
        this.armorFee = armorFee;
    }
}
