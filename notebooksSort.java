import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class notebooksSort {
    public static void main(String[] args) {
        List<Notebook> notebooks = new ArrayList<>();
        notebooks.add(new Notebook(40000, 16));
        notebooks.add(new Notebook(60000, 32));
        notebooks.add(new Notebook(20000, 8));
        notebooks.add(new Notebook(50000, 16));
        notebooks.add(new Notebook(25000, 8));

        // по цене используя priceComparator

        Comparator<Notebook> PriceComparator = new priceComparator();
        Collections.sort(notebooks, PriceComparator);
        for (Notebook notebook : notebooks) {
            notebook.printNotebook();
        }

        // по значению ram

        Collections.sort(notebooks, Comparator.comparingInt(Notebook::getRam));
        for (Notebook notebook : notebooks) {
            notebook.printNotebook();
        }

        // по памяти потом по цене

        Collections.sort(notebooks, Comparator.comparingInt(Notebook::getRam)
                .thenComparingDouble(Notebook::getPrice));
        for (Notebook notebook : notebooks) {
            notebook.printNotebook();
        }

    }

    public static class Notebook {
        private double price;
        private int ram;

        public Notebook(double price, int ram) {
            this.price = price;
            this.ram = ram;
        }

        public double getPrice() {
            return price;
        }

        public int getRam() {
            return ram;
        }

        public void printNotebook() {
            System.out.println("Notebook{" +
                    "price=" + price +
                    ", ram=" + ram +
                    '}');
        }
    }

    public static class priceComparator implements Comparator<Notebook> {

        @Override
        public int compare(Notebook item1, Notebook item2) {
            return (int) (item1.getPrice() - item2.getPrice());
        }
    }

}