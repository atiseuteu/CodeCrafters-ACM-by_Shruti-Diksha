package social_media;

import java.util.*;

public class CommunityManager {
    private static Scanner sc = new Scanner(System.in);
    static List<Community> recommendedCommunities = new ArrayList<>();

    public static void addCommunity() {
        System.out.println("Enter community name:");
        String name = sc.nextLine();
        System.out.println("Enter community interests (comma-separated):");
        String[] interestsArray = sc.nextLine().split(",");
        Set<String> interests = new HashSet<>(Arrays.asList(interestsArray));
        recommendedCommunities.add(new Community(name, interests));
        System.out.println("Community added successfully.");
    }

    public static void matchAndRecommendCommunity(Set<String> userInterests) {
        List<Community> matchedCommunities = new ArrayList<>();

        for (Community community : recommendedCommunities) {
            Set<String> commonInterests = new HashSet<>(community.getInterests());
            commonInterests.retainAll(userInterests); // Get the common interests between user and community
            if (!commonInterests.isEmpty()) {
                matchedCommunities.add(community);
            }
        }

        if (matchedCommunities.isEmpty()) {
            System.out.println("No matching communities found.");
        } else {
            System.out.println("Matching communities:");
            for (Community community : matchedCommunities) {
                System.out.println("Community Name: " + community.getName());
                System.out.println("Common Interests: " + community.getInterests());
            }
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding Communities:");
        CommunityManager.addCommunity();
        CommunityManager.addCommunity();

        // Simulate a new teacher joining with interests
        System.out.println("Enter teacher's interests (comma-separated):");
        String[] userInterestsArray = scanner.nextLine().split(",");
        Set<String> userInterests = new HashSet<>(Arrays.asList(userInterestsArray));

        System.out.println("Recommended communities for the new teacher:");
        matchAndRecommendCommunity(userInterests);
    }
}

