package tutorials.days30;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * palindrome을 스택과 큐를 이용해 풀기
 * https://www.hackerrank.com/challenges/30-queues-stacks/problem
 *
 * @author gwon
 * @history
 *          2021. 2. 7. initial creation
 */
public class Day18QueuesAndStacks {
	Stack<Character> stack = new Stack<>();
	List<Character> queue = new ArrayList<>();

	public void pushCharacter(char c) {
		stack.add(c);
	}

	public char popCharacter() {
		return stack.pop();
	}

	public void enqueueCharacter(char c) {
		queue.add(c);
	}

	public char dequeueCharacter() {
		return queue.remove(0);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();

		// Convert input String to an array of characters:
		char[] s = input.toCharArray();

		// Create a Solution object:
		Day18QueuesAndStacks p = new Day18QueuesAndStacks();

		// Enqueue/Push all chars to their respective data structures:
		for (char c : s) {
			p.pushCharacter(c);
			p.enqueueCharacter(c);
		}

		// Pop/Dequeue the chars at the head of both data structures and compare them:
		boolean isPalindrome = true;
		for (int i = 0; i < s.length / 2; i++) {
			if (p.popCharacter() != p.dequeueCharacter()) {
				isPalindrome = false;
				break;
			}
		}

		// Finally, print whether string s is palindrome or not.
		System.out.println("The word, " + input + ", is "
		        + ((!isPalindrome) ? "not a palindrome." : "a palindrome."));
	}
}
