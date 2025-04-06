class Solution {
    class Team implements Comparable<Team> {
        char letter;
        int[] counts = new int[26];

        Team(char letter) {
            this.letter = letter;
        }

        @Override
        public int compareTo(Team other) {
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] != other.counts[i]) {
                    return other.counts[i] - counts[i];
                }
            }
            return (int) letter - (int) other.letter;
        }
    }

    public String rankTeams(String[] votes) {
        Map<Character, Team> teams = new HashMap<>();
        for (int i = 0; i < votes[0].length(); i++) {
            teams.put(votes[0].charAt(i), new Team(votes[0].charAt(i)));
        }

        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                Team team = teams.get(vote.charAt(i));
                team.counts[i]++;
            }
        }

        List<Team> sorted = new ArrayList<>(teams.values());
        Collections.sort(sorted);
        StringBuilder sb = new StringBuilder();
        for (Team team : sorted) {
            sb.append(team.letter);
        }
        return sb.toString();
    }
}
