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
public class Pelicula 
{
    
    String color;
    String director_name;
    double num_critic_for_reviews;
    double duration;
    double director_facebook_likes;
    double actor_3_facebook_likes;
    String actor_2_name;
    double actor_1_facebook_likes;
    double gross;
    String genres;
    String actor_1_name;
    String movie_title;
    double num_voted_users;
    double cast_total_facebook_likes;
    String actor_3_name;
    double facenumber_in_poster;
    String plot_keywords;
    String movie_imdb_link;
    double num_user_for_reviews;
    String language;
    String country;
    String content_rating;
    double budget;
    double title_year;
    double actor_2_facebook_likes;
    double imdb_score;
    double aspect_ratio;
    double movie_facebook_likes;
    double calificacion_inicial;
    
    public Pelicula(String color, String director_name, double num_critic_for_reviews,
            double duration, double director_facebook_likes, double actor_3_facebook_likes,
            String actor_2_name, double actor_1_facebook_likes, double gross, String genres,
            String actor_1_name, String movie_title, double num_voted_users, double cast_total_facebook_likes,
            String actor_3_name, double facenumber_in_poster, String plot_keywords, String movie_imdb_link, 
            double num_user_for_reviews, String language, String country, String content_rating, double budget,
            double title_year, double actor_2_facebook_likes, double imdb_score, double aspect_ratio, 
            double movie_facebook_likes) {
        this.color = color;
        this.director_name = director_name;
        this.num_critic_for_reviews = num_critic_for_reviews;
        this.duration = duration;
        this.director_facebook_likes = director_facebook_likes;
        this.actor_3_facebook_likes = actor_3_facebook_likes;
        this.actor_2_name = actor_2_name;
        this.actor_1_facebook_likes = actor_1_facebook_likes;
        this.gross = gross;
        this.genres = genres;
        this.actor_1_name = actor_1_name;
        this.movie_title = movie_title;
        this.num_voted_users = num_voted_users;
        this.cast_total_facebook_likes = cast_total_facebook_likes;
        this.actor_3_name = actor_3_name;
        this.facenumber_in_poster = facenumber_in_poster;
        this.plot_keywords = plot_keywords;
        this.movie_imdb_link = movie_imdb_link;
        this.num_user_for_reviews = num_user_for_reviews;
        this.language = language;
        this.country = country;
        this.content_rating = content_rating;
        this.budget = budget;
        this.title_year = title_year;
        this.actor_2_facebook_likes = actor_2_facebook_likes;
        this.imdb_score = imdb_score;
        this.aspect_ratio = aspect_ratio;
        this.movie_facebook_likes = movie_facebook_likes;
        calificacion_inicial= 0;
    }
    
    public Pelicula pelicula_de_archivo(String linea)
    {
        String [] campos = linea.split(",");
        return new Pelicula(campos[0],campos[1],DP(campos[2]),DP(campos[3]),DP(campos[4]),DP(campos[5]),
        campos[6],DP(campos[7]),DP(campos[8]),campos[9],campos[10],campos[11],DP(campos[12]),DP(campos[13]),
        campos[14],DP(campos[15]),campos[16],campos[17],DP(campos[18]),campos[19],campos[20],campos[21],
        DP(campos[22]),DP(campos[23]),DP(campos[24]),DP(campos[25]),DP(campos[26]),DP(campos[27]));
    }
    
    public Double DP (String numero)
    {
      try
      {
        return Double.parseDouble(numero);
      }
      catch(Exception ex)
      {
        return 0.0;
      }
    
    }
    
    public Boolean have_genre(String genero)
    {
        Boolean t = false;
        String [] generos = this.genres.split("\\|");
        for (int i = 0; i < generos.length; i++)
        {
            if (generos[i].equals(genero))
            {
             t=true;
             break;
            }
   
        }
        return t;
    
    }
    
    public void calificar(double[] maximos)
    {
        calificacion_inicial= 0;
        calificacion_inicial+= (director_facebook_likes/maximos[0]);
        calificacion_inicial+= (actor_3_facebook_likes/maximos[1]);
        calificacion_inicial+= (actor_1_facebook_likes/maximos[2]);
        calificacion_inicial+= (gross/maximos[3]);
        calificacion_inicial+= (cast_total_facebook_likes/maximos[4]);
        calificacion_inicial+= (imdb_score/maximos[5]);
        calificacion_inicial+= (aspect_ratio/maximos[6]);
        calificacion_inicial+= (movie_facebook_likes/maximos[7]);
    }
    
    public KNN_point punto()
    {
    
      return null;
    }
    
}
