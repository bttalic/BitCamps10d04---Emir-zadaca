import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;

public class CollectionUtilsTest {
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		names.add("test");
		names.add(null);
		names.add("another test");

		// before cleanup
		System.out.println("Before cleanup: " + names);
		int removed = CollectionUtil.removeNulls(names);
		System.out.println("Removed: " + removed);
		System.out.println("After cleanup: " + names);

		Collection<String> prefixedRaw = CollectionUtil.withPrefixRaw(names,
				"te");
		System.out.println("Prefixed raw: " + prefixedRaw);
		Collection<String> prefixed = CollectionUtil.withPrefix(names, "te");
		System.out.println("Prefixed: " + prefixed);

		names.add(null);
		System.out.println("\nAdded null: " + names);
		// need to cast
		Collection<String> cleanedNames = (Collection<String>) CollectionUtil
				.toCleanedRaw(names);
		System.out.println("Cleaned raw: " + cleanedNames);

		System.out.println("\nStill have null: " + names);
		cleanedNames = CollectionUtil.toCleaned(names);
		System.out.println("Cleaned parameterized: " + cleanedNames);

		// check duplicates
		System.out.println("\nHas duplicates names: "
				+ CollectionUtil.hasDuplicates(names));
		System.out.println("Has duplicates cleaned: "
				+ CollectionUtil.hasDuplicates(cleanedNames));

		names.add(null);
		System.out.println("\nDuplicate null: " + names);
		System.out.println("Has duplicates names: "
				+ CollectionUtil.hasDuplicates(names));

		cleanedNames.add("test");
		System.out.println("\nDuplicate test: " + cleanedNames);
		System.out.println("Has duplicates cleaned: "
				+ CollectionUtil.hasDuplicates(cleanedNames));

		System.out.println("\nFirst duplicate value: "
				+ CollectionUtil.firstDuplicateValue(cleanedNames));

		System.out.println("Get max: ");
		ArrayList<Integer> intList = new ArrayList<Integer>();
		Random rand = new Random();
		for (int i = 0; i < 5; i++)
			intList.add(rand.nextInt(10));
		System.out.println("Elements: ");
		CollectionUtil.printToConsole(intList);
		int max = CollectionUtil.getMax(intList);
		System.out.println("Max element: " + max);
		
		LinkedList<Character> charList = new LinkedList<Character>();
		for (int i = 0; i < 5; i++)
			charList.add((char) (65+rand.nextInt(27)));
		System.out.println("Elements: ");
		CollectionUtil.printToConsole(charList);
		char maxChar = CollectionUtil.getMax(charList);
		System.out.println("Max element: " + maxChar);
	}
}