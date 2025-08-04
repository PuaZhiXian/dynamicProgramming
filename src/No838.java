public class No838 {

    public static void main(String[] args) {
        No838 obj = new No838();
        System.out.println(obj.pushDominoes("R.R.L"));
        System.out.println("RRR.L");
        //LL.RR.LLRRLL..

    }

    public String pushDominoes(String dominoes) {
        int cnt = 1;
        String str = "";

        char[] chars = dominoes.toCharArray();
        char[] ans = new char[chars.length];
        int index = 0;

        char prev = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (prev == chars[i]) {
                if (prev == 'R') {
                    if (cnt >= 1) {
                        multiple('R', cnt, index, ans);
                        index += cnt;
                    }
                    cnt = 1;
                } else {
                    cnt++;
                }
                continue;
            }

            if (prev == '.') {
                if (chars[i] == 'L') {
                    multiple('L', cnt, index, ans);
                    index += cnt;
//                    str = str + multiple('L', cnt);
                    cnt = 1;
                    prev = 'L';
                } else if (chars[i] == 'R') {
//                    str = str + multiple('.', cnt);
                    multiple('.', cnt, index, ans);
                    index += cnt;
                    cnt = 1;
                    prev = 'R';
                }
            } else if (prev == 'L') {
                if (chars[i] == '.') {
                    multiple('L', cnt, index, ans);
                    index += cnt;
                    cnt = 1;
                    prev = '.';
                } else if (chars[i] == 'R') {
                    multiple('L', cnt, index, ans);
                    index += cnt;
                    cnt = 1;
                    prev = 'R';
                }
            } else if (prev == 'R') {
                if (chars[i] == '.') {
                    cnt++;
                } else if (chars[i] == 'L') {
                    cnt++;
                    multiple('R', cnt / 2, index, ans);
                    index += (cnt / 2);
                    if (cnt % 2 != 0) {
                        multiple('.', 1, index, ans);
                        index += 1;
                    }
                    multiple('L', cnt / 2, index, ans);
                    index += (cnt / 2);
                    prev = 'L';
                    cnt = 0;
                }
            }
        }

        multiple(prev, cnt, index, ans);


        return new String(ans);
    }

    private void multiple(char str, int cnt, int index, char[] ans) {
        for (int i = index; i < index + cnt; i++) {
            ans[i] = str;
        }
    }
}
