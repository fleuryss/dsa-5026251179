/**
 * ES234317 - Algorithms and Data Structures
 * Gasal | 2026-2027
 * Coursework   : 04
 * Student ID   : 5026251179
 * Full Name    : Jonathan J. S. Pamunsu
 * Class        : C
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        System.out.println("Problem Test Case 1:");
        Integer [] a = {1, 3, 1, 4, 3, 7, -2, 0, 7, -2, -2, 1};
        ArrayList<Integer> v = new ArrayList<Integer> (Arrays.asList(a));
        System.out.println(twice(v));
        
        
        System.out.println("Problem Test Case 2:");
        String [] fNames ={"Marty", "Stuart", "Jessica", "Amanda", "Meghan", "Hal"};
        String [] lNames ={"Stepp", "Reges", "Miller", "Camp", "Miller", "Perkins"};
        String [] lNamesX ={"Stepp", "Reges", "Muller", "Camp", "Miller", "Perkins"};
        
        TreeMap<String, String> m1 = new TreeMap<String, String>();
        for(int i=0;i<fNames.length;i++){
            m1.put(fNames[i],lNames[i]);
        }
        
        TreeMap<String, String> m2 = new TreeMap<String, String>();
        for(int i=0;i<fNames.length;i++){
            m2.put(fNames[i],lNamesX[i]);
        }
        
        System.out.println(hasDuplicateValue(m1));
        System.out.println(hasDuplicateValue(m2));
        
        System.out.println("Problem Test Case 3:");
        Integer d1 [] = {3, 8, 17, 9, 17, 8, 3};
        Integer d2 [] = {3, 8, 17, 9, 4, 17, 8, 3};
        
        Queue<Integer> q1 = new LinkedList<Integer> (Arrays.asList(d1));
        Queue<Integer> q2 = new LinkedList<Integer> (Arrays.asList(d2));
        
        System.out.println(isPalindrome(q1));
        System.out.println(isPalindrome(q2));
        
        
        
    }
    
    /**
    * Mengembalikan nilai-nilai berbeda yang muncul tepat dua kali dalam list.
    * Untuk setiap nilai, hitung kemunculannya dengan menelusuri seluruh list.
    * Tambahkan nilai ke hasil hanya jika jumlahnya tepat dua.
     */
    public static Set<Integer> twice(List<Integer> l){
        Set<Integer> s = new TreeSet<Integer>();
        for (Integer n : l) {
            int count = 0;
            for (Integer value : l) {
                if (Objects.equals(value, n)) {
                    count++;
                }
            }
            if (count == 2) {
                s.add(n);
            }
        }
        return s;
    }
    
    /**
    * Kembalikan true jika dua kunci berbeda memiliki nilai yang sama.
    * Set menyimpan nilai yang sudah diperiksa, jika penambahan gagal, berarti
    * nilai tersebut sudah ada. Map hanya dibaca sehingga tidak berubah.
     */
    public static boolean  hasDuplicateValue(Map<String,String> m){
        Set<String> values = new HashSet<String>();
        for (String value : m.values()) {
            // Set.add mengembalikan false jika nilai ini sudah ada di dalam set.
            if (!values.add(value)) {
                return true;
            }
        }
        // Tidak ada duplikat; hasil ini juga berlaku untuk map kosong atau satu entri.
        return false;
    }
    
    /**
    * Memeriksa apakah urutan angka dalam antrean sama dari depan maupun belakang.
    * Tumpukan menyimpan urutan antrean secara terbalik. Kedua perulangan memutar
    * antrean sebanyak ukuran awalnya agar urutannya kembali seperti semula.
     */
    public static boolean isPalindrome(Queue<Integer> q){
        int size = q.size();
        Stack<Integer> values = new Stack<Integer>();
        for (int i = 0; i < size; i++) {
            Integer value = q.remove();
            values.push(value);
            // Memasukkan kembali setiap nilai menjaga urutan antrean setelah satu putaran penuh.
            q.add(value);
        }

        boolean palindrome = true;
        for (int i = 0; i < size; i++) {
            Integer front = q.remove();
            // Puncak tumpukan adalah nilai pembanding dari belakang, elemen tengah pada antrean ganjil dilewati.
            if (i < size / 2 && !Objects.equals(front, values.pop())) {
                palindrome = false;
            }
            // Selesaikan satu loop biarpun ada perbedaan agar antrean kembali seperti semula.
            q.add(front);
        }
        return palindrome;
        
    }
    
        
}
