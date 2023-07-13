public class jugador {
    private int score;
    private String nom;

    public jugador(String nom) {
        this.nom = nom;
    }

    public jugador() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return getNom()+"   "+getScore()+"\n";
    }
}
