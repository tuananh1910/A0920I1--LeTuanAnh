package trainee.OOP;

public class OrderBook {
    private final OrderBookEconomy  orderBookEconomy;
    private final OrderBookPsychological  orderBookPsychological;

    public OrderBook(
            OrderBookEconomy orderBookEconomy,
            OrderBookPsychological orderBookPsychological) {
        this.orderBookEconomy = orderBookEconomy;
        this.orderBookPsychological = orderBookPsychological;
    }

    public OrderBookPsychological getOrderBookPsychological() {
        return orderBookPsychological;
    }

    public OrderBookEconomy getOrderBookEconomy() {
        return orderBookEconomy;
    }

    public enum OrderBookEconomy {
            ECONOMY_1, ECONOMY_2
        }

        public enum OrderBookPsychological {
            PSYCHOLOGICAL_1, PSYCHOLOGICAL_2
        }
    }
