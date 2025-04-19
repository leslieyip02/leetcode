class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split(" ");
            int count = Integer.parseInt(split[0]);

            String[] domains = split[1].split("\\.");
            for (int i = 0; i < domains.length; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(domains[i]);
                for (int j = i + 1; j < domains.length; j++) {
                    sb.append(".");
                    sb.append(domains[j]);
                }
                String domain = sb.toString();
                counts.put(domain, counts.getOrDefault(domain, 0) + count);
            }
        }

        List<String> visits = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            visits.add(String.format("%d %s", entry.getValue(), entry.getKey()));
        }
        return visits;
    }
}
