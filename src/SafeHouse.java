public class SafeHouse extends NormalLocation{
    public SafeHouse(Player player){
        super( 5 , player,"Guvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Guvenli evdesiniz. Caniniz FULLlendi\n" +
                      "\t\t Burda Hicbir yaratik caninizi yakamaz!!!!");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());  // Burda Oyuncunun canini fulluyoruz (Orjinal deger ilk baslangictaki deger)
        //setter Health metoduyla baslangictaki cani ile oyun icindeki canini degistirip oyuncunun canini fullemis oluyoruz
        //OriginalHealth her zaman baslangic degerinde kalip oyuncu guvenli eve degildiginde mevcut helath degerinin setter metoduna yazilarak can fulleme islemi yapilir.

        return true;
    }
}
