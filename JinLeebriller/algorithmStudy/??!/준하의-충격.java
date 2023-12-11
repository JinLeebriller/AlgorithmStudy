package algorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String existingId = br.readLine();
            String shockingOfJoona = existingId + "??!";

            System.out.println(shockingOfJoona);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}