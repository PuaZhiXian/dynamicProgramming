public class No1524 {
    public static void main(String[] args) {
        No1524 obj = new No1524();
//        System.out.println(obj.numOfSubarrays(new int[]{1, 3, 5}));
//        System.out.println(obj.numOfSubarrays(new int[]{100, 100, 99, 99}));
//        System.out.println(obj.numOfSubarrays(new int[]{1, 2, 1, 2, 3, 2}));


        String n = "SELECT acct.bank_account_id,\n" +
                "       acct.account_no,\n" +
                "       acct.bank_account_no,\n" +
                "       acct.bank_account_name,\n" +
                "       acct.iban,\n" +
                "       acct.status,\n" +
                "       acct.created_date,\n" +
                "       sub.bank_sub_account_no,\n" +
                "       sub.currency,\n" +
                "       sub.available_balance             AS current_balance,\n" +
                "       viban.master_bank_account_id,\n" +
                "       indiv.first_name,\n" +
                "       indiv.middle_name,\n" +
                "       indiv.last_name,\n" +
                "       indiv.date_of_birth,\n" +
                "       indiv.nationality,\n" +
                "       indiv.nationality2,\n" +
                "       indiv.country_of_residence,\n" +
                "       corp.ENTITY_LEGAL_NAME            as corp_entity_legal_name,\n" +
                "       corp.business_registration_number as corp_business_registration_number,\n" +
                "       corp.COMPANY_TYPE                 as corp_COMPANY_TYPE,\n" +
                "       corp.DATE_OF_INCORPORATION        as corp_DATE_OF_INCORPORATION,\n" +
                "       corp.TAX_ID                       as corp_TAX_ID,\n" +
                "       corp.PLACE_OF_INCORPORATION       as corp_PLACE_OF_INCORPORATION,\n" +
                "       corp.NATURE_OF_BUSINESS           as corp_NATURE_OF_BUSINESS,\n" +
                "       corp.FIRST_NAME1                  as corp_FIRST_NAME1,\n" +
                "       corp.LAST_NAME1                   as corp_LAST_NAME1,\n" +
                "       corp.ROLE1                        as corp_ROLE1,\n" +
                "       corp.DOB1                         as corp_DOB1,\n" +
                "       corp.NATIONALITY1                 as corp_NATIONALITY1,\n" +
                "       corp.COUNTRY_OF_RESIDENCE1        as corp_COUNTRY_OF_RESIDENCE1,\n" +
                "       corp.FIRST_NAME2                  as corp_FIRST_NAME2,\n" +
                "       corp.LAST_NAME2                   as corp_LAST_NAME2,\n" +
                "       corp.ROLE2                        as corp_ROLE2,\n" +
                "       corp.DOB2                         as corp_DOB2,\n" +
                "       corp.NATIONALITY2                 as corp_NATIONALITY2,\n" +
                "       corp.COUNTRY_OF_RESIDENCE2        as corp_COUNTRY_OF_RESIDENCE2\n" +
                "FROM ((((bank_account acct\n" +
                "    JOIN bank_account_viban_mapping viban ON (((viban.viban_bank_account_id)::text = (acct.bank_account_id)::text)))\n" +
                "    LEFT JOIN bank_sub_account sub ON (((sub.bank_account_id)::text = (acct.bank_account_id)::text)))\n" +
                "    LEFT JOIN viban_end_user usr ON (((usr.bank_account_id)::text = (viban.viban_bank_account_id)::text)))\n" +
                "         LEFT JOIN viban_end_user_individual indiv\n" +
                "                   ON (((indiv.viban_end_user_id)::text = (usr.viban_end_user_id)::text))\n" +
                "         LEFT JOIN viban_end_user_corporate corp\n" +
                "                   ON (((corp.viban_end_user_id)::text = (usr.viban_end_user_id)::text)));";

        System.out.println(n.toLowerCase());

    }

    public int numOfSubarrays(int[] arr) {
        int ans = 0;
        int cum = 0;
        int cntOdd = 0;
        int cntEven = 0;
        for (int i = 0; i < arr.length; i++) {
            cum += arr[i];
            if (cum % 2 == 0) {
                ans = (ans + cntOdd) % 1000_000_007;
                cntEven++;
            } else {
                ans = (ans + cntEven + 1) % 1000_000_007;
                cntOdd++;
            }
        }
        return ans;
    }
}
