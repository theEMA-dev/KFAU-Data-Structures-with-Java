package LAB5.exercise;

public class StockLedgerDemo {
  public static void main(String[] args) {
    StockLedger ledger = new StockLedger();
    ledger.addPurchase(new StockPurchase("AAPL", 100, 150.0, 170.0));
    ledger.addPurchase(new StockPurchase("GOOG", 50, 1000.0, 1200.0));

    System.out.println("Total capital gain: " + ledger.getTotalCapitalGain());

    StockPurchase soldShares = ledger.sellShares(50);
    System.out.println("Sold shares: " + soldShares.getShares() + " Capital gain: " + soldShares.getCapitalGain());

    System.out.println("Total capital gain after selling: " + ledger.getTotalCapitalGain());
  }
}