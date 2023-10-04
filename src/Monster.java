public class Monster {
    private int monsterID;
    private String monsterName;
    private int maxMonsterDamage;
    private int minMonsterDamage;
    private int monsterHealth;
    private int monsterLoot;
    private int monsterOriginalHealth;

    public Monster(int monsterID, String monsterName, int maxMonsterDamage , int minMonsterDamage, int monsterHealth , int monsterLoot ) {
        this.monsterID = monsterID;
        this.monsterName = monsterName;
        this.maxMonsterDamage = maxMonsterDamage;
        this.minMonsterDamage = minMonsterDamage;
        this.monsterOriginalHealth = monsterHealth;
        this.monsterLoot = monsterLoot;
    }

    public int randomMonsterDamage(){
        return   (int)( Math.random() * getMaxMonsterDamage() ) + getMinMonsterDamage();
           //Bu fonksiyonun anlami max deger ile sifir arasinda bir sayi uret.
        //Bu sayi double oldugundan basina int koyup tam sayiya cevirdik. Double sayi integere donerken bir alt degere yivarlanir.
        //Bu yuzden biz olasi 0.61561(int degeri = 0) gibi bir sayi ihtimaline karsi istedigimiz min canavar degerini de ekliyoruz.
        //3-6 arasi canavar uretmek istiyorsak maxMonster = 3 minMonster = 3 yapariz
        //7-11 arasinda canavar uretmek istiyorsak max=7 min=4 yapariz
    }


    public int getMonsterID() {
        return monsterID;
    }

    public void setMonsterID(int monsterID) {
        this.monsterID = monsterID;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public int getMaxMonsterDamage() {
        return maxMonsterDamage;
    }

    public void setMaxMonsterDamage(int maxMonsterDamage) {
        this.maxMonsterDamage = maxMonsterDamage;
    }

    public int getMinMonsterDamage() {
        return minMonsterDamage;
    }

    public void setMinMonsterDamage(int minMonsterDamage) {
        this.minMonsterDamage = minMonsterDamage;
    }

    public int getMonsterHealth() {
        return monsterHealth;
    }

    public void setMonsterHealth(int monsterHealth) {
        if (monsterHealth < 0){
            monsterHealth = 0 ;
        }
        this.monsterHealth = monsterHealth;
    }

    public int getMonsterLoot() {
        return monsterLoot;
    }

    public void setMonsterLoot(int monsterLoot) {
        this.monsterLoot = monsterLoot;
    }

    public int getMonsterOriginalHealth() {
        return monsterOriginalHealth;
    }

    public void setMonsterOriginalHealth(int monsterOriginalHealth) {
        this.monsterOriginalHealth = monsterOriginalHealth;
    }
}
