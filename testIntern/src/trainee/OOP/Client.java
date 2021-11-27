package trainee.OOP;

public class Client {
    public static void main(String[] args) {
        OrderBook order = new OrderBookBuilderImpl()
                .orderBookEconomy(OrderBook.OrderBookEconomy.ECONOMY_1)
                .orderBookPsychological(OrderBook.OrderBookPsychological.PSYCHOLOGICAL_1)
                .build();
        System.out.println(order);
    }
}
