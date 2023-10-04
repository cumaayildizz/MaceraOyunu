import java.util.Random;


public abstract class BattleLocation extends Location {
    private Monster monster;
    private String award;
    private int maxMonster;
    private int minMonster;
    private int maxMonsterDamage;
    private int minMonsterDamage;
    public BattleLocation(int locationID, Player player, String name,Monster monster ,String award , int maxMonster , int minMonster ) {
        super(locationID, player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
        this.minMonster = minMonster;
        this.maxMonsterDamage = maxMonsterDamage;
        this.minMonsterDamage = minMonsterDamage;

    }



    public int randomMonsterNumber(){
        Random r = new Random();
        return r.nextInt(getMaxMonster()) + getMinMonster() ;  //random fonksiyonu 0 ile parantez icine yazdigimiz degerin bir eksigi kadar integer sayi uretebilir
        // Yani random fonksiyonundaki degeri indis adedi gibi dusunebiliriz.Ornegin 1-3 arasinda uretmek istiyorsak maxMonster=3 minMonster=1 yapariz
        //3-6 arasi canavar uretmek istiyorsak maxMonster = 3 minMonster = 3 yapariz
        //7-11 arasinda canavar uretmek istiyorsak max=7 min=4 yapariz
    }
    @Override
    boolean onLocation() {

        int monsNumber = this.randomMonsterNumber();
        System.out.println("Suan buradasiniz : " + this.getName());
        System.out.println("----------------------------------------");
        System.out.println("Aman dikkat!! Her an karsina " + randomMonsterNumber() + " tane " +this.getMonster().getMonsterName() + "  cikabilir");
        System.out.println("----------------------------------------");
        System.out.println( "(S)avas    yada    (K)ac");
        System.out.println("Savasmak icin 'S' ye bas!!");
        System.out.println();
        System.out.print("Secimini yap: ");
        String selectLifeCase = scanner.nextLine().toUpperCase();
        System.out.println("=============================================================================");
        //int counter = 0 ;
        if(selectLifeCase.equals("S")  &&  combat(monsNumber)){
            System.out.println(this.getName() + " tum " + this.getMonster().getMonsterName() + " kestiniz.");
            if (getMonster().getMonsterID() == 4 ){
                System.out.println(this.getName() + " basarili bir sekilde gectiniz.");
                getPlayer().getInventory().snakeLoot();
            }
            if (getAward().equals("Yemek")  &&  getPlayer().getInventory().isFood() == false ){
                System.out.println(this.getName() + " basarili bir sekilde gectiniz." + this.getAward() + " kazandiniz.");
                getPlayer().getInventory().setFood(true);

            }
            if (getAward().equals("Odun")  &&  getPlayer().getInventory().isFirewood() == false ) {
                System.out.println(this.getName() + " basarili bir sekilde gectiniz." + this.getAward() + " kazandiniz.");
                getPlayer().getInventory().setFirewood(true);
            }
            if (getAward().equals("Su")  &&  getPlayer().getInventory().isWater() == false ) {
                System.out.println(this.getName() + " basarili bir sekilde gectiniz." + this.getAward() + " kazandiniz.");
                getPlayer().getInventory().setWater(true);
            }
            if ( getPlayer().getInventory().isWater() == true  &&  getPlayer().getInventory().isFirewood() == true  &&  getPlayer().getInventory().isFood() == true){
                System.out.println("OYUNU KAZANDINIZ");
                return false;
            }


            return true;
        }
        if(this.getPlayer().getHealth() <= 0){
            System.out.println("Öldünüz");
            return false;
        }

        return true;
    }



    public void afterHit(){
        System.out.println("Caniniz : " + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getMonsterName() + "Cani : " + this.getMonster().getMonsterHealth());
    }

    public boolean combat(int monsterNumber){  //combat metodu false donene kadar savasa devam et
        for (int i = 1 ; i <= monsterNumber ; i++){  //random olarak 1-3 ya da 1-5 arasinda atanan canavarlar bitene kadar savasa devam et.Biterse buradan cik.
            this.getMonster().setMonsterHealth(this.getMonster().getMonsterOriginalHealth());  //Girdigimiz savas bolgelerinde birden fazla canavar bulunabileceginden ,
                                                                                                // her kesilen canavar sonrasi yeni canavarin canini eski degerine dondurmek icin yaptigimiz islem
            playerStats();  //Savas oncesi Oyuncunun degerlerini gosteren metod
            monsterStats( i );  //Savas oncesi i'ninci  canavarin degerlerini gosteren metod
            while ( this.getPlayer().getHealth() > 0  &&  this.getMonster().getMonsterHealth() > 0 ){  //Oyuncu ve ya Canavardan herhangi birinin cani sifir ve ya altina dusmediyse savasa devam et.
                System.out.println("*********************************");
                System.out.print("   (V)ur   yada    (K)ac   " );
                System.out.println("Vurmak icin 'V' ye bas!!");
                System.out.print("Secimini yap: ");
                String selectCombat = scanner.nextLine().toUpperCase();
                System.out.println();

                int whoStart = (int)(Math.random() * 100 );
                if(selectCombat.equals("V")  &&  whoStart >= 50){
                        System.out.println("----------YENI RAUND-------------");
                        System.out.println("Siz Vurdunuz : ");
                        System.out.println("**************************");
                        this.getMonster().setMonsterHealth(this.getMonster().getMonsterHealth() - this.getPlayer().getTotalDamage()); //Burda canavarin canindan oyuncunun toplam vurdugu hasari cikariyoruz.
                        afterHit();  //savas sonrasi oyuncu ve canavarin son durumunu gosteren metod (saglik ,para,hasar,block)
                        if (this.getMonster().getMonsterHealth() > 0 ){  //Canavarin cani 0 ve ya altinda degilse yasiyor demektir. Yasiyorsa canavar da bize vursun.
                            System.out.println();
                            System.out.println(this.getMonster().getMonsterName() + " size vurdu :");
                            System.out.println("**************************"); //
                            int monsterNowDamage = getMonster().randomMonsterDamage() - this.getPlayer().getInventory().getArmor().getArmorBlock(); // Canavarin hasarindan block degerini cikarip bize vurabilecegi hasari buluyoruz.
                            if (monsterNowDamage < 0){  //Bug kontrolu.
                                monsterNowDamage = 0;  // Burda da Canavarin hasari benim zirhimin block degerinden kucukse , canavarin verecegi hasari 0 in altina dusmesini engelliyoruz.
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterNowDamage);  // Encapsulation yaptigimiz Health metodunda kendi canimizdan canavarinda vurdugu hasari cikariyoruz.
                            afterHit();   //savas sonrasi oyuncu ve canavarin son durumunu gosteren metod (saglik ,para,hasar,block)
                        }
                }else if ( selectCombat.equals("V")  &&  whoStart < 50 ) {

                        System.out.println("----------YENI RAUND-------------");
                        System.out.println(this.getMonster().getMonsterName() + " size vurdu :");
                        System.out.println("**************************");
                        int monsterNowDamage = getMonster().randomMonsterDamage() - this.getPlayer().getInventory().getArmor().getArmorBlock(); // Canavarin hasarindan block degerini cikarip bize vurabilecegi hasari buluyoruz.
                        if (monsterNowDamage < 0){  //Bug kontrolu.
                            monsterNowDamage = 0;  // Burda da Canavarin hasari benim zirhimin block degerinden kucukse , canavarin verecegi hasari 0 in altina dusmesini engelliyoruz.
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterNowDamage);
                        afterHit();

                        if (this.getPlayer().getHealth() > 0 ){  //Canavarin cani 0 ve ya altinda degilse yasiyor demektir. Yasiyorsa canavar da bize vursun.

                            System.out.println();
                            System.out.println("Siz Vurdunuz : ");
                            System.out.println("**************************");
                            this.getMonster().setMonsterHealth(this.getMonster().getMonsterHealth() - this.getPlayer().getTotalDamage()); //Burda canavarin canindan oyuncunun toplam vurdugu hasari cikariyoruz.
                            afterHit();  //savas sonrasi oyuncu ve canavarin son durumunu gosteren metod (saglik ,para,hasar,block)

                        }


                }else {
                    return false;
                }

            }
            if (this.getMonster().getMonsterHealth() < this.getPlayer().getHealth()){
                System.out.println("----------------------------------------------");
                System.out.println( i + "." + this.getMonster().getMonsterName() + "yi YENDINIZ");
                System.out.println(this.getMonster().getMonsterLoot() + " kazandiniz");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getMonsterLoot());
                System.out.println("Guncel Paraniz : " + this.getPlayer().getMoney());
                System.out.println("----------------------------------------------");
            }else {
                return false;
            }
        }
        return true;
    }

    public void  playerStats(){ //Oyuncunun mevcut degerlerini gosteren metod
        System.out.println();
        System.out.println("Oyuncu Degerleri");
        System.out.println("==================================");
        System.out.println("Saglik: " + this.getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getWeaponName());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Zirh  : " + this.getPlayer().getInventory().getArmor().getArmorName());
        System.out.println("Block : " + this.getPlayer().getInventory().getArmor().getArmorBlock());
        System.out.println("para  : " + this.getPlayer().getMoney());

    }

    public void monsterStats(int i){
        //i'ninci Canavarin mevcut degerlerini gosteren metod(Canavar sayisini random olarak atadigimiz icin 1 den fazla canavar cikabilir)
        //Bu yuzden kacici canavar oldugunu da bilmek icin for dongumuzeki sayaci(i) olusturdugumuz monsterStats metodununda icinde kullandik
        System.out.println();
        System.out.println( i + "." + this.getMonster().getMonsterName() + "Degerleri");
        System.out.println("=================================================");
        System.out.println("Saglik :" + this.getMonster().getMonsterHealth());
        System.out.println("Hasar  :" + getMonster().randomMonsterDamage());
        System.out.println("Ganimet:" +this.getMonster().getMonsterLoot());
    }





    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }

    public int getMinMonster() {
        return minMonster;
    }

    public void setMinMonster(int minMonster) {
        this.minMonster = minMonster;
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
}
