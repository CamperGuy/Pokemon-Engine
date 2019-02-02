package Pokemon;

import java.util.HashMap;
import java.util.Iterator;

/**
 * A Class containing a central database of all Pokemons registered
 * Also keeps track of which of these Pokemons have been seen and caught so far
 */
public class Pokedex {
    private static HashMap<Integer, PKMN_Descriptive> database = new HashMap<>();

    private HashMap<Integer, Boolean> seenDB;
    private HashMap<Integer, Boolean> caughtDB;

    /**
     * Constructor initialising the save-game specific DBs
     */
    public Pokedex(){
        seenDB = new HashMap<>();
        caughtDB = new HashMap<>();
    }

    /**
     * @return Returns the amount of Pokemons that have been registered so far
     */
    public static int getSize(){
        return database.size();
    }

    /**
     * Returns the Pokedex ID of a certain Pokmeon
     * @param pkmn The Pokemon who's ID is to be found
     * @return The Pokedex ID for said Pokemon
     */
    public static int getID(PKMN_Descriptive pkmn){
        Iterator it = database.entrySet().iterator();
        int number = 0;
        while(it.hasNext()){
            number++;
            if(database.get(number).equals(pkmn)){
                return number;
            }
        }
        System.out.println("When calling Pokedex.getID("+ pkmn.toString() + " the Pokemon has not been found and may need to be added first");
        return number;
    }

    /**
     * Returns a Pokemon object based on the ID given
     * @param id The Pokedex ID of a Pokemon
     * @return That Pokemon
     */
    public static PKMN_Descriptive getPKMN(int id){
        if (database.containsKey(id)){
            return database.get(id);
        }
        System.out.println("Pokedex.getPKMN("+ id +")\nThe pokemon could not be found!\n    - Null has been returned");
        return null;
    }

    /**
     * Adds a Pokemon to the Pokedex
     * @param pkmn The Pokemon that will be added to the Pokedex
     */
    public static void addPokemon(PKMN_Descriptive pkmn){
        if (!database.containsValue(pkmn))
            database.put(getSize(), pkmn);
        else
            System.out.println("Pokedex.addPokemon(" + pkmn.toString() +")\nThe Pokemon is already registered on ID " + getID(pkmn));

    }

    /**
     * Removes a certain Pokemon from the Pokedex
     * @param pkmn The Pokemon that is to be deleted
     */
    public static void removePokemon(PKMN_Descriptive pkmn){
        if (database.containsValue(pkmn))
            database.remove(getID(pkmn));
        else
            System.out.println("Pokedex.removePokemon(" + pkmn.toString() +")\nThe Pokemon was not registered");

    }

    /**
     * Removes a certain Pokemon from the Pokedex
     * @param id The ID of the Pokemon that is to be deleted
     */
    public static void removePokemon(int id){
        if (database.containsKey(id))
            database.remove(id);
        else
            System.out.println("Pokedex.removePokemon("+ id +")\nThe ID is not associated with a Pokemon!");
    }
}
