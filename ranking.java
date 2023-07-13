import java.util.ArrayList;

public class ranking {
    private ArrayList<jugador> ordenar = new ArrayList<jugador>();
    private ArrayList<jugador> ranking = new ArrayList<jugador>();

    public String imprimir(){
        StringBuilder escribir= new StringBuilder();
        for(int i=0;i<ranking.size();i++){
            escribir.append(ranking.get(i).getNom()+"       ").append(ranking.get(i).getScore()).append("\n");
        }
        return escribir.toString();
    }
    public void agregar(jugador jugador){
        ordenar.add(jugador);
    }

    public void ordenar(){
        int j=0;
        jugador mayor;
        ordenar.addAll(ranking);
        ranking.clear();
        do{
            mayor= ordenar.get(0);
            for(int i=0;i<ordenar.size();i++){
                if(mayor.equals(ordenar.get(i))){}
                else{
                    if(mayor.getScore()<ordenar.get(i).getScore()){
                        mayor=ordenar.get(i);
                        break;
                    }
                }
            }
            ordenar.remove(mayor);
            ranking.add(mayor);
        }while(j<ordenar.size());
    }
}
