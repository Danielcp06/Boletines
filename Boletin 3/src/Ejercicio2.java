public class Ejercicio2 {
    public static void main(String[] args) {
        int[] nums = {1,-34,5,2,-9,4,-6};
        int contador = 0;
        for (int i = 0; i < nums.length; i++) {
          if (nums[i] < 0){
              contador++;
          }
        }
        System.out.println("Hay " + contador + " numeros negativos");
    }
}
