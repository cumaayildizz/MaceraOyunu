import java.util.Scanner;

public class Game {
    public Scanner scanner = new Scanner(System.in);

    public void start(){
        System.out.println();
        System.out.println("                             ******MACERA OYUNU******");
        System.out.println("===============================================================================================");
        System.out.println("===============================================================================================");
        System.out.println("Yaşa yada Öl!!\n    Sonunu düşünen kahraman olamaz::))\n    \tHazirsan Baslayalim...");
        System.out.println("===============================================================================================");

        System.out.print("Lutfen Adinizi giriniz : ");
        String playerName = scanner.nextLine();
        System.out.println("===============================================================================================");

        Player player = new Player(playerName);
        System.out.println("Sevgili '" + player.getName() + "' Macera Oyununa Hos Geldin");
        System.out.println();
        System.out.println("Burda yaşanan olaylar Mr. BıgCoder Cuma YILDIZ'ın hayal ürünüdür....\n" +
                "\tLütfen rüyalarınızdan uzak tutunuz!!!");
        System.out.println("===============================================================================================");
        System.out.println("===============================================================================================");

        player.selectChar();

        Location location = null;
        Location[] locationsList = {new Cave(player) , new Forest(player) , new River(player) , new Mine(player) ,new SafeHouse(player) , new ToolStore(player) };
        //BattleLocation[] locationsList = {new Cave(player) , new Forest(player) , new River(player) , new Mine(player) };
        //NormalLocation[] locationListNL = {new SafeHouse(player) , new ToolStore(player)};

        while (true){
            int counter = 0 ;
            player.printPLayerInfo();
            System.out.println();
            System.out.println("                      *****Bolgeler*****");
            System.out.println("===============================================================================================");
            System.out.println( locationsList[0].getLocationID() + " - " + locationsList[0].getName() + "        ---->>>  Burasi Zombilerin yasam alanidir.Basarili olursan <YEMEK> kazanirsin");
            System.out.println( locationsList[1].getLocationID() + " - " + locationsList[1].getName() + "         ---->>>  Burasi Vampirlerin yasam alanidir.Basarili olursan <ODUN> kazanirsin");
            System.out.println( locationsList[2].getLocationID() + " - " + locationsList[2].getName() + "         ---->>>  Burasi Ayilarin yasam alanidir.Basarili olursan <SU> kazanirsin");
            System.out.println( locationsList[3].getLocationID() + " - " + locationsList[3].getName() + "   ---->>>  Burasi Anacondanin yasam alanidir.Basarili olursan canavarlardan dusen itemleri kazanabilirsin");
            System.out.println( locationsList[4].getLocationID() + " - " + locationsList[4].getName() + "    ---->>>  Guvenli bolge.Burada dusman yoktur ");
            System.out.println( locationsList[5].getLocationID() + " - " + locationsList[5].getName() + "  ---->>>  Oyun magazasi.Silah yada zirh satin alabilirsiniz");
            System.out.println("===============================================================================================");
            System.out.println(" 0 === CIKIS YAP  ----->>> OYUNU SONLANDIR!!   ");

            int selectLocation ;
            do {
                System.out.println("------------------------------------------");
                System.out.print("Lutfen Gitmek istediginiz bolgeyi seciniz : ");
                selectLocation = scanner.nextInt();

                if (selectLocation >7 || selectLocation < 0 ){
                    System.out.println();
                    System.out.println("Secim Hatali!! Lutfen belirttigimiz yerlerden birini seciniz");
                    System.out.println();
                }
                if ((selectLocation == 1 && player.getInventory().isFood() == true) ||  (selectLocation == 2 && player.getInventory().isFirewood() == true)
                        ||  (selectLocation == 3 && player.getInventory().isWater() == true)){
                    System.out.println(  "Bu gorevi zaten bitirdiniz!!\n" +
                            "Lutfen baska bir gorev yeri secin." );
                }

            }while (!(selectLocation < 7 && selectLocation >= 0) || (selectLocation == 1 && player.getInventory().isFood() == true) ||
                    (selectLocation == 2 && player.getInventory().isFirewood() == true)  ||  (selectLocation == 3 && player.getInventory().isWater() == true));
            System.out.println();

            switch (selectLocation){
                case 1:
                    location = new Cave(player);
                    break;
                case 2:
                    location = new Forest(player);
                    break;
                case 3:
                    location = new River(player);
                    break;
                case 4:
                    location = new Mine(player);
                    break;
                case 5:
                    location = new SafeHouse(player);
                    break;
                case 6:
                    location = new ToolStore(player);
                    break;

                case 0 :
                    location = null;
                    break;
                default:
                    System.out.println("Hatali sayi girisi. Lutfen belirtilen Alanlardan birini secin");
            }
            if (location == null){
                System.out.println();
                System.out.println("GAME OVER!!! \n\tHepsi bu kadar miydi:)) \n\t\tBu oyun sadece cesur olanlari barindirir!!!");
                break;
            }

            if(!(location.onLocation())){
                System.out.println("*******************************");
                System.out.println("OYUN BITTI!!!\n" ); //+
                                 //   "\t\t GAME OVER..... ");
                break;
            }
        }



    }
}

