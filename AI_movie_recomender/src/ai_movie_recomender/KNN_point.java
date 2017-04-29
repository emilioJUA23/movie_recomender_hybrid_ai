/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_movie_recomender;

/**
 *
 * @author root
 */
public class KNN_point 
{
    public double[] coordenates;//posicion en el mapa de coordenadas
    public Boolean estado;         //positivo o negativo

    public KNN_point(double[] coordenates)
    {
        this.coordenates = coordenates;
    }
    
    public double distancia(KNN_point that)
    {
      try
      {
        
        double distancia=0;
        for (int i = 0; i < this.coordenates.length; i++)
        {
              //suma el cuadrado de la distancia
              distancia=distancia+Math.pow(this.coordenates[i]-that.coordenates[i],2);
        }
        return Math.sqrt(distancia);
      }
      catch(Exception ex)
      {
          return -1;
      }
    }
    
    
}
