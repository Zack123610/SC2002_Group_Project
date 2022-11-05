package main;

import java.util.List;
import java.util.UUID;

import cineplex.Cineplex;

public interface ICineplexController {
    public void init();
    public void exit();
    public Cineplex getCineplexByID(UUID id);
    
    public void displayCineplex(List<Cineplex> list);
    public Cineplex selectCineplex();
    public Cineplex selectCineplex(List<Cineplex>list);
}