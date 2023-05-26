package MAIN_02;

import java.util.ArrayList;

class Main {

    public static void main(String[] args) {

        System.out.println("Hello world");

    
        Movie movie_01 = new Movie("A Culpa é das Estrelas", "Um filme aleatório", 16, 120);
        Movie movie_02 = new Movie("A Culpa é das Estrelas", "Um filme aleatório", 16, 120);
        Serie serie_01 = new Serie("Peaky Blinders", "Sangue e Navalhas", 18, 20);
        Serie serie_02 = new Serie("Peaky Blinders", "Sangue e Navalhas", 18, 20);


        ArrayList<Footage> footages = new ArrayList<Footage>(); 
        footages.add(movie_01);
        footages.add(movie_02);
        footages.add(serie_01);
        footages.add(serie_02);

        
        Library library_01 = new Library("Biblioteca Principal", footages);

        library_01.addFootage(movie_01);
        library_01.toString(1);

    }

}