class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for (String email : emails) {
            String processedEmail = processEmail(email);
            if (!set.contains(processedEmail)) set.add(processedEmail);
        }
        return set.size();
    }

    private String processEmail(String email) {
        String[] strArray = email.split("@");
        String localName = strArray[0].replace(".","");
        localName = localName.split("\\+")[0];
        return localName + "@" + strArray[1];
    }
}
