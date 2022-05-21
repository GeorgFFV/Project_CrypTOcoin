package model.vo;

import java.util.List;

public class WalletVO {
  private Double amount; //valor em dólares
  private List<CoinVO> lista; //lista das moedas

  public WalletVO(){
    this.amount = null;
  }

  public Double getAmount(){
    return this.amount;
  }

  public void setAmount(Double value){
    this.amount = value;
  }
}
