public class No860 {
    public static void main(String[] args) {
        No860 obj = new No860();
    }

    public boolean lemonadeChange(int[] bills) {
        int[] cash = new int[2];

        for (int i = 0; i < bills.length; i++) {
            switch (bills[i]) {
                case 5:
                    cash[0]++;
                    break;
                case 10:
                    cash[0]--;
                    if (cash[0] < 0) {
                        return false;
                    }
                    cash[1]++;
                    break;
                case 20:
                    if (cash[1] > 0) {
                        cash[1]--;
                        cash[0]--;
                    } else {
                        cash[0] -= 3;
                    }

                    if (cash[0] < 0) {
                        return false;
                    }
                    break;
            }

        }

        return true;
    }
}
