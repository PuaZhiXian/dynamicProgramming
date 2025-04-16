public class No1813 {
    public static void main(String[] args) {
        No1813 obj = new No1813();
//        System.out.println(obj.areSentencesSimilar("My name is Haley", "My Haley"));//true
//        System.out.println(obj.areSentencesSimilar("of", "A lot of words"));//false
//        System.out.println(obj.areSentencesSimilar("Eating right now", "Eating"));//true
//        System.out.println(obj.areSentencesSimilar("Eating right now", "now"));//true
//        System.out.println(obj.areSentencesSimilar("Luky", "Lucccky"));//false
        System.out.println(obj.areSentencesSimilar("a", "a aa a"));//true

    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] split1 = sentence1.split(" ");
        String[] split2 = sentence2.split(" ");
        String[] strA;
        String[] strX;

        if (split1.length < split2.length) {
            strA = split1;
            strX = split2;
        } else {
            strA = split2;
            strX = split1;
        }

        //A____A
        if (strA[0].equals(strX[0]) && strA[strA.length - 1].equals(strX[strX.length - 1])) {
            return checkA__A(strA, strX);
        }
        //A____
        if (strA[0].equals(strX[0]) && !strA[strA.length - 1].equals(strX[strX.length - 1])) {
            return checkA__(strA, strX);
        }
        //____A
        if (!strA[0].equals(strX[0]) && strA[strA.length - 1].equals(strX[strX.length - 1])) {
            return check__A(strA, strX);
        }
        return false;
    }

    private boolean checkA__A(String[] a, String[] x) {
//        System.out.println(obj.areSentencesSimilar("Luky", "Lucccky"));//false
        //START
        int startLen = 0;
        for (int i = 0; i < x.length; i++) {
            if (a[i].equals(x[i])) {
                a[i] = "@";
                x[i] = "#";
                startLen++;
                if (startLen == a.length) {
                    return true;
                }
            } else {
                break;
            }
        }


        //END
        int pointer = a.length - 1;
        int endLen = 0;
        for (int i = x.length - 1; i >= 0; i--) {
            if (a[pointer].equals(x[i])) {
                a[pointer] = "@";
                x[i] = "#";
                endLen++;
                pointer--;
            } else {
                break;
            }
        }

//        System.out.printf("startLen : %s, endLend : %s\n", startLen, endLen);
        return startLen + endLen == a.length;
    }

    private boolean checkA__(String[] a, String[] x) {
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(x[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean check__A(String[] a, String[] x) {
        int pointer = x.length - 1;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i].equals(x[pointer])) {
                pointer--;
            } else {
                return false;
            }
        }
        return true;
    }
}
