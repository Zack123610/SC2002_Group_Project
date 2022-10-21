# SC2002_Group_Project

Taskings:
- Create seed data for the Models            (24 Oct Monday)
- Finishing the code for all the controllers (30 Oct Sunday)

General Idea:
- Model: Models the real world using classes and enums. Objects will be created from the models. 
- Controllers: Control the overall logic flow of the entire application. 

----------------------
On Git:
- Master branch will be the official branch used.
- When pushing your code:
    - Create a new branch
    - Push your code to the new branch
    - Create a pull request to the master branch
- Impt: Do NOT select the option to delete the branch when merging
        The branches will be used for tracking purposes / backup 
----------------------
----------------------
- All the controllers will be initialised in the main file (MOBLIMA.java), there will be one instance of each controller at runtime
- The application works by having the controllers communicate with each other.
- Each controller will store an ArrayList of their respective model.

Eg. In the CustomerController, to call a method in the BookingController:
MOBLIMA.bookingController.method();
----------------------
----------------------
Explanations of the controllers:
Each controller should support Create/Read/Update/Delete operations (depends on question, might not need to implement all), plus some additional requirements.

- CustomerController: Manages the menu display for when user selects "Customer"

- AdminController:    Manages the menu display for when user selects "Admin"

- SettingsController: Manages the application settings (Edit base ticket price, Add new holiday, Change multiplier for all the ticket attributes)

- ShowTimeController: Manages the ShowTime class, has to support querying of the showtime based on the Movie and Cineplex provided.

- MovieController: Manages the Movie class, has to support sorting the movies based on ticket sales / review rating

- BookingController: Manages the Booking class, generates the booking when customer books a movie. Note that one booking can have multiple tickets

- TicketController: Manages the Ticket class, one ticket is created when the customer books a seat. 

- CineplexController: Manages the Cineplex class, each cineplex will store 3 Cinema objects

- CinemaController: Manages the Cinema class, will also manage the respective seats in the Cinema. 

- ReviewController: Manages the Review class, used when customers chooses to create a new review

----------------------
----------------------
Guide for Tasking 1: Create seed data for the Models

Whoever is doing the controller, will do the seed data for that model.
E.g. The person in charge of the Movie Controller will provide the seed data for the Movie class

1) Create a new text file in data\init, fill in with data accordingly (E.g. Movie1.txt, ..., Movie5.txt)
2) In the Movie class, create a public static void main(String args[]).
   This main method will only be for internal use to initialise the data folder when needed
3) Write code in the main method to read the files and convert them into an ArrayList of the Movie class. 
4) Use the code provided in FileController to write the ArrayList into the respective data folder (E.g. data\movies)

How to get the base filepath?
- System.getProperty("user.dir") gives you the base file path, then append accordingly
- E.g. String filepath = System.getProperty("user.dir") + \\\data\\\init\\\ ;

This will create the string for the filepath to the init folder. 
(Use double backslash)

----------------------
