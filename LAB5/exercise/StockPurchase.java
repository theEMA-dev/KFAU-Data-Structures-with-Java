package LAB5.exercise;

public class StockPurchase {
  private String symbol;
  private int shares;
  private double purchasePrice;
  private double currentPrice;

  public StockPurchase(String symbol, int shares, double purchasePrice, double currentPrice) {
    this.symbol = symbol;
    this.shares = shares;
    this.purchasePrice = purchasePrice;
    this.currentPrice = currentPrice;
    System.out.println("Purchased " + shares + " shares of " + symbol + " at " + purchasePrice + " each");
  }

  public int getShares() {
    return shares;
  }
  public void setShares(int shares) {
    this.shares = shares;
  }
  public double getPurchasePrice() {
    return purchasePrice;
  }
  public double getCurrentPrice() {
    return currentPrice;
  }
  public String getSymbol() {
    return symbol;
  }

  public double getCapitalGain() {
    return shares * (currentPrice - purchasePrice);
  }
}
