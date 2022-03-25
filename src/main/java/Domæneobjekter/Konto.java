package Domæneobjekter;

public class Konto {
    private String navn;
    private String kode;
    private int saldo;

    public Konto(String navn, String kode, int saldo) {
        this.navn = navn;
        this.kode = kode;
        this.saldo = saldo;
    }

    public String getNavn() {
        return navn;
    }

    public String getKode() {
        return kode;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setKode(String kode)
    {
        this.kode = kode;
    }

    public int deposit(int i) {
        if(i > 0){
        saldo = saldo + i;}
        return saldo;
    }

    public int withdraw(int i) {
        if(i <= saldo && i > 0){
        saldo = saldo -i;}
        return saldo;
    }
}
