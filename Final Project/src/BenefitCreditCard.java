class BenefitCreditCard extends BasicCreditCard {
    float annualFee;
    float rewardPercent;

    public BenefitCreditCard(int cardNum, String cardType, float spending, float interest,
                             float current, float annual, float reward) {
        super(cardNum, cardType, spending, interest, current);
        annualFee = annual;
        rewardPercent = reward;
    }

    public BenefitCreditCard(String cardType, float spending, float annual, float reward) {
        super(cardType, spending);
        annualFee = annual;
        rewardPercent = reward;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format(", ANNUAL FEE: %s, REWARD PERCENTAGE: %s", annualFee, rewardPercent));
        return sb.toString();
    }
}
