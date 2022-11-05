package main;

import java.util.UUID;

import cineplex.Cineplex;

import java.util.*;

public interface ICineplexController {
    public void init();

    public void exit();

    public Cineplex getCineplexByID(UUID id);

    public void displayCineplex(ArrayList<Cineplex> list);

    public Cineplex selectCineplex(ArrayList<Cineplex>list);


}
