import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class No679 {
    public static void main(String[] args) {
        No679 o = new No679();
        System.out.println(o.judgePoint24(new int[]{8, 3, 8, 3}));
    }

    double[] cards = new double[4];

    public boolean judgePoint24(int[] cards) {
        for (int i = 0; i < cards.length; i++) {
            this.cards[i] = cards[i];
        }
        List<List<Double>> permutation = permute(this.cards);

        for (List<Double> arr : permutation) {
            for (int i = 0; i < arr.size(); i++) {
                this.cards[i] = arr.get(i);
            }
            if (have24(rec(0, 1))) {
                return true;
            }
            if (have24(rec(0, 2))) {
                return true;
            }
            if (have24(rec(0, 3))) {
                return true;
            }
        }

        return false;
    }

    double factor = Math.pow(10, 10);

    private boolean have24(Set<Double> set) {
        for (Double d : set) {
            double rounded = Math.ceil(d * factor) / factor;
            if (rounded == 24.0) {
                return true;
            }
        }
        return false;
    }

    private Set<Double> rec(int index, int lenForOperation) {
        if (index == 3) {
            Set<Double> set = new HashSet<>();
            set.add(cards[index]);
            return set;
        }
        Set<Double> set = new HashSet<>();

        if (lenForOperation == 1) {
            Set<Double> nextOpsSet = new HashSet<>();
            if (index == 0) {
                nextOpsSet.addAll(rec(index + 1, 1));
                nextOpsSet.addAll(rec(index + 1, 2));
            } else {
                nextOpsSet.addAll(rec(index + 1, 1));
            }
            for (Double num : nextOpsSet) {
                set.add(cards[index] + num);
                set.add(cards[index] - num);
                set.add(cards[index] * num);
                set.add(cards[index] / num);
            }
        } else if (lenForOperation == 2) {
            Set<Double> nextOpsSet = new HashSet<>();
            if (index == 0) {
                nextOpsSet.addAll(rec(index + 2, 1));
            } else {
                nextOpsSet.addAll(rec(index + 2, 1));
            }
            Set<Double> curOpsSet = new HashSet<>();
            curOpsSet.add(cards[index] + cards[index + 1]);
            curOpsSet.add(cards[index] - cards[index + 1]);
            curOpsSet.add(cards[index] * cards[index + 1]);
            curOpsSet.add(cards[index] / cards[index + 1]);

            for (Double num : nextOpsSet) {
                for (Double curNum : curOpsSet) {
                    set.add(num + curNum);
                    set.add(num - curNum);
                    set.add(num * curNum);
                    set.add(num / curNum);
                }
            }
        } else if (lenForOperation == 3) {
            Set<Double> nextOpsSet = rec(index + 3, lenForOperation);
            Set<Double> curOpsSet = new HashSet<>();
            curOpsSet.add((cards[index] + cards[index + 1]) + cards[index + 2]);
            curOpsSet.add((cards[index] + cards[index + 1]) - cards[index + 2]);
            curOpsSet.add((cards[index] + cards[index + 1]) * cards[index + 2]);
            curOpsSet.add((cards[index] + cards[index + 1]) / cards[index + 2]);

            curOpsSet.add((cards[index] - cards[index + 1]) + cards[index + 2]);
            curOpsSet.add((cards[index] - cards[index + 1]) - cards[index + 2]);
            curOpsSet.add((cards[index] - cards[index + 1]) * cards[index + 2]);
            curOpsSet.add((cards[index] - cards[index + 1]) / cards[index + 2]);

            curOpsSet.add((cards[index] * cards[index + 1]) + cards[index + 2]);
            curOpsSet.add((cards[index] * cards[index + 1]) - cards[index + 2]);
            curOpsSet.add((cards[index] * cards[index + 1]) * cards[index + 2]);
            curOpsSet.add((cards[index] * cards[index + 1]) / cards[index + 2]);

            curOpsSet.add((cards[index] - cards[index + 1]) + cards[index + 2]);
            curOpsSet.add((cards[index] - cards[index + 1]) - cards[index + 2]);
            curOpsSet.add((cards[index] - cards[index + 1]) * cards[index + 2]);
            curOpsSet.add((cards[index] - cards[index + 1]) / cards[index + 2]);

            // A $ (B $ C)
            curOpsSet.add(cards[index] + (cards[index + 1] + cards[index + 2]));
            curOpsSet.add(cards[index] + (cards[index + 1] - cards[index + 2]));
            curOpsSet.add(cards[index] + (cards[index + 1] * cards[index + 2]));
            curOpsSet.add(cards[index] + (cards[index + 1] / cards[index + 2]));

            curOpsSet.add(cards[index] - (cards[index + 1] + cards[index + 2]));
            curOpsSet.add(cards[index] - (cards[index + 1] - cards[index + 2]));
            curOpsSet.add(cards[index] - (cards[index + 1] * cards[index + 2]));
            curOpsSet.add(cards[index] - (cards[index + 1] / cards[index + 2]));

            curOpsSet.add(cards[index] * (cards[index + 1] + cards[index + 2]));
            curOpsSet.add(cards[index] * (cards[index + 1] - cards[index + 2]));
            curOpsSet.add(cards[index] * (cards[index + 1] * cards[index + 2]));
            curOpsSet.add(cards[index] * (cards[index + 1] / cards[index + 2]));

            curOpsSet.add(cards[index] - (cards[index + 1] + cards[index + 2]));
            curOpsSet.add(cards[index] - (cards[index + 1] - cards[index + 2]));
            curOpsSet.add(cards[index] - (cards[index + 1] * cards[index + 2]));
            curOpsSet.add(cards[index] - (cards[index + 1] / cards[index + 2]));

            for (Double curOpsNum : curOpsSet) {
                for (Double nextOpsNum : nextOpsSet) {
                    set.add(curOpsNum + nextOpsNum);
                    set.add(curOpsNum - nextOpsNum);
                    set.add(curOpsNum * nextOpsNum);
                    set.add(curOpsNum / nextOpsNum);
                }
            }
        }

        return set;

    }

    static void permutations(List<List<Double>> res,
                             double[] arr, int idx) {
        if (idx == arr.length) {
            res.add(convertArrayToList(arr));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);
            permutations(res, arr, idx + 1);
            swap(arr, idx, i);
        }
    }

    static List<List<Double>> permute(double[] arr) {
        List<List<Double>> res = new ArrayList<>();
        permutations(res, arr, 0);
        return res;
    }

    static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static List<Double> convertArrayToList(double[] arr) {
        List<Double> list = new ArrayList<>();
        for (double num : arr) {
            list.add(num);
        }
        return list;
    }

}
