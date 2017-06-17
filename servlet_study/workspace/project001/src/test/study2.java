package test;

public class study2 {
  public static void main(String[] args) {
    // 하나은행01 이라는 계좌번호가 있다는 가정하에 진행
    Account acc01 = new Account(1000,"하나은행01");
    //형석이가 1000원 짜리 하나은행01 계좌를 갖는다.
    Member m01 = new Member("오형석",acc01);
    
    System.out.println(m01);
  }
}

class Member{
  
  private String name; //이름
  private Account account; //account
  Member() {}
  Member(String name, Account account) {
    this.name = name; 
    this.account= account;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Account getAccount() {
    return account;
  }
  public void setAccount(Account account) {
    this.account = account;
  }
  @Override
  public String toString() {
    return "Member [이름: " + name + account.toString() + "]";
  }
}

class Account{
  private int money; //잔액
  private String accNumber; //계좌 번호
  Account() {}
  Account(int money, String accNumber) {
    this.money = money;
    this.accNumber = accNumber;
  }
  public int getMoney() {
    return money;
  }
  public void setMoney(int money) {
    this.money = money;
  }
  public String getAccNumber() {
    return accNumber;
  }
  public void setAccNumber(String accNumber) {
    this.accNumber = accNumber;
  }
  public String toString() {
    return " 은행 (잔액: " + money + ", 계좌번호: " + accNumber + ")";
  }
}