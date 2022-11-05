package main;

<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> master
import java.util.UUID;

import cineplex.Cineplex;

<<<<<<< HEAD
public interface ICineplexController {
    public void init();
    public void exit();
    public Cineplex getCineplexByID(UUID id);
    
    public void displayCineplex(List<Cineplex> list);
    public Cineplex selectCineplex();
    public Cineplex selectCineplex(List<Cineplex>list);
}
=======
import java.util.*;

public interface ICineplexController {
    public void init();

    public void exit();

    public Cineplex getCineplexByID(UUID id);

    public void displayCineplex(ArrayList<Cineplex> list);

    public Cineplex selectCineplex(ArrayList<Cineplex>list);


}
>>>>>>> master
