class BasicCreditCard {
    enum CreditCardType {Free, Rewards, Platinum};
    int creditCardNumber;
    CreditCardType creditCardType;
    float spendingLimit;
    float interestRate;
    float currentBalance;
    static int nextCreditNum = 0;

    public BasicCreditCard(int cardNum, String cardType, float spending, float interest, float current) {
        creditCardNumber = cardNum;
        creditCardType = CreditCardType.valueOf(cardType);
        spendingLimit = spending;
        interestRate = interest;
        currentBalance = current;
        if (cardNum >= nextCreditNum) {
            nextCreditNum = cardNum + 1;
        }
    }

    public BasicCreditCard(String cardType, float spending) {
        this(nextCreditNum, cardType, spending, 0, 0);
        nextCreditNum++;
    }

    public String toString() {
        String s = String.format("CARD NUMBER: %s, CARD TYPE: %s, SPENDING LIMIT: %s, INTEREST RATE: %s, " +
                "CURRENT BALANCE: %s", creditCardNumber, creditCardType, spendingLimit, interestRate, currentBalance);
        return s;
    }

    public int getId() {
        return creditCardNumber;
    }

    public String getViewString() {
        return "";
    }

    public static int getNextAvailableCreditCardNum() {
        return nextCreditNum;
    }

    public float getAmountOwed() {
        return currentBalance;
    }
}
