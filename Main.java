/*
 * read text file and insert its content into a binary tree.
 * 
 *  Naima Matahri
 *  04/25/2018
 *  Data Structure / Project 3
 * 
 * Description:
 *       the program implements the binary tree in Java
 *       I created 3 classes to handle the goal of this project
 *       which is creating a binary tree  from a text file , 
 *       implement methods to search for specific words, count their occurence 
 *       find the longest word in the tree, the most repeated words, the root and the deepest leaf of the tree
 *       implements method to find how many words are different in the tree, and how many words appear more than 20 times
 *       
 *       
 *       
 *       For this projects I use classes, public and private methods, variables, objects, for loops, 
 *       if else statements, setters, getters, and read text file , …

 * */


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
	public static BinaryTree biTree = new BinaryTree();

	public static void main(String[] args) {

		try {

			String book = new String(Files.readAllBytes(Paths.get("book.txt")));

			book = book.toLowerCase().replaceAll("\\p{Punct}", "").trim().replaceAll("\\s+", " ");

			String[] words = book.split(" ");

			for (int i = 0; i < words.length; i++) {

				biTree.add(words[i]);

			}

			System.out.println("The book has " + biTree.length() + " words");
			System.out.println("The word 'portrait' appears " + getTheWordsCount("portrait") + " time(s)");
			System.out.println("The word 'persian' appears " + getTheWordsCount("persian") + " time(s)");
			System.out.println("The word 'dorian' appears " + getTheWordsCount("dorian") + " time(s)");
			System.out.println("The word 'experimental' appears " + getTheWordsCount("experimental") + " time(s)");
			System.out.println("The word 'magnetic' appears " + getTheWordsCount("magnetic") + " time(s)");
			System.out.println("The word in the root of the tree is : < " + biTree.root.getData() + " > ");
			System.out.println("Tree is :" + biTree.maxDepth() + " nodes deep");
			System.out.println("There are " + biTree.count() + " different words are there in the book.");
			biTree.deepest();
			System.out.println(biTree.minOccurrence(21).length + " words occur more than 20 times.");
			System.out.println("' " + biTree.mostFrequent() + " '"
					+ " is the word that occurs most frequently. Appears  " + getTheWordsCount("the") + " time(s)");
			System.out.println("The longest word in the book is " + "' " + biTree. longestWord() + " '.");

		} catch (IOException e) {
			System.out.println("error ");
		}
	}

	public static int getTheWordsCount(String word) {
		Node node = biTree.search(word);
		if (node == null) {
			return 0;
		}
		return node.getOccurency();
	}
}
