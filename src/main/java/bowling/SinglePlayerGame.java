package bowling;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancés successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class SinglePlayerGame {

	private int score;
	private int lancer;
        private int nblancer;
        private int previous;
        private int multiplicateur;
        
	public SinglePlayerGame() {
            lancer = 0;
            score = 0;
            nblancer = 0;
            previous = 0;
            multiplicateur = 0;
        }

	/**
	 * C ette méthode doit être appelée à chaque lancé de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de
	 * ce lancé
	 */
	public void lancer(int nombreDeQuillesAbattues) {
              lancer = nombreDeQuillesAbattues;
              if(lancer == 10 && nblancer<20){
                  if (multiplicateur>0){
                      if (multiplicateur == 2){
                          score += lancer*3;
                      }
                      else{
                          score += lancer*2;
                      }
                      nblancer +=2;
                      multiplicateur = 2;
                  }
                  else{
                  multiplicateur = 2;
                  score += lancer;
                  nblancer +=2;
                  }
                  
              }
              else if(lancer == 10 && nblancer>=20){
                  score += lancer; 
              }
              else{
                  
                  if (nblancer%2 ==0){
                      previous = lancer;
                      if (multiplicateur>0){
                          multiplicateur -= 1;
                          score += lancer*2;
                      }
                      else{
                          score += lancer;
                      }
                     
                  }
                  else{
                      if (multiplicateur>0){
                          if(lancer+previous == 10){
                          }
                          else{
                              multiplicateur -= 1;
                          }
                          
                          score += lancer*2;
                      }
                      else{
                          if(lancer+previous == 10){
                            multiplicateur = 1;
                          }
                          score += lancer;
                      }
                      
                  }
              nblancer +=1;    
              }
              
	}

	/**
	 * Cette méthode donne le score du joueur
	 *
	 * @return Le score du joueur
	 */
	public int score() {
                return score;
        }
}
