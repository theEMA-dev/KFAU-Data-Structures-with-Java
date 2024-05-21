package LAB5.exercise;

public class StockLedger {
  private QueueInterface<StockPurchase> ledger;

  public StockLedger() {
    this.ledger = new LinkedQueue<>();
  }

  public void addPurchase(StockPurchase purchase) {
    ledger.enqueue(purchase);
  }

  public StockPurchase sellShares(int shares) {
    if (ledger.isEmpty()) {
      throw new EmptyQueueException();
    }

    StockPurchase firstPurchase = ledger.getFront();
    if (firstPurchase.getShares() > shares) {
      firstPurchase.setShares(firstPurchase.getShares() - shares);
      return new StockPurchase(firstPurchase.getSymbol(), shares, firstPurchase.getPurchasePrice(), firstPurchase.getCurrentPrice());
    } else {
      return ledger.dequeue();
    }
  }

  public double getTotalCapitalGain() {
    double totalGain = 0.0;
    while (!ledger.isEmpty()) {
      StockPurchase purchase = ledger.dequeue();
      totalGain += purchase.getCapitalGain();
    }
    return totalGain;
  }
}
