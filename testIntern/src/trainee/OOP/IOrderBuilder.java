package trainee.OOP;

public interface IOrderBuilder {
    IOrderBuilder orderBookEconomy(OrderBook.OrderBookEconomy orderBookEconomy);
    IOrderBuilder orderBookPsychological(OrderBook.OrderBookPsychological orderBookPsychological);
    OrderBook build();
}
