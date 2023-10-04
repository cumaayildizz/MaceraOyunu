public class ToolStore extends NormalLocation{
    public ToolStore(Player player ){
        super(6 , player , "ERDAL BAKKAL");
    }

    @Override
    public boolean onLocation() {
        System.out.println("       **** Erdal Bakkala Hos Geldiniz ****");
        boolean showMenu = true;
        while (showMenu){

            System.out.println("======================================================");
            System.out.println(" 1-Silahlar       2-Zirhlar       3-Cikis yap");
            System.out.println("======================================================");

            int selectCase;
            do {
                System.out.print("Seciminiz : ");
                selectCase = Location.scanner.nextInt();
                if (selectCase > 3 || selectCase < 1){
                    System.out.println();
                    System.out.println("Hatali secim!! Lutfen tekrar deneyiniz.");
                    System.out.println();
                }
            }while (selectCase > 3 || selectCase < 1);

            switch (selectCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Tekrar Bekleriz");
                    showMenu = false;
                    break;
            }

        }

        return true;
    }

    public void printWeapon(){
        System.out.println("           ******Silahlar*******");
        System.out.println("===========================================");
        for(Weapon w : Weapon.weapons()){
            System.out.println(w.getWeaponID() + "-" + w.getWeaponName() + "  \t-->>>  Hasar: " + w.getGetWeaponDamage() + "    Ucret: " + w.getWeaponFee());
        }
        System.out.println(" 0 -->> Cikis Yap");
    }

    public void buyWeapon(){
        System.out.print("Bir silah secin : ");
        int selectWeaponID = scanner.nextInt();

        while (selectWeaponID < 0  ||  selectWeaponID > Weapon.weapons().length ){ //Silah secimi 1 ve 3 arasinda olmak zorunda!!
            if (selectWeaponID > Weapon.weapons().length  ||  selectWeaponID < 0){  //Weapon.weapons().length tasarim guncellemesinde yeni bir silah eklersek bu kismi degistirmemize gerek kalmaz.
                System.out.println();                                           // En buyuk degeri array(dizi) boyutuna gore ayarladigimiz icin dizinin icine eleman eklendikce dizi.lenght degeri de otomatikmen degisir.
                System.out.println("Secim Hatali!! Lutfen belirttigimiz Silahlardan birini seciniz(1 -2 - 3)");
                System.out.println();
            }
        }

        if (selectWeaponID != 0){

            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

            if(selectedWeapon != null){
                if(selectedWeapon.getWeaponFee() > this.getPlayer().getMoney()){
                    System.out.println("Bunu alacak paran yok dostum:)\n " +
                            "\t  Gidip biraz daha Yaratik kes");
                }
                else {
                    System.out.println("======================================================");
                    System.out.println(selectedWeapon.getWeaponName() + " silahini satin aldiniz.");
                    int playerBalance = (this.getPlayer().getMoney()) - (selectedWeapon.getWeaponFee()); // Oyuncunun bakiyesini aldigi silahi cikararak guncelledik
                    this.getPlayer().setMoney(playerBalance);
                    System.out.println("Kalan paraniz : " + this.getPlayer().getMoney());
                    System.out.println("======================================================");
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);

                }
            }
            System.out.println(" 0 -->> Cikis Yap");
        }

    }
    public void printArmor(){
        System.out.println("           ******Zirhlar*******");
        System.out.println("===========================================");
        for(Armor a : Armor.armors()){
            System.out.println(a.getArmorID() + "-" + a.getArmorName() + "\t Block: " + a.getArmorBlock() + "\t Ucret: " + a.getArmorFee() );
        }
        System.out.println(" 0 -->> Cikis Yap");
    }

    public void buyArmor(){ //Zirh secimi 1 ve 3 arasinda olmak zorunda!!

        System.out.print("Bir Zirh secin : ");
        int selectArmorID = scanner.nextInt();

        while (selectArmorID > Weapon.weapons().length   ||  selectArmorID < 0 ){  //Weapon.weapons().length tasarim guncellemesinde yeni bir silah eklersek bu kismi degistirmemize gerek kalmaz.
            System.out.println();                                                 // En buyuk degeri array(dizi) boyutuna gore ayarladigimiz icin dizinin icine eleman eklendikce dizi.lenght degeri de otomatikmen degisir.
            System.out.println("Secim Hatali!! Lutfen belirttigimiz Silahlardan birini seciniz(1 -2 - 3)");
            System.out.println();
            selectArmorID = scanner.nextInt();
        }

        if(selectArmorID != 0 ){
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);

            if(selectedArmor != null){
                if(selectedArmor.getArmorFee() > this.getPlayer().getMoney()){
                    System.out.println("Bunu alacak paran yok dostum:)\n " +
                            "\t  Gidip biraz daha Yaratik kes");
                }
                else {
                    System.out.println("======================================================");
                    System.out.println(selectedArmor.getArmorName() + " zirh satin aldiniz.");
                    int playerBalance = (this.getPlayer().getMoney()) - (selectedArmor.getArmorFee());  //Oyuncu bakiyesinden armor fiyatini cikardik.
                    this.getPlayer().setMoney(playerBalance);
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Kalan paraniz : " + this.getPlayer().getMoney());
                    System.out.println("======================================================");


                }
            }
        }


    }





}
