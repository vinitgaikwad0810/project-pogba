package geekForGeeks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by vinitanilgaikwad on 9/26/16.
 */
public class Solution {

    static int minCost(int a, int b, int[][] cost, int m, int n) {


        if (b >= cost[0].length || a >= cost.length)
            return 30000;

        if (m == a && n == b) {
            return cost[a][b];
        }

        int x = minCost(a + 1, b, cost, m, n);
        int y = minCost(a, b + 1, cost, m, n);
        int z = minCost(a + 1, b + 1, cost, m, n);


        int intermediate = Math.min(x + cost[a][b], y + cost[a][b]);
        return Math.min(intermediate, z + cost[a][b]);


    }


    static int cacheMinCost[][];

    static int minCostDP(int a, int b, int[][] cost, int m, int n) {


        if (b >= cost[0].length || a >= cost.length)
            return 30000;

        if (m == a && n == b) {
            return cost[a][b];
        }

        if (cacheMinCost[a][b] != 0) return cacheMinCost[a][b];

        int x = minCost(a + 1, b, cost, m, n);
        int y = minCost(a, b + 1, cost, m, n);
        int z = minCost(a + 1, b + 1, cost, m, n);

        int intermediate = Math.min(x + cost[a][b], y + cost[a][b]);

        return cacheMinCost[a][b] = Math.min(intermediate, z + cost[a][b]);

    }

    static int minCostDPBottonUP(int[][] cost, int m, int n) {
        int minCost = 0;
        int cacheMinCost[][] = new int[cost.length + 1][cost[0].length + 1];

        for (int i = 0; i < cost.length; i++) {

            for (int j = 0; j < cost[i].length; i++) {


                int intermediate = Math.min(cost[i + 1][j], cost[j][i + 1]);
                //TODO    Math.min(cost[i],[j])
            }
        }

        return minCost;
    }


    static int minOperationsRequired(String str1, String str2) {
        int numOfOperations = 0;
        int[][] cache = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {

            for (int j = 1; j <= str2.length(); j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    cache[i][j] = 1 + cache[i - 1][j - 1];
                } else {
                    cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - 1]);
                }

            }
        }
        int lengthOfLongestSequence = cache[str1.length()][str2.length()];
        return Math.max((str1.length() - lengthOfLongestSequence), (str2.length() - lengthOfLongestSequence));
    }

    static void printLeaders(int[] givenArray) {
        int maxSeen = Integer.MIN_VALUE;


        for (int j = givenArray.length - 1; j >= 0; j--) {

            if (maxSeen < givenArray[j]) {
                maxSeen = givenArray[j];
                System.out.print(givenArray[j]);
            }


        }
    }

    public static Boolean isRotation(String arg1, String arg2) {


        for (int i = 0; i < arg1.length(); i++) {
            StringBuilder rotatedArg = new StringBuilder();

            for (int j = 0; j < arg1.length(); j++) {

                rotatedArg.append(arg1.charAt((j + i) % arg1.length()));
            }

            System.out.println(rotatedArg.toString());
            if (rotatedArg.toString().equals(arg2)) {
                return true;
            }
        }
        return false;
    }

    /*
 * Complete the function below.
 */
    static int[] getRecommendedTweets(int[][] followGraph_edges, int[][] likeGraph_edges,
                                      int targetUser, int minLikeThreshold) {

        List<Integer> recommendedTweets = new ArrayList<>();
        List<Integer> followedByTarget = new ArrayList<>();
        for (int i = 0; i < followGraph_edges.length; i++) {
            if (followGraph_edges[i][0] == targetUser) {
                followedByTarget.add(followGraph_edges[i][1]);
            }
        }


        Arrays.sort(likeGraph_edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int likeCount = 0, currentTweet = likeGraph_edges[0][0];
        for (int i = 0; i < likeGraph_edges.length; i++) {

            currentTweet = likeGraph_edges[i][1];
            if ((i + 1) < likeGraph_edges.length && likeGraph_edges[i][1] == likeGraph_edges[i + 1][1]) {

                if (followedByTarget.contains(likeGraph_edges[i][0]))
                    likeCount++;

            } else {

                if (followedByTarget.contains(likeGraph_edges[i][0]))
                    likeCount++;

                if (likeCount >= minLikeThreshold) {
                    recommendedTweets.add(currentTweet);
                }
                likeCount = 0;
            }
        }


        return recommendedTweets.stream().mapToInt(Integer::intValue).toArray();

    }

    static class InputOutputDTO {
        Date currentDate;
        String engagementType;
        String numberOfEngagement;


        public InputOutputDTO(Date currentDate, String engagementType, String numberOfEngagement) {
            this.currentDate = currentDate;
            this.engagementType = engagementType;
            this.numberOfEngagement = numberOfEngagement;
        }
    }

    static void interleave(String arg1, int index1, String arg2, int index2, StringBuilder ans, int ansIndex) {


        if ((arg1.length() + arg2.length()) == ansIndex) {
            System.out.println(ans);
        }

        if (index1 < arg1.length()) {
            ans.setCharAt(ansIndex, arg1.charAt(index1));
            interleave(arg1, index1 + 1, arg2, index2, ans, ansIndex + 1);
        }

        if (index2 < arg2.length()) {
            ans.setCharAt(ansIndex, arg2.charAt(index2));
            interleave(arg1, index1, arg2, index2 + 1, ans, ansIndex + 1);
        }
    }

    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }

    private static void longestPalindromicSubString(String arg1) {


        int cache[][] = new int[arg1.length() + 1][arg1.length() + 1];


        for (int i = 0; i < arg1.length(); i++) {

            for (int j = i; j < arg1.length(); j++) {

            }
        }


    }

    static String[] findPotentialInsiderTraders(String[] datafeed) {


        List<String> output = new ArrayList<>();
        Integer currentStockPrice = Integer.valueOf(datafeed[0].split("\\|")[1]);
        Integer prevStockPrice = Integer.valueOf(datafeed[0].split("\\|")[1]);
        int[] stockPriceVariations = new int[datafeed.length + 1];
        int stockPriceDifference = 0;
        for (int i = 1; i < datafeed.length; i++) {

            String[] partsOfDataFeed = datafeed[i].split("\\|");


            if (partsOfDataFeed.length == 2) {

                prevStockPrice = currentStockPrice;
                currentStockPrice = Integer.parseInt(partsOfDataFeed[1]);
                stockPriceVariations[i] = currentStockPrice - prevStockPrice;

            }

        }


        for (int i = 0; i < stockPriceVariations.length; i--) {

            //  System.out.println(stockPriceVariations[i]);
        }
        int index = 0;

        for (int i = datafeed.length - 1; i >= 0; i--) {

            String[] partsOfDataFeed = datafeed[i].split("\\|");

            if (partsOfDataFeed.length == 2) {

                stockPriceDifference = stockPriceVariations[i];
                index = i;
                continue;
            }

            if (partsOfDataFeed.length == 4) {
                String day = partsOfDataFeed[0];
                String trader = partsOfDataFeed[1];
                String tradeType = partsOfDataFeed[2];
                int amount = tradeType.equals("BUY") ? Integer.parseInt(partsOfDataFeed[3]) : Integer.parseInt(partsOfDataFeed[3]) * -1;

                if (amount * stockPriceDifference >= 3000000 && index >= Integer.valueOf(day)) {
                    output.add(day + "|" + trader);
                    System.out.println(day + "|" + trader);
                }

            } else
                continue;

        }
        output = new ArrayList<>(new HashSet<>(output));
        Collections.sort(output, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer dayO1 = Integer.valueOf(o1.split("\\|")[0]);
                Integer dayO2 = Integer.valueOf(o2.split("\\|")[0]);

                String trader1 = o1.split("\\|")[1];
                String trader2 = o2.split("\\|")[1];
                if (dayO1 != dayO2)
                    return dayO1.compareTo(dayO2);
                else
                    return trader1.compareTo(trader2);
            }
        });


        return output.toArray(new String[0]);
    }


    static String rollingString(String s, String[] operations) {


        char[] lowercaseAlphabets = new char[26];
        int index = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            lowercaseAlphabets[index++] = (char) i;
        }

        StringBuilder resultBuilder = new StringBuilder(s);

        for (int i = 0; i < operations.length; i++) {

            String[] partsOfAOperation = operations[i].split(" ");
            Integer beginIndex = Integer.valueOf(partsOfAOperation[0]);
            Integer endIndex = Integer.valueOf(partsOfAOperation[1]);
            String operationType = partsOfAOperation[2];

            if (operationType.equals("L")) {
                char toReplaceBy;
                for (int j = beginIndex; j <= endIndex; j++) {


                    if (resultBuilder.charAt(j) - 'a' == 0) {
                        toReplaceBy = 'z';
                    } else {
                        int offset = resultBuilder.charAt(j) - 'a';
                        offset--;
                        toReplaceBy = lowercaseAlphabets[offset];
                    }


                    resultBuilder.setCharAt(j, toReplaceBy);
                }
            } else if (operationType.equals("R")) {
                char toReplaceBy;
                for (int j = beginIndex; j <= endIndex; j++) {

                    if (resultBuilder.charAt(j) - 'a' == 25) {
                        toReplaceBy = 'a';
                    } else {
                        int offset = resultBuilder.charAt(j) - 'a';
                        offset++;
                        toReplaceBy = lowercaseAlphabets[offset];
                    }
                    resultBuilder.setCharAt(j, toReplaceBy);
                }


            } else {

                continue;
            }


        }
        return resultBuilder.toString();

    }

    static String canReach(int a, int b, int c, int d) {


        String ans;
        if (a == c && b == d) {
            return "YES";
        } else {
            ans = "NO";
            if (canReach(a + b, b, c, d).equals("YES")) return "YES";
            if (canReach(a, a + b, c, d).equals("YES")) return "NO";

        }


        return null;
    }

    static int goodNodes(int[] points_to) {

        Map<Integer, Set<Integer>> groups = new HashMap<>();
        groups.put(1, new HashSet<Integer>());

        for (int i = 1; i < points_to.length; i++) {
            Set<Integer> group = groups.get(points_to[i]);
            if (group == null) {
                group = new HashSet<>();
                groups.put(points_to[i], group);
            }

            group.add(i);
        }


        boolean detectVariation;
        do {
            detectVariation = false;
            for (Iterator<Integer> i = groups.keySet().iterator(); i.hasNext(); ) {
                int index = i.next();
                if (index == 1) {
                    continue;
                }
                Set<Integer> group = groups.get(index);

                if (points_to[index - 1] == index) {
                    continue;
                }

                Set<Integer> aGroup = groups.get(points_to[index - 1]);
                if (aGroup != null) {
                    for (Integer member : group) {
                        points_to[member] = points_to[index - 1];
                    }

                    aGroup.addAll(group);
                    i.remove();
                    detectVariation = true;
                }

            }
        } while (detectVariation);

        return groups.size() - 1;


    }

    public static int solution(int[] A) {

        int[] sortedIndices = IntStream.range(0, A.length)
                .boxed().sorted((i, j) -> Integer.compare(A[i], A[j]))
                .mapToInt(ele -> ele).toArray();


        int beginIndex = -1, endIndex = -1;

        for (int i = 0; i < sortedIndices.length; i++) {

            if (sortedIndices[i] != i && beginIndex == -1) {
                beginIndex = i;
            }
            if (sortedIndices[i] != i && beginIndex != -1 ) {
                endIndex = i;


            }

        }


        return endIndex -beginIndex+1  ;
    }

    private static void permutations(String prefix, String str, String maximumTime) {
        int n = str.length();
        if (n == 0) {
            if (Integer.valueOf(str) < 2400 && Integer.valueOf(str) > Integer.valueOf(maximumTime)) {

                maximumTime = str;

            }
        } else {
            for (int i = 0; i < n; i++)
                permutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), maximumTime);
        }
    }

    public static void main(String[] args) throws Exception {


        //interleave("AB", 0, "CD", 0, new StringBuilder("ABCD"), 0);
        //     permutation("ABCD");

        System.out.println(solution(new int[]{1, 2, 6, 5, 5, 8, 9}));

        //   longestPalindromicSubString("forgeeksskeegfor");
    }


}
