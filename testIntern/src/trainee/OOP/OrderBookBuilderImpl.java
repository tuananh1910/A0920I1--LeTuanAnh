package trainee.OOP;

public class OrderBookBuilderImpl implements IOrderBuilder{
    private OrderBook.OrderBookEconomy orderBookEconomy;
    private OrderBook.OrderBookPsychological orderBookPsychological;


    @Override
    public IOrderBuilder orderBookEconomy(OrderBook.OrderBookEconomy orderBookEconomy) {
        this.orderBookEconomy = orderBookEconomy;
        return this;
    }

    @Override
    public IOrderBuilder orderBookPsychological(OrderBook.OrderBookPsychological orderBookPsychological) {
        this.orderBookPsychological = orderBookPsychological;
        return this;
    }

    @Override
    public OrderBook build() {
        return new OrderBook(orderBookEconomy, orderBookPsychological);
    }
}
