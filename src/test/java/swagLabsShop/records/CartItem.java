package swagLabsShop.records;

import org.jetbrains.annotations.NotNull;

public record CartItem(String title, String description, double price) implements Comparable<CartItem> {
    @Override
    public int compareTo(@NotNull CartItem o) {
        return Double.compare(price, o.price());
    }
}
