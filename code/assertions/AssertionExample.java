public class AssertionExample {
    public double avgMarks(double[] marks){
         assert marks.length > 0 : "Array is empty!";
         double avg = 0;
         for (int i =0 ; i < marks.length; i++){
              assert marks[i]>=0 && marks[i]<=10 : "Mark not valid!";
              avg +=marks[i];
         }
         return avg/marks.length;
     }
  
    public static void main(String args[]){
         AssertionExample e = new AssertionExample();
         double [] marks = {10, 5, 11, 3, 2, 7.5};
         System.out.println(e.avgMarks(marks));
         marks = new double[0];
         System.out.println(e.avgMarks(marks));
     }
  }