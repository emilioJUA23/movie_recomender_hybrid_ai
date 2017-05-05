/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_movie_recomender;
import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * @author root
 */
public class KNN_map 
{
    public List<KNN_point> Points = new ArrayList();
    public int k;
    public int r_space;

    public KNN_map(int k, int r_space) 
    {
        this.k = k;
        this.r_space = r_space;
    }
    
    public Boolean prediccion(KNN_point punto)
    {
        int contador=0;
        List<KNN_point> sub_lista= closer_points(punto);
        for (int i = 0; i < sub_lista.size(); i++)
        {
            if (sub_lista.get(i).estado)
            {
              contador++;    
            }
            else
            {
              contador--;
            }
  
        }
        return (contador>=0);
    }
    
    public void train_point(KNN_point n_point,Boolean state)//insertaun punto en nustro mapa
    {
        if (n_point.coordenates.length==r_space) 
        {
            n_point.estado=state;
            Boolean t =false;
            for (int i = 0; i < Points.size(); i++) 
            {
                if (Points.get(i).distancia(n_point)==0)
                {
                   Points.get(i).estado=state;
                   t=true;
                   break;
                }
            }
            if (!t)
            {
                Points.add(n_point);
            } 
           
        }
        else
        {
           
        }
    }
   
    public List<KNN_point> closer_points(KNN_point punto)
    {
        List<KNN_point> close_points = new ArrayList();
        List<Double> distancias = new ArrayList();
        if (Points.size()<=k)
        {
          close_points=Points;    
        }
        else
        {
            for (int i = 0; i < Points.size(); i++)
            {
              distancias.add(punto.distancia(Points.get(i)));//calculo todas las distancias de los puntos
            }
            for (int i = 0; i < Points.size(); i++)//empiezo a listar todos los puntos mas cercanos
            {
                if (close_points.size()<k)   //si todavia no lleno k solo agrego el punto
                {
                    close_points.add(Points.get(i));
                }
                else                            //si ya llegue a k tengo que buscar si es mas cercano
                {
                    for (int j = 0; j < close_points.size(); j++)
                    {
                        if (distancias.get(i)<punto.distancia(close_points.get(j)))
                        {
                            close_points.set(j, Points.get(i));
                            break;
                        }
                        else{}
                    }
                }
            }
        
        }
    
        
        return close_points;
    }
    
    
}
