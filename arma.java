public class arma {

    private String nom;
    private TipusA tipus;
    private boolean magia;
    private double dany;

    public arma(String nom, TipusA tipus, boolean magia, double dany) {
        this.nom = nom;
        this.tipus = tipus;
        this.magia = magia;
        this.dany = dany;
    }

    public String getNom() {
        return nom;
    }

    public TipusA getTipus() {
        return tipus;
    }

    public boolean getMagia() {
        return magia;
    }

    public double getDany() {
        return dany;
    }

    public enum TipusA {
        espasa, destral, basto, arc
    }
}