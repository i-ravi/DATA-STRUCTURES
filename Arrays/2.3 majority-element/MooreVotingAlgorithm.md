## Moore's Voting Algorithm

Initialize two variables: count and candidate. Set count to 0 and candidate to an arbitrary value.
Iterate through the array nums:
- If count is 0, assign the current element as the new candidate and increment count by 1.
- If the current element is the same as the candidate, increment count by 1.
- If the current element is different from the candidate, decrement count by 1.

After the iteration, the candidate variable will hold the majority element.

Explanation:

Let's consider two cases:
- If the majority element has more than n/2 occurrences:
  The algorithm will ensure that the count remains positive for the majority element throughout the traversal, guaranteeing that it will be selected as the final candidate.
- If the majority element has exactly n/2 occurrences:
  In this case, there will be an equal number of occurrences for the majority element and the remaining elements combined.
However, the majority element will still be selected as the final candidate because it will always have a lead over any other element.

In both cases, the algorithm will correctly identify the majority element.

The time complexity of the Moore's Voting Algorithm is O(n) since it traverses the array once.

This approach is efficient compared to sorting as it requires only a single pass through the array and does not change the original order of the elements.
