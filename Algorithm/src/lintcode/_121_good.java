package lintcode;

import java.util.*;

/**
 * @Description: 121. 单词接龙 II
 * @Author: lc
 * @Date: Created in 2018/3/15
 */
public class _121_good
{
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict)
    {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if (dict.size() == 0)
        {
            return result;
        }
        HashMap<String, Integer> mapping = new HashMap<>(); // 每个单词到end单词的距离
        dict.add(start);
        dict.add(end);
        bfs(end, start, dict, mapping);
        //System.out.println(mapping.get("hot"));
        List<String> currArray = new ArrayList<>();
        currArray.add(start);
        dfs(start, end, dict, mapping, result, currArray);
        return result;
    }

    private void bfs(String start, String end, Set<String> dict, HashMap<String, Integer> mapping)
    {
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int distance = 0;
        mapping.put(start, distance);
        boolean notDone = true;
        while (notDone && !queue.isEmpty())
        {
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                String word = queue.poll();
                //System.out.println(word);
                if (word.equals(end))
                {
                    notDone = false;
                }
                List<String> nextWords = nextWord(word, dict);
                //System.out.println(nextWords.size());
                for (String str : nextWords)
                {
                    if (!mapping.containsKey(str))
                    {
                        mapping.put(str, distance);
                        queue.offer(str);
                    }
                }
            }
        }
        return;
    }

    private void dfs(String start, String end, Set<String> dict, HashMap<String, Integer> mapping, List<List<String>> result, List<String> currArray)
    {
        //System.out.println(start);
        if (start.equals(end))
        {
            result.add(new ArrayList<>(currArray));
            return;
        }
        int distance = mapping.get(start);
        List<String> nextWords = nextWord(start, dict);

        int i = 0;
        while (i < nextWords.size())
        {
            if (!mapping.containsKey(nextWords.get(i)) || mapping.get(nextWords.get(i)) != distance - 1)
            {
                nextWords.remove(i);
            } else
            {
                i++;
            }
        }
        //System.out.println(nextWords.size());
        for (String next : nextWords)
        {
            currArray.add(next);
            dfs(next, end, dict, mapping, result, currArray);
            currArray.remove(currArray.size() - 1);
        }
        return;
    }

    private List<String> nextWord(String word, Set<String> dict)
    {
        List<String> nextWords = new ArrayList<>();
        for (int i = 0; i < word.length(); i++)
        {
            for (int j = 'a'; j < 'z'; j++)
            {
                String newWord = word.substring(0, i) + (char) j + word.substring(i + 1, word.length());
                if (dict.contains(newWord) && !newWord.equals(word))
                {
                    nextWords.add(newWord);
                }
            }
        }
        return nextWords;
    }
}
