package algorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String existingId = br.readLine();
            String shockingOfJoona = existingId + "??!";

            bw.write(shockingOfJoona);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
