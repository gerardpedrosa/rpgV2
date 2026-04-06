import java.util.ArrayList;

public abstract class personatge {

    protected String nom;
    private int edat;

    // caracteristiques generals
    protected double salut;
    protected double mana;

    // caracteristiques especifiques
    protected double forca;
    protected double destresa;
    protected double constitucio;
    protected double inteligencia;
    protected double saviesa;
    protected double carisma;
    private int ultimate;

    protected ArrayList<arma> armes;
    protected arma armaEquipada;

    public personatge(String nom, int edat, double forca, double destresa, double constitucio, double inteligencia, double saviesa, double carisma) {

    this.nom = nom;
    this.edat = edat;

    this.forca = forca;
    this.destresa = destresa;
    this.constitucio = constitucio;
    this.inteligencia = inteligencia;
    this.saviesa = saviesa;
    this.carisma = carisma;

    this.ultimate = 0;

    this.salut = constitucio * 50;
    this.mana = inteligencia * 30;

    this.armes = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public double getSalut() {
        return salut;
    }

    public double getMana() {
        return mana;
    }   

    public boolean estaViu() {
        return salut > 0;
    }

    public void mostrarArmes() {
        for (int i = 0; i < armes.size(); i++) {
            System.out.println(i + " - " + armes.get(i).getNom());
        }
    }

    public void equiparArma(int index) {
        if (index < 0 || index >= armes.size()) return;

        arma a = armes.get(index);

        if (a.getMagia() && inteligencia < 10) {
            System.out.println("No tens prou intel·ligència per equipar aquesta arma.");
            return;
        }

        armaEquipada = a;
        System.out.println(nom + " equipa " + a.getNom());
    }

    public void afegirArma(arma a) {
        armes.add(a);
    }

    public double atacar() {

        double dany;

        if (armaEquipada == null) {
            dany = forca;
        } else if (!armaEquipada.getMagia()) {
            dany = forca * (1 + armaEquipada.getDany() / 100);
        } else {
            dany = armaEquipada.getDany() * inteligencia / 100;
        }

        ultimate++;
        dany = usarUltimate(dany);

        return dany;
    }

    public void defensar(double dany) {
        dany = dany / 2;
        salut -= dany;
        if (salut < 0) salut = 0;
    }

    public boolean esquivar() {
        double prob = (destresa - 5) * 3.33;
        if (prob < 0) prob = 0;
        if (prob > 100) prob = 100;

        return Math.random() * 100 < prob;
    }

    public void rebreAtac(double dany, boolean defensant) {

        if (esquivar()) {
            System.out.println(nom + " esquiva l'atac!");
            return;
        }

        if (defensant) {
            dany /= 2;
        }

        salut -= dany;
        if (salut < 0) salut = 0;

        System.out.println(nom + " rep " + dany + " de dany.");
    }

    public void regenerarVida() {
        double max = constitucio * 50;
        salut += constitucio * 3;
        if (salut > max) salut = max;
    }

    public void regenerarMana() {
        double max = inteligencia * 30;
        mana += inteligencia * 2;
        if (mana > max) mana = max;
    }

    public double usarUltimate(double dany) {
        if (ultimate >= 3) {
            System.out.println(nom + " ha activat l'ULTIMATE!");
            dany *= 2;
            ultimate = 0;
        }
        return dany;
    }

}

