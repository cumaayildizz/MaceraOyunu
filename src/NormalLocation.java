public abstract class NormalLocation extends Location{

    public NormalLocation(int NormalLocID , Player player , String name){
        super( NormalLocID, player , name);
    }
    public boolean onLocation(){
        return true;               //guvenli bolgeler oldugu icin olme ihtimalimiz yok.Bu yuzden boolean her zaman TRUE doner
    }
}
