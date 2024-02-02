package algorithmStudy;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> pokemonList = new HashMap<>();
        String[] pokemon = new String[N];

        for(int i = 0, j = 1 ; i < N ; i++, j++) {
            pokemon[i] = br.readLine();
            pokemonList.put(pokemon[i], j);
        }

        for(int i = 0 ; i < M ; i++) {
            String searchPokemon = br.readLine();
            if(pokemonList.containsKey(searchPokemon)) {
                System.out.println(pokemonList.get(searchPokemon));
            } else {
                System.out.println(pokemon[Integer.parseInt(searchPokemon) - 1]);
            }
        }
    }
}